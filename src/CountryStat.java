
/**
 * Creates a class for the country stat
 */
public class CountryStat {

    //initializes attributes
    private String country;
    private double healthExp;
    private double infantMortality;

    /**
     * Constructor for CountryStat
     * @param country
     * @param healthExp
     * @param infantMortality
     */
    public CountryStat(String country, double healthExp, double infantMortality)
    {
        this.country = country;
        this.healthExp = healthExp;
        this.infantMortality = infantMortality;
    }

    //getters

    /**
     * Getter for country
     * @return country
     */
    public String getCountry()
    {
        return country;
    }

    /**
     * Getter for healthExp
     * @return healthExp
     */
    public double getHealthExp()
    {
        return healthExp;
    }

    /**
     * Getter for infantMortality
     * @return infantMortality
     */
    public double getInfantMortality()
    {
        return infantMortality;
    }



    @Override

    /**
     * toString method
     * @return string of toString
     */
    public String toString()
    {
        return country + " has a " + infantMortality + " infant mortality rate and health expenditures make up " + healthExp + " of GDP.";
    }




}