import java.util.*;
class Solution5 {
    public int maxFreqSum(String s) {
        HashMap<Character,Integer> map=new HashMap<>();
        int n = s.length();
        for(int i=0;i<n;i++){
            char ch=s.charAt(i);
            map.put(ch,map.getOrDefault(ch,0)+1);
        }
        int maxvovel=0;
        int maxconsonant=0;
        for(char ch:map.keySet()){
            if(ch=='a'|| ch=='e' ||ch=='i' ||ch=='o' ||ch=='u') 
                maxvovel=Math.max(maxvovel,map.get(ch));
            else
                maxconsonant=Math.max(maxconsonant,map.get(ch));
        }
        return maxvovel+maxconsonant;
    }
}