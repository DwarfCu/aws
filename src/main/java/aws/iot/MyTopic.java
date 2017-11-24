package aws.iot;

import com.amazonaws.services.iot.client.AWSIotMessage;
import com.amazonaws.services.iot.client.AWSIotQos;
import com.amazonaws.services.iot.client.AWSIotTopic;

public class MyTopic extends AWSIotTopic {
  public MyTopic(String topic, AWSIotQos qos) { super(topic, qos); }

  @Override
  public void onMessage(AWSIotMessage message) {
    // called when a message is received
    System.out.println("New message: " + message);
  }
}