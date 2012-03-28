package concordance.tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import concordance.data.ContextAndLine;
import concordance.data.LinkedList;

public class LinkedListTest 
{
	LinkedList linkedList;
	
	@Before
	public void setUp()
	{
		linkedList = new LinkedList();
	}
	
	@Test 
	public void testAddWhenEmpty()
	{
		int line = 9;
		String before = "Well";
		String after = "there";
		ContextAndLine context = new ContextAndLine(line, before, after);
		linkedList.add(context);
		
		ContextAndLine result = linkedList.getHead();
		
		assertEquals("The ContextAndLine objects do not match", context, result);
	}
	
	@Test 
	public void testAddWhenNotEmpty()
	{
		int line1 = 9;
		String before1 = "Well";
		String after1 = "there";
		ContextAndLine context1 = new ContextAndLine(line1, before1, after1);
		linkedList.add(context1);
		
		int line = 10;
		String before = "Hat";
		String after = "cat";
		ContextAndLine context = new ContextAndLine(line, before, after);
		linkedList.add(context);
		
		ContextAndLine[] expected = new ContextAndLine[2];
		expected[0] = context1;
		expected[1] = context;
		
		ContextAndLine[] result = linkedList.getAll();
		
		assertEquals("The ContextAndLine objects do not match", expected, result);
	}
	
	@Test
	public void testIsEmpty()
	{
		boolean isEmptyResult = linkedList.isEmpty();
		assertTrue("Linked List is not empty", isEmptyResult);
	}
	
	@Test
	public void testLength()
	{
		int line1 = 9;
		String before1 = "Well";
		String after1 = "there";
		ContextAndLine context1 = new ContextAndLine(line1, before1, after1);
		linkedList.add(context1);
		
		int line = 10;
		String before = "Hat";
		String after = "cat";
		ContextAndLine context = new ContextAndLine(line, before, after);
		linkedList.add(context);
		
		int expectedLength = 2;
		int length = linkedList.length();
		
		assertEquals("The length does not match", expectedLength, length);
	}
}
