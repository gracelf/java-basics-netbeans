package lambdaAndfunctionInterfaceAndStream;

/**
 *
 * @author grace.fu
 */
public class Type {

    private long id;
    private String description;
    
    Type(long id, String description){
        this.id = id;
        this.description = description;
    }

    /**
     * @return the id
     */
    public long getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(long id) {
        this.id = id;
    }

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

}
