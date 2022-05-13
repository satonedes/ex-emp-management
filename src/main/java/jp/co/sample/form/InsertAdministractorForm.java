package jp.co.sample.form;

public class InsertAdministractorForm {
	public String name;
	public String mail;
	public String password;
	@Override
	public String toString() {
		return "InsertAdministractorForm [name=" + name + ", mail=" + mail + ", password=" + password + "]";
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

}
