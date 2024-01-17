package alfarezyyd.bishamonten.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.LinkedList;

@Entity(name = "scopes")
@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
public class Scope {
  @Id
  private Short id;
  private String name;
  @ManyToMany(mappedBy = "scopes")
  private LinkedList<Client> clients;
}
