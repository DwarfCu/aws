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

2. Register a device/thing. Attach a policy. Generate, download and associate a certificate to a thing.

+INFO: http://docs.aws.amazon.com/iot/latest/developerguide/register-device.html

3. Create a rule and add an action, e.g. SNS email.

+INFO: http://docs.aws.amazon.com/iot/latest/developerguide/config-and-test-rules.html

4. Run the Publisher:


    mvn exec:java -Dexec.mainClass="aws.iot.publisher" -Dexec.args="<config.properties>"
   
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
    
5. Run the Subscriber:


    mvn exec:java -Dexec.mainClass="aws.iot.subscriber" -Dexec.args="<config.properties>"