import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.List;

public class Schedule {

    private List<List<List<Student>>> masterList = new ArrayList<>();
    private List<Station> stationList;
    private List<List<Student>> pool;

    private List<Student> students;
    private String sundayRange = "ShiftNumbers!B2:M13";
    private String mondayRange = "ShiftNumbers!B14:M25";
    private String tuesdayRange = "ShiftNumbers!B26:M37";
    private String wednesdayRange = "ShiftNumbers!B38:M49";
    private String thursdayRange = "ShiftNumbers!B50:M61";
    private String fridayRange = "ShiftNumbers!B62:M73";
    private String saturdayRange = "ShiftNumbers!B74:M85";

    public Schedule(List<List<Object>> times){
        this.students = building(times);
        buildMasterList();
    }

    /*
       Fills master list with stations and shifts
    */
    private void buildMasterList(){
        List<List<Student>> checker = new ArrayList<List<Student>>();
        List<List<Student>> peaks = new ArrayList<List<Student>>();
        List<List<Student>> hearth = new ArrayList<List<Student>>();
        List<List<Student>> salads = new ArrayList<List<Student>>();
        List<List<Student>> toast = new ArrayList<List<Student>>();
        List<List<Student>> mid = new ArrayList<List<Student>>();
        List<List<Student>> curry = new ArrayList<List<Student>>();
        List<List<Student>> grange = new ArrayList<List<Student>>();
        List<List<Student>> dish = new ArrayList<List<Student>>();
        List<List<Student>> dra = new ArrayList<List<Student>>();
        List<List<Student>> jan = new ArrayList<List<Student>>();
        List<List<Student>> cold = new ArrayList<List<Student>>();

        List<Student> checkMorn = new ArrayList<Student>();
        List<Student> checkEarlyMid = new ArrayList<Student>();
        List<Student> checkLateMid = new ArrayList<Student>();
        List<Student> checkDin = new ArrayList<Student>();
        List<Student> peaksMorn = new ArrayList<Student>();
        List<Student> peaksEarlyMid = new ArrayList<Student>();
        List<Student> peaksLateMid = new ArrayList<Student>();
        List<Student> peaksDin = new ArrayList<Student>();
        List<Student> hearthMorn = new ArrayList<Student>();
        List<Student> hearthEarlyMid = new ArrayList<Student>();
        List<Student> hearthLateMid = new ArrayList<Student>();
        List<Student> hearthDin = new ArrayList<Student>();
        List<Student> saladsMorn = new ArrayList<Student>();
        List<Student> saladsEarlyMid = new ArrayList<Student>();
        List<Student> saladsLateMid = new ArrayList<Student>();
        List<Student> saladsDin = new ArrayList<Student>();
        List<Student> toastMorn = new ArrayList<Student>();
        List<Student> toastEarlyMid = new ArrayList<Student>();
        List<Student> toastLateMid = new ArrayList<Student>();
        List<Student> toastDin = new ArrayList<Student>();
        List<Student> midMorn = new ArrayList<Student>();
        List<Student> midEarlyMid = new ArrayList<Student>();
        List<Student> midLateMid = new ArrayList<Student>();
        List<Student> midDin = new ArrayList<Student>();
        List<Student> curryMorn = new ArrayList<Student>();
        List<Student> curryEarlyMid = new ArrayList<Student>();
        List<Student> curryLateMid = new ArrayList<Student>();
        List<Student> curryDin = new ArrayList<Student>();
        List<Student> grangeMorn = new ArrayList<Student>();
        List<Student> grangeEarlyMid = new ArrayList<Student>();
        List<Student> grangeLateMid = new ArrayList<Student>();
        List<Student> grangeDin = new ArrayList<Student>();
        List<Student> dishMorn = new ArrayList<Student>();
        List<Student> dishEarlyMid = new ArrayList<Student>();
        List<Student> dishLateMid = new ArrayList<Student>();
        List<Student> dishDin = new ArrayList<Student>();
        List<Student> draMorn = new ArrayList<Student>();
        List<Student> draEarlyMid = new ArrayList<Student>();
        List<Student> draLateMid = new ArrayList<Student>();
        List<Student> draDin = new ArrayList<Student>();
        List<Student> janMorn = new ArrayList<Student>();
        List<Student> janEarlyMid = new ArrayList<Student>();
        List<Student> janLateMid = new ArrayList<Student>();
        List<Student> janDin = new ArrayList<Student>();
        List<Student> coldMorn = new ArrayList<Student>();
        List<Student> coldEarlyMid = new ArrayList<Student>();
        List<Student> coldLateMid = new ArrayList<Student>();
        List<Student> coldDin = new ArrayList<Student>();

        checker.add(checkMorn);
        checker.add(checkEarlyMid);
        checker.add(checkLateMid);
        checker.add(checkDin);
        peaks.add(peaksMorn);
        peaks.add(peaksEarlyMid);
        peaks.add(peaksLateMid);
        peaks.add(peaksDin);
        hearth.add(hearthMorn);
        hearth.add(hearthEarlyMid);
        hearth.add(hearthLateMid);
        hearth.add(hearthDin);
        salads.add(saladsMorn);
        salads.add(saladsEarlyMid);
        salads.add(saladsLateMid);
        salads.add(saladsDin);
        toast.add(toastMorn);
        toast.add(toastEarlyMid);
        toast.add(toastLateMid);
        toast.add(toastDin);
        mid.add(midMorn);
        mid.add(midEarlyMid);
        mid.add(midLateMid);
        mid.add(midDin);
        curry.add(curryMorn);
        curry.add(curryEarlyMid);
        curry.add(curryLateMid);
        curry.add(curryDin);
        grange.add(grangeMorn);
        grange.add(grangeEarlyMid);
        grange.add(grangeLateMid);
        grange.add(grangeDin);
        dish.add(dishMorn);
        dish.add(dishEarlyMid);
        dish.add(dishLateMid);
        dish.add(dishDin);
        dra.add(draMorn);
        dra.add(draEarlyMid);
        dra.add(draLateMid);
        dra.add(draDin);
        jan.add(janMorn);
        jan.add(janEarlyMid);
        jan.add(janLateMid);
        jan.add(janDin);
        cold.add(coldMorn);
        cold.add(coldEarlyMid);
        cold.add(coldLateMid);
        cold.add(coldDin);



        this.masterList.add(checker); //0
        this.masterList.add(peaks); //1
        this.masterList.add(hearth); //2
        this.masterList.add(salads); //3
        this.masterList.add(toast); //4
        this.masterList.add(mid); //5
        this.masterList.add(curry); //6
        this.masterList.add(grange); //7
        this.masterList.add(dish); //8
        this.masterList.add(dra);//9
        this.masterList.add(cold);//10
        this.masterList.add(jan); //11
    }

    public List<List<Object>> getDefaultStationNumbers(int day) throws IOException, GeneralSecurityException{
        SheetsCommunicator sheets = new SheetsCommunicator();
        List<List<Object>> values = new ArrayList<List<Object>>();
        if (day == 1) {  values = sheets.getShiftDefaults(sundayRange); }
        else if (day == 3) { values = sheets.getShiftDefaults(mondayRange); }
        else if (day == 5) {  values = sheets.getShiftDefaults(tuesdayRange); }
        else if (day == 7) { values = sheets.getShiftDefaults(wednesdayRange); }
        else if (day == 9) { values = sheets.getShiftDefaults(thursdayRange); }
        else if (day == 11) {  values = sheets.getShiftDefaults(fridayRange); }
        else if (day == 13) {  values = sheets.getShiftDefaults(saturdayRange); }
        return values;
    }
    /*
        Fill Stations with Default numbers from database
        @Param int day
     */
    public void fillStations(List<List<Object>> values) throws IOException, GeneralSecurityException{


        Station Checker = new Station(Integer.parseInt((String)values.get(0).get(0)),Integer.parseInt((String)values.get(0).get(1)),Integer.parseInt((String)values.get(0).get(2)),
                Integer.parseInt((String)values.get(0).get(3)), Integer.parseInt((String)values.get(0).get(4)), Integer.parseInt((String)values.get(0).get(5)), Integer.parseInt((String)values.get(0).get(6)),
                Integer.parseInt((String)values.get(0).get(7)), Integer.parseInt((String)values.get(0).get(8)), Integer.parseInt((String)values.get(0).get(9)), Integer.parseInt((String)values.get(0).get(10)),
                Integer.parseInt((String)values.get(0).get(11)));
        Station Peaks = new Station(Integer.parseInt((String)values.get(1).get(0)),Integer.parseInt((String)values.get(1).get(1)),Integer.parseInt((String)values.get(1).get(2)),
                Integer.parseInt((String)values.get(1).get(3)), Integer.parseInt((String)values.get(1).get(4)), Integer.parseInt((String)values.get(1).get(5)), Integer.parseInt((String)values.get(1).get(6)),
                Integer.parseInt((String)values.get(1).get(7)), Integer.parseInt((String)values.get(1).get(8)), Integer.parseInt((String)values.get(1).get(9)), Integer.parseInt((String)values.get(1).get(10)),
                Integer.parseInt((String)values.get(1).get(11)));
        Station Hearth = new Station(Integer.parseInt((String)values.get(2).get(0)),Integer.parseInt((String)values.get(2).get(1)),Integer.parseInt((String)values.get(2).get(2)),
                Integer.parseInt((String)values.get(2).get(3)), Integer.parseInt((String)values.get(2).get(4)), Integer.parseInt((String)values.get(2).get(5)), Integer.parseInt((String)values.get(2).get(6)),
                Integer.parseInt((String)values.get(2).get(7)), Integer.parseInt((String)values.get(2).get(8)), Integer.parseInt((String)values.get(2).get(9)), Integer.parseInt((String)values.get(2).get(10)),
                Integer.parseInt((String)values.get(2).get(11)));
        Station Salads = new Station(Integer.parseInt((String)values.get(3).get(0)),Integer.parseInt((String)values.get(3).get(1)),Integer.parseInt((String)values.get(3).get(2)),
                Integer.parseInt((String)values.get(3).get(3)), Integer.parseInt((String)values.get(3).get(4)), Integer.parseInt((String)values.get(3).get(5)), Integer.parseInt((String)values.get(3).get(6)),
                Integer.parseInt((String)values.get(3).get(7)), Integer.parseInt((String)values.get(3).get(8)), Integer.parseInt((String)values.get(3).get(9)), Integer.parseInt((String)values.get(3).get(10)),
                Integer.parseInt((String)values.get(3).get(11)));
        Station Toast = new Station(Integer.parseInt((String)values.get(4).get(0)),Integer.parseInt((String)values.get(4).get(1)),Integer.parseInt((String)values.get(4).get(2)),
                Integer.parseInt((String)values.get(4).get(3)), Integer.parseInt((String)values.get(4).get(4)), Integer.parseInt((String)values.get(4).get(5)), Integer.parseInt((String)values.get(4).get(6)),
                Integer.parseInt((String)values.get(4).get(7)), Integer.parseInt((String)values.get(4).get(8)), Integer.parseInt((String)values.get(4).get(9)), Integer.parseInt((String)values.get(4).get(10)),
                Integer.parseInt((String)values.get(4).get(11)));
        Station Middie = new Station(Integer.parseInt((String)values.get(5).get(0)),Integer.parseInt((String)values.get(5).get(1)),Integer.parseInt((String)values.get(5).get(2)),
                Integer.parseInt((String)values.get(5).get(3)), Integer.parseInt((String)values.get(5).get(4)), Integer.parseInt((String)values.get(5).get(5)), Integer.parseInt((String)values.get(5).get(6)),
                Integer.parseInt((String)values.get(5).get(7)), Integer.parseInt((String)values.get(5).get(8)), Integer.parseInt((String)values.get(5).get(9)), Integer.parseInt((String)values.get(5).get(10)),
                Integer.parseInt((String)values.get(5).get(11)));
        Station Curry = new Station(Integer.parseInt((String)values.get(6).get(0)),Integer.parseInt((String)values.get(6).get(1)),Integer.parseInt((String)values.get(6).get(2)),
                Integer.parseInt((String)values.get(6).get(3)), Integer.parseInt((String)values.get(6).get(4)), Integer.parseInt((String)values.get(6).get(5)), Integer.parseInt((String)values.get(6).get(6)),
                Integer.parseInt((String)values.get(6).get(7)), Integer.parseInt((String)values.get(6).get(8)), Integer.parseInt((String)values.get(6).get(9)), Integer.parseInt((String)values.get(6).get(10)),
                Integer.parseInt((String)values.get(6).get(11)));
        Station Grange = new Station(Integer.parseInt((String)values.get(7).get(0)),Integer.parseInt((String)values.get(7).get(1)),Integer.parseInt((String)values.get(7).get(2)),
                Integer.parseInt((String)values.get(7).get(3)), Integer.parseInt((String)values.get(7).get(4)), Integer.parseInt((String)values.get(7).get(5)), Integer.parseInt((String)values.get(7).get(6)),
                Integer.parseInt((String)values.get(7).get(7)), Integer.parseInt((String)values.get(7).get(8)), Integer.parseInt((String)values.get(7).get(9)), Integer.parseInt((String)values.get(7).get(10)),
                Integer.parseInt((String)values.get(7).get(11)));
        Station Dish = new Station(Integer.parseInt((String)values.get(8).get(0)),Integer.parseInt((String)values.get(8).get(1)),Integer.parseInt((String)values.get(8).get(2)),
                Integer.parseInt((String)values.get(8).get(3)), Integer.parseInt((String)values.get(8).get(4)), Integer.parseInt((String)values.get(8).get(5)), Integer.parseInt((String)values.get(8).get(6)),
                Integer.parseInt((String)values.get(8).get(7)), Integer.parseInt((String)values.get(8).get(8)), Integer.parseInt((String)values.get(8).get(9)), Integer.parseInt((String)values.get(8).get(10)),
                Integer.parseInt((String)values.get(8).get(11)));
        Station DRA = new Station(Integer.parseInt((String)values.get(9).get(0)),Integer.parseInt((String)values.get(9).get(1)),Integer.parseInt((String)values.get(9).get(2)),
                Integer.parseInt((String)values.get(9).get(3)), Integer.parseInt((String)values.get(9).get(4)), Integer.parseInt((String)values.get(9).get(5)), Integer.parseInt((String)values.get(9).get(6)),
                Integer.parseInt((String)values.get(9).get(7)), Integer.parseInt((String)values.get(9).get(8)), Integer.parseInt((String)values.get(9).get(9)), Integer.parseInt((String)values.get(9).get(10)),
                Integer.parseInt((String)values.get(9).get(11)));
        Station ColdRunner = new Station(Integer.parseInt((String)values.get(10).get(0)),Integer.parseInt((String)values.get(10).get(1)),Integer.parseInt((String)values.get(10).get(2)),
                Integer.parseInt((String)values.get(10).get(3)), Integer.parseInt((String)values.get(10).get(4)), Integer.parseInt((String)values.get(10).get(5)), Integer.parseInt((String)values.get(10).get(6)),
                Integer.parseInt((String)values.get(10).get(7)), Integer.parseInt((String)values.get(10).get(8)), Integer.parseInt((String)values.get(10).get(9)), Integer.parseInt((String)values.get(10).get(10)),
                Integer.parseInt((String)values.get(10).get(11)));
        Station Janitor = new Station(Integer.parseInt((String)values.get(11).get(0)),Integer.parseInt((String)values.get(11).get(1)),Integer.parseInt((String)values.get(11).get(2)),
                Integer.parseInt((String)values.get(11).get(3)), Integer.parseInt((String)values.get(11).get(4)), Integer.parseInt((String)values.get(11).get(5)), Integer.parseInt((String)values.get(11).get(6)),
                Integer.parseInt((String)values.get(11).get(7)), Integer.parseInt((String)values.get(11).get(8)), Integer.parseInt((String)values.get(11).get(9)), Integer.parseInt((String)values.get(11).get(10)),
                Integer.parseInt((String)values.get(11).get(11)));

        List<Station> stations = new ArrayList<Station>();
        stations.add(Checker);
        stations.add(Peaks);
        stations.add(Hearth);
        stations.add(Salads);
        stations.add(Toast);
        stations.add(Middie);
        stations.add(Curry);
        stations.add(Grange);
        stations.add(Dish);
        stations.add(DRA);
        stations.add(ColdRunner);
        stations.add(Janitor);

        this.stationList = stations;
    }

    /*
       Builds list of students from list of objects retrieved from google sheets

       @param List<List<Object>> times (data pulled from google sheets)


    */
    public List<Student> building(List<List<Object>> times) {
        List<Student> students = new ArrayList<>();
        int studentIndex = 0;
        boolean leads = true;
        for(int i = 0; i < times.size(); i++){
            if(times.get(i).size() > 0){
                if(times.get(i).get(0).toString().compareTo("Crew") == 0) {
                    leads = false;
                }
                if(times.get(i).get(0).toString().compareTo("Temps") == 0){
                    leads = true;
                }
            }
            if(times.get(i).size() > 1) {
                //If student has split shift name won't be on same row, so it sets it to the name from previous row
                if(times.get(i).get(0).toString().compareTo("") != 0) {
                    students.add(new Student(times.get(i).get(0).toString(), times.get(i), leads));
                }
                else if(times.get(i-1).get(0).toString().compareTo("") != 0){
                    students.add(new Student(times.get(i-1).get(0).toString(), times.get(i), leads));
                }
            }
        }
        return students;
    }


    /*
        Builds pool for students working on given day


        @param int day (day index for intended day

     */
    public List<Student> buildDayPool(int day)
    {
        List<Student> pool = new ArrayList<Student>();
        for(int i = 0; i < students.size(); i++)
        {
            if(students.get(i).getWork(day)){
                pool.add(students.get(i));
            }
        }
        return pool;
    }

    /*
        Builds daily pool of students separated by Morning, Early Mid, Late mid, and Dinner shifts

        @param List<Student> studentsWorking (list of people working that day)
        @param int day (day index for intended day

     */
    public List<List<Student>> buildPool(List<Student> studentsWorking, int day){
     List<List<Student>> pool = new ArrayList<List<Student>>();
     List<Student> morning = new ArrayList<Student>();
     List<Student> earlyMid = new ArrayList<Student>();
     List<Student> lateMid = new ArrayList<Student>();
     List<Student> dinner = new ArrayList<Student>();
     pool.add(morning);
     pool.add(earlyMid);
     pool.add(lateMid);
     pool.add(dinner);


     for(int i = 0; i < studentsWorking.size(); i++){
         //Weekday morning (starting before 8am)
      try{
          //System.out.println(studentsWorking.get(i).getName());
          if(studentsWorking.get(i).getSchedule().get(day).toString().endsWith("am") &&
                 Integer.parseInt(studentsWorking.get(i).getSchedule().get(day).toString().substring(0,1)) < 8 &&
         Integer.parseInt(studentsWorking.get(i).getSchedule().get(day).toString().substring(0,1)) > 5 && day != 1 && day != 13){
             //System.out.println("Morning: " + studentsWorking.get(i).getName())   ;
             pool.get(0).add(studentsWorking.get(i));
             if(studentsWorking.get(i).getSchedule().get(day+1).toString().compareTo("CL") == 0){
                 pool.get(2).add(studentsWorking.get(i));
                 pool.get(3).add(studentsWorking.get(i));
                 studentsWorking.get(i).setMultipleShifts(true);
             }
             else if(Integer.parseInt(studentsWorking.get(i).getSchedule().get(day+1).toString().substring(0,1)) > 1){
                 pool.get(1).add(studentsWorking.get(i));
                 studentsWorking.get(i).setMultipleShifts(true);
             }
         }

         //Weekend morning (starting before 10am)
         else if(studentsWorking.get(i).getSchedule().get(day).toString().endsWith("am") &&
                 Integer.parseInt(studentsWorking.get(i).getSchedule().get(day).toString().substring(0,1)) < 10 &&
                 Integer.parseInt(studentsWorking.get(i).getSchedule().get(day).toString().substring(0,1)) > 5 && (day == 1 || day == 13)){
             pool.get(0).add(studentsWorking.get(i));
             //if they leave at CL add them to mid and close as well
             if(studentsWorking.get(i).getSchedule().get(day+1).toString().compareTo("CL") == 0){
                 pool.get(1).add(studentsWorking.get(i));
                 pool.get(3).add(studentsWorking.get(i));
                 studentsWorking.get(i).setMultipleShifts(true);
             }
             //else if they leave after 1pm but before close, add them to mid
             else if(Integer.parseInt(studentsWorking.get(i).getSchedule().get(day+1).toString().substring(0,1)) > 1){
                 pool.get(1).add(studentsWorking.get(i));
                 studentsWorking.get(i).setMultipleShifts(true);
             }
         }
         //Weekend/Weekday Mid + Close shift (starting before 3pm and Closing)
         else if(studentsWorking.get(i).getSchedule().get(day+1).toString().compareTo("CL") == 0 &&
                 ((Integer.parseInt(studentsWorking.get(i).getSchedule().get(day).toString().substring(0,1)) < 3) ||
                         (Integer.parseInt(studentsWorking.get(i).getSchedule().get(day).toString().substring(0,1)) > 7)  )){
             pool.get(2).add(studentsWorking.get(i));
             pool.get(3).add(studentsWorking.get(i));
          studentsWorking.get(i).setMultipleShifts(true);
         }
         //weekend/weekday Close (Starts 3pm or later and Closing)
         else if(studentsWorking.get(i).getSchedule().get(day+1).toString().compareTo("CL") == 0){
             pool.get(3).add(studentsWorking.get(i));
         }
         else if(studentsWorking.get(i).getSchedule().get(day).toString().compareTo("") == 0){
             //do nothing, this shouldn't happen
             System.out.println("something went wrong here");
         }
         //weekday early mid (not opening or closing and here before 11am)
         else if(studentsWorking.get(i).getSchedule().get(day+1).toString().compareTo("CL") != 0 &&
              ((Integer.parseInt(studentsWorking.get(i).getSchedule().get(day).toString().substring(0,1)) > 6) ||
                      (studentsWorking.get(i).getSchedule().get(day).toString().substring(0,1).compareTo("1") == 0 &&
                      studentsWorking.get(i).getSchedule().get(day).toString().substring(1,2).compareTo("0") == 0)) && day != 1 && day != 13){
            pool.get(1).add(studentsWorking.get(i));
      }
        //weekend early mid (not opening or closing and here before 12pm)
        else if(studentsWorking.get(i).getSchedule().get(day+1).toString().compareTo("CL") != 0 &&
              ((Integer.parseInt(studentsWorking.get(i).getSchedule().get(day).toString().substring(0,1)) > 6) ||
                      (studentsWorking.get(i).getSchedule().get(day).toString().substring(0,1).compareTo("1") == 0 &&
                              ((studentsWorking.get(i).getSchedule().get(day).toString().substring(1,2).compareTo("0") == 0) ||
                                      (studentsWorking.get(i).getSchedule().get(day).toString().substring(1,2).compareTo("1") == 0)))) && (day == 1 || day == 13)){
             pool.get(1).add(studentsWorking.get(i));
      }
        //late mid
         else{

             pool.get(2).add(studentsWorking.get(i));
         }}
         catch(Exception exception){
          System.out.println("Cannot convert********************************************"); //todo: check with justin on this
         }
     }
        return pool;
    }

