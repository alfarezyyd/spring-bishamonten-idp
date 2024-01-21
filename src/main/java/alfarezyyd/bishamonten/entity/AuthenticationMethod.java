package alfarezyyd.bishamonten.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import lombok.*;

import java.util.LinkedList;

@Entity(name = "authentication_methods")
@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
public class AuthenticationMethod {
  @Id
  private Short id;
  private String name;
  @ManyToMany(mappedBy = "clientAuthenticationMethods")
  private LinkedList<Client> clients;
}
