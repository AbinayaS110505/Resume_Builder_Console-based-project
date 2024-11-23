import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class ResumeBuilder {
    private static String name;
    private static String email;
    private static String phone;
    private static ArrayList<String> education = new ArrayList<>();
    private static ArrayList<String> skills = new ArrayList<>();
    private static ArrayList<String> workExperience = new ArrayList<>();
    private static ArrayList<String> projects = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Welcome to Dynamic Resume Builder!");
            System.out.println("1. Enter Personal Information");
            System.out.println("2. Add Education Details");
            System.out.println("3. Add Skills");
            System.out.println("4. Add Work Experience");
            System.out.println("5. Add Projects");
            System.out.println("6. Generate Resume");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) {
                case 1 -> enterPersonalInformation(scanner);
                case 2 -> addEducation(scanner);
                case 3 -> addSkills(scanner);
                case 4 -> addWorkExperience(scanner);
                case 5 -> addProjects(scanner);
                case 6 -> generateResume();
                case 7 -> {
                    System.out.println("Thank you for using Resume Builder!");
                    scanner.close();
                    return;
                }
                default -> System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void enterPersonalInformation(Scanner scanner) {
        System.out.print("Enter your full name: ");
        name = scanner.nextLine();
        System.out.print("Enter your email address: ");
        email = scanner.nextLine();
        System.out.print("Enter your phone number: ");
        phone = scanner.nextLine();
    }

    private static void addEducation(Scanner scanner) {
        System.out.print("Enter your education details (e.g., Degree, Institution, Year): ");
        education.add(scanner.nextLine());
    }

    private static void addSkills(Scanner scanner) {
        System.out.print("Enter a skill: ");
        skills.add(scanner.nextLine());
    }

    private static void addWorkExperience(Scanner scanner) {
        System.out.print("Enter your work experience (e.g., Job Title, Company, Duration): ");
        workExperience.add(scanner.nextLine());
    }

    private static void addProjects(Scanner scanner) {
        System.out.print("Enter a project (e.g., Project Name, Description): ");
        projects.add(scanner.nextLine());
    }

    private static void generateResume() {
        try (FileWriter writer = new FileWriter("Resume.txt")) {
            writer.write("============ RESUME ============\n\n");
            writer.write("Name: " + name + "\n");
            writer.write("Email: " + email + "\n");
            writer.write("Phone: " + phone + "\n\n");

            writer.write("Education:\n");
            for (String edu : education) {
                writer.write("- " + edu + "\n");
            }
            writer.write("\n");

            writer.write("Skills:\n");
            for (String skill : skills) {
                writer.write("- " + skill + "\n");
            }
            writer.write("\n");

            writer.write("Work Experience:\n");
            for (String experience : workExperience) {
                writer.write("- " + experience + "\n");
            }
            writer.write("\n");

            writer.write("Projects:\n");
            for (String project : projects) {
                writer.write("- " + project + "\n");
            }
            writer.write("\n");

            writer.write("================================\n");

            System.out.println("Resume generated successfully! Check the file 'Resume.txt'.");
        } catch (IOException e) {
            System.out.println("An error occurred while generating the resume.");
            e.printStackTrace();
        }
    }
}
