import java.util.*;

public class PrintToScreen {


	WordRecommender b = new WordRecommender();
	String[] wordExist = new String[1];


//	ArrayList<String> wordsFromDictionary;
//	ArrayList<String> wordsFromUserFile;
//	static ArrayList<String> newFileD;
//	static ArrayList<String> newFileC;



//	WordRecommender a = new WordRecommender();
//	newFileD = a.createDFile("engDictionary.txt");
//	newFileC = a.createFileToCheck("usertocorrect");



	public void correctMis (String userFile, String dict) {
		
		Scanner s = new Scanner(System.in);
		WordRecommender a = new WordRecommender();
		ArrayList <String> newFileC = a.createFileToCheck(userFile);
		ArrayList <String> newFileD = a.createDFile(dict);
		
		for (int i = 0; i < newFileC.size(); i++) {
			ArrayList <String> toPrint = a.getWordSuggestions(newFileC.get(i), 2, 0.6, 5);
			for (int j = 0 ; j < newFileD.size(); j++) {
				if (newFileC.get(i).equals(newFileD.get(j))) {
					wordExist[0] = newFileC.get(i);

				}
				
			}
			if (wordExist[0] == null) {
				System.out.println("The word " + "'"+ newFileC.get(i)+ "' is misspelled");
				System.out.println("The following suggestions are available");
				
				System.out.println(a.prettyPrint(toPrint));
				
				
				
				
				

				
			}
//			else {
//				toPrint.clear();
//			}
			wordExist[0] = null;
		}

	}

	public static void main(String[] args) {
		//		System.out.println(Arrays.toString(wordsFromDictionary.toArray()));

		PrintToScreen v = new PrintToScreen();
		v.correctMis("usertocorrect", "engDictionary.txt");
//
//
//		for (int i = 0; i < 5; i++) {
//			System.out.println(newFileD.get(i));
		}
	}



