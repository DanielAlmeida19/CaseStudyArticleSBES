# MSCondominium

Represents the microservice that controls the condominium network, the registration of its respective units, residents, and public areas of the condominium. The class diagram is shown below.

![Error loading image](../images/MSCondominium.png)

The microservice represented by the class diagram provides the following endpoints:

- General and specific search, insertion, update, and removal for <b>condominiums</b>;
- General and specific search, insertion, update, and removal for <b>units</b>;
- General and specific search, insertion, update, and removal for <b>rentable areas</b>;
- General and specific search for <b>residents</b>;

Residents do not have insertion, update, or removal endpoints because their data is replicated from another microservice (MSResident), mainly indicated by the white background of the class, denoting that it is not part of this microservice.

You can see the documentation of the endpoints with Swagger on this URL (with containers running):
    
    http://localhost:8080/swagger-ui/index.html

Implementation details are as follows:
- OpenJDK 21
- SpringFramework 3.4.4
- PostgreSQL 17.4