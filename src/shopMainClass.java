import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

public class shopMainClass {

	public static void main(String[] args) throws IOException {
		LocalDateTime now = LocalDateTime.now();

		Scanner scan = new Scanner(System.in);
		Menu menu = new Menu();
		int itemCount = 0;
		int inoviceCount = 0;
		HashMap<Integer, Product> listOfItems = new HashMap<>();
		HashMap<Integer, Invoice> mapOfInvoices = new HashMap<>();
		
		Shop shop= new Shop();
		boolean programFlag = true;
		System.out.println("\t\tstarting of shop program");
		System.out.println(
				"chose one of the follwing :\n  a) Shop Settings\n  b) Manage Shop Items  \n  c) create Invoice \n  d) exit ");
		while (programFlag) {

			String MainMenuResponce = scan.nextLine().toLowerCase();

			switch (MainMenuResponce) {
			case "a":
				boolean settingFlag = true;
				while (settingFlag) {
					System.out.println("chose from the Shop Settings :\n a. Load Data (Items and invoices)\n"
							+ " b. Set Shop Name\n" + " c. Set Invoice Header (Tel / Fax / Email / Website)\n"+ " d. search Invoice\n" 
							+ " f. Go Back\r");
					String subMenuResponce = scan.nextLine().toLowerCase();

					switch (subMenuResponce) {

					case "a":
						System.out.println("Load Data (Items)");
						if (menu.getMapOfInvoices() == null) {
							System.out.println("no items added"+"\n");
						} else {
							for (Entry<Integer, Product> entry : menu.getListOfItems().entrySet()) {
								System.out.println("\n\nItem Id: " + entry.getKey() + "\n\tItem Name: "
										+ entry.getValue().getItemName() + "\n\tItem price: "
										+ entry.getValue().getUnitPrice()+"\n");

							}
						}
						System.out.println("Load Data (invoices)");
				
						if (menu.getMapOfInvoices() == null) {
							System.out.println("no invoices added"+"\n");
						} else {
							for (Entry<Integer, Invoice> entry : menu.getMapOfInvoices().entrySet()) {
								System.out.println("\n\nItem Id: " + entry.getKey() + "\n\tItem Name: "
										+ entry.getValue().getCustomerFullName()+"\n");
								Reporting.createAllInvoiceReport("\t\t<"+entry.getKey().toString()+">\ninvoice date\t:"
										+entry.getValue().getInvoiceDate() +"\ncustomer Name\t: "
												+ entry.getValue().getCustomerFullName()
												 +"\nNo of items\t: "
													+ entry.getValue().getNumberOfItems()
													+"\nTotal\t: "
													+ entry.getValue().getTotalAmount()+"\nBalance\t: "
															+ entry.getValue().getBalance());
							}
							
						}
						break;
					case "b":
						System.out.println("pls enter Shop Name");
						shop.setName(scan.nextLine());
					
						break;
					case "c":
						System.out.println("Set Invoice Header (Tel / Fax / Email / Website)");
						System.out.println("pls enter Tel ");
						shop.setTel(scan.nextInt());
						System.out.println("pls enter Fax ");
						shop.setName(scan.nextLine());
						System.out.println("pls enter Email ");
						shop.setEmail(scan.nextLine());
						System.out.println("pls enter Website ");
						shop.setWebsite(scan.nextLine());
						break;
						
					case "d":

						if (menu.getMapOfInvoices() == null) {
							System.out.println("no invoices added"+"\n");
						} else {
							System.out.println("pls enter the inovise id you want to show :");
							
							Invoice invoiceObj =menu.getMapOfInvoices().get(scan.nextInt());
							scan.nextLine();
							System.out.println("customer Full Name\t:"+invoiceObj.getCustomerFullName());
							System.out.println("phone Number\t:"+invoiceObj.getPhoneNumber());
							System.out.println("invoice Date\t:"+invoiceObj.getInvoiceDate());
							System.out.println("number Of Items\t:"+invoiceObj.getNumberOfItems());
							System.out.println("total Amount\t:"+invoiceObj.getTotalAmount());
							System.out.println("paid Amount\t:"+invoiceObj.getPaidAmount());
							System.out.println("balance\t:"+invoiceObj.getBalance()+"\n");
							
							System.out.println("\t\t<items purches>");
							for(Product p :invoiceObj.getlistOfPurchaseItems()) {
								System.out.println("\titem id\t:"+p.getItemID());
								System.out.println("\titem name\t:"+p.getItemName());
								System.out.println("\titem unit price\t:"+p.getUnitPrice());
								System.out.println("\titem quantity\t:"+p.getQuantity());
							    System.out.println("\titem qty amount\t:"+p.getQtyAmount() +"\n");
							
							}
						}
					
						break;
					
					case "f":

						settingFlag = false;
						break;
					}
				}
				break;
			case "b":

				boolean itemsFlag = true;
				while (itemsFlag) {
					System.out.println("chose from the Shop Settings :\n a. Add Items \n" + " b. Delete Items\n"
							+ " c. Change Item Price\n" + " d. Report All Items\n" + " f. go Back");
					String subMenuResponce = scan.nextLine().toLowerCase();

					switch (subMenuResponce) {

					case "a":
						itemCount++;
						System.out.println("Add Items");
						Product product = new Product();

						product.setItemID(itemCount);

						System.out.println("what is the item name");
						product.setItemName(scan.nextLine());
						System.out.println("what is the item unit price");
						product.setUnitPrice(scan.nextFloat());
						System.out.println("what is the item quantity");
						product.setQuantity(scan.nextInt());
						scan.nextLine();
						System.out.println("what is the item qtyAmount");
						product.setQtyAmount(scan.nextInt());
						scan.nextLine();

						listOfItems.put(itemCount, product);

						break;
					case "b":
						System.out.println("Delete Items : enter the item id you want to delete from below list ");
						for (Entry<Integer, Product> entry : menu.getListOfItems().entrySet()) {
							System.out.println(
									"Item Id: " + entry.getKey() + ", Item Name: " + entry.getValue().getItemName());

						}
						listOfItems.remove(scan.nextInt());
						scan.nextLine();

						break;
					case "c":
						System.out.println("which item you want to change it is price from below list ");
						for (Entry<Integer, Product> entry : menu.getListOfItems().entrySet()) {
							System.out.println(
									"Item Id: " + entry.getKey() + ", Item price: " + entry.getValue().getUnitPrice());

						}
						System.out.println("what is the item id");
						int id = scan.nextInt();
						System.out.println("what is the new item unit price");
						float price = scan.nextFloat();
						menu.getListOfItems().get(id).setUnitPrice(price);
						scan.nextLine();
						break;
					case "d":
						System.out.println("Report All Items");

						for (Entry<Integer, Product> entry : menu.getListOfItems().entrySet()) {
							System.out.println("\n\nItem Id: " + entry.getKey() + "\n\tItem Name: "
									+ entry.getValue().getItemName() + "\n\tItem price: "
									+ entry.getValue().getUnitPrice()+"\n");

						}
						break;
					case "f":

						itemsFlag = false;
						break;
					}
					menu.setListOfItems(listOfItems);
				}

				break;
			case "c":
				inoviceCount++;
				int totalAmount = 0;
				Invoice invoice = new Invoice();
				boolean purchaseFlag = true;
				ArrayList<Product> listOfPurchaseItems = new ArrayList<>();
				System.out.println("enter the item id , customer purchase from below list of items ");
				for (Entry<Integer, Product> entry : menu.getListOfItems().entrySet()) {
					System.out.println("\n\nItem Id: " + entry.getKey() + "\n\tItem Name: "
							+ entry.getValue().getItemName() + "\n\tItem price: " + entry.getValue().getUnitPrice());

				}
				while (purchaseFlag) {

					listOfPurchaseItems.add(menu.getListOfItems().get(scan.nextInt()));
					scan.nextLine();
					System.out.println("do you want to add another purchase? yes/no");
					if (scan.nextLine().equals("no")) {
						for (Product p : listOfPurchaseItems) {
							totalAmount += p.getUnitPrice();
							System.out.println("the purches");
							System.out.println(p.getItemID());
						}
						purchaseFlag = false;
					} else {
						System.out.println("enter the item id , customer purchase from above list of items ");
					}

				}
				invoice.setInvoiceId(inoviceCount);
				invoice.setListOfPurchaseItems(listOfPurchaseItems);
				System.out.println("what is the customer Full Name ?");
				invoice.setCustomerFullName(scan.nextLine());
				System.out.println("what is the customer phone Number ?");
				invoice.setPhoneNumber(scan.nextInt());
				scan.nextLine();
				DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
				String formatDateTime = now.format(format);
				invoice.setInvoiceDate(formatDateTime);
				invoice.setNumberOfItems(listOfPurchaseItems.size());
				invoice.setTotalAmount(totalAmount);
				System.out.println("what is the customer paid Amount ?");
				invoice.setPaidAmount(scan.nextInt());
				scan.nextLine();
				invoice.setBalance(invoice.getPaidAmount() - totalAmount);
				mapOfInvoices.put(inoviceCount, invoice);
				Reporting.createInvoiceReport(invoice);
				menu.setMapOfInvoices(mapOfInvoices);
				break;

			case "d":
				System.out.println("Are you sure you want to exit? yes/no");
				if (scan.nextLine().toLowerCase().equals("no")) {
					System.out.println("\t\tstarting of shop program");
				} else if (scan.nextLine().toLowerCase().equals("yes")) {
					System.out.println("Exit the shop program");
			
					programFlag = false;

				}
				break;
			}
	

			System.out.println(
					"chose one of the follwing :\n  a) Shop Settings\n  b) Manage Shop Items  \n  c) create Invoice \n  d) exit ");

		}
	}

}
