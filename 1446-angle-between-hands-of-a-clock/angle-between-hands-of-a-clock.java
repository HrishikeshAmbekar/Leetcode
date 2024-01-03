class Solution {
    public double angleClock(int hour, int minutes) {
        if(hour==12){
            hour =0;
        }
        double position1 = (double) hour*5 + (double) minutes/12;
        double position2 = (double) minutes;
        double distance = Math.max(position1,position2) - Math.min(position1,position2);
        // System.out.println(position1+" "+position2+" "+distance);
        distance = Math.min(distance,60-distance);
        double angle = distance * 6;
        return angle;

    }
}