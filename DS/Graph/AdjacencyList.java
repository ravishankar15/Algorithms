public class AdjacencyList {
    private String[] vertexArr;
    private int vertexCount;

    public ListNode[] adjList;

    public AdjacencyList(int vertexCount, String[] vertexArr) {
        this.vertexCount = vertexCount;
        this.vertexArr = vertexArr;
        this.adjList = new ListNode[vertexCount];
        for (int i=0; i<vertexCount; i++) {
            adjList[i] = new ListNode(vertexArr[i]);
        }
    }

    public void addEdge(String a, String b) {
        int fIndex = getIndex(a);
        int sIndex = getIndex(b);

        if (fIndex >= 0 && fIndex < vertexCount && sIndex >= 0 && sIndex < vertexCount) {
            ListNode fNode = adjList[fIndex];
            addAtBegining(fNode, b);
            ListNode sNode = adjList[sIndex];
            addAtBegining(sNode, a);
        }
    }

    public void addAtBegining(ListNode node, String sVertex) {
        ListNode sNode = new ListNode(sVertex);
        ListNode currNode = node.getNext();
        node.setNext(sNode);
        sNode.setNext(currNode);
    }

    public void removeEdge(String a, String b) {
        int fIndex = getIndex(a);
        int sIndex = getIndex(b);

        if (fIndex >= 0 && fIndex < vertexCount && sIndex >= 0 && sIndex < vertexCount) {
            deleteNode(fIndex, b);
            deleteNode(sIndex, a);
        }

    }

    public void deleteNode(int fIndex, String sVertex) {
        ListNode list = adjList[fIndex];
        ListNode prev = null;

        while(list != null && !list.getData().equals(sVertex)) {
            prev = list;
            list = list.getNext();
        }

        if (list == null) {
            System.out.println("Vertex not found");
        } else if(prev != null) {
            prev.setNext(list.getNext());
            list.setNext(null);
        }
    }

    public int getIndex(String vertex) {
        for (int i=0; i<vertexCount; i++) {
            if (vertexArr[i].equals(vertex)){
                return i;
            }

        }
        return -1;
    }
}