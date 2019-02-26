package binary_search;

class Merge {
    /*
    Runtime: 24 ms, faster than 99.79% of Java online submissions for Median of Two Sorted Arrays.
    Memory Usage: 48.3 MB, less than 87.78% of Java online submissions for Median of Two Sorted Arrays.
     */
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int i, j, k, total;
        i = j = k = 0;
        int[] nums3;

        if (nums1 == null || nums1.length == 0) {
            total = nums2.length;
            nums3 = nums2;
        } else if (nums2 == null || nums2.length == 0) {
            total = nums1.length;
            nums3 = nums1;
        } else {
            total = nums1.length + nums2.length;
            nums3 = new int[total];

            while (k < total) {
                if (i < nums1.length && j < nums2.length) {
                    nums3[k++] = nums1[i] > nums2[j] ? nums2[j++] : nums1[i++];
                } else if (i < nums1.length) {
                    nums3[k++] = nums1[i++];
                } else nums3[k++] = nums2[j++];
            }
        }

        double median = 0.0;
        int mid = total / 2;
        if (total % 2 == 0) {
            median = (nums3[mid-1] + nums3[mid]) / 2.0;
        } else {
            median = nums3[mid];
        }
        return median;
    }
}

public class MedianSortedArrays {
    public static void main(String[] args) {
        int a[] = {1,2,3,7,8};
        int b[] = {4,5,6};

        Merge merge = new Merge();
        double median = merge.findMedianSortedArrays(a, b);

        System.out.println(median);
    }
}
