import java.util.ArrayList;

public class AddressBook<E extends Person> {
    private ArrayList<E> book = new ArrayList<E>();

    // AddressBook() constructor to create an initialize the ad
    public AddressBook() {
        System.out.println("Address book created!");
    }

    // The add(E p) method should add a person object to the address book. Make
    // sure that the add method does not add duplicate person objects to the address
    // book.
    public void add(E p) {
        for (E person : book) {
            if (person == null) {
                break;
            }
            if (person.getID() == p.getID()) {
                System.out.println("This person already exists, they cannot be added");
                System.exit(0);
            }
        }

        book.add(p);
    }

    // The delete(E p) method should remove the specified person object from
    // the address book.
    public void delete(E p) {
        for (int i = 0; i < book.size(); i++) {
            if (book.get(i) == p) {
                book.remove(i);
                break;
            }
        }
    }

    // The delete(int id) method should remove person object with the specified id
    // from the address book.
    public void delete(int id) {
        for (E person : book) {
            if (person != null && person.getID() == id) {
                book.remove(book.indexOf(person));
                break;
            }
        }
    }

    // The search(String name) method that searches the address book for a specified
    // person and returns the list of persons matching name.
    public ArrayList<E> search(String name) {
        ArrayList<E> matches = new ArrayList<E>();

        for (E person : book) {
            if (person != null && person.getFirstName().equals(name) || person.getLastName().equals(name)) {
                matches.add(person);
            }
        }
        return matches;
    }

    // The search(int id) method that searches the address book for the person with
    // the given id and returns the person object if found and none if the there is
    // no person object with that it in the address book.
    public E search(int id) {
        for (E person : book) {
            if (person != null && person.getID() == id) {
                return person;
            }
        }
        return null;
    }

    // The print method to print all the person objects in the address book.
    public void print() {
        for (E person : book) {
            if (person != null) {
                System.out.println(person.toString());
            }
        }
    }
}
