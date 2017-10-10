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

This project can be built with [Apache Maven](http://maven.apache.org/). The project uses [Liberty Maven Plug-in](https://github.com/WASdev/ci.maven) to automatically download and install Liberty with Java EE7 Full Platform runtime from the Maven Central. Liberty Maven Plug-in is also used to create, configure, and run the application on the Liberty server. 

Use the following steps to run the application with Maven:

1. Execute full Maven build. This will cause Liberty Maven Plug-in to download and install Liberty profile server.

    $ mvn clean install


2. To run the server with the Servlet sample execute:

    $ mvn liberty:run-server


In your browser, enter the URL for the application: [http://localhost:9131/jaxws](http://localhost:9131/jaxws/) (where port 9131 assumes the httpEndpoint provided in the sample server.xml has not been modified).
There are 7 scenarios for different JAX-WS features in the left. You can navigate each scenario to experience these features.

## Gradle

The sample can be built using [Gradle](https://gradle.org/). In the directory where you cloned the repository issue the following command to build and run the project.

    $ gradle build

To start the application use the command:

    $ gradle libertyStart

To stop the application use the command:

    $ gradle libertyStop

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
