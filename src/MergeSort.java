import java.io.*;
import java.util.*;

public class MergeSort {

	/**
	 * stores an ordered lists of words for searching
	 */
	private static ArrayList<String> words;

	/**
	 * main program
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {

		words = getWords();
		mergeSort(words);
		int interval = 100;
		String[] find = new String[100];    
		int index = interval;
		for (int i = 0; i < interval - 1; i++) {
			index += words.size() / interval;
			find[i] = words.get(index);
		}
		find[interval - 1] = "Xdfsdda";

		SearchResult seqResult;
		SearchResult binResult;

		System.out.println("#\tBinary\tSequential\tindex\tword");

		for (int i = 0; i < find.length; i++) {
			seqResult = sequentialSearch(find[i]);
			binResult = binarySearch(find[i]);
			System.out.println(i + "\t" + binResult.getIterations() + "\t" + seqResult.getIterations() + "\t" + binResult.getIndex() + ":" + seqResult.getIndex() + "\t" + find[i] );
		}
	}

	/**
	 * sequential search to find wordToFind in the ArrayList words
	 * 
	 * @param wordToFind - String to find in words
	 * @return a SearchResult (index of item found or -1 if not found, number of iterations in search loop)
	 */
	public static SearchResult sequentialSearch(String wordToFind) {
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
	 * @param wordToFind - String to find in words
	 * @return a SearchResult (index of item found or -1 if not found, number of iterations in search loop)
	 */
	public static SearchResult binarySearch(String wordToFind) {
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
	 * Implement Selection Sort
	 * @param list - ArrayList of words to be sorted
	 */
	public static void selectionSort(ArrayList<String> list) {
		for (int i = 0; i < list.size() - 1; i++) {
			// find index of smallest element
			int smallest = i;
			for (int j = i + 1; j < list.size(); j++) {
				if (list.get(j).compareTo(list.get(smallest)) < 0) {
					smallest = j;
				}
			}
			swap(list, i, smallest); // swap smallest to front			
		}
	}
	
	
	/**
	 * Implement Recursive Merge Sort
	 * @param list - ArrayList of words to be sorted
	 */
	public static void mergeSort(ArrayList<String> list) {
	
	}
	
	public static void swap(ArrayList<String> list, int i, int j) {
		String temp = list.get(i);
		list.set(i, list.get(j));
		list.set(j, temp);
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

