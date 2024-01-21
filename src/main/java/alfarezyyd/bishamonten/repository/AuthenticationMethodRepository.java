package alfarezyyd.bishamonten.repository;

import alfarezyyd.bishamonten.entity.AuthenticationMethod;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthenticationMethodRepository extends JpaRepository<AuthenticationMethod, Short> {
}
