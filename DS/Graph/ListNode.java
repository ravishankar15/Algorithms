public class ListNode {
	private Vertex vertex;
	private ListNode next;

	public ListNode(Vertex vertex){
		this.vertex = vertex;
	}

	public Vertex getVertex(){
		return this.vertex;
	}

	public void setVertex(Vertex vertex){
		this.vertex = vertex;
	}

	public ListNode getNext(){
		return this.next;
	}

	public void setNext(ListNode next){
		this.next = next;
	}

	public String toString(){
		return this.getVertex() + "->" + this.getNext();
	}

}