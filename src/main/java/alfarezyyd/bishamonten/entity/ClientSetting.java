package alfarezyyd.bishamonten.entity;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "client_settings")
@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
public class ClientSetting {
  @Id
  private Long id;
  @Column(name = "require_proof_key")
  private Boolean requireProofKey;
  @Column(name = "require_authorization_consent")
  private Boolean requireAuthorizationConsent;
  @Column(name = "jwk_set_url")
  private String jwkSetUrl;
  @Column(name = "token_endpoint_authentication_signing_algorithm")
  private String tokenEndpointAuthenticationSigningAlgorithm;
  @OneToOne
  @JoinColumn(name = "client_id", referencedColumnName = "id")
  private Client client;
}
