import static org.junit.jupiter.api.Assertions.*;


import org.junit.Test;

public class PetTest {

    @Test
    public void testConstructor() {
        Pet pet = new Pet("Fluffy", 5, "Dog");
        assertEquals("Fluffy", pet.getName());
        assertEquals(5, pet.getAge());
        assertEquals("Dog", pet.getSpecies());
    }

    @Test
    public void testSetters() {
        Pet pet = new Pet("Fluffy", 5, "Dog");
        pet.setName("Max");
        pet.setAge(7);
        pet.setSpecies("Cat");
        assertEquals("Max", pet.getName());
        assertEquals(7, pet.getAge());
        assertEquals("Cat", pet.getSpecies());
    }

    @Test
    public void testOwner() {
        Pet pet = new Pet("Fluffy", 5, "Dog");
        Person owner = new Person("John", "Doe", 40, "male");
        pet.setOwner(owner);
        assertEquals(owner, pet.getOwner());
    }

}

