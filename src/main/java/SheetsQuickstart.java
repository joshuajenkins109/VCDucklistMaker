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
        final String sunday = "Sheet1!A6:O165";
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
*/
        //monday
        Station monChecker = new Station(0,1,1, 0, 1, 1);
        Station monHearth = new Station(0, 0, 0, 0, 3, 3);
        Station monSalads = new Station( 0, 0, 1, 2, 1, 2);
        Station monPeaks = new Station( 0, 0, 1, 1, 1, 2);
        Station monToast = new Station( 2, 1, 1, 9, 5, 5);
        Station monMiddie = new Station(0, 0, 1, 0, 3, 3);
        Station monCurry = new Station( 0, 1, 1, 0, 5, 6);
        Station mongrange = new Station( 0, 1, 1, 0, 5, 6);
        Station monDish = new Station( 1, 1 , 6, 10, 10, 15);
        Station monDra = new Station(0, 0, 0 , 1, 1, 1);
        Station monJan = new Station(0, 0, 0, 1, 1, 2);

        List<Station> monStations = new ArrayList<Station>();
        monStations.add(monChecker);
        monStations.add(monHearth);
        monStations.add(monSalads);
        monStations.add(monPeaks);
        monStations.add(monToast);
        monStations.add(monMiddie);
        monStations.add(monCurry);
        monStations.add(mongrange);
        monStations.add(monDish);
        monStations.add(monDra);
        monStations.add(monJan);
/*
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
*/
        //wednesday

        Station wedChecker = new Station(0,0,1, 0, 0, 1);
        Station wedHearth = new Station(0, 0, 0, 0, 3, 3);
        Station wedSalads = new Station( 0, 0, 1, 2, 1, 2);
        Station wedPeaks = new Station( 0, 0 , 1, 1, 1, 2);
        Station wedToast = new Station( 2, 1, 1, 9, 5, 5);
        Station wedMiddie = new Station(0, 0, 1, 0, 3, 3);
        Station wedCurry = new Station( 0, 3, 4, 0, 6, 7);
        Station wedGrange = new Station( 0, 1, 1, 0, 5, 6);
        Station wedDish = new Station( 1, 1, 6, 10, 10, 15);
        Station wedDra = new Station(0, 0, 0 , 1, 1, 1);
        Station wedJan = new Station(0, 0, 0, 1, 1, 2);
        Station wedCold = new Station(0,1, 1, 1, 2, 2);

        List<Station> wedStations = new ArrayList<Station>();
        wedStations.add(wedChecker);
        wedStations.add(wedPeaks);
        wedStations.add(wedHearth);
        wedStations.add(wedSalads);
        wedStations.add(wedToast);
        wedStations.add(wedMiddie);
        wedStations.add(wedCurry);
        wedStations.add(wedGrange);
        wedStations.add(wedDish);
        wedStations.add(wedDra);
        wedStations.add(wedJan);
        wedStations.add(wedCold);
