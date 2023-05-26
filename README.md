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

Build to run locally
```
mvn clean package -Pnative
```

Build do publish on Azure
```
mvn clean package -Pnative -Dquarkus.native.container-build=true -Dquarkus.native.builder-image=quay.io/quarkus/ubi-quarkus-mandrel-builder-image:22.3.2.1-Final-java17
```

```
cp target/quarkus-azure-functions-http-1.0.0-SNAPSHOT-runner functions/
```

```
cd functions
```

Test local
```
func start
```

```
curl localhost:7071/api/funq
```

```
curl localhost:7071/api/resteasy
```

Publish
1. Create Function App in Azure portal(runtime stack: custom handler, OS: Linux)
```
func azure functionapp publish <function app name>
```
