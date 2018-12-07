public class AdjacencyMatrix {
    private int vertexCount;
    private Vertex[] vertices;

    public int[][] adjMatrix;

    public AdjacencyMatrix(Vertex[] vertices){
        this.vertices = vertices;
        this.vertexCount = vertices.length;
        this.adjMatrix = new int[vertexCount][vertexCount];
    }

    private void addEdge(Vertex a, Vertex b){
        int aIndex = getIndex(a);
        int bIndex = getIndex(b);

        if(aIndex >=0 && aIndex < vertexCount && bIndex >= 0 && bIndex < vertexCount){
            adjMatrix[aIndex][bIndex] = 1;
            adjMatrix[bIndex][aIndex] = 1;
        }
    }

    private void removeEdge(Vertex a, Vertex b){
        int aIndex = getIndex(a);
        int bIndex = getIndex(b);

        if(aIndex >=0 && aIndex < vertexCount && bIndex >= 0 && bIndex < vertexCount){
            adjMatrix[aIndex][bIndex] = 0;
            adjMatrix[bIndex][aIndex] = 0;
        }
    }

    public int getIndex(Vertex vertex){
        for(int i=0; i<vertexCount; i++){
            if(vertex.getName().equals(vertices[i].getName()))
                return i;
        }
        return -1;
    }
}