    /*
           Checks if a student with given name works during given shift

           @param List<Student> pool (list of people working during a shift)
           @param String name (name of student we are checking for)

        */
    public Boolean worksShift( List<Student> pool, String name){
        for(int i = 0; i < pool.size(); i++){
            if(pool.get(i).getName().compareTo(name) == 0){
                return true;
            }
        }
        return false;
    }

    private void addLateDinner(int stationID, Student temp){
        this.masterList.get(stationID).get(2).add(temp);
        this.masterList.get(stationID).get(3).add(temp);
        this.pool.set(2,removeByName(temp.getName(), pool.get(2)) ) ;
        this.pool.set(3,removeByName(temp.getName(), pool.get(3)) ) ;
        this.stationList.get(stationID).addLateMidStudent();
        this.stationList.get(stationID).addDinnerStudent();
    }

    private void addEarlyLateDinner(int stationID, Student temp){
        this.masterList.get(stationID).get(1).add(temp);
        this.masterList.get(stationID).get(3).add(temp);
        this.pool.set(1,removeByName(temp.getName(), pool.get(1)) ) ;
        this.pool.set(2,removeByName(temp.getName(), pool.get(2))) ;
        this.pool.set(3,removeByName(temp.getName(), pool.get(3)) ) ;
        this.stationList.get(stationID).addEarlyMidStudent();
        this.stationList.get(stationID).addLateMidStudent();
        this.stationList.get(stationID).addDinnerStudent();
    }

    private void addMorningEarlyMid( int stationID, Student temp){
        this.masterList.get(stationID).get(0).add(temp);
        this.masterList.get(stationID).get(1).add(temp);
        this.pool.set(0, removeByName(temp.getName(), pool.get(0)));
        this.pool.set(1, removeByName(temp.getName(), pool.get(1)));
        this.stationList.get(stationID).addMorningStudent();
        this.stationList.get(stationID).addEarlyMidStudent();
    }
    private void addAll(int stationID, Student temp){
        this.masterList.get(stationID).get(0).add(temp);
        this.masterList.get(stationID).get(1).add(temp);
        this.masterList.get(0).get(3).add(temp);
        this.pool.set(0, removeByName(temp.getName(), pool.get(0)));
        this.pool.set(1, removeByName(temp.getName(), pool.get(1)));
        this.pool.set(2, removeByName(temp.getName(), pool.get(2)));
        this.pool.set(3, removeByName(temp.getName(), pool.get(3)));
        this.stationList.get(stationID).addMorningStudent();
        this.stationList.get(stationID).addEarlyMidStudent();
        this.stationList.get(stationID).addLateMidStudent();
        this.stationList.get(stationID).addDinnerStudent();
    }

