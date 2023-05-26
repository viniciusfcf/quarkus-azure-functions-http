# quarkus-azure-functions-http

This project uses Quarkus, the Supersonic Subatomic Java Framework.

If you want to learn more about Quarkus, please visit its website: https://quarkus.io/ .

## Creating a native executable

You can create a native executable using: 
```shell script
./mvnw package -Pnative
```

Or, if you don't have GraalVM installed, you can run the native executable build in a container using: 
```shell script
./mvnw package -Pnative -Dquarkus.native.container-build=true
```

You can then execute your native executable with: `./target/quarkus-azure-functions-http-1.0.0-SNAPSHOT-runner`

If you want to learn more about building native executables, please consult https://quarkus.io/guides/maven-tooling.

## Test using Azure Functions Core Tools (native mode)

``` bash
mvn clean package -Pnative
```

``` bash
cd functions
```

``` bash
func start --custom
```

``` bash
curl localhost:7071/api/funq
```

``` bash
curl localhost:7071/api/resteasy
```

## Deploy to Azure Functions with the Azure Functions Core Tools (native mode)

``` bash
func azure functionapp publish <FunctionAppName>
```
