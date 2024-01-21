package alfarezyyd.bishamonten.mapper;

import alfarezyyd.bishamonten.dto.client.setting.ClientSettingDto;
import alfarezyyd.bishamonten.entity.ClientSetting;
import org.mapstruct.Mapper;
import org.mapstruct.Named;
import org.springframework.security.oauth2.jose.jws.MacAlgorithm;
import org.springframework.security.oauth2.jose.jws.SignatureAlgorithm;
import org.springframework.security.oauth2.server.authorization.settings.ClientSettings;

@Mapper
public interface ClientSettingMapper {
  @Named("clientSettings")
  default ClientSettings clientSettingEntityIntoClientSettings(ClientSetting clientSettingEntity) {
    MacAlgorithm macAlgorithm = MacAlgorithm.from(clientSettingEntity.getTokenEndpointAuthenticationSigningAlgorithm());
    SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.from(clientSettingEntity.getTokenEndpointAuthenticationSigningAlgorithm());
    return ClientSettings.builder()
        .requireAuthorizationConsent(clientSettingEntity.getRequireAuthorizationConsent())
        .requireProofKey(clientSettingEntity.getRequireProofKey())
        .jwkSetUrl(clientSettingEntity.getJwkSetUrl())
        .tokenEndpointAuthenticationSigningAlgorithm(macAlgorithm == null ? signatureAlgorithm : macAlgorithm)
        .build();
  }

  @Named("entityClientSetting")
  default ClientSetting clientSettingsIntoClientSettingEntity(ClientSettings clientSettings) {
    ClientSetting clientSetting = new ClientSetting();
    clientSetting.setJwkSetUrl(clientSettings.getJwkSetUrl());
    clientSetting.setRequireProofKey(clientSettings.isRequireProofKey());
    clientSetting.setRequireAuthorizationConsent(clientSettings.isRequireAuthorizationConsent());
    clientSetting.setTokenEndpointAuthenticationSigningAlgorithm(clientSettings.getTokenEndpointAuthenticationSigningAlgorithm().getName());
    return clientSetting;
  }

  @Named("clientSettingsDto")
  default ClientSettings clientDtoIntoClientSettings(ClientSettingDto clientSettingDto) {
    MacAlgorithm macAlgorithm = MacAlgorithm.from(clientSettingDto.getTokenEndpointAuthenticationSigningAlgorithm());
    SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.from(clientSettingDto.getTokenEndpointAuthenticationSigningAlgorithm());
    return ClientSettings.builder()
        .requireAuthorizationConsent(clientSettingDto.getRequireAuthorizationConsent())
        .requireProofKey(clientSettingDto.getRequireProofKey())
        .jwkSetUrl(clientSettingDto.getJwkSetUrl())
        .tokenEndpointAuthenticationSigningAlgorithm(macAlgorithm == null ? signatureAlgorithm : macAlgorithm)
        .build();
  }
}
