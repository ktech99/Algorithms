# fibonacci
This program calculates the n'th term of the Fibonacci series in 2 different ways.<br />
Method 1 : using a third temporary variable storing the sum of 2 terms. <br />
Method 2 : Using an array and storing all terms of the series and printing out the last term. <br />
For those who don't know, the Fibonacci series is a series of numbers in which the next number is the sum of the<br /> 
previous two numbers.<br />
```
The series : 0 1 1 2 3 5 8 13 21.... 
as we can see:
0 + 1 = 1
1 + 1 = 2
1 + 2 = 3
3 + 5 = 8
```
and so on...<br>

The Pseudo code for this :
```
val1 = 0; // first term
val2 = 1; // Second term
val3 = 0; // Temporary variable to store sum of terms
for 1 --> Number of terms
  val3 = val1 + val2;  // Storing the sum of the numbers
  val1 = val2;
  val2 = val3;
 end loop
print(val2); // nth term of series
```
