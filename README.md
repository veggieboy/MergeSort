# MergeSort

You will be implementing **merge sort** (http://en.wikipedia.org/wiki/Merge_sort#Top-down_implementation_using_lists).

Merge sort is an efficient sorting algorithm which recursively splits a list into smaller sublists and then merges them together.

You will be implementing the two methods necessary for merge sort: `mergeSort()` and `merge()`.

You should follow the pseudocode linked above. To summarize:

## mergeSort()
- Your base case is if the list length is less than or equal to one. In this case, the list is sorted; you should return it.
- Otherwise, you need to split the list. To do this, find the middle of the list; now create two new ArrayLists to hold the left and right sublists. Add everything from the original list *before* the midpoint to the first (left) ArrayList, and everything from the midpoint to the end of the original list to the second (right) ArrayList.
- Recursively call mergeSort on the left and right list (you can assign the return value to the left and right ArrayLists you created, and pass them to the recursive call - basically replacing them with their sorted version).
- Merge the the two lists and return the result.
 
## merge()
This method will return a merged and sorted version of the two lists that are passed in, by removing elements from those lists to build up a sorted, single merged list.
- Create an ArrayList to hold the return value.
- Loop as long as both the first list and second list have elements in them (Which loop would be best for this?)
  - If the first element in the first list is smaller than the first element in the second list, remove the first element from the first list and add it to the results list (Remember how we compare Strings! We can't use <=)
  - Otherwise, remove the first element from the second list and add it to the results list.
- At this point, there might be a few elements in one of the lists (since one will probably empty out before the other). So, we need to make sure we add all the remaining elements from each list to the results.
- First, go over the first list as long as it still has elements in it (which loop would be best?) and remove the first element, adding it to the results.
- Next, go over the second list as long as it still has elements in it (which loop would be best?) and remove the first element, adding it to the results.
- Return the results list.

## How do I know when I'm done?
When you run the program, it will call your mergeSort method to sort a large dictionary of words, and then use Binary Search and Sequential Search (remember?) to look up words in the sorted dictionary, recording the number of loop iterations it took to find the element. You will know everything is done correctly when:
- The program actually runs and exits, and doesn't loop forever.
- None of the results show -1 for the "index" column.
- The "index" column in the output is in ascending order. The program looks for words in lexicographical order, so if you sorted the dictionary correctly, the indexes of the words in the sorted dictionary list will be in ascending order. (Why?)

