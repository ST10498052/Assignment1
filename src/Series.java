import java.util.ArrayList;
import java.util.Scanner;

public class Series {
    private Scanner scanner = new Scanner(System.in);
    private ArrayList<SeriesModel> seriesList = new ArrayList<>();

    public void launchMenu() {
        System.out.println("************************");
        System.out.println("Latest series - 2025");
        System.out.println("************************");
        System.out.print("Enter 1 to launch or 0 to exit: ");
        int action = getValidInt();

        if (action == 1) {
            showMenu();
        } else {
            System.out.println("You exited the program.");
        }
    }

    private void showMenu() {
        while (true) {
            System.out.println("\nPlease select one of the menu options:");
            System.out.println("(1) Capture a new series");
            System.out.println("(2) Search for a series");
            System.out.println("(3) Update series age restriction");
            System.out.println("(4) Delete series");
            System.out.println("(5) Print series report - 2025");
            System.out.println("(6) Exit application");

            int option = getValidInt();

            switch (option) {
                case 1 -> captureNewSeries();
                case 2 -> searchSeries();
                case 3 -> updateSeriesAge();
                case 4 -> deleteSeries();
                case 5 -> printReport();
                case 6 -> {
                    System.out.println("Exiting...");
                    return;
                }
                default -> System.out.println("Invalid option. Try again.");
            }
        }
    }

    private void captureNewSeries() {
        System.out.println("CAPTURE A NEW SERIES");
        System.out.println("************************");

        System.out.print("Enter series ID: ");
        String id = scanner.nextLine();

        System.out.print("Enter series name: ");
        String name = scanner.nextLine();

        int age;
        do {
            System.out.print("Enter series age restriction (between 2-18): ");
            age = getValidInt();
            if (age < 2 || age > 18) {
                System.out.println("You have entered an incorrect series age!!");
            }
        } while (age < 2 || age > 18);

        System.out.print("Enter number of episodes: ");
        String episodes = scanner.nextLine();

        // Store in list using SeriesModel variables
        seriesList.add(new SeriesModel(id, name, age, episodes));
        System.out.println("You have successfully captured a series!");
        System.out.print("Enter 1 to launch or 0 to exit: ");
        int action = getValidInt();

        if (action == 1) {
            showMenu();
        } else {
            System.out.println("You exited the program.");
        }
    }

    private void searchSeries() {
        System.out.print("Enter series ID to search: ");
        String searchID = scanner.nextLine();
        System.out.println("************************");

        for (SeriesModel series : seriesList) {
            if (series.getSeriesId().equalsIgnoreCase(searchID)) {
                System.out.printf("%-3s %-10s", "Series Found: " ,"\n" + series);
                return;
            }
        }
        System.out.println("Series not found.");

        System.out.print("Enter 1 to launch or 0 to exit: ");
        int action = getValidInt();

        if (action == 1) {
            showMenu();
        } else {
            System.out.println("You exited the program.");
        }
    }

    private void updateSeriesAge() {
        System.out.print("\nEnter the series ID to update age restriction: ");
        String id = scanner.nextLine();

        for (SeriesModel series : seriesList) {
            if (series.getSeriesId().equalsIgnoreCase(id)) {
                System.out.println("Current Age Restriction: " + series.getSeriesAge());
                series.setSeriesAge(getValidAge());
                System.out.println("Age restriction updated successfully!");
                return;
            }
        }
        System.out.println("Series ID not found.");

        System.out.print("Enter 1 to launch or 0 to exit: ");
        int action = getValidInt();

        if (action == 1) {
            showMenu();
        } else {
            System.out.println("You exited the program.");
        }
    }

    private void deleteSeries() {
        System.out.print("\nEnter the series ID to delete: ");
        String id = scanner.nextLine();

        for (SeriesModel series : seriesList) {
            if (series.getSeriesId().equalsIgnoreCase(id)) {
                seriesList.remove(series);
                System.out.println("Series deleted successfully!");
                return;
            }
        }
        System.out.println("Series ID not found.");
    }

    private void printReport() {
        System.out.println("\nFULL SERIES REPORT");
        System.out.println("************************");
        if (seriesList.isEmpty()) {
            System.out.println("No series available.");
        } else {
            for (SeriesModel series : seriesList) {
                System.out.println(series);
            }
        }

        System.out.print("Enter 1 to launch or 0 to exit: ");
        int action = getValidInt();

        if (action == 1) {
            showMenu();
        } else {
            System.out.println("You exited the program.");
        }
    }

    private int getValidAge() {
        int age;
        while (true) {
            System.out.print("Enter the series age restriction: ");
            age = getValidInt();
            if (age >= 2 && age <= 18) {
                return age;
            } else {
                System.out.println("Age restriction must be between 2 and 18.");
            }
        }
    }

    private int getValidInt() {
        while (true) {
            try {
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number.");
            }
        }
    }
}
