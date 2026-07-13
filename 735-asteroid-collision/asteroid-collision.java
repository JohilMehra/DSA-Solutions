class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        int n = asteroids.length;
        List<Integer> st = new ArrayList<>(); //we are using list as stack

        for(int i=0; i<n; i++){
            if(asteroids[i] > 0){ //positive
                st.add(asteroids[i]);
            }else{ //negative
                //if top ele is pos and less than curr ele
                while(!st.isEmpty() && st.get(st.size()-1) > 0 && st.get(st.size()-1) < Math.abs(asteroids[i])){
                    st.remove(st.size()-1);
                }
                //if both are equal -> destroy both
                if(!st.isEmpty() && st.get(st.size()-1) == Math.abs(asteroids[i])){
                    st.remove(st.size()-1);
                }else if(st.isEmpty() || st.get(st.size()-1) < 0){
                    //means both are neg and going to same dire -> no collision or if st is empty
                    st.add(asteroids[i]);
                }
            }
        }

        int []res = new int[st.size()];
        int i=0;
        for(Integer num : st){
            res[i++]=num;
        }

        return res;
    }
}