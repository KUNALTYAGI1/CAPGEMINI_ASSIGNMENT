package springcore_assignment1;

public class Customer {
	private Address address;
	private String customerId;
	private String customerName;
	private String customerContact;
	private String customerAddress;
	
	
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public String getCustomerId() {
		return customerId;
	}
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getCustomerContact() {
		return customerContact;
	}
	public void setCustomerContact(String customerContact) {
		this.customerContact = customerContact;
	}
	public String getCustomerAddress() {
		return customerAddress;
	}
	public void setCustomerAddress(String customerAddress) {
		this.customerAddress = customerAddress;
	}
	
	public void details() {
		System.out.println("City: "+getAddress().getCity()+", Country: "+getAddress().getCountry()+", State "+getAddress().getState()
				+", Customer ID: "+getCustomerId());
	}
	
	

}

