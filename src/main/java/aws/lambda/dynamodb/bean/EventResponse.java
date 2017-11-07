package aws.lambda.dynamodb.bean;

import com.google.gson.Gson;

public class EventResponse {
  private String message;

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public String toString() {
    final Gson gson = new Gson();
    return gson.toJson(this);
  }
}