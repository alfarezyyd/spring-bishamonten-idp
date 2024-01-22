package alfarezyyd.bishamonten.repository;

import alfarezyyd.bishamonten.entity.Client;
import alfarezyyd.bishamonten.mapper.ClientMapper;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;
import org.springframework.security.oauth2.server.authorization.client.RegisteredClient;
import org.springframework.security.oauth2.server.authorization.client.RegisteredClientRepository;
import org.springframework.stereotype.Repository;

@Repository
public class CustomRegisteredClientRepository implements RegisteredClientRepository {
  private final EntityManager entityManager;
  private final ClientMapper clientMapper;

  public CustomRegisteredClientRepository(EntityManager entityManager, ClientMapper clientMapper) {
    this.entityManager = entityManager;
    this.clientMapper = clientMapper;
  }

  @Override
  public void save(RegisteredClient registeredClient) {
    EntityTransaction entityTransaction = entityManager.getTransaction();
    try {
      entityTransaction.begin();
      Client newClient = new Client();
      clientMapper.registeredClientIntoClient(newClient, registeredClient);
      entityManager.persist(clientMapper);
      entityTransaction.commit();
    }catch (Exception e){
      entityTransaction.rollback();
    }

  }

  @Override
  public RegisteredClient findById(String id) {
    Client foundClient = entityManager.find(Client.class, Long.valueOf(id));
    return clientMapper.clientIntoRegisteredClient(foundClient);
  }

  @Override
  public RegisteredClient findByClientId(String clientId) {
    TypedQuery<Client> entityManagerQuery = entityManager.createQuery("select c from clients c where c.clientId = :clientId", Client.class);
    entityManagerQuery.setParameter("clientId", clientId);
    Client clientSingleResult = entityManagerQuery.getSingleResult();
    return clientMapper.clientIntoRegisteredClient(clientSingleResult);
  }
}
