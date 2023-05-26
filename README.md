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

## Configure GitHub Actions to build and deploy the application

The GitHub Actions workflow that we will use is available in [.github/workflows/build-and-deploy.yml](.github/workflows/build-and-deploy.yml).

This GitHub Action will need to use some variables, for this go to your project fork and select "Settings", then "Secrets".

### Configure the FUNCTION_NAME variable

The `FUNCTION_NAME` is the name of your function application. You can find it in the Azure portal, or by executing the following command:

```bash
az functionapp list --resource-group $RESOURCE_GROUP  --query '[].name' -o tsv
```

Update the env variable called `FUNCTION_NAME` at '.github/workflow/build-and-deploy.yml'.

### Configure the AZURE_CREDENTIALS secret

The `AZURE_CREDENTIALS` will allow the GitHub Actions workflow to log in your Azure account, and deploy the application.

This is a JSON payload that we will get by executing the following command:

```bash
RESOURCE_ID=$(az group show --name $RESOURCE_GROUP --query id -o tsv)
SPNAME="sp-$(az functionapp list --resource-group $RESOURCE_GROUP  --query '[].name' -o tsv)"
az ad sp create-for-rbac --name "${SPNAME}" --role contributor --scopes "$RESOURCE_ID" --sdk-auth
```

Create a new secret called `AZURE_CREDENTIALS`, paste the JSON payload in it, and click "Add secret".

## Deploy and test

Now that everything is set up, your application will be automatically built as a GraalVM native image, and deployed to Azure Functions.

You can change some code, or force a commit to trigger such a build:

```bash
git commit -m "force build" --allow-empty && git push
```

You will be able to monitor that process in the "Actions" tab of your fork of the project.
