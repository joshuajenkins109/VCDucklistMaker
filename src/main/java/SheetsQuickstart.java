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






    public static void main(String... args) throws IOException, GeneralSecurityException {

        SheetsCommunicator sheet = new SheetsCommunicator();
        DuckListUI ui = new DuckListUI();
        ResultsUI rui = new ResultsUI();
        CoverageUI cui = new CoverageUI();

        JFrame frame = new JFrame("DuckListUI");
        frame.setContentPane(ui.getMainView());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        Schedule schedule = sheet.generateList();
        List<Student> pool = new ArrayList<Student>();
        List<List<Student>> bigpool = new ArrayList<List<Student>>();
        List<List<List<Student>>> trying = new ArrayList<List<List<Student>>>();
        JFrame resultsFrame = new JFrame("ResultsUI");
        resultsFrame.setContentPane(rui.getResultsPanel());
        resultsFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        resultsFrame.pack();
        JFrame coverageFrame = new JFrame("CoverageUI");
        coverageFrame.setContentPane(cui.getCoveragePanel());
        coverageFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        coverageFrame.pack();


        while(ui.getDay() != -1) {

            System.out.print("");

            if(rui.getExitCode() == 1){
                resultsFrame.setVisible(false);
                frame.setVisible(true);
                ui.setDay(0);
                rui.setExitCode(0);
            }
            if(cui.getExitCode() == 1){
                coverageFrame.setVisible(false);
                frame.setVisible(true);
                cui.setExitCode(0);
                ui.setDay(0);
            }
            if(rui.getExitCode() == -1) {
                resultsFrame.setVisible(false);
                break;
            }
            if(cui.getExitCode() == -1){
                coverageFrame.setVisible(false);
                break;
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
                sunStations.add(sunCold);
                sunStations.add(sunJan);

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
                monStations.add(monCold);
                monStations.add(monJan);

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
                tuesStations.add(tuesCold);
                tuesStations.add(tuesJan);

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
                wedStations.add(wedCold);
                wedStations.add(wedJan);

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
                thurStations.add(thurCold);
                thurStations.add(thurJan);

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
                Station friChecker = new Station(0,0,1, 1, 0, 0, 1, 1);
                Station friHearth = new Station(0, 2, 3 , 1, 1, 1, 1, 1);
                Station friSalads = new Station( 0, 2, 2, 1, 1, 1, 1, 1);
                Station friPeaks = new Station( 0, 1, 1, 1, 1, 1, 1, 1);
                Station friToast = new Station( 4, 2, 4, 1, 5, 2, 4, 4);
                Station friMiddie = new Station(0, 2, 2, 1, 1, 2, 2, 2);
                Station friCurry = new Station( 0, 2, 4, 1, 1, 1,1, 1);
                Station friGrange = new Station( 2, 3, 3,1 ,1 ,1, 1 , 1);
                Station friDish = new Station( 0, 4 , 4, 8, 1, 6, 6, 10);
                Station friDra = new Station( 1, 1, 1, 1, 1, 2, 2, 2);
                Station friJan = new Station( 1, 1, 1, 1, 1, 1, 1, 2);
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
                friStations.add(friCold);
                friStations.add(friJan);

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
                Station satChecker = new Station(1 ,1,1, 1, 1, 1, 1, 1);
                Station satHearth = new Station(0, 1, 1 , 1, 1, 2, 2, 3);
                Station satSalads = new Station( 0, 0, 0, 1, 2, 1, 1, 3);
                Station satPeaks = new Station( 0, 0, 0, 1, 1, 1, 1, 2);
                Station satToast = new Station( 3, 2, 1, 2, 9, 6, 3, 5);
                Station satMiddie = new Station(0, 0, 1, 1, 0, 3, 1, 3);
                Station satCurry = new Station( 0, 0, 0, 0, 0, 0,0, 0);
                Station satGrange = new Station( 0, 1, 1,2 ,2 ,3, 3 , 5);
                Station satDish = new Station( 3, 2 , 2, 6, 6, 5, 5, 12);
                Station satDra = new Station( 0, 0, 0, 2, 1, 1, 1, 2);
                Station satJan = new Station( 0, 0, 0, 0, 1, 1, 1, 3);
                Station satCold = new Station(1, 1, 1, 2, 1, 1, 1, 2);

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
                satStations.add(satCold);
                satStations.add(satJan);
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
            if(ui.getDay() == 15){
                pool = schedule.buildDayPool(1);
                bigpool = schedule.buildPool(pool, 1);
                cui.setSundayCoverage(schedule.getCoverage(bigpool,1));
                pool = schedule.buildDayPool(3);
                bigpool = schedule.buildPool(pool, 3);
                cui.setMondayCoverage(schedule.getCoverage(bigpool,3));
                pool = schedule.buildDayPool(5);
                bigpool = schedule.buildPool(pool, 5);
                cui.setTuesdayCoverage(schedule.getCoverage(bigpool,5));
                pool = schedule.buildDayPool(7);
                bigpool = schedule.buildPool(pool, 7);
                cui.setWednesdayCoverage(schedule.getCoverage(bigpool,7));
                pool = schedule.buildDayPool(9);
                bigpool = schedule.buildPool(pool, 9);
                cui.setThursdayCoverage(schedule.getCoverage(bigpool,9));
                pool = schedule.buildDayPool(11);
                bigpool = schedule.buildPool(pool, 11);
                cui.setFridayCoverage(schedule.getCoverage(bigpool,11));
                pool = schedule.buildDayPool(13);
                bigpool = schedule.buildPool(pool, 13);
                cui.setSaturdayCoverage(schedule.getCoverage(bigpool,13));
                frame.setVisible(false);
                coverageFrame.setVisible(true);
                ui.setDay(0);
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


                TODO: When placing multiples, if they are early mid - close , also fill late mid (should fix double checker issue) *** morning -> early mid can cause double checker

               TODO: placement based on leads, float position


               TODO: Produce names so Ryan can easily cross check list as he makes changes.






         */

        /*

            TODO: how to make people keep their weights for scheduiling stations when the list of students gets updated everytime i run the program. find way to have it update instead of rerun?

                -store weights seperately? *** im thinking store in google sheet, reference based on name. no two students can have same name.
                -or update only new -> could be time intensive :(





         */














    }








}