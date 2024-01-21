package alfarezyyd.bishamonten.entity;


import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "redirect_uris")
@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
public class RedirectUri {
  @Id
  private Short id;
  private String name;
  @ManyToOne
  @JoinColumn(name = "client_id", referencedColumnName = "id")
  private Client client;
}
