# Native image with proxy class

The principal objective is set proxy configs in generate native image. Note the file META-INF/native-image/proxy-config.json contains needed config to build project.

## Metadata

- Proxies ([proxy-config.json](src/main/resources/META-INF/native-image/proxy-config.json))

## Commands

### Native image (Default)
``` commandline
native-image -Ob -cp target/classes br.com.fabex.runtime.AppRuntime
```
### Run

``` commandline
./br.com.fabex.runtime.appruntime br.com.fabex.runtime.BusinessServiceImpl br.com.fabex.runtime.RuntimeInvocationHandler findAll
```