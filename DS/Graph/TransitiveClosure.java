//https://www.geeksforgeeks.org/transitive-closure-of-a-graph-using-dfs/
import java.util.*;
public class TransitiveClosure {

	private AdjacencyList adjacencyList;
	private Vertex[] vertices;
	private int vertexCount = 0;
	private ListNode[] tc;

	public TransitiveClosure(AdjacencyList adjacencyList, Vertex[] vertices) {
		this.adjacencyList = adjacencyList;
		this.vertices = vertices;
		this.vertexCount = vertices.length;
		tc = new ListNode[vertexCount];
		for(int i=0; i<vertexCount; i++){
			tc[i] = new ListNode(vertices[i]);
		}
	}


	public ListNode[] constructTC(){
		for(int i=0; i<vertexCount; i++){
			int sIndex = getIndex(vertices[i]);
			dfsRecurr(sIndex, vertices[i]);
		}
		return tc;
	}


	public void dfsRecurr(int sIndex, Vertex vertex){
		ListNode tcList = tc[sIndex];
		addToTC(tcList, vertex);
		int index = adjacencyList.getIndex(vertex);
		ListNode currNode = adjacencyList.adjList[index];
		while(currNode.getNext() != null){
			currNode = currNode.getNext();
			Vertex currVertex = currNode.getVertex();
			if (checkInTC(tcList, currVertex)){
				dfsRecurr(sIndex, currVertex);
			}
		}
	}

	public boolean checkInTC(ListNode tcList, Vertex vertex){
		while(tcList.getNext() != null){
			tcList = tcList.getNext();
			if(tcList.getVertex().getName().equals(vertex.getName())){
				return false;
			}
		}
		return true;

	}

	public void addToTC(ListNode node, Vertex vertex) {
		ListNode vNode = new ListNode(vertex);
		ListNode currNode = node.getNext();
		node.setNext(vNode);
		vNode.setNext(currNode);
	}

	public int getIndex(Vertex vertex){
        for(int i=0; i<vertexCount; i++){
            if(vertex.getName().equals(vertices[i].getName())){
                return i;
            }
        }
        return -1;
    }


}