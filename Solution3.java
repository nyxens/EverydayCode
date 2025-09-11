import java.util.*;
class Solution3 {
    public String sortVowels(String s) {
        ArrayList<Character> vowels = new ArrayList<>();
        for(char c : s.toCharArray()){
            if("aeiouAEIOU".indexOf(c) != -1){
                vowels.add(c);
            }
        }
        Collections.sort(vowels,(a, b) ->{
            int i = (int)a;
            int j = (int)b;
            return i - j;
        });
        StringBuilder sb = new StringBuilder(s);
        int index = 0;
        for(int i = 0; i < sb.length(); i++){
            char c = sb.charAt(i);
            if("aeiouAEIOU".indexOf(c) != -1){
                sb.setCharAt(i, vowels.get(index));
                index++;
            }
        }
        s = sb.toString();
        return s;
    }
}