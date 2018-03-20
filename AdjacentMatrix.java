import java.util.Scanner;

public class AdjacentMatrix {
  private int[][] matrix;
  private static int vertices;
  private static int edges;
  private static int count = 1;
  private static int to = 0;
  private static int from = 0;

  public AdjacentMatrix() {
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter number of vertices:");
    vertices = sc.nextInt();
    matrix = new int[vertices + 1][vertices + 1];
    System.out.println("Enter number of edges:");
    edges = sc.nextInt();
    to = 0;
    from = 0;
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    AdjacentMatrix graph = new AdjacentMatrix();
    System.out.println("Enter the edges: <To> <From>");
    while (count <= edges) {
      to = sc.nextInt();
      from = sc.nextInt();
      graph.makeEdge(to, from, 1);
      count++;
    }
    System.out.println("The adjacency matrix is: ");
    System.out.print("  ");
    for (int i = 0; i < vertices; i++) {
      System.out.print((i + 1) + " ");
    }
    System.out.println();
    for (int i = 0; i < vertices; i++) {
      System.out.print((i + 1) + " ");
      for (int j = 0; j < vertices; j++) {
        System.out.print(graph.getEdge((i + 1), (j + 1)) + " ");
      }
      System.out.println();
    }
  }

  // Creates a matrix with the edges to and from a node
  // throws IlleaglArgumentException if to or from are invalid
  public void makeEdge(int to, int from, int edge) {
    check(to, from);
    matrix[to][from] = edge;
  }

  // Returns the edges from one node to the other
  // throws IlleaglArgumentException if to or from are invalid
  public int getEdge(int to, int from) {
    check(to, from);
    return matrix[to][from];
  }

  // throws IlleaglArgumentException if to or from are invalid
  public void check(int to, int from) {
    if (to < 0 || to > vertices + 1 || from < 0 && from > vertices + 1) {
      throw new IllegalArgumentException();
    }
  }
}
