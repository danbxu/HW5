import java.util.ArrayList;

public class WordRecommenderTester {
	

	
	public static void main(String[] args) {
		
		WordRecommender a = new WordRecommender();
		ArrayList <String> newFileD = a.createDFile("engDictionary.txt");
		ArrayList <String> newFileC = a.createDFile("usertocorrect");
		System.out.println(a.getWordSuggestions("helo", 1, 0.5, 5));
		
//		PrintToScreen xy = new PrintToScreen();
		
//		xy.correctMis(newFileD, newFileC);
		
		
//		System.out.println(xy.correctMis(newFileD, newFileC));
		
//		for (int i = 0; i < 5; i++) {
//			System.out.println(newFileD.get(i));
//		}
//		
//		for (int i = 0; i < 5; i++) {
//			System.out.println(newFileC.get(i));
//		}
//		
//		
	
	}

}
