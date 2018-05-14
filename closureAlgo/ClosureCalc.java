import java.util.*;

public class ClosureCalc {

  private Map<String, String> lineMap;

  public ClosureCalc(List<String> lines) {
    if (lines.size() == 0) {
      throw new IllegalArgumentException("Empty file");
    }
    lineMap = new HashMap<String, String>();
    for (String line : lines) {
      String[] lineDiv = line.split("-");
      if (lineMap.containsKey(lineDiv[0])) {
        throw new IllegalArgumentException("Wrong file format");
      }
      lineMap.put(lineDiv[0], lineDiv[1]);
    }
  }
}
