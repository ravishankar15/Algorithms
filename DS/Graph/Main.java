import java.util.*;
public class Main {
    public static void main(String[] args) {
        String[] vertexArr = { "A", "B", "C", "D", "E", "F", "G", "H" };

        // AdjacencyList adjList = new AdjacencyList(5, vertexArr);
        // adjList.addEdge("A", "B");
        // adjList.addEdge("A", "C");
        // adjList.addEdge("A", "D");
        // adjList.addEdge("A", "E");
        // adjList.addEdge("A", "B");
        // System.out.println(Arrays.toString(adjList.adjList));
        // adjList.removeEdge("A", "B");
        // adjList.removeEdge("A", "E");
        // System.out.println(Arrays.toString(adjList.adjList));

        AdjacencyMatrix adjMatrix = new AdjacencyMatrix(5, vertexArr);
        adjMatrix.addEdge("A", "B");
        adjMatrix.addEdge("A", "C");
        adjMatrix.addEdge("A", "D");
        adjMatrix.addEdge("A", "E");
        adjMatrix.addEdge("A", "B");
        System.out.println(Arrays.deepToString(adjMatrix.adjMatrix));
        adjMatrix.removeEdge("A", "B");
        adjMatrix.removeEdge("A", "E");
        System.out.println(Arrays.deepToString(adjMatrix.adjMatrix));
    }
}