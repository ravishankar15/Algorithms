//https://www.geeksforgeeks.org/connect-n-ropes-minimum-cost/
public class ConnectRopes{
	
	private int heapSize;
	private int minCost;
	private int[] harr;

	public ConnectRopes(){
		heapSize = 0;
		minCost = 0;
	}

	public void connect(int[] arr){
		heapSize = arr.length;
		harr = new int[heapSize];
		//Copy to heap array
		harr = arr;

		//Construct the heap
		for(int i = heapSize/2 - 1; i>=0; i--)
			heapify(i);

		//Calculate the Minimum cost
		while(!(heapSize == 1)){
			int curlen = extractMin() + extractMin();
			minCost = minCost + curlen;
			insert(curlen);
		}

		System.out.println(minCost);
	}

	private void swap(int a, int b){
		int temp = harr[a];
		harr[a] = harr[b];
		harr[b] = temp;
	}

	private int parent(int i){
		return (i-1)/2;
	}

	private void insert(int key){

		int i = heapSize;
		heapSize++;
		harr[i] = key;

		while(i != 0 && harr[parent(i)] > harr[i]){
			swap(parent(i), i);
			i = parent(i);
		}
	}

	private int extractMin(){

		if(heapSize == 1){
			heapSize--;
			return harr[0];
		}

		int result = harr[0];
		harr[0] = harr[heapSize - 1];
		heapSize--;

		heapify(0);

		return result;


	}

	private void heapify(int i){
		int smallest = i;
		int l = (2*i) + 1;
		int r = (2*i) + 2;

		if(l < heapSize && harr[l] < harr[i])
			smallest = l;
		if(r < heapSize && harr[r] < harr[smallest])
			smallest = r;

		if(smallest != i){
			swap(i, smallest);
			heapify(smallest);
		}
	}

}