class Solution {
    public List<String> maxNumOfSubstrings(String s) {
        int n = s.length();
        int []first = new int[26]; //stores first occurance in string
        Arrays.fill(first,-1);
        int []last = new int[26]; //stores last occurance in string

        //fill first occu array
        for(int i=n-1;i>=0;i--){
            int ch = s.charAt(i);
            first[ch-'a']=i;
        }
        //fill last occu array
        for(int i=0;i<n;i++){
            last[s.charAt(i)-'a']=i;
        }

        List<int[]> intervals = new ArrayList<>();

        //stores all the valid string incices for every char in the list
        for(int ch=0;ch<26;ch++){
            if(first[ch] == -1)
                continue; //char is not in the string
            
            int start = first[ch];
            int end = last[ch];

            boolean valid = true;

            for(int j=start;j<=end;j++){
                int curr = s.charAt(j)-'a';

                if(first[curr] < start){
                    valid = false;
                    break;
                }
                //if the curr char last occurance is oustide the end then expand the end value
                if(last[curr] > end){
                    //expand
                    end = last[curr];
                }
            }

            if(valid) intervals.add(new int[]{start,end});
        }

        //sort the intervals based on last occurance
        intervals.sort((a,b) -> a[1]-b[1]);

        List<String> res = new ArrayList<>();
        int prevEnd = -1;

        for(int []interval : intervals){
            int start = interval[0];
            int end = interval[1];

            if(start > prevEnd){
                res.add(s.substring(start,end+1));
                prevEnd = end;
            }
        }

        return res;
    }
}