class Solution {
    public int myAtoi(String s) {
        long ans=0;
        boolean found = false;
        int sign =1;
        int i = Integer.MAX_VALUE;
        int j =Integer.MIN_VALUE;
        
        
        for(char c  : s.toCharArray()){
            if(!found){
                if(!(c==' ' || c=='+' || c=='-' || Character.isDigit(c))){
                    return (int) ans;
                }
                if(c=='+'){
                    sign =1;
                    found=true;
                }
                if(c=='-'){
                    sign = -1;
                    found=true;
                }
                if(Character.isDigit(c)){
                    found=true;
                    ans =(long) c -'0';
                }
            }
            else{
                if(Character.isDigit(c)){
                    ans = ans*10;
                    ans+= (long) (c-'0');
                }
                else{
                    
                    break;
                }
                if(ans>(long) i){
                    break;
                }
            }
        }
        ans =  (long) sign*ans;
        if(ans>(long) i){
            return i;
        }
        if(ans<(long) j){
            return j;
        }
        return (int) ans;
    }
}