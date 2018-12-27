public class AdjacencyList {
    private Vertex[] vertices;
    private int vertexCount;

    public ListNode[] adjList;

    public AdjacencyList(Vertex[] vertices){
        this.vertices = vertices;
        this.vertexCount = vertices.length;
        adjList = new ListNode[vertexCount];
        for(int i=0; i<vertexCount; i++){
            adjList[i] = new ListNode(vertices[i]);
        }
    }


    public void addEdge(Vertex a, Vertex b){
        int aIndex = getIndex(a);
        int bIndex = getIndex(b);

        if(aIndex >= 0 && aIndex < vertexCount && bIndex >=0 && bIndex < vertexCount){
            ListNode aNode = adjList[aIndex];
            addAtEnd(aNode, b);
            ListNode bNode = adjList[bIndex];
            addAtEnd(bNode, a);
        }
    }

    public void removeEdge(Vertex a, Vertex b){
        int aIndex = getIndex(a);
        int bIndex = getIndex(b);

        if(aIndex >= 0 && aIndex < vertexCount && bIndex >=0 && bIndex < vertexCount){
            deleteNode(aIndex, b);
            deleteNode(bIndex, a);
        }

    }

    public void addDirectedEdge(Vertex a, Vertex b){
        int aIndex = getIndex(a);
        int bIndex = getIndex(b);

        if(aIndex >= 0 && aIndex < vertexCount && bIndex >= 0 && bIndex < vertexCount){
            ListNode aNode = adjList[aIndex];
            addAtBegining(aNode, b);
        }
    }

    public void removeDirectedEdge(Vertex a, Vertex b){
        int aIndex = getIndex(a);
        int bIndex = getIndex(b);

        if (aIndex >= 0 && aIndex < vertexCount && bIndex >= 0 && bIndex < vertexCount) {
            deleteNode(aIndex, b);
        }
    }

    private void addAtBegining(ListNode node, Vertex vertex){
        ListNode vNode = new ListNode(vertex);
        ListNode currNode = node.getNext();
        node.setNext(vNode);
        vNode.setNext(currNode);
    }

    private void addAtEnd(ListNode node, Vertex vertex){
        ListNode vNode = new ListNode(vertex);
        while(node.getNext() != null){
            node = node.getNext();
        }
        node.setNext(vNode);
    }

    private void deleteNode(int index, Vertex vertex){
        ListNode list = adjList[index];
        ListNode prev = null;
        while(list != null && !list.getVertex().getName().equals(vertex.getName())){
            prev = list;
            list = list.getNext();
        }

        if (list == null){
            System.out.println("Vertex not found");
        } else if (prev != null) {
            prev.setNext(list.getNext());
            list.setNext(null);
        }
    }


    public int getIndex(Vertex vertex){
        for(int i=0; i<vertexCount; i++){
            if(vertex.getName().equals(vertices[i].getName())){
                return i;
            }
        }
        return -1;
    }

    public int getSize(ListNode node) {
        int count = 0;
        while(node != null) {
            count++;
            node = node.getNext();
        }
        return count;
    }

}