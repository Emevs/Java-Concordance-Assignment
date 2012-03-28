/**
 * Author:  Emily Evans
 * Version: 4.0
 * Date: 24/10/2011
 */
package concordance.data;

public class LinkedList 
{	
	private Node head = new Node();
	private Node tail = new Node();
	private int numItems = 0;

	/**
	 * Empty constructor for LinkedList
	 */
	public LinkedList()
	{
	
	}

	/**
	 * Method to add nodes to the tail of the linked list.
	 * 
	 * @param contextAndLine
	 */
	public void add(ContextAndLine contextAndLine)
	{
		//create a new node, passing the object contextAndLine to node constructor
		Node newNode = new Node(contextAndLine);
		//if the number of items in the linked list doesn't equal zero
		if (0 == numItems)
		{
			//set the next node to be null
        	newNode.setNext(null);
        	//make the head and tail the new node
            head = newNode;
            tail = newNode;
        } 
        else 
        {
        	//set the tail node to point to the new node
        	tail.setNext(newNode);
        	//change the tail to the new node
			tail = newNode;
        }
		//increment number of items in the linked list
		numItems++;		
	}

	/**
	 * Method to return the context and line object stored in the head node of the 
	 * LinkedList 
	 * 
	 * @return head.getContextAndLine()
	 */public ContextAndLine[] getAll()
		{
			//create string and new Node and make the new node equal the head node
			ContextAndLine[] context = new ContextAndLine[numItems];
			Node tempNode = head;
			//while integer count is less than number of items in linked list
			for(int i = 0; i < numItems; i++)
			{
				//get context object from node and add to string
				context[i] = tempNode.getContextAndLine();
				//make node next node in linked list
				tempNode = tempNode.getNext();
			}
			return context;
		}
	 
	/**
	 * Method to return the ContextAndLine object stored in the head node 
	 * in the linked list.
	 * 
	 * @return head.getContextAndLine
	 */
	public ContextAndLine getHead()
	{
		//return context and line object from first node in list
		return head.getContextAndLine();
	}
	
	/**
	 * Method to return the context and line object stored in the tail node of the 
	 * LinkedList
	 * 
	 *  @return tail.getLineNum()
	 */
	public ContextAndLine getTail()
	{
		//return context and line object from last node in list
		return tail.getContextAndLine();
	}
	
	/**
	 * Method to print all information stored in each node in the LinkedList 
	 */
	public void printAll()
	{
		//create new Node and make the new node equal the head node
		Node tempNode = head;
		//loop through number of items in linked list
		for(int i = 0; i < numItems; i++)
		{
			//get contextAndLine and words before and after from node and print
			ContextAndLine contextAndLine = tempNode.getContextAndLine();
			contextAndLine.print();
			//make node next node in linked list
			tempNode = tempNode.getNext();
		}
		System.out.println(" ");
	}

	/**
	 * Method to return true if the LinkedList is empty
	 * 
	 * @return true/ false
	 */
	public boolean isEmpty()
	{
		//return true if length equals zero
		return(numItems == 0);
	}

	/**
	 * Method to return the length of the LinkedList
	 * 
	 * @return numItems
	 */
	public int length()
	{
		return numItems;
	}
}

