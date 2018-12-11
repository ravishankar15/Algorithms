public class BreadthFirstSearch {

	private AdjacencyList adjacencyList;
	private QueueLL queue;

	public BreadthFirstSearch(AdjacencyList adjacencyList){
		this.adjacencyList = adjacencyList;
		this.queue = new QueueLL();
	}

	public void calcBFS(Vertex sVertex){
		sVertex.setVisited(true);
		queue.enqueue(sVertex);
		while(!queue.isEmpty()) {
			Vertex vertex = queue.dequeue();
			System.out.print(vertex.getName() + " ");
			int index = adjacencyList.getIndex(vertex);
			ListNode currNode = adjacencyList.adjList[index];
			while(currNode.getNext() != null){
				currNode = currNode.getNext();
				Vertex currVertex = currNode.getVertex();
				if (!currVertex.isVisited()){
					currVertex.setVisited(true);
					queue.enqueue(currVertex);
				}
			}
		}
	}

}