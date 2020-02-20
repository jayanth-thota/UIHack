package my.spring.project.pojos;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="user")
public class User {
	@Id
	 private int id;
	  private String userName;
	 
	private String password;
	  private String userType;
	  private String email;
	  private int contact;
	  private String confirmed;
	  @Override
	public String toString() {
		return "User [id=" + id + ", username=" + userName + ", password=" + password + ", userType=" + userType
				+ ", email=" + email + ", contact=" + contact + ", confirmed=" + confirmed + "]";
	}
	
	 
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	 public String getUserName() {
			return userName;
		}


		public void setUserName(String username) {
			this.userName = username;
		}
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUserType() {
		return userType;
	}
	public void setUserType(String userType) {
		this.userType = userType;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getContact() {
		return contact;
	}
	public void setContact(int contact) {
		this.contact = contact;
	}
	public String getConformed() {
		return confirmed;
	}
	public void setConformed(String conformed) {
		this.confirmed = conformed;
	}
}
