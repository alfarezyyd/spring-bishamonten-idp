package alfarezyyd.bishamonten.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.LinkedList;

@Entity(name = "grant_types")
@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
public class GrantType {
  @Id
  private Short id;
  private String name;
  @ManyToMany(mappedBy = "authorizationGrantTypes")
  private LinkedList<Client> clients;
}
