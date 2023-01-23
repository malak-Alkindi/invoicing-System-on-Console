import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;



public class Reporting {
	static void  createInvoiceReport(Invoice i) {
	try {
		FileOutputStream ff = new FileOutputStream(new File("invoice_#"+i.getInvoiceId() +".txt"));
		ObjectOutputStream o = new ObjectOutputStream(ff);

		// Write objects to file
		o.writeObject(i);

		o.close();
		ff.close();
}catch(Exception error) {
error.getMessage();
}


}
}
