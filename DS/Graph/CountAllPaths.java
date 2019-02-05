//https://www.geeksforgeeks.org/count-possible-paths-two-vertices/
public class CountAllPaths {

    private AdjacencyList adjacencyList;
    private Vertex[] vertices;
    private int pathCount = 0;

    public CountAllPaths(AdjacencyList adjacencyList, Vertex[] vertices){
        this.adjacencyList = adjacencyList;
        this.vertices = vertices;
    }

    public void countOfPaths(Vertex sVertex, Vertex eVertex) {
        count(sVertex, eVertex);
        System.out.println(pathCount);
    }


    public void count(Vertex sVertex, Vertex eVertex) {
        sVertex.setVisited(true);
        if (sVertex.toString() == eVertex.toString()){
            pathCount++;
            printPaths();
        } else {
            int index = adjacencyList.getIndex(sVertex);
            ListNode node = adjacencyList.adjList[index];
            while(node.getNext() != null){
                node = node.getNext();
                Vertex vertex = node.getVertex();
                if(!vertex.isVisited()){
                    count(vertex, eVertex);
                }
            }
        }
        sVertex.setVisited(false);
    }

    private void printPaths(){
        for(Vertex v: vertices){
            if(v.isVisited()){
                System.out.print(v + "->");
            }
        }
        System.out.println();
    }

}