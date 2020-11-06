import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;




class WordRecommenderTest{
	
	ArrayList<String> wordsFromDictionary;
	ArrayList<String> wordsFromUserFile;

	@Test
	void testInstance() {
		WordRecommender a = new WordRecommender();
		assertNotNull(a);
	}
	
	@Test
	void testFileCreation() {
		WordRecommender a = new WordRecommender();
		assertNotNull(a);
		wordsFromDictionary = a.createDFile("testdictionary");
		assertNotNull(wordsFromDictionary);
	    wordsFromUserFile = a.createFileToCheck("usertocorrect.txt");
	}

	@Test
	void testFileDCreation() {
		WordRecommender a = new WordRecommender();
		wordsFromDictionary = a.createDFile("testdictionary");
		assertEquals("hello", wordsFromDictionary.get(0), "First word in dictionary");
		
	}
	
	@Test
	void testFileCCreation() {
		WordRecommender a = new WordRecommender();
		wordsFromUserFile = a.createFileToCheck("usertocorrect.txt");
		assertEquals("hellp", wordsFromUserFile.get(0), "First word in file");
	}
	
	@Test
	void getSim1() {
		WordRecommender a = new WordRecommender();
		double Sim = a.getSimilarity("help", "hell");
		assertEquals(3, Sim, "First word in file");
	}
	
	@Test
	void getSim2() {
		WordRecommender a = new WordRecommender();
		double Sim = a.getSimilarity("help", "hello");
		assertEquals(Sim, 2, "Sim works");
	}
	

	@Test
	void print() {
		WordRecommender a = new WordRecommender();
		ArrayList<String> list =  new ArrayList <String>();
		list.add("hi");
		list.add("hello");
		list.add("help");
		String toPrint = a.prettyPrint(list);
		assertNotNull(toPrint);
	}
	
	@Test
	void getWordS1() {
		WordRecommender a = new WordRecommender();
		a.createFileToCheck("usertocorrect.txt");
		a.createDFile("testdictionary");
		ArrayList<String> words = a.getWordSuggestions("hellp", 2, 0.8, 5);
		assertNotNull(words);
	}
	
	@Test
	void getWordS2() {
		WordRecommender a = new WordRecommender();
		a.createFileToCheck("usertocorrect.txt");
		a.createDFile("testdictionary");
		ArrayList<String> words = a.getWordSuggestions("hellp", 1, 0.8, 2);
		assertNotNull(words);
	}
	
	
	
	
	
	
	

	

}
