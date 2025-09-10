import java.util.*;
class Solution2 {
    public int minTeach(int totallang, int[][] user_lang, int[][] friends_pair) {
        Set<Integer> usersToTeach = new HashSet<>();
        for(int[] friendship : friends_pair){
            int u1 = friendship[0] - 1;
            int u2 = friendship[1] - 1;
            boolean samelang = false;
            for(int lang1 : user_lang[u1]){
                for(int lang2 : user_lang[u2]){
                    if(lang1 == lang2){
                        samelang = true;
                        break;
                    }
                }
                if(samelang) 
                    break;
            }
            if(!samelang){
                usersToTeach.add(u1);
                usersToTeach.add(u2);
            }
        }
        int minUsersToTeach = user_lang.length + 1;
        for(int lang = 1; lang <= totallang; lang++){
            int count = 0;
            for(int user : usersToTeach){
                boolean knows = false;
                for(int l : user_lang[user]){
                    if(l == lang){
                        knows = true;
                        break;
                    }
                }
                if(!knows) 
                    count++;
            }
            minUsersToTeach = Math.min(minUsersToTeach, count);
        }
        return minUsersToTeach;
    }
}