import java.math.BigInteger;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
/*
Solution for hacker rank problem
https://www.hackerrank.com/domains/algorithms
 */
public class Test {

    static List<Integer> compareTriplets(List<Integer> a, List<Integer> b) {
        int aCount = 0;
        int bCount = 0;
        String abc = null;

        aCount = (int) a.stream().filter(aValue -> b.stream().anyMatch(bValue -> bValue < aValue)).count();
        bCount = (int) b.stream().filter(bValue -> a.stream().anyMatch(aValue -> aValue < bValue)).count();

        int size = a.size();
        for (Integer value : a) {
            if (a.get(size) < b.get(size)) {
                bCount++;
            } else {
                if (a.get(size) > b.get(size)) {
                    aCount++;
                }
            }
            size--;
        }


        return Arrays.asList(aCount, bCount);

    }

    static long aVeryBigSum(long[] ar) {
        long sum = 0;
        for (long value : ar) {
            sum += value;
        }
        return sum;
    }

    static int diagonalDifference(int[][] arr) {

        int total1 = 0, total2 = 0;

        for (int row = 0; row < arr.length; row++) {

            total1 += arr[row][row];
        }

        for (int row = 0; row < arr.length; row++) {

            total2 += arr[row][arr.length - row - 1];
        }

        return Math.abs(total1 - total2);

    }

    static void miniMaxSum(int[] arr) {
        List<Integer> arry = Arrays.stream(arr).boxed().collect(Collectors.toList());
        Collections.sort(arry);
        long total = arry.stream().mapToLong(i -> i).sum();
        long minSum = total - arry.get(arr.length - 1);
        long maxSum = total - arry.get(0);
        System.out.println(minSum + " " + maxSum);
    }

    static int birthdayCakeCandles(int[] ar) {
        List<Integer> arry = Arrays.stream(ar).boxed().sorted().collect(Collectors.toList());
        int largestValue = arry.get(ar.length - 1);
        return Collections.frequency(arry, largestValue);
    }

    static void plusMinus(int[] arr) {
        double positiveCount = 0, negativeCount = 0, zeroCount = 0;

        List<Integer> arry = Arrays.stream(arr).boxed().collect(Collectors.toList());

        positiveCount = arry.stream().filter(a -> a > 0).count();
        negativeCount = arry.stream().filter(a -> a < 0).count();
        zeroCount = arry.stream().filter(a -> a == 0).count();

        double decimalPositive = (positiveCount / (double) arr.length);
        double decimalNegative = (negativeCount / (double) arr.length);
        double decimalZero = (zeroCount / (double) arr.length);

        System.out.println(decimalPositive);
        System.out.println(decimalNegative);
        System.out.println(decimalZero);
    }

    /*
     * Complete the timeConversion function below.
     */
    static String timeConversion(String s) {
        /*
         * Write your code here.
         */
        String[] time = s.split(":");
        String hours = time[0];
        String minutes = time[1];
        String seconds = time[2].substring(0, 2);
        String dayEve = time[2].substring(2, 4);
        String value;
        if (dayEve.equals("AM")) {
            value = ((hours.equals("12") ? "00" : hours)
                    + ":" + minutes + ":" + seconds);
        } else {
            value = ((hours.equals("12") ? hours :
                    (Integer.parseInt(hours) + 12))
                    + ":" + minutes + ":" + seconds);
        }
        return value;
    }

    /*
     * Complete the gradingStudents function below.
     */
    static int[] gradingStudents(int[] grades) {
        int[] result = new int[grades.length];
        int count = 0;
        for (int grade : grades) {
            if (grade < 38) {
                result[count] = grade;
                ++count;
            } else {
                int firstDigit = grade % 10;
                if (firstDigit < 5) {
                    if (5 - firstDigit < 3) {
                        result[count] = grade + (5 - firstDigit);
                        ++count;
                    } else {
                        result[count] = grade;
                        ++count;
                    }
                } else {
                    if (10 - firstDigit < 3) {
                        result[count] = grade + (10 - firstDigit);
                        ++count;
                    } else {
                        result[count] = grade;
                        ++count;
                    }
                }
            }
        }
        return result;
    }

    // Complete the countApplesAndOranges function below.
    static void countApplesAndOranges(int s, int t, int a, int b, int[] apples, int[] oranges) {
        int appleCount = 0, orangeCount = 0;
        for (int apple : apples) {
            if ((apple + a) >= s && (apple + a) <= t) {
                ++appleCount;
            }
        }
        System.out.println(appleCount);
        for (int orange : oranges) {
            if ((orange + b) >= s && (orange + b) <= t) {
                ++orangeCount;
            }
        }
        System.out.println(orangeCount);
    }

    static String kangaroo(int x1, int v1, int x2, int v2) {
        boolean result = false;
        int difference = 0;
        while (difference >= 0) {
            if(x1<x2 && (v1<v2 || v1 == v2)){
                break;
            }
            if(x1 == x2){
                result = true;
                break;
            }
            x1+=v1;
            x2+=v2;
            difference = x2-x1;
        }
        if(result)
            return "YES";
        else
            return "NO";
    }

    // Complete the getWays function below.
    static long getWays(long n, long[] c) {

        long table[] = new long[(int) (n + 1)], i;

        Arrays.fill(table, 0);

        table[0] = 1;

        for(long coins : c){
            for (i = (int) coins; i <= n; i++)
                table[(int)i] += table[(int) (i - coins)];
        }
        return table[(int) n];
    }

    // Complete the getWays function below.
    static long getWays1(long n, long[] c) {
      int[] combinations = new int[(int) (n + 1)];
      Arrays.fill(combinations,0);
      combinations[0]=1;
      for(long coin : c){
          for(int i = 1;i<combinations.length ; i++){
                if(i >= coin){
                    combinations[i] += combinations[(int) (i -coin)];
                }
          }
      }
      return combinations[(int) n];
    }

    // Complete the extraLongFactorials function below.
    static void extraLongFactorials(int n) {

        BigInteger f = new BigInteger("1");

        for (int i = 2; i <= n; i++)
            f = f.multiply(BigInteger.valueOf(i));

        System.out.println(f);
    }

    public static void main(String[] arg) {
        //int[] value = {140638725,436257910,953274816,734065819,362748590,953274816};
        //int[] value = {140638725,140638725,140638725,140638725,140638725,140638725};
        //birthdayCakeCandles(value)
        /*int[] a = {-2, 2, 1};
        int[] b = {5, -6};
        countApplesAndOranges(7, 11, 5, 15, a, b);*/
        //kangaroo(4523,8092 ,9419 ,8076);
        //kangaroo(0,3 ,4 ,2);
        long[] a = {5,6,2,3};
        long aa = getWays1(10,a);
        System.out.println("value   :  "+aa);
    }
}
