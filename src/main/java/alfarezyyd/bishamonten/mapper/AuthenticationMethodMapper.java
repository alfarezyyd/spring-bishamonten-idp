package alfarezyyd.bishamonten.mapper;

import alfarezyyd.bishamonten.entity.AuthenticationMethod;
import org.mapstruct.Mapper;
import org.mapstruct.Named;
import org.springframework.security.oauth2.core.ClientAuthenticationMethod;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

@Mapper
public interface AuthenticationMethodMapper {

  @Named("clientAuthMethod")
  default Set<ClientAuthenticationMethod> authMethodEntityIntoClientAuthMethod(LinkedList<AuthenticationMethod> authenticationMethods) {
    Set<ClientAuthenticationMethod> clientAuthenticationMethods = new HashSet<>();
    for (AuthenticationMethod authenticationMethod : authenticationMethods) {
      clientAuthenticationMethods.add(new ClientAuthenticationMethod(authenticationMethod.getName()));
    }
    return clientAuthenticationMethods;
  }

  @Named("entityAuthMethod")
  default LinkedList<AuthenticationMethod> clientAuthMethodIntoAuthMethodEntity(Set<ClientAuthenticationMethod> clientAuthenticationMethods) {
    LinkedList<AuthenticationMethod> authenticationMethods = new LinkedList<>();
    for (ClientAuthenticationMethod clientAuthenticationMethod : clientAuthenticationMethods) {
      AuthenticationMethod authenticationMethod = new AuthenticationMethod();
      authenticationMethod.setName(clientAuthenticationMethod.getValue());
      authenticationMethods.add(authenticationMethod);
    }
    return authenticationMethods;
  }
}
