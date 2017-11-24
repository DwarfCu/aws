package aws.iot;

import com.amazonaws.services.iot.client.AWSIotException;
import com.amazonaws.services.iot.client.AWSIotMqttClient;
import com.amazonaws.services.iot.client.AWSIotQos;
import com.amazonaws.services.iot.client.AWSIotTimeoutException;

public class publisher {
  private static final AWSIotQos QOS = AWSIotQos.QOS0;
  private static final long QUIESCE_TIMEOUT = 5000;
  private static final String TOPIC = "MyIoTButtonTopìc";
  private static final String PAYLOAD = "{\n" +
      "    \"deviceid\" : \"iot123\",\n" +
      "    \"temp\" : 54.98,\n" +
      "    \"humidity\" : 32.43,\n" +
      "    \"coords\" : {\n" +
      "        \"latitude\" : 47.615694,\n" +
      "        \"longitude\" : -122.3359976\n" +
      "    }\n" +
      "}";

  public static void main (String args[]) {

    if(args.length < 1) { showHelp(); }

    AWSIotMqttClient client = new IoTMQTTClient(args[0]).getClient();

    try {
      client.connect();

      client.publish(TOPIC, QOS, PAYLOAD);

      client.disconnect(QUIESCE_TIMEOUT);

    } catch (AWSIotException e) {
      e.printStackTrace();
    } catch (AWSIotTimeoutException e) {
      e.printStackTrace();
    }
  }

  private static void showHelp()  {
    System.out.println("Usage: java -classpath targe/aws-1.0-SNAPSHOT.jar aws.iot.publisher <config-file>\n");
    System.out.println("See resources/config.properties for an example of a config file.\n");
    System.exit(0);
  }
}
