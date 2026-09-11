class Solution {
    public int totalNumbers(int[] digits) {
        int n = digits.length;
        HashSet<Integer> set = new HashSet<>();

        for(int i=0;i<n;i++){
            if(digits[i] == 0) continue; //skip ,first digit can't be zero
            for(int j=0;j<n;j++){
                if(i == j) continue;
                for(int k =0;k<n;k++){
                    if(i==k || j==k) continue;
                    if(digits[k] % 2 != 0){
                        //last digit must be even 
                        continue;
                    }
                    int num = digits[i]*100 + digits[j]*10 + digits[k];
                    set.add(num);
                }
            }
        }
        return set.size();
    }
}