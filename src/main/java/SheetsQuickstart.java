import javax.swing.*;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;



public class SheetsQuickstart {






    public static void main(String... args) throws IOException, GeneralSecurityException {

        SheetsCommunicator sheet = new SheetsCommunicator();
        DuckListUI ui = new DuckListUI();
        ResultsUI rui = new ResultsUI();
        CoverageUI cui = new CoverageUI();
        ShiftNumberChangeUI sui = new ShiftNumberChangeUI();

        sheet.updateStudentsWeights();

        Schedule schedule = sheet.generateList();

        while(true){
            if(!schedule.getStudents().isEmpty()) break;
        }

        JFrame frame = new JFrame("DuckListUI");
        frame.setContentPane(ui.getMainView());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
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
        JFrame shiftNumberChangeFrame = new JFrame("ShiftNumberChangeUI");
        shiftNumberChangeFrame.setContentPane(sui.getShiftNumberChangeView());
        shiftNumberChangeFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        shiftNumberChangeFrame.pack();














        while(ui.getAction() != -1) {

            System.out.print("");

            if(rui.getExitCode() == 1){
                schedule.buildMasterList();
                resultsFrame.setVisible(false);
                frame.setVisible(true);
                ui.setAction(0);
                rui.setExitCode(0);

            }
            if(cui.getExitCode() == 1){
                coverageFrame.setVisible(false);
                frame.setVisible(true);
                cui.setExitCode(0);
                ui.setAction(0);
            }
            if(rui.getExitCode() == -1) {
                resultsFrame.setVisible(false);
                break;
            }
            if(rui.getExitCode() == -2){
                sheet.adjustStudentWeights();
                resultsFrame.setVisible(false);
                break;
            }
            if(cui.getExitCode() == -1){
                coverageFrame.setVisible(false);
                break;
            }
            if(ui.getAction() == 1){


                pool = schedule.buildDayPool(ui.getDay());
                bigpool = schedule.buildPool(pool, ui.getDay());
                schedule.fillStations(schedule.getDefaultStationNumbers(ui.getDay()));
                trying = schedule.createDuck(bigpool);
                schedule.printToSystem(trying, ui.getDay());
                ui.setAction(0);

                schedule.sortForPrinting(ui.getDay());
                schedule.setMasterList(sheet.combineMidShifts(schedule.getMasterList()));
                sheet.createDuckList(sheet.sortMasterStudentList(schedule.getMasterList(), ui.getDay()), ui.getDay());
                List<String> printer = schedule.printToString(trying, ui.getDay());
                rui.setMorningDuckList(printer.get(0));
                rui.setMidDuckList(printer.get(1));
                rui.setDinnerDuckList(printer.get(2));
                frame.setVisible(false);
                resultsFrame.setVisible(true);


            }
            if(sui.getAction() == 1){
                if(sui.getDay() == 1){ sheet.setShiftDefaults(sui.getSundayRange(), sui.buildShiftNumbers()); }
                if(sui.getDay() == 3){ sheet.setShiftDefaults(sui.getMondayRange(), sui.buildShiftNumbers());}
                if(sui.getDay() == 5){ sheet.setShiftDefaults(sui.getTuesdayRange(), sui.buildShiftNumbers());}
                if(sui.getDay() == 7){ sheet.setShiftDefaults(sui.getWednesdayRange(), sui.buildShiftNumbers());}
                if(sui.getDay() == 9){ sheet.setShiftDefaults(sui.getThursdayRange(), sui.buildShiftNumbers());}
                if(sui.getDay() == 11){ sheet.setShiftDefaults(sui.getFridayRange(), sui.buildShiftNumbers()); }
                if(sui.getDay() == 13){ sheet.setShiftDefaults(sui.getSaturdayRange(), sui.buildShiftNumbers());}

                pool = schedule.buildDayPool(sui.getDay());
                bigpool = schedule.buildPool(pool, sui.getDay());
                schedule.fillStations(sui.buildShiftNumbers());
                trying = schedule.createDuck(bigpool);
                schedule.printToSystem(trying, ui.getDay());
                schedule.sortForPrinting(ui.getDay());
                schedule.setMasterList(sheet.combineMidShifts(schedule.getMasterList()));
                sheet.createDuckList(sheet.sortMasterStudentList(schedule.getMasterList(), ui.getDay()), ui.getDay());

                ui.setAction(0);
                sui.setAction(0);

                List<String> printer = schedule.printToString(trying, sui.getDay());
                rui.setMorningDuckList(printer.get(0));
                rui.setMidDuckList(printer.get(1));
                rui.setDinnerDuckList(printer.get(2));
                shiftNumberChangeFrame.setVisible(false);
                resultsFrame.setVisible(true);


            }
            if(sui.getAction() == 2){
                pool = schedule.buildDayPool(sui.getDay());
                bigpool = schedule.buildPool(pool, sui.getDay());
                schedule.fillStations(sui.buildShiftNumbers());
                trying = schedule.createDuck(bigpool);
                schedule.printToSystem(trying, ui.getDay());
                schedule.sortForPrinting(ui.getDay());
                schedule.setMasterList(sheet.combineMidShifts(schedule.getMasterList()));
                sheet.createDuckList(sheet.sortMasterStudentList(schedule.getMasterList(), ui.getDay()), ui.getDay());
                ui.setAction(0);
                sui.setAction(0);

                List<String> printer = schedule.printToString(trying, sui.getDay());
                rui.setMorningDuckList(printer.get(0));
                rui.setMidDuckList(printer.get(1));
                rui.setDinnerDuckList(printer.get(2));
                shiftNumberChangeFrame.setVisible(false);
                resultsFrame.setVisible(true);
            }
            if(ui.getAction() == 2){
                sui.setDay(ui.getDay());
                sui.fillWithDefaults();
                frame.setVisible(false);
                shiftNumberChangeFrame.setVisible(true);
                ui.setAction(0);

            }
            if(ui.getAction() == 3){
                List<List<Integer>> coverages = new ArrayList<>();
                pool = schedule.buildDayPool(1);
                bigpool = schedule.buildPool(pool, 1);
                cui.setSundayCoverage(schedule.getCoverage(bigpool,1));
                coverages.add(schedule.getCoverageList(bigpool));
                pool = schedule.buildDayPool(3);
                bigpool = schedule.buildPool(pool, 3);
                cui.setMondayCoverage(schedule.getCoverage(bigpool,3));
                coverages.add(schedule.getCoverageList(bigpool));
                pool = schedule.buildDayPool(5);
                bigpool = schedule.buildPool(pool, 5);
                cui.setTuesdayCoverage(schedule.getCoverage(bigpool,5));
                coverages.add(schedule.getCoverageList(bigpool));
                pool = schedule.buildDayPool(7);
                bigpool = schedule.buildPool(pool, 7);
                cui.setWednesdayCoverage(schedule.getCoverage(bigpool,7));
                coverages.add(schedule.getCoverageList(bigpool));
                pool = schedule.buildDayPool(9);
                bigpool = schedule.buildPool(pool, 9);
                cui.setThursdayCoverage(schedule.getCoverage(bigpool,9));
                coverages.add(schedule.getCoverageList(bigpool));
                pool = schedule.buildDayPool(11);
                bigpool = schedule.buildPool(pool, 11);
                cui.setFridayCoverage(schedule.getCoverage(bigpool,11));
                coverages.add(schedule.getCoverageList(bigpool));
                pool = schedule.buildDayPool(13);
                bigpool = schedule.buildPool(pool, 13);
                cui.setSaturdayCoverage(schedule.getCoverage(bigpool,13));
                coverages.add(schedule.getCoverageList(bigpool));
                sheet.updateCoverageSheet(coverages);
                frame.setVisible(false);
                coverageFrame.setVisible(true);
                ui.setAction(0);
            }

        }
        System.exit(0);



        /*

               TODO: Check if need to fix double checker
               TODO: Fix errors on multiple runs (as in run, hit restart, run again) i believe its probably just overloading things, doesnt 'reset'

         */




    }








}