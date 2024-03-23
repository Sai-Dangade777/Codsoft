import java.util.Scanner;
class CurrencyConverter
{
    static class currency
    {

        double
        IND=1,
        USD=83.2992,
        EUR=89.2592,
        JPY=0.5478,
        GBP=101.8165,
        AUD=52.9866;
        String[] name=new String[]{"Indian Rupee","United States Dollar","Euro","Japanese Yen","Pound Sterling","Australian Dollar"};
        int n=6;
    }
    public static void main(String[] args)
    {
        System.out.println("CURRENCY CONVERTER");
        while(true)
        {
        double r=0;
        int i=0,j=0;
        currency o=new currency();
        Scanner scan=new Scanner(System.in);
        for(int k=0;k<o.n;k++)
        {
            System.out.print("\n"+(k+1)+". "+o.name[k]);
        }
        System.out.print("\n\nstarting currency: ");
        int x=scan.nextInt();
        System.out.print("\nending currency: ");
        int y=scan.nextInt();
        System.out.print("\nenter amount: ");
        double amount=scan.nextDouble();
        switch(x)
        {
            case 1:r=o.IND*amount;
                i=0;
                break;
            case 2:r=o.USD*amount;
                i=1;
                break;
            case 3:r=o.EUR*amount;
                i=2;
                break;
            case 4:r=o.JPY*amount;
                i=3;
                break;
            case 5:r=o.GBP*amount;
                i=4;
                break;
            case 6:r=o.AUD*amount;
                i=5;
                break;
            default:System.out.println("INVALID CHOICE");
        }
        switch(y)
        {
            case 1:r*=(1/o.IND);
                j=0;
                break;
            case 2:r*=(1/o.USD);
                j=1;
                break;
            case 3:r*=(1/o.EUR);
                j=2;
                break;
            case 4:r*=(1/o.JPY);
                j=3;
                break;
            case 5:r*=(1/o.GBP);
                j=4;
                break;
            case 6:r*=(1/o.AUD);
                j=5;
                break;
            default:System.out.println("INVALID CHOICE");
        }
        System.out.println("\n"+amount+" "+o.name[i]+" = "+r+" "+o.name[j]);
        }
    }
}