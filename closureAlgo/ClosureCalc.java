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

  public void mapper(List<String> lines) {
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
    int x = 0;
    for (String key : lineMap.keySet()) {
      values = new TreeSet<String>();
      keys = new TreeSet<String>();
      String[] valDiv = lineMap.get(key).split(",");
      String[] keyDiv = key.split("\\s*\\,\\s*");
      for (int i = 0; i < valDiv.length; i++) {
        values.add(valDiv[i]);
      }
      for (int i = 0; i < keyDiv.length; i++) {
        keys.add(keyDiv[i]);
        values.add(keyDiv[i]);
      }
      lineMapToSet.put(keys, values);
      x += 1;
    }
  }

  public void completer() {
    for (Set<String> k : lineMapToSet.keySet()) {
      Set<String> v = lineMapToSet.get(k);
      for (Set<String> aheadK : lineMapToSet.keySet()) {
        if (!(aheadK.equals(k))) {
          if (isSubset(aheadK, v)) {
            Set<String> aheadV = lineMapToSet.get(aheadK);
            Iterator<String> i = aheadV.iterator();
            while (i.hasNext()) {
              v.add(i.next());
            }
            lineMapToSet.put(k, v);
          }
        }
      }
    }
    System.out.println(lineMapToSet);
  }

  public <T> boolean isSubset(Set<String> setA, Set<String> setB) {
    return setB.containsAll(setA);
  }
}
