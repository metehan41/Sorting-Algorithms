import java.util.Arrays;

public class CountSort {


    int getMax(int[] arr, int n) {
        int max = arr[0];
        for (int i = 1; i < n; i++) {
            if (arr[i] > max)
                max = arr[i];
        }
        return max;
    }

    void countSort(int[] arr, int range) {
        // I firstly created array with size one more than range and I get max value via getMax method() and filled it
        // with zeroes
        int[] output = new int[range + 1];
        int max = getMax(arr, range);
        int[] count = new int[max + 1];
        Arrays.fill(count, 0);

        // I stored number of each int in my array
        for (int i = 0; i < range; i++) {
            count[arr[i]]++;
        }

        // now in here count array will contains position of each number in my main array
        for (int i = 0; i < max; i++) {
            count[i+1] += count[i];
        }

        // I here I finally filled sorted array
        // I don't understand why but according to stackoverflow for make stable this operation we did it in reverse order.
        for (int i = range - 1; i >= 0; i--) {
            output[count[arr[i]] - 1] = arr[i];
            count[arr[i]]--;
        }

        // I will copy my sorted array to my main array.
        System.arraycopy(output, 0, arr, 0, range);
    }

    void printArray(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}
