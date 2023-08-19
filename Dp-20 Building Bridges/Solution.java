import java.util.*;

class Solution{

    public static class Pair{
        int north;
        int south;
        Pair(int north,int south){
            this.north = north;
            this.south = south;
        }
    }
    public static int lis(ArrayList<Pair> arr){
        //will return the longest increasing subseq of south bank

        TreeSet<Integer> ts = new TreeSet<>();

        for(Pair p: arr){
            int south = p.south;
            Integer ceil= ts.ceiling(south);
            if(ceil!=null){
                ts.remove(ceil);
            }
            ts.add(south);
        }
        return ts.size();

    }
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        
        int n = scn.nextInt();
        
        int[] north = new int[n];
        for(int i = 0;i<n;i++) north[i] = scn.nextInt();

        int[] south = new int[n];
        for(int i = 0;i<n;i++) south[i] = scn.nextInt();

        ArrayList<Pair> arr = new ArrayList<>();

        for(int i = 0;i<n;i++) arr.add(new Pair(north[i] , south[i]));
        //Sort arr is asc order on the basis of north bank

        Collections.sort(arr, (a,b)->{
            // a-b
            return a.north-b.north;
        } );

        System.out.println(lis(arr));

        scn.close();
    }
}