package designPattern.builder;

/**
 *
 */
public class CivilEngineer {

    private HouseBuilderInterface houseBuilder;

    //construtor with the buidler
    public CivilEngineer(HouseBuilderInterface houseBuilder) {
        this.houseBuilder = houseBuilder;
    }

    public House getHouse() {
        return this.houseBuilder.getHouse();
    }

    public void constructHouse() {
        this.houseBuilder.buildBasement();
        this.houseBuilder.buildStructure();
        this.houseBuilder.buildRoof();
        this.houseBuilder.buildInterior();
    }

}
