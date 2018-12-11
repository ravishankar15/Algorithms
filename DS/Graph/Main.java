import java.util.*;
public class Main {
    public static void main(String[] args) {
        Vertex aVertex = new Vertex("A");//0
        Vertex bVertex = new Vertex("B");//1
        Vertex cVertex = new Vertex("C");//2
        Vertex dVertex = new Vertex("D");//3
        Vertex eVertex = new Vertex("E");//4
        Vertex fVertex = new Vertex("F");//5
        Vertex gVertex = new Vertex("G");//6

        Vertex[] vertices = {aVertex, bVertex, cVertex, dVertex, eVertex, fVertex, gVertex};
        
        AdjacencyList adjacencyList = new AdjacencyList(vertices);
        adjacencyList.addDirectedEdge(aVertex, bVertex);
        adjacencyList.addDirectedEdge(aVertex, cVertex);
        adjacencyList.addDirectedEdge(bVertex, dVertex);
        adjacencyList.addDirectedEdge(eVertex, bVertex);
        adjacencyList.addDirectedEdge(gVertex, eVertex);
        adjacencyList.addDirectedEdge(fVertex, gVertex);
        adjacencyList.addDirectedEdge(fVertex, cVertex);
        adjacencyList.addDirectedEdge(gVertex, aVertex);
        System.out.println(Arrays.toString(adjacencyList.adjList));

        // AdjacencyMatrix adjacencyMatrix = new AdjacencyMatrix(vertices);
        // adjacencyMatrix.addEdge(aVertex, bVertex);
        // adjacencyMatrix.addEdge(aVertex, cVertex);
        // adjacencyMatrix.addEdge(aVertex, dVertex);
        // adjacencyMatrix.addEdge(aVertex, eVertex);
        // System.out.println(Arrays.deepToString(adjacencyMatrix.adjMatrix));
        // adjacencyMatrix.removeEdge(aVertex, bVertex);
        // adjacencyMatrix.removeEdge(aVertex, eVertex);
        // System.out.println(Arrays.deepToString(adjacencyMatrix.adjMatrix));

        // DepthFirstSearch dfs = new DepthFirstSearch(adjacencyList);
        // dfs.dfsRecur(aVertex);
        // System.out.println();


        // BreadthFirstSearch bfs = new BreadthFirstSearch(adjacencyList);
        // bfs.calcBFS(aVertex);
        // System.out.println();

        MotherVertex mv = new MotherVertex(adjacencyList, vertices);
        mv.findMotherVertex();

    }
}