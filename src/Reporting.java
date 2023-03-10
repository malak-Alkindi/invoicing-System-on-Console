import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class Reporting  implements Serializable{

	

static void createFoldersReport(String folderName) {
	try (Stream<Path> files = Files.list(Paths.get(folderName))) {
		

		files.close();
	} catch (IOException e) {
	
		new File(folderName).mkdirs();
		System.out.println(folderName+" folder created");

	}
	
	
}

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

	
		FileWriter w = new FileWriter("AllInvoiceReport.txt");
		w.write("\t\tAllInvoiceReport");
		w.write(name);
		w.close();

	}
	static void createStatisticsReport(String name) throws IOException {

	
		FileWriter w = new FileWriter("Statistics .txt");
		w.write("\t\tStatistics\n\n");
		w.write(name);
		w.close();

	}
	

	static void statics(String name) throws IOException {

		

		FileWriter w = new FileWriter("Statistics .txt");
		w.write("\t\tAllInvoiceReport");
		w.write(name);
		w.close();

	}
	static void createProgramStatisticsReport(ProgramStatistics PS) throws IOException {
		try {
		

			File oldFile = new File( "ProgramStatisticsReport.txt");
			
			FileOutputStream ff = new FileOutputStream(oldFile);
			ObjectOutputStream o = new ObjectOutputStream(ff);

			// Write objects to file
			o.writeObject(PS);

			o.close();
			ff.close();
		} catch (Exception error) {
			error.getMessage();
		}

	}
	static void creatShopInfoFile(Shop s) throws IOException {
		try {
		

			File oldFile = new File( "shopInfo.txt");
			
			FileOutputStream ff = new FileOutputStream(oldFile);
			ObjectOutputStream o = new ObjectOutputStream(ff);

			// Write objects to file
			o.writeObject(s);

			o.close();
			ff.close();
		} catch (Exception error) {
			error.getMessage();
		}

	}
	static Shop getShopInfoFile() {
		Shop in=null;
	
		try {
			FileInputStream fi = new FileInputStream(new File("shopInfo.txt"));
			ObjectInputStream oi = new ObjectInputStream(fi);

			// Read objects
			 in = (Shop) oi.readObject();

		

			oi.close();
			fi.close();
		} catch (Exception error) {
			error.getMessage();
		}
return in;
	}
	static ProgramStatistics getProgramStatisticsReport() {
		ProgramStatistics in=null;
	
		try {
			FileInputStream fi = new FileInputStream(new File("ProgramStatisticsReport.txt"));
			ObjectInputStream oi = new ObjectInputStream(fi);

			// Read objects
			 in = (ProgramStatistics) oi.readObject();

		

			oi.close();
			fi.close();
		} catch (Exception error) {
			error.getMessage();
		}
return in;
	}
	static Invoice getInvoicesReport(String i) {
		Invoice in=null;
	
		try {
			FileInputStream fi = new FileInputStream(new File("invoiceReport\\" + i + ".txt"));
			ObjectInputStream oi = new ObjectInputStream(fi);

			// Read objects
			 in = (Invoice) oi.readObject();

		

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
