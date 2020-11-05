import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;




class WordRecommenderTest{
	
	ArrayList<String> wordsFromDictionary;
	ArrayList<String> wordsFromUserFile;

	@Test
	void testCreation() {
		WordRecommender a = new WordRecommender();
		assertNotNull(a);
		wordsFromDictionary = a.createDFile("testdictionary");
		assertNotNull(wordsFromDictionary);
	    wordsFromUserFile = a.createFileToCheck("usertocorrect.txt");
	}
//	@Test
//	void setUp(String fileName) throws Exception {
//		WordRecommender a = new WordRecommender();
//		assertNotNull(a);
//	    wordsFromDictionary = a.createDFile("testdictionary");
//	    wordsFromUserFile = a.createFileToCheck("usertocorrect.txt");
//	 	
//	}

	@Test
	void testFileDCreation() {
	    assertEquals("hello", wordsFromDictionary.get(0), "First word correct");
		
	}
	
	@Test
	void testFileCCreation() {
		assertEquals("hellp", wordsFromUserFile.get(0), "First word correct");
	}
	
	
	
	
	
	
	
	@Test
	void createCorrectDictionaryFile() {
		
		fail("Not yet implemented");
	}
	
	@Test
	void createCorrectWordsToCheckFile() {
		
		fail("Not yet implemented");
	}
	
	
	
//	WordRecommender a = new WordRecommender();
//	static ArrayList <String> newFileD = a.createDFile("engDictionary.txt");
//	ArrayList <String> newFileC = a.createFileToCheck("usertocorrect");
//	
//	
//	public static void main(String[] args) {
//		
//		
//		for (int i = 0; i < 5; i++) {
//			System.out.println(newFileD.get(i));
//		}
//	
//	}
	

}
