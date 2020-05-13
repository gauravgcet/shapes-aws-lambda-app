# Using Serverless application to compute the characteristics of geometric shapes

This project contains source code and supporting files for a serverless application that you can deploy with the SAM CLI. It includes the following files and folders.

- Geometry/src/main - Code for the application's Lambda function.
- events - Invocation events that you can use to invoke the function.
- Geometry/src/test - Unit tests for the application code. 
- template.yaml - A template that defines the application's AWS resources.

The application uses several AWS resources, including Lambda functions and an API Gateway API. These resources are defined in the `template.yaml` file in this project.

## Deploy the sample application

To deploy using the SAM CLI, you need the following tools.

* SAM CLI
* Java11
* Maven
* Docker

To build and deploy your application for the first time, run the following in your shell:

```bash
sam build
sam deploy --guided
```
You can find your API Gateway Endpoint URL in the output values displayed after deployment.

## Use the SAM CLI to build and test locally

Build your application with the `sam build` command.

```bash
$ sam build
```

The SAM CLI installs dependencies defined in `geometry/pom.xml`, creates a deployment package, and saves it in the `.aws-sam/build` folder.

Test a single function by invoking it directly with a test event. An event is a JSON document that represents the input that the function receives from the event source. Test events are included in the `events` folder in this project.

Run functions locally and invoke them with the `sam local invoke` command.

```bash
$ sam local invoke ShapesFunction --event events/circle-event.json
$ sam local invoke ShapesFunction --event events/square-event.json

```

The SAM CLI can also emulate your application's API. Use the `sam local start-api` to run the API locally on port 3000.

```bash
$ sam local start-api
$ curl http://localhost:3000/shapes/sqaure?side=10&side=10
$ curl http://localhost:3000/shapes/circle?side=10
```

The SAM CLI reads the application template to determine the API's routes and the functions that they invoke. The `Events` property on each function's definition includes the route and method for each path.

```yaml
      Events:
        Shapes:
          Type: Api
          Properties:
            Path: /shapes/{shapeName}
            Method: get
```

## Fetch, tail, and filter Lambda function logs

```bash
$ sam logs -n ShapesFunction --stack-name Shapes --tail
```

## Unit tests

Tests are defined in the `geometry/src/test` folder in this project.

```bash
$ cd geometry
geometry$ mvn test
```

## Cleanup

```bash
aws cloudformation delete-stack --stack-name shapes
```