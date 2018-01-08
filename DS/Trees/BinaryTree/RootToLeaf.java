import java.util.HashMap;
public class RootToLeaf{

	//http://www.geeksforgeeks.org/root-to-leaf-path-sum-equal-to-a-given-number/
	public boolean rootToLeafSum(TreeNode tree, int sum){
		if(tree == null)
			return (sum == 0);

		else {
			boolean res = false;

			//Subract the sum from the nodes data
			int subsum = sum - tree.getData();

			//If the subsum reaches 0 return true
			if(subsum == 0 && tree.getLeft() == null && tree.getRight() == null)
				return true;
			//The or condition is checked because we need to store the true value if found
			//Because the recursive function runs through all the paths from root to leaf
			if(tree.getLeft() != null){
				res = res || rootToLeafSum(tree.getLeft(), subsum);
			}
			if(tree.getRight() != null){
				res = res || rootToLeafSum(tree.getRight(), subsum);
			}

			return res;
		}
	}

	//http://www.geeksforgeeks.org/given-a-binary-tree-print-out-all-of-its-root-to-leaf-paths-one-per-line/
	public void rootToLeafPath(TreeNode tree, int[] path, int len){
		if(tree == null)
			return;

		else {
			//Adds the node data on the particular position
			//First the left node is added and once it is printed the 
			//corresponding right node is overridden on the same place
			path[len] = tree.getData();
			len++;
			
			//If the leaf node is reached print the path
			if(tree.getLeft() == null && tree.getRight() == null){
				for(int i=0; i<len; i++)
					System.out.print(path[i]+" ");
				System.out.println();
			} else {
				//Recursively call both subtrees
				rootToLeafPath(tree.getLeft(), path, len);
				rootToLeafPath(tree.getRight(), path, len);
			}
		}
	}

	//https://www.geeksforgeeks.org/find-the-maximum-sum-path-in-a-binary-tree/
	//Note: Private variables are declared to keep track globally
	private int max = Integer.MIN_VALUE;
	private TreeNode target;
	public TreeNode maxSumPath(TreeNode tree, int curMax){
		if(tree == null)
			return target;

		//Identify the target leaf with the maximum sum
		curMax = curMax + tree.getData();

		if(tree.getLeft() == null && tree.getRight() == null){
			if(curMax > max){
				max = curMax;
				target = tree;
			}
		}

		maxSumPath(tree.getLeft(), curMax);
		maxSumPath(tree.getRight(), curMax);
		
		return target;
	}

	//https://www.geeksforgeeks.org/sum-numbers-formed-root-leaf-paths/
	public int sumNumRootToLeaf(TreeNode tree, int val){
		if(tree == null)
			return 0;

		//This calculation is to be noted (val = val + (tree.getData() * 10^(0,1,2.....n))
		//Can also be used which makes the logic tricky
		val = (val*10) + tree.getData();

		if(tree.getLeft() == null && tree.getRight() == null){
			return val;
		}

		return sumNumRootToLeaf(tree.getLeft(), val)
			+ sumNumRootToLeaf(tree.getRight(), val);
	}

	//https://www.geeksforgeeks.org/remove-all-nodes-which-lie-on-a-path-having-sum-less-than-k/
	public TreeNode removeNodesNotInPath(TreeNode tree, int sum){
		if(tree == null)
			return null;

		tree.setLeft(removeNodesNotInPath(tree.getLeft(), sum - tree.getData()));
		tree.setRight(removeNodesNotInPath(tree.getRight(), sum - tree.getData()));

		//If we reach the leaf node and the sum is greater than the tree data 
		//we delete the node by returning null 
		if(tree.getLeft() == null && tree.getRight() == null){
			if(sum > tree.getData()){
				return null;
			}
		}

		return tree;
	}

	//https://www.geeksforgeeks.org/vertical-sum-in-a-given-binary-tree/
	//Note: we have a space optimized solution using the DLL
	//Refer: https://www.geeksforgeeks.org/vertical-sum-in-binary-tree-set-space-optimized/
	private HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
	public HashMap<Integer, Integer> verticalSum(TreeNode tree, int hd){
		
		if(tree == null)
			return hm;

		verticalSum(tree.getLeft(), hd - 1);

		//If there is a sum already existing for the vertical line
		//Add the current node value to the existing value and put it to the map
		int curSum = (hm.get(hd) == null) ? 0 : hm.get(hd);
		hm.put(hd, curSum + tree.getData());

		verticalSum(tree.getRight(), hd + 1);

		return hm;

	}

	//https://www.geeksforgeeks.org/find-closest-leaf-binary-tree/
	public int findCloseLeaf(TreeNode tree, TreeNode[] ancestors, int key, int index){

		//Base condition and If the key is not found
		if(tree == null)
			return Integer.MAX_VALUE;

		//If key is found
		if(tree.getData() == key){
			//Find the leaf rooted under the given node
			int res = findCloseDown(tree);

			//Traverse all the ancestors and update the result if any provides with
			//the smallest distance
			for(int i = index - 1; i>=0; i--){
				//The index - i is used to calculate the distance between 
				//the ancestor and the key node
				res = Math.min(res, index - i + findCloseDown(ancestors[i]));
			}
			return res;
		}

		//If key node not found store the current node and recur for left and right children
		//If the result is not on the left child than the nodes will be replaced with the right
		//on the recursive call
		ancestors[index] = tree;
		return Math.min(findCloseLeaf(tree.getLeft(), ancestors, key, index + 1),
							findCloseLeaf(tree.getRight(), ancestors, key, index + 1));
	}
	//Utility function for finding the closest leaf rooted under a given tree
	private int findCloseDown(TreeNode tree){
		if(tree == null)
			return Integer.MAX_VALUE;
		if(tree.getLeft() == null && tree.getRight() == null)
			return 0;

		return 1 + Math.min(findCloseDown(tree.getLeft()), findCloseDown(tree.getRight()));
	}
}