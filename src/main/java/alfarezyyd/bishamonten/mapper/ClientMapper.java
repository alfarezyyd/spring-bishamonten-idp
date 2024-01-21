package alfarezyyd.bishamonten.mapper;

import alfarezyyd.bishamonten.entity.Client;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.springframework.security.oauth2.server.authorization.client.RegisteredClient;

import java.sql.Timestamp;
import java.time.Instant;

@Mapper(uses = {AuthenticationMethodMapper.class, GrantTypeMapper.class, RedirectUriMapper.class, ScopeMapper.class, ClientSettingMapper.class, PostLogoutRedirectUriMapper.class, TokenSettingMapper.class})
public interface ClientMapper {
  @Mapping(target = "clientIdIssuedAt", qualifiedByName = "instantIntoTimestamp")
  @Mapping(target = "clientSecretExpiresAt", qualifiedByName = "instantIntoTimestamp")
  Client registeredClientIntoClient(RegisteredClient registeredClient);


  @Named("instantIntoTimestamp")
  static Timestamp instantIntoTimestamp(Instant instantVal) {
    return new Timestamp(instantVal.getEpochSecond());
  }
}
