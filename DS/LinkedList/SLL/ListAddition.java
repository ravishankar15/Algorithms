public class ListAddition{

	private ListNode result;
	private int carry = 0;

	/* Begin - Adding 1 to a number represented as list */

	//Adding one to a linked list represented as numbers
	public ListNode addOneToList(ListNode head){
		carry = addOneWithCarry(head);

		/*After the function call if there is carry left 
			create a new ListNode and add the ListNode to the begining*/
		if(carry > 0){
			ListNode temp = new ListNode(carry, head);
			head = temp;
		}

		return head;
	}
	//Recursively adding one to the list
	public int addOneWithCarry(ListNode head){
		/*When head reaches the NULL it will 
			return the value 1 to be added to the last ListNode*/
		if(head == null)
			/*return the value to be added to list 
				in this case 1 we can return 2 or 3 or any*/
			return 1; 
		int sum = head.getData() + addOneWithCarry(head.getNext());
		head.setData(sum % 10); //Change the data in that particular ListNode
		return sum / 10; //Return the carry value to be added in the sum
	}

	/* End - Adding 1 to a number represented as list */


	/* Begin - Recursive - Adding two list as a Number */

	public ListNode addTwoNumAsList(ListNode head1, ListNode head2){

		//Calculate the size of the two list
		int h1s = getSize(head1);
		int h2s = getSize(head2);
		int carry = 0;
		if(h1s == h2s){
			result = addSameSize(head1, head2);
		} else {

			/*Always 1st List should be greated in length 
				than the second one if not swap the head pointers*/
			if(h1s < h2s){
				ListNode temp = head1;
				head1 = head2;
				head2 = temp;
			}

			//Find the absolute diffrence between the two list
			int dif = Math.abs(h1s - h2s);

			/*Move the longer list in this case always the 1st list 
				to dif position from the start*/
			ListNode temp = head1;
			while(dif-- > 0){
				temp = temp.getNext();
			}

			/*At this point temp and head2 should be of same size
				Add them using the addSameSize() method*/
			result = addSameSize(temp, head2);

			/*Add the remaining part of the head1 list to the result
				if there is carry retruned propagate that to by adding to the 
			value*/
			result = propagateCarry(head1, temp);
		}

		/*If there is carry present in this point, 
			create a new ListNode and add it before the result
		This point will be reached when adding 999 and 9*/
		if(carry > 0){
			ListNode temp = new ListNode(carry, result);
			result = temp;
		}
		return result;

	}

	/*After adding the same size list we need to,
		add the carry to the begining part of the longer list*/
	public ListNode propagateCarry(ListNode head1, ListNode diffPoint){
		if(head1 != diffPoint){
			propagateCarry(head1.getNext(), diffPoint);
			int sum = head1.getData() + carry; //Carry is declared as global variable
			carry = sum / 10;
			sum = sum % 10;

			/* Add the sum to the new ListNode and 
				place it before the result */
			ListNode temp = new ListNode(sum, result);
			result = temp;
		}
		return result;
	}

	//Adding two list recursively of same size
	public ListNode addSameSize(ListNode head1, ListNode head2){

		if(head1 == null)
			return result;
		
		addSameSize(head1.getNext(), head2.getNext());

		int sum = head1.getData() + head2.getData() + carry;
		carry = sum / 10;
		sum = sum % 10;

		ListNode temp = new ListNode(sum, result);
		result = temp;

		return result;


	}
	/*Utility method for getting the size of the list*/
	public int getSize(ListNode head){
		int count = 0;
		while(head != null){
			head = head.getNext();
			count++;
		}
		return count;
	}
	/* End - Recursive - Adding two list as a Number */

	/* Assuming that the two list are in reverse order 
		and each ListNode represents a single digit */
	public ListNode addTwoLinkedList(ListNode head1, ListNode head2){
		ListNode res = new ListNode(0, null);
		ListNode result = res;
		int carry = 0;
		while(head1 != null && head2 != null){
			int value = head1.getData() + head2.getData() + carry;
			if(value > 9){
				carry = 1;
				value = value % 10;
			} else {
				carry = 0;
			}

			ListNode temp = new ListNode(value, null);
			result.setNext(temp);
			result = result.getNext();
			head1 = head1.getNext();
			head2 = head2.getNext();
		}

		while(head1 != null){
			int value = head1.getData() + carry;
			if(value > 9){
				carry = 1;
				value = value % 10;
			} else {
				carry = 0;
			}			
			ListNode temp = new ListNode(value, null);
			result.setNext(temp);
			result = result.getNext();
			head1 = head1.getNext();
		}

		while(head2 != null){
			int value = head2.getData() + carry;
			if(value > 9){
				carry = 1;
				value = value % 10;
			} else {
				carry = 0;
			}			
			ListNode temp = new ListNode(value, null);
			result.setNext(temp);
			result = result.getNext();
			head2 = head2.getNext();
		}

		if(carry == 1){
			ListNode temp = new ListNode(carry, null);
			result.setNext(temp);
		}

		return res.getNext();
	}
}