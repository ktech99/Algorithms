# Longest Substring
Takes 2 strings as input and computes the longest substring between those 2 strings
```
String1 = abcdxyz
String2 = xyzabcd
Longest subString --> abcd
```
Big O --> O(n x m x (smaller of m and n))

Pseudo Code :
```
int max = 0; // Length of longest substring
String longest = ""; // Longest common substring
if (string1 or string 2 = "")
  return
for (i = 0 --> string1 length)
  for (j = 0 --> string2 length)
    for (counter = 1 --> (string1 length or string2 length)
      str1 = string1 substring from i --> i + counter;
      str2 = string2 substring from j --> j + counter;
      if (str1 = str2)
        if(counter > max)
          longest = str1;
          max = length of longest
      end counter loop
    end j loop
  end i loop
  Print longest
 ```
