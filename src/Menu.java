import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

public class Menu implements Serializable {
	  HashMap<Integer, Invoice> mapOfInvoices ;
	  HashMap<Integer, Product> listOfItems  ;
	  
	
	

	public HashMap<Integer, Invoice> getMapOfInvoices() {
		return mapOfInvoices;
	}

	
	public void setMapOfInvoices(HashMap<Integer, Invoice> mapOfInvoices) {
		this.mapOfInvoices = mapOfInvoices;
	}


	public HashMap<Integer, Product> getListOfItems() {
		return listOfItems;
	}


	public void setListOfItems(HashMap<Integer, Product> listOfItems) {
		this.listOfItems = listOfItems;
	}

	// genral method : Shop Settings
	  void LoadData (){}
	  
	  // genral method :Manage Shop Items
	  void AddItems () {}
	  void DeleteItems (){}
	  void ChangeItemPrice (){}
	  void ReportAllItems  (){}

}
