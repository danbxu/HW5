import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class WriteCorrectedFile {

	

	public void writeNewFileName (String filename) {
		
		
		
		try {
			PrintWriter New = new PrintWriter("output.txt");
			//write to this file
			New.println("fghogrh");
			New.flush();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

