package alfarezyyd.bishamonten.entity;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "token_settings")
@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
public class TokenSetting {
  @Id
  private Long id;
  @Column(name = "authorization_code_ttl")
  private Short authorizationCodeTtl;
  @Column(name = "access_token_ttl")
  private Short accessTokenTtl;
  @Column(name = "access_token_format")
  private String accessTokenFormat;
  @Column(name = "device_code_ttl")
  private Short deviceCodeTtl;
  @Column(name = "reuse_refresh_token")
  private Boolean reuseRefreshToken;
  @Column(name = "refresh_token_ttl")
  private Short refreshTokenTtl;
  @Column(name = "id_token_signature_algorithm")
  private String idTokenSignatureAlgorithm;
  @OneToOne
  @JoinColumn(name = "client_id", referencedColumnName = "id")
  private Client client;
}
