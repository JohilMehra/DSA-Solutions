class Solution {
    int mod= 1000000007;
    public int numPrimeArrangements(int n) {
        int primeCount=countPrime(n);
        int nonPrime=n-primeCount;
        long res=(factorial(primeCount)*factorial(nonPrime))%mod;
        return (int)res;
    }
    private int countPrime(int n){
        boolean[] isPrime=new boolean[n+1];
        Arrays.fill(isPrime,true);
        isPrime[0]=false;
        if(n>=1) isPrime[1]=false;
        for(int i=2;i*i<=n;i++){
            if(isPrime[i]){
                for(int j=i*i;j<=n;j+=i){
                    isPrime[j]=false;
                }
            }
        }
        int count=0;
        for(int i=2;i<=n;i++){
            if(isPrime[i]){
                count++;
            }
        }
        return count;
    }
    private long factorial(int n){
        long res=1;
        for(int i=1;i<=n;i++){
            res=(res*i)%mod;
        }
        return res;
    }
}