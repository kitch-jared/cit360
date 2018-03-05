package junit;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.junit.Ignore;
import org.junit.jupiter.api.Test;

/* include assertArrayEquals, assertEquals, assertFalse, assertNotNull, assertNotSame,
 *         assertNull, assertSame, assertThat, assertTrue.
 */

class JunitTests {

	@Test
	void SucceedEquals() {
		MethodsToTest test = new MethodsToTest();
		
		int output = test.addThese(3, 4);
		assertEquals(7, output); // values need to be equal to pass
	}
	
	@Test
	void FailEquals() {
		MethodsToTest test = new MethodsToTest();
		
		int output = test.addThese(3, 4);
		assertEquals(5, output);
	}
	
	@Ignore // you can ignore tests...
	void FailEqualsIgnored() {
		MethodsToTest test = new MethodsToTest();
		
		int output = test.addThese(3, 4);
		assertEquals(5, output);
	}
	
	@Test // you can test directly from your test without calling another class
	void SucceedArray() {
		String[] expected = {"Jared", "Ben", "Devin"};
		String[] actual = {"Jared", "Ben", "Devin"};
		
		assertArrayEquals(expected, actual); // arrays need to be equal to pass
	}
	
	@Test
	void FailArray() {
		String[] expected = {"Jared", "Ben", "Devin"};
		String[] actual = {"Jared", "Ben", "Troy"};
		
		assertArrayEquals(expected, actual);
	}
	
	@Test
	void SucceedFalse() {
		assertFalse(false); // a boolean test...
	}
	
	@Test
	void FailFalse() {
		assertFalse(true);
	}
	
	@Test
	void SucceedTrue() {
		assertTrue(true);
	}
	
	@Test
	void FailTrue() {
		assertTrue(false);
	}
	
	@Test
	void SucceedNull() {
		assertNull(null); // test for null values...
	}
	
	@Test
	void FailNull() {
		assertNull(101);
	}
	
	@Test
	void SucceedNotNull() {
		assertNotNull(101);
	}
	
	@Test
	void FailNotNull() {
		assertNotNull(null);
	}
	
	@Test
	void SucceedSame() { // this succeeds because they reference the same memory space
		MethodsToTest test = new MethodsToTest();
		
		int[] firstArray = test.produceSameArray();
		int[] secondArray = firstArray;
		
		assertSame(firstArray, secondArray);
	}
	
	@Test
	void FailSame() { // this fails. even though the arrays are equal, they are not the same array
		MethodsToTest test = new MethodsToTest();
		
		int[] firstArray = test.produceSameArray();
		int[] secondArray = test.produceSameArray();
		
		assertSame(firstArray, secondArray);
	}
	
	@Test
	void SucceedNotSame() {
		MethodsToTest test = new MethodsToTest();
		
		int[] firstArray = test.produceRandomArray();
		int[] secondArray = test.produceRandomArray();
		
		assertNotSame(firstArray, secondArray);
	}
	
	@Test
	void FailNotSame() {
		MethodsToTest test = new MethodsToTest();
		
		int[] firstArray = test.produceSameArray();
		int[] secondArray = firstArray;
		
		assertNotSame(firstArray, secondArray);
	}
	
	@Test
	void SucceedThat() { // assertThat can be used to build matching statements
		                 // assertThat(<actual>, <matcher statement>)
		
		assertThat(1, is(1)); // the same as an assertEquals
		assertThat(1, is(not(2)));
		assertThat(true, is(true)); // the same as an assertTrue
	}
	
	@Test
	void FailThat() {
		assertThat(1, is(2));
		assertThat(1, is(not(1)));
	}
	
}
