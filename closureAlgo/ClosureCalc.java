import java.util.*;

public class ClosureCalc {

  private Map<String, String> lineMap;
  private Map<String, Set<String>> lineMapToSet;
  private Set<String> values;

  public ClosureCalc() {
    lineMap = new HashMap<String, String>();
    lineMapToSet = new HashMap<String, Set<String>>();
  }

  public void calculations(List<String> lines) {
    if (lines.size() == 0) {
      throw new IllegalArgumentException("Empty file");
    }
    for (String line : lines) {
      line.replace(" ", "");
      String[] lineDiv = line.split("-");
      if (lineMap.containsKey(lineDiv[0])) {
        throw new IllegalArgumentException("Wrong file format");
      }
      lineMap.put(lineDiv[0], lineDiv[1]);
    }
    for (String key : lineMap.keySet()) {
      values = new HashSet<>();
      String[] valDiv = lineMap.get(key).split(",");
      for (int i = 0; i < valDiv.length; i++) {
        values.add(valDiv[i]);
      }
      values.add(key);
      lineMapToSet.put(key, values);
    }
  }
}
