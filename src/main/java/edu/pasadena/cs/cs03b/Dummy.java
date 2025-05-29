package edu.pasadena.cs.cs03b;

import java.util.Scanner;

public class Dummy {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Define salary brackets and corresponding tax rates
        int[] salaryRanges = {0, 20000, 50000, 100000, Integer.MAX_VALUE};
        double[] taxRates = {0.0, 0.10, 0.20, 0.30, 0.40};

        TaxTableTools taxTool = new TaxTableTools();
        taxTool.setTaxTable(salaryRanges, taxRates);

        while (true) {
            System.out.print("Enter annual income (-1 to exit): ");
            int income = scanner.nextInt();

            if (income == -1) {
                break;
            }

            taxTool.setSalary(income);
            double rate = taxTool.getTaxRate();
            double tax = taxTool.calculateTax();

            System.out.printf("Annual Income: %d Tax rate: %.2f Tax to pay: %.2f%n", income, rate, tax);
        }

        scanner.close();
    }

    public static int dummy() {
        return 1;
    }
}

// Inner class for handling tax logic
class TaxTableTools {

    private int[] salaryRanges;
    private double[] taxRates;
    private int salary;

    // Set the tax brackets and rates
    public void setTaxTable(int[] salaryRanges, double[] taxRates) {
        this.salaryRanges = salaryRanges;
        this.taxRates = taxRates;
    }

    // Set the user's income
    public void setSalary(int salary) {
        this.salary = salary;
    }

    // Determine the applicable tax rate
    public double getTaxRate() {
    for (int i = 0; i < salaryRanges.length - 1; i++) {
        if (salary >= salaryRanges[i] && salary < salaryRanges[i + 1]) {
            return taxRates[i];
        }
    }
    return taxRates[taxRates.length - 1];
}

    // Calculate tax owed
    public double calculateTax() {
        return salary * getTaxRate();
    }
}
