import java.util.Scanner;

public class MonthlyCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double salary = 0;
        double electricityBill = 0;
        double taxiBill = 0;

        while (true) {
            System.out.println("\n===== MENU =====");
            System.out.println("1. Calculate the electricity bill at the end of the month");
            System.out.println("2. Calculate the taxi fare at the end of the month (assuming: one trip per month)");
            System.out.println("3. Calculate the end-of-month salary (assuming: tax = 15%)");
            System.out.println("4. Calculate the total income after expenses at the end of the month");
            System.out.print("=> Please choose number from 1 to 4 or press any key to exit...");

            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    System.out.print("Enter electricity number(kWh): ");
                    double kwh = Double.parseDouble(scanner.nextLine());
                    electricityBill = calculateElectricityBill(kwh);
                    System.out.println("=> Electricity bill have to pay: " + electricityBill + " VND");
                    break;
                case "2":
                    System.out.print("Enter taxi bill per trip(VND): ");
                    taxiBill = Double.parseDouble(scanner.nextLine());
                    System.out.println("=> Total taxi bill: " + taxiBill + " VND");
                    break;
                case "3":
                    System.out.print("Enter gross salary(VND): ");
                    double grossSalary = Double.parseDouble(scanner.nextLine());
                    salary = calculateNetSalary(grossSalary);
                    System.out.println("=> Net salary(15%): " + salary + " VND");
                    break;
                case "4":
                    double totalIncome = salary - (electricityBill + taxiBill);
                    System.out.println("=> Total income after all: " + totalIncome + " VND");
                    break;
                default:
                    System.out.println("Thank you for using our services!");
                    return; 
            }
        }
    }
    public static double calculateElectricityBill(double kwh) {
        double rate = 3000; 
        return kwh * rate;
    }

    public static double calculateNetSalary(double gross) {
        double taxRate = 0.15;
        return gross * (1 - taxRate);
    }
}

