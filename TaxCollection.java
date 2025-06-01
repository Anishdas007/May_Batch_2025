import java.util.Scanner;
class TaxPayer {
    double salary;
    int age;
    double investment;
    double healthInsurance;
    double homeLoanInterest;
    TaxPayer(double salary, int age, double investment, double healthInsurance, double homeLoanInterest) {
        this.salary = salary;
        this.age = age;
        this.investment = investment;
        this.healthInsurance = healthInsurance;
        this.homeLoanInterest = homeLoanInterest;
    }
}
class TaxCalculator {
    TaxPayer taxPayer;
    TaxCalculator(TaxPayer taxPayer) {
        this.taxPayer = taxPayer;
    }
    double calculateDeductions() {
        double section80C = Math.min(taxPayer.investment, 150000);
        double section80D = taxPayer.age < 60
                ? Math.min(taxPayer.healthInsurance, 25000)
                : Math.min(taxPayer.healthInsurance, 50000);
        double section24 = Math.min(taxPayer.homeLoanInterest, 200000);
        return section80C + section80D + section24;
    }
    double calculateTaxableIncome() {
        double deductions = calculateDeductions();
        double taxableIncome = taxPayer.salary - deductions;
        return Math.max(taxableIncome, 0);
    }
    double computeTax() {
        double taxableIncome = calculateTaxableIncome();
        int age = taxPayer.age;
        double tax = 0;
        if (age < 60) {
            if (taxableIncome <= 250000) tax = 0;
            else if (taxableIncome <= 500000) tax = (taxableIncome - 250000) * 0.05;
            else if (taxableIncome <= 1000000) tax = 12500 + (taxableIncome - 500000) * 0.20;
            else tax = 112500 + (taxableIncome - 1000000) * 0.30;
        } else if (age < 80) {
            if (taxableIncome <= 300000) tax = 0;
            else if (taxableIncome <= 500000) tax = (taxableIncome - 300000) * 0.05;
            else if (taxableIncome <= 1000000) tax = 10000 + (taxableIncome - 500000) * 0.20;
            else tax = 110000 + (taxableIncome - 1000000) * 0.30;
        } else {
            if (taxableIncome <= 500000) tax = 0;
            else if (taxableIncome <= 1000000) tax = (taxableIncome - 500000) * 0.20;
            else tax = 100000 + (taxableIncome - 1000000) * 0.30;
        }
        return tax;
    }
    void printSummary() {
        double deductions = calculateDeductions();
        double taxableIncome = calculateTaxableIncome();
        double tax = computeTax();
        System.out.println("\n--- Tax Calculation Summary ---");
        System.out.println("Gross Salary: ₹" + taxPayer.salary);
        System.out.println("Total Deductions: ₹" + deductions);
        System.out.println("Taxable Income: ₹" + taxableIncome);
        System.out.println("Total Tax Owed: ₹" + tax);
    }
}

public class TaxCollection {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter your annual salary (INR): ");
        double salary = sc.nextDouble();
        System.out.print("Enter your age (in years): ");
        int age = sc.nextInt();
        System.out.print("Investment in tax-saving instruments (INR): ");
        double investment = sc.nextDouble();
        System.out.print("Health insurance premium paid annually (INR): ");
        double healthInsurance = sc.nextDouble();
        System.out.print("Home loan interest paid annually (INR): ");
        double homeLoanInterest = sc.nextDouble();
        TaxPayer taxPayer = new TaxPayer(salary, age, investment, healthInsurance, homeLoanInterest);
        TaxCalculator calculator = new TaxCalculator(taxPayer);
        calculator.printSummary();
    }
}
