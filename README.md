# AWS

### AWS IoT
AWS IoT SDK for Java: http://docs.aws.amazon.com/iot/latest/developerguide/iot-sdks.html#iot-java-sdk

AWS IoT SDK for Java on GitHub: https://github.com/aws/aws-iot-device-sdk-java

#### Install the SDK
Install the SDK Using Maven

```XML
<dependencies>
    <dependency>
        <groupId>com.amazonaws</groupId>
        <artifactId>aws-iot-device-sdk-java</artifactId>
        <version>1.1.1</version>
    </dependency>
</dependencies>
```

#### Publisher/Subscriber Example

1. Login on AWS console and click on AWS IoT service.

2. Register a device / thing.

+INFO: http://docs.aws.amazon.com/iot/latest/developerguide/register-device.html

3. Create and Activate a Device Certificate.

+INFO: http://docs.aws.amazon.com/iot/latest/developerguide/create-device-certificate.html

¡¡¡IMPORTANT!!!: Choose Download for the certificate, private key, and the root CA for AWS IoT. Save each of them to your computer.

4. Create and Attach a policy.

+INFO: http://docs.aws.amazon.com/iot/latest/developerguide/create-iot-policy.html

After the policy has been created, click on it and check Policy Document:
```JSON
{
  "Version": "2012-10-17",
  "Statement": [
    {
      "Effect": "Allow",
      "Action": "iot:Connect",
      "Resource": "*"
    },
    {
      "Effect": "Allow",
      "Action": "iot:Subscribe",
      "Resource": "*"
    },
    {
      "Effect": "Allow",
      "Action": "iot:Publish",
      "Resource": "arn:aws:iot:<your-region>:<your-endpoint>:topic/MyIoTButtonTopìc"
    }
  ]
}
```

5. Attach a Certificate to a Thing

+INFO: http://docs.aws.amazon.com/iot/latest/developerguide/attach-cert-thing.html

6. Create a rule and add an action, e.g. SNS email.

+INFO: http://docs.aws.amazon.com/iot/latest/developerguide/config-and-test-rules.html

7. Create config-publisher.properties file.

   7.1 Fill in resources/config.properties template.

   7.2 Save it as config-publisher.properties.

8. Run the Publisher:


    mvn exec:java -Dexec.mainClass="aws.iot.publisher" -Dexec.args="config-publisher.properties"
   
Your output should be similar: 

    ...
    Cert file:<your-certf-file> Private key: <your-key-file>
    nov 24, 2017 12:24:16 PM com.amazonaws.services.iot.client.core.AwsIotConnection onConnectionSuccess
    INFORMACIÓN: Connection successfully established
    nov 24, 2017 12:24:16 PM com.amazonaws.services.iot.client.core.AbstractAwsIotClient onConnectionSuccess
    INFORMACIÓN: Client connection active: <your-client-id>
    nov 24, 2017 12:24:16 PM com.amazonaws.services.iot.client.core.AwsIotConnection onConnectionClosed
    INFORMACIÓN: Connection permanently closed
    nov 24, 2017 12:24:16 PM com.amazonaws.services.iot.client.core.AbstractAwsIotClient onConnectionClosed
    INFORMACIÓN: Client connection closed: <your cliend-id>
    ...

Check your email.
    
9. Create config-subscriber.properties file.

   9.1 Fill in resources/config.properties template. Make sure that the clientId is different from the previous one.

   9.2 Save it as config-subscriber.properties. 

10. Run the Subscriber:


    mvn exec:java -Dexec.mainClass="aws.iot.subscriber" -Dexec.args="config-subscriber.properties"
    
Your output should be similar:

    ...
    Cert file:<your-certf-file> Private key: <your-key-file>
    nov 24, 2017 12:26:52 PM com.amazonaws.services.iot.client.core.AwsIotConnection onConnectionSuccess
    INFORMACIÓN: Connection successfully established
    nov 24, 2017 12:26:52 PM com.amazonaws.services.iot.client.core.AbstractAwsIotClient onConnectionSuccess
    INFORMACIÓN: Client connection active: <your-client-id>
    New message: {
        "deviceid" : "iot123",
            "temp" : 54.98,
            "humidity" : 32.43,
        "coords" : {
            "latitude" : 47.615694,
            "longitude" : -122.3359976
        }
    }
    ...