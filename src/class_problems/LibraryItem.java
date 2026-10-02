package class_problems;

import java.time.LocalDate;
import java.util.Scanner;

interface Borrowable {
    LocalDate calculateDueDate(LocalDate currentDate);
}

class Book implements Borrowable {
    String title;

    Book(String title) {
        this.title = title;
    }

    public LocalDate calculateDueDate(LocalDate currentDate) {
        return currentDate.plusDays(14);
    }
}

class DVD implements Borrowable {
    String title;

    DVD(String title) {
        this.title = title;
    }

    public LocalDate calculateDueDate(LocalDate currentDate) {
        return currentDate.plusDays(7);
    }
}

class Magazine implements Borrowable {
    String title;

    Magazine(String title) {
        this.title = title;
    }

    public LocalDate calculateDueDate(LocalDate currentDate) {
        return currentDate.plusDays(3);
    }
}

public class LibraryItem {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        sc.nextLine();

        LocalDate currentDate = LocalDate.of(2023, 10, 26);

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            String title = sc.nextLine().trim();

            if (title.startsWith("\"") && title.endsWith("\"")) {
                title = title.substring(1, title.length() - 1);
            }

            Borrowable item;

            if (type.equals("BOOK")) {
                item = new Book(title);
            } else if (type.equals("DVD")) {
                item = new DVD(title);
            } else {
                item = new Magazine(title);
            }

            LocalDate dueDate = item.calculateDueDate(currentDate);

            System.out.println(title + ": " + dueDate);
        }

        sc.close();
    }
}