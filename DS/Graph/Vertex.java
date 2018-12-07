public class Vertex {
	private String name;
	private boolean visited;

	public Vertex(String name){
		this.name = name;
		this.visited = false;
	}

	public String getName(){
		return this.name;
	}

	public void setName(String name){
		this.name = name;
	}

	public boolean isVisited(){
		return this.visited;
	}

	public void setVisited(boolean visited) {
		this.visited = visited;
	}

	public String toString(){
		return this.name;
	}
}