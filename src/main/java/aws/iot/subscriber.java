package aws.iot;

import com.amazonaws.services.iot.client.*;

public class subscriber {
  private static final AWSIotQos QOS = AWSIotQos.QOS0;
  private static final String TOPIC = "MyIoTButtonTopìc";

  public static void main (String args[]) {

    if(args.length < 1) { showHelp(); }

    AWSIotMqttClient client = new IoTMQTTClient(args[0]).getClient();

    try {
      client.connect();

      MyTopic topic = new MyTopic(TOPIC, QOS);
      client.subscribe(topic, 30000, true);

    } catch (AWSIotException e) {
      e.printStackTrace();
    } catch (AWSIotTimeoutException e) {
      e.printStackTrace();
    }
  }

  private static void showHelp()  {
    System.out.println("Usage: java -classpath targe/aws-1.0-SNAPSHOT.jar aws.iot.subscriber <config-file>\n");
    System.out.println("See resources/config.properties for an example of a config file.\n");
    System.exit(0);
  }
}