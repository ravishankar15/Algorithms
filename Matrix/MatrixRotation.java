public class MatrixRotation{

	//http://www.geeksforgeeks.org/inplace-rotate-square-matrix-by-90-degrees/
	//Note: Rotate by 90 degrees in anti-clockwise direction without using any extra space.
	public int[][] rotateSqr90Deg(int N, int[][] mat){

		for(int i=0; i<N/2; i++){
			for(int j=i; j<N-1-i; j++){

				//Store Top-Left to temp
				int temp = mat[i][j];

				//Top-Right to Top-Left
				mat[i][j] = mat[j][N-1-i];

				//Bottom-Right to Top Right
				mat[j][N-1-i] = mat[N-1-i][N-1-j];

				//Bottom-Left to Bottom-Right
				mat[N-1-i][N-1-j] = mat[N-1-j][i];

				//temp to Bottom-Left
				mat[N-1-j][i] = temp;

			}
		}

		return mat;
	}
	

	//http://www.geeksforgeeks.org/print-a-given-matrix-in-spiral-form/
		/*	|			|
			Left        Right
	  ->Top 1	2	3	4	
			5	6	7	8
			9	10	11	12
   ->Bottom	13	14	15	16*/

	public int[] printInSpiral(int m, int n, int[][] mat){
		int dir = 0; int value = 0;
		int[] result = new int[m*n];
		int tp = 0; int bt = m-1; int lt = 0; int rt = n-1;
		while(tp <= bt && lt<=rt){
			//Left - Right
			if(dir == 0){
				for(int k=lt; k<=rt; k++){
					result[value++] = mat[tp][k];
				}
				tp++;
				dir = 1;

			} 
			//Top - Bottom
			else if(dir == 1){
				for(int k=tp; k<=bt; k++){
					result[value++] = mat[k][rt];
				}
				rt--;
				dir = 2;
			} 
			//Right - Left
			else if(dir == 2){
				for(int k=rt; k>=lt; k--){
					result[value++] = mat[bt][k];
				}
				bt--;
				dir = 3;
			} 
			//Bottom to Top
			else {
				for(int k=bt; k>=tp; k--){
					result[value++] = mat[k][lt];
				}
				lt++;
				dir = 0;
			}
		}
		return result;
	}
}