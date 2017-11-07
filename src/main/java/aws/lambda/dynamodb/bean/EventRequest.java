package aws.lambda.dynamodb.bean;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class EventRequest {
  private int id;
  private String source;
  private String date;
  private String severity;
  private String message;

  public static void main(String[] args) {
    EventRequest EventRequest = new EventRequest();
    EventRequest.setId(1);
    EventRequest.setSource("192.168.1.1");
    EventRequest.setDate("2017-12-31");
    EventRequest.setSeverity("Severity");
    EventRequest.setMessage("Test Message");
    System.out.println(EventRequest);
  }

  public int getId() {
    return id;
  }

  public void setId(int id) { this.id = id; }

  public String getSource() {
    return source;
  }

  public void setSource(String source) {
    this.source = source;
  }

  public String getDate() {
    return date;
  }

  public void setDate(String date) {
    this.date = date;
  }

  public String getSeverity() {
    return severity;
  }

  public void setSeverity(String severity) { this.severity = severity; }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public String toString() {
    final Gson gson = new GsonBuilder().setPrettyPrinting().create();
    return gson.toJson(this);
  }
}