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

import javax.swing.*;
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

    public Schedule generateList() throws IOException, GeneralSecurityException {
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
        Schedule schedule = new Schedule(values);

        return schedule;
    }

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
        DuckListUI ui = new DuckListUI();
        ResultsUI rui = new ResultsUI();

        JFrame frame = new JFrame("DuckListUI");
        frame.setContentPane(ui.getMainView());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        Schedule schedule = new Schedule( values);
        List<Student> pool = new ArrayList<Student>();
        List<List<Student>> bigpool = new ArrayList<List<Student>>();
        List<List<List<Student>>> trying = new ArrayList<List<List<Student>>>();
        JFrame resultsFrame = new JFrame("ResultsUI");
        resultsFrame.setContentPane(rui.getResultsPanel());
        resultsFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        resultsFrame.pack();

        while(ui.getDay() != -1) {

            System.out.print("");

            if(rui.getExitCode() == 1){
                resultsFrame.setVisible(false);
                frame.setVisible(true);
                ui.setDay(0);
                rui.setExitCode(0);
            }
            if(ui.getDay() == 1){
                Station sunChecker = new Station(0,1,1, 1, 1, 1, 1, 1);
                Station sunHearth = new Station(2, 2, 3 , 1, 1, 1, 1, 1);
                Station sunSalads = new Station( 2, 2, 2, 1, 1, 1, 1, 1);
                Station sunPeaks = new Station( 1, 1, 1, 1, 1, 1, 1, 1);
                Station sunToast = new Station( 4, 2, 4, 1, 1, 1, 1, 1);
                Station sunMiddie = new Station(0, 2, 2, 1, 1, 1, 1, 1);
                Station sunCurry = new Station( 2, 2, 4, 1, 1, 1,1, 1);
                Station sunGrange = new Station( 2, 3, 3,1 ,1 ,1, 1 , 1);
                Station sunDish = new Station( 8, 8 , 9, 1, 1, 1, 1, 1);
                Station sunDra = new Station( 1, 1, 1, 1, 1, 2, 2, 2);
                Station sunJan = new Station( 1, 1, 1, 1, 1, 1, 1, 1);
                Station sunCold = new Station(1, 1, 1, 1, 2, 2, 2, 2);

                List<Station> sunStations = new ArrayList<Station>();
                sunStations.add(sunChecker);
                sunStations.add(sunPeaks);
                sunStations.add(sunHearth);
                sunStations.add(sunSalads);
                sunStations.add(sunToast);
                sunStations.add(sunMiddie);
                sunStations.add(sunCurry);
                sunStations.add(sunGrange);
                sunStations.add(sunDish);
                sunStations.add(sunDra);
                sunStations.add(sunJan);
                sunStations.add(sunCold);
                pool = schedule.buildDayPool(1);
                bigpool = schedule.buildPool(pool, 1);
                trying = schedule.createDuck(bigpool, sunStations);
                schedule.printToSystem(trying, ui.getDay());
                ui.setDay(0);
                List<String> printer = schedule.printToString(trying, 1);
                rui.setMorningDuckList(printer.get(0));
                rui.setMidDuckList(printer.get(1));
                rui.setDinnerDuckList(printer.get(2));
                frame.setVisible(false);
                resultsFrame.setVisible(true);


            }
            if( ui.getDay() == 3){
                Station monChecker = new Station(0,1,1, 1, 1, 1, 1, 1);
                Station monHearth = new Station(2, 2, 3 , 1, 1, 1, 1, 1);
                Station monSalads = new Station( 2, 2, 2, 1, 1, 1, 1, 1);
                Station monPeaks = new Station( 1, 1, 1, 1, 1, 1, 1, 1);
                Station monToast = new Station( 4, 2, 4, 1, 1, 1, 1, 1);
                Station monMiddie = new Station(0, 2, 2, 1, 1, 1, 1, 1);
                Station monCurry = new Station( 2, 2, 4, 1, 1, 1,1, 1);
                Station monGrange = new Station( 2, 3, 3,1 ,1 ,1, 1 , 1);
                Station monDish = new Station( 8, 8 , 9, 1, 1, 1, 1, 1);
                Station monDra = new Station( 1, 1, 1, 1, 1, 2, 2, 2);
                Station monJan = new Station( 1, 1, 1, 1, 1, 1, 1, 1);
                Station monCold = new Station(1, 1, 1, 1, 2, 2, 2, 2);

                List<Station> monStations = new ArrayList<Station>();
                monStations.add(monChecker);
                monStations.add(monPeaks);
                monStations.add(monHearth);
                monStations.add(monSalads);
                monStations.add(monToast);
                monStations.add(monMiddie);
                monStations.add(monCurry);
                monStations.add(monGrange);
                monStations.add(monDish);
                monStations.add(monDra);
                monStations.add(monJan);
                monStations.add(monCold);
                pool = schedule.buildDayPool(3);
                bigpool = schedule.buildPool(pool, 3);
                trying = schedule.createDuck(bigpool, monStations);
                schedule.printToSystem(trying, ui.getDay());
                ui.setDay(0);
                List<String> printer = schedule.printToString(trying, 3);
                rui.setMorningDuckList(printer.get(0));
                rui.setMidDuckList(printer.get(1));
                rui.setDinnerDuckList(printer.get(2));
                frame.setVisible(false);
                resultsFrame.setVisible(true);
            }
            if( ui.getDay() == 5){
                Station tuesChecker = new Station(0,1,1, 1, 1, 1, 1, 1);
                Station tuesHearth = new Station(2, 2, 3 , 1, 1, 1, 1, 1);
                Station tuesSalads = new Station( 2, 2, 2, 1, 1, 1, 1, 1);
                Station tuesPeaks = new Station( 1, 1, 1, 1, 1, 1, 1, 1);
                Station tuesToast = new Station( 4, 2, 4, 1, 1, 1, 1, 1);
                Station tuesMiddie = new Station(0, 2, 2, 1, 1, 1, 1, 1);
                Station tuesCurry = new Station( 2, 2, 4, 1, 1, 1,1, 1);
                Station tuesGrange = new Station( 2, 3, 3,1 ,1 ,1, 1 , 1);
                Station tuesDish = new Station( 8, 8 , 9, 1, 1, 1, 1, 1);
                Station tuesDra = new Station( 1, 1, 1, 1, 1, 2, 2, 2);
                Station tuesJan = new Station( 1, 1, 1, 1, 1, 1, 1, 1);
                Station tuesCold = new Station(1, 1, 1, 1, 2, 2, 2, 2);

                List<Station> tuesStations = new ArrayList<Station>();
                tuesStations.add(tuesChecker);
                tuesStations.add(tuesPeaks);
                tuesStations.add(tuesHearth);
                tuesStations.add(tuesSalads);
                tuesStations.add(tuesToast);
                tuesStations.add(tuesMiddie);
                tuesStations.add(tuesCurry);
                tuesStations.add(tuesGrange);
                tuesStations.add(tuesDish);
                tuesStations.add(tuesDra);
                tuesStations.add(tuesJan);
                tuesStations.add(tuesCold);
                pool = schedule.buildDayPool(5);
                bigpool = schedule.buildPool(pool, 5);
                trying = schedule.createDuck(bigpool, tuesStations);
                schedule.printToSystem(trying, ui.getDay());
                ui.setDay(0);
                List<String> printer = schedule.printToString(trying, 5);
                rui.setMorningDuckList(printer.get(0));
                rui.setMidDuckList(printer.get(1));
                rui.setDinnerDuckList(printer.get(2));
                frame.setVisible(false);
                resultsFrame.setVisible(true);
            }
            if( ui.getDay() == 7){
                Station wedChecker = new Station(0,0,1, 0, 0, 1, 1, 1);
                Station wedHearth = new Station(0, 0, 0, 0, 3, 3,3,3);
                Station wedSalads = new Station( 0, 0, 1, 2, 1, 2,2,2);
                Station wedPeaks = new Station( 0, 0 , 1, 1, 1, 2, 2, 2);
                Station wedToast = new Station( 2, 1, 1, 9, 5, 5, 5, 5);
                Station wedMiddie = new Station(0, 0, 1, 0, 3, 3, 3, 3);
                Station wedCurry = new Station( 0, 3, 4, 0, 6, 7, 7, 9);
                Station wedGrange = new Station( 0, 1, 1, 0, 5, 6, 6, 6);
                Station wedDish = new Station( 1, 1, 6, 10, 10, 15, 15, 15);
                Station wedDra = new Station(0, 0, 0 , 1, 1, 1, 1, 1);
                Station wedJan = new Station(0, 0, 0, 1, 1, 2, 2, 2);
                Station wedCold = new Station(0,1, 1, 1, 2, 2, 2, 2);

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
                pool = schedule.buildDayPool(7);
                bigpool = schedule.buildPool(pool, 7);
                trying = schedule.createDuck(bigpool, wedStations);
                schedule.printToSystem(trying, ui.getDay());
                ui.setDay(0);
                List<String> printer = schedule.printToString(trying, 7);
                rui.setMorningDuckList(printer.get(0));
                rui.setMidDuckList(printer.get(1));
                rui.setDinnerDuckList(printer.get(2));
                frame.setVisible(false);
                resultsFrame.setVisible(true);
            }
            if( ui.getDay() == 9){
                Station thurChecker = new Station(0,1,1, 1, 1, 1, 1, 1);
                Station thurHearth = new Station(2, 2, 3 , 1, 1, 1, 1, 1);
                Station thurSalads = new Station( 2, 2, 2, 1, 1, 1, 1, 1);
                Station thurPeaks = new Station( 1, 1, 1, 1, 1, 1, 1, 1);
                Station thurToast = new Station( 4, 2, 4, 1, 1, 1, 1, 1);
                Station thurMiddie = new Station(0, 2, 2, 1, 1, 1, 1, 1);
                Station thurCurry = new Station( 2, 2, 4, 1, 1, 1,1, 1);
                Station thurGrange = new Station( 2, 3, 3,1 ,1 ,1, 1 , 1);
                Station thurDish = new Station( 8, 8 , 9, 1, 1, 1, 1, 1);
                Station thurDra = new Station( 1, 1, 1, 1, 1, 2, 2, 2);
                Station thurJan = new Station( 1, 1, 1, 1, 1, 1, 1, 1);
                Station thurCold = new Station(1, 1, 1, 1, 2, 2, 2, 2);

                List<Station> thurStations = new ArrayList<Station>();
                thurStations.add(thurChecker);
                thurStations.add(thurPeaks);
                thurStations.add(thurHearth);
                thurStations.add(thurSalads);
                thurStations.add(thurToast);
                thurStations.add(thurMiddie);
                thurStations.add(thurCurry);
                thurStations.add(thurGrange);
                thurStations.add(thurDish);
                thurStations.add(thurDra);
                thurStations.add(thurJan);
                thurStations.add(thurCold);
                pool = schedule.buildDayPool(9);
                bigpool = schedule.buildPool(pool, 9);
                trying = schedule.createDuck(bigpool, thurStations);
                schedule.printToSystem(trying, ui.getDay());
                ui.setDay(0);
                List<String> printer = schedule.printToString(trying, 9);
                rui.setMorningDuckList(printer.get(0));
                rui.setMidDuckList(printer.get(1));
                rui.setDinnerDuckList(printer.get(2));
                frame.setVisible(false);
                resultsFrame.setVisible(true);
            }
            if( ui.getDay() == 11){
                Station friChecker = new Station(0,1,1, 1, 1, 1, 1, 1);
                Station friHearth = new Station(2, 2, 3 , 1, 1, 1, 1, 1);
                Station friSalads = new Station( 2, 2, 2, 1, 1, 1, 1, 1);
                Station friPeaks = new Station( 1, 1, 1, 1, 1, 1, 1, 1);
                Station friToast = new Station( 4, 2, 4, 1, 1, 1, 1, 1);
                Station friMiddie = new Station(0, 2, 2, 1, 1, 1, 1, 1);
                Station friCurry = new Station( 2, 2, 4, 1, 1, 1,1, 1);
                Station friGrange = new Station( 2, 3, 3,1 ,1 ,1, 1 , 1);
                Station friDish = new Station( 8, 8 , 9, 1, 1, 1, 1, 1);
                Station friDra = new Station( 1, 1, 1, 1, 1, 2, 2, 2);
                Station friJan = new Station( 1, 1, 1, 1, 1, 1, 1, 1);
                Station friCold = new Station(1, 1, 1, 1, 2, 2, 2, 2);

                List<Station> friStations = new ArrayList<Station>();
                friStations.add(friChecker);
                friStations.add(friPeaks);
                friStations.add(friHearth);
                friStations.add(friSalads);
                friStations.add(friToast);
                friStations.add(friMiddie);
                friStations.add(friCurry);
                friStations.add(friGrange);
                friStations.add(friDish);
                friStations.add(friDra);
                friStations.add(friJan);
                friStations.add(friCold);
                pool = schedule.buildDayPool(11);
                bigpool = schedule.buildPool(pool, 11);
                trying = schedule.createDuck(bigpool, friStations);
                schedule.printToSystem(trying, ui.getDay());
                ui.setDay(0);
                List<String> printer = schedule.printToString(trying, 11);
                rui.setMorningDuckList(printer.get(0));
                rui.setMidDuckList(printer.get(1));
                rui.setDinnerDuckList(printer.get(2));
                frame.setVisible(false);
                resultsFrame.setVisible(true);
            }
            if( ui.getDay() == 13){
                Station satChecker = new Station(0,1,1, 1, 1, 1, 1, 1);
                Station satHearth = new Station(2, 2, 3 , 1, 1, 1, 1, 1);
                Station satSalads = new Station( 2, 2, 2, 1, 1, 1, 1, 1);
                Station satPeaks = new Station( 1, 1, 1, 1, 1, 1, 1, 1);
                Station satToast = new Station( 4, 2, 4, 1, 1, 1, 1, 1);
                Station satMiddie = new Station(0, 2, 2, 1, 1, 1, 1, 1);
                Station satCurry = new Station( 2, 2, 4, 1, 1, 1,1, 1);
                Station satGrange = new Station( 2, 3, 3,1 ,1 ,1, 1 , 1);
                Station satDish = new Station( 8, 8 , 9, 1, 1, 1, 1, 1);
                Station satDra = new Station( 1, 1, 1, 1, 1, 2, 2, 2);
                Station satJan = new Station( 1, 1, 1, 1, 1, 1, 1, 1);
                Station satCold = new Station(1, 1, 1, 1, 2, 2, 2, 2);

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
                satStations.add(satCold);
                pool = schedule.buildDayPool(13);
                bigpool = schedule.buildPool(pool, 13);
                trying = schedule.createDuck(bigpool, satStations);
                schedule.printToSystem(trying, ui.getDay());
                ui.setDay(0);
                List<String> printer = schedule.printToString(trying, 13);
                rui.setMorningDuckList(printer.get(0));
                rui.setMidDuckList(printer.get(1));
                rui.setDinnerDuckList(printer.get(2));
                frame.setVisible(false);
                resultsFrame.setVisible(true);
            }
        }
        System.exit(0);
        //System.out.println(values);

       // System.out.println(values.size());

       /* for(int i = 0; i < values.size()-1; i++){


            if(values.get(i).size() >= 2) {
                if (values.get(i).get(1).toString().compareTo("") != 0) {
                    System.out.println(values.get(i).get(0));
                }
            }
        }*/
     /*   int stunumb = 76;
       Schedule schedule = new Schedule(values);




        /*

               TODO: Write to document




                              Weekend   -> start at 12 or later


               TODO: important functinality: dealing with split shifts



         */

        /*

            TODO: how to make people keep their weights for scheduiling stations when the list of students gets updated everytime i run the program. find way to have it update instead of rerun?

                -store weights seperately? *** im thinking store in google sheet, reference based on name. no two students can have same name.
                -or update only new -> could be time intensive :(





         */














    }








}