    public List<List<List<Student>>> createDuck(List<List<Student>> pool){
        this.pool = pool;


        while(pool.get(0).size() > 0) {
            System.out.println("hanging");
            System.out.println(pool.get(0).size());
            if(pool.get(0).size() == 1){
                System.out.println(pool.get(0).get(0).getName());
                for(int i = 0; i < stationList.size(); i++){
                    System.out.println("Station #: " + i);
                    System.out.println("Morning Min: " + stationList.get(i).getMorningPeopleNeeded() + " Mid Min: " + stationList.get(i).getEarlyMidPeopleNeeded());
                    System.out.println("Morning Max: " + stationList.get(i).getMorningMaxWorkers() + " Mid Max: " + stationList.get(i).getEarlyMidMaxWorkers());
                    System.out.println("Total Students: " + stationList.get(i).getTotalMorning() + " Total Mid: " + stationList.get(i).getEarlyMid());

                }
            }

            if (stationList.get(0).getMorningPeopleNeeded() > stationList.get(0).getTotalMorning() && pool.get(0).size() != 0) {  // fill checker
                Student temp = randomChooser(pool.get(0), 1);
               if(temp.getMultipleShifts()){
                   if((worksShift(pool.get(1), temp.getName()) || worksShift(pool.get(2), temp.getName()) )&& !(worksShift(pool.get(3), temp.getName()))){ //if they work Morning + Mid, add them to same station for both shifts
                       if(stationList.get(0).getEarlyMidPeopleNeeded() > stationList.get(0).getEarlyMid()){
                          addMorningEarlyMid(0, temp);
                       }
                       else if(neededMidMinShiftsFilled(stationList) && stationList.get(0).getEarlyMid() <= stationList.get(0).getEarlyMidMaxWorkers()){
                           addMorningEarlyMid(0, temp);
                       }
                   }
                   else if(worksShift(pool.get(3), temp.getName())){
                       if((stationList.get(0).getEarlyMidPeopleNeeded() > stationList.get(0).getEarlyMid() || stationList.get(0).getLateMidPeopleNeeded() > stationList.get(0).getLateMid()) &&
                               stationList.get(0).getDinnerPeopleNeeded() > stationList.get(0).getTotalDinner()){
                           addAll(0, temp);
                       }
                   }
               }
               else{
                   masterList.get(0).get(0).add(temp);
                   pool.set(0, removeByName(temp.getName(), pool.get(0)));
                   stationList.get(0).addMorningStudent();
               }
            }
            if (stationList.get(1).getMorningPeopleNeeded() > stationList.get(1).getTotalMorning() && pool.get(0).size() != 0) { // fill peaks
                Student temp = randomChooser(pool.get(0), 2);
                if(temp.getMultipleShifts()){
                    if((worksShift(pool.get(1), temp.getName()) || worksShift(pool.get(2), temp.getName()) )&& !(worksShift(pool.get(3), temp.getName()))){ //if they work Morning + Mid, add them to same station for both shifts
                        if(stationList.get(1).getEarlyMidPeopleNeeded() > stationList.get(1).getEarlyMid()){
                            addMorningEarlyMid(1, temp);
                        }
                        else if(neededMidMinShiftsFilled(stationList) && stationList.get(1).getEarlyMid() <= stationList.get(1).getEarlyMidMaxWorkers()){
                            addMorningEarlyMid(1, temp);
                        }
                    }
                    else if(worksShift(pool.get(3), temp.getName())){
                        if((stationList.get(1).getEarlyMidPeopleNeeded() > stationList.get(1).getEarlyMid() || stationList.get(1).getLateMidPeopleNeeded() > stationList.get(1).getLateMid()) &&
                                stationList.get(1).getDinnerPeopleNeeded() > stationList.get(1).getTotalDinner()){
                            addAll(1, temp);
                        }
                    }
                }
                else {
                    masterList.get(1).get(0).add(temp);
                    pool.set(0, removeByName(temp.getName(), pool.get(0)));
                    stationList.get(1).addMorningStudent();
                }
            }
            if (stationList.get(2).getMorningPeopleNeeded() > stationList.get(2).getTotalMorning() && pool.get(0).size() != 0) { // fill hearth
                Student temp = randomChooser(pool.get(0), 3);
                if(temp.getMultipleShifts()){
                    if((worksShift(pool.get(1), temp.getName()) || worksShift(pool.get(2), temp.getName()) )&& !(worksShift(pool.get(3), temp.getName()))){ //if they work Morning + Mid, add them to same station for both shifts
                        if(stationList.get(2).getEarlyMidPeopleNeeded() > stationList.get(2).getEarlyMid()){
                            addMorningEarlyMid(2, temp);
                        }
                        else if(neededMidMinShiftsFilled(stationList) && stationList.get(2).getEarlyMid() <= stationList.get(2).getEarlyMidMaxWorkers()){
                            addMorningEarlyMid(2, temp);
                        }
                    }
                    else if(worksShift(pool.get(3), temp.getName())){
                        if((stationList.get(2).getEarlyMidPeopleNeeded() > stationList.get(2).getEarlyMid() || stationList.get(2).getLateMidPeopleNeeded() > stationList.get(2).getLateMid()) &&
                                stationList.get(2).getDinnerPeopleNeeded() > stationList.get(2).getTotalDinner()){
                            addAll(2, temp);
                        }
                    }
                }
                else {
                    masterList.get(2).get(0).add(temp);
                    pool.set(0, removeByName(temp.getName(), pool.get(0)));
                    stationList.get(2).addMorningStudent();
                }
            }
            if (stationList.get(3).getMorningPeopleNeeded() > stationList.get(3).getTotalMorning() && pool.get(0).size() != 0) { // fill salads
                Student temp = randomChooser(pool.get(0), 4);
                if(temp.getMultipleShifts()){
                    if((worksShift(pool.get(1), temp.getName()) || worksShift(pool.get(2), temp.getName()) )&& !(worksShift(pool.get(3), temp.getName()))){ //if they work Morning + Mid, add them to same station for both shifts
                        if(stationList.get(3).getEarlyMidPeopleNeeded() > stationList.get(3).getEarlyMid()){
                            addMorningEarlyMid(3, temp);
                        }
                        else if(neededMidMinShiftsFilled(stationList) && stationList.get(3).getEarlyMid() <= stationList.get(3).getEarlyMidMaxWorkers()){
                            addMorningEarlyMid(3, temp);
                        }
                    }
                    else if(worksShift(pool.get(3), temp.getName())){
                        if((stationList.get(3).getEarlyMidPeopleNeeded() > stationList.get(3).getEarlyMid() || stationList.get(3).getLateMidPeopleNeeded() > stationList.get(3).getLateMid()) &&
                                stationList.get(3).getDinnerPeopleNeeded() > stationList.get(3).getTotalDinner()){
                            addAll(3, temp);
                        }
                    }
                }
                else {
                    masterList.get(3).get(0).add(temp);
                    pool.set(0, removeByName(temp.getName(), pool.get(0)));
                    stationList.get(3).addMorningStudent();
                }
            }
            if (stationList.get(4).getMorningPeopleNeeded() > stationList.get(4).getTotalMorning() && pool.get(0).size() != 0) { //fill toast
                Student temp = randomChooser(pool.get(0), 5);
                if(temp.getMultipleShifts()){
                    if((worksShift(pool.get(1), temp.getName()) || worksShift(pool.get(2), temp.getName()) )&& !(worksShift(pool.get(3), temp.getName()))){ //if they work Morning + Mid, add them to same station for both shifts
                        if(stationList.get(4).getEarlyMidPeopleNeeded() > stationList.get(4).getEarlyMid()){
                            addMorningEarlyMid(4, temp);
                        }
                        else if(neededMidMinShiftsFilled(stationList) && stationList.get(4).getEarlyMid() <= stationList.get(4).getEarlyMidMaxWorkers()){
                            addMorningEarlyMid(4, temp);
                        }
                    }
                    else if(worksShift(pool.get(3), temp.getName())){
                        if((stationList.get(4).getEarlyMidPeopleNeeded() > stationList.get(4).getEarlyMid() || stationList.get(4).getLateMidPeopleNeeded() > stationList.get(4).getLateMid()) &&
                                stationList.get(4).getDinnerPeopleNeeded() > stationList.get(4).getTotalDinner()){
                            addAll(4, temp);
                        }
                    }
                }
                else {
                    masterList.get(4).get(0).add(temp);
                    pool.set(0, removeByName(temp.getName(), pool.get(0)));
                    stationList.get(4).addMorningStudent();
                }
            }
            if (stationList.get(5).getMorningPeopleNeeded() > stationList.get(5).getTotalMorning() && pool.get(0).size() != 0) { //fill mid
                Student temp = randomChooser(pool.get(0), 6);
                if(temp.getMultipleShifts()){
                    if((worksShift(pool.get(1), temp.getName()) || worksShift(pool.get(2), temp.getName()) )&& !(worksShift(pool.get(3), temp.getName()))){ //if they work Morning + Mid, add them to same station for both shifts
                        if(stationList.get(5).getEarlyMidPeopleNeeded() > stationList.get(5).getEarlyMid()){
                            addMorningEarlyMid(5, temp);
                        }
                        else if(neededMidMinShiftsFilled(stationList) && stationList.get(5).getEarlyMid() <= stationList.get(5).getEarlyMidMaxWorkers()){
                            addMorningEarlyMid(5, temp);
                        }
                    }
                    else if(worksShift(pool.get(3), temp.getName())){
                        if((stationList.get(5).getEarlyMidPeopleNeeded() > stationList.get(5).getEarlyMid() || stationList.get(5).getLateMidPeopleNeeded() > stationList.get(5).getLateMid()) &&
                                stationList.get(5).getDinnerPeopleNeeded() > stationList.get(5).getTotalDinner()){
                            addAll(5, temp);
                        }
                    }
                }
                else {
                    masterList.get(5).get(0).add(temp);
                    pool.set(0, removeByName(temp.getName(), pool.get(0)));
                    stationList.get(5).addMorningStudent();
                }
            }
            if (stationList.get(6).getMorningPeopleNeeded() > stationList.get(6).getTotalMorning() && pool.get(0).size() != 0) { //fill curry
                Student temp = randomChooser(pool.get(0), 7);
                if(temp.getMultipleShifts()){
                    if((worksShift(pool.get(1), temp.getName()) || worksShift(pool.get(2), temp.getName()) )&& !(worksShift(pool.get(3), temp.getName()))){ //if they work Morning + Mid, add them to same station for both shifts
                        if(stationList.get(6).getEarlyMidPeopleNeeded() > stationList.get(6).getEarlyMid()){
                            addMorningEarlyMid(6, temp);
                        }
                        else if(neededMidMinShiftsFilled(stationList) && stationList.get(6).getEarlyMid() <= stationList.get(6).getEarlyMidMaxWorkers()){
                            addMorningEarlyMid(6, temp);
                        }
                    }
                    else if(worksShift(pool.get(3), temp.getName())){
                        if((stationList.get(6).getEarlyMidPeopleNeeded() > stationList.get(6).getEarlyMid() || stationList.get(6).getLateMidPeopleNeeded() > stationList.get(6).getLateMid()) &&
                                stationList.get(6).getDinnerPeopleNeeded() > stationList.get(6).getTotalDinner()){
                            addAll(6, temp);
                        }
                    }
                }
                else {
                    masterList.get(6).get(0).add(temp);
                    pool.set(0, removeByName(temp.getName(), pool.get(0)));
                    stationList.get(6).addMorningStudent();
                }
            }
            if (stationList.get(7).getMorningPeopleNeeded() > stationList.get(7).getTotalMorning() && pool.get(0).size() != 0) { //fill grange
                Student temp = randomChooser(pool.get(0), 8);
                if(temp.getMultipleShifts()){
                    if((worksShift(pool.get(1), temp.getName()) || worksShift(pool.get(2), temp.getName()) )&& !(worksShift(pool.get(3), temp.getName()))){ //if they work Morning + Mid, add them to same station for both shifts
                        if(stationList.get(7).getEarlyMidPeopleNeeded() > stationList.get(7).getEarlyMid()){
                            addMorningEarlyMid(7, temp);
                        }
                        else if(neededMidMinShiftsFilled(stationList) && stationList.get(7).getEarlyMid() <= stationList.get(7).getEarlyMidMaxWorkers()){
                            addMorningEarlyMid(7, temp);
                        }
                    }
                    else if(worksShift(pool.get(3), temp.getName())){
                        if((stationList.get(7).getEarlyMidPeopleNeeded() > stationList.get(7).getEarlyMid() || stationList.get(7).getLateMidPeopleNeeded() > stationList.get(7).getLateMid()) &&
                                stationList.get(7).getDinnerPeopleNeeded() > stationList.get(7).getTotalDinner()){
                            addAll(7, temp);
                        }
                    }
                }
                else {
                    masterList.get(7).get(0).add(temp);
                    pool.set(0, removeByName(temp.getName(), pool.get(0)));
                    stationList.get(7).addMorningStudent();
                }
            }
            if (stationList.get(8).getMorningPeopleNeeded() > stationList.get(8).getTotalMorning() && pool.get(0).size() != 0) { //fill dish
                Student temp = randomChooser(pool.get(0), 9);
                if(temp.getMultipleShifts() == true){
                    if((worksShift(pool.get(1), temp.getName()) || worksShift(pool.get(2), temp.getName()) )&& !(worksShift(pool.get(3), temp.getName()))){ //if they work Morning + Mid, add them to same station for both shifts
                        if(stationList.get(8).getEarlyMidPeopleNeeded() > stationList.get(8).getEarlyMid()){
                            addMorningEarlyMid(8, temp);
                        }
                        else if(neededMidMinShiftsFilled(stationList) && stationList.get(8).getEarlyMid() <= stationList.get(8).getEarlyMidMaxWorkers()){
                            addMorningEarlyMid(0, temp);
                        }
                    }
                    else if(worksShift(pool.get(3), temp.getName())){
                        if((stationList.get(8).getEarlyMidPeopleNeeded() > stationList.get(8).getEarlyMid() || stationList.get(8).getLateMidPeopleNeeded() > stationList.get(8).getLateMid()) &&
                                stationList.get(8).getDinnerPeopleNeeded() > stationList.get(8).getTotalDinner()){
                            addAll(8, temp);
                        }
                    }
                }
                else {
                    masterList.get(8).get(0).add(temp);
                    pool.set(0, removeByName(temp.getName(), pool.get(0)));
                    stationList.get(8).addMorningStudent();
                }
            }
            if (stationList.get(9).getMorningPeopleNeeded() > stationList.get(8).getTotalMorning() && pool.get(0).size() != 0){  //fill dra
                Student temp = randomChooser(pool.get(0), 10);
                if(temp.getMultipleShifts()){
                    if((worksShift(pool.get(1), temp.getName()) || worksShift(pool.get(2), temp.getName()) )&& !(worksShift(pool.get(3), temp.getName()))){ //if they work Morning + Mid, add them to same station for both shifts
                        if(stationList.get(9).getEarlyMidPeopleNeeded() > stationList.get(9).getEarlyMid()){
                            addMorningEarlyMid(9, temp);
                        }
                        else if(neededMidMinShiftsFilled(stationList) && stationList.get(9).getEarlyMid() <= stationList.get(9).getEarlyMidMaxWorkers()){
                            addMorningEarlyMid(9, temp);
                        }
                    }
                    else if(worksShift(pool.get(3), temp.getName())){
                        if((stationList.get(9).getEarlyMidPeopleNeeded() > stationList.get(9).getEarlyMid() || stationList.get(9).getLateMidPeopleNeeded() > stationList.get(9).getLateMid()) &&
                                stationList.get(9).getDinnerPeopleNeeded() > stationList.get(9).getTotalDinner()){
                            addAll(9, temp);
                        }
                    }
                }
                else {
                    masterList.get(9).get(0).add(temp);
                    pool.set(0, removeByName(temp.getName(), pool.get(0)));
                    stationList.get(9).addMorningStudent();
                }
            }
            if (stationList.get(10).getMorningPeopleNeeded() > stationList.get(10).getTotalMorning() && pool.get(0).size() != 0){  //fill cold runner
                Student temp = randomChooser(pool.get(0), 11);
                if(temp.getMultipleShifts()){
                    if((worksShift(pool.get(1), temp.getName()) || worksShift(pool.get(2), temp.getName()) )&& !(worksShift(pool.get(3), temp.getName()))){ //if they work Morning + Mid, add them to same station for both shifts
                        if(stationList.get(10).getEarlyMidPeopleNeeded() > stationList.get(10).getEarlyMid()){
                            addMorningEarlyMid(10, temp);
                        }
                        else if(neededMidMinShiftsFilled(stationList) && stationList.get(10).getEarlyMid() <= stationList.get(10).getEarlyMidMaxWorkers()){
                            addMorningEarlyMid(10, temp);
                        }
                    }
                    else if(worksShift(pool.get(3), temp.getName())){
                        if((stationList.get(10).getEarlyMidPeopleNeeded() > stationList.get(10).getEarlyMid() || stationList.get(10).getLateMidPeopleNeeded() > stationList.get(10).getLateMid()) &&
                                stationList.get(10).getDinnerPeopleNeeded() > stationList.get(10).getTotalDinner()){
                            addAll(10, temp);
                        }
                    }
                }
                else {
                    masterList.get(10).get(0).add(temp);
                    pool.set(0, removeByName(temp.getName(), pool.get(0)));
                    stationList.get(10).addMorningStudent();
                }
            }
            if((stationList.get(0).getTotalMorning() >= stationList.get(0).getMorningPeopleNeeded()) &&
                    (stationList.get(1).getTotalMorning() >= stationList.get(1).getMorningPeopleNeeded()) &&
                    (stationList.get(2).getTotalMorning() >= stationList.get(2).getMorningPeopleNeeded()) &&
                    (stationList.get(3).getTotalMorning() >= stationList.get(3).getMorningPeopleNeeded()) &&
                    (stationList.get(4).getTotalMorning() >= stationList.get(4).getMorningPeopleNeeded()) &&
                    (stationList.get(5).getTotalMorning() >= stationList.get(5).getMorningPeopleNeeded()) &&
                    (stationList.get(7).getTotalMorning() >= stationList.get(7).getMorningPeopleNeeded()) &&
                    (stationList.get(8).getTotalMorning() >= stationList.get(8).getMorningPeopleNeeded()) &&
                    (stationList.get(9).getTotalMorning() >= stationList.get(9).getMorningPeopleNeeded()) &&
                    (stationList.get(10).getTotalMorning() >= stationList.get(10).getMorningPeopleNeeded()) &&
                    (stationList.get(11).getTotalMorning() < stationList.get(11).getMorningPeopleNeeded()) && pool.get(0).size() != 0){   //fill jan if other stations meet minimum (until jan meets its min)
                Student temp = randomChooser(pool.get(0), 12);
                if(temp.getMultipleShifts()){
                    if((worksShift(pool.get(1), temp.getName()) || worksShift(pool.get(2), temp.getName()) )&& !(worksShift(pool.get(3), temp.getName()))){ //if they work Morning + Mid, add them to same station for both shifts
                        if(stationList.get(11).getEarlyMidPeopleNeeded() > stationList.get(11).getEarlyMid()){
                            addMorningEarlyMid(11, temp);
                        }
                    }
                    else if(worksShift(pool.get(3), temp.getName())){
                        if((stationList.get(11).getEarlyMidPeopleNeeded() > stationList.get(11).getEarlyMid() || stationList.get(11).getLateMidPeopleNeeded() > stationList.get(11).getLateMid()) &&
                                stationList.get(11).getDinnerPeopleNeeded() > stationList.get(11).getTotalDinner()){
                            addAll(11, temp);
                        }
                    }
                }
                else {
                    masterList.get(11).get(0).add(temp);
                    pool.set(0, removeByName(temp.getName(), pool.get(0)));
                    stationList.get(11).addMorningStudent();
                }
            }
            if( (stationList.get(0).getTotalMorning() >= stationList.get(0).getMorningPeopleNeeded()) &&
                    (stationList.get(1).getTotalMorning() >= stationList.get(1).getMorningPeopleNeeded()) &&
                    (stationList.get(2).getTotalMorning() >= stationList.get(2).getMorningPeopleNeeded()) &&
                    (stationList.get(3).getTotalMorning() >= stationList.get(3).getMorningPeopleNeeded()) &&
                    (stationList.get(4).getTotalMorning() >= stationList.get(4).getMorningPeopleNeeded()) &&
                    (stationList.get(5).getTotalMorning() >= stationList.get(5).getMorningPeopleNeeded()) &&
                    (stationList.get(7).getTotalMorning() >= stationList.get(7).getMorningPeopleNeeded()) &&
                    (stationList.get(8).getTotalMorning() >= stationList.get(8).getMorningPeopleNeeded()) &&
                    (stationList.get(9).getTotalMorning() >= stationList.get(9).getMorningPeopleNeeded()) &&
                    (stationList.get(10).getTotalMorning() >= stationList.get(10).getMorningPeopleNeeded()) &&
                    (stationList.get(11).getTotalMorning() >= stationList.get(11).getMorningPeopleNeeded()) && pool.get(0).size() != 0){  //if all stations meet minimum requirements, start filling to max
                while(pool.get(0).size() > 0){ //order switched so extras go where help is more needed first
                    if (stationList.get(8).getMorningMaxWorkers() > stationList.get(8).getTotalMorning() && pool.get(0).size() != 0) {  //fill dish
                        Student temp = randomChooser(pool.get(0), 9);
                        if(temp.getMultipleShifts() == true){
                            if((worksShift(pool.get(1), temp.getName()) || worksShift(pool.get(2), temp.getName()) )&& !(worksShift(pool.get(3), temp.getName()))){ //if they work Morning + Mid, add them to same station for both shifts
                                if(stationList.get(8).getEarlyMidPeopleNeeded() > stationList.get(8).getEarlyMid()){
                                    addMorningEarlyMid(8, temp);
                                }
                                else{
                                    if(availableMidMinShiftsFilled(stationList)){
                                        if(stationList.get(8).getEarlyMidMaxWorkers() > stationList.get(8).getEarlyMid()){
                                            addMorningEarlyMid(8, temp);
                                        }
                                    }
                                }
                            }
                            else if(worksShift(pool.get(3), temp.getName())){
                                if((stationList.get(8).getEarlyMidPeopleNeeded() > stationList.get(8).getEarlyMid() || stationList.get(8).getLateMidPeopleNeeded() > stationList.get(8).getLateMid()) &&
                                        stationList.get(8).getDinnerPeopleNeeded() > stationList.get(8).getTotalDinner()){
                                    addAll(8, temp);
                                }
                                else{
                                    if(availableMidMinShiftsFilled(stationList) && availableCloseMinShiftsFilled(stationList, 0) ){
                                        if(stationList.get(8).getDinnerMaxWorkers() > stationList.get(8).getTotalDinner() && stationList.get(8).getEarlyMidMaxWorkers() > stationList.get(8).getEarlyMid()){
                                            addAll(8, temp);


                                        }
                                    }
                                }
                            }
                        }
                        else {
                            masterList.get(8).get(0).add(temp);
                            pool.set(0, removeByName(temp.getName(), pool.get(0)));
                            stationList.get(8).addMorningStudent();
                        }
                    }
                    if (stationList.get(1).getMorningMaxWorkers() > stationList.get(1).getTotalMorning() && pool.get(0).size() != 0) { // fill peaks
                        Student temp = randomChooser(pool.get(0), 2);
                        if(temp.getMultipleShifts()){
                            if((worksShift(pool.get(1), temp.getName()) || worksShift(pool.get(2), temp.getName()) )&& !(worksShift(pool.get(3), temp.getName()))){ //if they work Morning + Mid, add them to same station for both shifts
                                if(stationList.get(1).getEarlyMidPeopleNeeded() > stationList.get(1).getEarlyMid()){
                                    addMorningEarlyMid(1, temp);
                                }
                                else{
                                    if(availableMidMinShiftsFilled(stationList)){
                                        if(stationList.get(1).getEarlyMidMaxWorkers() > stationList.get(1).getEarlyMid()){
                                            addMorningEarlyMid(1, temp);
                                        }
                                    }
                                }
                            }
                            else if(worksShift(pool.get(3), temp.getName())){
                                if((stationList.get(1).getEarlyMidPeopleNeeded() > stationList.get(1).getEarlyMid() || stationList.get(1).getLateMidPeopleNeeded() > stationList.get(1).getLateMid()) &&
                                        stationList.get(1).getDinnerPeopleNeeded() > stationList.get(1).getTotalDinner()){
                                    addAll(1, temp);
                                }
                                else{
                                    if(availableMidMinShiftsFilled(stationList) && availableCloseMinShiftsFilled(stationList, 0)){
                                        if(stationList.get(1).getDinnerMaxWorkers() > stationList.get(1).getTotalDinner() && stationList.get(1).getEarlyMidMaxWorkers() > stationList.get(1).getEarlyMid()){
                                            addAll(1, temp);


                                        }
                                    }
                                }
                            }
                        }
                        else {
                            masterList.get(1).get(0).add(temp);
                            pool.set(0, removeByName(temp.getName(), pool.get(0)));
                            stationList.get(1).addMorningStudent();
                        }
                    }
                    if (stationList.get(10).getMorningMaxWorkers() > stationList.get(10).getTotalMorning() && pool.get(0).size() != 0){ //fill cold runner
                        Student temp = randomChooser(pool.get(0), 11);
                        if(temp.getMultipleShifts()){
                            if((worksShift(pool.get(1), temp.getName()) || worksShift(pool.get(2), temp.getName()) )&& !(worksShift(pool.get(3), temp.getName()))){ //if they work Morning + Mid, add them to same station for both shifts
                                if(stationList.get(10).getEarlyMidPeopleNeeded() > stationList.get(10).getEarlyMid()){
                                    addMorningEarlyMid(10, temp);
                                }
                                else{
                                    if(availableMidMinShiftsFilled(stationList)){
                                        if(stationList.get(10).getEarlyMidMaxWorkers() > stationList.get(10).getEarlyMid()){
                                            addMorningEarlyMid(10, temp);
                                        }
                                    }
                                }
                            }
                            else if(worksShift(pool.get(3), temp.getName())){
                                if((stationList.get(10).getEarlyMidPeopleNeeded() > stationList.get(10).getEarlyMid() || stationList.get(10).getLateMidPeopleNeeded() > stationList.get(10).getLateMid()) &&
                                        stationList.get(10).getDinnerPeopleNeeded() > stationList.get(10).getTotalDinner()){
                                    addAll(10, temp);
                                }
                                else{
                                    if(availableMidMinShiftsFilled(stationList)&& availableCloseMinShiftsFilled(stationList, 0)){
                                        if(stationList.get(10).getDinnerMaxWorkers() > stationList.get(10).getTotalDinner() && stationList.get(10).getEarlyMidMaxWorkers() > stationList.get(10).getEarlyMid()){
                                            addAll(10, temp);
                                        }
                                    }
                                }
                            }
                        }
                        else {
                            masterList.get(10).get(0).add(temp);
                            pool.set(0, removeByName(temp.getName(), pool.get(0)));
                            stationList.get(10).addMorningStudent();
                        }
                    }
                    if (stationList.get(2).getMorningMaxWorkers() > stationList.get(2).getTotalMorning() && pool.get(0).size() != 0) { // fill hearth
                        Student temp = randomChooser(pool.get(0), 3);
                        if(temp.getMultipleShifts()){
                            if((worksShift(pool.get(1), temp.getName()) || worksShift(pool.get(2), temp.getName()) )&& !(worksShift(pool.get(3), temp.getName()))){ //if they work Morning + Mid, add them to same station for both shifts
                                if(stationList.get(2).getEarlyMidPeopleNeeded() > stationList.get(2).getEarlyMid()){
                                    addMorningEarlyMid(2, temp);
                                }
                                else{
                                    if(availableMidMinShiftsFilled(stationList)){
                                        if(stationList.get(2).getEarlyMidMaxWorkers() > stationList.get(2).getEarlyMid()){
                                            addMorningEarlyMid(2, temp);
                                        }
                                    }
                                }
                            }
                            else if(worksShift(pool.get(3), temp.getName())){
                                if((stationList.get(2).getEarlyMidPeopleNeeded() > stationList.get(2).getEarlyMid() || stationList.get(2).getLateMidPeopleNeeded() > stationList.get(2).getLateMid()) &&
                                        stationList.get(2).getDinnerPeopleNeeded() > stationList.get(2).getTotalDinner()){
                                    addAll(2, temp);
                                }
                                else{
                                    if(availableMidMinShiftsFilled(stationList) && availableCloseMinShiftsFilled(stationList, 0)){
                                        if(stationList.get(2).getDinnerMaxWorkers() > stationList.get(2).getTotalDinner() && stationList.get(2).getEarlyMidMaxWorkers() > stationList.get(2).getEarlyMid()){
                                            addAll(2, temp);
                                        }
                                    }
                                }
                            }
                        }
                        else {
                            masterList.get(2).get(0).add(temp);
                            pool.set(0, removeByName(temp.getName(), pool.get(0)));
                            stationList.get(2).addMorningStudent();
                        }
                    }
                    if (stationList.get(3).getMorningMaxWorkers() > stationList.get(3).getTotalMorning() && pool.get(0).size() != 0) { // fill salads
                        Student temp = randomChooser(pool.get(0), 4);
                        if(temp.getMultipleShifts()){
                            if((worksShift(pool.get(1), temp.getName()) || worksShift(pool.get(2), temp.getName()) )&& !(worksShift(pool.get(3), temp.getName()))){ //if they work Morning + Mid, add them to same station for both shifts
                                if(stationList.get(3).getEarlyMidPeopleNeeded() > stationList.get(3).getEarlyMid()){
                                    addMorningEarlyMid(3, temp);
                                }
                                else{
                                    if(availableMidMinShiftsFilled(stationList)){
                                        if(stationList.get(3).getEarlyMidMaxWorkers() > stationList.get(3).getEarlyMid()){
                                            addMorningEarlyMid(3, temp);
                                        }
                                    }
                                }
                            }
                            else if(worksShift(pool.get(3), temp.getName())){
                                if((stationList.get(3).getEarlyMidPeopleNeeded() > stationList.get(3).getEarlyMid() || stationList.get(3).getLateMidPeopleNeeded() > stationList.get(3).getLateMid()) &&
                                        stationList.get(3).getDinnerPeopleNeeded() > stationList.get(3).getTotalDinner()){
                                    addAll(3, temp);
                                }
                                else{
                                    if(availableMidMinShiftsFilled(stationList)&& availableCloseMinShiftsFilled(stationList, 0)){
                                        if(stationList.get(3).getDinnerMaxWorkers() > stationList.get(3).getTotalDinner() && stationList.get(3).getEarlyMidMaxWorkers() > stationList.get(3).getEarlyMid()){
                                            addAll(3, temp);
                                        }
                                    }
                                }
                            }
                        }
                        else {
                            masterList.get(3).get(0).add(temp);
                            pool.set(0, removeByName(temp.getName(), pool.get(0)));
                            stationList.get(3).addMorningStudent();
                        }
                    }
                    if (stationList.get(4).getMorningMaxWorkers() > stationList.get(4).getTotalMorning() && pool.get(0).size() != 0) { //fill toast
                        Student temp = randomChooser(pool.get(0), 5);
                        if(temp.getMultipleShifts()){
                            if((worksShift(pool.get(1), temp.getName()) || worksShift(pool.get(2), temp.getName()) )&& !(worksShift(pool.get(3), temp.getName()))){ //if they work Morning + Mid, add them to same station for both shifts
                                if(stationList.get(4).getEarlyMidPeopleNeeded() > stationList.get(4).getEarlyMid()){
                                    addMorningEarlyMid(4, temp);
                                }
                                else{
                                    if(availableMidMinShiftsFilled(stationList)){
                                        if(stationList.get(4).getEarlyMidMaxWorkers() > stationList.get(4).getEarlyMid()){
                                            addMorningEarlyMid(4, temp);
                                        }
                                    }
                                }
                            }
                            else if(worksShift(pool.get(3), temp.getName())){
                                if((stationList.get(4).getEarlyMidPeopleNeeded() > stationList.get(4).getEarlyMid() || stationList.get(4).getLateMidPeopleNeeded() > stationList.get(4).getLateMid()) &&
                                        stationList.get(4).getDinnerPeopleNeeded() > stationList.get(4).getTotalDinner()){
                                    addAll(4, temp);
                                }
                                else{
                                    if(availableMidMinShiftsFilled(stationList) && availableCloseMinShiftsFilled(stationList, 0)){
                                        if(stationList.get(4).getDinnerMaxWorkers() > stationList.get(4).getTotalDinner() && stationList.get(4).getEarlyMidMaxWorkers() > stationList.get(4).getEarlyMid()){
                                            addAll(4, temp);
                                        }
                                    }
                                }
                            }
                        }
                        else {
                            masterList.get(4).get(0).add(temp);
                            pool.set(0, removeByName(temp.getName(), pool.get(0)));
                            stationList.get(4).addMorningStudent();
                        }
                    }
                    if (stationList.get(5).getMorningMaxWorkers() > stationList.get(5).getTotalMorning() && pool.get(0).size() != 0) { //fill mid
                        Student temp = randomChooser(pool.get(0), 6);
                        if(temp.getMultipleShifts()){
                            if((worksShift(pool.get(1), temp.getName()) || worksShift(pool.get(2), temp.getName()) )&& !(worksShift(pool.get(3), temp.getName()))){ //if they work Morning + Mid, add them to same station for both shifts
                                if(stationList.get(5).getEarlyMidPeopleNeeded() > stationList.get(5).getEarlyMid()){
                                    addMorningEarlyMid(5, temp);
                                }
                                else{
                                    if(availableMidMinShiftsFilled(stationList)){
                                        if(stationList.get(5).getEarlyMidMaxWorkers() > stationList.get(8).getEarlyMid()){
                                            addMorningEarlyMid(5, temp);
                                        }
                                    }
                                }
                            }
                            else if(worksShift(pool.get(3), temp.getName())){
                                if((stationList.get(5).getEarlyMidPeopleNeeded() > stationList.get(5).getEarlyMid() || stationList.get(5).getLateMidPeopleNeeded() > stationList.get(5).getLateMid()) &&
                                        stationList.get(5).getDinnerPeopleNeeded() > stationList.get(5).getTotalDinner()){
                                    addAll(5, temp);
                                }
                                else{
                                    if(availableMidMinShiftsFilled(stationList) && availableCloseMinShiftsFilled(stationList, 0)){
                                        if(stationList.get(5).getDinnerMaxWorkers() > stationList.get(5).getTotalDinner() && stationList.get(5).getEarlyMidMaxWorkers() > stationList.get(5).getEarlyMid()){
                                            addAll(5, temp);


                                        }
                                    }
                                }
                            }
                        }
                        else {
                            masterList.get(5).get(0).add(temp);
                            pool.set(0, removeByName(temp.getName(), pool.get(0)));
                            stationList.get(5).addMorningStudent();
                        }
                    }
                    if (stationList.get(6).getMorningMaxWorkers() > stationList.get(6).getTotalMorning() && pool.get(0).size() != 0) { //fill curry
                        Student temp = randomChooser(pool.get(0), 7);
                        if(temp.getMultipleShifts()){
                            if((worksShift(pool.get(1), temp.getName()) || worksShift(pool.get(2), temp.getName()) )&& !(worksShift(pool.get(3), temp.getName()))){ //if they work Morning + Mid, add them to same station for both shifts
                                if(stationList.get(6).getEarlyMidPeopleNeeded() > stationList.get(6).getEarlyMid()){
                                    addMorningEarlyMid(6, temp);
                                }
                                else{
                                    if(availableMidMinShiftsFilled(stationList)){
                                        if(stationList.get(6).getEarlyMidMaxWorkers() > stationList.get(6).getEarlyMid()){
                                            addMorningEarlyMid(6, temp);
                                        }
                                    }
                                }
                            }
                            else if(worksShift(pool.get(3), temp.getName())){
                                if((stationList.get(6).getEarlyMidPeopleNeeded() > stationList.get(6).getEarlyMid() || stationList.get(6).getLateMidPeopleNeeded() > stationList.get(6).getLateMid()) &&
                                        stationList.get(6).getDinnerPeopleNeeded() > stationList.get(6).getTotalDinner()){
                                    addAll(6, temp);
                                }
                                else{
                                    if(availableMidMinShiftsFilled(stationList) && availableCloseMinShiftsFilled(stationList, 0)){
                                        if(stationList.get(6).getDinnerMaxWorkers() > stationList.get(6).getTotalDinner() && stationList.get(6).getEarlyMidMaxWorkers() > stationList.get(6).getEarlyMid()){
                                            addAll(6, temp);
                                        }
                                    }
                                }
                            }
                        }
                        else {
                            masterList.get(6).get(0).add(temp);
                            pool.set(0, removeByName(temp.getName(), pool.get(0)));
                            stationList.get(6).addMorningStudent();
                        }
                    }
                    if (stationList.get(7).getMorningMaxWorkers() > stationList.get(7).getTotalMorning() && pool.get(0).size() != 0) { //fill grange
                        Student temp = randomChooser(pool.get(0), 8);
                        if(temp.getMultipleShifts()){
                            if((worksShift(pool.get(1), temp.getName()) || worksShift(pool.get(2), temp.getName()) )&& !(worksShift(pool.get(3), temp.getName()))){ //if they work Morning + Mid, add them to same station for both shifts
                                if(stationList.get(7).getEarlyMidPeopleNeeded() > stationList.get(11).getEarlyMid()){
                                    addMorningEarlyMid(7, temp);
                                }
                                else{
                                    if(availableMidMinShiftsFilled(stationList)){
                                        if(stationList.get(7).getEarlyMidMaxWorkers() > stationList.get(7).getEarlyMid()){
                                            addMorningEarlyMid(7, temp);
                                        }
                                    }
                                }
                            }
                            else if(worksShift(pool.get(3), temp.getName())){
                                if((stationList.get(7).getEarlyMidPeopleNeeded() > stationList.get(7).getEarlyMid() || stationList.get(7).getLateMidPeopleNeeded() > stationList.get(7).getLateMid()) &&
                                        stationList.get(7).getDinnerPeopleNeeded() > stationList.get(7).getTotalDinner()){
                                    addAll(7, temp);
                                }
                                else{
                                    if(availableMidMinShiftsFilled(stationList) && availableCloseMinShiftsFilled(stationList, 0)){
                                        if(stationList.get(7).getDinnerMaxWorkers() > stationList.get(7).getTotalDinner() && stationList.get(7).getEarlyMidMaxWorkers() > stationList.get(7).getEarlyMid()){
                                            addAll(7, temp);


                                        }
                                    }
                                }
                            }
                        }
                        else {
                            masterList.get(7).get(0).add(temp);
                            pool.set(0, removeByName(temp.getName(), pool.get(0)));
                            stationList.get(7).addMorningStudent();
                        }
                    }
                    if (stationList.get(9).getMorningMaxWorkers() > stationList.get(9).getTotalMorning() && pool.get(0).size() != 0) { //fill dra
                        Student temp = randomChooser(pool.get(0), 10);
                        if(temp.getMultipleShifts()){
                            if((worksShift(pool.get(1), temp.getName()) || worksShift(pool.get(2), temp.getName()) )&& !(worksShift(pool.get(3), temp.getName()))){ //if they work Morning + Mid, add them to same station for both shifts
                                if(stationList.get(9).getEarlyMidPeopleNeeded() > stationList.get(9).getEarlyMid()){
                                    addMorningEarlyMid(9, temp);
                                }
                                else{
                                    if(availableMidMinShiftsFilled(stationList)){
                                        if(stationList.get(9).getEarlyMidMaxWorkers() > stationList.get(9).getEarlyMid()){
                                            addMorningEarlyMid(9, temp);
                                        }
                                    }
                                }
                            }
                            else if(worksShift(pool.get(3), temp.getName())){
                                if((stationList.get(9).getEarlyMidPeopleNeeded() > stationList.get(9).getEarlyMid() || stationList.get(9).getLateMidPeopleNeeded() > stationList.get(9).getLateMid()) &&
                                        stationList.get(9).getDinnerPeopleNeeded() > stationList.get(9).getTotalDinner()){
                                    addAll(9, temp);
                                }
                                else{
                                    if(availableMidMinShiftsFilled(stationList) && availableCloseMinShiftsFilled(stationList, 0)){
                                        if(stationList.get(9).getDinnerMaxWorkers() > stationList.get(9).getTotalDinner() && stationList.get(9).getEarlyMidMaxWorkers() > stationList.get(9).getEarlyMid()){
                                            addAll(9, temp);
                                        }
                                    }
                                }
                            }
                        }
                        else {
                            masterList.get(9).get(0).add(temp);
                            pool.set(0, removeByName(temp.getName(), pool.get(0)));
                            stationList.get(9).addMorningStudent();
                        }
                    }
                    if (stationList.get(0).getMorningMaxWorkers() > stationList.get(0).getTotalMorning() && pool.get(0).size() != 0){  //fill check
                        Student temp = randomChooser(pool.get(0), 1);
                        if(temp.getMultipleShifts()){
                            if((worksShift(pool.get(1), temp.getName()) || worksShift(pool.get(2), temp.getName()) )&& !(worksShift(pool.get(3), temp.getName()))){ //if they work Morning + Mid, add them to same station for both shifts
                                if(stationList.get(0).getEarlyMidPeopleNeeded() > stationList.get(0).getEarlyMid()){
                                    addMorningEarlyMid(0, temp);
                                }
                                else{
                                    if(availableMidMinShiftsFilled(stationList)){
                                        if(stationList.get(0).getEarlyMidMaxWorkers() > stationList.get(0).getEarlyMid()){
                                            addMorningEarlyMid(0, temp);
                                        }
                                    }
                                }
                            }
                            else if(worksShift(pool.get(3), temp.getName())){
                                if((stationList.get(0).getEarlyMidPeopleNeeded() > stationList.get(0).getEarlyMid() || stationList.get(0).getLateMidPeopleNeeded() > stationList.get(0).getLateMid()) &&
                                        stationList.get(0).getDinnerPeopleNeeded() > stationList.get(0).getTotalDinner()){
                                    addAll(0, temp);
                                }
                                else{
                                    if(availableMidMinShiftsFilled(stationList) && availableCloseMinShiftsFilled(stationList, 0)){
                                        if(stationList.get(0).getDinnerMaxWorkers() > stationList.get(0).getTotalDinner() && stationList.get(0).getEarlyMidMaxWorkers() > stationList.get(0).getEarlyMid()){
                                            addAll(0, temp);
                                        }
                                    }
                                }
                            }
                        }
                        else {
                            masterList.get(0).get(0).add(temp);
                            pool.set(0, removeByName(temp.getName(), pool.get(0)));
                            stationList.get(0).addMorningStudent();
                        }
                    }
                    if(stationList.get(11).getMorningMaxWorkers() > stationList.get(11).getTotalMorning() && pool.get(0).size() != 0){
                        Student temp = randomChooser(pool.get(0), 12);
                        if(temp.getMultipleShifts()){
                            if((worksShift(pool.get(1), temp.getName()) || worksShift(pool.get(2), temp.getName()) )&& !(worksShift(pool.get(3), temp.getName()))){ //if they work Morning + Mid, add them to same station for both shifts
                                if(stationList.get(11).getEarlyMidPeopleNeeded() > stationList.get(11).getEarlyMid()){
                                    addMorningEarlyMid(11, temp);
                                }
                                else{
                                    if(availableMidMinShiftsFilled(stationList)){
                                        if(stationList.get(11).getEarlyMidMaxWorkers() > stationList.get(11).getEarlyMid()){
                                            addMorningEarlyMid(11, temp);
                                        }
                                    }
                                }
                            }
                            else if(worksShift(pool.get(3), temp.getName())){
                                if((stationList.get(11).getEarlyMidPeopleNeeded() > stationList.get(11).getEarlyMid() || stationList.get(11).getLateMidPeopleNeeded() > stationList.get(11).getLateMid()) &&
                                        stationList.get(11).getDinnerPeopleNeeded() > stationList.get(11).getTotalDinner()){
                                    addAll(11, temp);
                                }
                                else{
                                    if(availableMidMinShiftsFilled(stationList) && availableCloseMinShiftsFilled(stationList, 0)){
                                        if(stationList.get(11).getDinnerMaxWorkers() > stationList.get(11).getTotalDinner() && stationList.get(11).getEarlyMidMaxWorkers() > stationList.get(11).getEarlyMid()){
                                            addAll(11, temp);
                                        }
                                    }
                                }
                            }
                        }
                        else {
                            masterList.get(11).get(0).add(temp);
                            pool.set(0, removeByName(temp.getName(), pool.get(0)));
                            stationList.get(11).addMorningStudent();
                        }
                    }
                    if((stationList.get(0).getTotalMorning() >= stationList.get(0).getMorningMaxWorkers()) &&
                            (stationList.get(1).getTotalMorning() >= stationList.get(1).getMorningMaxWorkers()) &&
                            (stationList.get(2).getTotalMorning() >= stationList.get(2).getMorningMaxWorkers()) &&
                            (stationList.get(3).getTotalMorning() >= stationList.get(3).getMorningMaxWorkers()) &&
                            (stationList.get(4).getTotalMorning() >= stationList.get(4).getMorningMaxWorkers()) &&
                            (stationList.get(5).getTotalMorning() >= stationList.get(5).getMorningMaxWorkers()) &&
                            (stationList.get(7).getTotalMorning() >= stationList.get(7).getMorningMaxWorkers()) &&
                            (stationList.get(8).getTotalMorning() >= stationList.get(8).getMorningMaxWorkers()) &&
                            (stationList.get(9).getTotalMorning() >= stationList.get(9).getMorningMaxWorkers()) &&
                            (stationList.get(10).getTotalMorning() >= stationList.get(10).getMorningMaxWorkers()) &&
                            (stationList.get(11).getTotalMorning() >= stationList.get(11).getMorningMaxWorkers()) &&pool.get(0).size() != 0) { //if all stations at max -> go to dish? //TODO: ask ryan what he prefers to happen here
                        Student temp = randomChooser(pool.get(0), 9);
                        if(temp.getMultipleShifts()){
                            if((worksShift(pool.get(1), temp.getName()) || worksShift(pool.get(2), temp.getName()) )&& !(worksShift(pool.get(3), temp.getName()))){ //if they work Morning + Mid, add them to same station for both shifts
                                if(stationList.get(8).getEarlyMidPeopleNeeded() > stationList.get(8).getEarlyMid()){
                                    addMorningEarlyMid(8, temp);
                                }
                                else{
                                    if(availableMidMinShiftsFilled(stationList)){
                                        if(stationList.get(8).getEarlyMidMaxWorkers() > stationList.get(8).getEarlyMid()){
                                            addMorningEarlyMid(8, temp);
                                        }
                                    }
                                }
                            }
                            else if(worksShift(pool.get(3), temp.getName())){
                                if((stationList.get(8).getEarlyMidPeopleNeeded() > stationList.get(8).getEarlyMid() || stationList.get(8).getLateMidPeopleNeeded() > stationList.get(8).getLateMid()) &&
                                        stationList.get(8).getDinnerPeopleNeeded() > stationList.get(8).getTotalDinner()){
                                    addAll(8, temp);
                                }
                                else{
                                    if(availableMidMinShiftsFilled(stationList) && availableCloseMinShiftsFilled(stationList, 0)){
                                        if(stationList.get(8).getDinnerMaxWorkers() > stationList.get(8).getTotalDinner() && stationList.get(8).getEarlyMidMaxWorkers() > stationList.get(8).getEarlyMid()){
                                            addAll(8, temp);
                                        }
                                    }
                                }
                            }
                        }
                        else {
                            masterList.get(8).get(0).add(temp);
                            pool.set(0, removeByName(temp.getName(), pool.get(0)));
                            stationList.get(8).addMorningStudent();
                        }
                    }

                }
            }

        }

        while(pool.get(1).size() > 0) {
            System.out.println("hang5");
            if (stationList.get(0).getEarlyMidPeopleNeeded() > stationList.get(0).getEarlyMid() && pool.get(1).size() != 0) {  // fill checker
                Student temp = randomChooser(pool.get(1), 1);
                if(temp.getMultipleShifts()){
                    if(((worksShift(pool.get(3), temp.getName())))){ //works from mid until close
                        if(stationList.get(0).getDinnerPeopleNeeded() > stationList.get(0).getTotalDinner()){
                            addEarlyLateDinner(0, temp);
                        }
                        else{
                            if(availableCloseMinShiftsFilled(stationList, 1)){
                                if(stationList.get(0).getDinnerMaxWorkers() > stationList.get(0).getTotalDinner()){
                                    addEarlyLateDinner(0, temp);
                                }
                            }
                        }
                    }

                }
                else {
                    masterList.get(0).get(1).add(temp);
                    pool.set(1,removeByName(temp.getName(), pool.get(1)) ) ;
                    stationList.get(0).addEarlyMidStudent();
                }

            }
            if (stationList.get(1).getEarlyMidPeopleNeeded() > stationList.get(1).getEarlyMid() && pool.get(1).size() != 0) { // fill peaks
                Student temp = randomChooser(pool.get(1), 2);
                if(temp.getMultipleShifts()){
                    if(((worksShift(pool.get(3), temp.getName())))){ //works from mid until close
                        if(stationList.get(1).getDinnerPeopleNeeded() > stationList.get(1).getTotalDinner()){
                            addEarlyLateDinner(1, temp);
                        }
                        else{
                            if(availableCloseMinShiftsFilled(stationList, 1)){
                                if(stationList.get(1).getDinnerMaxWorkers() > stationList.get(1).getTotalDinner()){
                                    addEarlyLateDinner(1, temp);
                                }
                            }
                        }
                    }

                }
                else {
                    masterList.get(1).get(1).add(temp);
                    pool.set(1, removeByName(temp.getName(), pool.get(1)));
                    stationList.get(1).addEarlyMidStudent();
                }
            }
            if (stationList.get(2).getEarlyMidPeopleNeeded() > stationList.get(2).getEarlyMid() && pool.get(1).size() != 0) { // fill hearth
                Student temp = randomChooser(pool.get(1), 3);
                if(temp.getMultipleShifts()){
                    if(((worksShift(pool.get(3), temp.getName())))){ //works from mid until close
                        if(stationList.get(2).getDinnerPeopleNeeded() > stationList.get(2).getTotalDinner()){
                            addEarlyLateDinner(2, temp);
                        }
                        else{
                            if(availableCloseMinShiftsFilled(stationList, 1)){
                                if(stationList.get(2).getDinnerMaxWorkers() > stationList.get(2).getTotalDinner()){
                                    addEarlyLateDinner(2, temp);
                                }
                            }
                        }
                    }

                }
                else {
                    masterList.get(2).get(1).add(temp);
                    pool.set(1, removeByName(temp.getName(), pool.get(1)));
                    stationList.get(2).addEarlyMidStudent();
                }
            }
            if (stationList.get(3).getEarlyMidPeopleNeeded() > stationList.get(3).getEarlyMid() && pool.get(1).size() != 0) { // fill salads
                Student temp = randomChooser(pool.get(1), 4);
                if(temp.getMultipleShifts()){
                    if(((worksShift(pool.get(3), temp.getName())))){ //works from mid until close
                        if(stationList.get(3).getDinnerPeopleNeeded() > stationList.get(3).getTotalDinner()){
                            addEarlyLateDinner(3, temp);
                        }
                        else{
                            if(availableCloseMinShiftsFilled(stationList, 1)){
                                if(stationList.get(3).getDinnerMaxWorkers() > stationList.get(3).getTotalDinner()){
                                    addEarlyLateDinner(3, temp);
                                }
                            }
                        }
                    }

                }
                else {
                    masterList.get(3).get(1).add(temp);
                    pool.set(1, removeByName(temp.getName(), pool.get(1)));
                    stationList.get(3).addEarlyMidStudent();
                }
            }
            if (stationList.get(4).getEarlyMidPeopleNeeded() > stationList.get(4).getEarlyMid() && pool.get(1).size() != 0) { //fill toast
                Student temp = randomChooser(pool.get(1), 5);
                if(temp.getMultipleShifts()){
                    if(((worksShift(pool.get(3), temp.getName())))){ //works from mid until close
                        if(stationList.get(4).getDinnerPeopleNeeded() > stationList.get(4).getTotalDinner()){
                            addEarlyLateDinner(4, temp);
                        }
                        else{
                            if(availableCloseMinShiftsFilled(stationList, 1)){
                                if(stationList.get(4).getDinnerMaxWorkers() > stationList.get(4).getTotalDinner()){
                                    addEarlyLateDinner(4, temp);
                                }
                            }
                        }
                    }

                }
                else {
                    masterList.get(4).get(1).add(temp);
                    pool.set(1, removeByName(temp.getName(), pool.get(1)));
                    stationList.get(4).addEarlyMidStudent();
                }
            }
            if (stationList.get(5).getEarlyMidPeopleNeeded() > stationList.get(5).getEarlyMid() && pool.get(1).size() != 0) { //fill mid
                Student temp = randomChooser(pool.get(1), 6);
                if(temp.getMultipleShifts()){
                    if(((worksShift(pool.get(3), temp.getName())))){ //works from mid until close
                        if(stationList.get(5).getDinnerPeopleNeeded() > stationList.get(5).getTotalDinner()){
                            addEarlyLateDinner(5, temp);
                        }
                        else{
                            if(availableCloseMinShiftsFilled(stationList, 1)){
                                if(stationList.get(5).getDinnerMaxWorkers() > stationList.get(5).getTotalDinner()){
                                    addEarlyLateDinner(5, temp);
                                }
                            }
                        }
                    }

                }
                else {
                    masterList.get(5).get(1).add(temp);
                    pool.set(1, removeByName(temp.getName(), pool.get(1)));
                    stationList.get(5).addEarlyMidStudent();
                }
            }
            if (stationList.get(6).getEarlyMidPeopleNeeded() > stationList.get(6).getEarlyMid() && pool.get(1).size() != 0) { //fill curry
                Student temp = randomChooser(pool.get(1), 7);
                if(temp.getMultipleShifts()){
                    if(((worksShift(pool.get(3), temp.getName())))){ //works from mid until close
                        if(stationList.get(6).getDinnerPeopleNeeded() > stationList.get(6).getTotalDinner()){
                            addEarlyLateDinner(6, temp);
                        }
                        else{
                            if(availableCloseMinShiftsFilled(stationList, 1)){
                                if(stationList.get(6).getDinnerMaxWorkers() > stationList.get(6).getTotalDinner()){
                                    addEarlyLateDinner(6, temp);
                                }
                            }
                        }
                    }

                }
                else {
                    masterList.get(6).get(1).add(temp);
                    pool.set(1, removeByName(temp.getName(), pool.get(1)));
                    stationList.get(6).addEarlyMidStudent();
                }
            }
            if (stationList.get(7).getEarlyMidPeopleNeeded() > stationList.get(7).getEarlyMid() && pool.get(1).size() != 0) { //fill grange
                Student temp = randomChooser(pool.get(1), 8);
                if(temp.getMultipleShifts()){
                    if(((worksShift(pool.get(3), temp.getName())))){ //works from mid until close
                        if(stationList.get(7).getDinnerPeopleNeeded() > stationList.get(7).getTotalDinner()){
                            addEarlyLateDinner(7, temp);
                        }
                        else{
                            if(availableCloseMinShiftsFilled(stationList, 1)){
                                if(stationList.get(7).getDinnerMaxWorkers() > stationList.get(7).getTotalDinner()){
                                    addEarlyLateDinner(7, temp);
                                }
                            }
                        }
                    }

                }
                else {
                    masterList.get(7).get(1).add(temp);
                    pool.set(1, removeByName(temp.getName(), pool.get(1)));
                    stationList.get(7).addEarlyMidStudent();
                }
            }
            if (stationList.get(8).getEarlyMidPeopleNeeded() > stationList.get(8).getEarlyMid() && pool.get(1).size() != 0) { //fill dish
                Student temp = randomChooser(pool.get(1), 9);
                if(temp.getMultipleShifts()){
                    if(((worksShift(pool.get(3), temp.getName())))){ //works from mid until close
                        if(stationList.get(8).getDinnerPeopleNeeded() > stationList.get(8).getTotalDinner()){
                            addEarlyLateDinner(8, temp);
                        }
                        else{
                            if(availableCloseMinShiftsFilled(stationList, 1)){
                                if(stationList.get(8).getDinnerMaxWorkers() > stationList.get(8).getTotalDinner()){
                                    addEarlyLateDinner(8, temp);
                                }
                            }
                        }
                    }

                }
                else {
                    masterList.get(8).get(1).add(temp);
                    pool.set(1, removeByName(temp.getName(), pool.get(1)));
                    stationList.get(8).addEarlyMidStudent();
                }
            }

            if (stationList.get(9).getEarlyMidPeopleNeeded() > stationList.get(9).getEarlyMid() && pool.get(1).size() != 0){  //fill dra
                Student temp = randomChooser(pool.get(1), 10);
                if(temp.getMultipleShifts()){
                    if(((worksShift(pool.get(3), temp.getName())))){ //works from mid until close
                        if(stationList.get(9).getDinnerPeopleNeeded() > stationList.get(9).getTotalDinner()){
                            addEarlyLateDinner(9, temp);
                        }
                        else{
                            if(availableCloseMinShiftsFilled(stationList, 1)){
                                if(stationList.get(9).getDinnerMaxWorkers() > stationList.get(9).getTotalDinner()){
                                    addEarlyLateDinner(9, temp);
                                }
                            }
                        }
                    }

                }
                else {
                    masterList.get(9).get(1).add(temp);
                    pool.set(1, removeByName(temp.getName(), pool.get(1)));
                    stationList.get(9).addEarlyMidStudent();
                }
            }
            if (stationList.get(10).getEarlyMidPeopleNeeded() > stationList.get(10).getEarlyMid() && pool.get(1).size() != 0){  //fill CR
                Student temp = randomChooser(pool.get(1), 11);
                if(temp.getMultipleShifts()){
                    if(((worksShift(pool.get(3), temp.getName())))){ //works from mid until close
                        if(stationList.get(10).getDinnerPeopleNeeded() > stationList.get(10).getTotalDinner()){
                            addEarlyLateDinner(10, temp);
                        }
                        else{
                            if(availableCloseMinShiftsFilled(stationList, 1)){
                                if(stationList.get(10).getDinnerMaxWorkers() > stationList.get(10).getTotalDinner()){
                                    addEarlyLateDinner(10, temp);
                                }
                            }
                        }
                    }

                }
                else {
                    masterList.get(10).get(1).add(temp);
                    pool.set(1, removeByName(temp.getName(), pool.get(1)));
                    stationList.get(10).addEarlyMidStudent();
                }
            }
            if((stationList.get(0).getEarlyMid() >= stationList.get(0).getEarlyMidPeopleNeeded()) &&
                    (stationList.get(1).getEarlyMid() >= stationList.get(1).getEarlyMidPeopleNeeded()) &&
                    (stationList.get(2).getEarlyMid() >= stationList.get(2).getEarlyMidPeopleNeeded()) &&
                    (stationList.get(3).getEarlyMid() >= stationList.get(3).getEarlyMidPeopleNeeded()) &&
                    (stationList.get(4).getEarlyMid() >= stationList.get(4).getEarlyMidPeopleNeeded()) &&
                    (stationList.get(5).getEarlyMid() >= stationList.get(5).getEarlyMidPeopleNeeded()) &&
                    (stationList.get(7).getEarlyMid() >= stationList.get(7).getEarlyMidPeopleNeeded()) &&
                    (stationList.get(8).getEarlyMid() >= stationList.get(8).getEarlyMidPeopleNeeded()) &&
                    (stationList.get(9).getEarlyMid() >= stationList.get(9).getEarlyMidPeopleNeeded()) &&
                    (stationList.get(10).getEarlyMid() >= stationList.get(10).getEarlyMidPeopleNeeded()) &&
                    (stationList.get(11).getEarlyMid() < stationList.get(11).getEarlyMidPeopleNeeded()) && pool.get(1).size() != 0){   //fill jan if other stations meet minimum (until jan meets its min)
                Student temp = randomChooser(pool.get(1), 11);
                if(temp.getMultipleShifts()){
                    if(((worksShift(pool.get(3), temp.getName())))){ //works from mid until close
                        if(stationList.get(11).getDinnerPeopleNeeded() > stationList.get(11).getTotalDinner()){
                            addEarlyLateDinner(11, temp);
                        }
                        else{
                            if(availableCloseMinShiftsFilled(stationList, 1)){
                                if(stationList.get(11).getDinnerMaxWorkers() > stationList.get(11).getTotalDinner()){
                                    addEarlyLateDinner(11, temp);
                                }
                            }
                        }
                    }

                }
                else {
                    masterList.get(11).get(1).add(temp);
                    pool.set(1, removeByName(temp.getName(), pool.get(1)));
                    stationList.get(11).addEarlyMidStudent();
                }

            }
            if( (stationList.get(0).getEarlyMid() >= stationList.get(0).getEarlyMidPeopleNeeded()) &&
                    (stationList.get(1).getEarlyMid() >= stationList.get(1).getEarlyMidPeopleNeeded()) &&
                    (stationList.get(2).getEarlyMid() >= stationList.get(2).getEarlyMidPeopleNeeded()) &&
                    (stationList.get(3).getEarlyMid() >= stationList.get(3).getEarlyMidPeopleNeeded()) &&
                    (stationList.get(4).getEarlyMid() >= stationList.get(4).getEarlyMidPeopleNeeded()) &&
                    (stationList.get(5).getEarlyMid() >= stationList.get(5).getEarlyMidPeopleNeeded()) &&
                    (stationList.get(7).getEarlyMid() >= stationList.get(7).getEarlyMidPeopleNeeded()) &&
                    (stationList.get(8).getEarlyMid() >= stationList.get(8).getEarlyMidPeopleNeeded()) &&
                    (stationList.get(9).getEarlyMid() >= stationList.get(9).getEarlyMidPeopleNeeded()) &&
                    (stationList.get(10).getEarlyMid() >= stationList.get(10).getEarlyMidPeopleNeeded()) &&
                    (stationList.get(11).getEarlyMid() >= stationList.get(11).getEarlyMidPeopleNeeded()) && pool.get(1).size() != 0){  //if all stations meet minimum requirements, start filling to max
                while(pool.get(1).size() > 0){ //order switched so extras go where help is more needed first
                    if (stationList.get(8).getEarlyMidMaxWorkers() > stationList.get(8).getEarlyMid() && pool.get(1).size() != 0) {  //fill dish
                        Student temp = randomChooser(pool.get(1), 9);
                        if(temp.getMultipleShifts()){
                            if(((worksShift(pool.get(3), temp.getName())))){ //works from mid until close
                                if(stationList.get(8).getDinnerPeopleNeeded() > stationList.get(8).getTotalDinner()){
                                    addEarlyLateDinner(8, temp);
                                }
                                else{
                                    if(availableCloseMinShiftsFilled(stationList, 1)){
                                        if(stationList.get(8).getDinnerMaxWorkers() > stationList.get(8).getTotalDinner()){
                                            addEarlyLateDinner(8, temp);
                                        }
                                    }
                                }
                            }

                        }
                        else {
                            masterList.get(8).get(1).add(temp);
                            pool.set(1, removeByName(temp.getName(), pool.get(1)));
                            stationList.get(8).addEarlyMidStudent();
                        }
                    }
                    if (stationList.get(1).getEarlyMidMaxWorkers() > stationList.get(1).getEarlyMid() && pool.get(1).size() != 0) { // fill peaks
                        Student temp = randomChooser(pool.get(1), 2);
                        if(temp.getMultipleShifts()){
                            if(((worksShift(pool.get(3), temp.getName())))){ //works from mid until close
                                if(stationList.get(1).getDinnerPeopleNeeded() > stationList.get(1).getTotalDinner()){
                                    addEarlyLateDinner(1, temp);
                                }
                                else{
                                    if(availableCloseMinShiftsFilled(stationList, 1)){
                                        if(stationList.get(1).getDinnerMaxWorkers() > stationList.get(1).getTotalDinner()){
                                            addEarlyLateDinner(1, temp);
                                        }
                                    }
                                }
                            }

                        }
                        else {
                            masterList.get(1).get(1).add(temp);
                            pool.set(1, removeByName(temp.getName(), pool.get(1)));
                            stationList.get(1).addEarlyMidStudent();
                        }
                    }
                    if (stationList.get(10).getEarlyMidMaxWorkers() > stationList.get(10).getEarlyMid() && pool.get(1).size() != 0) { //fill cold
                        Student temp = randomChooser(pool.get(1), 11);
                        if(temp.getMultipleShifts()){
                            if(((worksShift(pool.get(3), temp.getName())))){ //works from mid until close
                                if(stationList.get(10).getDinnerPeopleNeeded() > stationList.get(10).getTotalDinner()){
                                    addEarlyLateDinner(10, temp);
                                }
                                else{
                                    if(availableCloseMinShiftsFilled(stationList, 1)){
                                        if(stationList.get(10).getDinnerMaxWorkers() > stationList.get(10).getTotalDinner()){
                                            addEarlyLateDinner(10, temp);
                                        }
                                    }
                                }
                            }

                        }
                        else {
                            masterList.get(10).get(1).add(temp);
                            pool.set(1, removeByName(temp.getName(), pool.get(1)));
                            stationList.get(10).addEarlyMidStudent();
                        }
                    }
                    if (stationList.get(2).getEarlyMidMaxWorkers() > stationList.get(2).getEarlyMid() && pool.get(1).size() != 0) { // fill hearth
                        Student temp = randomChooser(pool.get(1), 3);
                        if(temp.getMultipleShifts()){
                            if(((worksShift(pool.get(3), temp.getName())))){ //works from mid until close
                                if(stationList.get(2).getDinnerPeopleNeeded() > stationList.get(2).getTotalDinner()){
                                    addEarlyLateDinner(2, temp);
                                }
                                else{
                                    if(availableCloseMinShiftsFilled(stationList, 1)){
                                        if(stationList.get(2).getDinnerMaxWorkers() > stationList.get(2).getTotalDinner()){
                                            addEarlyLateDinner(2, temp);
                                        }
                                    }
                                }
                            }

                        }
                        else {
                            masterList.get(2).get(1).add(temp);
                            pool.set(1, removeByName(temp.getName(), pool.get(1)));
                            stationList.get(2).addEarlyMidStudent();
                        }
                    }
                    if (stationList.get(3).getEarlyMidMaxWorkers() > stationList.get(3).getEarlyMid() && pool.get(1).size() != 0) { // fill salads
                        Student temp = randomChooser(pool.get(1), 4);
                        if(temp.getMultipleShifts()){
                            if(((worksShift(pool.get(3), temp.getName())))){ //works from mid until close
                                if(stationList.get(3).getDinnerPeopleNeeded() > stationList.get(3).getTotalDinner()){
                                    addEarlyLateDinner(3, temp);
                                }
                                else{
                                    if(availableCloseMinShiftsFilled(stationList, 1)){
                                        if(stationList.get(3).getDinnerMaxWorkers() > stationList.get(3).getTotalDinner()){
                                            addEarlyLateDinner(3, temp);
                                        }
                                    }
                                }
                            }

                        }
                        else {
                            masterList.get(3).get(1).add(temp);
                            pool.set(1, removeByName(temp.getName(), pool.get(1)));
                            stationList.get(3).addEarlyMidStudent();
                        }
                    }
                    if (stationList.get(4).getEarlyMidMaxWorkers() > stationList.get(4).getEarlyMid() && pool.get(1).size() != 0) { //fill toast
                        Student temp = randomChooser(pool.get(1), 5);
                        if(temp.getMultipleShifts()){
                            if(((worksShift(pool.get(3), temp.getName())))){ //works from mid until close
                                if(stationList.get(4).getDinnerPeopleNeeded() > stationList.get(4).getTotalDinner()){
                                    addEarlyLateDinner(4, temp);
                                }
                                else{
                                    if(availableCloseMinShiftsFilled(stationList, 1)){
                                        if(stationList.get(4).getDinnerMaxWorkers() > stationList.get(4).getTotalDinner()){
                                            addEarlyLateDinner(4, temp);
                                        }
                                    }
                                }
                            }

                        }
                        else {
                            masterList.get(4).get(1).add(temp);
                            pool.set(1, removeByName(temp.getName(), pool.get(1)));
                            stationList.get(4).addEarlyMidStudent();
                        }
                    }
                    if (stationList.get(5).getEarlyMidMaxWorkers() > stationList.get(5).getEarlyMid() && pool.get(1).size() != 0) { //fill mid
                        Student temp = randomChooser(pool.get(1), 6);
                        if(temp.getMultipleShifts()){
                            if(((worksShift(pool.get(3), temp.getName())))){ //works from mid until close
                                if(stationList.get(5).getDinnerPeopleNeeded() > stationList.get(5).getTotalDinner()){
                                    addEarlyLateDinner(5, temp);
                                }
                                else{
                                    if(availableCloseMinShiftsFilled(stationList, 1)){
                                        if(stationList.get(5).getDinnerMaxWorkers() > stationList.get(5).getTotalDinner()){
                                            addEarlyLateDinner(5, temp);
                                        }
                                    }
                                }
                            }

                        }
                        else {
                            masterList.get(5).get(1).add(temp);
                            pool.set(1, removeByName(temp.getName(), pool.get(1)));
                            stationList.get(5).addEarlyMidStudent();
                        }
                    }
                    if (stationList.get(6).getEarlyMidMaxWorkers() > stationList.get(6).getEarlyMid() && pool.get(1).size() != 0) { //fill curry
                        Student temp = randomChooser(pool.get(1), 7);
                        if(temp.getMultipleShifts()){
                            if(((worksShift(pool.get(3), temp.getName())))){ //works from mid until close
                                if(stationList.get(6).getDinnerPeopleNeeded() > stationList.get(6).getTotalDinner()){
                                    addEarlyLateDinner(6, temp);
                                }
                                else{
                                    if(availableCloseMinShiftsFilled(stationList, 1)){
                                        if(stationList.get(6).getDinnerMaxWorkers() > stationList.get(6).getTotalDinner()){
                                            addEarlyLateDinner(6, temp);
                                        }
                                    }
                                }
                            }

                        }
                        else {
                            masterList.get(6).get(1).add(temp);
                            pool.set(1, removeByName(temp.getName(), pool.get(1)));
                            stationList.get(6).addEarlyMidStudent();
                        }
                    }
                    if (stationList.get(7).getEarlyMidMaxWorkers() > stationList.get(7).getEarlyMid() && pool.get(1).size() != 0) { //fill grange
                        Student temp = randomChooser(pool.get(1), 8);
                        if(temp.getMultipleShifts()){
                            if(((worksShift(pool.get(3), temp.getName())))){ //works from mid until close
                                if(stationList.get(7).getDinnerPeopleNeeded() > stationList.get(7).getTotalDinner()){
                                    addEarlyLateDinner(7, temp);
                                }
                                else{
                                    if(availableCloseMinShiftsFilled(stationList, 1)){
                                        if(stationList.get(7).getDinnerMaxWorkers() > stationList.get(7).getTotalDinner()){
                                            addEarlyLateDinner(7, temp);
                                        }
                                    }
                                }
                            }

                        }
                        else {
                            masterList.get(7).get(1).add(temp);
                            pool.set(1, removeByName(temp.getName(), pool.get(1)));
                            stationList.get(7).addEarlyMidStudent();
                        }
                    }
                    if (stationList.get(9).getEarlyMidMaxWorkers() > stationList.get(9).getEarlyMid() && pool.get(1).size() != 0) { //fill dra
                        Student temp = randomChooser(pool.get(1), 10);
                        if(temp.getMultipleShifts()){
                            if(((worksShift(pool.get(3), temp.getName())))){ //works from mid until close
                                if(stationList.get(9).getDinnerPeopleNeeded() > stationList.get(9).getTotalDinner()){
                                    addEarlyLateDinner(9, temp);
                                }
                                else{
                                    if(availableCloseMinShiftsFilled(stationList, 1)){
                                        if(stationList.get(9).getDinnerMaxWorkers() > stationList.get(9).getTotalDinner()){
                                            addEarlyLateDinner(9, temp);
                                        }
                                    }
                                }
                            }

                        }
                        else {
                            masterList.get(9).get(1).add(temp);
                            pool.set(1, removeByName(temp.getName(), pool.get(1)));
                            stationList.get(9).addEarlyMidStudent();
                        }
                    }
                    if (stationList.get(0).getEarlyMidMaxWorkers() > stationList.get(0).getEarlyMid() && pool.get(1).size() != 0){  //fill check
                        Student temp = randomChooser(pool.get(1), 1);
                        if(temp.getMultipleShifts()){
                            if(((worksShift(pool.get(3), temp.getName())))){ //works from mid until close
                                if(stationList.get(0).getDinnerPeopleNeeded() > stationList.get(0).getTotalDinner()){
                                    addEarlyLateDinner(0, temp);
                                }
                                else{
                                    if(availableCloseMinShiftsFilled(stationList, 1)){
                                        if(stationList.get(0).getDinnerMaxWorkers() > stationList.get(0).getTotalDinner()){
                                            addEarlyLateDinner(0, temp);
                                        }
                                    }
                                }
                            }

                        }
                        else {
                            masterList.get(0).get(1).add(temp);
                            pool.set(1, removeByName(temp.getName(), pool.get(1)));
                            stationList.get(0).addEarlyMidStudent();
                        }
                    }
                    if(stationList.get(11).getEarlyMidMaxWorkers() > stationList.get(11).getEarlyMid() && pool.get(1).size() != 0){ //fill jan
                        Student temp = randomChooser(pool.get(1), 12);
                        if(temp.getMultipleShifts()){
                            if(((worksShift(pool.get(3), temp.getName())))){ //works from mid until close
                                if(stationList.get(11).getDinnerPeopleNeeded() > stationList.get(11).getTotalDinner()){
                                    addEarlyLateDinner(11, temp);
                                }
                                else{
                                    if(availableCloseMinShiftsFilled(stationList, 1)){
                                        if(stationList.get(11).getDinnerMaxWorkers() > stationList.get(11).getTotalDinner()){
                                            addEarlyLateDinner(11, temp);
                                        }
                                    }
                                }
                            }

                        }
                        else {
                            masterList.get(11).get(1).add(temp);
                            pool.set(1, removeByName(temp.getName(), pool.get(1)));
                            stationList.get(11).addEarlyMidStudent();
                        }
                    }
                    if((stationList.get(0).getEarlyMid() >= stationList.get(0).getEarlyMidMaxWorkers()) &&
                            (stationList.get(1).getEarlyMid() >= stationList.get(1).getEarlyMidMaxWorkers()) &&
                            (stationList.get(2).getEarlyMid() >= stationList.get(2).getEarlyMidMaxWorkers()) &&
                            (stationList.get(3).getEarlyMid() >= stationList.get(3).getEarlyMidMaxWorkers()) &&
                            (stationList.get(4).getEarlyMid() >= stationList.get(4).getEarlyMidMaxWorkers()) &&
                            (stationList.get(5).getEarlyMid() >= stationList.get(5).getEarlyMidMaxWorkers()) &&
                            (stationList.get(7).getEarlyMid() >= stationList.get(7).getEarlyMidMaxWorkers()) &&
                            (stationList.get(8).getEarlyMid() >= stationList.get(8).getEarlyMidMaxWorkers()) &&
                            (stationList.get(9).getEarlyMid() >= stationList.get(9).getEarlyMidMaxWorkers()) &&
                            (stationList.get(10).getEarlyMid() >= stationList.get(10).getEarlyMidMaxWorkers()) &&
                            (stationList.get(11).getEarlyMid() >= stationList.get(11).getEarlyMidMaxWorkers()) && pool.get(1).size() != 0) { //if all stations at max -> go to dish? //TODO: ask ryan what he prefers to happen here
                        Student temp = randomChooser(pool.get(1), 9);
                        if(temp.getMultipleShifts()){
                            if(((worksShift(pool.get(3), temp.getName())))){ //works from mid until close
                                if(stationList.get(8).getDinnerPeopleNeeded() > stationList.get(8).getTotalDinner()){
                                    addEarlyLateDinner(8, temp);
                                }
                                else{
                                    if(availableCloseMinShiftsFilled(stationList, 1)){
                                        if(stationList.get(8).getDinnerMaxWorkers() > stationList.get(8).getTotalDinner()){
                                            addEarlyLateDinner(8, temp);
                                        }
                                    }
                                }
                            }

                        }
                        else {
                            masterList.get(8).get(1).add(temp);
                            pool.set(1, removeByName(temp.getName(), pool.get(1)));
                            stationList.get(8).addEarlyMidStudent();
                        }
                    }

                }
            }

        }
        while(pool.get(2).size() > 0) {
            System.out.println("hang7");
            if (stationList.get(0).getLateMidPeopleNeeded() > stationList.get(0).getLateMid() && pool.get(2).size() != 0) {  // fill checker
                Student temp = randomChooser(pool.get(2), 1);
                if(temp.getMultipleShifts()){
                    if(((worksShift(pool.get(3), temp.getName())))){ //works from mid until close
                        if(stationList.get(0).getDinnerPeopleNeeded() > stationList.get(0).getTotalDinner()){
                            addLateDinner(0, temp);
                        }
                        else{
                            if(availableCloseMinShiftsFilled(stationList, 2)){
                                if(stationList.get(0).getDinnerMaxWorkers() > stationList.get(0).getTotalDinner()){
                                    addLateDinner(0, temp);
                                }
                            }
                        }
                    }

                }
                else {
                    masterList.get(0).get(2).add(temp);
                    pool.set(2, removeByName(temp.getName(), pool.get(2)));
                    stationList.get(0).addLateMidStudent();
                }
            }
            if (stationList.get(1).getLateMidPeopleNeeded() > stationList.get(1).getLateMid() && pool.get(2).size() != 0) { // fill peaks
                Student temp = randomChooser(pool.get(2), 2);
                if(temp.getMultipleShifts()){
                    if(((worksShift(pool.get(3), temp.getName())))){ //works from mid until close
                        if(stationList.get(1).getDinnerPeopleNeeded() > stationList.get(1).getTotalDinner()){
                            addLateDinner(1, temp);
                        }
                        else{
                            if(availableCloseMinShiftsFilled(stationList, 2)){
                                if(stationList.get(1).getDinnerMaxWorkers() > stationList.get(1).getTotalDinner()){
                                    addLateDinner(1, temp);
                                }
                            }
                        }
                    }

                }
                else {
                    masterList.get(1).get(2).add(temp);
                    pool.set(2, removeByName(temp.getName(), pool.get(2)));
                    stationList.get(1).addLateMidStudent();
                }
            }
            if (stationList.get(2).getLateMidPeopleNeeded() > stationList.get(2).getLateMid() && pool.get(2).size() != 0) { // fill hearth
                Student temp = randomChooser(pool.get(2), 3);
                if(temp.getMultipleShifts()){
                    if(((worksShift(pool.get(3), temp.getName())))){ //works from mid until close
                        if(stationList.get(2).getDinnerPeopleNeeded() > stationList.get(2).getTotalDinner()){
                            addLateDinner(2, temp);
                        }
                        else{
                            if(availableCloseMinShiftsFilled(stationList, 2)){
                                if(stationList.get(2).getDinnerMaxWorkers() > stationList.get(2).getTotalDinner()){
                                    addLateDinner(2, temp);
                                }
                            }
                        }
                    }

                }
                else {
                    masterList.get(2).get(2).add(temp);
                    pool.set(2, removeByName(temp.getName(), pool.get(2)));
                    stationList.get(2).addLateMidStudent();
                }
            }
            if (stationList.get(3).getLateMidPeopleNeeded() > stationList.get(3).getLateMid() && pool.get(2).size() != 0) { // fill salads
                Student temp = randomChooser(pool.get(2), 4);
                if(temp.getMultipleShifts()){
                    if(((worksShift(pool.get(3), temp.getName())))){ //works from mid until close
                        if(stationList.get(3).getDinnerPeopleNeeded() > stationList.get(3).getTotalDinner()){
                            addLateDinner(3, temp);
                        }
                        else{
                            if(availableCloseMinShiftsFilled(stationList, 2)){
                                if(stationList.get(3).getDinnerMaxWorkers() > stationList.get(3).getTotalDinner()){
                                    addLateDinner(3, temp);
                                }
                            }
                        }
                    }

                }
                else {
                    masterList.get(3).get(2).add(temp);
                    pool.set(2, removeByName(temp.getName(), pool.get(2)));
                    stationList.get(3).addLateMidStudent();
                }
            }
            if (stationList.get(4).getLateMidPeopleNeeded() > stationList.get(4).getLateMid() && pool.get(2).size() != 0) { //fill toast
                Student temp = randomChooser(pool.get(2), 5);
                if(temp.getMultipleShifts()){
                    if(((worksShift(pool.get(3), temp.getName())))){ //works from mid until close
                        if(stationList.get(4).getDinnerPeopleNeeded() > stationList.get(4).getTotalDinner()){
                            addLateDinner(4, temp);
                        }
                        else{
                            if(availableCloseMinShiftsFilled(stationList, 2)){
                                if(stationList.get(4).getDinnerMaxWorkers() > stationList.get(4).getTotalDinner()){
                                    addLateDinner(4, temp);
                                }
                            }
                        }
                    }

                }
                else {
                    masterList.get(4).get(2).add(temp);
                    pool.set(2, removeByName(temp.getName(), pool.get(2)));
                    stationList.get(4).addLateMidStudent();
                }
            }
            if (stationList.get(5).getLateMidPeopleNeeded() > stationList.get(5).getLateMid() && pool.get(2).size() != 0) { //fill mid
                Student temp = randomChooser(pool.get(2), 6);
                if(temp.getMultipleShifts()){
                    if(((worksShift(pool.get(3), temp.getName())))){ //works from mid until close
                        if(stationList.get(5).getDinnerPeopleNeeded() > stationList.get(5).getTotalDinner()){
                            addLateDinner(5, temp);
                        }
                        else{
                            if(availableCloseMinShiftsFilled(stationList, 2)){
                                if(stationList.get(5).getDinnerMaxWorkers() > stationList.get(5).getTotalDinner()){
                                    addLateDinner(5, temp);
                                }
                            }
                        }
                    }

                }
                else {
                    masterList.get(5).get(2).add(temp);
                    pool.set(2, removeByName(temp.getName(), pool.get(2)));
                    stationList.get(5).addLateMidStudent();
                }
            }
            if (stationList.get(6).getLateMidPeopleNeeded() > stationList.get(6).getLateMid() && pool.get(2).size() != 0) { //fill curry
                Student temp = randomChooser(pool.get(2), 7);
                if(temp.getMultipleShifts()){
                    if(((worksShift(pool.get(3), temp.getName())))){ //works from mid until close
                        if(stationList.get(6).getDinnerPeopleNeeded() > stationList.get(6).getTotalDinner()){
                            addLateDinner(6, temp);
                        }
                        else{
                            if(availableCloseMinShiftsFilled(stationList, 2)){
                                if(stationList.get(6).getDinnerMaxWorkers() > stationList.get(6).getTotalDinner()){
                                    addLateDinner(6, temp);
                                }
                            }
                        }
                    }

                }
                else {
                    masterList.get(6).get(2).add(temp);
                    pool.set(2, removeByName(temp.getName(), pool.get(2)));
                    stationList.get(6).addLateMidStudent();
                }
            }
            if (stationList.get(7).getLateMidPeopleNeeded() > stationList.get(7).getLateMid() && pool.get(2).size() != 0) { //fill grange
                Student temp = randomChooser(pool.get(2), 8);
                if(temp.getMultipleShifts()){
                    if(((worksShift(pool.get(3), temp.getName())))){ //works from mid until close
                        if(stationList.get(7).getDinnerPeopleNeeded() > stationList.get(7).getTotalDinner()){
                            addLateDinner(7, temp);
                        }
                        else{
                            if(availableCloseMinShiftsFilled(stationList, 2)){
                                if(stationList.get(7).getDinnerMaxWorkers() > stationList.get(7).getTotalDinner()){
                                    addLateDinner(7, temp);
                                }
                            }
                        }
                    }

                }
                else {
                    masterList.get(7).get(2).add(temp);
                    pool.set(2, removeByName(temp.getName(), pool.get(2)));
                    stationList.get(7).addLateMidStudent();
                }
            }
            if (stationList.get(8).getLateMidPeopleNeeded() > stationList.get(8).getLateMid() && pool.get(2).size() != 0) { //fill dish
                Student temp = randomChooser(pool.get(2), 9);
                if(temp.getMultipleShifts()){
                    if(((worksShift(pool.get(3), temp.getName())))){ //works from mid until close
                        if(stationList.get(8).getDinnerPeopleNeeded() > stationList.get(8).getTotalDinner()){
                            addLateDinner(8, temp);
                        }
                        else{
                            if(availableCloseMinShiftsFilled(stationList, 2)){
                                if(stationList.get(8).getDinnerMaxWorkers() > stationList.get(8).getTotalDinner()){
                                    addLateDinner(8, temp);
                                }
                            }
                        }
                    }

                }
                else {
                    masterList.get(8).get(2).add(temp);
                    pool.set(2, removeByName(temp.getName(), pool.get(2)));
                    stationList.get(8).addLateMidStudent();
                }
            }

            if (stationList.get(9).getLateMidPeopleNeeded() > stationList.get(9).getLateMid() && pool.get(2).size() != 0){  //fill dra
                Student temp = randomChooser(pool.get(2), 10);
                if(temp.getMultipleShifts()){
                    if(((worksShift(pool.get(3), temp.getName())))){ //works from mid until close
                        if(stationList.get(9).getDinnerPeopleNeeded() > stationList.get(9).getTotalDinner()){
                            addLateDinner(9, temp);
                        }
                        else{
                            if(availableCloseMinShiftsFilled(stationList, 2)){
                                if(stationList.get(9).getDinnerMaxWorkers() > stationList.get(9).getTotalDinner()){
                                    addLateDinner(9, temp);
                                }
                            }
                        }
                    }

                }
                else {
                    masterList.get(9).get(2).add(temp);
                    pool.set(2, removeByName(temp.getName(), pool.get(2)));
                    stationList.get(9).addLateMidStudent();
                }
            }
            if (stationList.get(10).getLateMidPeopleNeeded() > stationList.get(10).getLateMid() && pool.get(2).size() != 0){  //fill dra
                Student temp = randomChooser(pool.get(2), 11);
                if(temp.getMultipleShifts()){
                    if(((worksShift(pool.get(3), temp.getName())))){ //works from mid until close
                        if(stationList.get(10).getDinnerPeopleNeeded() > stationList.get(10).getTotalDinner()){
                            addLateDinner(10, temp);
                        }
                        else{
                            if(availableCloseMinShiftsFilled(stationList, 2)){
                                if(stationList.get(10).getDinnerMaxWorkers() > stationList.get(10).getTotalDinner()){
                                    addLateDinner(10, temp);
                                }
                            }
                        }
                    }

                }
                else {
                    masterList.get(10).get(2).add(temp);
                    pool.set(2, removeByName(temp.getName(), pool.get(2)));
                    stationList.get(10).addLateMidStudent();
                }
            }
            if((stationList.get(0).getLateMid() >= stationList.get(0).getLateMidPeopleNeeded()) &&
                    (stationList.get(1).getLateMid() >= stationList.get(1).getLateMidPeopleNeeded()) &&
                    (stationList.get(2).getLateMid() >= stationList.get(2).getLateMidPeopleNeeded()) &&
                    (stationList.get(3).getLateMid() >= stationList.get(3).getLateMidPeopleNeeded()) &&
                    (stationList.get(4).getLateMid() >= stationList.get(4).getLateMidPeopleNeeded()) &&
                    (stationList.get(5).getLateMid() >= stationList.get(5).getLateMidPeopleNeeded()) &&
                    (stationList.get(7).getLateMid() >= stationList.get(7).getLateMidPeopleNeeded()) &&
                    (stationList.get(8).getLateMid() >= stationList.get(8).getLateMidPeopleNeeded()) &&
                    (stationList.get(9).getLateMid() >= stationList.get(9).getLateMidPeopleNeeded()) &&
                    (stationList.get(10).getLateMid() >= stationList.get(10).getLateMidPeopleNeeded()) &&
                    (stationList.get(11).getLateMid() < stationList.get(11).getLateMidPeopleNeeded()) && pool.get(2).size() != 0){   //fill jan if other stations meet minimum (until jan meets its min)
                Student temp = randomChooser(pool.get(2), 11);
                if(temp.getMultipleShifts()){
                    if(((worksShift(pool.get(3), temp.getName())))){ //works from mid until close
                        if(stationList.get(11).getDinnerPeopleNeeded() > stationList.get(11).getTotalDinner()){
                            addLateDinner(11, temp);
                        }
                        else{
                            if(availableCloseMinShiftsFilled(stationList, 2)){
                                if(stationList.get(11).getDinnerMaxWorkers() > stationList.get(11).getTotalDinner()){
                                    addLateDinner(11, temp);
                                }
                            }
                        }
                    }

                }
                else {
                    masterList.get(11).get(2).add(temp);
                    pool.set(2, removeByName(temp.getName(), pool.get(2)));
                    stationList.get(11).addLateMidStudent();
                }

            }
            if( (stationList.get(0).getLateMid() >= stationList.get(0).getLateMidPeopleNeeded()) &&
                    (stationList.get(1).getLateMid() >= stationList.get(1).getLateMidPeopleNeeded()) &&
                    (stationList.get(2).getLateMid() >= stationList.get(2).getLateMidPeopleNeeded()) &&
                    (stationList.get(3).getLateMid() >= stationList.get(3).getLateMidPeopleNeeded()) &&
                    (stationList.get(4).getLateMid() >= stationList.get(4).getLateMidPeopleNeeded()) &&
                    (stationList.get(5).getLateMid() >= stationList.get(5).getLateMidPeopleNeeded()) &&
                    (stationList.get(7).getLateMid() >= stationList.get(7).getLateMidPeopleNeeded()) &&
                    (stationList.get(8).getLateMid() >= stationList.get(8).getLateMidPeopleNeeded()) &&
                    (stationList.get(9).getLateMid() >= stationList.get(9).getLateMidPeopleNeeded()) &&
                    (stationList.get(10).getLateMid() >= stationList.get(10).getLateMidPeopleNeeded()) &&
                    (stationList.get(11).getLateMid() >= stationList.get(11).getLateMidPeopleNeeded()) && pool.get(2).size() != 0){  //if all stations meet minimum requirements, start filling to max
                while(pool.get(2).size() > 0){ //order switched so extras go where help is more needed first
                    if (stationList.get(8).getLateMidMaxWorkers() > stationList.get(8).getLateMid() && pool.get(2).size() != 0) {  //fill dish
                        Student temp = randomChooser(pool.get(2), 9);
                        if(temp.getMultipleShifts()){
                            if(((worksShift(pool.get(3), temp.getName())))){ //works from mid until close
                                if(stationList.get(8).getDinnerPeopleNeeded() > stationList.get(8).getTotalDinner()){
                                    addLateDinner(8, temp);
                                }
                                else{
                                    if(availableCloseMinShiftsFilled(stationList, 2)){
                                        if(stationList.get(8).getDinnerMaxWorkers() > stationList.get(8).getTotalDinner()){
                                            addLateDinner(8, temp);
                                        }
                                    }
                                }
                            }

                        }
                        else {
                            masterList.get(8).get(2).add(temp);
                            pool.set(2, removeByName(temp.getName(), pool.get(2)));
                            stationList.get(8).addLateMidStudent();
                        }
                    }
                    if (stationList.get(1).getLateMidMaxWorkers() > stationList.get(1).getLateMid() && pool.get(2).size() != 0) { // fill peaks
                        Student temp = randomChooser(pool.get(2), 2);
                        if(temp.getMultipleShifts()){
                            if(((worksShift(pool.get(3), temp.getName())))){ //works from mid until close
                                if(stationList.get(1).getDinnerPeopleNeeded() > stationList.get(1).getTotalDinner()){
                                    addLateDinner(1, temp);
                                }
                                else{
                                    if(availableCloseMinShiftsFilled(stationList, 2)){
                                        if(stationList.get(1).getDinnerMaxWorkers() > stationList.get(1).getTotalDinner()){
                                            addLateDinner(1, temp);
                                        }
                                    }
                                }
                            }

                        }
                        else {
                            masterList.get(1).get(2).add(temp);
                            pool.set(2, removeByName(temp.getName(), pool.get(2)));
                            stationList.get(1).addLateMidStudent();
                        }
                    }
                    if (stationList.get(10).getLateMidMaxWorkers() > stationList.get(10).getLateMid() && pool.get(2).size() != 0) { //fill cold
                        Student temp = randomChooser(pool.get(2), 11);
                        if(temp.getMultipleShifts()){
                            if(((worksShift(pool.get(3), temp.getName())))){ //works from mid until close
                                if(stationList.get(10).getDinnerPeopleNeeded() > stationList.get(10).getTotalDinner()){
                                    addLateDinner(10, temp);
                                }
                                else{
                                    if(availableCloseMinShiftsFilled(stationList, 2)){
                                        if(stationList.get(10).getDinnerMaxWorkers() > stationList.get(10).getTotalDinner()){
                                            addLateDinner(10, temp);
                                        }
                                    }
                                }
                            }

                        }
                        else {
                            masterList.get(10).get(2).add(temp);
                            pool.set(2, removeByName(temp.getName(), pool.get(2)));
                            stationList.get(10).addLateMidStudent();
                        }
                    }
                    if (stationList.get(2).getLateMidMaxWorkers() > stationList.get(2).getLateMid() && pool.get(2).size() != 0) { // fill hearth
                        Student temp = randomChooser(pool.get(2), 3);
                        if(temp.getMultipleShifts()){
                            if(((worksShift(pool.get(3), temp.getName())))){ //works from mid until close
                                if(stationList.get(2).getDinnerPeopleNeeded() > stationList.get(2).getTotalDinner()){
                                    addLateDinner(2, temp);
                                }
                                else{
                                    if(availableCloseMinShiftsFilled(stationList, 2)){
                                        if(stationList.get(2).getDinnerMaxWorkers() > stationList.get(2).getTotalDinner()){
                                            addLateDinner(2, temp);
                                        }
                                    }
                                }
                            }

                        }
                        else {
                            masterList.get(2).get(2).add(temp);
                            pool.set(2, removeByName(temp.getName(), pool.get(2)));
                            stationList.get(2).addLateMidStudent();
                        }
                    }
                    if (stationList.get(3).getLateMidMaxWorkers() > stationList.get(3).getLateMid() && pool.get(2).size() != 0) { // fill salads
                        Student temp = randomChooser(pool.get(2), 4);
                        if(temp.getMultipleShifts()){
                            if(((worksShift(pool.get(3), temp.getName())))){ //works from mid until close
                                if(stationList.get(3).getDinnerPeopleNeeded() > stationList.get(3).getTotalDinner()){
                                    addLateDinner(3, temp);
                                }
                                else{
                                    if(availableCloseMinShiftsFilled(stationList, 2)){
                                        if(stationList.get(3).getDinnerMaxWorkers() > stationList.get(3).getTotalDinner()){
                                            addLateDinner(3, temp);
                                        }
                                    }
                                }
                            }

                        }
                        else {
                            masterList.get(3).get(2).add(temp);
                            pool.set(2, removeByName(temp.getName(), pool.get(2)));
                            stationList.get(3).addLateMidStudent();
                        }
                    }
                    if (stationList.get(4).getLateMidMaxWorkers() > stationList.get(4).getLateMid() && pool.get(2).size() != 0) { //fill toast
                        Student temp = randomChooser(pool.get(2), 5);
                        if(temp.getMultipleShifts()){
                            if(((worksShift(pool.get(3), temp.getName())))){ //works from mid until close
                                if(stationList.get(4).getDinnerPeopleNeeded() > stationList.get(4).getTotalDinner()){
                                    addLateDinner(4, temp);
                                }
                                else{
                                    if(availableCloseMinShiftsFilled(stationList, 2)){
                                        if(stationList.get(4).getDinnerMaxWorkers() > stationList.get(4).getTotalDinner()){
                                            addLateDinner(4, temp);
                                        }
                                    }
                                }
                            }

                        }
                        else {
                            masterList.get(4).get(2).add(temp);
                            pool.set(2, removeByName(temp.getName(), pool.get(2)));
                            stationList.get(4).addLateMidStudent();
                        }
                    }
                    if (stationList.get(5).getLateMidMaxWorkers() > stationList.get(5).getLateMid() && pool.get(2).size() != 0) { //fill mid
                        Student temp = randomChooser(pool.get(2), 6);
                        if(temp.getMultipleShifts()){
                            if(((worksShift(pool.get(3), temp.getName())))){ //works from mid until close
                                if(stationList.get(5).getDinnerPeopleNeeded() > stationList.get(5).getTotalDinner()){
                                    addLateDinner(5, temp);
                                }
                                else{
                                    if(availableCloseMinShiftsFilled(stationList, 2)){
                                        if(stationList.get(5).getDinnerMaxWorkers() > stationList.get(5).getTotalDinner()){
                                            addLateDinner(5, temp);
                                        }
                                    }
                                }
                            }

                        }
                        else {
                            masterList.get(5).get(2).add(temp);
                            pool.set(2, removeByName(temp.getName(), pool.get(2)));
                            stationList.get(5).addLateMidStudent();
                        }
                    }
                    if (stationList.get(6).getLateMidMaxWorkers() > stationList.get(6).getLateMid() && pool.get(2).size() != 0) { //fill curry
                        Student temp = randomChooser(pool.get(2), 7);
                        if(temp.getMultipleShifts()){
                            if(((worksShift(pool.get(3), temp.getName())))){ //works from mid until close
                                if(stationList.get(6).getDinnerPeopleNeeded() > stationList.get(6).getTotalDinner()){
                                    addLateDinner(6, temp);
                                }
                                else{
                                    if(availableCloseMinShiftsFilled(stationList, 2)){
                                        if(stationList.get(6).getDinnerMaxWorkers() > stationList.get(6).getTotalDinner()){
                                            addLateDinner(6, temp);
                                        }
                                    }
                                }
                            }

                        }
                        else {
                            masterList.get(6).get(2).add(temp);
                            pool.set(2, removeByName(temp.getName(), pool.get(2)));
                            stationList.get(6).addLateMidStudent();
                        }
                    }
                    if (stationList.get(7).getLateMidMaxWorkers() > stationList.get(7).getLateMid() && pool.get(2).size() != 0) { //fill grange
                        Student temp = randomChooser(pool.get(2), 8);
                        if(temp.getMultipleShifts()){
                            if(((worksShift(pool.get(3), temp.getName())))){ //works from mid until close
                                if(stationList.get(7).getDinnerPeopleNeeded() > stationList.get(7).getTotalDinner()){
                                    addLateDinner(7, temp);
                                }
                                else{
                                    if(availableCloseMinShiftsFilled(stationList, 2)){
                                        if(stationList.get(7).getDinnerMaxWorkers() > stationList.get(7).getTotalDinner()){
                                            addLateDinner(7, temp);
                                        }
                                    }
                                }
                            }

                        }
                        else {
                            masterList.get(7).get(2).add(temp);
                            pool.set(2, removeByName(temp.getName(), pool.get(2)));
                            stationList.get(7).addLateMidStudent();
                        }
                    }
                    if (stationList.get(9).getLateMidMaxWorkers() > stationList.get(9).getLateMid() && pool.get(2).size() != 0) { //fill dra
                        Student temp = randomChooser(pool.get(2), 10);
                        if(temp.getMultipleShifts()){
                            if(((worksShift(pool.get(3), temp.getName())))){ //works from mid until close
                                if(stationList.get(9).getDinnerPeopleNeeded() > stationList.get(9).getTotalDinner()){
                                    addLateDinner(9, temp);
                                }
                                else{
                                    if(availableCloseMinShiftsFilled(stationList, 2)){
                                        if(stationList.get(9).getDinnerMaxWorkers() > stationList.get(9).getTotalDinner()){
                                            addLateDinner(9, temp);
                                        }
                                    }
                                }
                            }

                        }
                        else {
                            masterList.get(9).get(2).add(temp);
                            pool.set(2, removeByName(temp.getName(), pool.get(2)));
                            stationList.get(9).addLateMidStudent();
                        }
                    }
                    if (stationList.get(0).getLateMidMaxWorkers() > stationList.get(0).getLateMid() && pool.get(2).size() != 0){  //fill check
                        Student temp = randomChooser(pool.get(2), 1);
                        if(temp.getMultipleShifts()){
                            if(((worksShift(pool.get(3), temp.getName())))){ //works from mid until close
                                if(stationList.get(0).getDinnerPeopleNeeded() > stationList.get(0).getTotalDinner()){
                                    addLateDinner(0, temp);
                                }
                                else{
                                    if(availableCloseMinShiftsFilled(stationList, 2)){
                                        if(stationList.get(0).getDinnerMaxWorkers() > stationList.get(0).getTotalDinner()){
                                            addLateDinner(0, temp);
                                        }
                                    }
                                }
                            }

                        }
                        else {
                            masterList.get(0).get(2).add(temp);
                            pool.set(2, removeByName(temp.getName(), pool.get(2)));
                            stationList.get(0).addLateMidStudent();
                        }
                    }
                    if(stationList.get(11).getLateMidMaxWorkers() > stationList.get(11).getLateMid() && pool.get(2).size() != 0){ //fill jan
                        Student temp = randomChooser(pool.get(2), 12);
                        if(temp.getMultipleShifts()){
                            if(((worksShift(pool.get(3), temp.getName())))){ //works from mid until close
                                if(stationList.get(11).getDinnerPeopleNeeded() > stationList.get(11).getTotalDinner()){
                                    addLateDinner(11, temp);
                                }
                                else{
                                    if(availableCloseMinShiftsFilled(stationList, 2)){
                                        if(stationList.get(11).getDinnerMaxWorkers() > stationList.get(11).getTotalDinner()){
                                            addLateDinner(11, temp);
                                        }
                                    }
                                }
                            }

                        }
                        else {
                            masterList.get(11).get(2).add(temp);
                            pool.set(2, removeByName(temp.getName(), pool.get(2)));
                            stationList.get(11).addLateMidStudent();
                        }
                    }
                    if((stationList.get(0).getLateMid() >= stationList.get(0).getEarlyMidMaxWorkers()) &&
                            (stationList.get(1).getLateMid() >= stationList.get(1).getLateMidMaxWorkers()) &&
                            (stationList.get(2).getLateMid() >= stationList.get(2).getLateMidMaxWorkers()) &&
                            (stationList.get(3).getLateMid() >= stationList.get(3).getLateMidMaxWorkers()) &&
                            (stationList.get(4).getLateMid() >= stationList.get(4).getLateMidMaxWorkers()) &&
                            (stationList.get(5).getLateMid() >= stationList.get(5).getLateMidMaxWorkers()) &&
                            (stationList.get(7).getLateMid() >= stationList.get(7).getLateMidMaxWorkers()) &&
                            (stationList.get(8).getLateMid() >= stationList.get(8).getLateMidMaxWorkers()) &&
                            (stationList.get(9).getLateMid() >= stationList.get(9).getLateMidMaxWorkers()) &&
                            (stationList.get(10).getLateMid() >= stationList.get(10).getLateMidMaxWorkers()) &&
                            (stationList.get(11).getLateMid() >= stationList.get(11).getLateMidMaxWorkers()) && pool.get(2).size() != 0) { //if all stations at max -> go to dish? //TODO: ask ryan what he prefers to happen here
                        Student temp = randomChooser(pool.get(2), 9);
                        if(temp.getMultipleShifts()){
                            if(((worksShift(pool.get(3), temp.getName())))){ //works from mid until close
                                if(stationList.get(8).getDinnerPeopleNeeded() > stationList.get(8).getTotalDinner()){
                                    addLateDinner(8, temp);
                                }
                                else{
                                    if(availableCloseMinShiftsFilled(stationList, 2)){
                                        if(stationList.get(8).getDinnerMaxWorkers() > stationList.get(8).getTotalDinner()){
                                            addLateDinner(8, temp);
                                        }
                                    }
                                }
                            }

                        }
                        else {
                            masterList.get(8).get(2).add(temp);
                            pool.set(2, removeByName(temp.getName(), pool.get(2)));
                            stationList.get(8).addLateMidStudent();
                        }
                    }

                }
            }

        }
        while(pool.get(3).size() > 0) {
            if (stationList.get(0).getDinnerPeopleNeeded() > stationList.get(0).getTotalDinner() && pool.get(3).size() != 0) {  // fill checker
                Student temp = randomChooser(pool.get(3), 1);
                masterList.get(0).get(3).add(temp);
                pool.set(3,removeByName(temp.getName(), pool.get(3)) ) ;
                stationList.get(0).addDinnerStudent();
            }
            if (stationList.get(1).getDinnerPeopleNeeded() > stationList.get(1).getTotalDinner() && pool.get(3).size() != 0) { // fill peaks
                Student temp = randomChooser(pool.get(3), 2);
                masterList.get(1).get(3).add(temp);
                pool.set(3,removeByName(temp.getName(), pool.get(3)) ) ;
                stationList.get(1).addDinnerStudent();
            }
            if (stationList.get(2).getDinnerPeopleNeeded() > stationList.get(2).getTotalDinner() && pool.get(3).size() != 0) { // fill hearth
                Student temp = randomChooser(pool.get(3), 3);
                masterList.get(2).get(3).add(temp);
                pool.set(3,removeByName(temp.getName(), pool.get(3)) ) ;
                stationList.get(2).addDinnerStudent();
            }
            if (stationList.get(3).getDinnerPeopleNeeded() > stationList.get(3).getTotalDinner() && pool.get(3).size() != 0) { // fill salads
                Student temp = randomChooser(pool.get(3), 4);
                masterList.get(3).get(3).add(temp);
                pool.set(3,removeByName(temp.getName(), pool.get(3)) ) ;
                stationList.get(3).addDinnerStudent();
            }
            if (stationList.get(4).getDinnerPeopleNeeded() > stationList.get(4).getTotalDinner() && pool.get(3).size() != 0) { //fill toast
                Student temp = randomChooser(pool.get(3), 5);
                masterList.get(4).get(3).add(temp);
                pool.set(3,removeByName(temp.getName(), pool.get(3)) ) ;
                stationList.get(4).addDinnerStudent();
            }
            if (stationList.get(5).getDinnerPeopleNeeded() > stationList.get(5).getTotalDinner() && pool.get(3).size() != 0) { //fill mid
                Student temp = randomChooser(pool.get(3), 6);
                masterList.get(5).get(3).add(temp);
                pool.set(3,removeByName(temp.getName(), pool.get(3) )) ;
                stationList.get(5).addDinnerStudent();
            }
            if (stationList.get(6).getDinnerPeopleNeeded() > stationList.get(6).getTotalDinner() && pool.get(3).size() != 0) { //fill curry
                Student temp = randomChooser(pool.get(3), 7);
                masterList.get(6).get(3).add(temp);
                pool.set(3,removeByName(temp.getName(), pool.get(3)) ) ;
                stationList.get(6).addDinnerStudent();
            }
            if (stationList.get(7).getDinnerPeopleNeeded() > stationList.get(7).getTotalDinner() && pool.get(3).size() != 0) { //fill grange
                Student temp = randomChooser(pool.get(3), 8);
                masterList.get(7).get(3).add(temp);
                pool.set(3,removeByName(temp.getName(), pool.get(3)) ) ;
                stationList.get(7).addDinnerStudent();
            }
            if (stationList.get(8).getDinnerPeopleNeeded() > stationList.get(8).getTotalDinner() && pool.get(3).size() != 0) { //fill dish
                Student temp = randomChooser(pool.get(3), 9);
                masterList.get(8).get(3).add(temp);
                pool.set(3,removeByName(temp.getName(), pool.get(3)) ) ;
                stationList.get(8).addDinnerStudent();
            }
            if (stationList.get(10).getDinnerPeopleNeeded() > stationList.get(10).getTotalDinner() && pool.get(3).size() != 0) { //fill cold runner
                Student temp = randomChooser(pool.get(3), 11);
                masterList.get(10).get(3).add(temp);
                pool.set(3,removeByName(temp.getName(), pool.get(3)));
                stationList.get(10).addDinnerStudent();
            }
            if (stationList.get(9).getDinnerPeopleNeeded() > stationList.get(9).getTotalDinner() && pool.get(3).size() != 0){  //fill dra
                Student temp = randomChooser(pool.get(3), 10);
                masterList.get(9).get(3).add(temp);
                pool.set(3, removeByName(temp.getName(), pool.get(3)));
                stationList.get(9).addDinnerStudent();
            }

            if((stationList.get(0).getTotalDinner() >= stationList.get(0).getDinnerPeopleNeeded()) &&
                    (stationList.get(1).getTotalDinner() >= stationList.get(1).getDinnerPeopleNeeded()) &&
                    (stationList.get(2).getTotalDinner() >= stationList.get(2).getDinnerPeopleNeeded()) &&
                    (stationList.get(3).getTotalDinner() >= stationList.get(3).getDinnerPeopleNeeded()) &&
                    (stationList.get(4).getTotalDinner() >= stationList.get(4).getDinnerPeopleNeeded()) &&
                    (stationList.get(5).getTotalDinner() >= stationList.get(5).getDinnerPeopleNeeded()) &&
                    (stationList.get(7).getTotalDinner() >= stationList.get(7).getDinnerPeopleNeeded()) &&
                    (stationList.get(8).getTotalDinner() >= stationList.get(8).getDinnerPeopleNeeded()) &&
                    (stationList.get(9).getTotalDinner() >= stationList.get(9).getDinnerPeopleNeeded()) &&
                    (stationList.get(10).getTotalDinner() >= stationList.get(10).getDinnerPeopleNeeded()) &&
                    (stationList.get(11).getTotalDinner() < stationList.get(11).getDinnerPeopleNeeded()) && pool.get(3).size() != 0){   //fill jan if other stations meet minimum (until jan meets its min)
                Student temp = randomChooser(pool.get(3), 12);
                masterList.get(11).get(3).add(temp);
                pool.set(3,removeByName(temp.getName(), pool.get(3)) ) ;
                stationList.get(11).addDinnerStudent();


            }
            if( (stationList.get(0).getTotalDinner() >= stationList.get(0).getDinnerPeopleNeeded()) &&
                    (stationList.get(1).getTotalDinner() >= stationList.get(1).getDinnerPeopleNeeded()) &&
                    (stationList.get(2).getTotalDinner() >= stationList.get(2).getDinnerPeopleNeeded()) &&
                    (stationList.get(3).getTotalDinner() >= stationList.get(3).getDinnerPeopleNeeded()) &&
                    (stationList.get(4).getTotalDinner() >= stationList.get(4).getDinnerPeopleNeeded()) &&
                    (stationList.get(5).getTotalDinner() >= stationList.get(5).getDinnerPeopleNeeded()) &&
                    (stationList.get(7).getTotalDinner() >= stationList.get(7).getDinnerPeopleNeeded()) &&
                    (stationList.get(8).getTotalDinner() >= stationList.get(8).getDinnerPeopleNeeded()) &&
                    (stationList.get(9).getTotalDinner() >= stationList.get(9).getDinnerPeopleNeeded()) &&
                    (stationList.get(10).getTotalDinner() >= stationList.get(10).getDinnerPeopleNeeded()) &&
                    (stationList.get(11).getTotalDinner() >= stationList.get(11).getDinnerPeopleNeeded()) && pool.get(3).size() != 0){  //if all stations meet minimum requirements, start filling to max

                while(pool.get(3).size() > 0){ //order switched so extras go where help is more needed first

                    if (stationList.get(8).getDinnerMaxWorkers() > stationList.get(8).getTotalDinner() && pool.get(3).size() != 0) {  //fill dish
                        Student temp = randomChooser(pool.get(3), 9);
                        masterList.get(8).get(3).add(temp);
                        pool.set(3,removeByName(temp.getName(), pool.get(3)) ) ;
                        stationList.get(8).addDinnerStudent();
                    }
                    if (stationList.get(1).getDinnerMaxWorkers() > stationList.get(1).getTotalDinner() && pool.get(3).size() != 0) { // fill peaks
                        Student temp = randomChooser(pool.get(3), 2);
                        masterList.get(1).get(3).add(temp);
                        pool.set(3,removeByName(temp.getName(), pool.get(3)) ) ;
                        stationList.get(1).addDinnerStudent();
                    }
                    if (stationList.get(2).getDinnerMaxWorkers() > stationList.get(2).getTotalDinner() && pool.get(3).size() != 0) { // fill hearth
                        Student temp = randomChooser(pool.get(3), 3);
                        masterList.get(2).get(3).add(temp);
                        pool.set(3,removeByName(temp.getName(), pool.get(3)) ) ;
                        stationList.get(2).addDinnerStudent();
                    }
                    if (stationList.get(3).getDinnerMaxWorkers() > stationList.get(3).getTotalDinner() && pool.get(3).size() != 0) { // fill salads
                        Student temp = randomChooser(pool.get(3), 4);
                        masterList.get(3).get(3).add(temp);
                        pool.set(3,removeByName(temp.getName(), pool.get(3)) ) ;
                        stationList.get(3).addDinnerStudent();
                    }
                    if (stationList.get(4).getDinnerMaxWorkers() > stationList.get(4).getTotalDinner() && pool.get(3).size() != 0) { //fill toast
                        Student temp = randomChooser(pool.get(3), 5);
                        masterList.get(4).get(3).add(temp);
                        pool.set(3,removeByName(temp.getName(), pool.get(3)) ) ;
                        stationList.get(4).addDinnerStudent();
                    }
                    if (stationList.get(5).getDinnerMaxWorkers() > stationList.get(5).getTotalDinner() && pool.get(3).size() != 0) { //fill mid
                        Student temp = randomChooser(pool.get(3), 6);
                        masterList.get(5).get(3).add(temp);
                        pool.set(3,removeByName(temp.getName(), pool.get(3)) ) ;
                        stationList.get(5).addDinnerStudent();
                    }
                    if (stationList.get(6).getDinnerMaxWorkers() > stationList.get(6).getTotalDinner() && pool.get(3).size() != 0) { //fill curry
                        Student temp = randomChooser(pool.get(3), 7);
                        masterList.get(6).get(3).add(temp);
                        pool.set(3,removeByName(temp.getName(), pool.get(3)) ) ;
                        stationList.get(6).addDinnerStudent();
                    }
                    if (stationList.get(7).getDinnerMaxWorkers() > stationList.get(7).getTotalDinner() && pool.get(3).size() != 0) { //fill grange
                        Student temp = randomChooser(pool.get(3), 8);
                        masterList.get(7).get(3).add(temp);
                        pool.set(3,removeByName(temp.getName(), pool.get(3)) ) ;
                        stationList.get(7).addDinnerStudent();
                    }
                    if (stationList.get(9).getDinnerMaxWorkers() > stationList.get(9).getTotalDinner() && pool.get(3).size() != 0) { //fill dra
                        Student temp = randomChooser(pool.get(3), 10);
                        masterList.get(9).get(3).add(temp);
                        pool.set(3,removeByName(temp.getName(), pool.get(3)) ) ;
                        stationList.get(9).addDinnerStudent();
                    }
                    if (stationList.get(0).getDinnerMaxWorkers() > stationList.get(0).getTotalDinner() && pool.get(3).size() != 0){  //fill check
                        Student temp = randomChooser(pool.get(3), 1);
                        masterList.get(0).get(3).add(temp);
                        pool.set(3, removeByName(temp.getName(), pool.get(3)));
                        stationList.get(0).addDinnerStudent();
                    }
                    if (stationList.get(10).getDinnerMaxWorkers() > stationList.get(10).getTotalDinner() && pool.get(3).size() != 0){ //fill cold runner
                        Student temp = randomChooser(pool.get(3), 11);
                        masterList.get(10).get(3).add(temp);
                        pool.set(3, removeByName(temp.getName(), pool.get(3)));
                        stationList.get(10).addDinnerStudent();
                    }
                    if(stationList.get(11).getDinnerMaxWorkers() > stationList.get(11).getTotalDinner() && pool.get(3).size() != 0){
                        Student temp = randomChooser(pool.get(3), 12);
                        masterList.get(11).get(3).add(temp);
                        pool.set(3, removeByName(temp.getName(), pool.get(3)));
                        stationList.get(11).addDinnerStudent();
                    }
                    if((stationList.get(0).getTotalDinner() >= stationList.get(0).getMorningMaxWorkers()) &&
                            (stationList.get(1).getTotalDinner() >= stationList.get(1).getDinnerMaxWorkers()) &&
                            (stationList.get(2).getTotalDinner() >= stationList.get(2).getDinnerMaxWorkers()) &&
                            (stationList.get(3).getTotalDinner() >= stationList.get(3).getDinnerMaxWorkers()) &&
                            (stationList.get(4).getTotalDinner() >= stationList.get(4).getDinnerMaxWorkers()) &&
                            (stationList.get(5).getTotalDinner() >= stationList.get(5).getDinnerMaxWorkers()) &&
                            (stationList.get(7).getTotalDinner() >= stationList.get(7).getDinnerMaxWorkers()) &&
                            (stationList.get(8).getTotalDinner() >= stationList.get(8).getDinnerMaxWorkers()) &&
                            (stationList.get(9).getTotalDinner() >= stationList.get(9).getDinnerMaxWorkers()) &&
                            (stationList.get(10).getTotalDinner() >= stationList.get(10).getDinnerMaxWorkers()) &&
                            (stationList.get(11).getTotalDinner() >= stationList.get(11).getDinnerMaxWorkers()) && pool.get(3).size() != 0) { //if all stations at max -> go to dish? //TODO: ask ryan what he prefers to happen here
                        Student temp = randomChooser(pool.get(3), 9);
                        masterList.get(8).get(3).add(temp);
                        pool.set(3, removeByName(temp.getName(), pool.get(3)));
                        stationList.get(8).addDinnerStudent();
                    }
                }
            }

        }
        return masterList;

    }

