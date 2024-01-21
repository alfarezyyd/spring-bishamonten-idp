package alfarezyyd.bishamonten.usecase.impl;

import alfarezyyd.bishamonten.dto.client.ClientCreateRequest;
import alfarezyyd.bishamonten.mapper.ClientMapper;
import alfarezyyd.bishamonten.repository.CustomRegisteredClientRepository;
import alfarezyyd.bishamonten.usecase.ClientUsecase;
import alfarezyyd.bishamonten.util.ValidationUtil;
import org.springframework.security.oauth2.server.authorization.client.RegisteredClient;
import org.springframework.stereotype.Service;

@Service
public class ClientUsecaseImpl implements ClientUsecase {
  private final CustomRegisteredClientRepository customRegisteredClientRepository;

  private final ValidationUtil validationUtil;
  private final ClientMapper clientMapper;

  public ClientUsecaseImpl(CustomRegisteredClientRepository customRegisteredClientRepository, ValidationUtil validationUtil, ClientMapper clientMapper) {
    this.customRegisteredClientRepository = customRegisteredClientRepository;
    this.validationUtil = validationUtil;
    this.clientMapper = clientMapper;
  }

  @Override
  public void create(ClientCreateRequest clientCreateRequest) {
    validationUtil.validateRequestObject(clientCreateRequest);
    RegisteredClient registeredClient = clientMapper.clientDtoIntoRegisteredClient(clientCreateRequest);
    customRegisteredClientRepository.save(registeredClient);
  }
}
