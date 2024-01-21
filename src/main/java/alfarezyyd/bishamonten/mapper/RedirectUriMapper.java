package alfarezyyd.bishamonten.mapper;

import alfarezyyd.bishamonten.entity.RedirectUri;
import org.mapstruct.Mapper;
import org.mapstruct.Named;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

@Mapper
public interface RedirectUriMapper {
  @Named("clientRedirectUri")
  default Set<String> redirectUriEntityIntoClientRedirectUri(LinkedList<RedirectUri> redirectUrisEntity) {
    Set<String> redirectUris = new HashSet<>();
    for (RedirectUri redirectUri : redirectUrisEntity) {
      redirectUris.add(redirectUri.getName());
    }
    return redirectUris;
  }

  @Named("entityRedirectUri")
  default LinkedList<RedirectUri> clientRedirectUriIntoRedirectUriEntity(Set<String> clientRedirectUris) {
    LinkedList<RedirectUri> redirectUris = new LinkedList<>();
    for (String clientRedirectUri : clientRedirectUris) {
      RedirectUri redirectUri = new RedirectUri();
      redirectUri.setName(clientRedirectUri);
      redirectUris.add(redirectUri);
    }
    return redirectUris;
  }
}
