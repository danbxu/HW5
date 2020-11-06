//Collaborators: Corey Parker, Daniel Xu
import java.util.*;

public class PrintToScreen {

	
	WordRecommender b = new WordRecommender();
	String[] wordExist = new String[1];

	/**
	 * This method will identify and prompt the user different options to accept spelling
	 * as is, replace the word with suggestion, or type in user's spelling 
	 * @param userFile (userfile that user wishes to spell check)
	 * @param dict (dictionary to be used for checking spelling) 
	 * @return (returns ArrayList of all the words corrected)
	 */
	
	public ArrayList <String> correctMis (String userFile, String dict) {

		Scanner s = new Scanner(System.in);
		WordRecommender a = new WordRecommender();
		ArrayList <String> newFileC = a.createFileToCheck(userFile);
		ArrayList <String> newFileD = a.createDFile(dict);
	
	
		/**
		 * This will iterate through all the words inside the userfile to spell check and
		 * and repeatedly prompt the user for different choices until there are no more incorrect
		 * words
		 */

		for (int i = 0; i < newFileC.size(); i++) {
			ArrayList <String> toPrint = a.getWordSuggestions(newFileC.get(i), 1, 0.8, 5);
			for (int j = 0 ; j < newFileD.size(); j++) {
				if (newFileC.get(i).equals(newFileD.get(j))) {
					wordExist[0] = newFileC.get(i);

				}

			}
			
			/**
			 * If the word, when checked against the dictionary does not exist,
			 * it means that the word is misspelled 
			 */
			if (wordExist[0] == null) {
				System.out.println("The word " + "'"+ newFileC.get(i)+ "' is misspelled.");
				
				//This condition hits if there are existing suggestions for correct spelling
				if (!a.prettyPrint(toPrint).isEmpty()) {
					System.out.println("The following suggestions are available:");
					//print the top suggestions
					System.out.println(a.prettyPrint(toPrint));
					System.out.println("Press 'r' for replace, 'a' for accept as is, 't' for type in manually.");


					int errorCounter = 1;
					for (int k = 0; k < errorCounter; k++) {
						String input = s.next();
						//prompt user with different options
						if (input.equals("r")) {
							System.out.println("Your word will now be replaced with one of the suggestions.");
							System.out.println("Enter the number corresponding to the word that you want to use for replacement.");
							int replace = s.nextInt();
							newFileC.set(i, toPrint.get(replace - 1));
						}
						//Goes to next word if user choice to accept the incorrect spelling
						if (input.equals("a")) {

						}
						//Prompts user to input what the spelling to be by typing on the keyboard and hitting enter
						if (input.equals("t")) {
							System.out.println("Please type the word that will be used as the replacement in the output file.");
							String replace = s.next();
							newFileC.set(i, replace);
						}
						//Prompts user to select either 'r', 'a', 't', the only allowable inputs 
						if (!input.equals("r") && !input.equals("a") && !input.equals("t")) {

							System.out.println("That input was not one of the options.");
							errorCounter++;
							System.out.println("Press 'r' for replace, 'a' for accept as is, 't' for type in manually.");
						}
					}

				}
				//This condition hits if there are no existing suggestions for correct spelling
				if (a.prettyPrint(toPrint).isEmpty()) {
					System.out.println("There are 0 suggestions in our dictionary for this word.");
					System.out.println("Press 'a' for accept as is, 't' for type in manually.");
					int errorCounter = 1;
					for (int k = 0; k < errorCounter; k++) {
						String input = s.next();
						//Goes to next word if user choice to accept the incorrect spelling
						if (input.equals("a")) {

						}
						//Prompts user to input what the spelling to be by typing on the keyboard and hitting enter
						if (input.equals("t")) {
							System.out.println("Please type the word that will be used as the replacement in the output file.");
							String replace = s.next();
							newFileC.set(i, replace);
						}
						//Prompts user to select either 'a' or 't', the only allowable inputs 
						if (!input.equals("a") && !input.equals("t")) {

							System.out.println("That input was not one of the options.");
							errorCounter++;
							System.out.println("Press 'a' for accept as is, 't' for type in manually.");
						}

					}
				}

			}
			wordExist[0] = null;
		}
//		System.out.println(newFileC);
		return newFileC;

	}
	
}
