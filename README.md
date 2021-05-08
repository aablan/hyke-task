#About The project:
In this project, an endpoint is consumed that provides access to json data which is mobile dataset information.
A service is implemented that consumes the provided endpoint using rest template, map the fetched data to into a list of DTO objects that are stores
in memory, and then provides a basic filtration based on some criteria, and the result of that is exposed to the client via a rest endpoint

# Project Components & Design:
- Api definition for the endpoint "/mobile/search", that determines what is the request form and what is provided as a response (DTO data).
- Rest controller that provide implementation of the Api definition.
- Service layer which basically consume data from the endpoint ("https://run.mocky.io/v3/b755c334-9627-4b09-84f2-548cb1918184"), store the result in memory, and perform filtration which is passed from client.
- Filters are implemented in accordance to the open-closed principle which will enable users of this design to simply add new types of filters by extending a specific behavior not by changing the existing behavior.

# Technical Details:
- This project is built using Maven.
- Java version 11 is used.
- Spring boot version 2.3.
- Integration tests using junit5 & rest assured.
- Feign Clients to provide the definition.

# How to Run:
- Pre-requisites:<br />
 1- This project uses Maven, version 3.6.3 or later is required.<br />
 2- This project uses Java, version 11+ is required.

- Run the project:<br />
 1- Check out the code from this Git repository.<br />
 2- Navigate to the project directory where it is checked out.<br />
 3- Run the command "mvn package" -> a jar named "hyke-task-1.0.jar" will be generated to the target directory.<br/>
 4- Navigate to the jar directory and run the command "java -jar hyke-task-1.0.jar". <br/>
 5- Now the jar should be up and running, check the endpoint "http://localhost:8080/v1/mobile/search".

# Miscellaneous:
- Integration test cases are provided for the major functionalities.
- No Unit tests as the provided integration test covers end to end which should be good enough for the scope of the assignment.
- Only basic important filters are implemented, it should be enough to show the concepts, and new ones can easily be added on need.
- Documentation is provided for the high level components, for the rest, the code should be pretty much self-explanatory.
- Date field (announceDate) values are not in consistent proper date formats, that's why it can't be properly parsed to date objects.
