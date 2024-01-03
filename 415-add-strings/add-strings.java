class Solution {
    public String addStrings(String num1, String num2) {
        if(num2.length()<num1.length()){
            String temp = num2;
            num2 = num1;
            num1 = temp;
        }

        int l1 =num1.length();
        int l2 = num2.length();
        int carry =0;
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<l1;i++){
            int x = num1.charAt(l1-1-i) - '0';
            int y = num2.charAt(l2-1-i) - '0';
            int t = x+y+carry;
            // System.out.println(x+" "+)
            carry = t/10;
            t = t%10;
            char c =(char) ('0'+t);
            sb.insert(0,c);
        }
        for(int i=l1;i<l2;i++){
            int y = num2.charAt(l2-1-i) -'0';
            int t = y + carry;
            carry = t/10;
            t = t%10;
            char c =(char) ('0'+t);
            sb.insert(0,c);
        }
        if(carry!=0){
            char c =(char) ('0'+carry);
            sb.insert(0,c);
        }

        return sb.toString();
    }
}