    private Student randomChooser(List<Student> options, int station){
        //System.out.println("size: " + options.size() + " station: " + station);
        double totalWeight = 0.0;
        for(Student student: options) {
            if( station == 1) totalWeight += student.getCheckWeight();
            if( station == 2) totalWeight += student.getPeaksWeight();
            if( station == 3) totalWeight += student.getHearthWeight();
            if( station == 4) totalWeight += student.getSaladsWeight();
            if( station == 5) totalWeight += student.getToastWeight();
            if( station == 6) totalWeight += student.getMidWeight();
            if( station == 7) totalWeight += student.getCurryWeight();
            if( station == 8) totalWeight += student.getGrangeWeight();
            if( station == 9) totalWeight += student.getDishWeight();
            if( station == 10) totalWeight += student.getDraWeight();
            if( station == 11) totalWeight += student.getColdWeight();
            if( station == 12) totalWeight += student.getJanWeight();
        }
        double r = Math.random() * totalWeight;
        double countWeight = 0.0;
        for(Student student : options){
            if( station == 1) countWeight += student.getCheckWeight();
            if( station == 2) countWeight += student.getPeaksWeight();
            if( station == 3) countWeight += student.getHearthWeight();
            if( station == 4) countWeight += student.getSaladsWeight();
            if( station == 5) countWeight += student.getToastWeight();
            if( station == 6) countWeight += student.getMidWeight();
            if( station == 7) countWeight += student.getCurryWeight();
            if( station == 8) countWeight += student.getGrangeWeight();
            if( station == 9) countWeight += student.getDishWeight();
            if( station == 10) countWeight += student.getDraWeight();
            if( station == 11) countWeight += student.getColdWeight();
            if( station == 12) countWeight += student.getJanWeight();
            //System.out.println("C: " + countWeight + " r: " + r);
            if(countWeight >= r){
                return student;
            }

        }
        throw new RuntimeException("Shouldn't be shown.");
    }

