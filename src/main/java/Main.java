import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        // Maak personen aan
        Person father = new Person("John", "Doe", 40, "male");
        Person mother = new Person("Jane", "Doe", 35, "female");
        Person child1 = new Person("David", "Doe", 10, "male");
        Person child2 = new Person("Sarah", "Doe", 8, "female");
        Person sibling1 = new Person("Mike", "Doe", 25, "male");
        Person sibling2 = new Person("Mary", "Doe", 20, "female");
        Pet pet1 = new Pet("Fluffy", 2, "dog");
        Pet pet2 = new Pet("Whiskers", 1, "cat");

        // Wijs ouders en kinderen toe
        father.addChild(child1);
        father.addChild(child2);
        mother.addChild(child1);
        mother.addChild(child2);
        child1.addParents(mother, father);
        child2.addParents(mother, father);

        // Wijs broers/zussen toe
        child1.addSibling(sibling1);
        child1.addSibling(sibling2);
        sibling1.addSibling(child1);
        sibling2.addSibling(child1);

        // Wijs huisdieren toe
        father.addPet(pet1);
        child1.addPet(pet2);

        // Print stamboom
        printFamilyTree(father);
    }

    public static void printFamilyTree(Person person) {
        System.out.println(person.getName() + " " + person.getLastName());
        System.out.println("Parents:");
        if (person.getMother() != null) {
            System.out.println(person.getMother().getName() + " " + person.getMother().getLastName() + " (mother)");
        }
        if (person.getFather() != null) {
            System.out.println(person.getFather().getName() + " " + person.getFather().getLastName() + " (father)");
        }
        System.out.println("Children:");
        for (Person child : person.getChildren()) {
            System.out.println(child.getName() + " " + child.getLastName() + " (" + child.getSex() + ")");
        }
        System.out.println("Siblings:");
        for (Person sibling : person.getSiblings()) {
            System.out.println(sibling.getName() + " " + sibling.getLastName() + " (" + sibling.getSex() + ")");
        }
        System.out.println("Pets:");
        for (Pet pet : person.getPets()) {
            System.out.println(pet.getName() + " (" + pet.getAge() + " (" + pet.getSpecies() + ")");
        }
        System.out.println();
        for (Person child : person.getChildren()) {
            printFamilyTree(child);
        }
    }
}
