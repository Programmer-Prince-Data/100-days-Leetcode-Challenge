class Solution {
    public boolean canAliceWin(int n) {
        int remove=10;
        int turn=1;
        
        while (n>0){
            if(remove>n && turn==1) return false;
            if(remove>n && turn==0) return true;

            n-=remove;
            remove--;
            turn=1-turn;
        }
        return turn==0;
    }
}