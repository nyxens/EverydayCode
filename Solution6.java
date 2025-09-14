import java.util.*;
class Solution6 {
    public String xvovel(String s){
        StringBuilder sb = new StringBuilder();
        for(char c : s.toCharArray()){
            if("aeiou".indexOf(Character.toLowerCase(c)) >= 0){
                sb.append('#');
            }else{
                sb.append(Character.toLowerCase(c));
            }
        }
        return sb.toString();
    }
    public String[] spellchecker(String[] wordlist, String[] queries) {
        Set<String> exact = new HashSet<>(Arrays.asList(wordlist));
        Map<String,String> casewrong = new HashMap<>();
        Map<String,String> vowelwrong = new HashMap<>();
        for(String word : wordlist){
            String lower = word.toLowerCase();
            String vovel = xvovel(word);
            casewrong.putIfAbsent(lower,word);
            vowelwrong.putIfAbsent(vovel,word);
        }
        String result[] = new String[queries.length];
        for(int i = 0; i<queries.length; i++){
            String q = queries[i];
            if(exact.contains(q))
                result[i] = q;
            else{
                String lower = q.toLowerCase();
                String vovel = xvovel(q);
                if(casewrong.containsKey(lower))
                    result[i] = casewrong.get(lower);
                else if(vowelwrong.containsKey(vovel))
                    result[i] = vowelwrong.get(vovel);
                else
                    result[i] = "";
            }
        }
        return result;
    }
}