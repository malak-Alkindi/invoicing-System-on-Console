import java.util.Scanner;

public class shopMainClass {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		Menu menu = new Menu();
		boolean programFlag=true;
		System.out.println("\t\tstarting of shop program");
		while(programFlag) {
			
			
			
			
			
			
			
			
			System.out.println("chose one of the follwing :\n  a) Shop Settings\n  b) Manage Shop Items");
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
						System.out.println("Add Items");
						itemsFlag=true;
						 break;
					case "b":
						System.out.println("Delete Items");
						settingFlag=true;
						 break;
					case "c":
						System.out.println("Change Item Price");
						settingFlag=true;
						 break;
					case "d":
						System.out.println("Report All Items");
						settingFlag=true;
						 break;
					case "f":

						itemsFlag=false;
					 break;
					}
					}
				 break;
			}
		
				
			
			System.out.println("Are you sure you want to exit? yes/No");
		
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			if( scan.nextLine().toLowerCase().equals("no")) {
				System.out.println("\t\tstarting of shop program");
			}
			else if( scan.nextLine().toLowerCase().equals("yes")) {
				System.out.println("Exit the shop program");
			 programFlag=false;
			
			}
		
		}

	}

}
