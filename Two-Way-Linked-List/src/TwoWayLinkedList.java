import java.util.Iterator;
import java.util.ListIterator;
import java.util.NoSuchElementException;


public class TwoWayLinkedList<T> implements MyList<T>{

	Node head, tail = null;
	int size = 0;

	public TwoWayLinkedList<T> addFirst(T data) {
		// TODO Auto-generated method stub
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

	public TwoWayLinkedList<T> addLast(T data) {
		// TODO Auto-generated method stub
		Node temp = new Node(tail,data,null);
		if (tail != null)
			tail.next = temp;
		tail = temp;
		if (head == null)
			head = temp;
		size++;
		return this;
	}

	public TwoWayLinkedList<T> removeFirst() {
		Node temp = head;
		head = temp.next;
		size--;
		return this;
	}

	public TwoWayLinkedList<T> removeLast() {
		Node temp = tail;
		tail = temp;
		size--;
		return this;
	}

	public T getFirst() {
		// TODO Auto-generated method stub
		return head.data;
	}

	public T getLast() {
		// TODO Auto-generated method stub
		return tail.data;
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		head = null;
		tail = null;
		size = 0;
	}

	@Override
	public boolean contains(Object arg0) {
		// TODO Auto-generated method stub
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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return size;
	}

	@Override
	public void add(int index, T e) {
		// TODO Auto-generated method stub
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
		// TODO Auto-generated method stub
		Node current = head;

		for (int i = 0; i <= index; i++)
			current = head.next;

		return current.data;
	}

	@Override
	public int indexOf(Object e) {
		// TODO Auto-generated method stub
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
		// TODO Auto-generated method stub
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
		// TODO Auto-generated method stub
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
		// TODO Auto-generated method stub
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
