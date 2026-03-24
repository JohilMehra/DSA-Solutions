class Solution {
    public double myPow(double x, int n) {
        if(n<0){
            x=1/x;  // invert x if power is negative
            n=-n;  // make the exponent positive
        }
        return fastPow(x,n);
    }

    public static double fastPow(double x,long n){
        //base case
        if(n==0) return 1.0;

        //recursive loop
        double half=fastPow(x,n/2);
        
        if(n%2==0){
            return half*half; //even
        }else{
            return half*half*x;  //odd
        }
    }
}