    public List<Student> getStudents() {
        return students;
    }

    private List<Student> removeByName(String name, List<Student> studentPool){
        for(int i = 0; i < studentPool.size(); i++ ){
            if(studentPool.get(i).getName().compareTo(name) == 0)
            {
                studentPool.remove(i);
            }
        }
        return studentPool;
    }

    public void printToSystem(List<List<List<Student>>> trying, int day){
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
        for(int i = 0; i < trying.get(0).get(2).size(); i++)
        {
            System.out.print(trying.get(0).get(2).get(i).getName() + trying.get(0).get(2).get(i).getSchedule().get(day) + "-" + trying.get(0).get(2).get(i).getSchedule().get(day+1) +", ");
        }
        System.out.println("");
        System.out.print("Peaks: ");
        for(int i = 0; i < trying.get(1).get(1).size(); i++)
        {
            System.out.print(trying.get(1).get(1).get(i).getName() + trying.get(1).get(1).get(i).getSchedule().get(day) + "-" + trying.get(1).get(1).get(i).getSchedule().get(day+1) + ", ");
        }
        for(int i = 0; i < trying.get(1).get(2).size(); i++)
        {
            System.out.print(trying.get(1).get(2).get(i).getName() + trying.get(1).get(2).get(i).getSchedule().get(day) + "-" + trying.get(1).get(2).get(i).getSchedule().get(day+1) +", ");
        }
        System.out.println("");
        System.out.print("Hearth: ");
        for(int i = 0; i < trying.get(2).get(1).size(); i++)
        {
            System.out.print(trying.get(2).get(1).get(i).getName() + trying.get(2).get(1).get(i).getSchedule().get(day) + "-" + trying.get(2).get(1).get(i).getSchedule().get(day+1) + ", ");
        }
        for(int i = 0; i < trying.get(2).get(2).size(); i++)
        {
            System.out.print(trying.get(2).get(2).get(i).getName() + trying.get(2).get(2).get(i).getSchedule().get(day) + "-" + trying.get(2).get(2).get(i).getSchedule().get(day+1) +", ");
        }
        System.out.println("");
        System.out.print("Salads: ");
        for(int i = 0; i < trying.get(3).get(1).size(); i++)
        {
            System.out.print(trying.get(3).get(1).get(i).getName() + trying.get(3).get(1).get(i).getSchedule().get(day) + "-" + trying.get(3).get(1).get(i).getSchedule().get(day+1) +", ");
        }
        for(int i = 0; i < trying.get(3).get(2).size(); i++)
        {
            System.out.print(trying.get(3).get(2).get(i).getName() + trying.get(3).get(2).get(i).getSchedule().get(day) + "-" + trying.get(3).get(2).get(i).getSchedule().get(day+1) +", ");
        }
        System.out.println("");
        System.out.print("Toast: ");
        for(int i = 0; i < trying.get(4).get(1).size(); i++)
        {
            System.out.print(trying.get(4).get(1).get(i).getName() + trying.get(4).get(1).get(i).getSchedule().get(day) + "-" + trying.get(4).get(1).get(i).getSchedule().get(day+1) + ", ");
        }
        for(int i = 0; i < trying.get(4).get(2).size(); i++)
        {
            System.out.print(trying.get(4).get(2).get(i).getName() + trying.get(4).get(2).get(i).getSchedule().get(day) + "-" + trying.get(4).get(2).get(i).getSchedule().get(day+1) +", ");
        }
        System.out.println("");
        System.out.print("Mid: ");
        for(int i = 0; i < trying.get(5).get(1).size(); i++)
        {
            System.out.print(trying.get(5).get(1).get(i).getName() +trying.get(5).get(1).get(i).getSchedule().get(day) + "-" + trying.get(5).get(1).get(i).getSchedule().get(day+1) + ", ");
        }
        for(int i = 0; i < trying.get(5).get(2).size(); i++)
        {
            System.out.print(trying.get(5).get(2).get(i).getName() + trying.get(5).get(2).get(i).getSchedule().get(day) + "-" + trying.get(5).get(2).get(i).getSchedule().get(day+1) +", ");
        }
        System.out.println("");
        System.out.print("Curry: ");
        for(int i = 0; i < trying.get(6).get(1).size(); i++)
        {
            System.out.print(trying.get(6).get(1).get(i).getName() + trying.get(6).get(1).get(i).getSchedule().get(day) + "-" + trying.get(6).get(1).get(i).getSchedule().get(day+1) +", ");
        }
        for(int i = 0; i < trying.get(6).get(2).size(); i++)
        {
            System.out.print(trying.get(6).get(2).get(i).getName() + trying.get(6).get(2).get(i).getSchedule().get(day) + "-" + trying.get(6).get(2).get(i).getSchedule().get(day+1) +", ");
        }
        System.out.println("");
        System.out.print("Grange: ");
        for(int i = 0; i < trying.get(7).get(1).size(); i++)
        {
            System.out.print(trying.get(7).get(1).get(i).getName() +trying.get(7).get(1).get(i).getSchedule().get(day) + "-" + trying.get(7).get(1).get(i).getSchedule().get(day+1) + ", ");
        }
        for(int i = 0; i < trying.get(7).get(2).size(); i++)
        {
            System.out.print(trying.get(7).get(2).get(i).getName() + trying.get(7).get(2).get(i).getSchedule().get(day) + "-" + trying.get(7).get(2).get(i).getSchedule().get(day+1) +", ");
        }
        System.out.println("");
        System.out.print("Dish: ");
        for(int i = 0; i < trying.get(8).get(1).size(); i++)
        {
            System.out.print(trying.get(8).get(1).get(i).getName() + trying.get(8).get(1).get(i).getSchedule().get(day) + "-" + trying.get(8).get(1).get(i).getSchedule().get(day+1) +", ");
        }
        for(int i = 0; i < trying.get(8).get(2).size(); i++)
        {
            System.out.print(trying.get(8).get(2).get(i).getName() + trying.get(8).get(2).get(i).getSchedule().get(day) + "-" + trying.get(8).get(2).get(i).getSchedule().get(day+1) +", ");
        }
        System.out.println("");
        System.out.print("Dra: ");
        for(int i = 0; i < trying.get(9).get(1).size(); i++)
        {
            System.out.print(trying.get(9).get(1).get(i).getName() + trying.get(9).get(1).get(i).getSchedule().get(day) + "-" + trying.get(9).get(1).get(i).getSchedule().get(day+1) +", ");
        }
        for(int i = 0; i < trying.get(9).get(2).size(); i++)
        {
            System.out.print(trying.get(9).get(2).get(i).getName() + trying.get(9).get(2).get(i).getSchedule().get(day) + "-" + trying.get(9).get(2).get(i).getSchedule().get(day+1) +", ");
        }
        System.out.println("");
        System.out.print("Cold Runner: ");
        for(int i = 0; i < trying.get(10).get(1).size(); i++)
        {
            System.out.print(trying.get(10).get(1).get(i).getName() +trying.get(10).get(1).get(i).getSchedule().get(day) + "-" + trying.get(10).get(1).get(i).getSchedule().get(day+1) + ", ");
        }
        for(int i = 0; i < trying.get(10).get(2).size(); i++)
        {
            System.out.print(trying.get(10).get(2).get(i).getName() + trying.get(10).get(2).get(i).getSchedule().get(day) + "-" + trying.get(10).get(2).get(i).getSchedule().get(day+1) +", ");
        }
        System.out.println("");
        System.out.print("Janitor: ");
        for(int i = 0; i < trying.get(11).get(1).size(); i++)
        {
            System.out.print(trying.get(11).get(1).get(i).getName() +trying.get(11).get(1).get(i).getSchedule().get(day) + "-" + trying.get(11).get(1).get(i).getSchedule().get(day+1) + ", ");
        }
        for(int i = 0; i < trying.get(11).get(2).size(); i++)
        {
            System.out.print(trying.get(11).get(2).get(i).getName() + trying.get(11).get(2).get(i).getSchedule().get(day) + "-" + trying.get(11).get(2).get(i).getSchedule().get(day+1) +", ");
        }
        System.out.println("");
        System.out.println("Dinner");
        System.out.print("Checker: ");
        for(int i = 0; i < trying.get(0).get(3).size(); i++)
        {
            System.out.print(trying.get(0).get(3).get(i).getName() + trying.get(0).get(3).get(i).getSchedule().get(day) + "-" + trying.get(0).get(3).get(i).getSchedule().get(day+1) + ", ");
        }
        System.out.println("");
        System.out.print("Peaks: ");
        for(int i = 0; i < trying.get(1).get(3).size(); i++)
        {
            System.out.print(trying.get(1).get(3).get(i).getName() + trying.get(1).get(3).get(i).getSchedule().get(day) + "-" + trying.get(1).get(3).get(i).getSchedule().get(day+1) +", ");
        }
        System.out.println("");
        System.out.print("Hearth: ");
        for(int i = 0; i < trying.get(2).get(3).size(); i++)
        {
            System.out.print(trying.get(2).get(3).get(i).getName() +trying.get(2).get(3).get(i).getSchedule().get(day) + "-" + trying.get(2).get(3).get(i).getSchedule().get(day+1) + ", ");
        }
        System.out.println("");
        System.out.print("Salads: ");
        for(int i = 0; i < trying.get(3).get(3).size(); i++)
        {
            System.out.print(trying.get(3).get(3).get(i).getName() + trying.get(3).get(3).get(i).getSchedule().get(day) + "-" + trying.get(3).get(3).get(i).getSchedule().get(day+1) +", ");
        }
        System.out.println("");
        System.out.print("Toast: ");
        for(int i = 0; i < trying.get(4).get(3).size(); i++)
        {
            System.out.print(trying.get(4).get(3).get(i).getName() + trying.get(4).get(3).get(i).getSchedule().get(day) + "-" + trying.get(4).get(3).get(i).getSchedule().get(day+1) +", ");
        }
        System.out.println("");
        System.out.print("Mid: ");
        for(int i = 0; i < trying.get(5).get(3).size(); i++)
        {
            System.out.print(trying.get(5).get(3).get(i).getName() + trying.get(5).get(3).get(i).getSchedule().get(day) + "-" + trying.get(5).get(3).get(i).getSchedule().get(day+1) +", ");
        }
        System.out.println("");
        System.out.print("Curry: ");
        for(int i = 0; i < trying.get(6).get(3).size(); i++)
        {
            System.out.print(trying.get(6).get(3).get(i).getName() + trying.get(6).get(3).get(i).getSchedule().get(day) + "-" + trying.get(6).get(3).get(i).getSchedule().get(day+1) +", ");
        }
        System.out.println("");
        System.out.print("Grange: ");
        for(int i = 0; i < trying.get(7).get(3).size(); i++)
        {
            System.out.print(trying.get(7).get(3).get(i).getName() + trying.get(7).get(3).get(i).getSchedule().get(day) + "-" + trying.get(7).get(3).get(i).getSchedule().get(day+1) +", ");
        }
        System.out.println("");
        System.out.print("Dish: ");
        for(int i = 0; i < trying.get(8).get(3).size(); i++)
        {
            System.out.print(trying.get(8).get(3).get(i).getName() +trying.get(8).get(3).get(i).getSchedule().get(day) + "-" + trying.get(8).get(3).get(i).getSchedule().get(day+1) + ", ");
        }
        System.out.println("");
        System.out.print("Dra: ");
        for(int i = 0; i < trying.get(9).get(3).size(); i++)
        {
            System.out.print(trying.get(9).get(3).get(i).getName() +trying.get(9).get(3).get(i).getSchedule().get(day) + "-" + trying.get(9).get(3).get(i).getSchedule().get(day+1) + ", ");
        }
        System.out.println("");
        System.out.print("Cold Runner: ");
        for(int i = 0; i < trying.get(10).get(3).size(); i++)
        {
            System.out.print(trying.get(10).get(3).get(i).getName() +trying.get(10).get(3).get(i).getSchedule().get(day) + "-" + trying.get(10).get(3).get(i).getSchedule().get(day+1) + ", ");
        }
        System.out.println("");
        System.out.print("Janitor: ");
        for(int i = 0; i < trying.get(11).get(3).size(); i++)
        {
            System.out.print(trying.get(11).get(3).get(i).getName() +trying.get(11).get(3).get(i).getSchedule().get(day) + "-" + trying.get(11).get(3).get(i).getSchedule().get(day+1) + ", ");
        }
    }

