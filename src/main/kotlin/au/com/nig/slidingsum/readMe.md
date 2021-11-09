Kata Array of integers


The exercise is computing a sliding sum of 3.


Example of unit test:

computeSlidingSum( [1, 3, 4, 9, 0] )
result: [8, 16, 13, 9, 0]
[(1 + 3 + 4), (3+4+9), (4+9+0), (9+0), (0)]

Each constraint will be implemented one by one.


What are the difficulties of this exercise?

Constraints
- make it work
- not more than O(N) complexity
- accepts only positive integers
- empty list should throw exception
- evolve and implement pagination when there are more than 10 invoices. Change signature of function to take an integer and now which slice of integers to take.




computeSlidingSum( [1, 3, 4, 9, 0, 1, 2, 3, 4 ,5 ,6 ,6 ,7, 78,9 ,0], 0 )
result:
[(1 + 3 + 4), (3+4+9), (4+9+0), (9+0+ 1), (0+1+2), (1+2+3), ((2+3+4), (3+4+5), 4+5+6, 5+6+6]
