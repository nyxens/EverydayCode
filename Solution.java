class Solution {
    public int[] getNoZeroIntegers(int n){
        int a[] = new int[2];
        for(int i = 1; i<n; i++){
            if(nonzero(i) && nonzero(n-i)){
                a[0]=i;
                a[1]=n-i;
                return a;
            }
        }
        return a;
    }
    public boolean nonzero(int n){
        while(n > 0){
            if(n % 10 == 0)
                return false;
            n /= 10;
        }
        return true;
    }
}