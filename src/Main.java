public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
    }

    //Recursive Binary Search
    public static int BinarySearch(int[] arr, int first, int last, int target) {

        if (last>=first){
            int mid = first+(last - first)/2;
            if (arr[mid] == target){
                return mid;
            }
            if (arr[mid] > target) {
                return BinarySearch(arr, first, mid - 1, target);
            }else{
                return BinarySearch(arr,mid+1,last,target);
            }
        }
        return -1;
    }

    //Iterative Binary Search
    public static int IterativeBinarySearch(int[] arr, int first, int last, int target){
        int mid = (first+last)/2;
        while(first <= last) {
            if (arr[mid] < target) {
                first = mid + 1;
            } else if (arr[mid] == target) {
                System.out.println(" The target number is "+ mid);
                break;
            } else {
                last = mid - 1;
            }
            mid = (first + last) / 2;
        }
        if (first > last) {
            System.out.println("Target number is out of bounds");
        }

        return mid;
    }
    static void quickSort(int[] arr, int left, int right){
        //quicksort function
        // pivot is set after it calls the partition function
        if (left < right){
            int pivot = partition(arr,left,right);
            //sort elements before and after the pivot
            quickSort(arr, left, pivot-1);
            quickSort(arr, pivot+1, right);
        }
    }
    static void swap(int[] arr, int i, int j){
        // function to swap elements from the partition function
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    static int partition(int[] arr, int left, int right ) {

        int pivot = arr[right];
        //pivot is set as last bound of the array
        int i = (left - 1);
        // for loop which iterates through the array and begins the swap process
        for (int j = left; j <= right - 1; j++) {
            if (arr[j] < pivot) {
                //increment until smaller index is equal to pivot
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i + 1, right);
        return (i + 1);
    }
    static int duplicates(int array[], int length){
        // function which handles duplicates
        // edge cases are tested first, if the length of the array is 0 or 1
        // it will return the element of the array
        if(length == 0 || length == 1)
            return length;
        int index = 0;

        //iterates through the array to check whether current index is equal to next index
        for(int i = 0; i < length-1; i++){
            if(array[i] != array[i+1]){
                array[index++] = array[i];
            }
        }
        array[index++] = array[length-1];
        return index;
    }
    static public void DoMerge(int [] numbers, int left, int mid, int right)

    {
        int [] temp = new int[25];
        int i, left_end, num_elements, tmp_pos;

        left_end = (mid - 1);
        tmp_pos = left;
        num_elements = (right - left + 1);

        while ((left <= left_end) && (mid <= right))
        {
            if (numbers[left] <= numbers[mid])
                temp[tmp_pos++] = numbers[left++];
            else
                temp[tmp_pos++] = numbers[mid++];
        }
        while (left <= left_end)
            temp[tmp_pos++] = numbers[left++];
        while (mid <= right)
            temp[tmp_pos++] = numbers[mid++];
        for (i = 0; i < num_elements; i++)
        {
            numbers[right] = temp[right];
            right--;
        }
    }
    static public void MergeSort_Recursive(int [] numbers, int left, int right)
    {
        int mid;
        if (right > left)
        {
            mid = (right + left) / 2;
            MergeSort_Recursive(numbers, left, mid);
            MergeSort_Recursive(numbers, (mid + 1), right);
            DoMerge(numbers, left, (mid+1), right);
        }
    }
}
