//https://www.geeksforgeeks.org/maximum-size-sub-matrix-with-all-1s-in-a-binary-matrix/
//Problem: Given a binary matrix, find out the maximum size square sub-matrix with all 1s.
public class SqrSubMatrix{
	private int[][] mat;
	private int[][] aux;
	private int row;
	private int col;
	public SqrSubMatrix(int[][] mat){
		this.mat = mat;
		row = mat.length;
		col = mat[0].length;
		aux = new int[row][col];
	}

	public void calculate(){
		int row = mat.length;
		int col = mat[0].length;
		for(int i=0; i<row; i++){
			for(int j=0; j<col; j++){
				if(i==0 || j == 0)
					aux[i][j] = mat[i][j];
				else if(mat[i][j] == 1)
					aux[i][j] = Math.min(aux[i-1][j], Math.min(aux[i-1][j-1],aux[i][j-1])) + 1;
				else
					aux[i][j] = 0;
			}
		}
		//Print the AUX Matrix
		/*for(int i=0; i<row; i++){
			for(int j=0; j<col; j++){
				System.out.print(aux[i][j]+" ");
			}
			System.out.println();
		}*/
	}

	public void printMatrix(){
		int max_val = aux[0][0]; int max_i = 0; int max_j = 0;
		/* Find the maximum entry, and indexes of maximum entry 
             in aux[][] */
		for(int i=0; i<row; i++){
			for(int j=0; j<col; j++){
				if(max_val < aux[i][j]){
					max_val = aux[i][j];
					max_i = i;
					max_j = j;
				}
			}
		}
		//Print the array
		for(int i=max_i; i > max_i - max_val; i--){
			for(int j=max_j; j > max_j - max_val; j--){
				System.out.print(mat[i][j]+ " ");
			}
			System.out.println();
		}

	}

}