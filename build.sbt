import com.typesafe.startscript.StartScriptPlugin

organization := "com.github.tomtung"

name := "latex2unicode.demo"

version := "0.1-SNAPSHOT"

scalaVersion := "2.9.1"

seq(webSettings :_*)

libraryDependencies ++= Seq(
  "org.scalatra" %% "scalatra" % "2.0.1",
  "org.scalatra" %% "scalatra-scalate" % "2.0.1",
  "org.eclipse.jetty" % "jetty-webapp" % "7.4.5.v20110725" % "container",
  "org.eclipse.jetty" % "jetty-webapp" % "7.4.5.v20110725",
  "javax.servlet" % "servlet-api" % "2.5" % "provided",
  "com.github.tomtung" % "latex2unicode" % "0.1-SNAPSHOT"
)

resolvers += "Sonatype OSS Snapshots" at "http://oss.sonatype.org/content/repositories/snapshots/"

resolvers += "com.github.tomtung Snapshot" at "http://tomtung.github.com/maven-repo/snapshots"

seq(StartScriptPlugin.startScriptForClassesSettings: _*)

