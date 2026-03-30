package day8.B1854;

public class Edge implements Comparable<Edge>{
    int to;
    int weight;

    Edge(int to, int weight){
        this.to = to;
        this.weight = weight;
    }

    @Override
    public int compareTo(Edge o) {
        return Integer.compare(this.weight, o.weight);
    }
}
