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

Om man vill köra 'Feature X' på FeatureXController, måste man sätta true på följande:

```
feature.toggle.featurex=false
```

För att bevisa att 'Feature X' är aktiv, man kan göra så:

```
curl http://127.0.0.1:8080/api/v1/featurex/data
```

-   Feature X svarar: "Actual Data"
-   Feature X disabled svarar: "The Feature is currently not active" 


[application.properties](src/main/resources/application.properties)


## CI/CD Pipeline (YAML med Github Actions)

I [Github Action](.github/workflows/maven.yml) finns beskrivelse för workflow som bygger applikationen, kör test och
andra steg som, till exempel *Sonarqube* scan.

Här vi kunde logga in till en artifactory och spara *.jar filen för applikationen.
Andra steg kan det vara, till exempel, att skapa ett Docker image för applikationen,
eller göra Deploy av dessa till Produktion, och så vidare.

Det är ett bra verktyg som vi kan använda för att skapa custom pipeliner för alla processer som behövs.
Just nu är det bara ett MVP som bygger applikationen, kör test och Sonarqube.


## Automatiserad säkeret och kvalitet

### Sonarqube 

Medan den följande istruktioner i [Github Action](.github/workflows/maven.yml)

```
      - name: Sonarqube Scan
        env:
            SONAR_TOKEN: ${{ secrets.SONARQUBE_TOKEN }}
        run:  mvn -DskipTests -B verify org.sonarsource.scanner.maven:sonar-maven-plugin:sonar -Dsonar.projectKey=paolo-lulli_eng-excellence -Dsonar.organization=paolo-lulli -Dsonar.login=${{ secrets.SONARQUBE_TOKEN }} -Dsonar.host.url=https://sonarcloud.io
```
kan man få ett SonarQube scan av hela projekt. 
Just nu kommenterade dem för att undvika konflikter med sonarcloud.io där redan samma projekt hade jag skapat för att se om det går med fri versionen.

### Alternativer

På samma sätt som Sonarqube är möjlight att göra scan av kod med, [trivy](https://trivy.dev/) till exempel, eller andra verktyg.

## Enkel Observability - loggning och health check


Medan att sätta true/false på följande:

```
management.endpoints.web.exposure.include=health,info 
```
Spring ska publicera ett Rest Endpoint (```/actuator/health```) där man har full koll om applikationen är upp.

Exempel med *curl*:

```
$ curl -s http://127.0.0.1:8080/actuator/health     
{"status":"UP"}
```
