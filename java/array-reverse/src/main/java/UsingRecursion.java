import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;


// This is a simple Java program that reverses an array using recursion.
// It reads an array of integers from the standard input, reverses it, and prints the reversed array.
// The program uses a recursive function to swap the elements at the start and end indices until they meet in the middle.
// The reversed list is then returned and printed to the standard output.
// *** this changes the original array, it doesn't create a new one ***


public class UsingRecursion {

    public static void reverseRecursive(List<Integer> a, int start, int end) {
        // Base case: if start index is greater than or equal to end index, return
        if (start >= end) {
            return;
        }
        // Swap the elements at start and end indices
        int temp = a.get(start);
        a.set(start, a.get(end));
        a.set(end, temp);

        // Recursive call with updated indices
        reverseRecursive(a, start + 1, end - 1);
    }


    public static List<Integer> reverseArray(List<Integer> a) {
        reverseRecursive(a, 0, a.size() - 1);
        return a;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());
        bufferedReader.close();

        System.out.println("Original array" + arr);

        List<Integer> res = reverseArray(arr);

        System.out.println("Reversed result" + res);
    }
}
