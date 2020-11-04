import java.util.ArrayList;

public class PrintToScreen {


	WordRecommender b = new WordRecommender();
	String[] wordExist = new String[1];


	ArrayList<String> wordsFromDictionary;
	ArrayList<String> wordsFromUserFile;
	static ArrayList<String> newFileD;
	static ArrayList<String> newFileC;



//	WordRecommender a = new WordRecommender();
//	newFileD = a.createDFile("engDictionary.txt");
//	newFileC = a.createFileToCheck("usertocorrect");



	public void correctMis (ArrayList<String> dictionaryWords, 
			ArrayList<String> fileWords) {
		
		for (int i = 0; i < fileWords.size(); i++) {
			for (int j = 0 ; j < dictionaryWords.size(); j++) {
				if (fileWords.get(i).equals(dictionaryWords.get(j))) {
					wordExist[0] = fileWords.get(i);

				}
				
			}
			if (wordExist[0] == null) {
				System.out.println("The word " + "'"+ fileWords.get(i)+ "' is misspelled");
				System.out.println("The following suggestions are available");
				
				
				

				ArrayList<String> c = b.getWordSuggestions(fileWords.get(i), 1, .6, 3);
				b.prettyPrint(c);

				
			}
			wordExist[0] = null;
		}

	}

	public static void main(String[] args) {
		//		System.out.println(Arrays.toString(wordsFromDictionary.toArray()));

		PrintToScreen v = new PrintToScreen();
		v.correctMis(newFileD, newFileC);


		for (int i = 0; i < 5; i++) {
			System.out.println(newFileD.get(i));
		}
	}
}


