import exceptions.moduleDefectiveException;
import exceptions.pilotMissingException;
import human.Human;
import human.Profession;
import space.Galaxy;
import spaceship.Searchlight;
import spaceship.Spaceship;
import spaceship.WeightlessnessDevice;

public class Main {
    public static void main(String[] args) {
        System.out.println("Ускорение свободного падения на Земле равно " +
                Galaxy.PhysicsLaws.calculateFreeFallAcceleration(5.97E24, 6378.1) + "\n");

        Galaxy milkyWay = new Galaxy("Млечный путь");
        Galaxy.PlanetarySystem solarSystem = milkyWay.new PlanetarySystem("Солнечная система");

        System.out.println(milkyWay.getGalaxyName());
        System.out.println(solarSystem.getPlanetarySystemName());
        milkyWay.destroyGalaxy();
        System.out.println(milkyWay.getGalaxyName() + "\n");
        milkyWay = null;
        solarSystem = null;

        Human znaika = new Human("Знайка", Profession.PILOT);
        Human neznaika = new Human("Незнайка", Profession.SPY);

        Spaceship spaceship = new Spaceship("Восток-1", 2);

        WeightlessnessDevice weightlessnessDevice = new WeightlessnessDevice("Прибор невесомости");
        Searchlight searchlight = new Searchlight("Главный прожектор");

        spaceship.addMember(neznaika);
        spaceship.connectModule(weightlessnessDevice);
        spaceship.connectModule(searchlight);

        try {
            weightlessnessDevice.turnOn();
        } catch (moduleDefectiveException e) {
            System.out.println(e.getMessage());
        }
        searchlight.turnOn();

        try {
            spaceship.takeOff();
        } catch (pilotMissingException e) {
            System.out.println(e.getMessage());
        }

        spaceship.addMember(znaika);

        try {
            spaceship.takeOff();
        } catch (pilotMissingException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("Скорость корабля " + spaceship.getName() + " равна " + spaceship.checkSpeed());
        searchlight.turnOn();
        searchlight.turnOff();
        System.out.println("Скорость корабля " + spaceship.getName() + " равна " + spaceship.checkSpeed());
    }
}