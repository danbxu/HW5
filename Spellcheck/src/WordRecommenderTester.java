import java.util.ArrayList;

public class WordRecommenderTester {
	

	
	public static void main(String[] args) {
		
		WordRecommender a = new WordRecommender();
		ArrayList <String> newFileD = a.createDFile("engDictionary.txt");
		ArrayList <String> newFileC = a.createFileToCheck("usertocorrect");
		ArrayList <String> b = a.getWordSuggestions("dence", 2, .8, 20);
		System.out.println(a.prettyPrint(b));
	
	}

}
