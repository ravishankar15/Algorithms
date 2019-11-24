public class WordSearch {
  private static final int ALPHABET_SIZE = 26;
  private static final char SMALL_A = 'a';
  private TrieNode root;
  private String[] inputData;

  public WordSearch(String[] inputData) {
    this.root = new TrieNode(ALPHABET_SIZE);
    for (String key: inputData) {
      insert(key);
    }
  }

  public void insert(String key) {
    TrieNode pCrawl = root;
    int level;
    for (level = 0; level < key.length(); level++) {
      int index = key.charAt(level) - SMALL_A;
      if (pCrawl.getChildren()[index] == null) pCrawl.getChildren()[index] = new TrieNode(ALPHABET_SIZE);

      pCrawl = pCrawl.getChildren()[index];
    }
    pCrawl.setEndoFWord(true);
  }

  public boolean search(String key) {
    TrieNode pCrawl = root;
    for(int level = 0; level < key.length(); level++) {
      int index = key.charAt(level) - SMALL_A;
      if (pCrawl.getChildren()[index] == null) return false;

      pCrawl = pCrawl.getChildren()[index];
    }

    return (pCrawl != null && pCrawl.isEndoFWord());
  }

}