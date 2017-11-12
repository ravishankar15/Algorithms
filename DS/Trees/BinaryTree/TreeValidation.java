public class TreeValidation{

	//Not clear
	/*public boolean isSubTree(TreeNode t, TreeNode s){

		if(s == null)
			return true;

		if(t == null)
			return false;


		if(isIdentical(t, s))
			return true;

		return isSubTree(t.getLeft(), s) || isSubTree(t.getRight(), s);

	}


	public boolean isIdentical(TreeNode t, TreeNode s){
		if(t == null && s == null)
			return true;

		if(t == null || s == null)
			return false;

		return (t.getData() == s.getData() && isIdentical(t.getLeft(), s.getLeft()) 
				&& isIdentical(t.getRight(), s.getRight()));
	}*/
}