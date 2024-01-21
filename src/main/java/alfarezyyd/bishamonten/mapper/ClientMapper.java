package alfarezyyd.bishamonten.mapper;

import alfarezyyd.bishamonten.dto.client.ClientDto;
import alfarezyyd.bishamonten.entity.Client;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;
import org.springframework.security.oauth2.server.authorization.client.RegisteredClient;

import java.sql.Timestamp;
import java.time.Instant;

@Mapper(uses = {AuthenticationMethodMapper.class, GrantTypeMapper.class, RedirectUriMapper.class, ScopeMapper.class, ClientSettingMapper.class, PostLogoutRedirectUriMapper.class, TokenSettingMapper.class})
public interface ClientMapper {
  AuthenticationMethodMapper AUTHENTICATION_METHOD_MAPPER = Mappers.getMapper(AuthenticationMethodMapper.class);
  GrantTypeMapper GRANT_TYPE_MAPPER = Mappers.getMapper(GrantTypeMapper.class);
  RedirectUriMapper REDIRECT_URI_MAPPER = Mappers.getMapper(RedirectUriMapper.class);
  PostLogoutRedirectUriMapper POST_LOGOUT_REDIRECT_URI_MAPPER = Mappers.getMapper(PostLogoutRedirectUriMapper.class);
  ScopeMapper SCOPE_MAPPER = Mappers.getMapper(ScopeMapper.class);
  ClientSettingMapper CLIENT_SETTING_MAPPER = Mappers.getMapper(ClientSettingMapper.class);
  TokenSettingMapper TOKEN_SETTING_MAPPER = Mappers.getMapper(TokenSettingMapper.class);

  @Mapping(target = "clientIdIssuedAt", qualifiedByName = "instantIntoTimestamp")
  @Mapping(target = "clientSecretExpiresAt", qualifiedByName = "instantIntoTimestamp")
  @Mapping(target = "clientAuthenticationMethods", qualifiedByName = "entityAuthMethod")
  @Mapping(target = "authorizationGrantTypes", qualifiedByName = "entityGrantType")
  @Mapping(target = "redirectUris", qualifiedByName = "entityRedirectUri")
  @Mapping(target = "postLogoutRedirectUris", qualifiedByName = "entityPostLogoutRedirectUri")
  @Mapping(target = "scopes", qualifiedByName = "entityScope")
  @Mapping(target = "clientSettings", qualifiedByName = "entityClientSetting")
  @Mapping(target = "tokenSettings", qualifiedByName = "entityTokenSetting")
  void registeredClientIntoClient(@MappingTarget Client clientEntity, RegisteredClient registeredClient);

  default RegisteredClient clientIntoRegisteredClient(Client clientEntity) {
    return RegisteredClient
        .withId(String.valueOf(clientEntity.getId()))
        .clientId(clientEntity.getClientId())
        .clientIdIssuedAt(clientEntity.getClientIdIssuedAt().toInstant())
        .clientSecret(clientEntity.getClientSecret())
        .clientSecretExpiresAt(clientEntity.getClientSecretExpiresAt().toInstant())
        .clientName(clientEntity.getClientName())
        .clientAuthenticationMethods(clientAuthenticationMethods -> AUTHENTICATION_METHOD_MAPPER.authMethodEntityIntoClientAuthMethod(clientEntity.getClientAuthenticationMethods()))
        .authorizationGrantTypes(authorizationGrantTypes -> GRANT_TYPE_MAPPER.grantTypeEntityIntoAuthGrantType(clientEntity.getAuthorizationGrantTypes()))
        .redirectUris(redirectUris -> REDIRECT_URI_MAPPER.redirectUriEntityIntoClientRedirectUri(clientEntity.getRedirectUris()))
        .postLogoutRedirectUris(postLogoutRedirectUris -> POST_LOGOUT_REDIRECT_URI_MAPPER.postLogoutRedirectUriEntityIntoClientRedirectUri(clientEntity.getPostLogoutRedirectUris()))
        .scopes(scopes -> SCOPE_MAPPER.scopeEntityIntoClientScope(clientEntity.getScopes()))
        .clientSettings(CLIENT_SETTING_MAPPER.clientSettingEntityIntoClientSettings(clientEntity.getClientSettings()))
        .tokenSettings(TOKEN_SETTING_MAPPER.tokenSettingEntityIntoTokenSettings(clientEntity.getTokenSettings()))
        .build();
  }

  default RegisteredClient clientDtoIntoRegisteredClient(ClientDto clientDto) {
    return RegisteredClient
        .withId(String.valueOf(clientDto.getId()))
        .clientId(clientDto.getClientId())
        .clientSecret(clientDto.getClientSecret())
        .clientName(clientDto.getClientName())
        .clientAuthenticationMethods(clientAuthenticationMethods -> AUTHENTICATION_METHOD_MAPPER.authMethodStringIntoClientAuthMethod(clientDto.getClientAuthenticationMethods()))
        .authorizationGrantTypes(authorizationGrantTypes -> GRANT_TYPE_MAPPER.grantTypeStringIntoAuthGrantType(clientDto.getAuthorizationGrantTypes()))
        .redirectUris(redirectUris -> REDIRECT_URI_MAPPER.redirectUriStringIntoClientRedirectUri(clientDto.getRedirectUris()))
        .postLogoutRedirectUris(postLogoutRedirectUris -> POST_LOGOUT_REDIRECT_URI_MAPPER.postLogoutRedirectUriStringIntoClientRedirectUri(clientDto.getPostLogoutRedirectUris()))
        .scopes(scopes -> SCOPE_MAPPER.scopeStringIntoClientScope(clientDto.getScopes()))
        .clientSettings(CLIENT_SETTING_MAPPER.clientDtoIntoClientSettings(clientDto.getClientSetting()))
        .tokenSettings(TOKEN_SETTING_MAPPER.tokenSettingDtoIntoTokenSettings(clientDto.getTokenSetting()))
        .build();
  }


  @Named("instantIntoTimestamp")
  static Timestamp instantIntoTimestamp(Instant instantVal) {
    return new Timestamp(instantVal.getEpochSecond());
  }
}
