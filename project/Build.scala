import sbt._
import Keys._
import play.Project._
import com.ketalo.play.plugins.emberjs.EmberJsKeys

object ApplicationBuild extends Build with EmberJsKeys {

  val appName         = "ember-test"
  val appVersion      = "1.0-SNAPSHOT"

  val appDependencies = Seq(
    // Add your project dependencies here,
    javaCore,
    javaJdbc,
    javaEbean,
    cache
  )

  val main = play.Project(appName, appVersion, appDependencies).settings(
    emberJsVersion := "1.7.0"      
  )

}
