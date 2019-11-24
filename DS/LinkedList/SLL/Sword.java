public class Sword {

  private ListNode head;

  public int findLastMen(int n) {
    constructList(n);
    ListNode result = recurSurvive(head);
    return result.getData();
  }

  public void constructList(int n) {
    ListNode iHead = new ListNode(1, null);
    head = iHead;
    for(int i=2; i<=n; i++) {
      ListNode t = new ListNode(i, null);
      iHead.setNext(t);
      iHead = iHead.getNext();
    }
    iHead.setNext(head);
  }

  public ListNode recurSurvive(ListNode result) {
    if (result == null)
      return null;
    if (result.getNext() == null || result.getData() == result.getNext().getData())
      return result;
    ListNode temp = result.getNext();
    result.setNext(temp.getNext());
    return recurSurvive(result.getNext());
  }

}