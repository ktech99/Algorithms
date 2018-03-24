# Bubble Sort
Bubble Sort is a famous sorting algorithm.<br>
It works by comparing a number in a list to the next number in the list.<br>
  if (current number > next number) --> swap numbers
  else --> continue to next number
SudoCode :<br>
```
n = unsorted list
for 0 --> n - 1
  for 0 --> n - 1
    if(current number > next number){
      //swap both numbers;
      temp = current number
      current number = next number
      next number = current
    }
   end inner loop
 end outer loop
```
This is an inefficient method of sorting as the complexity is O(n^2)
