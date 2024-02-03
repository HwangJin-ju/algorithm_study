import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class MergeSort2 {
    public static int[] arr, temp;
    public static long result;
    public static void main(String[] args) throws NumberFormatException, IOException {
        //버블 소트 프로그램2

        //정렬할 수의 개수 num
        //정렬할 배열 arr
        //정렬할 때 임시로 사용할 배열 temp

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int num = Integer.parseInt(br.readLine());
        arr = new int[num+1];
        temp = new int[num+1];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 1 ; i <=num ; i++) {
            arr[i] =Integer.parseInt(st.nextToken());
        }

        result = 0;
        //병합 정렬 함수 수행하기
        executeMergeSort(1, num);
        //결괏값 출력하기
        System.out.println(result);
    }

    private static void executeMergeSort(int s, int e) {
        if (e-s < 1) {
            return;
        }
        int m = s + (e - s) /2;

        executeMergeSort(s, m);
        executeMergeSort(m+1, e);
        for (int i = s; i <= e; i++) {
            temp[i] = arr[i];
        }
        int k = s;
        int index1 = s;
        int index2 = m + 1;
        while (index1 <=m && index2 <= e) {
            if (temp[index1] > temp[index2]) {
                arr[k] = temp[index2];
                result = result + index2 - k; // 몇 개를 제쳤는지
                k++;
                index2 ++;
            } else {
                arr[k] = temp[index1];
                k++;
                index1 ++;
            }
        }

        while (index1 <=m) {
            arr[k] = temp[index1];
            k++;
            index1;
        }
        while (index2 <=e ) {
            arr[k] = temp[index2];
            k++;
            index2 ++;
        }
    }
}
