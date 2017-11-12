public class Main{
	public static void main(String[] args) {
		
		int[][] mat = {
            {1, 2, 3, 4},
            {5, 6, 7, 8},
            {9, 10, 11, 12},
            {13, 14, 15, 16}
        };

		MatrixRotation mr = new MatrixRotation();
		//print(mr.rotateSqr90Deg(4, mat));
        print(mr.printInSpiral(4, 4, mat));
	}

	static void print(int[][] mat){
		for (int i = 0; i < mat.length; i++){
            for (int j = 0; j < mat.length; j++)
                System.out.print(" " + mat[i][j]);
            System.out.print("\n");
        }
        System.out.print("\n");
	}

    static void print(int[] arr){
        for(int i=0; i<arr.length; i++)
            System.out.print(arr[i]+" ");
        System.out.println();
    }
}