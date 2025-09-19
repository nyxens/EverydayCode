import java.util.HashMap;
class Solution11 {
    HashMap<String,Integer> cellValues = new HashMap<>();
    public Solution11(int rows){}
    public void setCell(String cell, int value) {
        cellValues.put(cell,value);
    }
    public void resetCell(String cell) {
        cellValues.put(cell,0);
    }
    public int getValue(String formula) {
        formula = formula.substring(1);
        String[] cells = formula.split("\\+");
        String left = cells[0];
        String right = cells[1];
        int result = 0;
        if(left.matches("\\d+")){
            result += Integer.parseInt(left);
        }else{
            result += cellValues.getOrDefault(left,0);
        }
        if(right.matches("\\d+")){
            result += Integer.parseInt(right);
        } else {
            result += cellValues.getOrDefault(right,0);
        }
        return result;
    }
}
