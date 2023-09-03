package Arrays.MaxMin;
import java.util.Arrays;

public class DivideAndConquer {
    public static int []  findMaxMin(int[] arr)
    {
        return dNc(arr,0,arr.length-1);
    }
    static int [] maxMin(int [] arr1, int [] arr2){
        int [] max_min = new int[2];
        max_min[0] = Math.max(arr1[0],arr2[0]);
        max_min[1] = Math.min(arr1[1],arr2[1]);
        return max_min;
    }
    static int[] dNc(int [] A,int l, int h){
        if(l == h){
            return new int[]{A[l],A[l]};
        }
        int mid = (l+h)/2;
        return maxMin(dNc(A,l,mid),dNc(A,mid+1,h));
    }

    public static void main(String[] args) {
        int [] arr = {-2,1,-4,5,3};
        System.out.println(Arrays.toString(findMaxMin(arr)));
    }
}
