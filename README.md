# geo-ip service
This project takes an ip as input and return json as output containing location of the ip. To get the
region from ip,  maxmind database is used. 

Sample request 
```
GET http://localhost/location?ip=8.8.8.8
```
Sample response
```
{
    "continent": "EU",
    "ipAddress": "89.27.159.35",
    "countryCode": "DE"
}
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

## To run with docker
```
mvn clean install 
docker build -t geoip-service .
docker run -p 8080:8080 geoip-service 
```

## Hit browser 
For local maven
```
http://localhost:8080/
http://localhost:8080/location?ip=89.27.159.35
``` 

For docker
```
http://0.0.0.0:8080/
http://0.0.0.0:8080/location?ip=89.27.159.35
```
