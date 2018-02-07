import java.util.*;
public class CharCountProblem{
	private int MAX_CHAR = 26;
	//http://www.geeksforgeeks.org/minimum-sum-squares-characters-counts-given-string-removing-k-characters/
	public int getMinValue(String str, int k){

        //Array to store the frequency of the charecters
		int[] freq = new int[MAX_CHAR];

        //Loop to find the frequency of charecters
        //'a' is subracted so that he char value is stored from 0 to 26
		for(int i=0; i<str.length(); i++)
			freq[str.charAt(i) - 'a']++;

        //Priority queue that store the minimum value in the front
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>(new Comparator<Integer>(){
            @Override
            public int compare(Integer a, Integer b) {
                return b.compareTo(a);
            }
        });

        //Add the frequency value to this priority queue
		for(int i=0; i<MAX_CHAR; i++){
			if(freq[i] != 0){
				pq.add(freq[i]);
			}
		}

        //Subract the charecters from the maximum frequent value
        //Since its a priority queue it stores the maximum value in the front
		while(k-- > 0){
			int temp = pq.poll();
			temp = temp - 1;
			pq.add(temp);
		}

        //Calculate the value of the string
		int result = 0;
		while(!pq.isEmpty()){
			int temp = pq.poll();
			result += temp*temp;
		}

		return result;
	}

	//http://www.geeksforgeeks.org/queue-based-approach-for-first-non-repeating-character-in-a-stream/
	public void firstNonRepeat(String str){
		int[] freq = new int[MAX_CHAR];
		Queue<Character> q = new LinkedList<Character>();

		//Traverse all the charecters in the string
		for(int i=0; i<str.length(); i++){
			char c = str.charAt(i);
			//Push each charecters into the queue
			q.add(c);

			//Increment its frequency
			freq[c - 'a']++;

			while(!q.isEmpty()){

				//If the frequency is > 1 than it is a repeating character
				//So remove it from queue
				if(freq[q.peek() - 'a'] > 1)
					q.remove();
				else{
					//Else its a non repeating character
					System.out.print(q.peek()+" ");
					break;
				}
			}
			//If queue is empty than there is no non repeating characters
			if(q.isEmpty())
				System.out.print(-1+" ");
		}
	}
}