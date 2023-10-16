
/**
 * IMPORTANT: Do not change the method headers. Your tests will be run against
 * good and bad implementations of MyLinkedList. You will only receive points
 * if your test passes when run on a good implementation and fails for the
 * corresponding bad implementation.
 */

import static org.junit.Assert.*;
import org.junit.*;

public class MyLinkedListCustomTester {
	private MyLinkedList<Integer> emptyIntegerList;
    private MyLinkedList<String> threeStringList;
    private String[] strData = {"CSE 12", "Paul Cao", "Christine Alvarado"};

	// Optional: add test variables here

	/**
	 * This sets up the test fixture. JUnit invokes this method before
	 * every testXXX method. The @Before tag tells JUnit to run this method
	 * before each test.
	 */
	@Before
	public void setUp() throws Exception {
		// Optional: add setup here
		emptyIntegerList = new MyLinkedList<Integer>();
        threeStringList = new MyLinkedList<>();
	}

	private void populateLinkedList() {
        MyLinkedList<String>.Node node0 =  
            this.threeStringList.new Node(this.strData[0]);
        MyLinkedList<String>.Node node1 =  
            this.threeStringList.new Node(this.strData[1]);
        MyLinkedList<String>.Node node2 =  
            this.threeStringList.new Node(this.strData[2]);

        this.threeStringList.head.next = node0;
        node0.prev = this.threeStringList.head;
        node0.next = node1;
        node1.prev = node0;
        node1.next = node2;
        node2.prev = node1;
        node2.next = this.threeStringList.tail;
        this.threeStringList.tail.prev = node2;
        this.threeStringList.size = 3;
    }



	/**
	 * Aims to test the add(E data) method with a valid argument.
	 */
	@Test
	public void testCustomAdd() { // done
		this.populateLinkedList();
		// TODO: add your test here
		this.threeStringList.add("oh");
		MyLinkedList<String>.Node node1 = this.threeStringList.tail.prev;
        assertEquals("oh", this.threeStringList.tail.prev.data);
		assertEquals(node1, threeStringList.tail.prev);
		assertEquals(4, this.threeStringList.size);
	}

	/**
	 * Aims to test the add(int index, E data) method.
	 * Add a valid argument to the beginning of MyLinkedList.
	 */
	@Test
	public void testCustomAddIdxToStart() {// DONE
		// TODO: add your test here
		this.populateLinkedList();
		this.threeStringList.add(0,"Gary Gillespie");
        assertEquals("Gary Gillespie", this.threeStringList.head.next.data);
		assertEquals( 4, this.threeStringList.size);
	}

	/**
	 * Aims to test the add(int index, E data) method.
	 * Add a valid argument to the middle of MyLinkedList.
	 */
	@Test
	public void testCustomAddIdxToMiddle() {
		// TODO: add your test here
		this.populateLinkedList();
		this.threeStringList.add(1,"Gary Gillespie");
        assertEquals("Gary Gillespie", this.threeStringList.head.next.next.data);
		assertEquals(4, this.threeStringList.size);

	}

	/**
	 * Aims to test the remove(int index) method. Remove from an empty list.
	 */
	@Test
	public void testCustomRemoveFromEmpty() { //DONE
		// TODO: add your test here
		assertThrows(IndexOutOfBoundsException.class, () -> {
			emptyIntegerList.remove(0);
		});
	}

	/**
	 * Aims to test the remove(int index) method.
	 * Remove a valid argument from the middle of MyLinkedList.
	 */
	@Test
	public void testCustomRemoveFromMiddle() {
		// TODO: add your test here
        this.populateLinkedList();
        MyLinkedList<String>.Node node1 = this.threeStringList.tail.prev;
        String removedNode = this.threeStringList.remove(1);
        assertSame("Old node at position 0 should be removed", 
            node1, this.threeStringList.tail.prev);
        assertSame("Old node at position 0 should be removed  0", 
            node1.prev.prev, this.threeStringList.head);
        assertEquals("Removed node should be returned Correctly",
            removedNode, "Paul Cao");
        assertEquals(2, this.threeStringList.size());

	}

	/**
	 * Aims to test the set(int index, E data) method.
	 * Set an out-of-bounds index with a valid data argument.
	 */
	@Test
	public void testCustomSetIdxOutOfBounds() {
		// TODO: add your test here
		assertThrows(IndexOutOfBoundsException.class,() -> {
			threeStringList.set(8, "cat");
		});
	}

	@Test
	public void Mytest(){
		this.populateLinkedList();
		assertEquals(3, this.threeStringList.size);
		for(int i=0; i < 100; i++){
			threeStringList.add(i,"meow");
			assertEquals("meow", this.threeStringList.get(i));
		}
	}

}
