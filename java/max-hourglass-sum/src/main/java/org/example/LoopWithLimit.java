package org.example;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'hourglassSum' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts 2D_INTEGER_ARRAY arr as parameter.
     */

    public static int hourglassSum(List<List<Integer>> arr) {
        // The hourglass sum is calculated as follows:
        // The minimum value of an hourglass is -9 * 7 = -63
        int sum = -63;

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                // The hourglass sum is calculated as follows:
                int sumTemp = (arr.get(i).get(j) + arr.get(i).get(j + 1) + arr.get(i).get(j + 2)
                        + arr.get(i + 1).get(j + 1)
                        + arr.get(i + 2).get(j) + arr.get(i + 2).get(j + 1) + arr.get(i + 2).get(j + 2));
                // If the sum is greater than the current maximum, update the maximum
                if (sum < sumTemp)
                    sum = sumTemp;
            }
        }
        return sum;
    }

}


public class LoopWithLimit {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        List<List<Integer>> arr = new ArrayList<>();

        IntStream.range(0, 6).forEach(i -> {
            try {
                arr.add(
                        Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                                .map(Integer::parseInt)
                                .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        int result = Result.hourglassSum(arr);
        System.out.println("Max hourglass sum: " + result);

        bufferedReader.close();
    }
}

/*
sample inputs:

        1 1 1 0 0 0
        0 1 0 0 0 0
        1 1 1 0 0 0
        0 0 2 4 4 0
        0 0 0 2 0 0
        0 0 1 2 4 0

        output: 19

        -1 -1 0 -9 -2 -2
        -2 -1 -6 -8 -2 -5
        -1 -1 -1 -2 -3 -4
        -1 -9 -2 -4 -4 -5
        -7 -3 -3 -2 -9 -9
        -1 -3 -1 -2 -4 -5

        output: -6

*/
