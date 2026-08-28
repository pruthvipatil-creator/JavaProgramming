import java.util.Scanner;
public class EmployeeAttendence {
public static void main(String[] args)
{
Scanner sc = new Scanner(System.in);

System.out.print("Enter Batch Size(1-9): ");
int n = sc.nextInt();

if ( n > 1 && n < 9 ) {

for (int i = 1; i <= n; i++) {

for (int j = 1; j <= n - i; j++) {
System.out.print(" ");
}
for (int j = 1; j <= i; j++) {
System.out.print(j + " ");
}
System.out.println();
}
}
else {
System.out.println("Invalid input! Please enter a number between 1 and 9.");
return;
}

int sum = 0;

for (int i = 1; i <= n; i++) {
sum = sum +i;
}
double average = (double) sum / n;

System.out.println("Sum of 1 to " + n + " = " + sum);
System.out.println("Average = " + average);
System.out.println("Even number (reverse): ");

int i = n;

while (i >= 1) {

if (i % 2 == 0) {
System.out.print(i + " ");
}

i--;

}
sc.close();
} 
}
