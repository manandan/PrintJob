import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

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
	double FinalAmount = 0;
	double tot;
	try {

		br = new BufferedReader(new FileReader(csvFile));
		int i =1;
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
            tot = ((BlacknWhite*.10)+(Color+.20));
            }
            else{
            tot = ((BlacknWhite*.15)+(Color*.25));
            }
            System.out.println("total amount of Job "+i+" = $"+ tot);
            FinalAmount = FinalAmount+tot;
            i++; 
		}
		System.out.println("Final amount of all Job = $"+ FinalAmount +"\r\n");
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
	System.out.println("\r\n Done");
  }
}
