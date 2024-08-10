
// https://www.geeksforgeeks.org/problems/count-subsequences-of-type-ai-bj-ck4425/1
class Solution{
    public int fun(String s){
        // Write your code here
        int prevA = 0;
        int prevB = 0;
        int prevC = 0;
        int md = 1000000000 + 7;
        for(int i = 0;i<s.length();i++){
            int currA = 0;
            int currB = 0;
            int currC = 0;
            
            if(s.charAt(i) == 'a'){
                currA = ((2*prevA)%md + 1)%md;
                currB = prevB;
                currC = prevC;
            }else if(s.charAt(i) == 'b'){
                currA = prevA;
                currB = ((2*prevB)%md + prevA)%md;
                currC = prevC;
            }else{
                currA = prevA;
                currB = prevB;
                currC = ((2*prevC)%md + prevB)%md;
            }
            
            prevA = currA;
            prevB = currB;
            prevC = currC;
        }
        return prevC%md;
    }
}



