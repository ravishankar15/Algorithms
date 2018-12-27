//https://www.geeksforgeeks.org/find-k-cores-graph/
//Populating the adjacency list by adding at begining changes the expected solution?
public class KCores {

    private AdjacencyList adjacencyList;
    private Vertex[] vertices;
    private int k;

    public KCores(AdjacencyList adjacencyList, Vertex[] vertices, int k) {
        this.adjacencyList = adjacencyList;
        this.vertices = vertices;
        this.k = k;
    }


    public void constructKCores() {
        int minDegree = Integer.MAX_VALUE;
        Vertex startVertex = null;
        for(Vertex vertex: vertices){
            int index = adjacencyList.getIndex(vertex);
            ListNode node = adjacencyList.adjList[index];
            int degree = adjacencyList.getSize(node.getNext());
            if(degree < minDegree) {
                startVertex = vertex;
                minDegree = degree;
            }
            vertex.setDegree(degree);
        }
        dfsRecurr(startVertex);
        for(Vertex vertex: vertices) {
            if (!vertex.isVisited()) {
                dfsRecurr(vertex);
            }
        }
        printKcores();

    }


    private boolean dfsRecurr(Vertex vertex){
        vertex.setVisited(true);
        int index = adjacencyList.getIndex(vertex);
        ListNode node = adjacencyList.adjList[index];
        while(node.getNext() != null){
            node = node.getNext();
            Vertex nVertex = node.getVertex();
            if (vertex.getDegree() < k){
                int d = nVertex.getDegree() - 1;
                nVertex.setDegree(d);
            }

            if (!nVertex.isVisited()){
                if (dfsRecurr(nVertex)) {
                    int d1 = vertex.getDegree() - 1;
                    vertex.setDegree(d1);
                }

            }
        }
        return (vertex.getDegree() < k);

    }

    private void printKcores(){
        for (Vertex vertex: vertices) {

            if (vertex.getDegree() >= k){
                System.out.print("[" + vertex + "]");
                int index = adjacencyList.getIndex(vertex);
                ListNode node = adjacencyList.adjList[index];

                while(node.getNext() != null) {
                    node = node.getNext();
                    if (node.getVertex().getDegree() >= k){
                        System.out.print(" -> " + node.getVertex());
                    }
                }
                System.out.println();
            }
        }
    }

    //Dummy method
    private void printDegree(){
        for (Vertex vertex: vertices) {
            System.out.print(vertex + "-" +vertex.getDegree() + "/");
        }
        System.out.println();
        System.out.println("========");
    }

    
}