import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class MainTest {

    private Person father;
    private Person mother;
    private Person child1;
    private Person child2;
    private Person sibling1;
    private Person sibling2;
    private Pet pet1;
    private Pet pet2;

    @Before
    public void setUp() throws Exception {
        // Maak personen aan
        father = new Person("John", "Doe", 40, "male");
        mother = new Person("Jane", "Doe", 35, "female");
        child1 = new Person("David", "Doe", 10, "male");
        child2 = new Person("Sarah", "Doe", 8, "female");
        sibling1 = new Person("Mike", "Doe", 25, "male");
        sibling2 = new Person("Mary", "Doe", 20, "female");
        pet1 = new Pet("Fluffy", 2, "dog");
        pet2 = new Pet("Whiskers", 1, "cat");

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
    }

    @Test
    public void testAddChild() {
        assertEquals(2, father.getChildren().size());
        assertEquals(2, mother.getChildren().size());
        assertEquals(mother, child1.getMother());
        assertEquals(father, child1.getFather());
    }

    @Test
    public void testGetSiblings() {
        assertEquals(2, child1.getSiblings().size());
        assertEquals(2, sibling1.getSiblings().size());
        assertTrue(child1.getSiblings().contains(sibling1));
        assertTrue(sibling1.getSiblings().contains(child1));
    }

    @Test
    public void testAddSibling() {
        assertEquals(2, child1.getSiblings().size());
        assertEquals(2, sibling1.getSiblings().size());
    }

    @Test
    public void testAddPet() {
        assertEquals(1, father.getPets().size());
        assertEquals(1, child1.getPets().size());
        assertEquals(pet1, father.getPets().get(0));
        assertEquals(pet2, child1.getPets().get(0));
    }

}
