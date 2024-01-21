package alfarezyyd.bishamonten.mapper;

import alfarezyyd.bishamonten.dto.token.setting.TokenSettingDto;
import alfarezyyd.bishamonten.entity.TokenSetting;
import org.mapstruct.Mapper;
import org.mapstruct.Named;
import org.springframework.security.oauth2.jose.jws.SignatureAlgorithm;
import org.springframework.security.oauth2.server.authorization.settings.OAuth2TokenFormat;
import org.springframework.security.oauth2.server.authorization.settings.TokenSettings;

import java.time.Duration;

@Mapper(componentModel = "spring")
public interface TokenSettingMapper {
  @Named("clientTokenSettings")
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

  @Named("entityTokenSetting")
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

  @Named("clientTokenSettingsDto")
  default TokenSettings tokenSettingDtoIntoTokenSettings(TokenSettingDto tokenSettingDto) {
    return TokenSettings.builder()
        .accessTokenFormat(new OAuth2TokenFormat(tokenSettingDto.getAccessTokenFormat()))
        .accessTokenTimeToLive(Duration.ofHours(tokenSettingDto.getAccessTokenTtl()))
        .authorizationCodeTimeToLive(Duration.ofHours(tokenSettingDto.getAuthorizationCodeTtl()))
        .deviceCodeTimeToLive(Duration.ofHours(tokenSettingDto.getDeviceCodeTtl()))
        .reuseRefreshTokens(tokenSettingDto.getReuseRefreshToken())
        .refreshTokenTimeToLive(Duration.ofHours(tokenSettingDto.getRefreshTokenTtl()))
        .idTokenSignatureAlgorithm(SignatureAlgorithm.from(tokenSettingDto.getIdTokenSignatureAlgorithm()))
        .build();
  }
}
