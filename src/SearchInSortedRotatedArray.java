public class SearchInSortedRotatedArray {
    private int[] array;
    private int pivot;
    public SearchInSortedRotatedArray(int[] array) {
        this.array = array;
        int length = array.length;
        int left = 0;
        int right = length - 1;
        int mid = (left + right) / 2;
        while(left < right) {
            int midElement = array[mid];
            int leftElement = array[left];
            int rightElement = array[right];
            if(midElement < rightElement && midElement < leftElement) {
                right = mid - 1;
            } else if(midElement > rightElement && midElement > leftElement) {
                left = mid + 1;
            } else {
                mid = midElement < rightElement ? mid : right;
                break;
            }
            mid = (left + right) / 2;
        }
        System.out.println(mid);
    }
    public int search(int[] array, int query) {
        return 0;

    }
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6};
        SearchInSortedRotatedArray s = new SearchInSortedRotatedArray(array);
    }
}
