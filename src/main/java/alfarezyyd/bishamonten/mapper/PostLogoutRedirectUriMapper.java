package alfarezyyd.bishamonten.mapper;

import alfarezyyd.bishamonten.entity.PostLogoutRedirectUri;
import org.mapstruct.Mapper;
import org.mapstruct.Named;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

@Mapper
public interface PostLogoutRedirectUriMapper {
  @Named("clientPostLogoutRedirectUri")
  default Set<String> postLogoutRedirectUriEntityIntoClientRedirectUri(LinkedList<PostLogoutRedirectUri> postLogoutRedirectUrisEntity) {
    Set<String> postLogoutRedirectUris = new HashSet<>();
    for (PostLogoutRedirectUri postLogoutRedirectUri : postLogoutRedirectUrisEntity) {
      postLogoutRedirectUris.add(postLogoutRedirectUri.getName());
    }
    return postLogoutRedirectUris;
  }


  @Named("entityPostLogoutRedirectUri")
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
