# MSReservation

Microservice for managing reservations of rentable areas, following the logic that a resident can rent a common rentable area for a specific purpose at a predetermined cost per area. This microservice is used to validate the case study, as it requires information contained in <b>rentable area</b> (MSCondominium) and <b>resident</b> (MSResident), and still needs a logical transformation of the objects to retrieve only the information necessary for the business rules of the application. The class diagram is shown below:

![Error loading image](../images/MSReservation.png)

Note the difference between the resident and rentable area entities in the reservation microservice compared to the respective source data microservices. The notation that indicates it comes from another microservice is the white background of the class.

The microservice represented by the class diagram provides the following endpoints:

- General and specific search, insertion, update, and removal for <b>reservations</b>;
- General and specific search for <b>residents</b>;
- General and specific search for <b>rentable areas</b>;

Residents do not have insertion, update, or removal endpoints because their data is replicated from another microservice (MSResident).

Rentable areas do not have insertion, update, or removal endpoints because their data is replicated from another microservice (MSCondominium)

You can see the documentation of the endpoints with Swagger on this URL (with containers running):
    
    http://localhost:8082/swagger-ui/index.html

Implementation details are as follows:
- OpenJDK 21
- SpringFramework 3.4.4
- MariaDB 11.7.2