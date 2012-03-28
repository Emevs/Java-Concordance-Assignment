/**
 * Author:  Emily Evans
 * Version: 4.0
 * Date: 24/10/2011
 */
package concordance.data;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class Reader 
{
	private int numberOfLines;
	private HashtableInterface concordanceHash = new HashtableInterface ();

	/**
	 * Empty Reader constructor.
	 */
	public Reader()
	{
	}
	
	/**
	 * Method to read in index file, add an empty linked list to a hash table and add the words to an array.
	 * 
	 * @param filename
	 */
	public void IndexReader(String filename) 
	{
		// create new file reader
		FileReader fR;
		try
		{
			// Initialise new file reader and give passed in filename
			fR = new FileReader(filename);
			//create and initialise buffered reader
			BufferedReader bR = new BufferedReader(fR);
			String indexWord;			
			int count = 0;
			try 
			{
				// keep reading in each line, assigning it to word, until equal to null 
				while((indexWord = bR.readLine()) != null)
				{
					// create empty linked list
					LinkedList contextAndLines = new LinkedList();
					// add word and linked list to hash table by calling add in IndexHashtable class
					concordanceHash.add(indexWord, contextAndLines);
					//increment count
					count++;			
				}
				bR.close();
			} 
			// handle IO Exception
			catch (IOException e) 
			{
				System.out.println("There was an error reading in the file");
			}
		}
		catch (FileNotFoundException e)
		{
			System.out.println("Error, file not found");
		}
	}
	
	/**
	 * Method to read in the source file, line by line, then compare the array of index words
	 * to each word in the array.
	 * 
	 * @param filename
	 */
	public void SourceReader(String filename)
	{
		FileReader fR;
		try
		{
			// Initialise new file reader and create and initialise buffered reader
			fR = new FileReader(filename);
			BufferedReader bR = new BufferedReader(fR);
			String readInLine;
			int lineNumber = 1;
			String indexArray[] = this.getAndSortIndexWords();
			
			try 
			{
				// keep reading in each line, assigning it to line, until equal to null 
				while((readInLine = bR.readLine()) != null)
				{
					String indexWord = "";
					// loop through index array
					for(int c = 0; c < indexArray.length; c++)
					{
						// change word every time loop through 
						indexWord = indexArray[c];
						// remove punctuation;
						readInLine = readInLine.replaceAll("[,\".;:!?()0-9]", "");
						// split the string line into and array of strings
						String wordsInLineArray[] = readInLine.split(" "); 						//loop through array of words in the line
						for(int i = 0; i < wordsInLineArray.length; i++)
						{
							// change other word every time loop through
							String lineWord = wordsInLineArray[i];
							// compare the two words together
							if ((indexWord.compareToIgnoreCase(lineWord)) == 0)
							{
								// get linked list from hashtable
								LinkedList lineNumList = concordanceHash.get(indexWord);
								
								String wordBefore = "";
								// find the word before the matched word, making sure there
								// is a word before it.
								int previousWord = i - 1;
								if(previousWord >= 0)
								{
									wordBefore = wordsInLineArray[previousWord];
								}
								
								String wordAfter = "";
								// find the word after the matched word, making sure there 
								// actually a word after it.
								int nextWord = i + 1;
								if(nextWord < wordsInLineArray.length)
								{
									wordAfter = wordsInLineArray[nextWord];
								}
								
								// create a new ContextAndLine object and add the line numbers,
								// word before and word after.
								ContextAndLine contextAndLine = new ContextAndLine(lineNumber, wordBefore, wordAfter);
								// add to the linked list.
								lineNumList.add(contextAndLine);
							}	
						}				
					}
					// increment line number
					lineNumber++;
				}
				bR.close();
			} 
			// handle IO and FileNotFound exceptions
			catch (IOException e) 
			{
				System.out.println("There was an error reading in the file");
			}	
		}
		catch (FileNotFoundException e)
		{
			System.out.println("Error, file not found");
		}
	}
	
	/**
	 * Method to return the sorted array of index words .
	 * 
	 * @return indexArray
	 */
	public String[] getAndSortIndexWords()
	{
		//get the index words from the hashtable
		String indexArray[] = concordanceHash.getIndexArray();
		// sort array into alphabetical order
		Arrays.sort(indexArray);
		return indexArray;
	}
	
	/**
	 * Method to print all words and their line numbers to the screen.
	 */
	public void printAll()
	{
		String[] indexArray = this.getAndSortIndexWords();
		LinkedList contextAndNums = new LinkedList();
		// loop through array of index words
		for(int i = 0; i < indexArray.length; i++)
		{
			
			// change word to each word of the index array in turn
			String word = indexArray[i];
			// get the linked list from the hash table
			contextAndNums = concordanceHash.get(word);
			// print the word and then all of the items in the linked list.
			System.out.println("\n" + word);
			contextAndNums.printAll();
		}
	}
	
	/**
	 * 
	 * @param word
	 * @return concordanceHash(word);
	 */
	public LinkedList getLinkedList(String word)
	{
		return concordanceHash.get(word);
	}

}
