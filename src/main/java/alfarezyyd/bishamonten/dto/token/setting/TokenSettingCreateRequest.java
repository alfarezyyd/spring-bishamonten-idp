package alfarezyyd.bishamonten.dto.token.setting;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TokenSettingCreateRequest {
  @JsonProperty("authorization_code_ttl")
  private Short authorizationCodeTtl;
  @JsonProperty("access_token_ttl")
  private Short accessTokenTtl;
  @JsonProperty("access_token_format")
  private String accessTokenFormat;
  @JsonProperty("device_code_ttl")
  private Short deviceCodeTtl;
  @JsonProperty("reuse_refresh_token")
  private Boolean reuseRefreshToken;
  @JsonProperty("refresh_token_ttl")
  private Short refreshTokenTtl;
  @JsonProperty("id_token_signature_algorithm")
  private String idTokenSignatureAlgorithm;
}
