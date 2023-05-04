class Solution {
    public String predictPartyVictory(String senate) {
        int N = senate.length();
        int RCount = 0;
        int DCount = 0;
        for(int i=0; i<N; i++) {
            if(senate.charAt(i)=='R') {
                RCount++;
            } else {
                DCount++;
            }
        }
        boolean banned[] = new boolean[N];
        int turn = 0;
        while(RCount > 0 && DCount>0) {
            if(!banned[turn]) {
                char temp = senate.charAt(turn);
                bannedExecution(banned, (turn+1)%N, temp, senate);
                if(temp=='R') {
                    DCount--;
                } else {
                    RCount--;
                }
            }
            turn = (turn+1)%N;
        }
        return DCount==0 ? "Radiant" : "Dire";
    }
    
    void bannedExecution(boolean banned[], int turn, char curr, String senate) {
        int N = senate.length();
        while(true) {
            if(!banned[turn] && curr != senate.charAt(turn)) {
                banned[turn] = true;
                break;
            }
            turn = (turn+1)%N;
        }
    }
}