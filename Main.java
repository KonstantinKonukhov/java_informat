public class Main {
    public static void main(String[] args) {
        int a = 0;
        for (int i = 1; i < 10; i++){
            if (i == 1){
                a = 2000;
            }
            if (i == 2){
                a = 5000;
            }
            if (i == 3){
                a = 10000;
            }
            if (i == 4){
                a = 22000;
            }
            if (i == 5){
                a = 53000;
            }
            if (i == 6){
                a = 100000;
            }
            if (i == 7){
                a = 220000;
            }
            if (i == 8){
                a = 330000;
            }
            if (i == 9){
                a = 510000;
            }
            System.out.println("Массив длинной: " + a);
            int[] baseArr = new int[a];
            newArray(baseArr);

            int[] arr1 = baseArr.clone();
            int[] arr2 = baseArr.clone();
            int[] arr3 = baseArr.clone();


            // сортировка слиянием
            double time_merge = System.nanoTime();
            mergeSort(arr1);
            time_merge = System.nanoTime() - time_merge;

            System.out.println("Время выполнение для сортировки слиянием: " +
                    time_merge / 1_000_000 + " миллисекунд");

            // сортировка пузырьком обычная
            double time_bubble = System.nanoTime();
            bubbleSort(arr2);
            time_bubble = System.nanoTime() - time_bubble;

            System.out.println("Время выполнения для сортировки пузырьком: " +
                    time_bubble / 1_000_000 + " миллисекунд");

            // быстрая сортировка со средним элементом
            double time_quick = System.nanoTime();
            quickSort(arr3, 0, arr3.length - 1);
            time_quick = System.nanoTime() - time_quick;


            System.out.println("Время выполнения для быстрой сортировки со средним элементом в качестве опорного: " +
                    time_quick / 1_000_000 + " миллисекунд");


        }
    }


    // создание рандомного массива
    public static void newArray(int[] arr){
        for (int i = 0; i < arr.length; i++){
            arr[i] = (int) (Math.random() * 100000);
        }
    }


    // сортировка слиянием
    public static void mergeSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        mergeSort(arr, 0, arr.length - 1);
    }

    private static void mergeSort(int[] arr, int left, int right) {
        if (left >= right) return;

        int mid = (left + right) / 2;

        mergeSort(arr, left, mid);
        mergeSort(arr, mid + 1, right);

        merge(arr, left, mid, right);
    }

    private static void merge(int[] arr, int left, int mid, int right) {
        int[] temp = new int[right - left + 1];

        int i = left;      // левая часть
        int j = mid + 1;   // правая часть
        int k = 0;

        while (i <= mid && j <= right) {
            temp[k++] = arr[i] <= arr[j] ? arr[i++] : arr[j++];
        }

        while (i <= mid) {
            temp[k++] = arr[i++];
        }
        while (j <= right) {
            temp[k++] = arr[j++];
        }

        for (int p = 0; p < temp.length; p++) {
            arr[left + p] = temp[p];
        }
    }


    // сортировка пузырьком
    public static int[] bubbleSort(int[] arr){
        int n = arr.length;
        for (int i = 0; i < n - 1; i++){
            for (int j = 0; j < n - i - 1; j++){
                if (arr[j] > arr[j + 1]){
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        return arr;
    }

    // быстрая сортировка со средним элементом в качестве опорного
    public static void quickSort(int[] arr, int low, int high){
        if(low < high){
            int pivot = partition(arr, low, high);
            quickSort(arr, low, pivot);
            quickSort(arr, pivot + 1, high);
        }
    }
    public static int partition(int[] arr, int low, int high){
        int pivot = arr[(low + high) / 2];
        int i = low - 1;
        int j = high + 1 ;
        while (true){
            do {
                i++;
            } while (arr[i]< pivot);
            do {
                j--;
            } while (arr[j] > pivot);
            if (i >= j){
                return j;
            }
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
    }

}
