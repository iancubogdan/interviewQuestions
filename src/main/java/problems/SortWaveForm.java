package problems;

/**
 * Created by iancu on 5/13/2018.
 */
public class SortWaveForm  {

    void swap(int arr[], int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    void sortWave(int arr[]) {
        for (int i = 0; i < arr.length; i+=2) {
            if (i > 0 && arr[i-1] > arr[i]) {
                swap(arr, i-1, i);
            }
            if (i<arr.length-1 && arr[i] < arr[i+1]) {
                swap(arr, i, i+1);
            }
        }
    }


    public static void main(String args[])
    {
        SortWaveForm ob = new SortWaveForm();
//        int arr[] = {10, 90, 49, 2, 1, 5, 23};
        int arr[] = {7, 10, 12, 2, 1, 5, 23};

        ob.sortWave(arr);
        for (int i : arr)
            System.out.print(i+" ");
    }
}
