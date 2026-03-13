import java.io.File;
import java.util.Scanner;

public class App {

    public static void main(String[] args) throws Exception {

        File file = new File("WorldIndicators2000.csv");
        Scanner scan = new Scanner(file);

        CountryStat[] stats = new CountryStat[2705];

        int count = 0;

        // Skip header line
        scan.nextLine();

        while (scan.hasNextLine() && count < stats.length)
        {
            String line = scan.nextLine();
            String[] parts = line.split(",");

            //checking if there are blank values
            if (!parts[0].equals("") && !parts[8].equals("") && !parts[12].equals(""))
            {
                String country = parts[0];
                double healthExp = Double.parseDouble(parts[8]);
                double infantMortality = Double.parseDouble(parts[12]);

                CountryStat s = new CountryStat(country, healthExp, infantMortality);

                stats[count] = s;
                count++;
            }
        }

        scan.close();

        System.out.println("Rows loaded: " + count);

        double r = correlation(stats, count);

        System.out.println("Correlation coefficient: " + r);

        printInterpretation(r);
        System.out.println("The country with the highest infant mortality rates is: " +  highestInfantMortality(stats, count) );
       



    }

    /**
     * Calculates which country has the higher infant mortality rate
     * @param stats
     * @return the country with the highest infant mortality
     */

    public static String highestInfantMortality(CountryStat[] stats, int count)
{
    double max = stats[0].getInfantMortality();
    int index = 0;

    for(int i = 0; i < count; i++)
    {
        if(stats[i].getInfantMortality() > max)
        {
            max = stats[i].getInfantMortality();
            index = i;
        }
    }

    return stats[index].getCountry();
}
    /**
     * Calculates the correlation coefficient
     * between health expenditure and infant mortality.
     * @param stats array
     * @param count
     * @return the r value
     */
    
    public static double correlation(CountryStat[] stats, int count)
    {
        double sumX = 0;
        double sumY = 0;
        double sumXY = 0;
        double sumX2 = 0;
        double sumY2 = 0;

        for (int i = 0; i < count; i++)
        {
            double x = stats[i].getHealthExp();
            double y = stats[i].getInfantMortality();

            sumX += x;
            sumY += y;
            sumXY += x * y;
            sumX2 += x * x;
            sumY2 += y * y;
        }

        double numerator = count * sumXY - sumX * sumY;

        double denominator = Math.sqrt(
                (count * sumX2 - sumX * sumX) *
                (count * sumY2 - sumY * sumY)
        );

        return numerator / denominator;
    }


    
    public static void printInterpretation(double r)
    {
        System.out.println();

        if (r > 0.7)
        {
            System.out.println("Strong positive correlation.");
        }
        else if (r > 0.4)
        {
            System.out.println("Moderate positive correlation.");
        }
        else if (r > 0.1)
        {
            System.out.println("Weak positive correlation.");
        }
        else if (r > -0.1)
        {
            System.out.println("Little to no correlation.");
        }
        else if (r > -0.4)
        {
            System.out.println("Weak negative correlation.");
        }
        else if (r > -0.7)
        {
            System.out.println("Moderate negative correlation.");
        }
        else
        {
            System.out.println("Strong negative correlation.");
        }
    }
}