package spaceship;

import java.util.Random;

public abstract class Module implements Device {
    private String name;
    protected boolean isActive;
    private boolean serviceable;

    Module(String _name) {
        name = _name;
        Random random = new Random();
        isActive = false;
        serviceable = random.nextBoolean();
    }

    @Override
    public abstract boolean turnOn();

    @Override
    public abstract boolean turnOff();

    public String getName() {
        return name;
    }

    public boolean isServiceable() {
        return serviceable;
    }

    @Override
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
