import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class PrintallSubarrays
{
    // Utility function to insert <key, value> pair into the Multimap
    private static<K,V> void insert(Map<K, List<V>> hashMap, K key, V value)
    {
        // if the key is seen for the first time, initialize the list
        if (!hashMap.containsKey(key)) {
            hashMap.put(key, new ArrayList<>());
        }

        hashMap.get(key).add(value);
    }

    // Utility function to print a subarray A[i, j]
    public static void printSubarray(int[] A, int i, int j)
    {
        System.out.print("[" + i + ".." + j + "] -- { ");
        for (int k = i; k <= j; k++) {
            System.out.print(A[k] + " ");
        }

        System.out.println("}");
    }

    // Function to find subarrays with given sum in an array
    public static void printallSubarrays(int[] A, int sum)
    {
        // create a map for storing end index of all subarrays with
        // sum of elements so far
        Map<Integer, List<Integer>> hashMap = new HashMap<>();

        // To handle the case when the subarray with given sum starts
        // from 0th index
        insert(hashMap, 0, -1);

        int sum_so_far = 0;

        // traverse the given array
        for (int index = 0; index < A.length; index++)
        {
            // sum of elements so far
            sum_so_far += A[index];

            // check if there exists at-least one sub-array with given sum
            if (hashMap.containsKey(sum_so_far - sum))
            {
                List<Integer> list = hashMap.get(sum_so_far - sum);
                for (Integer value: list) {
                    printSubarray(A, value + 1, index);
                }
            }

            // insert (sum so far, current index) pair into the map
            insert(hashMap, sum_so_far, index);
        }
    }


    static long countTriplets(List<Long> arr, long zzzz){
        Map<Long,Long> v2 = new HashMap<>();
        Map<Long,Long> v3 = new HashMap<>();
        Long count = 0L;
        for (Long k:arr) {
            count+=v3.get(k)==null?0:v3.get(k);
            if (v2.get(k)!=null) v3.compute(k*zzzz,(key,value)->value!=null?value+v2.get(k):v2.get(k));
            v2.compute(k*zzzz,(key,value)->value==null?1:value+1);
        }
        return count;
    }



    static void find3Numbers(int arr[])
    {
        int n = arr.length;
        int max = n-1;
        int min = 0;
        int i;


        int[] smaller = new int[n];
        smaller[0] = -1;
        for (i = 1; i < n; i++)
        {
            if (arr[i] <= arr[min])
            {
                min = i;
                smaller[i] = -1;
            }
            else
                smaller[i] = min;
        }

        int[] greater = new int[n];
        greater[n-1] = -1;
        for (i = n-2; i >= 0; i--)
        {
            if (arr[i] >= arr[max])
            {
                max = i;
                greater[i] = -1;
            }
            else
                greater[i] = max;
        }

        for (i = 0; i < n; i++)
        {
            if (smaller[i] != -1 && greater[i] != -1)
            {
                System.out.print(arr[smaller[i]]+" "+
                        arr[i]+" "+ arr[greater[i]]);
                return;
            }
        }

        System.out.println("No such triplet found");
        return;
    }


    // main function
    public static void main (String[] args)
    {
        //int[] A = { 3, 4, -7, 1, 3, 3, 1, -4 };
        int[] A = { 2,4,1,5,6};
        int sum = 6;

        printallSubarrays(A, sum);
    }
}