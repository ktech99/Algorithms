import java.util.*;

public class ClosureCalc {

  private Map<String, String> lineMap;
  private Map<Set<String>, Set<String>> lineMapToSet;
  private Set<String> values;
  private Set<String> keys;

  public ClosureCalc() {
    lineMap = new HashMap<String, String>();
    lineMapToSet = new HashMap<Set<String>, Set<String>>();
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
      values = new TreeSet<>();
      keys = new TreeSet<>();
      values.add(key);
      String[] valDiv = lineMap.get(key).split(",");
      String[] keyDiv = key.split(",");
      for (int i = 0; i < valDiv.length; i++) {
        values.add(valDiv[i]);
      }
      for (int i = 0; i < keyDiv.length; i++) {
        keys.add(keyDiv[i]);
      }

      lineMapToSet.put(keys, values);
    }
    System.out.println(lineMapToSet);
  }
}
