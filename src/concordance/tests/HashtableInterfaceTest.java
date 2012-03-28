package concordance.tests;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import concordance.data.ContextAndLine;
import concordance.data.HashtableInterface;
import concordance.data.LinkedList;

public class HashtableInterfaceTest 
{
	HashtableInterface hash;
	
	@Before
	public void setUp()
	{
		hash = new HashtableInterface();
	}
	
	@Test
	public void testAddWhenEmpty()
	{
		String word = "hello";
		LinkedList linkedList = new LinkedList();
		int line = 9;
		String before = "why";
		String after = "there";
		ContextAndLine conAndLinesOb = new ContextAndLine(line, before, after);
		linkedList.add(conAndLinesOb);
		hash.add(word, linkedList);
	
		LinkedList resultList = hash.get(word);
		
		assertEquals("Line numbers do not match", linkedList, resultList);
	}
	
	@Test
	public void testAddWhenNotEmpty()
	{
		String word1 = "hello";
		LinkedList linkedList1 = new LinkedList();
		int line1 = 9;
		String before1 = "why";
		String after1 = "there";
		ContextAndLine conAndLinesOb1 = new ContextAndLine(line1, before1, after1);
		linkedList1.add(conAndLinesOb1);
		hash.add(word1, linkedList1);	
		
		String word2 = "are";
		LinkedList linkedList2 = new LinkedList();
		int line2 = 9;
		String before2 = "what";
		String after2 = "you";
		ContextAndLine conAndLinesOb2 = new ContextAndLine(line2, before2, after2);
		linkedList2.add(conAndLinesOb2);
		hash.add(word2, linkedList2);
		
		LinkedList resultList1 = hash.get(word1);
		LinkedList resultList2 = hash.get(word2);
		
		assertEquals("Line numbers do not match", linkedList1, resultList1);
		assertEquals("Line numbers do not match", linkedList2, resultList2);
	}
}