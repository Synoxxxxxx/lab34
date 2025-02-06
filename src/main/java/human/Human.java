package human;

public class Human {
    private final String name;
    private final Profession profession;

    public Human(String name, Profession profession) {
        this.name = name;
        this.profession = profession;
    }


    public String getName() {
        return name;
    }

    public Profession getProfession() {
        return profession;
    }

    public String toString() {
        return getClass() + getName();
    }

    @Override
    public int hashCode() {
        return 413483 * getName().hashCode() % 100;
    }

    @Override
    public boolean equals(Object object){
        if (!(object instanceof Module)) return false;

        return hashCode() == object.hashCode();
    }
}
