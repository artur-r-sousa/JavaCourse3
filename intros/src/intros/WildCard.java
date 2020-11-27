package intros;

import java.util.Arrays;
import java.util.List;

public class WildCard {

	public static void main(String[] args) {		
		List<Object> myInts = Arrays.asList(5, 2, 10, 12.0, "Maria");
		printList(myInts);
	}
		
	public static void printList(List<? extends Object> list) {
		for (Object obj : list) {
			System.out.println(obj);
		} 
	}
	
	/*
	public static void printList(List<? super Object> list) {
		for (Object obj : list) {
			System.out.println(obj);
		} 
	}
	*/
	
	/*
	 * Output:
		 * 5
		 * 2
		 * 10
		 * 12.0
		 * Maria
	 */
	
}
