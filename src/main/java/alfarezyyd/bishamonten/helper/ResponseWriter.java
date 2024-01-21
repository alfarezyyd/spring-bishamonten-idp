package alfarezyyd.bishamonten.helper;

import alfarezyyd.bishamonten.web.WebResponse;

public class ResponseWriter {
  private ResponseWriter() {
  }

  public static <T> WebResponse<T> writeIntoSuccessResponseBody(T responseData) {
    return WebResponse.<T>builder()
        .responseData(responseData)
        .errorMessage(null)
        .build();
  }
}
