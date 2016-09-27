package org.egov.bootcamp;

import org.egov.bootcamp.model.Node;

public class Stack<T> {
	private Node<T> head;
	private Node<T> previous;

	public void push(T element) {
		if (element == null)
			throw new NullPointerException();
		Node<T> newNode = new Node<>(element);

		if (head == null) {
			head = newNode;
		} else {
			previous = head;
			head = newNode;
			head.setPrevious(previous);
		}
	}

	public boolean pop() {
		if (isEmpty())
			throw new NullPointerException();
		head = head.getPrevious();
		return true;
	}

	public int size(Node<T> stackPointer, int totalLength) {
		if (stackPointer == null) {
			return totalLength;
		}
		return size(stackPointer.getPrevious(), ++totalLength);
	}

	public int size() {
		return size(head, 0);
	}

	public boolean isEmpty() {
		return size() == 0;
	}

	public T[] toArray() {
		int stackLength = this.size();
		T[] array = (T[]) new Object[stackLength];
		Node stackPointer = head;
		for (int i = stackLength - 1; i >= 0; i--) {
			array[i] = (T) stackPointer.getValue();
			stackPointer = stackPointer.getPrevious();
		}
		return array;
	}

	public boolean contains(T element) {
		if (element == null)
			throw new NullPointerException();
		Node<T> node = new Node<>(element);
		Node stackPointer = head;
		for (int i = 0; i < this.size(); i++) {
			if (stackPointer.equals(node))
				return true;
			else
				stackPointer = stackPointer.getPrevious();

		}
		return false;
	}

}