/*

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
        satStations.add(satPeaks);
        satStations.add(satHearth);
        satStations.add(satSalads);
        satStations.add(satToast);
        satStations.add(satMiddie);
        satStations.add(satCurry);
        satStations.add(satGrange);
        satStations.add(satDish);
        satStations.add(satDra);
        satStations.add(satJan);

        int day = 13;

        List<Student> pool = schedule.buildDayPool(day);
        List<List<Student>> bigpool = schedule.buildPool(pool, day);
        System.out.println(" Morning coverage is: " + bigpool.get(0).size());
        System.out.println(" Mid coverage is: " + bigpool.get(1).size());
        System.out.println(" Dinner coverage is: " + bigpool.get(2).size());

    /*
        List<List<List<Student>>> trying = schedule.createDuck(bigpool, wedStations );





        System.out.println("Morning");
        System.out.print("Checker: ");
        for(int i = 0; i < trying.get(0).get(0).size(); i++)
        {
            System.out.print(trying.get(0).get(0).get(i).getName() + trying.get(0).get(0).get(i).getSchedule().get(day) + "-" + trying.get(0).get(0).get(i).getSchedule().get(day+1) + ", ");
        }
        System.out.println("");
        System.out.print("Peaks: ");
        for(int i = 0; i < trying.get(1).get(0).size(); i++)
        {
            System.out.print(trying.get(1).get(0).get(i).getName() + trying.get(1).get(0).get(i).getSchedule().get(day) + "-" + trying.get(1).get(0).get(i).getSchedule().get(day+1) + ", ");
        }
        System.out.println("");
        System.out.print("Hearth: ");
        for(int i = 0; i < trying.get(2).get(0).size(); i++)
        {
            System.out.print(trying.get(2).get(0).get(i).getName() + trying.get(2).get(0).get(i).getSchedule().get(day) + "-" + trying.get(2).get(0).get(i).getSchedule().get(day+1) +", ");
        }
        System.out.println("");
        System.out.print("Salads: ");
        for(int i = 0; i < trying.get(3).get(0).size(); i++)
        {
            System.out.print(trying.get(3).get(0).get(i).getName() +trying.get(3).get(0).get(i).getSchedule().get(day) + "-" + trying.get(3).get(0).get(i).getSchedule().get(day+1) + ", ");
        }
        System.out.println("");
        System.out.print("Toast: ");
        for(int i = 0; i < trying.get(4).get(0).size(); i++)
        {
            System.out.print(trying.get(4).get(0).get(i).getName() +trying.get(4).get(0).get(i).getSchedule().get(day) + "-" + trying.get(4).get(0).get(i).getSchedule().get(day+1) + ", ");
        }
        System.out.println("");
        System.out.print("Mid: ");
        for(int i = 0; i < trying.get(5).get(0).size(); i++)
        {
            System.out.print(trying.get(5).get(0).get(i).getName() +trying.get(5).get(0).get(i).getSchedule().get(day) + "-" + trying.get(5).get(0).get(i).getSchedule().get(day+1) + ", ");
        }
        System.out.println("");
        System.out.print("Curry: ");
        for(int i = 0; i < trying.get(6).get(0).size(); i++)
        {
            System.out.print(trying.get(6).get(0).get(i).getName() + trying.get(6).get(0).get(i).getSchedule().get(day) + "-" + trying.get(6).get(0).get(i).getSchedule().get(day+1) +", ");
        }
        System.out.println("");
        System.out.print("Grange: ");
        for(int i = 0; i < trying.get(7).get(0).size(); i++)
        {
            System.out.print(trying.get(7).get(0).get(i).getName() + trying.get(7).get(0).get(i).getSchedule().get(day) + "-" + trying.get(7).get(0).get(i).getSchedule().get(day+1) +", ");
        }
        System.out.println("");
        System.out.print("Dish: ");
        for(int i = 0; i < trying.get(8).get(0).size(); i++)
        {
            System.out.print(trying.get(8).get(0).get(i).getName() + trying.get(8).get(0).get(i).getSchedule().get(day) + "-" + trying.get(8).get(0).get(i).getSchedule().get(day+1) +", ");
        }
        System.out.println("");
        System.out.print("Dra: ");
        for(int i = 0; i < trying.get(9).get(0).size(); i++)
        {
            System.out.print(trying.get(9).get(0).get(i).getName() + trying.get(9).get(0).get(i).getSchedule().get(day) + "-" + trying.get(9).get(0).get(i).getSchedule().get(day+1) +", ");
        }
        System.out.println("");
        System.out.print("Janitor: ");
        for(int i = 0; i < trying.get(10).get(0).size(); i++)
        {
            System.out.print(trying.get(10).get(0).get(i).getName() + trying.get(10).get(0).get(i).getSchedule().get(day) + "-" + trying.get(10).get(0).get(i).getSchedule().get(day+1) +", ");
        }
        System.out.println("");
        System.out.println("Mid");
        System.out.print("Checker: ");
        for(int i = 0; i < trying.get(0).get(1).size(); i++)
        {
            System.out.print(trying.get(0).get(1).get(i).getName() + trying.get(0).get(1).get(i).getSchedule().get(day) + "-" + trying.get(0).get(1).get(i).getSchedule().get(day+1) +", ");
        }
        System.out.println("");
        System.out.print("Peaks: ");
        for(int i = 0; i < trying.get(1).get(1).size(); i++)
        {
            System.out.print(trying.get(1).get(1).get(i).getName() + trying.get(1).get(1).get(i).getSchedule().get(day) + "-" + trying.get(1).get(1).get(i).getSchedule().get(day+1) + ", ");
        }
        System.out.println("");
        System.out.print("Hearth: ");
        for(int i = 0; i < trying.get(2).get(1).size(); i++)
        {
            System.out.print(trying.get(2).get(1).get(i).getName() + trying.get(2).get(1).get(i).getSchedule().get(day) + "-" + trying.get(2).get(1).get(i).getSchedule().get(day+1) + ", ");
        }
        System.out.println("");
        System.out.print("Salads: ");
        for(int i = 0; i < trying.get(3).get(1).size(); i++)
        {
            System.out.print(trying.get(3).get(1).get(i).getName() + trying.get(3).get(1).get(i).getSchedule().get(day) + "-" + trying.get(3).get(1).get(i).getSchedule().get(day+1) +", ");
        }
        System.out.println("");
        System.out.print("Toast: ");
        for(int i = 0; i < trying.get(4).get(1).size(); i++)
        {
            System.out.print(trying.get(4).get(1).get(i).getName() + trying.get(4).get(1).get(i).getSchedule().get(day) + "-" + trying.get(4).get(1).get(i).getSchedule().get(day+1) + ", ");
        }
        System.out.println("");
        System.out.print("Mid: ");
        for(int i = 0; i < trying.get(5).get(1).size(); i++)
        {
            System.out.print(trying.get(5).get(1).get(i).getName() +trying.get(5).get(1).get(i).getSchedule().get(day) + "-" + trying.get(5).get(1).get(i).getSchedule().get(day+1) + ", ");
        }
        System.out.println("");
        System.out.print("Curry: ");
        for(int i = 0; i < trying.get(6).get(1).size(); i++)
        {
            System.out.print(trying.get(6).get(1).get(i).getName() + trying.get(6).get(1).get(i).getSchedule().get(day) + "-" + trying.get(6).get(1).get(i).getSchedule().get(day+1) +", ");
        }
        System.out.println("");
        System.out.print("Grange: ");
        for(int i = 0; i < trying.get(7).get(1).size(); i++)
        {
            System.out.print(trying.get(7).get(1).get(i).getName() +trying.get(7).get(1).get(i).getSchedule().get(day) + "-" + trying.get(7).get(1).get(i).getSchedule().get(day+1) + ", ");
        }
        System.out.println("");
        System.out.print("Dish: ");
        for(int i = 0; i < trying.get(8).get(1).size(); i++)
        {
            System.out.print(trying.get(8).get(1).get(i).getName() + trying.get(8).get(1).get(i).getSchedule().get(day) + "-" + trying.get(8).get(1).get(i).getSchedule().get(day+1) +", ");
        }
        System.out.println("");
        System.out.print("Dra: ");
        for(int i = 0; i < trying.get(9).get(1).size(); i++)
        {
            System.out.print(trying.get(9).get(1).get(i).getName() + trying.get(9).get(1).get(i).getSchedule().get(day) + "-" + trying.get(9).get(1).get(i).getSchedule().get(day+1) +", ");
        }
        System.out.println("");
        System.out.print("Janitor: ");
        for(int i = 0; i < trying.get(10).get(1).size(); i++)
        {
            System.out.print(trying.get(10).get(1).get(i).getName() +trying.get(10).get(1).get(i).getSchedule().get(day) + "-" + trying.get(10).get(1).get(i).getSchedule().get(day+1) + ", ");
        }
        System.out.println("");
        System.out.println("Dinner");
        System.out.print("Checker: ");
        for(int i = 0; i < trying.get(0).get(2).size(); i++)
        {
            System.out.print(trying.get(0).get(2).get(i).getName() + trying.get(0).get(2).get(i).getSchedule().get(day) + "-" + trying.get(0).get(2).get(i).getSchedule().get(day+1) + ", ");
        }
        System.out.println("");
        System.out.print("Peaks: ");
        for(int i = 0; i < trying.get(1).get(2).size(); i++)
        {
            System.out.print(trying.get(1).get(2).get(i).getName() + trying.get(1).get(2).get(i).getSchedule().get(day) + "-" + trying.get(1).get(2).get(i).getSchedule().get(day+1) +", ");
        }
        System.out.println("");
        System.out.print("Hearth: ");
        for(int i = 0; i < trying.get(2).get(2).size(); i++)
        {
            System.out.print(trying.get(2).get(2).get(i).getName() +trying.get(2).get(2).get(i).getSchedule().get(day) + "-" + trying.get(2).get(2).get(i).getSchedule().get(day+1) + ", ");
        }
        System.out.println("");
        System.out.print("Salads: ");
        for(int i = 0; i < trying.get(3).get(2).size(); i++)
        {
            System.out.print(trying.get(3).get(2).get(i).getName() + trying.get(3).get(2).get(i).getSchedule().get(day) + "-" + trying.get(3).get(2).get(i).getSchedule().get(day+1) +", ");
        }
        System.out.println("");
        System.out.print("Toast: ");
        for(int i = 0; i < trying.get(4).get(2).size(); i++)
        {
            System.out.print(trying.get(4).get(2).get(i).getName() + trying.get(4).get(2).get(i).getSchedule().get(day) + "-" + trying.get(4).get(2).get(i).getSchedule().get(day+1) +", ");
        }
        System.out.println("");
        System.out.print("Mid: ");
        for(int i = 0; i < trying.get(5).get(2).size(); i++)
        {
            System.out.print(trying.get(5).get(2).get(i).getName() + trying.get(5).get(2).get(i).getSchedule().get(day) + "-" + trying.get(5).get(2).get(i).getSchedule().get(day+1) +", ");
        }
        System.out.println("");
        System.out.print("Curry: ");
        for(int i = 0; i < trying.get(6).get(2).size(); i++)
        {
            System.out.print(trying.get(6).get(2).get(i).getName() + trying.get(6).get(2).get(i).getSchedule().get(day) + "-" + trying.get(6).get(2).get(i).getSchedule().get(day+1) +", ");
        }
        System.out.println("");
        System.out.print("Grange: ");
        for(int i = 0; i < trying.get(7).get(2).size(); i++)
        {
            System.out.print(trying.get(7).get(2).get(i).getName() + trying.get(7).get(2).get(i).getSchedule().get(day) + "-" + trying.get(7).get(2).get(i).getSchedule().get(day+1) +", ");
        }
        System.out.println("");
        System.out.print("Dish: ");
        for(int i = 0; i < trying.get(8).get(2).size(); i++)
        {
            System.out.print(trying.get(8).get(2).get(i).getName() +trying.get(8).get(2).get(i).getSchedule().get(day) + "-" + trying.get(8).get(2).get(i).getSchedule().get(day+1) + ", ");
        }
        System.out.println("");
        System.out.print("Dra: ");
        for(int i = 0; i < trying.get(9).get(2).size(); i++)
        {
            System.out.print(trying.get(9).get(2).get(i).getName() +trying.get(9).get(2).get(i).getSchedule().get(day) + "-" + trying.get(9).get(2).get(i).getSchedule().get(day+1) + ", ");
        }
        System.out.println("");
        System.out.print("Janitor: ");
        for(int i = 0; i < trying.get(10).get(2).size(); i++)
        {
            System.out.print(trying.get(10).get(2).get(i).getName() +trying.get(10).get(2).get(i).getSchedule().get(day) + "-" + trying.get(10).get(2).get(i).getSchedule().get(day+1) + ", ");
        }
*/
        /*

               TODO: Write to document

                TODO: Make sure things are ordered correctly

               TODO: Split mid into two -> start at 11 or later -> second mid day
                              Weekend   -> start at 12 or later


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