Foursquare Adapter Service
=============================================
This is a microservice which work as a wrapper ove Foursquare Public API.
The service exposes a REST endpoint /places/{place}, which would give the recommendations
regarding the place that we want to search

#### Jasypt for encrypting the Foursquare API credentials
I have used Jasypt in order to encrypt cliend id and client secret that is required to run the REST call of Foursquare API

Sample command
```
https://api.foursquare.com/v2/venues/explore?near=NYC&client_id=<clientID>&client_secret=<clientSecret>&v=20190217
```

### Build
To build the JAR, execute the following command from the parent directory:

```
mvn clean install spring-boot:repackage
```

#### Run the service
In order to run the service through CMD using java -jar command, please pass following properties through command line:

```
G:\Amit\UK\projects\foursquare-adapter>set spring.profiles.active=DEV

G:\Amit\UK\projects\foursquare-adapter>set jasypt.encryptor.password=<would be shared separately>

G:\Amit\UK\projects\foursquare-adapter>java -jar ./target/foursquare-adapter-1.0-SNAPSHOT-spring-boot.jar

  .   ____          _            __ _ _
 /\\ / ___'_ __ _ _(_)_ __  __ _ \ \ \ \
( ( )\___ | '_ | '_| | '_ \/ _` | \ \ \ \
 \\/  ___)| |_)| | | | | || (_| |  ) ) ) )
  '  |____| .__|_| |_|_| |_\__, | / / / /
 =========|_|==============|___/=/_/_/_/
 :: Spring Boot ::        (v2.1.2.RELEASE)

2019-02-18 09:30:17.897  INFO 8840 --- [           main] com.foursquare.adapter.Application       : Starting Application v1.0-SNAPSHOT on DESKTOP-HKHI1PM with PID 8840 (G:\Amit\UK\projects\foursquare-adapter\target\foursquare-adapter-1.0-SNAPSHOT-spring-boot.jar started by Administrator in G:\Amit\UK\projects\foursquare-adapter)
2019-02-18 09:30:17.907  INFO 8840 --- [           main] com.foursquare.adapter.Application       : The following profiles are active: DEV
```


### Access Swagger Endpoints

##### Swagger UI
You can view the Swagger UI at `http://localhost:8080/swagger-ui.html`.

