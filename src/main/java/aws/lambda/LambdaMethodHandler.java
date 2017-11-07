package aws.lambda;

import aws.lambda.dynamodb.bean.EventRequest;
import com.amazonaws.services.lambda.runtime.Context;

public class LambdaMethodHandler {
  public String handleRequest(EventRequest input, Context context) {
    context.getLogger().log("Input: " + input.toString());
    return "[Event] " + input.toString();
  }
}