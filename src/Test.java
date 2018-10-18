import java.math.BigInteger;
import java.util.*;
import java.util.stream.Collectors;

import static java.util.Arrays.binarySearch;
import static java.util.stream.IntStream.range;

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


    // Complete the appendAndDelete function below.
    static String appendAndDelete(String s, String t, int k) {
        if(t.length() - s.length() > k) return "No";

      List<String> initial = Arrays.asList(s.split(""));
      initial.stream().sorted();
      for(String value : initial){

      }
      List<String> desired = Arrays.asList(s.split(""));
      desired.stream().sorted();
      Collections.frequency(initial, "a");
      return "yes";
    }

    // Complete the appendAndDelete function below.
    static String appendAndDelete1(String s, String t, int k) {

        if(t.length() - s.length() > k) return "No";

        int size = s.length()<t.length() ? s.length() : t.length();
        int count = 0 ;
        for(int i = 0 ;i < size ; i ++){
            if(s.charAt(i) == t.charAt(i)){
                ++count;
            }else{
                break;
            }
        }
        int removal = s.length() - count;
        int add = t.length() - count;
        if(s.equals(t)){
            return "Yes";
        }
        if(removal+add <= k){
            return "Yes";
        }else {
            return "No";
        }
    }

    // Complete the dayOfProgrammer function below.
    static String dayOfProgrammer(int year) {
        if (year == 1918)
            return "26.09.1918";
        if (year % 4 == 0 && (year < 1918 || year % 400 == 0 || year % 100 != 0))
            return "12.09."+year;
        else
            return "13.09."+year;
    }

    // Complete the bonAppetit function below.
    static void bonAppetit(List<Integer> bill, int k, int b) {

        int totalBill = bill.stream().mapToInt(Integer::intValue).sum();
        int average = Math.abs(totalBill - bill.get(k))/2;
        if((average-b) != 0 ){
            System.out.println(Math.abs(average-b));
        }else {
            System.out.println("Bon Appetit");
        }
    }

    // Complete the sockMerchant function below.
    static int sockMerchant(int n, int[] ar) {
        Set<Integer> uniqueColours = Arrays.stream(ar).boxed().collect(Collectors.toSet());
        int count = 0 ;
        for(Integer colour : uniqueColours){
            count += Arrays.stream(ar).boxed().filter(i -> i==colour).count() / 2;
        }
        return count;
    }

    /*
     * Complete the pageCount function below.
     */
    static int pageCount(int n, int p) {
        /*
         * Write your code here.
         */
        int page1 = Math.abs((p) / 2);
        if(n%2==0){
            n++;
        }
        int page2 = Math.abs((p - (n)) / 2);
        return page1 < page2 ? page1 : page2;

    }

    // Complete the countingValleys function below.
    static int countingValleys(int n, String s) {
        int v = 0;     // # of valleys
        int lvl = 0;   // current level
        for(char c : s.toCharArray()){
            if(c == 'U') ++lvl;
            if(c == 'D') --lvl;

            // if we just came UP to sea level
            if(lvl == 0 && c == 'U')
                ++v;
        }
        return v;
    }

    /*
     * Complete the getMoneySpent function below.
     */
    static int getMoneySpent(int[] keyboards, int[] drives, int b) {
        /*
         * Write your code here.
         */
        /*int sum =0,result=0;
        for(int i = 0 ; i < keyboards.length; i ++){
            for (int j =0 ; j < drives.length;j++){
                sum = keyboards[i] + drives[j];
                if(sum > b && result == 0){
                    result = -1;
                }
                if(result < sum && sum < b) {
                    result = sum;
                }
            }
        }
        return result;
*/
        Arrays.sort(keyboards);//Ascending order
        Arrays.sort(drives);//Ascending order

        int max = -1;
        for(int i = keyboards.length-1, j = 0; i >= 0; i--){
            for(; j < drives.length; j++){
                if(keyboards[i]+drives[j] > b) break; //This prevents j from incrementing
                if(keyboards[i]+drives[j] > max)
                    max = keyboards[i]+drives[j];
            }
        }
        return max;
    }

    // Complete the catAndMouse function below.
    static String catAndMouse(int x, int y, int z) {
        if(Math.abs(x-z) > Math.abs(y-z)){
            return "Cat B";
        }else {
                if(Math.abs(x-z) == Math.abs(y-z)){
                return "Mouse C";
                }else {
                    return "Cat A";
                    }
            }

    }

    // Complete the climbingLeaderboard function below.
    static int[] climbingLeaderboard(int[] scores, int[] alice) {
        int[] rank = new int[alice.length];
        int n = scores.length;
        int[] array = range(0,n).map(i->scores[n-i-1]).distinct().toArray();
        int index = 0;
        int count = 0 ;
        for(int score: alice) {
            index = binarySearch(array, index<0?0:index, array.length, score);
            if(index<0) index=-index-2;
            rank[count] = (array.length-index);
            count++;
        }
        return rank;
    }

    // Complete the hurdleRace function below.
    static int hurdleRace(int k, int[] height) {
    int tallestHurdle = Arrays.stream(height).max().getAsInt();
    return tallestHurdle-k > 0 ? tallestHurdle-k : 0 ;
    }

    // Complete the designerPdfViewer function below.
    static int designerPdfViewer(int[] h, String word) {
        char alpha = 'a';
        Map<Character,Integer> store = new HashMap<>();
        for(int i = 0 ; i < 26 ; i ++){
            store.put(alpha,h[i]);
            alpha++;
        }
        char[] chars = word.toCharArray();
        int max = 0 ;
        for(char c : chars){
            if(max < store.get(c))max = store.get(c);
        }
        return max * word.length();
    }

    // Complete the utopianTree function below.
    static int utopianTree(int n) {
        int height = 0;
        int j = 0;
        while(j<=n){
            if(j ==0 )height=1;
            else{
                if(j %2 == 0 ){
                    height += 1;
                }else{
                    height *= 2;
                }
            }
            j++;
        }
        return height;
    }

    // Complete the angryProfessor function below.
    static String angryProfessor(int k, int[] a) {
    int[] studentOnTime = Arrays.stream(a).filter(value -> value<=0).toArray();
    if(studentOnTime.length >= k)return "NO";
    else return "YES";
    }

    // Complete the queensAttack function below.
    static int queensAttack(int n, int k, int r_q, int c_q, int[][] obstacles) {
        String value = new String();
return 1;
    }

    // Complete the circularArrayRotation function below.
    static int[] circularArrayRotation(int[] a, int k, int[] queries) {
        for(int j = 0 ; j< k;j++) {
            int temp = a[a.length - 1];
            for (int i = 1; i < a.length; i++) {
                a[a.length - i] = a[a.length - i - 1];
            }
            a[0] = temp;
        }
        int[] result = new int[queries.length];
        for(int i = 0 ; i < queries.length ; i++){
            result[i] = a[queries[i]];
        }
        return result;
    }

    static int[] circularArrayRotation1(int[] a, int k, int[] queries) {
        int N = a.length; //an size of array of integers to rotate
        int K = k; //an integer, the rotation count
        int Q = queries.length;
        int rot = K % N;
        int[] result = new int[queries.length];
        for (int i = 0; i < Q; i++) {
            int idx = queries[i];
            if (idx - rot >= 0)
                result[i] = (a[idx - rot]);
            else
                result[i] = (a[idx - rot + a.length]);
        }
        return result;
    }

    // Complete the permutationEquation function below.
    static int[] permutationEquation(int[] p) {
        int[] inverse_p = new int[p.length + 1];
        for(int i = 1 ; i <= p.length ; i++){
            inverse_p[p[i-1]] = i;
        }
        int[] result = new int[p.length];
        for(int i = 1; i<= p.length ;i++){
            int y = inverse_p[inverse_p[i]];
            result[i-1] = y;
        }
        return result;
    }

    // Complete the jumpingOnClouds function below.
    static int jumpingOnClouds(int[] c, int k) {

        int e=100;
        for(int i=0;i<c.length;i=k+i)
        {
            if(c[i]==0)
            {
                e=e-1;
            }
            else
            {
                e=e-3;
            }
        }
        return e;

    }

    // Complete the findDigits function below.
    static int findDigits(int n) {
        int r = n;
        int count = 0;
        while(r > 0){
            if(r % 10 != 0 && n % (r % 10) == 0) count++;
            r = r / 10;
        }
        return count;
    }

    // Complete the encryption function below.
    static String encryption(String s) {

        String str = s.replaceAll("\\s","");
        int len = str.length();
        double value = Math.sqrt(len);
        double floorValueRow = Math.floor(value);
        double ceilValueColumn = Math.ceil(value);

         if(floorValueRow*ceilValueColumn < value){
             floorValueRow++;
         }

         char[] charArray = s.toCharArray();
         StringBuffer result = new StringBuffer();

         for(int i = 0 ; i < ceilValueColumn ; i++){
             int p = i;
             for(int j = 0 ; j < ceilValueColumn ; j++){
                 if(p < len)
                 result.append(charArray[p]);
                 p = (int) (p + ceilValueColumn);
             }
             result.append(" ");
         }

        return result.toString().trim();
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
        /*long[] a = {5,6,2,3};
        long aa = getWays1(10,a);
        System.out.println("value   :  "+aa);*/
        //appendAndDelete1("abcd","abcdert",10);
        //dayOfProgrammer(2016);
        //bonAppetit(Arrays.asList(3,10,2,9),1,12);
        int[] arr = {100,-101,-50,40,-42,20,10};
        int[] b = {5,25,50,120};
        //sockMerchant(9 , arr);
        //int[] a = {4};
        //int[] b = {5};
        //System.out.println(getMoneySpent(a ,b ,5));
        //System.out.println(catAndMouse(1,2,3));
        //climbingLeaderboard(arr,b);
        //utopianTree(4);
        //angryProfessor(4,arr);
        //circularArrayRotation(arr,1,b);
        int[] aa = {4 ,3 ,5 ,1 ,2};
        //permutationEquation(aa);
        encryption("haveaniceday");
    }
}
