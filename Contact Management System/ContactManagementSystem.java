import java.util.ArrayList;
import java.util.Scanner;

// Class to represent a Contact
class Contact {
    String name;
    String phone;
    String email;

    Contact(String name, String phone, String email) {
        this.name = name;
        this.phone = phone;
        this.email = email;
    }
}

public class ContactManagementSystem {
    public static void main(String[] args) {
        ArrayList<Contact> contacts = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n---Contact Management System ---");
            System.out.println("1. Add Contact");
            System.out.println("2. View Contacts");
            System.out.println("3. Update Contact");
            System.out.println("4. Delete Contact");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter Phone: ");
                    String phone = sc.nextLine();
                    System.out.print("Enter Email: ");
                    String email = sc.nextLine();

                    contacts.add(new Contact(name, phone, email));
                    System.out.println("Contact added successfully!");
                    break;

                case 2:
                    if (contacts.isEmpty()) {
                        System.out.println("No contacts found!");
                    } else {
                        System.out.println("\n--- Contact List ---");
                        for (int i = 0; i < contacts.size(); i++) {
                            Contact c = contacts.get(i);
                            System.out.println((i + 1) + ". " + c.name + " | " + c.phone + " | " + c.email);
                        }
                    }
                    break;

                case 3:
                    if (contacts.isEmpty()) {
                        System.out.println("No contacts to update!");
                        break;
                    }
                    System.out.print("Enter contact number to update: ");
                    int index = sc.nextInt();
                    sc.nextLine();

                    if (index > 0 && index <= contacts.size()) {
                        Contact c = contacts.get(index - 1);
                        System.out.print("Enter new Name: ");
                        c.name = sc.nextLine();
                        System.out.print("Enter new Phone: ");
                        c.phone = sc.nextLine();
                        System.out.print("Enter new Email: ");
                        c.email = sc.nextLine();
                        System.out.println("Contact updated successfully!");
                    } else {
                        System.out.println("Invalid contact number!");
                    }
                    break;

                case 4:
                    if (contacts.isEmpty()) {
                        System.out.println("No contacts to delete!");
                        break;
                    }
                    System.out.print("Enter contact number to delete: ");
                    int delIndex = sc.nextInt();
                    sc.nextLine();

                    if (delIndex > 0 && delIndex <= contacts.size()) {
                        contacts.remove(delIndex - 1);
                        System.out.println("Contact deleted successfully!");
                    } else {
                        System.out.println("Invalid contact number!");
                    }
                    break;

                case 5:
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        } while (choice != 5);

        sc.close();
    }
}
