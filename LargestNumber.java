public class LargestNumber{
public static void main(String[] args)
{
int a = 56;
int b = 82;
int c = 75;

int Largest = (a >= b && a >= c) ? a : (b >= c ? b : c);
System.out.println("LargestNumber = " + Largest);
}
}