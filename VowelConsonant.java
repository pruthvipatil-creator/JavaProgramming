import java.util.Scanner;

class VowelConsonant
{
public static void main(String[] args)
{
Scanner sc = new Scanner(System.in);

System.out.println("enter a character");
char ch = sc.next().charAt(0);

if (ch == 'a' || ch =='e' || ch == 'i' || ch == 'o' || ch == 'u' || 
    ch == 'A' || ch =='E' || ch == 'I' || ch == 'O' || ch == 'U')
{
System.out.println(" it is vowel ");
}
else 
{
System.out.println(" It is consonant ");
}
sc.close();
}
}

