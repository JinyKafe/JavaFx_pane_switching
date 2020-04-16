# Pane switching in JavaFx
The application consist of the 
![screenshot](doc/img/screenshot.png)
## Solution 1: Java 8 without Spring Boot
* You can find this solutin [under commit](https://github.com/JinyKafe/JavaFx_pane_switching/commit/c22b7ca54e80a0fc8dfdac326db801038890bfe7)
* It was forked from [this public repository](https://gist.github.com/jewelsea/6460130)
* It runs with Java 8 only, with has embedded JavaFX libraries. If you wanted to use any higher Java version (withoug JavaFx libraries), you will have to provide JavaFX into your libraries and also export the javafx packages in module-info.java.

## Solution 2: CI with JavaFX Weaver and Spring Boot
* in the latest master HEAD I have rewrote the application with use of [JavaFX-Weaver framework](https://github.com/rgielen/javafx-weaver) which enables to run Java, JavaFx and Spring Boot together (all latest version, which means that latest Java without JavaFX is possible. All the dependencies and libraries are provided by maven pom.xml)
