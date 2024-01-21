package alfarezyyd.bishamonten.usecase.impl;

import alfarezyyd.bishamonten.dto.client.ClientCreateRequest;
import alfarezyyd.bishamonten.repository.CustomRegisteredClientRepository;
import alfarezyyd.bishamonten.usecase.ClientUsecase;

public class ClientUsecaseImpl implements ClientUsecase {
  private CustomRegisteredClientRepository customRegisteredClientRepository;

  @Override
  public void create(ClientCreateRequest clientCreateRequest) {

  }
}
