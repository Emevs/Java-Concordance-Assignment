package concordance.tests;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Before;
import org.junit.Test;

import concordance.data.Reader;
import concordance.data.LinkedList;

public class ReaderTest 
{
	Reader reader;
	@Before
	public void setUp()
	{
		reader = new Reader();
	}
	
	@Test
	public void testIndexReader()
	{
		reader.IndexReader("testIndex.txt");
		String[] indexWords = reader.getAndSortIndexWords();
		assertNotNull("Index words array is empty, file was not read", indexWords);
	}
	

	@Test
	public void testSourceReader()
	{
		reader.IndexReader("testIndex.txt");
		reader.SourceReader("testSource.txt");
		String word = "was";
		LinkedList contextAndLines = reader.getLinkedList(word);
		assertNotNull("Linked List is empty, file was not read", contextAndLines);
	}
	
	@Test
	public void testGetAndSortIndexWords()
	{
		reader.IndexReader("testIndex.txt");
		String[] indexArray = reader.getAndSortIndexWords();
		String[] expectedIndexArray = new String[10];
		expectedIndexArray[0] = "daughters";
		expectedIndexArray[1] = "life";
		expectedIndexArray[2] = "little";
		expectedIndexArray[3] = "mean";
		expectedIndexArray[4] = "she";
		expectedIndexArray[5] = "temper";
		expectedIndexArray[6] = "visiting";
		expectedIndexArray[7] = "was";
		expectedIndexArray[8] = "wife";
		expectedIndexArray[9] = "woman";
		
		assertEquals("Index Arrays do not match", expectedIndexArray, indexArray);
	}
}
