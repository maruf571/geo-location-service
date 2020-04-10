# geo-location-service
As an application developer, often we need to know the client/user location for various reason like

- Embargo compliance
- Enforcing digital rights
- Fraud detection
- Internet security
- Language localization
- Personalizing web content
- Price localization
- Routing internet traffic
- Targeting advertising
- Web analytics

IP is the easiest solution to track user location(except for vpn users). Maxmind has a free database to get the location based on the ip.


Sample request 
```
GET http://localhost/location?ip=89.27.159.35
```
Sample response
```
{
    "continent": "EU",
    "ipAddress": "89.27.159.35",
    "countryCode": "DE"
}
```

## Tech spec
- java 1.8 
- spring boot 2.*
- maven

####  To run on the local env
```
$ mvn spring-boot:run
```

## To run with docker
```
mvn clean install 
docker build -t geoip-service .
docker run -p 8080:8080 geoip-service 
```


## How to run test 
On this project, there are  unit and integration test. Integration test is time consuming test. 
It is possible to run unit and integration alone. Please follow the instruction bellow.
 Maven lifecycle may help to understand the test and verify phase.   

- Run unit test only
```
$ mvn test
```

- Run  integration test only
```
$ mvn integration-test -DskipTests
```

- Run both unit & integration test
```
$ mvn verify 
```


## Hit the api  

```
http://localhost:8080/
http://localhost:8080/location?ip=89.27.159.35
``` 

