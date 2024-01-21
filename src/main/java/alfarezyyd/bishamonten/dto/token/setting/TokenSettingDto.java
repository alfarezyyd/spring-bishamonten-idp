package alfarezyyd.bishamonten.dto.token.setting;

public interface TokenSettingDto {

  Short getAuthorizationCodeTtl();

  Short getAccessTokenTtl();

  String getAccessTokenFormat();

  Short getDeviceCodeTtl();

  Boolean getReuseRefreshToken();

  Short getRefreshTokenTtl();

  String getIdTokenSignatureAlgorithm();

}
