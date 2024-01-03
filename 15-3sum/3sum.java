class Solution {

    public List<List<Integer>> threeSum(int[] nums) {
        
        Arrays.sort(nums);
        HashSet<List<Integer>> hs = new HashSet();
        for(int i=0;i<nums.length;i++){
            List<List<Integer>> l = twoSum(nums,i,-1*nums[i]);
            for(List<Integer> li : l){
                hs.add(li);
            }
        }
        List<List<Integer>> ans =new ArrayList(hs);
        return ans;
    }
    public List<List<Integer>> twoSum(int[] nums,int i, int t){
        List<List<Integer>> ans = new ArrayList();
        int s = i==0 ? 1 : 0;
        int e = i==nums.length-1 ? nums.length-2 : nums.length-1;
        while(s<e){
            if(nums[s]+nums[e]==t){
                List<Integer> l = new ArrayList();
                l.add(nums[s]);
                l.add(nums[e]);
                l.add(nums[i]);
                Collections.sort(l);
                ans.add(l);
                s++;
                e--;
                if(e==i){
                    e--;
                }
                if(s==i){
                    s++;
                }
            }
            else if(nums[s]+nums[e]>t){
                e--;
                if(e==i){
                    e--;
                }
            }
            else{
                s++;
                if(s==i){
                    s++;
                }
            }
        }
        return ans;
         
    }
}