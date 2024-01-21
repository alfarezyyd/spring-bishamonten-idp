package alfarezyyd.bishamonten.dto.client.setting;

public interface ClientSettingDto {

  Boolean getRequireProofKey();

  Boolean getRequireAuthorizationConsent();

  String getJwkSetUrl();

  String getTokenEndpointAuthenticationSigningAlgorithm();
}
