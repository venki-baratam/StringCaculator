package org.egov.bootcamp;

import static junit.framework.Assert.assertTrue;
import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertFalse;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class StackTest {
	@Rule
	public ExpectedException thrown = ExpectedException.none();

	@Test
	public void shouldThrowNullPointerExceptionOnNullInsertion() throws Exception {
		Stack<Integer> stack = new Stack();
		thrown.expect(NullPointerException.class);
		stack.push(null);

	}

	@Test
	public void shouldThrowNullPointerExceptionOnEmptyStackPop() throws Exception {
		Stack<Integer> stack = new Stack();
		thrown.expect(NullPointerException.class);
		stack.pop();
	}

	@Test
	public void shouldThrowEmptyListOnEmptyStack() throws Exception {
		Stack<Integer> stack = new Stack();
		assertArrayEquals(new Integer[] {}, stack.toArray());
	}

	@Test
	public void shouldThrowZeroOnEmptyStack() throws Exception {
		Stack<Integer> stack = new Stack();
		assertEquals(0, stack.size());
	}

	@Test
	public void shouldThrowNullPointerExceptionOnNullAsSearchElement() throws Exception {
		Stack<Integer> stack = new Stack();
		thrown.expect(NullPointerException.class);
		stack.contains(null);
	}

	@Test
	public void shouldBeAbleToPushOnEmptyStack() throws Exception {
		Stack<Integer> stack = new Stack();
		stack.push(1);
		assertEquals(1, stack.size());
		assertArrayEquals(new Integer[] { 1 }, stack.toArray());
	}

	@Test
	public void shouldBeAbleToPushOnStack() throws Exception {
		Stack<Integer> stack = new Stack();
		stack.push(1);
		stack.push(2);
		stack.push(3);
		stack.push(4);
		assertEquals(4, stack.size());
		assertArrayEquals(new Integer[] { 1, 2, 3, 4 }, stack.toArray());
	}

	@Test
	public void shouldBeAbleToPop() throws Exception {
		Stack<Integer> stack = new Stack();
		stack.push(1);
		stack.pop();
		assertEquals(0, stack.size());
		assertArrayEquals(new Integer[] {}, stack.toArray());
	}

	@Test
	public void shouldBeAbleToGetAlreadyExistingElement() throws Exception {
		Stack<Integer> stack = new Stack();
		stack.push(1);
		boolean contains = stack.contains(1);
		assertTrue(contains);
		boolean contains1 = stack.contains(2);
		assertFalse(contains1);
		assertArrayEquals(new Integer[] { 1 }, stack.toArray());
	}

}
