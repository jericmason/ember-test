App = Ember.Application.create();

App.SubView = Ember.View.extend({
  templateName: "sub/sub"
});

/* App.PhotosView = Ember.View.extend({
	template: Ember.TEMPLATES.photos
}); */

App.Router.map(function() {
	this.resource('photos', { path: '/photos' })
});

App.PhotosRoute = Ember.Route.extend({
	model: function() {
		console.log("Get data from route");
		return jsRoutes.controllers.Application.getPhotos().ajax({ dataType : "json" });
		/* console.log(jsRoutes.controllers.Application.getPhotos().getJSON())
		console.log('Has routes: ' + jsRoutes.controllers.Application);
		return [{
			title: "Tomster",
			url: "http://emberjs.com/images/about/ember-productivity-sm.png"
		}, {
			title: "Eiffel Tower",
			url: "http://emberjs.com/images/about/ember-structure-sm.png"
		}]; */
	}
});

/* App.Router = Ember.Router.extend({
  root: Ember.Route.extend({
    index: Ember.Route.extend({
      route: '/',
      connectOutlets: function(router) {
        router.get('applicationController').connectOutlet('sub')
      }
    })
  })
}); */