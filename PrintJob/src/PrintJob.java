import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintStream;

public class PrintJob {
	public static void main(String args[]) {

	String csvFile = "C:/Users/manan2/Downloads/printjobs.csv";
	BufferedReader br = null;
	String line = "";
	String cvsSplitBy = ",";
	String DoubleSide="";
	int TotalPages = 0;
	int Color = 0;
	int BlacknWhite = 0;
	double Finalcost = 0;
	double JobCost;
	try {

		br = new BufferedReader(new FileReader(csvFile));
		int i =1;
		File file = new File("C:/Users/manan2/Downloads/output.txt");
		FileOutputStream fos = new FileOutputStream(file);
		PrintStream ps = new PrintStream(fos);
		System.setOut(ps);
		while ((line = br.readLine()) != null) {
			System.out.println("Job =" + i);
			System.out.println("Input Data =" + line);
			String[] data = line.split(cvsSplitBy);
			TotalPages = Integer.parseInt(data[0].trim()) ;
			Color = Integer.parseInt(data [1].trim());
			BlacknWhite = (TotalPages - Color);
			System.out.println("Total number of pages =" + TotalPages
                    		+ " , color pages = " + Color
                    		+ " , black and white pages = " + BlacknWhite  );
			DoubleSide = data[2].trim();
            if ( DoubleSide.equalsIgnoreCase("true")){
            	JobCost = ((BlacknWhite*.10)+(Color+.20));
            }
            else{
            	JobCost = ((BlacknWhite*.15)+(Color*.25));
            }
            System.out.println("total cost of Job "+i+" = $"+ JobCost+"\r\n");
            Finalcost = Finalcost+JobCost;
            i++; 
		}
		System.out.println("Final cost of all Jobs = $"+ Finalcost +"\r\n");
	} catch (FileNotFoundException e) {
		e.printStackTrace();
	} catch (IOException e) {
		e.printStackTrace();
	} finally {
		if (br != null) {
			try {
				br.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
  }
}
