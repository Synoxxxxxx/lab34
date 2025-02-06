package spaceship;

import exceptions.pilotMissingException;
import human.Human;
import human.Profession;

public class Spaceship implements SpaceApparatus{
    private final String name;

    private int speed = 0;
    private final Human[] crew;
    private final Module[] modules = new Module[8];

    public Spaceship(String name, int capacity) {
        this.name = name;
        crew = new Human[capacity];
    }

    public boolean addMember(Human human) {
        for (int i = 0; i < 8; i++) {
            if (crew[i] == null) {
                crew[i] = human;
                return true;
            }
        }
        return false;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean connectModule(Module module) {
        for (int i = 0; i < 8; i++) {
            if (modules[i] == null) {
                modules[i] = module;
                return true;
            }
        }
        return false;
    }

    public boolean takeOff() throws pilotMissingException {
        for (Human member : crew) {
            if (member != null && member.getProfession() == Profession.PILOT) {
                System.out.println("Космический корабль " + name + " успешно взлетел.");
                return true;
            }
        }
        throw new pilotMissingException(name);
    }

    public int checkSpeed() {
        for (int i = 0; i < 8; i++) {
            if (modules[i] != null) {
                if (modules[i].isActive) {
                    speed += 15;
                } else {
                    System.out.println("Модуль " + modules[i].getName() + " отключен, корабль " + this.getName() + " не может развивать скорость без него.");
                    speed = 0;
                    break;
                }
            }
        }
        return speed;
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
