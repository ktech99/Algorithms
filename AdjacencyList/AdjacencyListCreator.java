import java.util.*;

public class AdjacencyListCreator {

  private int nodes;
  private int edges;
  private Map<Integer, Set<Integer>> adjList;

  public AdjacencyListCreator(int nodes, int edges) {
    this.nodes = nodes;
    this.edges = edges;
    adjList = new TreeMap<Integer, Set<Integer>>();
  }

  public void creator() {
    Scanner sc = new Scanner(System.in);
    for (int i = 1; i <= edges; i++) {
      System.out.print("Enter Node 1: ");
      int x = sc.nextInt();
      System.out.print("Enter node 2: ");
      int y = sc.nextInt();
      if (adjList.containsKey(x)) {
        adjList.get(x).add(y);
      } else {
        Set<Integer> connections = new TreeSet<Integer>();
        connections.add(y);
        adjList.put(x, connections);
      }
      if (adjList.containsKey(y)) {
        adjList.get(y).add(x);
      } else {
        Set<Integer> connections = new TreeSet<Integer>();
        connections.add(x);
        adjList.put(y, connections);
      }
    }
  }

  public void print() {
    System.out.println(adjList);
  }
}
