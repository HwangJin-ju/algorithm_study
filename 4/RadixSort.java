import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class RadixSort {
    public static int[] arr;
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        arr = new int[num];
        for (int i = 0 ; i <= num ; i ++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        br.close();

    }
    private static void executeRadixSort(int[] arr, int max_size) {
        int[] output = new int[arr.length];
        int jarisu = 1;
        int count = 0;
        while (count != max_size) {
            int[] bucket = new int[10];
            for(int i = 0; i < arr.length; i ++) {
                bucket[(arr[i] / jarisu) % 10]++ ;
            }
            for(int i = 1; i < 10 ; i++) {
                bucket[i] += bucket[i-1];
            }
            for(int i = arr.length -1 ; i >= 0 ; i--) {
                output[bucket[(arr[i] / jarisu % 10)] -1] = arr[i];
                bucket[(arr[i] / jarisu) % 10] --;
            }
            for(int i = 0 ; i < arr.length; i++) {
                arr[i] =output[i];
            }
            jarisu = jarisu * 10 ;
            count ++;
        }
    }

}
