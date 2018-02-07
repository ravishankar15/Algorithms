//https://www.geeksforgeeks.org/dynamic-programming-set-6-min-cost-path/
public class MinCostPath{

	private int[][] cost;
	private int[][] aux;
	private int m;
	private int n;

	public MinCostPath(int[][] cost, int m, int n){
		this.cost = cost;
		this.m = m;
		this.n = n;
		aux = new int[m+1][n+1];
	}

	public int calculate(){
		for(int i=0; i<=m; i++){
			for(int j=0; j<=n; j++){
				//If it the first element than that is the starting point
				if(i==0 && j==0)
					aux[i][j] = cost[i][j];
				//If it is the first row 
				//There is no path to reach the cell through down and diagonal
				//It can be reached only in the direction right
				else if(i==0)
					aux[i][j] = aux[i][j-1] + cost[i][j];
				//If it is the first column than it can be reached only by 
				//the direction down
				else if(j==0)
					aux[i][j] = aux[i-1][j] + cost[i][j];
				//Else we have to find the minimum to reach this point from all the possible
				//direction
				else
					aux[i][j] = Math.min(aux[i-1][j], Math.min(aux[i][j-1], aux[i-1][j-1])) + cost[i][j];
			}
		}
		//To print the auxillary matrix
		/*for(int i=0; i<=m; i++){
			for(int j=0; j<=n; j++){
				System.out.print(aux[i][j]+" ");
			}
			System.out.println();
		}*/

		return aux[m][n];

	}

}