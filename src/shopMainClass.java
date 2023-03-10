
import java.io.IOException;
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

	
		Reporting.createFoldersReport("invoiceReport");
		Reporting.createFoldersReport("itemsReport");
		String[] invoiceMenuArray= {"chose from the Shop Settings","a. Load Data (Items and invoices)",
				 "b. Set Shop Name" , "c. Set Invoice Header(Tel / Fax / Email / Website)"
				,"d. search Invoice" , "f. Go Back"};

		String[] itemMenuArray = {"chose from the Shop Settings","a. Add Items" , "b. Delete Items", "c. Change Item Price" , "d. Report All Items", "f. go Back"};
		
		String[] mainMenuArray= {"chose one of the follwing","a) Shop Settings",  "b) Manage Shop Items",  "c) create Invoice" ,"d) create items/invoices statics report",
				"e) create All Invoices report" , "f) show Program Statistics","x) exit "};
		
		Integer shopSettings;
		Integer manageShopItems;
		Integer createInvoice;
		Integer staticsreport;
		Integer allInvoicesreport;
		Integer showProgramStatistics;
		
	
		try {
			shopSettings = Reporting.getProgramStatisticsReport().getShopSettings();
			manageShopItems = Reporting.getProgramStatisticsReport().getManageShopItems();
			createInvoice = Reporting.getProgramStatisticsReport().getCreateInvoice();
			staticsreport = Reporting.getProgramStatisticsReport().getStaticsreport();
			allInvoicesreport = Reporting.getProgramStatisticsReport().getAllInvoicesreport();
			showProgramStatistics = Reporting.getProgramStatisticsReport().getShowProgramStatistics();//
		} catch (Exception error) {
			shopSettings = 0;
			manageShopItems = 0;
			createInvoice = 0;
			staticsreport = 0;
			allInvoicesreport = 0;
			showProgramStatistics = 0;
			error.getMessage();
		}
		ProgramStatistics ps = new ProgramStatistics();
		try (Scanner scan = new Scanner(System.in)) {
			Menu menu = new Menu();
			int itemCount = Math.toIntExact(Reporting.countItemsFiles());
			;
			int inoviceCount = Math.toIntExact(Reporting.countInvoiceFiles());
			Map<Integer, Product> listOfItems = new HashMap<>();
			Map<Integer, Invoice> mapOfInvoices = new HashMap<>();

			Shop shop = new Shop();
			boolean programFlag = true;
			System.out.println("\t\tstarting of shop program");
		menu.setListOfItems(mainMenuArray);
			while (programFlag) {

				String MainMenuResponce = scan.nextLine().toLowerCase();

				switch (MainMenuResponce) {
				case "a":

					boolean settingFlag = true;
					while (settingFlag) {
						shopSettings++;
						menu.setListOfItems(invoiceMenuArray);
			
						String subMenuResponce = scan.nextLine().toLowerCase();

						switch (subMenuResponce) {

						case "a":
							if (Reporting.countItemsFiles() > 0) {
								System.out.println("\tLoad Data (Items)");
								for (Long i = (long) 1; i <= Reporting.countItemsFiles(); i++) {

									Product p = Reporting.getitemsReport(i.toString());

									System.out.println("\n\nItem Id: " + p.getItemID() + "\n\tItem Name: "
											+ p.getItemName() + "\n\tItem price: " + p.getUnitPrice() + "\n");

								}
							}

							else {
								System.out.println("\tno items added");
							}

							System.out.println("\t-------------------------------\n");

							if (Reporting.countInvoiceFiles() > 0) {
								System.out.println("\tLoad Data (invoices)\n" + Reporting.countInvoiceFiles());

								for (Long i = (long) 1; i <= Reporting.countInvoiceFiles(); i++) {

									Invoice p = Reporting.getInvoicesReport(i.toString());

									System.out.println("Invoice Id: " + p.getInvoiceId() + "\n\tcustomer Name: "
											+ p.getCustomerFullName() + "\n\tInvoice date " + p.getInvoiceDate()
											+ "\n");
								}
							} else {
								System.out.println("\tno invoices added");
							}

							System.out.println("\t-------------------------------\n");
							break;
						case "b":
							System.out.println("pls enter Shop Name");
							shop.setName(scan.nextLine());
							Reporting.creatShopInfoFile(shop);

							break;
						case "c":
							System.out.println("Set Invoice Header (Tel / Fax / Email / Website)");
							System.out.println("pls enter Tel ");
							shop.setTel(scan.nextLine());
							
							System.out.println("pls enter Fax ");
							shop.setFax(scan.nextLine());
							System.out.println("pls enter Email ");
							shop.setEmail(scan.nextLine());
							System.out.println("pls enter Website ");
							shop.setWebsite(scan.nextLine());
							Reporting.creatShopInfoFile(shop);
							break;

						case "d":

							if (Reporting.countInvoiceFiles() > 0) {
								System.out.println("pls enter the inovise id you want to show :");

								Invoice invoiceObj = Reporting.getInvoicesReport(scan.nextLine());
								;

								System.out.println("customer Full Name\t:" + invoiceObj.getCustomerFullName());
								System.out.println("phone Number\t:" + invoiceObj.getPhoneNumber());
								System.out.println("invoice Date\t:" + invoiceObj.getInvoiceDate());
								System.out.println("number Of Items\t:" + invoiceObj.getNumberOfItems());
								System.out.println("total Amount\t:" + invoiceObj.getTotalAmount());
								System.out.println("paid Amount\t:" + invoiceObj.getPaidAmount());
								System.out.println("balance\t:" + invoiceObj.getBalance() + "\n");

								System.out.println("\t\t<items purches>");
								for (Product p : invoiceObj.getlistOfPurchaseItems()) {
									System.out.println("\titem id\t:" + p.getItemID());
									System.out.println("\titem name\t:" + p.getItemName());
									System.out.println("\titem unit price\t:" + p.getUnitPrice());
									System.out.println("\titem quantity\t:" + p.getQuantity());
									System.out.println("\titem qty amount\t:" + p.getQtyAmount() + "\n");
								}
							} else {
								System.out.println("\tno invoices added to search between\n");
							}

							break;

						case "f":

							settingFlag = false;
							break;
						}
					}
					break;
				case "b":
					manageShopItems++;
					boolean itemsFlag = true;
					while (itemsFlag) {

						menu.setListOfItems(itemMenuArray);
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
							if (menu.getListOfItems() != null) {
								if (menu.getListOfItems().size() > 0) {
									System.out.println(
											"Delete Items from the new items list : \nenter the item id you want to delete from below list\n ");
									for (Entry<Integer, Product> entry : menu.getListOfItems().entrySet()) {
										System.out.println("Item Id: " + entry.getKey() + ", Item Name: "
												+ entry.getValue().getItemName());

									}
									try {
										if (listOfItems.remove(scan.nextInt()) != null) {
											scan.nextLine();
										} else {
											System.out.println("\nno items with this id currently added\n");
										}

									} catch (Exception error) {
										System.out.println("\nno items with this id currently added\n");
										scan.nextLine();
									}
								} else {
									System.out.println("\n\tno new items added to be deleted\n");
								}
							} else {
								System.out.println("\n\tno new items added to be deleted\n");
							}
							break;
						case "c":
							if (Reporting.countItemsFiles() > 0) {
								System.out.println("which item you want to change it is price from below list ");
								for (Long i = (long) 1; i <= Reporting.countItemsFiles(); i++) {

									Product p = Reporting.getitemsReport(i.toString());

									System.out.println("\n\nItem Id: " + p.getItemID() + "\n\tItem Name: "
											+ p.getItemName() + "\n\tItem price: " + p.getUnitPrice() + "\n");

								}

								System.out.println("what is the item id");
								Integer id = 0;
								id = scan.nextInt();

								if (Reporting.getitemsReport(id.toString()) != null) {

									System.out.println("what is the new item unit price");
									float price = scan.nextFloat();

									Product pp = new Product();

									pp.setItemID(itemCount);
									Product theSelctetitem = Reporting.getitemsReport(id.toString());
									pp.setItemID(id);
									pp.setItemName(theSelctetitem.getItemName());

									pp.setUnitPrice(price);

									pp.setQuantity(theSelctetitem.getQuantity());

									pp.setQtyAmount(theSelctetitem.getQtyAmount());

									Reporting.creatItemsReport(pp);
									scan.nextLine();
								} else {
									System.out.println("\n\tno items added with this id\n");
								}
							} else {
								System.out.println("\n\tno items added\n");
							}
							break;
						case "d":
							System.out.println("Report All Items");

							for (Long i = (long) 1; i <= Reporting.countItemsFiles(); i++) {

								Product p = Reporting.getitemsReport(i.toString());

								System.out.println("\n\nItem Id: " + p.getItemID() + "\n\tItem Name: " + p.getItemName()
										+ "\n\tItem price: " + p.getUnitPrice() + "\n");

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
					for (Long i = (long) 1; i <= Reporting.countItemsFiles(); i++) {

						Product p = Reporting.getitemsReport(i.toString());

						System.out.println("\n\nItem Id: " + p.getItemID() + "\n\tItem Name: " + p.getItemName()
								+ "\n\tItem price: " + p.getUnitPrice() + "\n");

					}

					while (purchaseFlag) {
						listOfPurchaseItems.add(Reporting.getitemsReport(scan.nextLine()));

						System.out.println("do you want to add another purchase? yes/no");
						if (scan.nextLine().equals("no")) {
							for (Product p : listOfPurchaseItems) {
								totalAmount += p.getUnitPrice();
								System.out.println("the purches");
								System.out.println(p.getItemID() + " " + p.getItemName());
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
					System.out.println("what is the customer paid Amount ? total amount\t:" + totalAmount);
					int paidAmount = scan.nextInt();
					while (paidAmount < totalAmount) {

						System.out.println("the customer paid less Amount then the total amount\nleft to pay\t:"
								+ (totalAmount - paidAmount) + "\n ");
						paidAmount = scan.nextInt();
					}

					invoice.setPaidAmount(paidAmount);
					scan.nextLine();
					invoice.setBalance(invoice.getPaidAmount() - totalAmount);
					mapOfInvoices.put(inoviceCount, invoice);
					Reporting.createInvoiceReport(invoice);
					menu.setMapOfInvoices(mapOfInvoices);
					System.out.println("invoice created secufully");
					break;

				case "d":
					staticsreport++;
					int TotalSales = 0;

					for (Long i = (long) 1; i <= Reporting.countInvoiceFiles(); i++) {

						Invoice p = Reporting.getInvoicesReport(i.toString());

						TotalSales += p.getTotalAmount();

					}
					Reporting.createStatisticsReport("No Of Items\t:" + Reporting.countItemsFiles()
							+ "\nNo of Invoices\t:" + Reporting.countInvoiceFiles() + "\nTotal Sales\t:" + TotalSales);
					System.out.println("file created succefully");
					break;

				case "e":
					if (Reporting.countInvoiceFiles() > 0) {
						allInvoicesreport++;
						Shop s = Reporting.getShopInfoFile();
						String whatToWrite;
						try {
							whatToWrite = "\n\t\t" + s.getName() + "\n" + s.getEmail() + "\n" + s.getFax() + "\n"
									+ s.getWebsite() + "\n" + s.getTel() + "\n" + "\n";
						} catch (Exception error) {
							whatToWrite = "";
						}
						for (Long i = (long) 1; i <= Reporting.countInvoiceFiles(); i++) {

							Invoice p = Reporting.getInvoicesReport(i.toString());

							whatToWrite += ("\nInvoice Id: " + p.getInvoiceId() + "\n\tcustomer Name: "
									+ p.getCustomerFullName() + "\n\tInvoice date " + p.getInvoiceDate()
									+ "\n\tBalance " + p.getBalance() + "\n------------------------------\n\n");
						}
						Reporting.createAllInvoiceReport(whatToWrite);
						System.out.println("file created succefully");
					} else {
						System.out.println("invoices need to be added to create this file\n");
					}
					break;

				case "f":
					showProgramStatistics++;
					ps.setAllInvoicesreport(allInvoicesreport);
					ps.setCreateInvoice(createInvoice);

					ps.setManageShopItems(manageShopItems);
					ps.setShopSettings(shopSettings);
					ps.setStaticsreport(staticsreport);
					ps.setShowProgramStatistics(showProgramStatistics);
					Reporting.createProgramStatisticsReport(ps);

					System.out.println("\n\t\tthe program statics\n\nShop Settings\t:"
							+ Reporting.getProgramStatisticsReport().getShopSettings() + "\nManage Shop Items\t:"
							+ Reporting.getProgramStatisticsReport().getManageShopItems() + "\ncreate Invoice\t:"
							+ Reporting.getProgramStatisticsReport().getCreateInvoice()
							+ "\nreate items/invoices statics report\t:"
							+ Reporting.getProgramStatisticsReport().getStaticsreport()
							+ "\ncreate All Invoices report\t:"
							+ Reporting.getProgramStatisticsReport().getAllInvoicesreport()
							+ "\nshow Program Statistics\t:"
							+ Reporting.getProgramStatisticsReport().getShowProgramStatistics() + "\n");

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

				menu.setListOfItems(mainMenuArray);

			}
		} catch (Exception error) {

			System.out.println(error.getMessage());
		}

	}

}
