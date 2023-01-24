import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class Reporting  implements Serializable{

	static Long countItemsFiles() {
		Long count;
		try (Stream<Path> files = Files.list(Paths.get("itemsReport"))) {
			count = files.count();

			files.close();
		} catch (IOException e) {
			count = (long) 0;
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return count;
	}

	static Long countInvoiceFiles() {
		Long count;
		try (Stream<Path> files = Files.list(Paths.get("invoiceReport"))) {
			count = files.count();

			files.close();
		} catch (IOException e) {
			count = (long) 0;
			// TODO Auto0-generated catch block
			e.printStackTrace();
		}

		return count;
	}

	static void createInvoiceReport(Invoice i) {

		try {
			new File("invoiceReport").mkdirs();

			File oldFile = new File(i.getInvoiceId() + ".txt");
			File newFile = new File("invoiceReport\\" + i.getInvoiceId() + ".txt");
			FileOutputStream ff = new FileOutputStream(newFile);
			ObjectOutputStream o = new ObjectOutputStream(ff);

			// Write objects to file
			o.writeObject(i);

			o.close();
			ff.close();
		} catch (Exception error) {
			error.getMessage();
		}
	}

	static void creatItemsReport(Product p) {
		try {
			new File("itemsReport").mkdirs();

			File oldFile = new File(p.getItemID() + ".txt");
			File newFile = new File("itemsReport\\" + p.getItemID() + ".txt");
		
			FileOutputStream ff = new FileOutputStream(newFile);
			ObjectOutputStream o = new ObjectOutputStream(ff);

			// Write objects to file
			o.writeObject(p);

			o.close();
			ff.close();
		} catch (Exception error) {
			error.getMessage();
		}

	}

	static void createAllInvoiceReport(String name) throws IOException {

		File file = new File("AllInvoiceReport.txt");
		FileWriter w = new FileWriter("AllInvoiceReport.txt");
		w.write("\t\tAllInvoiceReport");
		w.write(name);
		w.close();

	}

	File file = new File("Statistics.txt");

	static void statics(String name) throws IOException {

		FileWriter w = new FileWriter("Statistics .txt");
		w.write("\t\tAllInvoiceReport");
		w.write(name);
		w.close();

	}

	static Invoice getInvoicesReport(String i) {
		Invoice in=null;
	
		try {
			FileInputStream fi = new FileInputStream(new File("invoiceReport\\" + i + ".txt"));
			ObjectInputStream oi = new ObjectInputStream(fi);

			// Read objects
			 in = (Invoice) oi.readObject();

			System.out.println(in.getCustomerFullName() + "\n");

			oi.close();
			fi.close();
		} catch (Exception error) {
			error.getMessage();
		}
return in;
	}
	
	static Product getitemsReport(String i) {
		 Product in=null;
	
		try {
			FileInputStream fi = new FileInputStream(new File("itemsReport\\" + i + ".txt"));
			ObjectInputStream oi = new ObjectInputStream(fi);

			// Read objects
	 in = (Product) oi.readObject();

			

			oi.close();
			fi.close();
		} catch (Exception error) {
			error.getMessage();
		}
		 return in;

	}
}
