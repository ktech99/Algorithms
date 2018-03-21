import java.util.*;

public class AdjacencyListManager {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter max number of nodes :");
    int nodes = sc.nextInt();
    System.out.println("Enter number of edges :");
    int edges = sc.nextInt();
    AdjacencyListCreator adj = new AdjacencyListCreator(nodes, edges);
    adj.creator();
    adj.print();
  }
}
