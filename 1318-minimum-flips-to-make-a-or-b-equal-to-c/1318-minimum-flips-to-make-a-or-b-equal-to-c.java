class Solution {
    public int minFlips(int a, int b, int c) { 
        int res= 0;
        for(int i=31; i>-1; i--) {
            int bitC = (c>>i)&1;
            int bitA = (a>>i)&1;
            int bitB = (b>>i)&1;
        	if(bitC==0) {
                /*
        		if(bitA==1 && bitB==1) {
                    res +=2;
                } else if((bitA^bitB)==1) {
                    res++;
                }*/
                
                res += (bitA & 1) + (bitB & 1);
        	} else {
                if(bitA==0 && bitB==0) {
                    res +=1;
                } 
            }
        }
        return res;
    }
}