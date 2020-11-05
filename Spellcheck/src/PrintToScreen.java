import java.util.*;

public class PrintToScreen {


	WordRecommender b = new WordRecommender();
	String[] wordExist = new String[1];


	public ArrayList <String> correctMis (String userFile, String dict) {

		Scanner s = new Scanner(System.in);
		WordRecommender a = new WordRecommender();
		ArrayList <String> newFileC = a.createFileToCheck(userFile);
		ArrayList <String> newFileD = a.createDFile(dict);
		String fileUpdated;

		for (int i = 0; i < newFileC.size(); i++) {
			ArrayList <String> toPrint = a.getWordSuggestions(newFileC.get(i), 1, 0.8, 5);
			for (int j = 0 ; j < newFileD.size(); j++) {
				if (newFileC.get(i).equals(newFileD.get(j))) {
					wordExist[0] = newFileC.get(i);

				}

			}
			if (wordExist[0] == null) {
				System.out.println("The word " + "'"+ newFileC.get(i)+ "' is misspelled.");

				if (!a.prettyPrint(toPrint).isEmpty()) {
					System.out.println("The following suggestions are available:");

					System.out.println(a.prettyPrint(toPrint));
					System.out.println("Press 'r' for replace, 'a' for accept as is, 't' for type in manually.");


					int errorCounter = 1;
					for (int k = 0; k < errorCounter; k++) {
						String input = s.next();

						if (input.equals("r")) {
							System.out.println("Your word will now be replaced with one of the suggestions.");
							System.out.println("Enter the number corresponding to the word that you want to use for replacement.");
							int replace = s.nextInt();
							newFileC.set(i, toPrint.get(replace - 1));
						}
						if (input.equals("a")) {

						}
						if (input.equals("t")) {
							System.out.println("Please type the word that will be used as the replacement in the output file.");
							String replace = s.next();
							newFileC.set(i, replace);
						}
						if (!input.equals("r") && !input.equals("a") && !input.equals("t")) {

							System.out.println("That input was not one of the options.");
							errorCounter++;
							System.out.println("Press 'r' for replace, 'a' for accept as is, 't' for type in manually.");
						}
					}

				}
				if (a.prettyPrint(toPrint).isEmpty()) {
					System.out.println("There are 0 suggestions in our dictionary for this word.");
					System.out.println("Press 'a' for accept as is, 't' for type in manually.");
					int errorCounter = 1;
					for (int k = 0; k < errorCounter; k++) {
						String input = s.next();

						if (input.equals("a")) {

						}
						if (input.equals("t")) {
							System.out.println("Please type the word that will be used as the replacement in the output file.");
							String replace = s.next();
							newFileC.set(i, replace);
						}
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
