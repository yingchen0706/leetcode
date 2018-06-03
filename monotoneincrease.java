class Solution {
    public int monotoneIncreasingDigits(int N) {
        char[] strN = (String.valueOf(N)).toCharArray();
        int cliffIndex = -1;
        if ((cliffIndex = findCliff(strN)) == -1) {
            return N;
        }
        
        for (int i = cliffIndex+1; i < strN.length; i++) {
            strN[i] ='9';
        }
        strN[cliffIndex]=(char)(strN[cliffIndex] - 1);
        while((cliffIndex=findCliff(strN)) != -1) {
            strN[cliffIndex-1] = (char)(strN[cliffIndex-1] - 1);
            strN[cliffIndex]='9';
        }
        return Integer.parseInt(String.valueOf(strN));
    }
    
    private int findCliff(char[] strN) {
        int prev = '0';
        for (int i=0; i<strN.length;i++) {
            int num = strN[i];
            if (num >= prev) {
                prev = num;
            } else {
                return i;
            }
        }
        return -1;
    }
}
