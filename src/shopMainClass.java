import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

public class shopMainClass {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		Menu menu = new Menu();
		boolean programFlag=true;
		System.out.println("\t\tstarting of shop program");
		System.out.println("chose one of the follwing :\n  a) Shop Settings\n  b) Manage Shop Items  \n  c) create Invoice \n  d) exit ");
		while(programFlag) {
			int itemCount=0;
			int inoviceCount=0;
			
			 HashMap<Integer, Product> listOfItems =new HashMap<>();	
			
			
			
			
			

			String MainMenuResponce = scan.nextLine().toLowerCase();
			switch( MainMenuResponce ) {
			case "a":
				boolean settingFlag=true;	
				while(settingFlag) {
					System.out.println("chose from the Shop Settings :\n a. Load Data (Items and invoices)\n"
							+ " b. Set Shop Name\n"
							+ " c. Set Invoice Header (Tel / Fax / Email / Website)\n"
							+ " d. Go Back\r"
							);
					String subMenuResponce = scan.nextLine().toLowerCase();
					
					switch( subMenuResponce )
					{
					
					case "a":
						System.out.println("Load Data (Items and invoices)");
						settingFlag=true;
						 break;
					case "b":
						System.out.println("Set Shop Name");
						settingFlag=true;
						 break;
					case "c":
						System.out.println("Set Invoice Header (Tel / Fax / Email / Website)");
						settingFlag=true;
						 break;
					case "d":

						settingFlag=false;
					 break;
					}
					}
				 break;
			case "b":
				
				boolean itemsFlag=true;	
				while(itemsFlag) {
					System.out.println("chose from the Shop Settings :\n a. Add Items \n"
							+ " b. Delete Items\n"
							+ " c. Change Item Price\n"
							+ " d. Report All Items\n"
							+ " f. go Back"
							);
					String subMenuResponce = scan.nextLine().toLowerCase();
					 
					switch( subMenuResponce )
					{
					
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
						for(Entry<Integer, Product> entry : menu.getListOfItems().entrySet()) {
							System.out.println("Item Id: " +entry.getKey() + ", Item Name: "+entry.getValue().getItemName());
							
						}
						listOfItems.remove(scan.nextInt());
						scan.nextLine();
					
						 break;
					case "c":
						System.out.println("which item you want to change it is price from below list ");
						for(Entry<Integer, Product> entry : menu.getListOfItems().entrySet()) {
							System.out.println("Item Id: " +entry.getKey() + ", Item price: "+entry.getValue().getUnitPrice());
							
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
						System.out.println( menu.getListOfItems());
					for(Entry<Integer, Product> entry : menu.getListOfItems().entrySet()) {
						System.out.println("\n\nItem Id: " +entry.getKey() + "\n\tItem Name: "+entry.getValue().getItemName()
								 + "\n\tItem price: "+entry.getValue().getUnitPrice());
						
						
					}
						 break;
					case "f":

						itemsFlag=false;
					 break;
					}
					menu.setListOfItems(listOfItems);
					}
				
				 break;
			case "c":
				System.out.println("creating incvois ");
				 break;
				 
			case "d":
				System.out.println("Are you sure you want to exit? yes/no");
				if( scan.nextLine().toLowerCase().equals("no")) {
					System.out.println("\t\tstarting of shop program");
				}
				else if( scan.nextLine().toLowerCase().equals("yes")) {
					System.out.println("Exit the shop program");
				 programFlag=false;
				
				}
				 break;
			}
		

			
			System.out.println("chose one of the follwing :\n  a) Shop Settings\n  b) Manage Shop Items  \n  c) create Invoice \n  d) exit ");
		
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			}
		}

	}


