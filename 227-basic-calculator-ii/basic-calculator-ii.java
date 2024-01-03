class Solution {
    public int calculate(String s) {
        int currNum = 0;
        s=s.replaceAll("\\s","");
        Stack<Integer> numStack = new Stack();
        Stack<Character> signStack = new Stack();
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if(c>='0' && c<='9'){
                currNum = currNum*10 + (c-'0');
                if(i==s.length()-1){
                    // System.out.println("entered");
                    // System.out.println(numStack);
                    // System.out.println(signStack);  
                    if(!signStack.isEmpty() && signStack.peek()=='*'){
                        numStack.push(numStack.pop()*currNum);
                        signStack.pop();
                    }
                    else if(!signStack.isEmpty() && signStack.peek()=='/'){
                        numStack.push(numStack.pop()/currNum);
                        signStack.pop();
                    }
                    else{
                        numStack.push(currNum);
                    }
                }
            }
            else if(c=='+' || c=='-' || c=='*' || c=='/'){
                if(!signStack.isEmpty() && signStack.peek()=='*'){
                    numStack.push(numStack.pop()*currNum);
                    signStack.pop();
                }
                else if(!signStack.isEmpty() && signStack.peek()=='/'){
                    numStack.push(numStack.pop()/currNum);
                    signStack.pop();
                }
                else{
                    numStack.push(currNum);
                }
                signStack.push(c);
                currNum=0;
            }
        }
        Stack<Integer> numStack2 = new Stack();
        Stack<Character> signStack2 = new Stack();
        while(!signStack.isEmpty()){
            signStack2.push(signStack.pop());
        }
        while(!numStack.isEmpty()){
            numStack2.push(numStack.pop());
        }
        while(!signStack2.isEmpty()){
            int p1 = numStack2.pop();
            int p2 = numStack2.pop();
            int sign = signStack2.pop();
            if(sign =='+'){
                numStack2.push(p1+p2);
            }
            else{
                numStack2.push(p1-p2);
            }
        }
        // System.out.println(numStack);
        // System.out.println(signStack);

        return numStack2.pop();
    }
}