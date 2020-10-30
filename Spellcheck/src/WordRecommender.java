import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class WordRecommender {

	String filename; //refers to the file 
	//containing a dictionary of correct words
	//ensure that spellcheck can run with any file name


	String word1;
	String word2;
	ArrayList<String> wordsFromDictionary;
	ArrayList<String> wordsFromUserFile;

	//Constructor for taking dictionary File
	public WordRecommender (String fileName, String checkFile) {
		//create objective
		String userDictionary = fileName;
		String userCheckFile = checkFile;
		//set as new
		File userFile = new File(userDictionary);

		try {
			//create ArrayList wordsFromUserFile
			Scanner fileScanner = new Scanner(userFile);
			while (fileScanner.hasNextLine()) { //This would need to be changed
				wordsFromDictionary.add(fileScanner.nextLine());
			}
		} catch (FileNotFoundException e) {
			System.out.println("Invalid file");
			e.printStackTrace();

		}

		/**
		 * Once ArrayList<String> for userDictionary is created, now create 
		 * a ArrayList for all words to check spelling
		 */
		//System.out.println(Arrays.toString(wordsFromUserFile))

		//created a handle/file object
		File f = new File(userCheckFile);
		try {
			//try to do stuff
			Scanner fileScanner = new Scanner(f);
			//need to ask about this
			while (fileScanner.hasNext()) {
				wordsFromUserFile.add(fileScanner.next());
			}
		} catch (FileNotFoundException e) {
			System.out.println("bad file name");
			e.printStackTrace();
		}
	}


}



//	String str = "2346512aa";
//	int sum = 0;
//
//	for(int i = 0; i <= str.length(); i++){
//		try{
//			sum += Integer.parseInt(str.charAt(i) + "");
//		}catch(IndexOutOfBoundsException ioe){
//			System.out.print("Regular!  ");
//			sum -= 1;
//		}catch(NumberFormatException nfe){
//			System.out.print("Yikes!  ");
//			sum -= 1;
//		}finally{
//			System.out.println("i= " + i);
//			sum += 1;
//		}
//	}
//	System.out.println("Sum: " + sum);
//} //main
//class




//	//get similarities and return average of the two words
//	//maybe use 2 forloops
//	public double getSimilarity (String word1, String word2) {
//	

// one forloop increment up (left to right)
// one forloop decrement down (right to left)

//	double leftSimilarity = 0;
//	double rightSimilarity = 0;
//	
//	double numbers = 2.9;
//	
//	return numbers;
//		
//	}
//	}





