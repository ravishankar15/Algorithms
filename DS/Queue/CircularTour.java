//http://www.geeksforgeeks.org/find-a-tour-that-visits-all-stations/
import java.util.*;
public class CircularTour{
	//Return the starting point of the tour
	public int getStartOfTour(PetrolPump[] arr, int n){
		int start = 0;
		int end = 1;
		int curr_petrol = arr[start].getPetrol() - arr[start].getDistance();

		while(curr_petrol < 0 || start != end){

			// If current amount of petrol in truck becomes less than 0, then
            // remove the starting petrol pump from tour
			while(curr_petrol < 0 && start != end){

				//Remove the starting petrol pump and move the start pointer
				curr_petrol -= arr[start].getPetrol() - arr[start].getDistance();
				start = (start + 1)%n;

				if(start == 0)
					return -1;

			}
			//Add petrol pump to current tour
			curr_petrol += arr[end].getPetrol() - arr[end].getDistance();
			end = (end + 1)%n;
		}
		return start;
	}

	//Same problem implemented using Queue
	public int getStartOfTourQ(PetrolPump[] arr, int n){
		Queue<Integer> q = new LinkedList<Integer>();

		//Enqueue the first petrol pump to queue
		int i = 0;
		int curr_petrol = arr[i].getPetrol() - arr[i].getDistance();
		q.add(i++);

		//Enqueue the petrol pumps to queue till we either reach 
		//the end of tour or the current petrol becomes negative
		while(i<n){
			
			//If the current petrol becomes negative
			//We dequeue the elements till we get current petrol positive
			//or the queue becomes empty
			while(!q.isEmpty() && curr_petrol < 0){
				int temp = q.poll();
				curr_petrol -= (arr[temp].getPetrol() - arr[temp].getDistance());
			}

			curr_petrol += arr[i].getPetrol() - arr[i].getDistance();
			q.add(i++);
		}
		//The front of the queue indicates the start of the tour
		return q.poll();
	}
}