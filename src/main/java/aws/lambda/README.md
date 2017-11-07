# AWS Lambda

1) <a href="https://console.aws.amazon.com/console/home">Sign up on AWS Console</a>

2) Select Lambda Service

3) Create a function (first time "Getting started -> Create a function -> Author from scrath")

4) Fill Basic Information
    1) Setup name, e.g. EventLambdaTest.
    
    2) Choose an existing role (e.g. lambda_basic_execution)
    
        Note: First time choose "Create a custom role". In the new opened window: "IAM Role=Create a new IAM Role" and "Role Name=lambda_basic_execution". Press "Allow" button. Maybe after that, you have to modified the policies for this role.
        
    3) Press "Create Function" button.
    
5) Display "Runtime" options and select "Java 8".

6) Display "Code Entry Type" and select "Upload a .ZIP or JAR file"

Note: You must build the application or have done it previosly:

    mvn clean package shade:shade.

7) Press "Upload" button and select the JAR file, e.g. aws-1.0-SNAPSHOT.jar.

8) Setup "Handler" file: aws.lambda.LambdaMethodHandler::handleRequest

9) Press "Save" button.

10) Display "Select a test event" field and press "Configure test event".

    1) Event name: e.g. EventTest.
    
    2) {
           "id":1,
           "source": "192.168.1.151",
           "date": "2017-11-07 15:23:00",
           "severity": "MINOR",
           "message": "Login failed",
           "other": "this field will not be displayed"
       }
       
    3) Press "Create" button.
    
11) Press "Test" button.

12) "Execution result: succeeded". If you check the details: "[Event] {\n  \"id\": 1,\n  \"source\": \"192.168.1.151\",\n  \"date\": \"2017-11-07 15:23:00\",\n  \"severity\": \"MINOR\",\n  \"message\": \"Login failed\"\n}"