package alfarezyyd.bishamonten.mapper;

import alfarezyyd.bishamonten.entity.PostLogoutRedirectUri;
import alfarezyyd.bishamonten.entity.RedirectUri;
import org.mapstruct.Mapper;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

@Mapper
public interface PostLogoutRedirectUriMapper {
  default Set<String> postLogoutRedirectUriEntityIntoClientRedirectUri(LinkedList<RedirectUri> postLogoutRedirectUrisEntity) {
    Set<String> postLogoutRedirectUris = new HashSet<>();
    for (RedirectUri postLogoutRedirectUri : postLogoutRedirectUrisEntity) {
      postLogoutRedirectUris.add(postLogoutRedirectUri.getName());
    }
    return postLogoutRedirectUris;
  }


  default LinkedList<PostLogoutRedirectUri> clientPostLogoutUriIntoPostLogoutRedirectUriEntity(Set<String> clientPostLogoutUris) {
    LinkedList<PostLogoutRedirectUri> postLogoutRedirectUris = new LinkedList<>();
    for (String clientPostLogoutUri : clientPostLogoutUris) {
      PostLogoutRedirectUri postLogoutRedirectUri = new PostLogoutRedirectUri();
      postLogoutRedirectUri.setName(clientPostLogoutUri);
      postLogoutRedirectUris.add(postLogoutRedirectUri);
    }
    return postLogoutRedirectUris;
  }
}
