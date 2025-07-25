# MSResident

The microservice responsible for managing the condominium residents. The class diagram is shown below:

![Error loading image](../images/MSResident.png)

The microservice represented by the class diagram provides the following endpoints:
- General and specific search, insertion, update, and removal of <b>residents</b>

You can see the documentation of the endpoints with Swagger on this URL (with containers running):
    
    http://localhost:8081/swagger-ui/index.html

Implementation details are as follows:
- OpenJDK 21
- SpringFramework 3.4.4
- MongoDB 8.0.8