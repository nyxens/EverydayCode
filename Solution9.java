import java.util.*;
class Solution9 {
    Map<String,String> food2cuisine = new HashMap<>();
    Map<String,Integer> food2rating = new HashMap<>();
    Map<String,TreeSet<String>> cuisine2foods = new HashMap<>();
    public Solution9(String[] foods, String[] cuisines, int[] ratings) {
        for(int i = 0; i < foods.length; i++){
            food2cuisine.put(foods[i],cuisines[i]);
            food2rating.put(foods[i],ratings[i]);
        }
        for(int i = 0; i < foods.length; i++){
            String cuisine = cuisines[i];
            cuisine2foods.putIfAbsent(cuisine,new TreeSet<>((a,b) -> {
                int r1 = food2rating.get(a);
                int r2 = food2rating.get(b);
                if(r1 != r2)
                    return r2 - r1;
                return a.compareTo(b);
            }));
            cuisine2foods.get(cuisine).add(foods[i]);
        }
    }
    public void changeRating(String food, int newRating) {
        String cuisine = food2cuisine.get(food);
        TreeSet<String> set = cuisine2foods.get(cuisine);
        set.remove(food);
        food2rating.put(food,newRating);
        set.add(food);
    }
    public String highestRated(String cuisine) {
        TreeSet<String> set = cuisine2foods.get(cuisine);
        if (set == null || set.isEmpty()) {
            return null;
        }
        return set.first();
    }
}


/**
 * Your FoodRatings object will be instantiated and called as such:
 * FoodRatings obj = new FoodRatings(foods, cuisines, ratings);
 * obj.changeRating(food,newRating);
 * String param_2 = obj.highestRated(cuisine);
 */