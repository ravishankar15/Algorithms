public class Vertex {
    private String name;
    private boolean visited;
    private int degree;
    private int level;

    public Vertex(String name){
        this.name = name;
        this.visited = false;
        this.degree = 0;
        this.level = 0;
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

    public void setDegree(int degree){
        this.degree = degree;
    }

    public int getDegree(){
        return this.degree;
    }

    public void setLevel(int level){
        this.level = level;
    }

    public int getLevel(){
        return this.level;
    }

    public String toString(){
        return this.name;
    }
}