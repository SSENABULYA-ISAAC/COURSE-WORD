import java.util.Arrays;  
import java.util.Collections;  

public class ArrangeNumbersDescending {  
    public static void main(String[] args) {  
        // Array of numbers to be arranged  
        Integer[] numbers = {1, 2, 3, 4, 5};  

        // Sorting the array in descending order  
        Arrays.sort(numbers, Collections.reverseOrder());  

        // Output: Displaying the sorted numbers  
        System.out.println("Numbers arranged in descending order:");  
        for (int num : numbers) {  
            System.out.print(num + " ");  
        }  
    }  
}
