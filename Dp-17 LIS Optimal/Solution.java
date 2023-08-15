class Solution {
    public int lengthOfLIS(int[] nums) {
        TreeSet<Integer> ts = new TreeSet<>();
        for(int i = 0;i<nums.length;i++){
            int x = nums[i];

            Integer justBigger = ts.ceiling(x);
            if(justBigger != null){
                ts.remove(justBigger);
            }
            ts.add(x);
        }
        return ts.size();
    }
}