package designPattern.builder.builderMethod;

/**
 *
 */
public class StudentBuilder {
    // instance fields

    private int id;
    private String name;
    private String address;

    // No Setter Methods, pass on builder as paramter to create the student object
    public StudentBuilder(Builder builder) {
        this.id = builder.id;
        this.name = builder.name;
        this.address = builder.address;
    }

    @Override
    public String toString() {
        return "id = " + this.id + ", name = " + this.name
                + ", address = " + this.address;
    }

    public static class Builder {

        /// instance fields
        private int id;
        private String name;
        private String address;

        public static Builder newInstance() {
            return new Builder();
        }

        //private constructor
        // Setter methods
        private Builder() {
        }

        public Builder setId(int id) {
            this.id = id;
            return this;
        }

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Builder setAddress(String address) {
            this.address = address;
            return this;
        }

        public StudentBuilder build() {
            //pass on Bulder object as an paramter to create Student object
            System.out.println(this.getClass().getSimpleName() + ": " +  this.address + this.name);
            return new StudentBuilder(this);
        }

    }

}
