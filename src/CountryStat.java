/**
 * Represents one row from your dataset.
 *
 * TODO:
 *  - Rename the class to match your dataset (e.g., Pokemon, StateData, CountryStat)
 *  - Add at least 3 private attributes based on your CSV columns
 *  - Write a constructor that initializes all attributes
 *  - Add getter methods for the attributes you need in your analysis
 *  - Override toString() to display the object's data
 *  - Add Javadoc comments for the class and all methods
 */

public class CountryStat {

    private String country;
    private double healthExp;
    private double infantMortality;

    public CountryStat(String country, double healthExp, double infantMortality)
    {
        this.country = country;
        this.healthExp = healthExp;
        this.infantMortality = infantMortality;
    }


    // TODO: Create a constructor that takes all attributes as parameters


    // TODO: Add getters for attributes you need

    // TODO: Add other data analysis methods

    // TODO: Override toString() to return a readable representation of your object

}