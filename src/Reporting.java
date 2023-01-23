import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;



public class Reporting {
	static void  createInvoiceReport(Invoice i) {
	try {
		new File("invoiceReport").mkdirs();
	
		File oldFile = new File(i.getInvoiceId() +".txt");
		File newFile = new File("invoiceReport\\"+i.getInvoiceId() +".txt");
		FileOutputStream ff = new FileOutputStream(newFile);
		ObjectOutputStream o = new ObjectOutputStream(ff);

		// Write objects to file
		o.writeObject(i);

		o.close();
		ff.close();
}catch(Exception error) {
error.getMessage();
}


}
	
	static void  createAllInvoiceReport(String name) throws IOException {
		
		File file = new File("AllInvoiceReport.txt");
		FileWriter w = new FileWriter("AllInvoiceReport.txt");
		w.write("\t\tAllInvoiceReport");
		w.write(name);
		w.close();


}
	
static void  statics(String name) throws IOException {
		
		File file = new File("Statistics.txt");
		FileWriter w = new FileWriter("Statistics .txt");
		w.write("\t\tAllInvoiceReport");
		w.write(name);
		w.close();


}
}
