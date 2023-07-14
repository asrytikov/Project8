import java.util.Comparator;
import java.util.Objects;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {

        Object obj = new Object();
        Object obj1 = new Object();
        obj.equals(obj1);

        Person person = new Person("Ivan", 30);
        Person person1 = new Person("Masha", 25);
        System.out.print(person.compareTo(person1));

        Comparator<Person> personComparator = new PersonAgeComparator().thenComparing(new PersonAgeComparator());
        TreeSet<Person> people = new TreeSet<>(personComparator);
        people.add(new Person("Ivan", 20));
        people.add(new Person("Alexander", 30));
        people.add(new Person("Yan", 40));

        System.out.print(people);



    }
}

class Person implements Comparable<Person>{
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(name, person.name) && Objects.equals(age, person.age);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }
    
    @Override
    public int compareTo(Person o) {
        return name.length()-o.getName().length();
    }

    /*private int compareTo(int age, int age1) {
        if (age>age1) {return 1;} else
            if (age<age1) {return -1;}else
                return 0;

        }*/

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}

class PersonNameComparator implements Comparator<Person>{

    @Override
    public int compare(Person o1, Person o2) {
        return o1.getName().compareTo(o2.getName());
    }
}

class PersonAgeComparator implements Comparator<Person>{
    public int compare(Person a, Person b) {
        if (a.getAge()>b.getAge()) {return 1;}
        else if (a.getAge()<b.getAge()) {return -1;}
        else
            return 0;
    }
}
