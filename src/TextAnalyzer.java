/** The TextAnalyzer class calculates the number of sentences and words for a given string. 
 * returns the number of words and number of sentences using the toSTring method, to be displayed using the TextAnalysisGUI
 * 
 * @author Nick Nikolov
 *
 */
public class TextAnalyzer {
	private int numOfSentences;
	private int numOfWords;
	

	/** The TextAnalyzer constructor accepts the entire user text and calculates the number of words and number of sentences
	 * updates the instance variables numOfWords and numOfSentences
	 * 
	 * @param text
	 */
	public TextAnalyzer(String text) {
		numOfWords = 1; //initialize to 1 so the last word in the text is counted correctly.
		text = text.trim();
		for (int i = 0; i < text.length(); i++) {
			if (text.charAt(i) == '\s' || text.charAt(i) == '\n')
			{
				numOfWords++;
				if (text.charAt(i-1) == '\n')
				{
					numOfWords--;
				}
			} else if(text.charAt(i) == '!' || text.charAt(i) == '?' || text.charAt(i) == '.')
			{
				numOfSentences++;
			}
		}
	}
	
	/** getter for the number of sentences found in the text
	 * 
	 * @return numOfSentences (int) - number of sentences found in the user input text
	 */
	public int getNumOfSentences() {
		return this.numOfSentences;
	}
	
	/**getter for the number of words found in the user input text
	 * 
	 * @return numOfWords (int) - number of words found in the user input text
	 */
	public int getNumOfWords() {
		return this.numOfWords;
	}
	
	/**
	 * @return summmary string concatenating number of words  with number of sentences of the user input text (String)
	 */
	public String toString() {
		return "Number of Words: " + this.numOfWords + "\n" + "Number of Sentences: " + this.numOfSentences;
	}

}