import java.util.Scanner;

public class Sample {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt(); //an size of array of integers to rotate
        int K = in.nextInt(); //an integer, the rotation count
        int Q = in.nextInt(); //an array of integers, the indices to report
        int rot = K % N;
        int[] arr = new int[N];
        for (int i = 0; i < N; i++)
            arr[i] = in.nextInt();
        for (int i = 0; i < Q; i++) {
            int idx = in.nextInt();
            if (idx - rot >= 0)
                System.out.println(arr[idx - rot]);
            else
                System.out.println(arr[idx - rot + arr.length]);
        }
    }




    // Complete the circularArrayRotation function below.
    static int[] circularArrayRotation(int[] a, int k, int[] queries) {
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
}

