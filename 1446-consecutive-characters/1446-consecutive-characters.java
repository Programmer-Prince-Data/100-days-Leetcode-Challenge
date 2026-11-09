class Solution {
    public int maxPower(String s) {

        int power=0;
        int count=0;

        for(int i=0;i<s.length()-1;i++){

            if(s.charAt(i)==s.charAt(i+1)){
                count++;
                power=Math.max(power,count);
            }else{
                count=0;
            }
        }
        return power+1;
    }
}