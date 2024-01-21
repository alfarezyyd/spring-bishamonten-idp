package alfarezyyd.bishamonten.dto.client;

import alfarezyyd.bishamonten.dto.client.setting.ClientSettingCreateRequest;
import alfarezyyd.bishamonten.dto.token.setting.TokenSettingCreateRequest;

import java.util.List;

public interface ClientDto {
  Long getId();

  String getClientId();

  String getClientSecret();

  String getClientName();

  List<String> getClientAuthenticationMethods();

  List<String> getAuthorizationGrantTypes();

  List<String> getRedirectUris();

  List<String> getPostLogoutRedirectUris();

  List<String> getScopes();

  ClientSettingCreateRequest getClientSetting();

  TokenSettingCreateRequest getTokenSetting();
}
