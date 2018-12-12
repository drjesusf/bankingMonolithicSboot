package banking.ads.domain.users.entities;

import java.util.List;
import java.util.Set;

/*import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;*/
import javax.validation.constraints.Size;

import banking.ads.security.Role;


//@Entity
public class User {

  //@Id
  //@GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  //@Size(min = 4, max = 255, message = "Minimum username length: 4 characters")
  //@Column(unique = true, nullable = false)
  private String userName;

  //@Column(unique = true, nullable = false)
  private String email;

  //@Size(min = 8, message = "Minimum password length: 8 characters")
  private String password;

  //@ElementCollection(fetch = FetchType.EAGER)
  List<Role> roles;
  
  private Set<UserClaim> claims;

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public List<Role> getRoles() {
    return roles;
  }

  public void setRoles(List<Role> roles) {
    this.roles = roles;
  }

public String getUserName() {
	return userName;
}

public void setUserName(String userName) {
	this.userName = userName;
}

public Set<UserClaim> getClaims() {
	return claims;
}

public void setClaims(Set<UserClaim> claims) {
	this.claims = claims;
}

}
