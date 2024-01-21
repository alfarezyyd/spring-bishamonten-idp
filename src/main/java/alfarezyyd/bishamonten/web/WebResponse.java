package alfarezyyd.bishamonten.web;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class WebResponse<T> {
  @JsonProperty("response_data")
  private T responseData;
  @JsonProperty("error_message")
  private Object errorMessage;
}