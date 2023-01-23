
public class Invoice {
	


	
	private	String customerFullName; 
	private Integer phoneNumber;
	private	Integer invoiceDate;
	private	Integer numberOfItems;
	private	Integer totalAmount ;
	private	Integer paidAmount;
	private	Integer balance;
	
	public String getCustomerFullName() {
		return customerFullName;
	}
	
	public void setCustomerFullName(String customerFullName) {
		this.customerFullName = customerFullName;
	}
	
	public Integer getPhoneNumber() {
		return phoneNumber;
	}
	
	public void setPhoneNumber(Integer phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	public Integer getInvoiceDate() {
		return invoiceDate;
	}
	
	public void setInvoiceDate(Integer invoiceDate) {
		this.invoiceDate = invoiceDate;
	}
	
	public Integer getNumberOfItems() {
		return numberOfItems;
	}
	
	public void setNumberOfItems(Integer numberOfItems) {
		this.numberOfItems = numberOfItems;
	}
	
	public Integer getTotalAmount() {
		return totalAmount;
	}
	
	public void setTotalAmount(Integer totalAmount) {
		this.totalAmount = totalAmount;
	}
	
	public Integer getPaidAmount() {
		return paidAmount;
	}

	public void setPaidAmount(Integer paidAmount) {
		this.paidAmount = paidAmount;
	}
	
	public Integer getBalance() {
		return balance;
	}
	
	public void setBalance(Integer balance) {
		this.balance = balance;
	}
	
	
	
}
