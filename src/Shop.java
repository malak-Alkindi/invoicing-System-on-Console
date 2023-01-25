import java.io.Serializable;

public class Shop implements Serializable{
	
	private Integer Tel; 
	private	String Fax ;
	private	String Email ;
	private	String name; 

	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	private	String Website;
	
	public void setTel(Integer tel) {
		Tel = tel;
	}
	
	public void setFax(String fax) {
		Fax = fax;
	}
	
	public void setEmail(String email) {
		Email = email;
	}
	
	public void setWebsite(String website) {
		Website = website;
	}

	public Integer getTel() {
		return Tel;
	}
	
	public String getFax() {
		return Fax;
	}
	
	public String getEmail() {
		return Email;
	}
	
	public String getWebsite() {
		return Website;
	}
}
