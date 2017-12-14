public class LoopDetection{

	//Detects Loop using Floyd’s Cycle-Finding Algorithm
	public boolean detectLoop(ListNode head){
		ListNode slow = head;
		ListNode fast = head;

		while(slow != null && fast.getNext() != null){
			slow = slow.getNext();
			fast = fast.getNext().getNext();
			if(slow == fast)
				return true;
		}

		return false;
	}

	//Detects Loops starting using Floyd’s Cycle-Finding Algorithm
	public ListNode getLoopStart(ListNode head){
		ListNode slow = head;
		ListNode fast = head;

		//Floyd’s Cycle-Finding Algorithm for detecting the loop
		while(slow != null && fast.getNext() != null){
			slow = slow.getNext();
			fast = fast.getNext().getNext();
			if(slow == fast){
				ListNode pt1 = slow;
				ListNode pt2 = slow;

				//Move a slow pointer and count the steps it takes to reach the start point
				int k = 1;
				while(pt1.getNext() != pt2){	
					pt1 = pt1.getNext();
					k++;
				}

				//From the head position move one of the pointer to k distance
				pt1 = head;
				pt2 = head;
				while(k-- > 0){
					pt1 = pt1.getNext();
				}

				//Move both the pointers in same speed until  they meet
				while(pt1 != pt2){
					pt1 = pt1.getNext();
					pt2 = pt2.getNext();
				}

				//The meeting point is the start of the loop
				return pt1;
			}
		}

		return null;
	}

	//Detect and Remove the loop
	public ListNode detectAndRemoveLoop(ListNode head){
		ListNode slow = head;
		ListNode fast = head;

		while(slow != null && fast.getNext() != null){
			slow = slow.getNext();
			fast = fast.getNext().getNext();
			if(slow == fast){
				ListNode pt1 = slow;
				ListNode pt2 = slow;

				int k=1; 
				while(pt1.getNext() != pt2){
					pt1 = pt1.getNext();
					k++;
				}

				pt1 = head;
				pt2 = head;

				while(k-- > 0){
					pt2 = pt2.getNext();
				}

				while(pt1 != pt2){
					pt1 = pt1.getNext();
					pt2 = pt2.getNext();
				}

				//Till this point same as detecting loops starting point
				//Once loop is detected starting from the next ListNode find the loop's meeting point
				pt2 = pt2.getNext();
				while(pt2.getNext() != pt1){
					pt2 = pt2.getNext();
				}

				//Make the loop end point to null
				pt2.setNext(null);

			}
		}
		return head;

	}
}