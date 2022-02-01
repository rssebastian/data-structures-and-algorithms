import java.util.ArrayList;

public class AddressBookTester {
    public static void main(String[] args) {
        AddressBook<Student> addressBook = new AddressBook<Student>();
        Student person0 = new Student("Albert", "Albertson");
        Student person1 = new Student("Bill", "Bilson");
        Student person2 = new Student("Carl", "Carlson");
        Student person3 = new Student("Daniel", "Danielson");
        Student person4 = new Student("Edwina", "Edwindaughter");
        Student person5 = new Student("Frank", "Franklin");
        Student person6 = person0;

        addressBook.add(person0);
        addressBook.add(person1);
        addressBook.add(person2);
        addressBook.add(person3);
        addressBook.add(person4);
        addressBook.add(person5);

        String linebreak = "----------------------------";
        System.out.println(linebreak);
        System.out.println(linebreak);
        System.out.println("Printing your initialized address book...");
        System.out.println(linebreak);
        addressBook.print();
        System.out.println(linebreak);
        System.out.println("You're searching for someone with the last name Bilson? Let me check...");

        ArrayList<Student> matches = addressBook.search("Bilson");
        System.out.println("We found: ");
        for (int i = 0; i < matches.size(); i++) {
            System.out.println(matches.get(i));
        }

        System.out.println(linebreak);
        System.out.println("This person needs to be removed? Let me work on that...");
        addressBook.delete(addressBook.search(1002));
        System.out.println("They were removed! Here's your updated address book");
        System.out.println(linebreak);
        addressBook.print();

        System.out.println(linebreak);
        System.out.println("You need to add an Albert Albertson? Let me work on that...");
        addressBook.add(person6);

    }
}

// TEST CASE OUTPUT
// Address book created!
// ----------------------------
// ----------------------------
// Printing your initialized address book...
// ----------------------------
// Albert Albertson, ID#: 1001
// Bill Bilson, ID#: 1002
// Carl Carlson, ID#: 1003
// Daniel Danielson, ID#: 1004
// Edwina Edwindaughter, ID#: 1005
// Frank Franklin, ID#: 1006
// ----------------------------
// You're searching for someone with the last name Bilson? Let me check...
// We found:
// Bill Bilson, ID#: 1002
// ----------------------------
// This person needs to be removed? Let me work on that...
// They were removed! Here's your updated address book
// ----------------------------
// Albert Albertson, ID#: 1001
// Carl Carlson, ID#: 1003
// Daniel Danielson, ID#: 1004
// Edwina Edwindaughter, ID#: 1005
// Frank Franklin, ID#: 1006
// ----------------------------
// You need to add an Albert Albertson? Let me work on that...
// This person already exists, they cannot be added