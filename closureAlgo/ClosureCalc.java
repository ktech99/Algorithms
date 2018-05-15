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
    System.out.println(all);
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
    System.out.println(lineMapToSet);
    return ret;
  }

  public void permutes() {
    int size = lineMapToSet.size();
    Map<Set<String>, Set<String>> permutations = new TreeMap<>();

    System.out.println(permutes(permutations, size));
  }

  private Set<String> permutes(Map<Set<String>, Set<String>> permutations, int size) {
    if (size == -1) {
      return null;
    }
    Set<String> v = new TreeSet<String>();
    Set<String> altk = new TreeSet<String>();
    for (Set<String> k : permutations.keySet()) {
      if (isSubset(permutations.get(k), all)) {
        return k;
      } else {
        v = permutations.get(k);
        altk.addAll(k);
      }
    }
    for (Set<String> k : lineMapToSet.keySet()) {
      altk.addAll(k);
      v.addAll(lineMapToSet.get(k));
      Map<Set<String>, Set<String>> newPerm = new HashMap<>();
      newPerm.put(altk, v);
      return permutes(newPerm, --size);
    }
    return v;
  }

  private <T> boolean isSubset(Set<String> setA, Set<String> setB) {
    return setB.containsAll(setA);
  }
}
