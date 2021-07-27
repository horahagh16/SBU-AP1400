import java.util.Scanner;

public class SaatSheni {
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        int rows=input.nextInt();
        for (int i = 1; i <= rows; i++)
        {
            for (int j = 1; j < i; j++)
            {
                System.out.printf(" ");
            }//fasele peyda kone az avale khat v mesle saat beshe

            for (int k = i; k <= rows; k++)
            {
                System.out.printf("%d ",k);
            }
            System.out.println();
        }
        for (int i = rows-1; i >= 1; i--)
        {
            for (int j = 1; j < i; j++)
            {
                System.out.printf(" ");
            }

            for (int k = i; k <= rows; k++)
            {
                System.out.printf("%d ",k);
            }
            System.out.println();
        }

    }
}
            

