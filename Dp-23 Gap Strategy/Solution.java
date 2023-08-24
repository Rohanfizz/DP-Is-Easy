import java.util.*;

class Solution{
    public static void main(String[] args){
        int[][] arr = {{1,2,3,4},
                       {5,6,7,8},
                       {4,3,2,1},
                       {8,7,6,5}};
        int n = arr.length;
        for(int gap =0; gap < n ;gap++){
            for(int i = 0,j=gap; j<n;i++,j++){
                System.out.print(arr[i][j]+" ");
            }
        }
        
    }
}