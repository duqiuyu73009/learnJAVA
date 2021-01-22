package day21_1_22;

import java.util.Scanner;

public class TestDemo0122_3 {
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int []a=new int[n];
        int A1=0,A2=0,A3=0,A5,t=0,c1=0,c2=0,c3=0,c4=0,c5=0;
        double A4=0;
        int sum=0,b=0;
        int max=0;
        int count=1;
        for(int i=0;i<n;i++)
        {
            a[i]=sc.nextInt();
            if(a[i]%5==0)
            {
                if(a[i]%2==0)
                {
                    A1=A1+a[i];
                    c1++;
                }
            }
            else if(a[i]%5==1)
            {
                c2++;

                if(count%2==1)
                    a[i]=a[i];
                else
                    a[i]=(-1)*a[i];
                A2=A2+a[i];
                count++;
            }
            else if(a[i]%5==2)
            {
                c3++;
                A3++;
            }
            else if(a[i]%5==3)
            {
                c4++;
                b++;
                sum=sum+a[i];
            }
            else if(a[i]%5==4)
            {
                c5++;

                if(max<a[i])
                {
                    t=max;
                    max=a[i];
                    a[i]=t;
                }

            }
        }

        A5=max;
        if(c1==0)
        {
            System.out.print("N"+" ");
        }
        if(c1!=0)
        {
            System.out.print(A1+" ");
        }
        if(c2==0)
        {
            System.out.print("N"+" ");
        }
        if(c2!=0)
        {
            System.out.print(A2+" ");
        }
        if(c3==0)
        {
            System.out.print("N"+" ");
        }
        if(c3!=0)
        {
            System.out.print(A3+" ");
        }
        if(c4==0)
        {
            System.out.print("N"+" ");
        }
        if(c4!=0)
        {
            A4=(float)sum/b;
            System.out.printf("%.1f"+" ",A4);
        }
        if(c5==0)
        {
            System.out.print("N");
        }
        if(c5!=0)
        {
            System.out.print(A5);
        }
    }
}
