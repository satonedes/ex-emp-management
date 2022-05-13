package jp.co.sample.domain;

public class Administrator {
	public Integer id;
	public String name;
	public String mailAddress;
	public String password;
	
	public Administrator(){}
	
	public Administrator(Integer id, String name, String mail, String password){
		this.id = id;
		this.name = name;
		this.mailAddress = mail;
		this.password = password;
	}

	@Override
	public String toString() {
		return "Administrator [id=" + id + ", name=" + name + ", mail=" + mailAddress + ", password=" + password + "]";
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMail() {
		return mailAddress;
	}

	public void setMail(String mail) {
		this.mailAddress = mail;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
