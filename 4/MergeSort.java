import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * MergeSort
 */
public class MergeSort {
    public static int[] arr, temp;
    public static void main(String[] args) throws IOException {
        //수 정렬하기2
        
        //num(정렬할 수 개수)
        //arr(정렬할 배열 선언하기) : 문제에서 주어진 원 배열
        //temp(정렬할 때 사용할 임시 배열 선언하기)
        //arr배열에 입력값 저장하기 (for문, loop 수 : 정렬할 요소의 개수 N)
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int num = Integer.parseInt(br.readLine());
        arr = new int[num+1];
        temp = new int[num+1];
        for (int i = 0 ; i <= num; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        
        //병합 정렬 수행
        executeMergeSort(1, num);

        //결괏값 출력
        for (int i = 0 ; i <= num; i++) {
            bw.write(arr[i] + "\n");
        }
        bw.flush();
        bw.close();
    }

    private static void executeMergeSort(int s, int e) {
        if (e - s < 1) {
            return;
        }
        int m = s + (e - s) / 2; //중간값 찾기 위함
        
        executeMergeSort(s, m);
        executeMergeSort(m+1, e);
        for (int i = s; i <= e; i ++) {
            temp[i] = arr[i];
        }

        int k = s;
        int index1 = s;
        int index2 = m +1 ;
        while (index1 <= m && index2 <= e) {
            if (temp[index1] > temp[index2]) {
                arr[k] = temp[index2];
                k++;
                index2++;
            } else {
                arr[k] = temp[index1];
                k++;
                index1++;
            }
        }
        while (index1 <= m) {
            arr[k] = temp[index1];
            k++;
            index1 ++;
        }
        while (index2 <= e) {
            arr[k] = temp[index2];
            k++;
            index2 ++;
        }
 
    }
}





