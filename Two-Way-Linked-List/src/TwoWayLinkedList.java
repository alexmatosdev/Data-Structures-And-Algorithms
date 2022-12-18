import java.util.Iterator;


public class TwoWayLinkedList<T> implements MyList<T>{

	Node head, tail = null;
	int size = 0;

	/*
	 * Adds a node to the front of the list
	 * @param data used to create the node
	 * @return the node that was added
	 */
	public TwoWayLinkedList<T> addFirst(T data) {
		// If list is empty, add node to the front
		if (isEmpty()) {
			head = new Node(null,data,tail);
			tail = new Node(head,data,null);
			size++;
			return this;
		}
		Node temp = new Node(null,data,head);
		head.previous = temp;
		head = temp;
		if (tail == null)
			tail = temp;
		return this;
	}

	/*
	 * Adds node to the end of the list
	 * @param data used to create the node 
	 * @return node that was added to the list
	 */
	public TwoWayLinkedList<T> addLast(T data) {
		
		Node temp = new Node(tail,data,null);
		if (tail != null)
			tail.next = temp;
		tail = temp;
		if (head == null)
			head = temp;
		size++;
		return this;
	}
	/*
	 * Removes first element in the list
	 */
	public TwoWayLinkedList<T> removeFirst() {
		Node temp = head;
		head = temp.next;
		size--;
		return this;
	}

	/*
	 * Removes last element in the list
	 */
	public TwoWayLinkedList<T> removeLast() {
		Node temp = tail;
		tail = temp;
		size--;
		return this;
	}
	
	/*
	 * Returns the data from the head node
	 */
	public T getFirst() {
		
		return head.data;
	}

	/*
	 * Returns the data from the last node in the list
	 */
	public T getLast() {
		return tail.data;
	}

	@Override
	public void clear() {
		head = null;
		tail = null;
		size = 0;
	}

	@Override
	public boolean contains(Object arg0) {
		Node current = head;

		for (int i = 0; i < size; i++) {
			if (current == arg0)
				return true;
			current = head.next;
		}
		return false;
	}

	@Override
	public Iterator<T> iterator() {
		return null;
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public void add(int index, T e) {
		if (index == size) {
			addLast(e);
			size++;
			return;
		}
		else if (index == 0) {
			addFirst(e);
			size++;
			return ;
		}
		Node curr = head;
		for (int i = 0; i < index; i++) {
			curr = curr.next;
		}
		Node t = curr;
		t.next = new Node(t, e, curr.next.next);
		curr.next.next.previous = t;
		size++;
	}

	@Override
	public T get(int index) {
		Node current = head;

		for (int i = 0; i <= index; i++)
			current = head.next;

		return current.data;
	}

	@Override
	public int indexOf(Object e) {
		Node current= head;

		for (int i = 0; i < size; i++) {
			if (current == e) {
				return i;
			}
			current = head.next;
		}

		return -1;
	}

	@Override
	public int lastIndexOf(T e) {
		int lastIndex = 0;
		Node current = head;

		for (int i = 0; i < size; i++) {
			if (current.data == e) {
				lastIndex = i;
			}
			current = current.next;
		}
		return lastIndex;
	}

	@Override
	public T remove(int index) {
		if (index > size || index < 0) {
			return null;
		}
		if (index == 0) {
			T t = get(index);
			removeFirst();
			return t;
		}
		else if (index == size) {
			T t = get(index);
			removeLast();
			return t;
		}
		else {
			Node curr = head;
			for (int i = 0; i < index; i++) {
				curr = curr.next;
			}
			Node t = curr;
			t.previous.next = t.next;
			t.next.previous = t.previous;
			size--;
			return t.data;
		}
	}

	@Override
	public T set(int index, T e) {
		Node current = head;

		for (int i = 0; i <= index; i++) {
			if (i == index) {
				current.data = e;
				return e;
			}
			current = current.next;
		}
		return null;
	}

	
	public class Node {

		public T data;
		public Node next,previous;

		public Node (Node previous, T data, Node next) {
			this.data = data;
			this.previous = previous;
			this.next = next;
		}
	}

	
}
