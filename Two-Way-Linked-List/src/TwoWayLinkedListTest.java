
public class TwoWayLinkedListTest {
	
	public static void main(String[] args) {

		TwoWayLinkedList<Integer> numbers = new TwoWayLinkedList<>();

		// This section confirms that the methods getFirst() and addFirst() work properly
		numbers.addFirst(45);
		if (numbers.getFirst() == 45) {
			System.out.println("The methods getFirst() and addFirst() PASSES the test");
		} else {
			System.out.println("The methods getFirst() and addFirst() DONT pass the test");
		}

		// This section confirms that the methods clear() works properly
		numbers.clear();
		if (numbers.size == 0 && numbers.head == null && numbers.tail == null) {
			System.out.println("The method clear() PASSES the test");
		} else {
			System.out.println("The method clear() DOESNT pass the test");
		}

		// Section tests addLast() method
		numbers.addLast(56);
		if (numbers.getFirst() == 56) {
			System.out.println("The methods addLast() PASSES the test");
		} else {
			System.out.println("The methods addLast() DONT pass the test");
		}

		// Section tests add() method
		numbers.add(0,56);
		if (numbers.getFirst() == 56 && numbers.get(0) == 56 && numbers.lastIndexOf(56) == 1) {
			System.out.println("The methods add() and get() and lastIndexOf() PASSES the test");
		} else {
			System.out.println("The methods add() and get() and lastIndexOf() DONT pass the test");
		}

		// Section tests remove() method
		numbers.set(1, 22);
		numbers.remove(0);
		if (numbers.getFirst() == 22) {
			System.out.println("The methods set() and remove() PASSES the test");
		} else {
			System.out.println("The methods set() and remove() DONT pass the test");
		}

	}
}
