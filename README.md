# Engineering Excellence Case


## Test-Driven Utveckling (TDD)

För att bygga applikationen:

```
mvn clean install
```

För att köra unit test som gynnar applikationen:

```
mvn test
```

Om något är fel, builden kommer att misslyckas.


För att köra applikationen:

```
mvn spring-boot:run
```


## Feature Toggle

Om man vill köra 'Feature X' på FeatureXController, måste man sätta false på följande:

```
feature.toggle.featurex=false
```

[application.properties](src/main/resources/application.properties)


## CI/CD Pipeline



## Automatiserad säkeret och kvalitet


## Enkel Observability - log och health check



Medan att sätta true/false på följande:

```
management.endpoints.web.exposure.include=health,info 
```
Spring ska publicera ett Rest Endpoint där man kan check:a att applikationen är up.

Exempel med *curl*:


```
$ curl -s http://127.0.0.1:8080/actuator/health     
{"status":"UP"}
```
