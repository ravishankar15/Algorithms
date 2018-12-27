//https://www.geeksforgeeks.org/find-a-mother-vertex-in-a-graph/
public class MotherVertex {
    
    private AdjacencyList adjacencyList;
    private Vertex[] vertices;
    private int vertexCount = 0;
    
    public MotherVertex(AdjacencyList adjacencyList, Vertex[] vertices) {
        this.adjacencyList = adjacencyList;
        this.vertices = vertices;
        this.vertexCount = vertices.length;
    }

    public void findMotherVertex(){
        Vertex result = findMother();
        if (result != null){
            System.out.println("The mother vertex is " + result.getName());
        }

    }

    private Vertex findMother(){
        Vertex vertex = null;
        for(int i=0; i<vertexCount; i++){
            if (!vertices[i].isVisited()) {
                dfsRecur(vertices[i]);
                vertex = vertices[i];
            }
        }
        resetVertices();
        dfsRecur(vertex);
        for(int i=0; i<vertexCount; i++) {
            if (!vertices[i].isVisited())
                return null;
        }
        return vertex;
    }

    public void dfsRecur(Vertex vertex){
        vertex.setVisited(true);
        int index = adjacencyList.getIndex(vertex);
        ListNode currNode = adjacencyList.adjList[index];
        while(currNode.getNext() != null) {
            currNode = currNode.getNext();
            Vertex currVertex = currNode.getVertex();
            if(!currVertex.isVisited()){
                dfsRecur(currVertex);
            }
        }
    }


    private void resetVertices(){
        for(int i=0; i<vertexCount; i++){
            vertices[i].setVisited(false);
        }
    }
}