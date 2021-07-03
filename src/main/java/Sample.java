//import sun.tools.asm.CatchData;

import java.util.*;

public abstract  class Sample {

    public Sample(){

    }
    public static void main(String[] args)  {
        trailingZeroes(5);
       // printTraingleStars(3);
        //System.out.println(" palindrome "+recursionPalindrom("b".toCharArray(),0));
        //maxAndMinOfArray(new int[]{9,9 , 8 , -0 , -9});
//        Integer minsum = Kadane2(new int[] {2,6,8,1,4,0});

      //  permutationsString("ABCB","");

        //stockPairs(Arrays.asList(1,3,46,1,3,9),47);
        //leetcode2Sum(new int[] {1,3,46,1,3,9} , 47);
      //  leetcodeReverseInt(123);
      //revisit // merge two sorted list

    }
    static int trailingZeroes(int N){
        // Write your code here
        if(N<5) return 0;
        HashMap<Integer,Integer> hm = new HashMap<Integer,Integer>();
        int temp = fact(N,hm);
        int count =0; int rem =0;
        while(rem==0){
            rem = temp%10;
            temp = temp/10;
           if(rem==0) count++;
        }
        return count;

    }
    static int fact(int N,HashMap <Integer,Integer> hm){
        if(hm.containsKey(N))
            return hm.get(N);
        if(N ==1 || N ==0) return 1;
        int temp = N*fact(N-1,hm);
        hm.put(N,temp);
        return hm.get(N);
    }
    public static void printTraingleStars(int n){
        int mid = n-1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 2*n-1; j++) {

                if(j>=(mid-i)&&j<=(mid+i))
                    System.out.print("*");
                else
                    System.out.print(" ");
            }
            System.out.println("");
        }
    }
    public static boolean recursionPalindrom(char[] str,int index){
        if(str==null || str.length==0) return false;
        int len = str.length-1;
        if(index > (len)/2)
            return true;

        if(str[index]==str[len-index])
          return  recursionPalindrom(str, index+1);
        else
            return false;
    }
    public static void maxAndMinOfArray(int[] a){
        if(a==null || a.length ==0) return;
        int len = a.length-1;
        int max = a[0] ;int min = a[0];
        for(int i=0;i<len;i++){
            if(min>a[i+1])
                min = a[i+1];
            if(max<a[i+1])
                max =a[i+1];
        }
        System.out.println("minimum " +min+ " and maximum are "+ max);
    }
    public static Integer maxSubArray(int[] a){
        if(a == null || a.length ==0) return null;
        int len = a.length; int maxSum =a[0];
        for(int i=0; i<len-1;i++){
            int sum = a[i];
            for(int j=i+1;j<=len-1;j++){
                sum = sum +a[j];
                if(maxSum<sum)
                    maxSum = sum;
            }
        }
        return maxSum;
    }
    public static Integer Kadane(int[] a){
        if(a == null || a.length ==0) return null;
        int len = a.length-1;
        int globalMax = a[0]; int localMax = a[0];
        for(int i =1;i<=len;i++){
            localMax = Math.max(a[i],localMax+a[i]);
            if(globalMax<localMax)
                globalMax = localMax;
        }
        return globalMax;
    }
    public static Integer Kadane2(int[] a){
        if(a == null || a.length ==0) return null;
        int len = a.length-1;
        int globalMin = a[0]; int localMin = a[0];
        for(int i =1;i<=len;i++){
            localMin = Math.min(a[i],localMin+a[i]);
            if(globalMin>localMin)
                globalMin = localMin;
        }
        return globalMin;
    }
    public static void permutationsString(String input , String ans){
        if(input.length()==0) {
            System.out.println(ans);return;
        }
        for(int i=0;i<input.length();i++)
        {
            String subString = input.substring(0,i)+input.substring(i+1);
            permutationsString(subString,ans+input.charAt(i));
        }
   }
    public static int stockPairs(List<Integer> stocksProfit, long target) {
        // Write your code here
        int countStocks=0;
        Set<String> st = new HashSet<>();
        for(int i= 0 ;i<stocksProfit.size()-1;i++){
            for(int j=i+1;j<stocksProfit.size();j++){

                if(stocksProfit.get(i)+stocksProfit.get(j)==target){

                    String temp;
                    if(stocksProfit.get(i)<stocksProfit.get(j))
                        temp= stocksProfit.get(i)+"_"+stocksProfit.get(j);
                    else
                        temp = stocksProfit.get(j)+"_"+stocksProfit.get(i);
                    if(st.add(temp))
                        countStocks++;

                }
            }
        }
        return countStocks;
    }
    public static int[] leetcode2Sum(int[] a, int target){
        if(a.length ==2 )
        {
            if(a[0]+a[1]==target)
                return new int[]{0,1};
        }
        Map<Integer,Integer> hm = new HashMap<>();
        for(int i =0; i<a.length;i++){
            hm.put(a[i],i);
        }
        for(int i =0; i<a.length;i++){
           int temp = target -a[i];
           if(hm.containsKey(temp)&&hm.get(temp)!=i){
               return new int[]{i,hm.get(temp)};
           }
        }
        return new int[]{};
    }
    public static int leetcodeReverseInt(int x){
        if(x>=-9 && x <=9)
            return x;
        if(x<=Integer.MIN_VALUE && x>=Integer.MAX_VALUE) return 0;
        String str ="";
        int y  = Math.abs(x);
        while(y!=0) {
            int mod =y % 10;
            str = str + mod;
            y = y / 10;
        }
        try {
            y = Integer.valueOf(str);
        }
        catch (NumberFormatException e)
        {
            return 0;
        }
        if(x<0)
            return -y;
        else return y;
    }
}

