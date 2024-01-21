package alfarezyyd.bishamonten.mapper;

import alfarezyyd.bishamonten.entity.Scope;
import org.mapstruct.Mapper;
import org.mapstruct.Named;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

@Mapper
public interface ScopeMapper {
  @Named("clientScope")
  default Set<String> scopeEntityIntoClientScope(LinkedList<Scope> scopeEntities) {
    Set<String> clientScopes = new HashSet<>();
    for (Scope scopeEntity : scopeEntities) {
      clientScopes.add(scopeEntity.getName());
    }
    return clientScopes;
  }

  @Named("entityScope")
  default LinkedList<Scope> clientScopeIntoScopeEntity(Set<String> clientScopes) {
    LinkedList<Scope> scopes = new LinkedList<>();
    for (String clientScope : clientScopes) {
      Scope scope = new Scope();
      scope.setName(clientScope);
      scopes.add(scope);
    }
    return scopes;
  }
}

