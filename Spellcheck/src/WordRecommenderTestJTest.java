import static org.junit.jupiter.api.Assertions.*;

import java.io.File;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class WordRecommenderTestJTest {

	@BeforeEach
	void setUp() throws Exception {
//		String fileName
//		String userDictionary = fileName;
//		File userFile = new File(userDictionary);
//		
//		
//		
//		String userCheckFile = checkFile; //unit test
//		File f = new File(userCheckFile); //unit test
//		
	}

	@Test
	void testgetSimInit(String word1, String word2) {
		String newWord1;
		String newWord2;
		newWord1 = word1;
		newWord2 = word2;
		assertEquals(newWord1, word1);
		assertEquals(newWord2, word2);
	}
	
	@Test
	void createCorrectDictionaryFile() {
		
		fail("Not yet implemented");
	}
	
	@Test
	void createCorrectWordsToCheckFile() {
		
		fail("Not yet implemented");
	}

}