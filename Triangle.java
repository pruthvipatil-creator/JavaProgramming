import java.util.Scanner;
class Triangle{
public static void main(String[]args){

Scanner sc = new Scanner(System.in);

System.out.print("enter a first triangle :");
int a = sc.nextInt();

System.out.print("enter a second triangle :");
int b = sc.nextInt();

System.out.print("enter a third triangle :");
int c = sc.nextInt();

if(a == b && b == c)
{
System.out.println("equilateral triangle ");
}
else if(a == b || b == c || a == c)
{
System.out.println("isosceles triangle ");
}
else 
{
System.out.println("scalene triangle ");
}
sc.close();
}
}
