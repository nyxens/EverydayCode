class Solution4 {
    public boolean doesAliceWin(String s) {
        for(int i=0;i<s.length();i++){
            int ch=s.charAt(i);
            if(ch=='a' || ch=='e' ||ch=='i' ||ch=='o' ||ch=='u') 
                return true;
        } 
        return false;
    }
}