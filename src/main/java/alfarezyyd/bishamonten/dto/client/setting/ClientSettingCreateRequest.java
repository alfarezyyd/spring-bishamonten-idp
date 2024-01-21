package alfarezyyd.bishamonten.dto.client.setting;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ClientSettingCreateRequest implements ClientSettingDto{
  @JsonProperty("require_proof_key")
  private Boolean requireProofKey;
  @JsonProperty("require_authorization_consent")
  private Boolean requireAuthorizationConsent;
  @JsonProperty("jwk_set_url")
  private String jwkSetUrl;
  @JsonProperty("token_endpoint_authentication_signing_algorithm")
  private String tokenEndpointAuthenticationSigningAlgorithm;
}
