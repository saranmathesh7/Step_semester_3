package assigment_problems;

import java.util.Scanner;

interface Room {
    double calculateBill();
}

class SingleRoom implements Room {
    int units;

    SingleRoom(int units) {
        this.units = units;
    }

    public double calculateBill() {
        return units * 8;
    }
}

class SharedRoom implements Room {
    int units;
    int occupants;

    SharedRoom(int units, int occupants) {
        this.units = units;
        this.occupants = occupants;
    }

    public double calculateBill() {
        return (units * 6) / (double) occupants;
    }
}

class AcRoom implements Room {
    int units;

    AcRoom(int units) {
        this.units = units;
    }

    public double calculateBill() {
        return (units * 10) + 200;
    }
}

public class HostelElectricityBill {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        double total = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            int units = sc.nextInt();

            Room room;

            if (type.equals("SINGLE")) {
                room = new SingleRoom(units);

            } else if (type.equals("SHARED")) {
                int occupants = sc.nextInt();
                room = new SharedRoom(units, occupants);

            } else {
                room = new AcRoom(units);
            }

            double bill = room.calculateBill();
            total += bill;

            System.out.printf("%s: %.2f%n", type, bill);
        }

        System.out.printf("Total: %.2f%n", total);

        sc.close();
    }
}