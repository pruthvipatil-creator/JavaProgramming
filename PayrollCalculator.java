import java.util.Scanner;
public class PayrollCalculator {
public static void main(String[] args)
{
Scanner sc = new Scanner(System.in);
 
char again;

do {
System.out.println("how many interns to process? ");
int count = sc.nextInt();

double totalSalary = 0;

String[] names = new String[count];
double[] pays = new double[count];

for (int i = 0; i < count; i++)
{
System.out.print("\nIntern " + (i + 1) + "Name :");
names[i] = sc.next();

System.out.print("Hours worked: ");
int hours = sc.nextInt();

System.out.print(" Hourly rate: ");
double rate = sc.nextDouble();

double pay;

if(hours <= 40) {

pay = hours * rate ;
System.out.println("->" + names[i] + "worked normal. pay = " + pay);

} else if(hours <= 48) {

int overtimeHours = hours - 40;

pay = (40 * rate) + (overtimeHours * rate * 1.5);

System.out.println("-> " + names[i] + "worked overtime. Pay = " + pay);

} else {

System.out.println("Exceeds allowed weekly hours");

 pay = (40 * rate) + (8 * rate * 1.5);

System.out.println(" -> Pay capped at 48 hours. Pay = " + pay);
}
totalSalary = totalSalary + pay;
pays[i] = pay;
}
System.out.println("\nTotal payout this batch: " + totalSalary);

System.out.println("Process another batch? (y/n): ");
again = sc.next().charAt(0);

System.out.println("\nName\t\tFinal Pay");

for(int i = 0; i< count; i++) {
System.out.printf("%-15s %.2f%n", names[i], pays[i]);
}

} while (again == 'y' || again == 'Y');

System.out.println("\\nProgram ended.");

sc.close();
}
}






















































