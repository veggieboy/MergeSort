import java.io.*;
import java.util.*;

public class MergeSort {

 /**
  * main program
  * @param args
  * @throws IOException
  */
 public static void main(String[] args) throws IOException {

  ArrayList<String> words = getWords();
  ArrayList<String> sortedWords = mergeSort(words);
  int interval = 100;
  String[] find = new String[100];    
  int index = interval;
  for (int i = 0; i < interval - 1; i++) {
   index += sortedWords.size() / interval;
   find[i] = sortedWords.get(index);
  }
  find[interval - 1] = "Xdfsdda";

  SearchResult seqResult;
  SearchResult binResult;

  System.out.println("#\tBinary\tSequential\tindex\tword");

  for (int i = 0; i < find.length; i++) {
   seqResult = sequentialSearch(sortedWords, find[i]);
   binResult = binarySearch(sortedWords, find[i]);
   System.out.println(i + "\t" + binResult.getIterations() + "\t" + seqResult.getIterations() + "\t" + binResult.getIndex() + ":" + seqResult.getIndex() + "\t" + find[i] );
  }
 }

 /**
  * sequential search to find wordToFind in the ArrayList words
  * 
  * @param words - List of words
  * @param wordToFind - String to find in words
  * @return a SearchResult (index of item found or -1 if not found, number of iterations in search loop)
  */
 public static SearchResult sequentialSearch(ArrayList<String> words, String wordToFind) {
  int iterations = 0;
  for (int i = 0; i < words.size(); i++) {
   iterations++;
   if (words.get(i).equals(wordToFind)) {
    return new SearchResult(i, iterations);
   }
  }
  return new SearchResult(-1, iterations);  
 }

 /**
  * binary search to find wordToFind in the ArrayList words
  * 
  * @param words - List of words
  * @param wordToFind - String to find in words
  * @return a SearchResult (index of item found or -1 if not found, number of iterations in search loop)
  */
 public static SearchResult binarySearch(ArrayList<String> words, String wordToFind) {
  int iterations = 0;
  int min = 0;
  int max = words.size() - 1;
  while (min <= max) {
   iterations++;
   int mid = (max + min) / 2;
   int compare = words.get(mid).compareTo(wordToFind);
   if (compare == 0) {
    return new SearchResult(mid, iterations);
   } else if (compare < 0) {
    min = mid + 1;
   } else {
    max = mid - 1;
   }
  }
  return new SearchResult(-1, iterations);  
 }
 
 /**
  * Use merge sort to recursively sort the list passed in.
  * @param list - ArrayList of words to be sorted
  * @return A list representing a sorted version of list that was passed in.
  */
 public static ArrayList<String> mergeSort(ArrayList<String> list) {
   if(list.size()<=1)
   {return list;}
   else 
   {
     ArrayList<String> left= new ArrayList<String> (list.subList(0, list.size()/2));
     ArrayList<String> right=new ArrayList<String> (list.subList(list.size()/2, list.size()));
     mergeSort(left);
     mergeSort(right);
     return merge(list, left, right);
   }
 }

 
 
 /**
  * Merge the left and right lists together in sorted order.
  * 
  * @param leftList The first list to be merged.
  * @param rightList The second list to be merged.
  * @return A single list by merging the two parameters in sorted order.
  */
 private static ArrayList<String> merge(ArrayList<String> result, ArrayList<String> left, ArrayList<String> right) {
   int i1=0;
   int i2=0;
   for(int i=0; i<result.size(); i++)
   {
     if(i2>=right.size() || (i1<left.size() && (left.get(i1).compareTo(right.get(i2))<0)))
     {
       result.set(i, left.get(i1));
       i1++;
     }
     else
     {
       result.set(i, right.get(i2));
       i2++;
      }
}
   return result;
   
 }

 /**
  * create an ArrayList<String> and populate it from text file
  * 
  * @return an ArrayList<String>
  * @throws FileNotFoundException
  */
 public static ArrayList<String> getWords() throws FileNotFoundException {
  ArrayList<String> result = new ArrayList<String>();
  Scanner input = new Scanner(new File("words.txt"));
  while(input.hasNextLine()) {
   result.add(input.nextLine());
  }
  input.close();
  return result;
 }
}
