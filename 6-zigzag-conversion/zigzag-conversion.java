class Solution {
    public String convert(String s, int numRows) {
        List<StringBuilder> l =new ArrayList<>();
        for(int i=0;i<numRows;i++){
            l.add(new StringBuilder());
        }
        int i=0;
        while(i<s.length()){
            for(int j=0;j<numRows;j++){
                l.get(j).append(s.charAt(i));
                i++;
                if(i==s.length()){
                    break;
                }
            }
            if(i==s.length()){
                    break;
            }
            for(int j=numRows-2;j>=1;j--){
                l.get(j).append(s.charAt(i));
                i++;
                if(i==s.length()){
                    break;
                }
            }
        }
        StringBuilder sb =new StringBuilder();
        for(StringBuilder li : l){
            sb.append(li);
        }
        return sb.toString();
    }
}