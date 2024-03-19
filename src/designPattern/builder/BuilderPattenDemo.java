package designPattern.builder;

/**
 * ref https://www.geeksforgeeks.org/builder-design-pattern/
 */
public class BuilderPattenDemo {

    public static void main(String[] args) {
        HouseBuilderInterface iglooBuilder = new IglooHouseBuilder();
        CivilEngineer engineer = new CivilEngineer(iglooBuilder);
        engineer.constructHouse();
        House house = engineer.getHouse();

        System.out.println("Builder constructed: " + house);
    }

}
