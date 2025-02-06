package spaceship;

public class Searchlight extends Module{
    public Searchlight(String name) {
        super(name);
    }

    @Override
    public boolean turnOn() {
        if (isActive) {
            System.out.println(getName() + " уже включен.");
            return false;
        }
        isActive = true;
        System.out.println(getName() + " включен.");
        return true;
    }

    @Override
    public boolean turnOff() {
        if (!isActive) {
            System.out.println(getName() + " уже выключен.");
            return false;
        }
        isActive = false;
        System.out.println(getName() + " выключен.");
        return true;
    }
}
