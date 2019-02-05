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

        Vertex v0 = new Vertex("0");//0
        Vertex v1 = new Vertex("1");//0
        Vertex v2 = new Vertex("2");//1
        Vertex v3 = new Vertex("3");//2
        Vertex v4 = new Vertex("4");//3
        Vertex v5 = new Vertex("5");//4
        Vertex v6 = new Vertex("6");//5
        Vertex v7 = new Vertex("7");//6
        Vertex v8 = new Vertex("8");//6


        Vertex[] vertices = {aVertex, bVertex, cVertex, dVertex, eVertex};
        //Vertex[] vertices = {v0, v1, v2, v3, v4, v5};
        
        AdjacencyList adjacencyList = new AdjacencyList(vertices);
        adjacencyList.addDirectedEdge(aVertex, bVertex); 
        adjacencyList.addDirectedEdge(aVertex, eVertex); 
        adjacencyList.addDirectedEdge(aVertex, cVertex); 
        adjacencyList.addDirectedEdge(bVertex, dVertex); 
        adjacencyList.addDirectedEdge(bVertex, eVertex);
        adjacencyList.addDirectedEdge(cVertex, eVertex);
        adjacencyList.addDirectedEdge(dVertex, cVertex); 
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

        // MotherVertex mv = new MotherVertex(adjacencyList, vertices);
        // mv.findMotherVertex();

        // TransitiveClosure tc = new TransitiveClosure(adjacencyList, vertices);
        // System.out.println(Arrays.toString(tc.constructTC()));


        // KCores kc = new KCores(adjacencyList, vertices, 3);
        // kc.constructKCores();

        // CountNodesAtLevel cn = new CountNodesAtLevel(adjacencyList, vertices, 2);
        // cn.countNoOfNodes(v0);

        CountAllPaths cp = new CountAllPaths(adjacencyList, vertices);
        cp.countOfPaths(aVertex, eVertex);

    }
}