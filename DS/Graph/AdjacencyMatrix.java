public class AdjacencyMatrix {

	private int vertexCount;
	private String[] vertexArr;
	
	public int[][] adjMatrix;

	public AdjacencyMatrix(int vertexCount, String[] vertexArr) {
		this.vertexCount = vertexCount;
		this.vertexArr = vertexArr;
		this.adjMatrix = new int[vertexCount][vertexCount];
	}

	public void addEdge(String a, String b) {
		int fIndex = getIndex(a);
		int sIndex = getIndex(b);

		if(fIndex >= 0 && fIndex < vertexCount && sIndex >= 0 && sIndex < vertexCount) {
			adjMatrix[fIndex][sIndex] = 1;
			adjMatrix[sIndex][fIndex] = 1;
		}
	}

	public void removeEdge(String a, String b) {
		int fIndex = getIndex(a);
		int sIndex = getIndex(b);

		if(fIndex >= 0 && fIndex < vertexCount && sIndex >= 0 && sIndex < vertexCount) {
			adjMatrix[fIndex][sIndex] = 0;
			adjMatrix[sIndex][fIndex] = 0;
		}

	}

	private int getIndex(String vertex) {
		for(int i=0; i<vertexCount; i++){
			if(vertexArr[i].equals(vertex)){
				return i;
			}
		}
		return -1;
	}

}