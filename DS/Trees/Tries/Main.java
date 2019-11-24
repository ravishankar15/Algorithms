public class Main {
  public static void main(String[] args) {
    TrieNode dummy = new TrieNode(0); //Dummy instantiation for TrieNode compilation
    
    WordSearch ws = new WordSearch(new String[] { "the", "a", "there", "answer", "any", "by", "bye", "their" });
    System.out.println(ws.search("the"));
    System.out.println(ws.search("these"));
    System.out.println(ws.search("there"));
    System.out.println(ws.search("thaw"));
  }
}