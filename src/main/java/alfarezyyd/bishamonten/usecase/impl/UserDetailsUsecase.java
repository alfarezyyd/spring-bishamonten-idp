package alfarezyyd.bishamonten.usecase.impl;

import alfarezyyd.bishamonten.configuration.SecurityUser;
import alfarezyyd.bishamonten.entity.User;
import alfarezyyd.bishamonten.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsUsecase implements UserDetailsService {
  private final UserRepository userRepository;

  public UserDetailsUsecase(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    User user = userRepository.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException("username not found"));
    return new SecurityUser(user);
  }
}
