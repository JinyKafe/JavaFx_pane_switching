# Pane switching in JavaFx (compared with and without Spring Boot)
The application consist of the 
![screenshot](doc/img/screenshot.png)
## without Spring Boot
* Original souce code was taken from [this GIT repository](https://gist.github.com/jewelsea/6460130) and you can still find it in an [initial commit here](https://github.com/JinyKafe/JavaFx_pane_switching/commit/c22b7ca54e80a0fc8dfdac326db801038890bfe7)
* this original code must be run with Java 8 with embedded JavaFX libraries! If you wanted to use any higher Java version (withoug JavaFx libraries), you will have to provide JavaFX into your libraries and also export the javafx packages in module-info.java.

## with Spring Boot and FXWeaver
* in the latest master HEAD I have rewrote the application with use of [JavaFX-Weaver framework](https://github.com/rgielen/javafx-weaver) which enables to run Java, JavaFx and Spring Boot together (all latest version, which means that latest Java without JavaFX is possible. All the dependencies and libraries are provided by maven pom.xml)


