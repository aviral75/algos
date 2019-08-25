package self.aviral.datastructures.arrays;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/*
 * The class shows an example of using Compartor with compare method
 * vs java lambda usage to do same thing .
 * Also List.of return immutable list of cannot be sorted or modified.
 */

public class EvenOddComparator {	
	public static final Comparator<Integer> oddEvenComparator = new Comparator<Integer>() {

		@Override
		public int compare(Integer o1, Integer o2) {
			if(o1%2==0 && o2%2!=0) return -1;
			if(o1%2!=0 && o2%2==0) return 1;
			return o1-o2;
		}

	};



	public static void main(String[] args) {
		// with arrays and comparator
		Integer []nums = new Integer[] {6,1,3,7,5,4};
		Arrays.sort(nums,oddEvenComparator);

		// with list and lamda
		List<Integer> numList =Arrays.asList(6,1,2,3,7,5,4);
		numList.sort((a,b)->{if((a&1)==0 && (b&1)!=0) return -1; if ((b&1)==0 && (a&1)!=0) return 1; return a-b;} );
		numList.stream().forEach(System.out::println);

		// with stream and lambda
         Stream.of(6,1,2,3,7,5,4)
        	.sorted((a,b)->{if((a&1)==0 && (b&1)!=0) return -1; if ((b&1)==0 && (a&1)!=0) return 1; return a-b;} )
            .collect(Collectors.collectingAndThen(Collectors.toList(), 
                        Collections::unmodifiableList))
            .forEach(System.out::println);

	}
}

