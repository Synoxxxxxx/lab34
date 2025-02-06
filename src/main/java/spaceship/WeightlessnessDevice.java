package spaceship;

import exceptions.moduleDefectiveException;

public class WeightlessnessDevice extends Module{
    public WeightlessnessDevice(String name) {
        super(name);
    }

    @Override
    public boolean turnOn() throws moduleDefectiveException {
        if (isServiceable()) {
            if (isActive) {
                System.out.println(getName() + " уже включен.");
                return false;
            }
            isActive = true;
            System.out.println(getName() + " включен.");
            return true;
        } else {
            throw new moduleDefectiveException(getName());
        }
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
