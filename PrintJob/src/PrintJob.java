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
	String DS="";
	int tp = 0;
	int color = 0;
	int bnw = 0;
	double tot;
	try {

		br = new BufferedReader(new FileReader(csvFile));
		while ((line = br.readLine()) != null) {
			System.out.println(" line number =" + line);
			String[] data = line.split(cvsSplitBy);
			tp = Integer.parseInt(data[0].trim()) ;
			color = Integer.parseInt(data [1].trim());
			bnw = (tp - color);
			System.out.println("Total number of pages =" + tp
                    		+ " , color pages = " + color
                    		+ " , black and white pages = " + bnw  );
			DS = data[2].trim();
            if ( DS.equalsIgnoreCase("true")){
            tot = ((bnw*.10)+(color+.20));
            }
            else{
            tot = ((bnw*.15)+(color*.25));
            }
            System.out.println("total ammount = $"+ tot);
		}
	} catch (FileNotFoundException e) {
		e.printStackTrace();
	} catch (IOException e) {
		e.printStackTrace();
	} finally {
		if (br != null) {
			try {

				tot = 0;
				color=0;
				tp =0;
				bnw =0;
				br.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	System.out.println("Done");
  }
}
