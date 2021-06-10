public class Sample {

    public static void main(String[] args){
       // printTraingleStars(3);
        //System.out.println(" palindrome "+recursionPalindrom("b".toCharArray(),0));
        maxAndMinOfArray(new int[]{9,9 , 8 , -0 , -9});
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
}
