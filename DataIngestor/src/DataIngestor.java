import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

public class DataIngestor {
    private static final String BASE_URL = "https://api.worldofwarships.%s/wows/account/statsbydate/?application_id=%s";
    private static final String RU_EXT = "ru";
    private static final String EU_EXT = "eu";
    private static final String NA_EXT = "com";
    private static final String ASIA_EXT = "asia";
    private static final String BAD_INPUT_MSG = "User did not enter an integer between 1 and 4, inclusive.";
    private static final String BAD_URL_MSG = "Bad url.";

    public static void main(String[] args)
    {
        Scanner userInputScanner = new Scanner(System.in);
        System.out.print("Enter app id: ");
        String appID = userInputScanner.next();
        System.out.println("Enter The corresponding number for your region.\n" +
                "(1) RU\n(2) EU\n(3) NA \n(4) asia");
        int userInput = userInputScanner.nextInt();
        userInputScanner.close();
        String queryURL = BASE_URL;
        try
        {
            if (userInput == 1)
            {
                queryURL = String.format(queryURL, RU_EXT, appID);
            }
            else if (userInput == 2)
            {
                queryURL = String.format(queryURL, EU_EXT, appID);
            }
            else if (userInput == 3)
            {
                queryURL = String.format(queryURL, NA_EXT, appID);
            }
            else if (userInput == 4)
            {
                queryURL = String.format(queryURL, ASIA_EXT, appID);
            }
            else
            {
                throw new IllegalArgumentException(BAD_INPUT_MSG);
            }
        }
        catch (IllegalArgumentException e)
        {
            System.err.println(BAD_INPUT_MSG);
            return;
        }
        try
        {
            URL url = new URL(queryURL);
        }
        catch (MalformedURLException e)
        {
            System.err.println(BAD_URL_MSG);
        }
    }
}
