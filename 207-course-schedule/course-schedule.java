class Solution {
    //this ques is same like detect cycle in graph
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>();
        for(int i=0;i<numCourses;i++){
            graph.add(new ArrayList<>());
        }

        int []indegree = new int[numCourses];
        for(int []pre : prerequisites){
            int firstCourse = pre[0];
            int secCourse = pre[1];

            //to complete first course, first we need to complete secondCourse
            // secCourse -> firstCourse
            graph.get(secCourse).add(firstCourse);
            indegree[firstCourse]++;
        }

        Queue<Integer> q = new LinkedList<>();

        //add all ele/courses having indegree 0
        for(int i=0;i<numCourses;i++){
            if(indegree[i]==0){
                q.add(i);
            }
        }

        int cmplted=0;

        while(!q.isEmpty()){
            int curr = q.poll();
            cmplted++;
            //curr course is done now decrease indegree of its neighbour by 1 and add in queue if ther indegree == 0
            for(Integer it : graph.get(curr)){
                indegree[it]--;

                if(indegree[it] == 0){
                    q.add(it);
                }
            }
        }
        return cmplted == numCourses;
    }
}