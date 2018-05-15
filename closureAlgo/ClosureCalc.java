import java.util.*;

public class ClosureCalc {

  private Map<String, String> lineMap;
  private Map<Set<String>, Set<String>> lineMapToSet;
  private Set<String> values;
  private Set<String> keys;
  private Set<String> all;
  private Set<String> container;

  public ClosureCalc() {
    lineMap = new HashMap<String, String>();
    lineMapToSet = new HashMap<Set<String>, Set<String>>();
    all = new TreeSet<String>();
    container = new TreeSet<String>();
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
      all.addAll(values);
      x += 1;
    }
  }

  public int completer() {
    int ret = 0;
    for (Set<String> k : lineMapToSet.keySet()) {
      Set<String> v = lineMapToSet.get(k);
      for (Set<String> aheadK : lineMapToSet.keySet()) {
        if (!(aheadK.equals(k))) {
          if (isSubset(aheadK, v)) {
            Set<String> aheadV = lineMapToSet.get(aheadK);
            Iterator<String> i = aheadV.iterator();
            while (i.hasNext()) {
              String toAdd = i.next();
              if (!v.contains(toAdd)) {
                v.add(toAdd);
                ret = 1;
              }
            }
            if (ret == 1) {
              lineMapToSet.put(k, v);
            }
          }
        }
      }
    }
    return ret;
  }

  public void permutes() {
    int size = lineMapToSet.size();
    Map<Set<String>, Set<String>> permutations = new HashMap<>();
    permutes(permutations, size);
  }

  private void permutes(Map<Set<String>, Set<String>> permutations, int size) {
    if (size > 0) {
      for (Set<String> k : lineMapToSet.keySet()) {
        Set<String> key = new TreeSet<String>();
        Set<String> value = new TreeSet<String>();
        key.addAll(k);
        value.addAll(lineMapToSet.get(k));
        if (permutations.size() > 0) {
          for (Set<String> p : permutations.keySet()) {
            if (p != null) {
              key.addAll(p);
              value.addAll(permutations.get(p));
            }
          }
        }
        if (isSubset(all, value) && value != null) {
          String p = key.toString();
          container.add(p);
          System.out.println(container);
        }
        permutations.put(key, value);
        permutes(permutations, --size);
        if (size == lineMapToSet.size()) permutations.remove(key);
      }
    }
  }

  private <T> boolean isSubset(Set<String> setA, Set<String> setB) {
    return setB.containsAll(setA);
  }

  public void printer() {
    // ToDo why isn't container printing
    System.out.println(container);
  }
}
