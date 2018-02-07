//http://www.geeksforgeeks.org/minimum-time-required-so-that-all-oranges-become-rotten/
import java.util.*;
public class RottenOranges{
	public int getMinTime(int[][] arr, int R, int C){
		Queue<Coordinates> q = new LinkedList<Coordinates>();
		int ans = 0;

		//Initially Store the cells with rotton oranges
		for(int i=0; i<R; i++){
			for(int j=0; j<C; j++){
				if(arr[i][j] == 2){
					q.add(new Coordinates(i, j));
				}
			}
		}

		//Separate these rotton oranges from the oranges which
		//will rotten due to the oranges in the first time
		q.add(new Coordinates(-1, -1));
		while(!q.isEmpty()){

			//This flag is used to increase the count 
			//even if one fresh orange gets rotten
			boolean flag = false;

			//Processing all rotten oranges in current time frame
			while(!isDelimiter(q.peek())){
				Coordinates temp = q.peek();

				//Check left adjacent cell
				if(isValid(temp.x-1, temp.y, R, C) && arr[temp.x-1][temp.y] == 1){

					if(!flag){
						ans++;
						flag = true;
					}
					arr[temp.x-1][temp.y] = 2;
					q.add(new Coordinates(temp.x-1, temp.y));
				}
				//Check right adjacent cell
				if(isValid(temp.x+1, temp.y, R, C) && arr[temp.x+1][temp.y] == 1){
					if(!flag){
						ans++;
						flag = true;
					}
					arr[temp.x+1][temp.y] = 2;
					q.add(new Coordinates(temp.x+1, temp.y));
				}
				//Check the bottom cell
				if(isValid(temp.x, temp.y-1, R, C) && arr[temp.x][temp.y-1] == 1){
					if(!flag){
						ans++;
						flag = true;
					}
					arr[temp.x][temp.y-1] = 2;
					q.add(new Coordinates(temp.x, temp.y-1));
				}
				//Check the top cell
				if(isValid(temp.x, temp.y+1, R, C) && arr[temp.x][temp.y+1] == 1){
					if(!flag){
						ans++;
						flag = true;
					}
					arr[temp.x][temp.y+1] = 2;
					q.add(new Coordinates(temp.x, temp.y+1));
				}
				q.remove();
			}
			//Pop the delimiter
			q.remove();

			//It there are oranges rotten in current time frame 
			//Separate them using delimiters
			if(!q.isEmpty()){
				q.add(new Coordinates(-1, -1));
			}
		}
		//Check for any fresh oranges
		return checkAll(arr, R, C) ? ans : -1;
	}

	//To check if the cell is valid
	public boolean isValid(int x, int y, int R, int C){
		return (x>=0 && y>=0 && x<R && y<C);
	}

	public boolean isDelimiter(Coordinates cor){
		return cor.getX() == -1 && cor.getY() == -1;
	}

	//Check for any fresh oranges
	public boolean checkAll(int[][] arr, int R, int C){
		for(int i=0; i<R; i++){
			for(int j=0; j<C; j++){
				if(arr[i][j] == 1){
					return false;
				}
			}
		}
		return true;
	}

	//Utility method for printing the array values
	public void print(int[][] arr, int R, int C){
		for(int i=0; i<R; i++){
			for(int j=0; j<C; j++){
				System.out.print(arr[i][j]+" ");
			}
			System.out.println();
		}
	}
}