import java.util.*;

public class AdjacencyListCreator {

  private int nodes; // Total Number of nodes
  private int edges; // Total number of edges
  private Map<Integer, Set<Integer>> adjList; // The Adjacency List

  public AdjacencyListCreator(int nodes, int edges) {
    this.nodes = nodes;
    this.edges = edges;
    adjList = new TreeMap<Integer, Set<Integer>>();
  }

  // Adds nodes and their respective adjacent nodes in the list
  public void creator() {
    Scanner sc = new Scanner(System.in);
    for (int i = 1; i <= edges; i++) {
      System.out.print("Enter Node 1: ");
      int x = sc.nextInt();
      System.out.print("Enter node 2: ");
      int y = sc.nextInt();
      adder(x, y);
      adder(y, x);
    }
  }

  // Adds node and its neighbout to the list
  private void adder(int n1, int n2) {
    if (adjList.containsKey(n1)) {
      adjList.get(n1).add(n2);
    } else {
      Set<Integer> connections = new TreeSet<Integer>();
      connections.add(n2);
      adjList.put(n1, connections);
    }
  }

  // Prints the adjacency list
  public void print() {
    System.out.println(adjList);
  }
}
