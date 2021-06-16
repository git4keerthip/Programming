//import sun.tools.asm.CatchData;

import java.util.*;

public  class Sample {

Queue<Integer> q = new PriorityQueue<>();


    public static void main(String[] args){

       // printTraingleStars(3);
        //System.out.println(" palindrome "+recursionPalindrom("b".toCharArray(),0));
        //maxAndMinOfArray(new int[]{9,9 , 8 , -0 , -9});
//        Integer minsum = Kadane2(new int[] {2,6,8,1,4,0});

        permutationsString("ABCB","");

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
}
