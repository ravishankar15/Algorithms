//https://www.geeksforgeeks.org/count-number-nodes-given-level-using-bfs/
public class CountNodesAtLevel {

    private AdjacencyList adjacencyList;
    private Vertex[] vertices;
    private QueueLL queue;
    private int level;
    private int count = 0;

    public CountNodesAtLevel(AdjacencyList adjacencyList, Vertex[] vertices, int level){
        this.adjacencyList = adjacencyList;
        this.vertices = vertices;
        this.level = level;
        this.queue = new QueueLL();
    }


    public  void countNoOfNodes(Vertex sVertex) {
        sVertex.setVisited(true);
        queue.enqueue(sVertex);
        while(!queue.isEmpty()){
            Vertex v = queue.dequeue();
            int index = adjacencyList.getIndex(v);
            ListNode currNode = adjacencyList.adjList[index];
            while(currNode.getNext() != null) {
                currNode = currNode.getNext();
                Vertex currVertex = currNode.getVertex();
                if (!currVertex.isVisited()){
                    int currLevel = v.getLevel();
                    currVertex.setLevel(currLevel + 1);
                    currVertex.setVisited(true);
                    queue.enqueue(currVertex);
                }
            }
        }


        for(Vertex v: vertices){
            if(v.getLevel() == level){
                count++;
            }
        }

        System.out.println(count);
    }



}