import org.junit.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

    public class PersonTest {

        @Test
        public void testConstructor() {
            Person person = new Person("John", "Doe", 30, "Male");
            assertEquals("John", person.getName());
            assertEquals(null, person.getMiddleName());
            assertEquals("Doe", person.getLastName());
            assertEquals(30, person.getAge());
            assertEquals("Male", person.getSex());
            assertEquals(new ArrayList<Person>(), person.getChildren());
            assertEquals(new ArrayList<Person>(), person.getSiblings());
            assertEquals(new ArrayList<Pet>(), person.getPets());
        }

        @Test
        public void testConstructorWithMiddleName() {
            Person person = new Person("John", "Mike", "Doe", 30, "Male");
            assertEquals("John", person.getName());
            assertEquals("Mike", person.getMiddleName());
            assertEquals("Doe", person.getLastName());
            assertEquals(30, person.getAge());
            assertEquals("Male", person.getSex());
            assertEquals(new ArrayList<Person>(), person.getChildren());
            assertEquals(new ArrayList<Person>(), person.getSiblings());
            assertEquals(new ArrayList<Pet>(), person.getPets());
        }

        @Test
        public void testSetName() {
            Person person = new Person("John", "Doe", 30, "Male");
            person.setName("Johnny");
            assertEquals("Johnny", person.getName());
        }

        @Test
        public void testSetMiddleName() {
            Person person = new Person("John", "Doe", 30, "Male");
            person.setMiddleName("Mike");
            assertEquals("Mike", person.getMiddleName());
        }

        @Test
        public void testSetLastName() {
            Person person = new Person("John", "Doe", 30, "Male");
            person.setLastName("Smith");
            assertEquals("Smith", person.getLastName());
        }

        @Test
        public void testSetSex() {
            Person person = new Person("John", "Doe", 30, "Male");
            person.setSex("Female");
            assertEquals("Female", person.getSex());
        }

        @Test
        public void testSetAge() {
            Person person = new Person("John", "Doe", 30, "Male");
            person.setAge(40);
            assertEquals(40, person.getAge());
        }

        @Test
        public void testSetMother() {
            Person mother = new Person("Jane", "Doe", 50, "Female");
            Person person = new Person("John", "Doe", 30, "Male");
            person.setMother(mother);
            assertEquals(mother, person.getMother());
        }

        @Test
        public void testSetFather() {
            Person father = new Person("John", "Doe", 50, "Male");
            Person person = new Person("John", "Doe", 30, "Male");
            person.setFather(father);
            assertEquals(father, person.getFather());
        }

        @Test
        public void testAddParents() {
            Person mother = new Person("Jane", "Doe", 50, "Female");
            Person father = new Person("John", "Doe", 50, "Male");
            Person person = new Person("John", "Doe", 30, "Male");
            person.addParents(mother, father);
            assertEquals(mother, person.getMother());
            assertEquals(father, person.getFather());
            assertEquals(1, mother.getChildren().size());
            assertEquals(1, father.getChildren().size());
            assertTrue(mother.getChildren().contains(person));


        }
    }