class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        Arrays.sort(envelopes,(a,b)->{
            if(a[0] == b[0]) return b[1] - a[1];//sorting equal width env in desc
            return a[0] - b[0];//sorting env in asc 
        });

        TreeSet<Integer> ts = new  TreeSet<>();
        for(int i = 0;i<envelopes.length;i++){
            int h = envelopes[i][1];

            Integer ceil = ts.ceiling(h);
            if(ceil != null) ts.remove(ceil);
            ts.add(h);
        }
        return ts.size();
    }
}