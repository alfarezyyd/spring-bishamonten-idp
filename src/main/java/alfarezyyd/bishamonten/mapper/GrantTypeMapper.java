package alfarezyyd.bishamonten.mapper;

import alfarezyyd.bishamonten.entity.GrantType;
import org.mapstruct.Mapper;
import org.mapstruct.Named;
import org.springframework.security.oauth2.core.AuthorizationGrantType;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

@Mapper
public interface GrantTypeMapper {
  @Named("entityGrantType")
  default LinkedList<GrantType> authGrantTypeIntoGrantTypeEntity(Set<AuthorizationGrantType> authorizationGrantTypes) {
    LinkedList<GrantType> grantTypes = new LinkedList<>();
    for (AuthorizationGrantType authorizationGrantType : authorizationGrantTypes) {
      GrantType grantType = new GrantType();
      grantType.setName(authorizationGrantType.getValue());
      grantTypes.add(grantType);
    }
    return grantTypes;
  }

  @Named("clientGrantType")
  default Set<AuthorizationGrantType> grantTypeEntityIntoAuthGrantType(List<GrantType> grantTypes) {
    Set<AuthorizationGrantType> authorizationGrantTypes = new HashSet<>();
    for (GrantType grantType : grantTypes) {
      authorizationGrantTypes.add(new AuthorizationGrantType(grantType.getName()));
    }
    return authorizationGrantTypes;
  }

  @Named("clientGrantTypeString")
  default Set<AuthorizationGrantType> grantTypeStringIntoAuthGrantType(List<String> grantTypes) {
    Set<AuthorizationGrantType> authorizationGrantTypes = new HashSet<>();
    for (String grantType : grantTypes) {
      authorizationGrantTypes.add(new AuthorizationGrantType(grantType));
    }
    return authorizationGrantTypes;
  }
}
