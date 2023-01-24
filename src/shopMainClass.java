import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;



import java.util.Scanner;

public class shopMainClass {

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		LocalDateTime now = LocalDateTime.now();
		
		 int ShopSettings=Reporting.getProgramStatisticsReport().getShopSettings();
		 int ManageShopItems=Reporting.getProgramStatisticsReport().getManageShopItems();
		 int createInvoice =Reporting.getProgramStatisticsReport().getCreateInvoice();
		 int staticsreport=Reporting.getProgramStatisticsReport().getStaticsreport();
		 int  AllInvoicesreport=Reporting.getProgramStatisticsReport().getAllInvoicesreport();
		 int  showProgramStatistics=Reporting.getProgramStatisticsReport().getShowProgramStatistics();//
	
		 ProgramStatistics ps =new ProgramStatistics();
		Scanner scan = new Scanner(System.in);
		Menu menu = new Menu();
		int itemCount = Math.toIntExact(Reporting.countItemsFiles()) ;;
		int inoviceCount =Math.toIntExact(Reporting.countInvoiceFiles()) ;
		HashMap<Integer, Product> listOfItems = new HashMap<>();
		HashMap<Integer, Invoice> mapOfInvoices = new HashMap<>();
		
		Shop shop= new Shop();
		boolean programFlag = true;
		System.out.println("\t\tstarting of shop program");
		System.out.println(
				"chose one of the follwing :\n  a) Shop Settings\n  b) Manage Shop Items  \n  c)"
				+ " create Invoice \n  d) create items/invoices statics report \n  e) create All Invoices report \n  f) show Program Statistics \n  x) exit ");
		while (programFlag) {

			String MainMenuResponce = scan.nextLine().toLowerCase();

			switch (MainMenuResponce) {
			case "a":
				
				boolean settingFlag = true;
				while (settingFlag) {
					ShopSettings++;
					System.out.println("chose from the Shop Settings :\n a. Load Data (Items and invoices)\n"
							+ " b. Set Shop Name\n" + " c. Set Invoice Header (Tel / Fax / Email / Website)\n"+ " d. search Invoice\n" 
							+ " f. Go Back\r");
					String subMenuResponce = scan.nextLine().toLowerCase();

					switch (subMenuResponce) {

					case "a":
						System.out.println("\tLoad Data (Items)");
						for(Long i=(long) 1;i<=Reporting.countItemsFiles();i++) {
							
							Product p=Reporting.getitemsReport(i.toString());
							
							System.out.println("\n\nItem Id: " + p.getItemID() + "\n\tItem Name: "
								+ p.getItemName() + "\n\tItem price: "
									+ p.getUnitPrice()+"\n");

					}
						
						
						
						
						System.out.println("\t-------------------------------\n");
						System.out.println("\tLoad Data (invoices)\n");
				
	for(Long i=(long) 1;i<=Reporting.countInvoiceFiles();i++) {
							
		Invoice p=Reporting.getInvoicesReport(i.toString());
							
							System.out.println("Invoice Id: " + p.getInvoiceId() + "\n\tcustomer Name: "
								+ p.getCustomerFullName()+ "\n\tInvoice date "
									+ p.getInvoiceDate()+"\n");

					}
	System.out.println("\t-------------------------------\n");
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

					
							System.out.println("pls enter the inovise id you want to show :");
						
							Invoice invoiceObj =	Reporting.getInvoicesReport(scan.nextLine());;
					
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
					ManageShopItems++;
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
						System.out.println(product.getItemName());
					
						scan.nextLine();
						Reporting.creatItemsReport(product);
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
for(Long i=(long) 1;i<=Reporting.countItemsFiles();i++) {
							
							Product p=Reporting.getitemsReport(i.toString());
							
							System.out.println("\n\nItem Id: " + p.getItemID() + "\n\tItem Name: "
								+ p.getItemName() + "\n\tItem price: "
									+ p.getUnitPrice()+"\n");

					
						
						}





						System.out.println("what is the item id");
						Integer id = scan.nextInt();
						System.out.println("what is the new item unit price");
						float price = scan.nextFloat();
						
						
						Product pp = new Product();

						pp.setItemID(itemCount);
						Product theSelctetitem =Reporting.getitemsReport(id.toString());
						pp.setItemID(id);
						pp.setItemName(theSelctetitem.getItemName());
						
						pp.setUnitPrice(price);
				
						pp.setQuantity(theSelctetitem.getQuantity());
						
						
						pp.setQtyAmount(theSelctetitem.getQtyAmount());
						
						
						
						Reporting.creatItemsReport(pp);
//						
//						menu.getListOfItems().get(id).setUnitPrice(price);
					scan.nextLine();
						break;
					case "d":
						System.out.println("Report All Items");

	for(Long i=(long) 1;i<=Reporting.countItemsFiles();i++) {
							
							Product p=Reporting.getitemsReport(i.toString());
							
							System.out.println("\n\nItem Id: " + p.getItemID() + "\n\tItem Name: "
								+ p.getItemName() + "\n\tItem price: "
									+ p.getUnitPrice()+"\n");

					
						
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
				createInvoice++;
				inoviceCount++;
				int totalAmount = 0;
				Invoice invoice = new Invoice();
				boolean purchaseFlag = true;
				ArrayList<Product> listOfPurchaseItems = new ArrayList<>();
				System.out.println("enter the item id , customer purchase from below list of items ");
				for(Long i=(long) 1;i<=Reporting.countItemsFiles();i++) {
					
					Product p=Reporting.getitemsReport(i.toString());
					
					System.out.println("\n\nItem Id: " + p.getItemID() + "\n\tItem Name: "
						+ p.getItemName() + "\n\tItem price: "
							+ p.getUnitPrice()+"\n");

			}
				
				while (purchaseFlag) {
					listOfPurchaseItems.add(Reporting.getitemsReport(scan.nextLine()));
				
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
				staticsreport++;
			int TotalSales=0;
			
				for(Long i=(long) 1;i<=Reporting.countInvoiceFiles();i++) {
					
					Invoice p=Reporting.getInvoicesReport(i.toString());
					
					TotalSales+=p.getTotalAmount();
			
					}
				Reporting.createStatisticsReport("No Of Items\t:" +Reporting.countItemsFiles()+ "\nNo of Invoices\t:" +Reporting.countInvoiceFiles()+ "\nTotal Sales\t:"+
						TotalSales);
				System.out.println("file created succefully");
				break;

			case "e":
				AllInvoicesreport++;
				String whatToWrite="";
				for(Long i=(long) 1;i<=Reporting.countInvoiceFiles();i++) {
					
					Invoice p=Reporting.getInvoicesReport(i.toString());
					
					whatToWrite+=("\nInvoice Id: " + p.getInvoiceId() + "\n\tcustomer Name: "
							+ p.getCustomerFullName()+ "\n\tInvoice date "
							+ p.getInvoiceDate()+ "\n\tBalance "
									+ p.getBalance()+"\n------------------------------\n\n"
			);
					}
				Reporting.createAllInvoiceReport(whatToWrite
			);
				System.out.println("file created succefully");
				break;

			case "f":
				showProgramStatistics++;
					ps.setAllInvoicesreport(AllInvoicesreport);
				ps.setCreateInvoice(createInvoice);
				ps.setManageShopItems(ManageShopItems);
				ps.setShopSettings(ShopSettings);
				ps.setStaticsreport(staticsreport);
				ps.setShowProgramStatistics(showProgramStatistics);
			Reporting.createProgramStatisticsReport(ps);
			
			System.out.println(
				"\n\t\tthe program statics\n\nShop Settings\t:"+Reporting.getProgramStatisticsReport().getShopSettings()
			+  "\nManage Shop Items\t:"+Reporting.getProgramStatisticsReport().getManageShopItems()
			+  "\ncreate Invoice\t:"+Reporting.getProgramStatisticsReport().getCreateInvoice()
			+"\nreate items/invoices statics report\t:"+Reporting.getProgramStatisticsReport().getStaticsreport()
			+"\ncreate All Invoices report\t:"+Reporting.getProgramStatisticsReport().getAllInvoicesreport()
			+"\nshow Program Statistics\t:"+Reporting.getProgramStatisticsReport().getShowProgramStatistics()+"\n");
				
			break;
			case "x":
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
					"chose one of the follwing :\n  a) Shop Settings\n  b) Manage Shop Items  \n  c)"
					+ " create Invoice \n  d) create items/invoices statics report \n  e) create All Invoices report \n  f) show Program Statistics \n  x) exit ");

		}
	}

}
