Web Services Sample [![Build Status](https://travis-ci.org/WASdev/sample.jaxws.web.svg?branch=master)](https://travis-ci.org/WASdev/sample.jaxws.web)
==============

The WebSphere Application Server Liberty Profile `jaxws-2.2` feature, included in the extended content for the Liberty Profile, supports the Java API for XML-Based Web Services. With this feature, it is easy to develop web services applications on the Liberty profile.

This sample contains a server definition that includes the `jaxws-2.2` feature. It also contains a demo application which demonstrates a number of JAX-WS features supported by the Liberty profile.

This sample can be installed onto runtime versions 8.5.5.0 and later.
Instructions

The ServletJDBCEngine sample contains a server definition for basic servlet support, and illustrates a simple datasource definition using an included configuration file. It uses Apache Derby (an open source relational database). Also included is a servlet which gets a connection to the database using the defined datasource, creates a table, inserts some data, retrieves the data, and prints the data out to the browser.

Once the server is running, the application will be available under [http://localhost:9131/jaxws](http://localhost:9131/jaxws).

## Running in Eclipse with Maven

1. Clone this project and import into Eclipse as an 'Existing Maven Project'.
2. Right-click the project and select **Run As > Run on Server**.
3. You should see the following message in the console: `Application JAXWSWebSample started in XX.XX seconds.`

## Running with Maven

This project can be built with [Apache Maven](http://maven.apache.org/). The project uses [Liberty Maven Plug-in] to automatically download and install Liberty with Java EE 7 Full Platform runtime from the Maven Central. Liberty Maven Plug-in is also used to create, configure, and run the application on the Liberty server.

Use the following steps to run the application with Maven:

1. Execute full Maven build. This will cause Liberty Maven Plug-in to download and install Liberty profile server.
    ```bash
    $ mvn clean install
    ```
2. To run the server with the Servlet sample execute:
    ```bash
    $ mvn liberty:run-server
    ```
In your browser, enter the URL for the application: [http://localhost:9131/jaxws](http://localhost:9131/jaxws/) (where port 9131 assumes the httpEndpoint provided in the sample server.xml has not been modified).
There are 7 scenarios for different JAX-WS features in the left. You can navigate each scenario to experience these features.

## Gradle

### Running in Eclipse with Gradle
1. Go to *Help > Eclipse Marketplace > Install Buildship Gradle Integration 2.0*
2. Clone this project and import into Eclipse as an 'Existing Gradle Project'.
3. Go to *Window > Show View > Other > Gradle Executions & Gradle Tasks*
4. Go to Gradle Tasks view and run `clean` in build folder, then `build` in build folder, then `libertyStart` in liberty folder.
5. You should see the following in the console: `Application JAXWSWebSample started in XX.XX seconds.`

### Running with Gradle command-line
This project can also be built and run with [Gradle](https://gradle.org/). 
The provided `build.gradle` file applies the [Liberty Gradle Plug-in][] and is configured to automatically download and install the Liberty Java EE Web Profile 7 runtime from [Maven Central][]. 
The Liberty Gradle Plug-in has built-in tasks that can be used to create, configure, and run the application on the Liberty server.

Use the following steps to run the application with the Gradle wrapper (Windows machines use `gradlew.bat`):

1. Execute the full Gradle build. The Liberty Gradle Plug-in will download and install the Liberty server.
    ```bash
    $ ./gradlew clean build
    ```
    
2. To start the server with the Servlet sample execute:
    ```bash
    $ ./gradlew libertyStart
    ```
    
    Alternatively, execute the run command:
    ```bash
    $ ./gradlew libertyRun --no-daemon
    ```
    
Once the server has started, the application will be available under [http://localhost:9080/ferret][].

3. To stop the server, execute:
    ```bash
    $ ./gradlew libertyStop
    ```  

Note, if Gradle is properly installed, Gradle commands can be executed directly using `gradle` and wouldn't require `gradlew`.

Please refer to the [Liberty Gradle Plug-in][] repository for documentation about using the Liberty Gradle Plug-in.

The application can be reached at [http://localhost:9131/jaxws](http://localhost:9131/jaxws/).

# Notice

© Copyright IBM Corporation 2017.

# License

```text
Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
````

[Liberty Maven Plug-in]: https://github.com/WASdev/ci.maven
[Liberty Gradle Plug-in]: https://github.com/WASdev/ci.gradle
