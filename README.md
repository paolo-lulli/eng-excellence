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

### Sonarqube scan

Medan den följande istruktioner i [Github Action](.github/workflows/maven.yml)

```
      - name: Sonarqube Scan
        env:
            SONAR_TOKEN: ${{ secrets.SONARQUBE_TOKEN }}
        run:  mvn -DskipTests -B verify org.sonarsource.scanner.maven:sonar-maven-plugin:sonar -Dsonar.projectKey=paolo-lulli_eng-excellence -Dsonar.organization=paolo-lulli -Dsonar.login=${{ secrets.SONARQUBE_TOKEN }} -Dsonar.host.url=https://sonarcloud.io
```
kan man få ett SonarQube scan av hela projekt. 
Just nu kommenterade dem för att undvika konflikter med sonarcloud.io där redan samma projekt hade jag skapat för att se om det går med fri versionen.


## Enkel Observability - log och health check


Medan att sätta true/false på följande:

```
management.endpoints.web.exposure.include=health,info 
```
Spring ska publicera ett Rest Endpoint där man ha koll att applikationen är upp.

Exempel med *curl*:

```
$ curl -s http://127.0.0.1:8080/actuator/health     
{"status":"UP"}
```
