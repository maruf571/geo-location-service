# geo-location-service
[![Quality Gate Status](https://sonarcloud.io/api/project_badges/measure?project=maruf571_geo-location-service&metric=alert_status)](https://sonarcloud.io/summary/new_code?id=maruf571_geo-location-service)
[![Bugs](https://sonarcloud.io/api/project_badges/measure?project=maruf571_geo-location-service&metric=bugs)](https://sonarcloud.io/summary/new_code?id=maruf571_geo-location-service)
[![Code Smells](https://sonarcloud.io/api/project_badges/measure?project=maruf571_geo-location-service&metric=code_smells)](https://sonarcloud.io/summary/new_code?id=maruf571_geo-location-service)


Often we need to know the client/user location for various reason like

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
- java 17 
- spring boot 3.*
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
GET http://localhost:8080/
GET http://localhost:8080/location?ip=89.27.159.35
``` 

