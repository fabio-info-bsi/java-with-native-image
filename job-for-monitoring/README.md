# Compile Native Image examples

## Commands

### Native image default
```
native-image -cp target/classes -o app-default br.com.fabex.job.Main
```
### Native image with Monitoring (Java Management Extensions - JMX & VisualVM)
```
native-image -cp target/classes -o app-default br.com.fabex.job.Main --enable-monitoring=jmxserver,jmxclient,jvmstat
```

### Run

``` commandline
./app-default
```