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

class BinarySearch {
     public double findMedianSortedArrays(int[] nums1, int[] nums2) {
    int m, n;
    m = nums1.length;
        n = nums2.length;
        
        if (m > n) {
            int[] temp = nums1;
            nums1 = nums2;
            nums2 = temp;
            
            int tmp = m;
            m = n;
            n = tmp;
        }
        
        int imin = 0, imax = m, halfLen = (m + n + 1) / 2;
        int i, j;
        while(imin <= imax) {
            i = (imin + imax) / 2;
            j = halfLen - i;
            
            if (i < imax && nums1[i] < nums2[j-1]) imin = i + 1;
            else if (i > imin && nums1[i-1] > nums2[j]) imax = i - 1;
            else {
                int max_of_left;
                if (i == 0) max_of_left = nums2[j-1];
                else if (j == 0) max_of_left = nums1[i-1];
                else max_of_left = Math.max(nums1[i-1], nums2[j-1]);
                
                if ((m + n) % 2 == 1) return max_of_left;
                
                int min_of_right;
                if (i == m) min_of_right = nums2[j];
                else if (j == n) min_of_right = nums1[i];
                else min_of_right = Math.min(nums1[i], nums2[j]);
                return (max_of_left + min_of_right) / 2.0;
            }
        }
return 0.0;
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
