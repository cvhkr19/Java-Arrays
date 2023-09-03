package Arrays.MaxSumSubArray;

public class DivideAndConquer {
    static int csum(int [] arr,int l,int mid,int r){
        int maxLsum = arr[mid];
        int sum = arr[mid];
        for(int i = mid-1;i >= l;i--){
            sum += arr[i];
            if(sum > maxLsum){
                maxLsum = sum;
            }
        }
        int maxRsum = arr[mid+1];
        sum = arr[mid+1];
        for(int i = mid+2;i <= r;i++){
            sum += arr[i];
            if(sum > maxRsum){
                maxRsum = sum;
            }
        }
        return maxLsum+maxRsum;
    }
    static int divide(int [] arr,int l, int r){
        if(l == r){
            return arr[l];
        }
        int mid = (l+r)/2;
        return Math.max(Math.max(divide(arr,l,mid),divide(arr,mid+1,r)),csum(arr,l,mid,r));
    }
    public static int maxSubArray(int[] nums) {
        return divide(nums,0,nums.length-1);
    }

    public static void main(String[] args) {
        int [] arr = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(maxSubArray(arr));
    }
}
