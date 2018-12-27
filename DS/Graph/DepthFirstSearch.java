//https://www.geeksforgeeks.org/depth-first-search-or-dfs-for-a-graph/
public class DepthFirstSearch{
    
    private AdjacencyList adjacencyList;
    
    public DepthFirstSearch(AdjacencyList adjacencyList) {
        this.adjacencyList = adjacencyList;
    }


    public void dfsRecur(Vertex vertex){
        vertex.setVisited(true);
        System.out.print(vertex.getName() +" ");
        int index = adjacencyList.getIndex(vertex);
        ListNode currNode = adjacencyList.adjList[index];
        while(currNode.getNext() != null){
            currNode = currNode.getNext();
            Vertex currVertex = currNode.getVertex();
            if (!currVertex.isVisited()){
                dfsRecur(currVertex);
            }
        }
    }
}