import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;

public class WriteNewFile {


	public void writeNewFileName (String filename, ArrayList<String> file) {
		String[] xyz = null;
		xyz = filename.split("\\.");
		String updateFile = xyz[0];
	

		try {
			PrintWriter pw = new PrintWriter(updateFile + "_chk.txt");
			for (int i = 0; i < file.size(); i++) {
				pw.print(file.get(i) + " ");
			}
			pw.flush();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
}
