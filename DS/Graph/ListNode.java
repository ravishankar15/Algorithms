public class ListNode {
    private String data;
    private ListNode next;

    public ListNode(String data) {
        this.data = data;
    }
    
    public ListNode(String data, ListNode next) {
        this.data = data;
        this.next = next;
    }

    public String getData(){
        return this.data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public ListNode getNext() {
        return this.next;
    }

    public void setNext(ListNode next) {
        this.next = next;
    }

    public String toString() {
        return this.getData() + " -> " + this.getNext();
    }

}