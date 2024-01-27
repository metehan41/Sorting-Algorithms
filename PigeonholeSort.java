import java.util.Arrays;

public class PigeonholeSort {

    public static int[] getMaxMin(int[] arr) {
        int min = arr[0];
        int max = arr[0];

        int[] minMax = new int[2];

        for(int i = 0; i <arr.length; i++) {

            if(arr[i] <= min) {
                min = arr[i];
                minMax[0] = min;
            }

            if(arr[i] >= max) {
                max = arr[i];
                minMax[1] = max;
            }
        }
        return minMax;
    }

    public void pigeonhole_sort(int arr[], int n) {
        int min = getMaxMin(arr)[0];
        int max = getMaxMin(arr)[1];

        int range = max - min + 1;
        int[] pih = new int[range];
        Arrays.fill(pih, 0);

        for(int i = 0; i < n; i++) {
            pih[arr[i] - min]++;
        }


        int index = 0;

        for(int j = 0; j < range; j++) {
            while (pih[j]-- > 0) {
                arr[index++] = j + min;
            }
        }

    }

    void printArray(int arr[]) {
        for (int i = 0; i < arr.length; ++i) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}
