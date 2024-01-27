class MergeSort {

    void merge(int arr[], int left, int middle, int r) {

        // I found size of each array
        int size1 = middle - left + 1;
        int size2 = r - middle;

        int Left[] = new int[size1];
        int Right[] = new int[size2];

        for (int i = 0; i < size1; ++i) {
            Left[i] = arr[left + i];
        }
        for (int j = 0; j < size2; ++j) {
            Right[j] = arr[middle + 1 + j];
        }

        int firstInit = 0, SecondInit = 0;
        int Init = left;

        while (firstInit < size1 && SecondInit < size2) {
            if (Left[firstInit] <= Right[SecondInit]) {
                arr[Init] = Left[firstInit];
                firstInit++;
            } else {
                arr[Init] = Right[SecondInit];
                SecondInit++;
            }
            Init++;
        }

        // Copy for left subarray
        while (firstInit < size1) {
            arr[Init] = Left[firstInit];
            firstInit++;
            Init++;
        }

        // Copy for right subarray
        while (SecondInit < size2) {
            arr[Init] = Right[SecondInit];
            SecondInit++;
            Init++;
        }
    }


    void sort(int arr[], int left, int right) {
        if (left < right) {
            int middle = left + (right - left) / 2;

            // I sorted two half one by one
            sort(arr, left, middle);
            sort(arr, middle + 1, right);

            // And after sorting both half I merged them
            merge(arr, left, middle, right);
        }
    }


    void printArray(int arr[]) {
        for (int i = 0; i < arr.length; ++i) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}