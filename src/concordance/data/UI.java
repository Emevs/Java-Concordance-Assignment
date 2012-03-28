/**
 * Author: Emily Evans
 * Version: 2.0
 * Date: 24/10/2011
 */
package concordance.data;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class UI 
{
	private Reader reader = new Reader();
	/**
	 * Empty constructor for the user interface class
	 */
	public UI()
	{
		
	}
	
	/**
	 * Method to handle users menu input, and carry out the right functions, according 
	 * to their choice.
	 */
	public void menu()
	{
		// create scanner to read in users menu choice
		Scanner in = new Scanner(System.in);
		String temp;
        char menu_choice;
        System.out.println("Welcome to Emily's Concordance");
        do
        {
            System.out.println("\nMenu");
            this.printMenu();
            temp = in.next();
            menu_choice = temp.charAt(0);
            switch(menu_choice)
            {
                case 'I': case 'i':
                	// ask user to input index filename
                	System.out.println("Please enter the index filename: ");
            		// call filename method to handle user input
            		String indexFilename = this.fileName();
            		// read index file
            		reader.IndexReader(indexFilename);
                    break;
                case 'S': case 's':
                	System.out.println("Please enter the source filename: ");
            		// call filename to handle input
            		String sourceFilename = this.fileName();
            		// call sourceReader method and print all words and line numbers
            		reader.SourceReader(sourceFilename);
                    break;
                case 'P': case 'p':
                	reader.printAll();
                	break;
                case 'F': case 'f':
                	// ask user to input a word to find
                	System.out.println("Please enter the word you wish to find: ");
                	// read in users input
                	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                	String word = "";
					try 
					{
						// try assigning users input to word
						word = br.readLine();
					} 
					catch (IOException e) 
					{
						System.out.println("There was a problem with your input, please try again.");
					}
					// get Index array from reader class
					String[] indexArray = reader.getAndSortIndexWords();
					// variable to prevent program crashing if the input wor is not in the index
					boolean wordInIndex = false;
					for(int i = 0; i < indexArray.length; i++)
					{
						// if the input word is in the index array
						if(indexArray[i].equals(word))
						{
							// get the linked list for that word
							LinkedList contextAndLines = reader.getLinkedList(word);
							// print all line numbers and the context
							contextAndLines.printAll();
							// wordInIndex becomes true as word was in the index
							wordInIndex = true;
						}
					}
					// if the word wasn't in the array
					if(!wordInIndex)
					{
						// write an error message
						System.out.println("The word you wanted is not in the index, please try a different word.");
					}
                	
                	break;
                case 'Q': case 'q':
                    System.out.println("Thank you for using my concordance, goodbye!");
                    break;
            }
        }
        while (menu_choice != 'Q' && menu_choice != 'q');
    }
	
	/**
     * Method displays menu options onto the screen
     */
    public void printMenu()
    {
        System.out.println("I - Input index filename");
        System.out.println("S - Input source filename");
        System.out.println("P - Print Concordance");
        System.out.println("F - Find a word in the source file");
        System.out.println("Q - Quit \n");
    }
		
	/**
	 * Method to read in users input filename and return it
	 * 
	 * @return filename
	 */
	public String fileName()
	{
		// create buffered reader 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String fileName = "";
	    try 
	    {
	    	// read in user input
	    	fileName = br.readLine();
	    }
	    // handle IO exception
	    catch (IOException ioe) 
	    {
	    	System.out.println("There was an error reading the file");
	        System.exit(1);
	    }
	    return fileName;
	}	
}
