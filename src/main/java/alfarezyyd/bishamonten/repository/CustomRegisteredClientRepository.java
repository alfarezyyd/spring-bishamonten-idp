package alfarezyyd.bishamonten.repository;

import alfarezyyd.bishamonten.entity.Client;
import alfarezyyd.bishamonten.mapper.ClientMapper;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.security.oauth2.server.authorization.client.RegisteredClient;
import org.springframework.security.oauth2.server.authorization.client.RegisteredClientRepository;
import org.springframework.stereotype.Repository;

@Repository
public class CustomRegisteredClientRepository implements RegisteredClientRepository {
  @PersistenceContext
  private EntityManager entityManager;
  private ClientMapper clientMapper;

  @Override
  public void save(RegisteredClient registeredClient) {

  }

  @Override
  public RegisteredClient findById(String id) {
    Client foundClient = entityManager.find(Client.class, Long.valueOf(id));
    return RegisteredClient.withId("1").build();
  }

  @Override
  public RegisteredClient findByClientId(String clientId) {
    return null;
  }
}
