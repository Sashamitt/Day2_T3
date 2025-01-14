public abstract class Animal {
    private String _name;
    private int _age;

    public Animal(String name, int age) {
        _name = name;
        _age = age;
    }


    public String get_name() {
        return _name;
    }

    public int get_age() {
        return _age;
    }
}
