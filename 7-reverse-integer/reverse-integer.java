class Solution {
    public int reverse(int x) {
        int sign = 1;
        if(x<0){
            sign =-1;
            x = x* -1;
        }
        long num =0;
        while(x>0){
            num =num*10+ (int) (x%10);
            x=x/10;
            if(num> (long) Integer.MAX_VALUE){
                return 0;
            }
        }
        return (int) num*sign;
    }
}