# Native image with reflection class

The principal objective is set reflection configs in generate native image. Note the file META-INF/native-image/reflect-config.json contains needed config to build project.

## Metadata

- Reflections ([reflect-config.json](src/main/resources/META-INF/native-image/reflect-config.json))

## Commands

### Compile native image

```` commandline
native-image -Ob -cp target/classes br.com.fabex.ReflectionClass 
````

### Compile native image with Build Report

```
native-image -H:+BuildReport -H:+BuildReportSamplerFlamegraph -cp target/classes br.com.fabex.ReflectionClass
```

### Run

``` commandline
./br.com.fabex.reflectionclass br.com.fabex.utils.FileUtil isFileExist /fabio/test.txt
```

``` commandline
./br.com.fabex.reflectionclass br.com.fabex.utils.StringUtil stringToInt 200
```

``` commandline
./br.com.fabex.reflectionclass br.com.fabex.utils.StringUtil stringToLong 78
```

``` commandline
./br.com.fabex.reflectionclass br.com.fabex.utils.StringUtil\$InnerStringUtil byPass 78
```

## Warns

> It's possible register a method to never be executed by config property `queriedMethods` (reflection-config.json):
> ```
>[
>  {
>    "name": "br.com.fabex.utils.StringUtil",
>    "methods": [
>      {
>        "name": "stringToLong",
>        "parameterTypes": [
>          "java.lang.String"
>        ]
>      }
>    ],
>    "queriedMethods" : [
>      { "name" : "neverExecuteStringToLong" }
>    ]
>  }
>]
>```
> It can be call, but will result in a runtime error:
> ```~/Workspace-fabex/java-with-native-image/reflection-class/target git:[master]
> ./br.com.fabex.reflectionclass br.com.fabex.utils.StringUtil neverExecuteStringToLong 78
> Exception in thread "main" org.graalvm.nativeimage.MissingReflectionRegistrationError: The program tried to reflectively invoke method public static long br.com.fabex.utils.StringUtil.neverExecuteStringToLong(java.lang.String) without it being registered for runtime reflection. Add public static long br.com.fabex.utils.StringUtil.neverExecuteStringToLong(java.lang.String) to the reflection metadata to solve this problem. See https://www.graalvm.org/latest/reference-manual/native-image/metadata/#reflection for help.
> at org.graalvm.nativeimage.builder/com.oracle.svm.core.reflect.MissingReflectionRegistrationUtils.forQueriedOnlyExecutable(MissingReflectionRegistrationUtils.java:72)
> at java.base@21/java.lang.reflect.Method.acquireMethodAccessor(Method.java:77)
> at java.base@21/java.lang.reflect.Method.invoke(Method.java:577)
> at br.com.fabex.ReflectionClass.main(ReflectionClass.java:19)
> at java.base@21/java.lang.invoke.LambdaForm$DMH/sa346b79c.invokeStaticInit(LambdaForm$DMH)
> ```