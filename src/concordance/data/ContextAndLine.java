/**
 * Author:  Emily Evans
 * Version: 1.2
 * Date: 24/10/2011
 */
package concordance.data;

public class ContextAndLine
{
	private int lineNum;
	private String wordBefore;
	private String wordAfter;
	
	/**
	 * Empty constructor for ContextAndLine object.
	 */
	public ContextAndLine()
	{
		
	}
	
	/**
	 * Constructor to initialise line number and the words that occur before 
	 * and after the found word.
	 * 
	 * @param line
	 * @param before
	 * @param after
	 */
	public ContextAndLine(int line, String before, String after)
	{
		lineNum = line;
		wordBefore = before;
		wordAfter = after;
	}

	/**
	 * Method to return the line number.
	 * 
	 * @return lineNum
	 */
	public int getLineNum() 
	{
		return lineNum;
	}

	/**
	 * Method to set the line number.
	 * 
	 * @param lineNum
	 */
	public void setLineNum(int lineNum) 
	{
		this.lineNum = lineNum;
	}

	/**
	 * Method to get the word that occurs before the found word.
	 * 
	 * @return wordBefore
	 */
	public String getWordBefore() 
	{
		return wordBefore;
	}

	/**
	 * Method to set the wordBefore.
	 * 
	 * @param wordBefore
	 */
	public void setWordBefore(String wordBefore) 
	{
		this.wordBefore = wordBefore;
	}

	/**
	 * Method to get the word that occurs after the found word.
	 * 
	 * @return wordAfter
	 */
	public String getWordAfter() 
	{
		return wordAfter;
	}
	
	/** 
	 * Method to set the word that occurs after the found word.
	 * 
	 * @param wordAfter
	 */
	public void setWordAfter(String wordAfter) 
	{
		this.wordAfter = wordAfter;
	}
	
	/**
	 * Method to print the line number, and both the words that are 
	 * before and after the found word. 
	 */
	public void print()
	{
		System.out.print(lineNum + " Before: " + wordBefore + " After: " + wordAfter + "\n");
	}
}
