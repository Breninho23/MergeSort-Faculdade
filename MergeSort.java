public class MergeSort {

    public static void merge(int[] array, int left, int middle, int right) {
        int n1 = middle - left + 1;
        int n2 = right - middle;

        int[] leftArray = new int[n1];
        int[] rightArray = new int[n2];

        for (int i = 0; i < n1; i++) {
            leftArray[i] = array[left + i];
        }

        for (int j = 0; j < n2; j++) {
            rightArray[j] = array[middle + 1 + j];
        }

        int i = 0, j = 0;
        int k = left;

        while (i < n1 && j < n2) {
            if (leftArray[i] <= rightArray[j]) {
                array[k] = leftArray[i];
                i++;
            } else {
                array[k] = rightArray[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            array[k] = leftArray[i];
            i++;
            k++;
        }

        while (j < n2) {
            array[k] = rightArray[j];
            j++;
            k++;
        }
    }

    public static void mergeSort(int[] array, int left, int right) {
        if (left < right) {
            int middle = left + (right - left) / 2;

            mergeSort(array, left, middle);
            mergeSort(array, middle + 1, right);

            merge(array, left, middle, right);
        }
    }

    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("Uso: java MergeSort <elemento1> <elemento2> ...");
            return;
        }

        int[] array = new int[args.length];

        for (int i = 0; i < args.length; i++) {
            if (isInteger(args[i])) {
                array[i] = Integer.parseInt(args[i]);
            } else {
                System.out.println("Erro: \"" + args[i] + "\" não é um número inteiro válido.");
                return;
            }
        }

        System.out.println("Array antes do merge sort:");
        for (int num : array) {
            System.out.print(num + " ");
        }

        mergeSort(array, 0, array.length - 1);

        System.out.println("\nArray depois do merge sort:");
        for (int num : array) {
            System.out.print(num + " ");
        }
    }

    public static boolean isInteger(String s) {
        try {
            Integer.parseInt(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
