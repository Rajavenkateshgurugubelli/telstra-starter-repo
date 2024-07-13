package au.com.telstra.simcardactivator;

public class User {

	private String iccid;

	private String customerEmail;

	public String getIccid() {
		return iccid;
	}

	public void setIccid(String iccid) {
		this.iccid = iccid;
	}

	public String getCustomerEmail() {
		return customerEmail;
	}

	public void setCustomerEmail(String customerEmail) {
		this.customerEmail = customerEmail;
	}

	public User(String iccid, String customerEmail) {
		this.iccid = iccid;
		this.customerEmail = customerEmail;
	}

}
