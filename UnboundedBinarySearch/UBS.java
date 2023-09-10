package Arrays.UnboundedBinarySearch;

public class UBS {
    static int f(int x){
        int posZero = 67582363; // point where the function returns zero
        if(x > posZero){  // positive after
            return (int)Math.exp(x);  // can be changed as long as it returns a +ve integer.
        }
        else if(x == posZero){
            return 0;
        }
        else if(x > 0){  // negative before
            return -(int)Math.exp(x); // can be changed as long as it returns a -ve integer.
        }
        else {
            System.out.println("Error : Function only accepts non-negative integers...");
            return Integer.MIN_VALUE;
        }
    }
    static int [] range(){ // scaling factor 10
        int [] r = new int[2];
        if(f(1) >= 0){
            return new int [] {1,2};
        }
        for(int i = 1; i >0;i*=10){
            if(f(i) >= 0){
                r[0] = i/10;
                r[1] = i;
                break;
            }
        }
        return r;
    }
    static int ubs(int l, int h){
        int mid = (l+h)/2;
        if(f(1) > 0){
            return 1;
        }
        if(f(l) == 0){
            return l+1;
        }
        else if(f(h) == 0){
            return h+1;
        }
        else if(f(mid) == 0){
            return mid+1;
        }
        else if(f(mid) < 0){
            return ubs(mid+1,h-1);  // This holds only when such a number exists.
        }                                // For arrays it will be a bit more complicated.
        else{                            // As the number might not exist in that case.
            return ubs(l+1,mid-1);
        }
    }
    public static void main(String[] args) {
        System.out.println(ubs(range()[0],range()[1]));
    }
}
