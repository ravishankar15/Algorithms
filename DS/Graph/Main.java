import java.util.*;
public class Main {
    public static void main(String[] args) {
        Vertex aVertex = new Vertex("A");
        Vertex bVertex = new Vertex("B");
        Vertex cVertex = new Vertex("C");
        Vertex dVertex = new Vertex("D");
        Vertex eVertex = new Vertex("E");

        Vertex[] vertices = {aVertex, bVertex, cVertex, dVertex, eVertex};
        
        // AdjacencyList adjacencyList = new AdjacencyList(vertices);
        // adjacencyList.addEdge(aVertex, bVertex);
        // adjacencyList.addEdge(aVertex, cVertex);
        // adjacencyList.addEdge(aVertex, dVertex);
        // adjacencyList.addEdge(aVertex, eVertex);
        // System.out.println(Arrays.toString(adjacencyList.adjList));
        // adjacencyList.removeEdge(aVertex, bVertex);
        // adjacencyList.removeEdge(aVertex, eVertex);
        // System.out.println(Arrays.toString(adjacencyList.adjList));

        // AdjacencyMatrix adjacencyMatrix = new AdjacencyMatrix(vertices);
        // adjacencyMatrix.addEdge(aVertex, bVertex);
        // adjacencyMatrix.addEdge(aVertex, cVertex);
        // adjacencyMatrix.addEdge(aVertex, dVertex);
        // adjacencyMatrix.addEdge(aVertex, eVertex);
        // System.out.println(Arrays.deepToString(adjacencyMatrix.adjMatrix));
        // adjacencyMatrix.removeEdge(aVertex, bVertex);
        // adjacencyMatrix.removeEdge(aVertex, eVertex);
        // System.out.println(Arrays.deepToString(adjacencyMatrix.adjMatrix));

        AdjacencyList adjacencyList = new AdjacencyList(vertices);
        adjacencyList.addEdge(aVertex, bVertex);
        adjacencyList.addEdge(aVertex, cVertex);
        adjacencyList.addEdge(bVertex, eVertex);
        adjacencyList.addEdge(dVertex, aVertex);
        adjacencyList.addEdge(eVertex, cVertex);
        adjacencyList.addEdge(cVertex, bVertex);
        adjacencyList.addEdge(dVertex, eVertex);
        System.out.println(Arrays.toString(adjacencyList.adjList));
        DepthFirstSearch dfs = new DepthFirstSearch(adjacencyList);
        dfs.dfsRecur(adjacencyList.adjList[0].getVertex());
        System.out.println();



    }
}