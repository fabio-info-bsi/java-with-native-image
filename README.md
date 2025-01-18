# Build native image java with dynamic features

## Args Native Image (native-image.properties)
Optional. The objective is set any configs for include to the build process.

For
default `META-INF/native-image/(jni-config, reflect-config, proxy-config, resource-config, predefined-classes-config, serialization-config).json`
are then automatically included in the build process (`native-image`). For add custom config (append):

```
-H:ReflectionConfigurationResources=${.}/custom-reflect-config.json
```
## Common commands

### Compile Native Image examples

````
native-image -Ob -cp target/classes:/Users/fabio.henrique/.m2/repository/org/mariadb/jdbc/mariadb-java-client/3.0.6/mariadb-java-client-3.0.6.jar --initialize-at-build-time=org.mariadb.jdbc.MariaDbDataSource:org.mariadb.jdbc.util.Version:org.mariadb.jdbc.util.VersionFactory -H:ReflectionConfigurationFiles=META-INF/native-image/reflect-config.json br.com.fabex.demo.Mariadb
````

### Native imag with `Version.class.getClassLoader().getResourceAsStream("mariadb.properties");`
````
native-image -Ob -cp target/classes:/Users/fabio.henrique/.m2/repository/org/mariadb/jdbc/mariadb-java-client/3.0.6/mariadb-java-client-3.0.6.jar --initialize-at-build-time=org.mariadb.jdbc.MariaDbDataSource:org.mariadb.jdbc.util.Version:org.mariadb.jdbc.util.VersionFactory -H:ReflectionConfigurationFiles=META-INF/native-image/reflect-config.json -H:ResourceConfigurationFiles=META-INF/native-image/resource-config.json br.com.fabex.demo.Mariadb
````

### VM Args to run with Tracing Agent
```
-agentlib:native-image-agent=config-output-dir=META-INF/native-image
```

### Native image with generate SBOM (export)
```
native-image -Ob --enable-sbom=export -cp classes  br.com.fabex.NativeImageWithResource
```
#### or (json)

````
native-image -Ob --enable-sbom -H:BuildOutputJSONFile=app-schema.json -J-XX:MaxRAMPercentage=10.0 -cp classes br.com.fabex.demo.Helloword app
````

### Native image with Report Call Tree (output.txt)
```
native-image -Ob -cp  classes -H:+PrintAnalysisCallTree br.com.fabex.NativeImageWithResource
```
#### Or (output.csv)
```
native-image -Ob -cp  classes -H:+PrintAnalysisCallTree -H:PrintAnalysisCallTreeType=CSV br.com.fabex.NativeImageWithResource
```