    public List<String> printToString(List<List<List<Student>>> trying, int day){
        List<String> outputs = new ArrayList<>();
        String output = "Morning  \n";
        String output2 = "Mid \n";
        String output3 = "Dinner \n";
        output += "Checker: ";
        for(int i = 0; i < trying.get(0).get(0).size(); i++) {
            if(trying.get(0).get(0).get(i).getLead()) output += "*";
            output += trying.get(0).get(0).get(i).getName() + trying.get(0).get(0).get(i).getSchedule().get(day) + "-" + trying.get(0).get(0).get(i).getSchedule().get(day+1) + ", ";
        }
        output += "\n";
        output += "Mid: ";
        for(int i = 0; i < trying.get(5).get(0).size(); i++) {
            if(trying.get(5).get(0).get(i).getLead()) output += "*";
            output += trying.get(5).get(0).get(i).getName() + trying.get(5).get(0).get(i).getSchedule().get(day) + "-" + trying.get(5).get(0).get(i).getSchedule().get(day+1) + ", ";
        }
        output += "\n";
        output += "Curry: ";
        for(int i = 0; i < trying.get(6).get(0).size(); i++) {
            if(trying.get(6).get(0).get(i).getLead()) output += "*";
            output += trying.get(6).get(0).get(i).getName() + trying.get(6).get(0).get(i).getSchedule().get(day) + "-" + trying.get(6).get(0).get(i).getSchedule().get(day+1) +", ";
        }
        output += "\n";
        output += "Grange: ";
        for(int i = 0; i < trying.get(7).get(0).size(); i++){
            if(trying.get(7).get(0).get(i).getLead()) output += "*";
            output += trying.get(7).get(0).get(i).getName() +trying.get(7).get(0).get(i).getSchedule().get(day) + "-" + trying.get(7).get(0).get(i).getSchedule().get(day+1) + ", " ;
        }
        output += "\n";
        output += "Toast: ";
        for(int i = 0; i < trying.get(4).get(0).size(); i++) {
            if(trying.get(4).get(0).get(i).getLead()) output += "*";
            output += trying.get(4).get(0).get(i).getName() +trying.get(4).get(0).get(i).getSchedule().get(day) + "-" + trying.get(4).get(0).get(i).getSchedule().get(day+1) + ", ";
        }
        output += "\n";
        output += "Hearth: ";
        for(int i = 0; i < trying.get(2).get(0).size(); i++) {
            if(trying.get(2).get(0).get(i).getLead()) output += "*";
            output += trying.get(2).get(0).get(i).getName() +trying.get(2).get(0).get(i).getSchedule().get(day) + "-" + trying.get(2).get(0).get(i).getSchedule().get(day+1) + ", ";
        }
        output += "\n";
        output += "Peaks: ";
        for(int i = 0; i < trying.get(1).get(0).size(); i++) {
            if(trying.get(1).get(0).get(i).getLead()) output += "*";
            output += trying.get(1).get(0).get(i).getName() + trying.get(1).get(0).get(i).getSchedule().get(day) + "-" + trying.get(1).get(0).get(i).getSchedule().get(day+1) +", ";
        }
        output +=  "\n";
        output += "Salads: ";
        for(int i = 0; i < trying.get(3).get(0).size(); i++) {
            if(trying.get(3).get(0).get(i).getLead()) output += "*";
            output += trying.get(3).get(0).get(i).getName() + trying.get(3).get(0).get(i).getSchedule().get(day) + "-" + trying.get(3).get(0).get(i).getSchedule().get(day+1) +", ";
        }
        output += "\n";
        output += "Cold Runner: ";
        for(int i = 0; i < trying.get(10).get(0).size(); i++) {
            if(trying.get(10).get(0).get(i).getLead()) output += "*";
            output += trying.get(10).get(0).get(i).getName() + trying.get(10).get(0).get(i).getSchedule().get(day) + "-" + trying.get(10).get(0).get(i).getSchedule().get(day+1) +", ";
        }
        output += "\n";
        output += "Dra: ";
        for(int i = 0; i < trying.get(9).get(0).size(); i++) {
            if(trying.get(9).get(0).get(i).getLead()) output += "*";
            output += trying.get(9).get(0).get(i).getName() + trying.get(9).get(0).get(i).getSchedule().get(day) + "-" + trying.get(9).get(0).get(i).getSchedule().get(day+1) +", ";
        }
        output += "\n";
        output += "Dish: ";
        for(int i = 0; i < trying.get(8).get(0).size(); i++) {
            if(trying.get(8).get(0).get(i).getLead()) output += "*";
            output += trying.get(8).get(0).get(i).getName() + trying.get(8).get(0).get(i).getSchedule().get(day) + "-" + trying.get(8).get(0).get(i).getSchedule().get(day+1) +", ";
        }
        output += "\n";
        output += "Janitor: ";
        for(int i = 0; i < trying.get(11).get(0).size(); i++) {
            if(trying.get(11).get(0).get(i).getLead()) output += "*";
            output += trying.get(11).get(0).get(i).getName() + trying.get(11).get(0).get(i).getSchedule().get(day) + "-" + trying.get(11).get(0).get(i).getSchedule().get(day+1) +", ";
        }
        output2 += "Checker: ";
        for(int i = 0; i < trying.get(0).get(1).size(); i++) {
            if(trying.get(0).get(1).get(i).getLead()) output2 += "*";
            output2 += trying.get(0).get(1).get(i).getName() + trying.get(0).get(1).get(i).getSchedule().get(day) + "-" + trying.get(0).get(1).get(i).getSchedule().get(day+1) +", ";
        }
        for(int i = 0; i < trying.get(0).get(2).size(); i++) {
            if(trying.get(0).get(2).get(i).getLead()) output2 += "*";
            output2 += trying.get(0).get(2).get(i).getName() + trying.get(0).get(2).get(i).getSchedule().get(day) + "-" + trying.get(0).get(2).get(i).getSchedule().get(day+1) +", ";
        }
        output2 += "\n";
        output2 += "Mid: ";
        for(int i = 0; i < trying.get(5).get(1).size(); i++) {
            if(trying.get(5).get(1).get(i).getLead()) output2 += "*";
            output2 += trying.get(5).get(1).get(i).getName() + trying.get(5).get(1).get(i).getSchedule().get(day) + "-" + trying.get(5).get(1).get(i).getSchedule().get(day+1) + ", ";
        }
        for(int i = 0; i < trying.get(5).get(2).size(); i++) {
            if(trying.get(5).get(2).get(i).getLead()) output2 += "*";
            output2 += trying.get(5).get(2).get(i).getName() + trying.get(5).get(2).get(i).getSchedule().get(day) + "-" + trying.get(5).get(2).get(i).getSchedule().get(day+1) +", ";
        }
        output2 += "\n";
        output2 += "Curry: ";
        for(int i = 0; i < trying.get(6).get(1).size(); i++) {
            if(trying.get(6).get(1).get(i).getLead()) output2 += "*";
            output2 += trying.get(6).get(1).get(i).getName() + trying.get(6).get(1).get(i).getSchedule().get(day) + "-" + trying.get(6).get(1).get(i).getSchedule().get(day+1) + ", ";
        }
        for(int i = 0; i < trying.get(6).get(2).size(); i++) {
            if(trying.get(6).get(2).get(i).getLead()) output2 += "*";
            output2 += trying.get(6).get(2).get(i).getName() + trying.get(6).get(2).get(i).getSchedule().get(day) + "-" + trying.get(6).get(2).get(i).getSchedule().get(day+1) +", ";
        }
        output2 += "\n";
        output2 += "Grange: ";
        for(int i = 0; i < trying.get(7).get(1).size(); i++) {
            if(trying.get(7).get(1).get(i).getLead()) output2 += "*";
            output2 += trying.get(7).get(1).get(i).getName() + trying.get(7).get(1).get(i).getSchedule().get(day) + "-" + trying.get(7).get(1).get(i).getSchedule().get(day+1) +", ";
        }
        for(int i = 0; i < trying.get(7).get(2).size(); i++) {
            if(trying.get(7).get(2).get(i).getLead()) output2 += "*";
            output2 += trying.get(7).get(2).get(i).getName() + trying.get(7).get(2).get(i).getSchedule().get(day) + "-" + trying.get(7).get(2).get(i).getSchedule().get(day+1) +", ";
        }
        output2 += "\n";
        output2 += "Toast: ";
        for(int i = 0; i < trying.get(4).get(1).size(); i++) {
            if(trying.get(4).get(1).get(i).getLead()) output2 += "*";
            output2 += trying.get(4).get(1).get(i).getName() + trying.get(4).get(1).get(i).getSchedule().get(day) + "-" + trying.get(4).get(1).get(i).getSchedule().get(day+1) + ", ";
        }
        for(int i = 0; i < trying.get(4).get(2).size(); i++) {
            if(trying.get(4).get(2).get(i).getLead()) output2 += "*";
            output2 += trying.get(4).get(2).get(i).getName() + trying.get(4).get(2).get(i).getSchedule().get(day) + "-" + trying.get(4).get(2).get(i).getSchedule().get(day+1) +", ";
        }
        output2 += "\n";
        output2 += "Hearth: ";
        for(int i = 0; i < trying.get(2).get(1).size(); i++) {
            if(trying.get(2).get(1).get(i).getLead()) output2 += "*";
            output2 += trying.get(2).get(1).get(i).getName() +trying.get(2).get(1).get(i).getSchedule().get(day) + "-" + trying.get(2).get(1).get(i).getSchedule().get(day+1) + ", ";
        }
        for(int i = 0; i < trying.get(2).get(2).size(); i++) {
            if(trying.get(2).get(2).get(i).getLead()) output2 += "*";
            output2 += trying.get(2).get(2).get(i).getName() + trying.get(2).get(2).get(i).getSchedule().get(day) + "-" + trying.get(2).get(2).get(i).getSchedule().get(day+1) +", ";
        }
        output2 += "\n";
        output2 += "Peaks: ";
        for(int i = 0; i < trying.get(1).get(1).size(); i++) {
            if(trying.get(1).get(1).get(i).getLead()) output2 += "*";
            output2 += trying.get(1).get(1).get(i).getName() + trying.get(1).get(1).get(i).getSchedule().get(day) + "-" + trying.get(1).get(1).get(i).getSchedule().get(day+1) +", ";
        }
        for(int i = 0; i < trying.get(1).get(2).size(); i++) {
            if(trying.get(1).get(2).get(i).getLead()) output2 += "*";
            output2 += trying.get(1).get(2).get(i).getName() + trying.get(1).get(2).get(i).getSchedule().get(day) + "-" + trying.get(1).get(2).get(i).getSchedule().get(day+1) +", ";
        }
        output2 += "\n";
        output2 += "Salads: ";
        for(int i = 0; i < trying.get(3).get(1).size(); i++) {
            if(trying.get(3).get(1).get(i).getLead()) output2 += "*";
            output2 += trying.get(3).get(1).get(i).getName() +trying.get(3).get(1).get(i).getSchedule().get(day) + "-" + trying.get(3).get(1).get(i).getSchedule().get(day+1) + ", " ;
        }
        for(int i = 0; i < trying.get(3).get(2).size(); i++) {
            if(trying.get(3).get(2).get(i).getLead()) output2 += "*";
            output2 += trying.get(3).get(2).get(i).getName() + trying.get(3).get(2).get(i).getSchedule().get(day) + "-" + trying.get(3).get(2).get(i).getSchedule().get(day+1) +", ";
        }
        output2 +=  "\n";
        output2 += "Cold Runner: ";
        for(int i = 0; i < trying.get(10).get(1).size(); i++) {
            if(trying.get(10).get(1).get(i).getLead()) output2 += "*";
            output2 += trying.get(10).get(1).get(i).getName() + trying.get(10).get(1).get(i).getSchedule().get(day) + "-" + trying.get(10).get(1).get(i).getSchedule().get(day+1) +", ";
            if(i % 4 == 0){ output2 += "\n"; }
        }
        for(int i = 0; i < trying.get(10).get(2).size(); i++) {
            if(trying.get(10).get(2).get(i).getLead()) output2 += "*";
            output2 += trying.get(10).get(2).get(i).getName() + trying.get(10).get(2).get(i).getSchedule().get(day) + "-" + trying.get(10).get(2).get(i).getSchedule().get(day+1) +", ";
            if(i % 4 == 0){ output2 += "\n"; }
        }
        output2 +=  "\n";
        output2 += "DRA: ";
        for(int i = 0; i < trying.get(9).get(1).size(); i++) {
            if(trying.get(9).get(1).get(i).getLead()) output2 += "*";
            output2 += trying.get(9).get(1).get(i).getName() + trying.get(9).get(1).get(i).getSchedule().get(day) + "-" + trying.get(9).get(1).get(i).getSchedule().get(day+1) +", ";
            if(i % 4 == 0){ output2 += "\n"; }
        }
        for(int i = 0; i < trying.get(9).get(2).size(); i++) {
            if(trying.get(9).get(2).get(i).getLead()) output2 += "*";
            output2 += trying.get(9).get(2).get(i).getName() + trying.get(9).get(2).get(i).getSchedule().get(day) + "-" + trying.get(9).get(2).get(i).getSchedule().get(day+1) +", ";
            if(i % 4 == 0){ output2 += "\n"; }
        }
        output2 += "\n";
        output2 += "Dish: ";
        for(int i = 0; i < trying.get(8).get(1).size(); i++) {
            if(trying.get(8).get(1).get(i).getLead()) output2 += "*";
            output2 += trying.get(8).get(1).get(i).getName() + trying.get(8).get(1).get(i).getSchedule().get(day) + "-" + trying.get(8).get(1).get(i).getSchedule().get(day+1) +", ";
            if(i % 4 == 0){ output2 += "\n"; }
        }
        for(int i = 0; i < trying.get(8).get(2).size(); i++) {
            if(trying.get(8).get(2).get(i).getLead()) output2 += "*";
            output2 += trying.get(8).get(2).get(i).getName() + trying.get(8).get(2).get(i).getSchedule().get(day) + "-" + trying.get(8).get(2).get(i).getSchedule().get(day+1) +", ";
            if(i % 4 == 0){ output2 += "\n"; }
        }
        output2 += "\n";
        output2 += "Janitor: ";
        for(int i = 0; i < trying.get(11).get(1).size(); i++) {
            if(trying.get(11).get(1).get(i).getLead()) output2 += "*";
            output2 += trying.get(11).get(1).get(i).getName() +trying.get(11).get(1).get(i).getSchedule().get(day) + "-" + trying.get(11).get(1).get(i).getSchedule().get(day+1) + ", ";
        }
        for(int i = 0; i < trying.get(11).get(2).size(); i++) {
            if(trying.get(11).get(2).get(i).getLead()) output2 += "*";
            output2 += trying.get(11).get(2).get(i).getName() + trying.get(11).get(2).get(i).getSchedule().get(day) + "-" + trying.get(11).get(2).get(i).getSchedule().get(day+1) +", ";
        }
        output3 += "Checker: ";
        for(int i = 0; i < trying.get(0).get(3).size(); i++) {
            if(trying.get(0).get(3).get(i).getLead()) output3 += "*";
            output3 += trying.get(0).get(3).get(i).getName() + trying.get(0).get(3).get(i).getSchedule().get(day) + "-" + trying.get(0).get(3).get(i).getSchedule().get(day+1) + ", ";
        }
        output3 += "\n";
        output3 += "Mid: ";
        for(int i = 0; i < trying.get(5).get(3).size(); i++) {
            if(trying.get(5).get(3).get(i).getLead()) output3 += "*";
            output3 += trying.get(5).get(3).get(i).getName() + trying.get(5).get(3).get(i).getSchedule().get(day) + "-" + trying.get(5).get(3).get(i).getSchedule().get(day+1) +", ";
        }
        output3 += "\n";
        output3 += "Curry: ";
        for(int i = 0; i < trying.get(6).get(3).size(); i++) {
            if(trying.get(6).get(3).get(i).getLead()) output3 += "*";
            output3 += trying.get(6).get(3).get(i).getName() +trying.get(6).get(3).get(i).getSchedule().get(day) + "-" + trying.get(6).get(3).get(i).getSchedule().get(day+1) + ", ";
        }
        output3 += "\n";
        output3 += "Grange: ";
        for(int i = 0; i < trying.get(7).get(3).size(); i++) {
            if(trying.get(7).get(3).get(i).getLead()) output3 += "*";
            output3 += trying.get(7).get(3).get(i).getName() + trying.get(7).get(3).get(i).getSchedule().get(day) + "-" + trying.get(7).get(3).get(i).getSchedule().get(day+1) +", ";
        }
        output3 += "\n";
        output3 += "Toast: ";
        for(int i = 0; i < trying.get(4).get(3).size(); i++) {
            if(trying.get(4).get(3).get(i).getLead()) output3 += "*";
            output3 += trying.get(4).get(3).get(i).getName() + trying.get(4).get(3).get(i).getSchedule().get(day) + "-" + trying.get(4).get(3).get(i).getSchedule().get(day+1) +", ";
        }
        output3 += "\n";
        output3 += "Hearth: ";
        for(int i = 0; i < trying.get(2).get(3).size(); i++) {
            if(trying.get(2).get(3).get(i).getLead()) output3 += "*";
            output3 += trying.get(2).get(3).get(i).getName() + trying.get(2).get(3).get(i).getSchedule().get(day) + "-" + trying.get(2).get(3).get(i).getSchedule().get(day+1) +", ";
        }
        output3 += "\n";
        output3 += "Peaks: ";
        for(int i = 0; i < trying.get(1).get(3).size(); i++) {
            if(trying.get(1).get(3).get(i).getLead()) output3 += "*";
            output3 += trying.get(1).get(3).get(i).getName() + trying.get(1).get(3).get(i).getSchedule().get(day) + "-" + trying.get(1).get(3).get(i).getSchedule().get(day+1) +", ";
        }
        output3 += "\n";
        output3 += "Salads: ";
        for(int i = 0; i < trying.get(3).get(3).size(); i++) {
            if(trying.get(3).get(3).get(i).getLead()) output3 += "*";
            output3 += trying.get(3).get(3).get(i).getName() + trying.get(3).get(3).get(i).getSchedule().get(day) + "-" + trying.get(3).get(3).get(i).getSchedule().get(day+1) +", ";
            if(i % 4 == 0){ output3 += "\n"; }
        }
        output3 += "\n";
        output3 += "Cold Runner: ";
        for(int i = 0; i < trying.get(10).get(3).size(); i++) {
            if(trying.get(10).get(3).get(i).getLead()) output3 += "*";
            output3 += trying.get(10).get(3).get(i).getName() +trying.get(10).get(3).get(i).getSchedule().get(day) + "-" + trying.get(10).get(3).get(i).getSchedule().get(day+1) + ", ";

        }
        output3 += "\n";
        output3 += "DRA: ";
        for(int i = 0; i < trying.get(9).get(3).size(); i++) {
            if(trying.get(9).get(3).get(i).getLead()) output3 += "*";
            output3 += trying.get(9).get(3).get(i).getName() +trying.get(9).get(3).get(i).getSchedule().get(day) + "-" + trying.get(9).get(3).get(i).getSchedule().get(day+1) + ", ";
            if(i % 4 == 0){ output3 += "\n"; }
        }
        output3 += "\n";
        output3 += "Dish: ";
        for(int i = 0; i < trying.get(8).get(3).size(); i++) {
            if(trying.get(8).get(3).get(i).getLead()) output3 += "*";
            output3 += trying.get(8).get(3).get(i).getName() +trying.get(8).get(3).get(i).getSchedule().get(day) + "-" + trying.get(8).get(3).get(i).getSchedule().get(day+1) + ", ";
            if(i % 4 == 0){ output3 += "\n"; }
        }
        output3 += "\n";
        output3 += "Janitor: ";
        for(int i = 0; i < trying.get(11).get(3).size(); i++) {
            if(trying.get(11).get(3).get(i).getLead()) output3 += "*";
            output3 += trying.get(11).get(3).get(i).getName() +trying.get(11).get(3).get(i).getSchedule().get(day) + "-" + trying.get(11).get(3).get(i).getSchedule().get(day+1) + ", ";
        }
        outputs.add(output);
        outputs.add(output2);
        outputs.add(output3);
        return outputs;
    }

