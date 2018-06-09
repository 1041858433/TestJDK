/**
 * @author DingYin
 * 3/14/2018 7:08 PM
 */
public class Professor implements Cloneable{

    private String name;

    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Professor [name=" + name + ", age=" + age + "]";
    }

    @Override
    public Object clone() throws CloneNotSupportedException{
        return super.clone();
    }
}
