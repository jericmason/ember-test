package controllers;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import play.Routes;
import play.libs.F.Function0;
import play.libs.F.Promise;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.index;

public class Application extends Controller {

    public static Result index() {
        return ok(index.render());
    }
    
    public Promise<Result> getPhotos() {
		return Promise.promise(new Function0<Result>(){
			@Override
			public Result apply() throws Throwable {
				List<Photo> photos = new ArrayList<Photo>();
				photos.add(new Photo("Tomster 7", "http://emberjs.com/images/about/ember-productivity-sm.png"));
				photos.add(new Photo("Eiffel Tower 4", "http://emberjs.com/images/about/ember-structure-sm.png"));
				photos.add(new Photo("Eiffel Tower 5", "http://emberjs.com/images/about/ember-structure-sm.png"));
				return ok(Json.toJson(photos));
			}
		});
    }
    
    private static class Photo implements Serializable {
    	public String title;
    	public String url;
    	public Photo(String title, String url) {
			this.title = title;
			this.url = url;
    	}
    }

	public Result javascriptRoutes() {
		response().setContentType("text/javascript");
		return ok(Routes.javascriptRouter("jsRoutes", controllers.routes.javascript.Application.getPhotos()));
	}
}
