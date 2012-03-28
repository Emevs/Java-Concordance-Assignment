/**
 * Author:  Emily Evans
 * Version: 4.2
 * Date: 24/10/2011
 */
package concordance.data;

import java.util.Hashtable;

public class HashtableInterface 
{
	private Hashtable<String, LinkedList> concordanceHash;
	
	/**
	 * Constructor to initialise hashtable
	 */
	public HashtableInterface ()
	{
		// initialise hashtable
		concordanceHash  = new Hashtable<String, LinkedList>();
	}
	
	/**
	 * Method to add the linked list of line numbers and context to the hashtable
	 * using the word as a key.
	 * 
	 * @param word
	 * @param lineNumsList
	 */
	public void add(String word, LinkedList contextAndLinesList)
	{
		concordanceHash.put(word, contextAndLinesList);
	}

	/**
	 * Method to return the linked list of a single word
	 * 
	 * @param word
	 * @return contextAndLines
	 */
	public LinkedList get(String word)
	{
		LinkedList contextAndLines = null;
		// check for linked list contains passed in word
		if(concordanceHash.containsKey(word))
		{
			// if entry for that word in the hashtable, get the linked list
			contextAndLines = concordanceHash.get(word);
		}
		return contextAndLines;
	}
	
	/**
	 * Method to get all the keys of the hashtable and add them to an
	 * array. In this instance, the keys are the index words.
	 * 
	 * @return indexArray
	 */
	public String[] getIndexArray()
	{
		String[] indexArray = new String[concordanceHash.size()];
		// get keys from hashtable - the index words and add to an array
		indexArray = concordanceHash.keySet().toArray(indexArray);
		return indexArray;
	}
}