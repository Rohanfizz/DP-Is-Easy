

//User function Template for Java

class Solution
{
    public static class Box{
        int h;
        int w;
        int l;
        Box(int h,int w,int l){
            this.h = h;
            this.w  = w;
            this.l  = l;
        }
    }
    public static int maxHeight(int[] height, int[] width, int[] length, int n)
    {
        // Code here
        
        ArrayList<Box> arr = new  ArrayList<>();
        for(int i = 0;i<n;i++){
            int h = height[i];
            int w = width[i];
            int l = length[i];
            
            arr.add(new Box( h , Math.min(w,l) , Math.max(w,l) ));
            arr.add(new Box( l , Math.min(w,h) , Math.max(w,h) ));
            arr.add(new Box( w , Math.min(h,l) , Math.max(h,l) ));
        }
        
        //Step2 sorting the boxes in terms of their base area
        Collections.sort(arr, (a,b)->{
            return (a.l * a.w) - (b.l * b.w);
        } );
        
        //Step 3 lis
        int N = 3*n;
        
        int[] dp = new int[N];
        
        for(int i = 0;i<N;i++){
            int bestOfPrev = 0;
            int myLen = arr.get(i).l;
            int myWid = arr.get(i).w;
            
            for(int j = i-1;j>=0;j--){
                int prevLen = arr.get(j).l;
                int prevWid = arr.get(j).w;
                if(prevLen < myLen && prevWid < myWid){
                    bestOfPrev  = Math.max(bestOfPrev , dp[j]);
                }
            }
            
            dp[i] = bestOfPrev + arr.get(i).h;
        }
        
        int maxi = 0;
        for(int i = 0;i<N;i++) maxi = Math.max(maxi,dp[i]);
        return maxi;
    }
}







