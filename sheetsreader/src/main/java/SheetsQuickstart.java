import com.google.api.client.auth.oauth2.Credential;
import com.google.api.client.extensions.java6.auth.oauth2.AuthorizationCodeInstalledApp;
import com.google.api.client.extensions.jetty.auth.oauth2.LocalServerReceiver;
import com.google.api.client.googleapis.auth.oauth2.GoogleAuthorizationCodeFlow;
import com.google.api.client.googleapis.auth.oauth2.GoogleClientSecrets;
import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.client.util.store.FileDataStoreFactory;
import com.google.api.services.sheets.v4.Sheets;
import com.google.api.services.sheets.v4.SheetsScopes;
import com.google.api.services.sheets.v4.model.ValueRange;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SheetsQuickstart {
    private static final String APPLICATION_NAME = "Google Sheets API Java Quickstart";
    private static final JsonFactory JSON_FACTORY = JacksonFactory.getDefaultInstance();
    private static final String TOKENS_DIRECTORY_PATH = "tokens";

    /**
     * Global instance of the scopes required by this quickstart.
     * If modifying these scopes, delete your previously saved tokens/ folder.
     */
    private static final List<String> SCOPES = Collections.singletonList(SheetsScopes.SPREADSHEETS_READONLY);
    private static final String CREDENTIALS_FILE_PATH = "/credentials.json";

    /**
     * Creates an authorized Credential object.
     * @param HTTP_TRANSPORT The network HTTP Transport.
     * @return An authorized Credential object.
     * @throws IOException If the credentials.json file cannot be found.
     */
    private static Credential getCredentials(final NetHttpTransport HTTP_TRANSPORT) throws IOException {
        // Load client secrets.
        InputStream in = SheetsQuickstart.class.getResourceAsStream(CREDENTIALS_FILE_PATH);
        GoogleClientSecrets clientSecrets = GoogleClientSecrets.load(JSON_FACTORY, new InputStreamReader(in));

        // Build flow and trigger user authorization request.
        GoogleAuthorizationCodeFlow flow = new GoogleAuthorizationCodeFlow.Builder(
                HTTP_TRANSPORT, JSON_FACTORY, clientSecrets, SCOPES)
                .setDataStoreFactory(new FileDataStoreFactory(new java.io.File(TOKENS_DIRECTORY_PATH)))
                .setAccessType("offline")
                .build();
        return new AuthorizationCodeInstalledApp(flow, new LocalServerReceiver()).authorize("user");
    }

    /**
     * Prints the names and majors of students in a sample spreadsheet:
     * https://docs.google.com/spreadsheets/d/1BxiMVs0XRA5nFMdKvBdBZjgmUUqptlbs74OgvE2upms/edit
     */
    public static void main(String... args) throws IOException, GeneralSecurityException {
        // Build a new authorized API client service.
        final NetHttpTransport HTTP_TRANSPORT = GoogleNetHttpTransport.newTrustedTransport();
        final String spreadsheetId = "1JwjcwHRbxiq6T16uxJFP2lEbJl4C0FkH7HVlRqHo_ps";
        final String sunday = "Sheet1!A6:O140";
        final String range = "Sheet1!A1:A14";
        Sheets service = new Sheets.Builder(HTTP_TRANSPORT, JSON_FACTORY, getCredentials(HTTP_TRANSPORT))
                .setApplicationName(APPLICATION_NAME)
                .build();
        ValueRange response = service.spreadsheets().values()
                .get(spreadsheetId, sunday)
                .execute();



        List<List<Object>> values = response.getValues();


        //System.out.println(values);

       // System.out.println(values.size());

       /* for(int i = 0; i < values.size()-1; i++){


            if(values.get(i).size() >= 2) {
                if (values.get(i).get(1).toString().compareTo("") != 0) {
                    System.out.println(values.get(i).get(0));
                }
            }
        }*/
        int stunumb = 76;
       Schedule schedule = new Schedule(values);



        /*
        //sunday
        Station sunChecker = new Station(1,1,1);
        Station sunHearth = new Station(2, 2, 3);
        Station sunSalads = new Station( 2, 2, 2);
        Station sunPeaks = new Station( 1, 1, 1);
        Station sunToast = new Station( 4, 2, 4);
        Station sunMiddie = new Station(0, 2, 2);
        Station sunCurry = new Station( 2, 2, 4);
        Station sunGrange = new Station( 2, 3, 3);
        Station sunDish = new Station( 8, 8 , 9);

        //monday
        Station monChecker = new Station(1,1,1);
        Station monHearth = new Station(2, 2, 3);
        Station monSalads = new Station( 2, 2, 2);
        Station monPeaks = new Station( 1, 1, 1);
        Station monToast = new Station( 4, 2, 4);
        Station monMiddie = new Station(0, 2, 2);
        Station monCurry = new Station( 2, 2, 4);
        Station monagrange = new Station( 2, 3, 3);
        Station monDish = new Station( 8, 8 , 9);

        //tuesday

        Station tuesChecker = new Station(1,1,1);
        Station tuesHearth = new Station(2, 2, 3);
        Station tuesSalads = new Station( 2, 2, 2);
        Station tuesPeaks = new Station( 1, 1, 1);
        Station tuesToast = new Station( 4, 2, 4);
        Station tuesMiddie = new Station(0, 2, 2);
        Station tuesCurry = new Station( 2, 2, 4);
        Station tuesgrange = new Station( 2, 3, 3);
        Station tuesDish = new Station( 8, 8 , 9);

        //wednesday

        Station wedChecker = new Station(1,1,1);
        Station wedHearth = new Station(2, 2, 3);
        Station wedSalads = new Station( 2, 2, 2);
        Station wedPeaks = new Station( 1, 1, 1);
        Station wedToast = new Station( 4, 2, 4);
        Station wedMiddie = new Station(0, 2, 2);
        Station wedCurry = new Station( 2, 2, 6);
        Station wedGrange = new Station( 2, 3, 3);
        Station wedDish = new Station( 8, 8 , 9);


        //thursday
        Station thurChecker = new Station(1,1,1);
        Station thurHearth = new Station(2, 2, 3);
        Station thurSalads = new Station( 2, 2, 2);
        Station thurPeaks = new Station( 1, 1, 1);
        Station thurToast = new Station( 4, 2, 4);
        Station thurMiddie = new Station(0, 2, 2);
        Station thurCurry = new Station( 2, 2, 4);
        Station thurGrange = new Station( 2, 3, 3);
        Station thurDish = new Station( 8, 8 , 9);

        //friday

        Station friChecker = new Station(1,1,1);
        Station friHearth = new Station(2, 2, 3);
        Station friSalads = new Station( 2, 2, 2);
        Station friPeaks = new Station( 1, 1, 1);
        Station friToast = new Station( 4, 2, 4);
        Station friMiddie = new Station(0, 2, 2);
        Station friCurry = new Station( 2, 2, 4);
        Station friGrange = new Station( 2, 3, 3);
        Station friDish = new Station( 8, 8 , 9);
*/
        //saturday

        Station satChecker = new Station(1,1,1, 1, 1, 1);
        Station satHearth = new Station(2, 2, 3, 3, 4, 4);
        Station satSalads = new Station( 2, 2, 2, 3, 4, 4);
        Station satPeaks = new Station( 1, 1, 1, 2, 2, 2);
        Station satToast = new Station( 4, 2, 4, 5, 5, 6);
        Station satMiddie = new Station(0, 2, 2, 1, 3, 4);
        Station satCurry = new Station( 2, 2, 4, 3, 3, 7);
        Station satGrange = new Station( 2, 3, 3, 3, 4, 5);
        Station satDish = new Station( 8, 8 , 9, 8, 10, 10);
        Station satDra = new Station( 2, 2, 2, 3, 3, 3);
        Station satJan = new Station( 2, 2, 2, 3, 3, 3);

        List<Station> satStations = new ArrayList<Station>();
        satStations.add(satChecker);
        satStations.add(satHearth);
        satStations.add(satSalads);
        satStations.add(satPeaks);
        satStations.add(satToast);
        satStations.add(satMiddie);
        satStations.add(satCurry);
        satStations.add(satGrange);
        satStations.add(satDish);
        satStations.add(satDra);
        satStations.add(satJan);

        List<Student> pool = schedule.buildDayPool(13);
        List<List<Student>> bigpool = schedule.buildPool(pool, 13);
        System.out.println(" Morning coverage is: " + bigpool.get(0).size());
        System.out.println(" Mid coverage is: " + bigpool.get(1).size());
        System.out.println(" Dinner coverage is: " + bigpool.get(2).size());


        List<List<List<Student>>> trying = schedule.createDuck(bigpool, satStations );



        for(int i = 0; i < trying.get(8).get(0).size(); i++)
        {
            System.out.println("Morning Dish: " + trying.get(8).get(0).get(i).getName());
        }
        for(int i = 0; i < trying.get(8).get(1).size(); i++)
        {
            System.out.println("Mid Dish: " + trying.get(8).get(1).get(i).getName());
        }
        for(int i = 0; i < trying.get(8).get(2).size(); i++)
        {
            System.out.println("Dinner Dish: " + trying.get(8).get(1).get(i).getName());
        }

        /*

               TODO: Write to document






               TODO: important functinality: dealing with split shifts



         */

        /*

            TODO: how to make people keep their weights for scheduiling stations when the list of students gets updated everytime i run the program. find way to have it update instead of rerun?

                -store weights seperately? *** im thinking store in google sheet, reference based on name. no two students can have same name.
                -or update only new -> could be time intensive :(





         */














    }

    /*
        update schedule
            update sunday
                update B L D
             update monday
            ect.
     */

}