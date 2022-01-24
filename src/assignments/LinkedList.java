package assignments;

/**
 * Singly-Linked List
 * 
 * Access    Search    Insertion    Deletion
 * O(n) 	 O(n)      O(1)         O(1)
 *
 */

public class LinkedList {
	// Store head, tail, and length
		private Node head;
		private Node tail;
		private int length;
		
		/**
		 * The node class represents a node in a linked list
		 * 
		 */
		
		class Node {
			// Store node's value and a node to point to
			int value;
			Node next;
			
			/**
			 * This constructor sets the value of the node
			 * @param value Value
			 */
			
			Node(int value) {
				this.value = value;
			}
		}
		
		/**
		 * This constructor creates a new node and sets the head and tail to point to that node
		 * @param value Value of node
		 */
		
		public LinkedList(int x) {
			Node node = new Node(x);
			head = node;
			tail = node;
			length = 1; // Increase length
		}
		
		/**
		 * This method displays the nodes in a linked list
		 */
		
		public void printList() {
			// Create a temporary node that points to the head node
			Node temp = head;
			
			// Iterate through list until there is no item
			while (temp != null) {
				// Print out the item in the list
				System.out.println(temp.value);
				
				// Causes temp to move to next item by setting temp to Node that is next
				temp = temp.next;
			}
		}
		
		/**
		 * This method displays the head
		 */
		
		public void getHead() {
			System.out.println("Head: " + head.value);
		}
		
		/**
		 * This method displays the tail
		 */
		
		public void getTail() {
			System.out.println("Tail: " + tail.value);
		}
		
		/**
		 * This method displays the length of the list
		 */
		
		public void getLength() {
			System.out.println("Length: " + length);
		}
		
		/**
		 * This method appends a new node to the end of a list
		 * @param x Value of node
		 */
		
		public void append(int x) {
			// Create a new node with value x
			Node newNode = new Node(x);
			
			// If there are no items, set the head and tail to newNode
			if (length == 0) {
				head = newNode;
				tail = newNode;
			}
			// Else, set the reference of the last tail to the new tail and make tail point to the new node
			else {
				tail.next = newNode;
				tail = newNode;
			}
			
			length++; // Incremenent list length
		}
		
		
		/**
		 * This method removes the last node in a list
		 * @return Removed node
		 */
		
		public Node removeLast() {
			if (length == 0) return null;
			
			// Set two temporary pointers
			Node temp = head, pre = head;
			
			// Iterate through list while the next Node is not null
			while (temp.next != null) {
				// Set pre equal to temp and then move temp to the next Node
				pre = temp;
				temp = temp.next;
			}
			
			// Set the tail to where pre left off and set it's "next" reference to null to make it the last node
			tail = pre;
			tail.next = null;
			
			// Decrement length
			length--; 
			
			// If length is 0, set head and tail to null (is not done automatically)
			if (length == 0) {
				head = null;
				tail = null;
			}
			
			// Return temp node (node that was removed)
			return temp;
		}
		
		/**
		 * This method adds a node to the beginning of the list
		 * @param value Value of node
		 */
		
		public void prepend(int value) {
			// Create new node
			Node newNode = new Node(value);
			
			// If length is 0, set head and tail to the new node
			if (length == 0) {
				head = newNode;
				tail = newNode;
			}
			// Set "next" reference of the new node to the original head.
			// Then, set head to the new node
			else {
				newNode.next = head;
				head = newNode;
			}
			
			length++; // Increment length
		}
		
		/**
		 * Removes the first node
		 * @return Removed node
		 */
		
		public Node removeFirst() {
			if (length == 0) return null;
			
			// Temp node
			Node temp = head;
			
			// Head is equal to the next node
			head = head.next;
			// Temp's link is equal to null
			temp.next = null;
			length--;
			
			// If length is 0, head is at null, so tail should be at null too
			if (length == 0) {
				tail = null;
			}
			
			return temp;
		}
		
		/**
		 * Returns a node at an index
		 * @param index Index
		 * @return Node
		 */
		
		public Node get(int index) {
			if (index < 0 || index >= length) return null;
			int counter = 0;
			
			// Temp node
			Node temp = head;
			
			// Loop through list until index is the same as counter (which starts as zero and is incremented each
			// time the temp node iterates through the list). If index is same as counter, return the node. Else,
			// move the node to next node
			while (temp != null) {
				if (index == counter)
					return temp;
				else {
					counter++;
					temp = temp.next;
				}
			}
			
			return temp;
		}
		
		/**
		 * Insert a node
		 * @param index Desired index
		 * @param value Value
		 * @return Whether or not insert was successful
		 */
		
		public boolean insert(int index, int value) {
			if (index < 0 || index > length) return false;
			
			if (index == 0) 
				prepend(value);
			else if (index == length) 
				append(value);
			else {
				// Create new node with value and a temp node
				// that is behind the node at index
				Node newNode = new Node(value);
				Node temp = get(index - 1);
				
				// Set the new node link to temp's link (index + 1)
				newNode.next = temp.next;
				
				// Set temp's link to the new node (index)
				temp.next = newNode;
			}
			
			length++;
			return true;
		}
		
		/**
		 * Set the value of a node
		 * @param index Index of node
		 * @param value Desired value
		 * @return Whether or not set was successful
		 */
		
		public boolean set(int index, int value) {
			// Set node equal to node at index
			Node node = get(index);
			
			// If node is not null, set it's value and return true
			// Else return false
			if (node != null) {
				node.value = value;
				return true;
			}
			return false;
		}
		
		/**
		 * Remove a node from an index
		 * @param index Index
		 * @return Removed node
		 */
		
		public Node remove(int index) {
			if (index < 0 || index >= length) return null;
			if (index == 0) return removeFirst();
			else if (index == length - 1) return removeLast();
			else {
				// Create a node that is equal to the node before the one at the index
				Node previous = get(index - 1);
				// Create a node that is equal to the node at the index
				Node temp = previous.next;
				
				// Set the previous node's link to the temp's link (the node that comes after the node at an index)
				// Set the temp's link to null to get rid of it
				previous.next = temp.next;
				temp.next = null;
				
				length--; // Decrement length
				return temp;
			}	
		}

		/**
		 * Reversing a linked list
		 */
		
		public void reverse() {
			// Swap head and tail
			Node temp = head;
			head = tail;
			tail = temp;
			
			// Create nodes coming before temp and one coming after temp
			Node before = null;
			Node after = temp.next;
			
			// Iterate through list
			for (int i = 0; i < length; i++) {
				after = temp.next; // Set the after node to come after temp (already done on 1st iteration)
				temp.next = before; // Set the temp node to point to the node before it
				before = temp; // Set the before node to temp to move it up
				temp = after; // Set temp to after to move it up as well
			}
		}
}
