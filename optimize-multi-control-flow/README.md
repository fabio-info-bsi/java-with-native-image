# Compile Native Image examples

## Commands

### Native image default
````
native-image -cp classes -o app-default br.com.fabex.Main
````
### Native image with PGO Instrument
````
native-image -cp classes -o app-pgo-instrument --pgo-instrument br.com.fabex.Main
````

### Getting profile (coverage any possibility) and generate profile .iprof
````
./app-pgo-instrument -XX:ProfilesDumpFile=app-run-pgo-profile-option-1.iprof 100000 1
````

### Native image with profile (.iprof)
```
native-image -cp classes -o app-pgo --pgo=app-run-pgo-profile-option-1.iprof br.com.fabex.Main
```

### Native image with Build Report
```
native-image -H:+BuildReport -H:+BuildReportSamplerFlamegraph -cp classes -o app-default-with-report  br.com.fabex.Main
```