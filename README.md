# Engineering Excellence Case


## Test-Driven Utveckling (TDD)

Om man kör:

```
mvn clean install test
```

det finns unit test som gynnar applikationen. Om något är fel, builden kommer att misslyckas.

## Feature Toggle

Medan att sätta true/false på följande:

```
feature.toggle.featurex=false
```

man kör FeatureXController eller något annat som inte har 'feature X'


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
