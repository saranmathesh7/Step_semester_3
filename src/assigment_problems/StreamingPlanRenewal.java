package assigment_problems;

import java.time.LocalDate;
import java.util.Scanner;

interface SubscriptionPlan {
    LocalDate calculateRenewalDate(LocalDate startDate);
}

class BasicPlan implements SubscriptionPlan {
    public LocalDate calculateRenewalDate(LocalDate startDate) {
        return startDate.plusDays(30);
    }
}

class StandardPlan implements SubscriptionPlan {
    public LocalDate calculateRenewalDate(LocalDate startDate) {
        return startDate.plusDays(90);
    }
}

class PremiumPlan implements SubscriptionPlan {
    public LocalDate calculateRenewalDate(LocalDate startDate) {
        return startDate.plusDays(365);
    }
}

public class StreamingPlanRenewal {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            String name = sc.next();
            LocalDate startDate = LocalDate.parse(sc.next());

            SubscriptionPlan plan;

            if (type.equals("BASIC")) {
                plan = new BasicPlan();

            } else if (type.equals("STANDARD")) {
                plan = new StandardPlan();

            } else {
                plan = new PremiumPlan();
            }

            LocalDate renewalDate =
                    plan.calculateRenewalDate(startDate);

            System.out.println(name + ": " + renewalDate);
        }

        sc.close();
    }
}