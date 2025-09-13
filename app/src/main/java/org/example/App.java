package org.example;

import java.util.Scanner;

public class App {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);

    final double hourlyRate = 16.78;
    final double overtimeRate = hourlyRate * 1.5;
    final double socSecTax = 0.06;
    final double fedTax = 0.14;
    final double stateTax = 0.05;
    final double unionDues = 10.00;

    System.out.println("Welcome to the Payroll Program!\n");

    System.out.print("How many hours did you work this week?");
    double hours = input.nextDouble();

    System.out.print("How many dependents do you have?");
    int dependents = input.nextInt();

    double gross;
    if (hours <= 40) {
      gross = hours * hourlyRate;
    } else {
      double regular = 40 * hourlyRate;
      double overtime = (hours - 40) * overtimeRate;
      gross = regular + overtime;
    }

    double socSec = gross * socSecTax;
    double FedTax = gross * fedTax;
    double StateTax = gross * stateTax;
    double union = unionDues;
    double insurance;

    if (dependents >= 3) {
      insurance = 35.00;
    } else {
      insurance = 15.00;
    }

    double totalExpenses = socSec + FedTax + StateTax + union + insurance;

    double net = gross - totalExpenses;

    System.out.println("\nPayroll Stub:\n");
    System.out.printf("   Hours: %6.2f\n", hours);
    System.out.printf("    Rate: %6.2f $/hr\n", hourlyRate);
    System.out.printf("   Gross: $%7.2f\n\n", gross);

    System.out.printf("  SocSec: $%7.2f\n", socSec);
    System.out.printf("  FedTax: $%7.2f\n", FedTax);
    System.out.printf("   StTax: $%7.2f\n", StateTax);
    System.out.printf("   Union: $%7.2f\n", union);
    System.out.printf("     Ins: $%7.2f\n\n", insurance);

    System.out.printf("     Net: $%7.2f\n", net);

    System.out.println("\nThank you for using the Payroll Program!");

    input.close();
  }
}
