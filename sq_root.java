import java.util.Scanner;

public class sq_root {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int x = in.nextInt();
        long i;
        for(i=1;i<=x;i++){
        if(i*i > x )
        break;
       }
       System.out.println((int)(i-1));
    }
}