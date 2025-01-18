# Native image with maria-db

The principal objective is set reflection and resources configs in generate native image. Note the files META-INF/native-image/[reflect, resource]-config.json contains needed config to build project.

## Metadata

- Reflections ([reflect-config.json](src/main/resources/META-INF/native-image/reflect-config.json))
- Resources ([resource-config.json](src/main/resources/META-INF/native-image/resource-config.json))


## Commands

### Native image default with resource files and path class
This code contains `Version.class.getClassLoader().getResourceAsStream("mariadb.properties");`
````
native-image -Ob -cp target/classes:/Users/fabio.henrique/.m2/repository/org/mariadb/jdbc/mariadb-java-client/3.0.6/mariadb-java-client-3.0.6.jar --initialize-at-build-time=org.mariadb.jdbc.MariaDbDataSource:org.mariadb.jdbc.util.Version:org.mariadb.jdbc.util.VersionFactory -H:ReflectionConfigurationFiles=META-INF/native-image/reflect-config.json -H:ResourceConfigurationFiles=META-INF/native-image/resource-config.json br.com.fabex.MariaDB
````
Or (implicit get config on META-INF/native-image/)
```
native-image -Ob -cp target/classes:/Users/fabio.henrique/.m2/repository/org/mariadb/jdbc/mariadb-java-client/3.0.6/mariadb-java-client-3.0.6.jar br.com.fabex.MariaDB
```
Or (using regex `-H:IncludeResources`)
````

````

### Native image with Build Report
```
native-image -H:+BuildReport -H:+BuildReportSamplerFlamegraph -cp target/classes:/Users/fabio.henrique/.m2/repository/org/mariadb/jdbc/mariadb-java-client/3.0.6/mariadb-java-client-3.0.6.jar br.com.fabex.MariaDB
```
