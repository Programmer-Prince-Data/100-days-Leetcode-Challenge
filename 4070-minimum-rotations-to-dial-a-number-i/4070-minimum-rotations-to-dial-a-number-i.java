class Solution {
    private int fun(int i, int j, String s){
        if(i >= s.length() || j >= s.length()) return 0;

        int a  = Math.abs(s.charAt(i) - s.charAt(j));
        int rot = Math.min(a, 10  - a);
        

        return rot + fun(i + 1, i, s);
    }
    public int minRotations(String s) {
        int a = Math.abs(s.charAt(0) - '0');
        int rot = Math.min(a, 10 - a);
        return rot + fun(1, 0, s);
    }
}