package alfarezyyd.bishamonten.mapper;

import alfarezyyd.bishamonten.entity.TokenSetting;
import org.mapstruct.Mapper;
import org.springframework.security.oauth2.jose.jws.SignatureAlgorithm;
import org.springframework.security.oauth2.server.authorization.settings.OAuth2TokenFormat;
import org.springframework.security.oauth2.server.authorization.settings.TokenSettings;

import java.time.Duration;

@Mapper(componentModel = "spring")
public interface TokenSettingMapper {
  default TokenSettings tokenSettingEntityIntoTokenSettings(TokenSetting tokenSettingEntity) {
    return TokenSettings.builder()
        .accessTokenFormat(new OAuth2TokenFormat(tokenSettingEntity.getAccessTokenFormat()))
        .accessTokenTimeToLive(Duration.ofHours(tokenSettingEntity.getAccessTokenTtl()))
        .authorizationCodeTimeToLive(Duration.ofHours(tokenSettingEntity.getAuthorizationCodeTtl()))
        .deviceCodeTimeToLive(Duration.ofHours(tokenSettingEntity.getDeviceCodeTtl()))
        .reuseRefreshTokens(tokenSettingEntity.getReuseRefreshToken())
        .refreshTokenTimeToLive(Duration.ofHours(tokenSettingEntity.getRefreshTokenTtl()))
        .idTokenSignatureAlgorithm(SignatureAlgorithm.from(tokenSettingEntity.getIdTokenSignatureAlgorithm()))
        .build();
  }

  default TokenSetting tokenSettingsIntoTokenSettingEntity(TokenSettings tokenSettings) {
    TokenSetting tokenSetting = new TokenSetting();
    tokenSetting.setAccessTokenFormat(tokenSettings.getAccessTokenFormat().getValue());
    tokenSetting.setAuthorizationCodeTtl(((short) tokenSettings.getAuthorizationCodeTimeToLive().toHours()));
    tokenSetting.setAccessTokenTtl(((short) tokenSettings.getAccessTokenTimeToLive().toHours()));
    tokenSetting.setDeviceCodeTtl(((short) tokenSettings.getDeviceCodeTimeToLive().toHours()));
    tokenSetting.setReuseRefreshToken(tokenSettings.isReuseRefreshTokens());
    tokenSetting.setRefreshTokenTtl(((short) tokenSettings.getRefreshTokenTimeToLive().toHours()));
    tokenSetting.setIdTokenSignatureAlgorithm(tokenSettings.getIdTokenSignatureAlgorithm().getName());
    return tokenSetting;
  }
}
