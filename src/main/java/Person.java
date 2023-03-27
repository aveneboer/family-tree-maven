import java.util.ArrayList;
import java.util.List;

public class Person {

    private String name;
    private String middleName;
    private String lastName;
    private String sex;
    int age;
    private Person mother;
    private Person father;
    private ArrayList<Person> siblings;
    private ArrayList<Person> children;
    private ArrayList<Pet> pets;

    public Person(String name, String lastName, int age, String sex) {
        this.name = name;
        this.lastName = lastName;
        this.sex = sex;
        this.age = age;
        this.children = new ArrayList<>();
        this.siblings = new ArrayList<>();
        this.pets = new ArrayList<>();
    }

    public Person(String name, String middleName, String lastName, int age, String sex) {
        this(name, lastName, age, sex);
        this.middleName = middleName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Person getMother() {
        return mother;
    }

    public void setMother(Person mother) {
        this.mother = mother;
    }

    public Person getFather() {
        return father;
    }

    public void setFather(Person father) {
        this.father = father;
    }

    public ArrayList<Person> getSiblings() {
        return siblings;
    }

    public void setSiblings(ArrayList<Person> siblings) {
        this.siblings = siblings;
    }

    public ArrayList<Person> getChildren() {
        return children;
    }

    public void setChildren(ArrayList<Person> children) {
        this.children = children;
    }

    public ArrayList<Pet> getPets() {
        return pets;
    }

    public void setPets(ArrayList<Pet> pets) {
        this.pets = pets;
    }


    public void addParents(Person mother, Person father) {
        this.mother = mother;
        this.father = father;
        mother.getChildren().add(this);
        father.getChildren().add(this);
    }

    public void addChild(Person child) {
        children.add(child);
        child.setMother(this);
        child.setFather(this);
    }

    public void addPet(Pet pet) {
        pets.add(pet);
        pet.setOwner(this);
    }

    //addSiblings
    public void addSibling(Person sibling) {
        siblings.add(sibling);
        sibling.getSiblings().add(this);
    }

    // Get grandchildren
    public ArrayList<Person> getGrandChildren() {
        ArrayList<Person> grandchildren = new ArrayList<>();
        for (Person child : children) {
            grandchildren.addAll(child.getChildren());
        }
        return grandchildren;
    }

}
