package Arrays.TrappingRainWater;

public class TrapRainO2n {
    public int trap(int[] arr) {
        int ctbp = 0; // currTallestBlockPos
        int ctb = arr[ctbp]; // height  of currTallestBlock
        int finSum = 0; // final sum
        int currSum = 0;
        for(int i = 0;i < arr.length;i++){
            if(ctb <= arr[i]){
                finSum += currSum;
                ctb = arr[i];
                ctbp = i;
                currSum = 0;
            }
            else{
                currSum += ctb - arr[i];
            }
        }
        currSum = 0;
        ctb = arr[arr.length-1];
        int temp = ctbp;
        ctbp = arr.length-1;
        for(int i = arr.length-1;i >= temp;i--){
            if(ctb <= arr[i]){
                finSum += currSum;
                ctb = arr[i];
                ctbp = i;
                currSum = 0;
            }
            else{
                currSum += ctb - arr[i];
            }
        }
        return finSum;
    }
}
