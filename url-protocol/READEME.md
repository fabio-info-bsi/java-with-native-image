# Native image with url protocol

The principal objective is set support to Url Protocol [http & https] in generate native image using args: `--enable-url-protocols=http,https` or `--enable-http --enable-https`.
## Metadata
- Properties ([native-image.properties](src/main/resources/META-INF/native-image/native-image.properties))

## Commands

### Native image (Default)

``` commandline
native-image  -Ob -cp target/classes br.com.fabex.UrlProtocol
```
### Run

``` commandline
./br.com.fabex.urlprotocol
```