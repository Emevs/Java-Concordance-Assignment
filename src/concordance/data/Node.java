/**
 * Author:  Emily Evans
 * Version: 2.0
 * Date: 24/10/2011
 */
package concordance.data;

class Node 
{
	private Node nextNode;
	private ContextAndLine contextAndLineOb = new ContextAndLine();
	
	/**
	 * Constructor to initialise line number variable
	 */
	public Node()
	{
	}
	
	/** 
	 * Constructor to initialise line number variable to passed in value
	 * 
	 * @param line
	 */
	public Node(ContextAndLine conAndLine)
	{
		contextAndLineOb = conAndLine;
	}
	
	/**
	 * Constructor to initialise line number variable to passed in value and nextNode to the 
	 * passed in Node.
	 *  
	 * @param line
	 * @param next
	 */
	public Node(ContextAndLine conAndLine, Node next)
	{
		contextAndLineOb = conAndLine;
		nextNode = next;
	}
	
	/**
	 * Method to return the number of lines that is stored in the Node.
	 * 
	 * @return lineNum
	 */
	public ContextAndLine getContextAndLine()
	{
		return contextAndLineOb;
	}
	
	/**
	 * Method to set the number of lines stored in the Node.
	 * 
	 * @param line
	 */
	public void setContextAndLine(ContextAndLine conAndLine)
	{
		contextAndLineOb = conAndLine;
	}
	
	/**
	 * Method to return the next node in the linked list.
	 * 
	 * @return nextNode
	 */
	public Node getNext()
	{
		return nextNode;
	}
	
	/**
	 * Method to set the next Node in the linked list.
	 * @param next
	 */
	public void setNext(Node next)
	{
		nextNode = next;
	}
}
