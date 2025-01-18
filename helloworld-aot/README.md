# Compile AOT
> Use Java 11 version for to test AOT compilation

## Commands

### Compile javac bytecode
```
javac -d target src/main/java/br/com/fabex/aot/Main.java
```
### Compile AOT
> Should be into the `/target` dir
```
jaotc --output app.so Main.class
```

### Run

``` commandline
java -XX:+UnlockExperimentalVMOptions -XX:-UseCompressedOops -XX:AOTLibrary=./app.so Main
```