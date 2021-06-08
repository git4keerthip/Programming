public class Sample {

    public static void main(String[] args){
        printTraingleStars(3);
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
}
