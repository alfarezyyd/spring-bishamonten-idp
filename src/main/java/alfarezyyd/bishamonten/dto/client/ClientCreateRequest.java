package alfarezyyd.bishamonten.dto.client;

import alfarezyyd.bishamonten.dto.client.setting.ClientSettingCreateRequest;
import alfarezyyd.bishamonten.dto.token.setting.TokenSettingCreateRequest;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.LinkedList;

@Getter
@Setter
public class ClientCreateRequest {
  @JsonProperty("client_id")
  private String clientId;
  @JsonProperty("client_secret")
  private String clientSecret;
  @JsonProperty("client_name")
  private String clientName;
  @JsonProperty("client_authentication_methods")
  private LinkedList<String> clientAuthenticationMethods;
  @JsonProperty("authorization_grant_types")
  private LinkedList<String> authorizationGrantTypes;
  @JsonProperty("redirect_uris")
  private LinkedList<String> redirectUris;
  @JsonProperty("post_logout_redirect_uris")
  private LinkedList<String> postLogoutRedirectUris;
  @JsonProperty("scopes")
  private LinkedList<String> scopes;
  @JsonProperty("client_setting")
  private ClientSettingCreateRequest clientSetting;
  @JsonProperty("token_setting")
  private TokenSettingCreateRequest tokenSetting;
}
