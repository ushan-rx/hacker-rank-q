import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

// This is a simple Java program that reverses an array using a loop.
// It reads an array of integers from the standard input, reverses it, and prints the reversed array.
// The program uses a for loop to iterate through the array in reverse order and adds each element to a new list.
// The reversed list is then returned and printed to the standard output.

// *** this doesn't change the original array, it creates a new one ***

class Result {

    /*
     * Complete the 'reverseArray' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts INTEGER_ARRAY a as parameter.
     */
    public static List<Integer> reverseArray(List<Integer> a) {
        List<Integer> newArr = new ArrayList<>();
        for(int i = a.size()-1; i>=0; i--){
            newArr.add(a.get(i));
        }
        return newArr;
    }

}

public class UsingLoop {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());
        bufferedReader.close();
        List<Integer> res = Result.reverseArray(arr);
        System.out.println("Original array" + arr);
        System.out.println("Reversed result" + res);
    }
}
