package zulus.lab2.wesite;

/**
 * Created by zulus on 22.02.18
 */

/**
 * defines Visitor of service
 */
public class Visitor {
    private String _name;
    private int _age;

    /**
     * Create new Visitor with specified name and age
     *
     * @param name name if client
     * @param age  value of visitor's age
     */
    public Visitor(String name, int age) {
        setName(name);
        setAge(age);
    }

    /**
     * get name of client
     *
     * @return name of client
     */
    public String getName() {
        return _name;
    }

    /**
     * set name of client
     *
     * @param name value of name of client
     */
    public void setName(String name) {
        this._name = name;
    }

    /**
     * get age of visitor
     *
     * @return age of visitor
     */
    public double getAge() {
        return _age;
    }

    /**
     * set value of visitor's age
     *
     * @param age new value of visitor's age
     */
    private void setAge(int age) {
        if (age < 0) throw new IllegalArgumentException("Age must be positive number");
        this._age = age;
    }

}
