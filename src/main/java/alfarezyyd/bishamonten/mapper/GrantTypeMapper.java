package alfarezyyd.bishamonten.mapper;

import alfarezyyd.bishamonten.entity.GrantType;
import org.mapstruct.Mapper;
import org.springframework.security.oauth2.core.AuthorizationGrantType;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

@Mapper
public interface GrantTypeMapper {
  default LinkedList<GrantType> authGrantTypeIntoGrantTypeEntity(Set<AuthorizationGrantType> authorizationGrantTypes) {
    LinkedList<GrantType> grantTypes = new LinkedList<>();
    for (AuthorizationGrantType authorizationGrantType : authorizationGrantTypes) {
      GrantType grantType = new GrantType();
      grantType.setName(authorizationGrantType.getValue());
      grantTypes.add(grantType);
    }
    return grantTypes;
  }

  default Set<AuthorizationGrantType> grantTypeEntityIntoAuthGrantType(LinkedList<GrantType> grantTypes) {
    Set<AuthorizationGrantType> authorizationGrantTypes = new HashSet<>();
    for (GrantType grantType : grantTypes) {
      authorizationGrantTypes.add(new AuthorizationGrantType(grantType.getName()));
    }
    return authorizationGrantTypes;
  }
}
