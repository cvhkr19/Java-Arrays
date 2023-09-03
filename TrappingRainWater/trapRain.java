package Arrays.TrappingRainWater;
//Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water
// it can trap after raining.
public class trapRain {
    public static int trap(int[] arr) {
        int pickNum = arr[0];
        int pickNumPos = 0;
        int rain = 0;
        int temprain = 0;
        int max = 0;
        for(int i = 1;i < arr.length;i++){
            if(pickNum - arr[i] > 0){
                temprain += pickNum - arr[i];
                if(arr[i] > max){
                    max = arr[i];
                }
            }
            else{
                rain += temprain;
                temprain = 0;
                pickNum = arr[i];
                pickNumPos = i;
            }
            if(i == arr.length-1 && temprain != 0){
                arr[pickNumPos] = max;
                pickNum = max;
                i = pickNumPos;
                temprain = 0;
                max = 0;
            }
        }
        return rain;
    }

    public static void main(String[] args) {
        int [] arr = {0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(trap(arr));
    }
}
