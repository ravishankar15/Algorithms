import java.util.Arrays;

public class TrieNode {
  private TrieNode[] children;
  private boolean endoFWord;
  private int size;
  private static final char SMALL_A = 'a';

  public TrieNode(int size) {
    this.children = new TrieNode[size];
    Arrays.fill(this.children, null);
    endoFWord = false;
  }

  public void setChildren(TrieNode[] children){
    this.children = children;
  }

  public TrieNode[] getChildren(){
    return this.children;
  }

  public void setEndoFWord(boolean endoFWord) {
    this.endoFWord = endoFWord;
  }

  public boolean isEndoFWord() {
    return this.endoFWord;
  }
}