// Class to find the longest substring amongst 2 strings
public class LongestSubFinder {

  private int max; // Stores the length of the longest substring
  private String longest; // STrores th longest subString

  public LongestSubFinder() {
    max = 0;
    longest = "";
  }

  // Finds the longest substring between 2 strings
  // Updates the max length of longest substring
  public void longestFinder(String str1, String str2) {
    if (str1 == "" || str2 == "") {
      return;
    }
    str1 = str1.toLowerCase();
    str2 = str2.toLowerCase();
    for (int i = 0; i < str1.length(); i++) {
      for (int j = 0; j < str2.length(); j++) {
        for (int counter = 1;
            counter <= str2.length() - j && counter <= str1.length() - i;
            counter++) {
          if (str1.substring(i, i + counter).equals(str2.substring(j, j + counter))) {
            if (counter > max) {
              longest = str1.substring(i, i + counter);
              max = longest.length();
            }
          }
        }
      }
    }
  }

  // Return the longest substring
  public String longest() {
    return longest;
  }

  // Returns the length of the liongest substring
  public int maxLength() {
    return max;
  }
}