    public String getCoverage(List<List<Student>> pool, int day){
        String result = "";
        if(day == 1)  result = "Sunday \n";
        if(day == 3) result = "Monday \n";
        if(day == 5) result = "Tuesday \n";
        if(day == 7) result = "Wednesday \n";
        if(day == 9) result = "Thursday \n";
        if(day == 11) result = "Friday \n";
        if(day == 13) result = "Saturday \n";
        result += "\n";
        result +=  "Morning: " + pool.get(0).size() + "\n \n";
        result +=  "Early Mid: " + pool.get(1).size()+ "   Late Mid: " + pool.get(2).size() + "\n";
        result +=  "Total Mid: " + (pool.get(1).size()+ pool.get(2).size()) + "\n \n";
        result += "\n";
        result +=  "Dinner: " + pool.get(3).size();

        return result;

    }
    /// TODO: cool idea, in coverage I can mark priority based on how well shifts are filled with current schedule

    private Boolean neededMidMinShiftsFilled(List<Station> stations){
        Boolean filled = true;
        for(Station station: stations){
            if(station.getMorningPeopleNeeded() > station.getTotalMorning()){
                if(station.getEarlyMidPeopleNeeded() > station.getEarlyMid()){
                    filled = false;
                }
            }
        }
        return filled;
    }

    private Boolean availableMidMinShiftsFilled(List<Station> stations){
        Boolean filled = true;
        for(Station station: stations ){

                if(station.getMorningMaxWorkers() > station.getTotalMorning()){
                    if(station.getEarlyMidPeopleNeeded() > station.getEarlyMid()){
                        filled = false;
                    }
                }


        }
        return filled;
    }
    private Boolean availableCloseMinShiftsFilled(List<Station> stations, int shift){
        Boolean filled = true;
        for(Station station: stations){
            if(shift == 1){
                if(station.getEarlyMidMaxWorkers() > station.getEarlyMid()){
                    if(station.getDinnerPeopleNeeded() > station.getTotalDinner()){
                        filled = false;
                    }
                }
            }
            else if(shift == 2){
                if(station.getLateMidMaxWorkers() > station.getLateMid()){
                    if(station.getDinnerPeopleNeeded() > station.getTotalDinner()){
                        filled = false;
                    }
                }
            }
            else{
                if(station.getMorningMaxWorkers() > station.getTotalMorning()){
                    if(station.getDinnerPeopleNeeded() > station.getTotalDinner()){
                        filled = false;
                    }
                }
            }

        }
        return filled;

    }
}
