import java.util.*;
class Solution10 {
    HashMap<Integer,Integer> taskId2priority = new HashMap<>();
    HashMap<Integer,Integer> taskId2userId = new HashMap<>();
    PriorityQueue<int[]> pq ;
    public Solution10(List<List<Integer>> tasks) {
        pq = new PriorityQueue<>((a,b) -> {
            if(a[0] != b[0])
                return b[0] - a[0];
            return b[1] - a[1];
        });
        taskId2priority = new HashMap<>();
        taskId2userId = new HashMap<>();
        for(List<Integer> task : tasks){
            add(task.get(0),task.get(1),task.get(2));
        }
    }
    public void add(int userId, int taskId, int priority) {
        pq.add(new int[]{priority,taskId});
        taskId2priority.put(taskId,priority);
        taskId2userId.put(taskId,userId);
    }
    public void edit(int taskId, int newPriority) {
        pq.add(new int[]{newPriority,taskId});
        taskId2priority.put(taskId,newPriority);
    }
    public void rmv(int taskId) {
        taskId2priority.put(taskId,-1);
    }
    public int execTop() {
        while(!pq.isEmpty()){
            int[] top = pq.poll();
            int priority = top[0];
            int taskId = top[1];
            if(taskId2priority.getOrDefault(taskId,-2) == priority){
                taskId2priority.put(taskId,-1);
                return taskId2userId.getOrDefault(taskId,-1);
            }   
        }
        return -1;
    }
}

/**
 * Your TaskManager object will be instantiated and called as such:
 * TaskManager obj = new TaskManager(tasks);
 * obj.add(userId,taskId,priority);
 * obj.edit(taskId,newPriority);
 * obj.rmv(taskId);
 * int param_4 = obj.execTop();
 */