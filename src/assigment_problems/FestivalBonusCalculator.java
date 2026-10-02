package assigment_problems;

import java.util.Scanner;

interface EmployeeBonus {
    double calculateBonus();
}

class FullTimeEmployee implements EmployeeBonus {
    double salary;

    FullTimeEmployee(double salary) {
        this.salary = salary;
    }

    public double calculateBonus() {
        return salary * 0.10;
    }
}

class PartTimeEmployee implements EmployeeBonus {
    double salary;

    PartTimeEmployee(double salary) {
        this.salary = salary;
    }

    public double calculateBonus() {
        return salary * 0.05;
    }
}

class InternEmployee implements EmployeeBonus {
    double salary;

    InternEmployee(double salary) {
        this.salary = salary;
    }

    public double calculateBonus() {
        return 2000;
    }
}

public class FestivalBonusCalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        double total = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            String name = sc.next();
            double salary = sc.nextDouble();

            EmployeeBonus employee;

            if (type.equals("FULLTIME")) {
                employee = new FullTimeEmployee(salary);

            } else if (type.equals("PARTTIME")) {
                employee = new PartTimeEmployee(salary);

            } else {
                employee = new InternEmployee(salary);
            }

            double bonus = employee.calculateBonus();
            total += bonus;

            System.out.printf("%s: %.2f%n", name, bonus);
        }

        System.out.printf("Total Bonus: %.2f%n", total);

        sc.close();
    }
}