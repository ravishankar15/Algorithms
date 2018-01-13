public class Main{
	public static void main(String[] args) {
		// MinHeap min = new MinHeap(6);
		// min.insert(1); min.insert(3); min.insert(6); min.insert(9); min.insert(8); min.insert(5);
		// min.print(); min.extractMin(); 	min.decreaseKey(3, 1);
		// min.print();


		// MaxHeap max = new MaxHeap(6);
		// max.insert(1); max.insert(3); max.insert(6); max.insert(9); max.insert(8); max.insert(5);
		// max.print(); max.extractMax(); max.increaseKey(3, 20);
		// max.print();

		// MergeSortedArrays msa = new MergeSortedArrays(4, 3);
		// msa.mergeArrays(new int[][]{
		// 				{2, 6, 12, 34},
		// 				{1, 9, 20, 1000},
		// 				{23, 34, 90, 2000}
		// 			});

		// ConnectRopes cr = new ConnectRopes();
		// cr.connect(new int[]{4, 3, 2, 6});

		TreeNode tree = new TreeNode(1, null, null);
		tree.setLeft(new TreeNode(4, null, null));
        tree.setRight(new TreeNode(8, null, null));
      	tree.getLeft().setLeft(new TreeNode(12, null, null));
      	tree.getLeft().setRight(new TreeNode(5, null, null));
      	tree.getRight().setLeft(new TreeNode(9, null, null));
      	tree.getRight().setRight(new TreeNode(10, null, null));

		CheckHeap ch = new CheckHeap();
		System.out.println(ch.isBinaryTreeAHeap(tree));


	}
}