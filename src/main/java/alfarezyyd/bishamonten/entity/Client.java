package alfarezyyd.bishamonten.entity;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;
import java.util.LinkedList;

@Entity(name = "clients")
@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
public class Client {
  @Id
  private Long id;
  @Column(name = "client_id")
  private String clientId;
  @Column(name = "client_id_issued_at")
  private Timestamp clientIdIssuedAt;
  @Column(name = "client_secret")
  private String clientSecret;
  @Column(name = "client_secret_expires_at")
  private Timestamp clientSecretExpiresAt;
  @Column(name = "client_name")
  private String clientName;
  @ManyToMany(fetch = FetchType.EAGER)
  @JoinTable(name = "clients_authentication_methods",
      joinColumns = @JoinColumn(name = "client_id", referencedColumnName = "id"),
      inverseJoinColumns = @JoinColumn(name = "authentication_method_id", referencedColumnName = "id"))
  private LinkedList<AuthenticationMethod> clientAuthenticationMethods;
  @ManyToMany(fetch = FetchType.EAGER)
  @JoinTable(name = "clients_grant_types",
      joinColumns = @JoinColumn(name = "client_id", referencedColumnName = "id"),
      inverseJoinColumns = @JoinColumn(name = "grant_type_id", referencedColumnName = "id"))
  private LinkedList<GrantType> authorizationGrantTypes;
  @OneToMany(mappedBy = "client", fetch = FetchType.EAGER)
  private LinkedList<RedirectUri> redirectUris;
  @OneToMany(mappedBy = "client", fetch = FetchType.EAGER)
  private LinkedList<PostLogoutRedirectUri> postLogoutRedirectUris;
  @ManyToMany(fetch = FetchType.EAGER)
  @JoinTable(name = "clients_scopes",
      joinColumns = @JoinColumn(name = "client_id", referencedColumnName = "id"),
      inverseJoinColumns = @JoinColumn(name = "scope_id", referencedColumnName = "id"))
  private LinkedList<Scope> scopes;
  @OneToOne(mappedBy = "client", fetch = FetchType.EAGER)
  private ClientSetting clientSettings;
  @OneToOne(mappedBy = "client", fetch = FetchType.EAGER)
  private TokenSetting tokenSettings;
}
