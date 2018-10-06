import java.util.ArrayList;
import java.util.List;

public class Schedule {

    private String Sunday;
    private String Monday;
    private String Tuesday;
    private String Wednesday;
    private String Thursday;
    private String Friday;
    private String Saturday;



    private List<Student> students;

    public Schedule(List<List<Object>> times){
        this.students = building(times);

    }


    public List<Student> building(List<List<Object>> times) {

        List<Student> students = new ArrayList<>();
        int studentIndex = 0;
        for(int i = 0; i < times.size(); i++){
            if(times.get(i).size() > 1) {
                //If student has split shift name won't be on same row, so it sets it to the name from previous row
                if(times.get(i).get(0).toString().compareTo("") != 0) {
                    students.add(new Student(times.get(i).get(0).toString(), times.get(i)));
                }
                else{
                    students.add(new Student(times.get(i-1).get(0).toString(), times.get(i)));
                }
            }
        }
        return students;
    }
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
        Builds daily pool of students separated by Morning, Mid, and Dinner shifts

        @param List<Student> studentsWorking (list of people working that day)
        @param int day (day index for intended day

     */
    public List<List<Student>> buildPool(List<Student> studentsWorking, int day){
     List<List<Student>> pool = new ArrayList<List<Student>>();
     List<Student> morning = new ArrayList<Student>();
     List<Student> mid = new ArrayList<Student>();
     List<Student> dinner = new ArrayList<Student>();
     pool.add(morning);
     pool.add(mid);
     pool.add(dinner);


     for(int i = 0; i < studentsWorking.size(); i++){
         //Weekday morning (starting before 8am)
      try{   if(studentsWorking.get(i).getSchedule().get(day).toString().endsWith("am") &&
                 Integer.parseInt(studentsWorking.get(i).getSchedule().get(day).toString().substring(0,1)) < 8 &&
         Integer.parseInt(studentsWorking.get(i).getSchedule().get(day).toString().substring(0,1)) > 5 && day != 1 && day != 13){
             System.out.println("Morning: " + studentsWorking.get(i).getName())   ;
             pool.get(0).add(studentsWorking.get(i));
             if(studentsWorking.get(i).getSchedule().get(day+1).toString().compareTo("CL") == 0){
                 pool.get(1).add(studentsWorking.get(i));
                 pool.get(2).add(studentsWorking.get(i));
             }
             else if(Integer.parseInt(studentsWorking.get(i).getSchedule().get(day+1).toString().substring(0,1)) > 1){
                 pool.get(1).add(studentsWorking.get(i));
             }
         }

         //Weekend morning (starting before 10am)
         else if(studentsWorking.get(i).getSchedule().get(day).toString().endsWith("am") &&
                 Integer.parseInt(studentsWorking.get(i).getSchedule().get(day).toString().substring(0,1)) < 10 &&
                 Integer.parseInt(studentsWorking.get(i).getSchedule().get(day).toString().substring(0,1)) > 5 && (day == 1 || day == 13)){
             pool.get(0).add(studentsWorking.get(i));
             System.out.println("weekend Morning: " + studentsWorking.get(i).getName());
             //if they leave at CL add them to mid and close as well
             if(studentsWorking.get(i).getSchedule().get(day+1).toString().compareTo("CL") == 0){
                 pool.get(1).add(studentsWorking.get(i));
                 pool.get(2).add(studentsWorking.get(i));
             }
             //else if they leave after 1pm but before close, add them to mid
             else if(Integer.parseInt(studentsWorking.get(i).getSchedule().get(day+1).toString().substring(0,1)) > 1){
                 pool.get(1).add(studentsWorking.get(i));
             }
         }
         //Weekend/Weekday Mid + Close shift (starting before 3pm and Closing)
         else if(studentsWorking.get(i).getSchedule().get(day+1).toString().compareTo("CL") == 0 &&
                 ((Integer.parseInt(studentsWorking.get(i).getSchedule().get(day).toString().substring(0,1)) < 3) ||
                         (Integer.parseInt(studentsWorking.get(i).getSchedule().get(day).toString().substring(0,1)) > 7)  )){
             pool.get(1).add(studentsWorking.get(i));
             pool.get(2).add(studentsWorking.get(i));
             System.out.println("mid to close: "+ studentsWorking.get(i).getName());
         }
         //weekend/weekday Close (Starts 3pm or later and Closing)
         else if(studentsWorking.get(i).getSchedule().get(day+1).toString().compareTo("CL") == 0){
             System.out.println("Dinner: " + studentsWorking.get(i).getName());
             pool.get(2).add(studentsWorking.get(i));
         }
         else if(studentsWorking.get(i).getSchedule().get(day).toString().compareTo("") == 0){
             //do nothing, this shouldn't happen
             System.out.println("something went wrong here");
         }
         //Weekend/weekday mid (not opening or closing)
         else{
             System.out.println("Mid: " + studentsWorking.get(i).getName());
             pool.get(1).add(studentsWorking.get(i));
         }}
         catch(Exception exception){
          System.out.println("Cannot convert"); //todo: check with justin on this
         }
     }
        return pool;
    }



    public List<List<List<Student>>> createDuck(List<List<Student>> pool, List<Station> stationList){

        List<List<List<Student>>> masterList = new ArrayList<List<List<Student>>>();
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
        List<Student> checkMidday = new ArrayList<Student>();
        List<Student> checkDin = new ArrayList<Student>();
        List<Student> peaksMorn = new ArrayList<Student>();
        List<Student> peaksMidday = new ArrayList<Student>();
        List<Student> peaksDin = new ArrayList<Student>();
        List<Student> hearthMorn = new ArrayList<Student>();
        List<Student> hearthMidday = new ArrayList<Student>();
        List<Student> hearthDin = new ArrayList<Student>();
        List<Student> saladsMorn = new ArrayList<Student>();
        List<Student> saladsMidday = new ArrayList<Student>();
        List<Student> saladsDin = new ArrayList<Student>();
        List<Student> toastMorn = new ArrayList<Student>();
        List<Student> toastMidday = new ArrayList<Student>();
        List<Student> toastDin = new ArrayList<Student>();
        List<Student> midMorn = new ArrayList<Student>();
        List<Student> midMidday = new ArrayList<Student>();
        List<Student> midDin = new ArrayList<Student>();
        List<Student> curryMorn = new ArrayList<Student>();
        List<Student> curryMidday = new ArrayList<Student>();
        List<Student> curryDin = new ArrayList<Student>();
        List<Student> grangeMorn = new ArrayList<Student>();
        List<Student> grangeMidday = new ArrayList<Student>();
        List<Student> grangeDin = new ArrayList<Student>();
        List<Student> dishMorn = new ArrayList<Student>();
        List<Student> dishMidday = new ArrayList<Student>();
        List<Student> dishDin = new ArrayList<Student>();
        List<Student> draMorn = new ArrayList<Student>();
        List<Student> draMidday = new ArrayList<Student>();
        List<Student> draDin = new ArrayList<Student>();
        List<Student> janMorn = new ArrayList<Student>();
        List<Student> janMidday = new ArrayList<Student>();
        List<Student> janDin = new ArrayList<Student>();
        List<Student> coldMorn = new ArrayList<Student>();
        List<Student> coldMidday = new ArrayList<Student>();
        List<Student> coldDin = new ArrayList<Student>();

        checker.add(checkMorn);
        checker.add(checkMidday);
        checker.add(checkDin);
        peaks.add(peaksMorn);
        peaks.add(peaksMidday);
        peaks.add(peaksDin);
        hearth.add(hearthMorn);
        hearth.add(hearthMidday);
        hearth.add(hearthDin);
        salads.add(saladsMorn);
        salads.add(saladsMidday);
        salads.add(saladsDin);
        toast.add(toastMorn);
        toast.add(toastMidday);
        toast.add(toastDin);
        mid.add(midMorn);
        mid.add(midMidday);
        mid.add(midDin);
        curry.add(curryMorn);
        curry.add(curryMidday);
        curry.add(curryDin);
        grange.add(grangeMorn);
        grange.add(grangeMidday);
        grange.add(grangeDin);
        dish.add(dishMorn);
        dish.add(dishMidday);
        dish.add(dishDin);
        dra.add(draMorn);
        dra.add(draMidday);
        dra.add(draDin);
        jan.add(janMorn);
        jan.add(janMidday);
        jan.add(janDin);
        cold.add(coldMorn);
        cold.add(coldMidday);
        cold.add(coldDin);



        masterList.add(checker); //0
        masterList.add(peaks); //1
        masterList.add(hearth); //2
        masterList.add(salads); //3
        masterList.add(toast); //4
        masterList.add(mid); //5
        masterList.add(curry); //6
        masterList.add(grange); //7
        masterList.add(dish); //8
        masterList.add(dra); //9
        masterList.add(cold);//10
        masterList.add(jan); //11

        while(pool.get(0).size() > 0) {
            if (stationList.get(0).getMorningPeopleNeeded() > stationList.get(0).getTotalMorning() && pool.get(0).size() != 0) {  // fill checker
                Student temp = randomChooser(pool.get(0), 1);
                masterList.get(0).get(0).add(temp);
                pool.set(0,removeByName(temp.getName(), pool.get(0)) ) ;
                stationList.get(0).addMorningStudent();
            }
            if (stationList.get(1).getMorningPeopleNeeded() > stationList.get(1).getTotalMorning() && pool.get(0).size() != 0) { // fill peaks
                Student temp = randomChooser(pool.get(0), 2);
                masterList.get(1).get(0).add(temp);
                pool.set(0,removeByName(temp.getName(), pool.get(0)) ) ;
                stationList.get(1).addMorningStudent();
            }
            if (stationList.get(2).getMorningPeopleNeeded() > stationList.get(2).getTotalMorning() && pool.get(0).size() != 0) { // fill hearth
                Student temp = randomChooser(pool.get(0), 3);
                masterList.get(2).get(0).add(temp);
                pool.set(0,removeByName(temp.getName(), pool.get(0)) ) ;
                stationList.get(2).addMorningStudent();
            }
            if (stationList.get(3).getMorningPeopleNeeded() > stationList.get(3).getTotalMorning() && pool.get(0).size() != 0) { // fill salads
                Student temp = randomChooser(pool.get(0), 4);
                masterList.get(3).get(0).add(temp);
                pool.set(0,removeByName(temp.getName(), pool.get(0)) ) ;
                stationList.get(3).addMorningStudent();
            }
            if (stationList.get(4).getMorningPeopleNeeded() > stationList.get(4).getTotalMorning() && pool.get(0).size() != 0) { //fill toast
                Student temp = randomChooser(pool.get(0), 5);
                masterList.get(4).get(0).add(temp);
                pool.set(0,removeByName(temp.getName(), pool.get(0)) ) ;
                stationList.get(4).addMorningStudent();
            }
            if (stationList.get(5).getMorningPeopleNeeded() > stationList.get(5).getTotalMorning() && pool.get(0).size() != 0) { //fill mid
                Student temp = randomChooser(pool.get(0), 6);
                masterList.get(5).get(0).add(temp);
                pool.set(0,removeByName(temp.getName(), pool.get(0)) ) ;
                stationList.get(5).addMorningStudent();
            }
            if (stationList.get(6).getMorningPeopleNeeded() > stationList.get(6).getTotalMorning() && pool.get(0).size() != 0) { //fill curry
                Student temp = randomChooser(pool.get(0), 7);
                masterList.get(6).get(0).add(temp);
                pool.set(0,removeByName(temp.getName(), pool.get(0)) ) ;
                stationList.get(6).addMorningStudent();
            }
            if (stationList.get(7).getMorningPeopleNeeded() > stationList.get(7).getTotalMorning() && pool.get(0).size() != 0) { //fill grange
                Student temp = randomChooser(pool.get(0), 8);
                masterList.get(7).get(0).add(temp);
                pool.set(0,removeByName(temp.getName(), pool.get(0)) ) ;
                stationList.get(7).addMorningStudent();
            }
            if (stationList.get(8).getMorningPeopleNeeded() > stationList.get(8).getTotalMorning() && pool.get(0).size() != 0) { //fill dish
                Student temp = randomChooser(pool.get(0), 9);
                masterList.get(8).get(0).add(temp);
                pool.set(0,removeByName(temp.getName(), pool.get(0)) ) ;
                stationList.get(8).addMorningStudent();
            }
            if (stationList.get(9).getMorningPeopleNeeded() > stationList.get(8).getTotalMorning() && pool.get(0).size() != 0){  //fill dra
                Student temp = randomChooser(pool.get(0), 10);
                masterList.get(9).get(0).add(temp);
                pool.set(0, removeByName(temp.getName(), pool.get(0)));
                stationList.get(9).addMorningStudent();
            }
            if (stationList.get(10).getMorningPeopleNeeded() > stationList.get(10).getTotalMorning() && pool.get(0).size() != 0){  //fill cold runner
                Student temp = randomChooser(pool.get(0), 11);
                masterList.get(10).get(0).add(temp);
                pool.set(0, removeByName(temp.getName(), pool.get(0)));
                stationList.get(10).addMorningStudent();
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
                masterList.get(11).get(0).add(temp);
                pool.set(0,removeByName(temp.getName(), pool.get(0)) ) ;
                stationList.get(11).addMorningStudent();
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
                        masterList.get(8).get(0).add(temp);
                        pool.set(0,removeByName(temp.getName(), pool.get(0)) ) ;
                        stationList.get(8).addMorningStudent();
                    }
                    if (stationList.get(1).getMorningMaxWorkers() > stationList.get(1).getTotalMorning() && pool.get(0).size() != 0) { // fill peaks
                        Student temp = randomChooser(pool.get(0), 2);
                        masterList.get(1).get(0).add(temp);
                        pool.set(0,removeByName(temp.getName(), pool.get(0)) ) ;
                        stationList.get(1).addMorningStudent();
                    }
                    if (stationList.get(10).getMorningMaxWorkers() > stationList.get(10).getTotalMorning() && pool.get(0).size() != 0){ //fill cold runner
                        Student temp = randomChooser(pool.get(0), 11);
                        masterList.get(10).get(0).add(temp);
                        pool.set(0, removeByName(temp.getName(), pool.get(0)) );
                        stationList.get(10).addMorningStudent();
                    }
                    if (stationList.get(2).getMorningMaxWorkers() > stationList.get(2).getTotalMorning() && pool.get(0).size() != 0) { // fill hearth
                        Student temp = randomChooser(pool.get(0), 3);
                        masterList.get(2).get(0).add(temp);
                        pool.set(0,removeByName(temp.getName(), pool.get(0)) ) ;
                        stationList.get(2).addMorningStudent();
                    }
                    if (stationList.get(3).getMorningMaxWorkers() > stationList.get(3).getTotalMorning() && pool.get(0).size() != 0) { // fill salads
                        Student temp = randomChooser(pool.get(0), 4);
                        masterList.get(3).get(0).add(temp);
                        pool.set(0,removeByName(temp.getName(), pool.get(0)) ) ;
                        stationList.get(3).addMorningStudent();
                    }
                    if (stationList.get(4).getMorningMaxWorkers() > stationList.get(4).getTotalMorning() && pool.get(0).size() != 0) { //fill toast
                        Student temp = randomChooser(pool.get(0), 5);
                        masterList.get(4).get(0).add(temp);
                        pool.set(0,removeByName(temp.getName(), pool.get(0)) ) ;
                        stationList.get(4).addMorningStudent();
                    }
                    if (stationList.get(5).getMorningMaxWorkers() > stationList.get(5).getTotalMorning() && pool.get(0).size() != 0) { //fill mid
                        Student temp = randomChooser(pool.get(0), 6);
                        masterList.get(5).get(0).add(temp);
                        pool.set(0,removeByName(temp.getName(), pool.get(0)) ) ;
                        stationList.get(5).addMorningStudent();
                    }
                    if (stationList.get(6).getMorningMaxWorkers() > stationList.get(6).getTotalMorning() && pool.get(0).size() != 0) { //fill curry
                        Student temp = randomChooser(pool.get(0), 7);
                        masterList.get(6).get(0).add(temp);
                        pool.set(0,removeByName(temp.getName(), pool.get(0)) ) ;
                        stationList.get(6).addMorningStudent();
                    }
                    if (stationList.get(7).getMorningMaxWorkers() > stationList.get(7).getTotalMorning() && pool.get(0).size() != 0) { //fill grange
                        Student temp = randomChooser(pool.get(0), 8);
                        masterList.get(7).get(0).add(temp);
                        pool.set(0,removeByName(temp.getName(), pool.get(0)) ) ;
                        stationList.get(7).addMorningStudent();
                    }
                    if (stationList.get(9).getMorningMaxWorkers() > stationList.get(9).getTotalMorning() && pool.get(0).size() != 0) { //fill dra
                        Student temp = randomChooser(pool.get(0), 10);
                        masterList.get(9).get(0).add(temp);
                        pool.set(0,removeByName(temp.getName(), pool.get(0)) ) ;
                        stationList.get(9).addMorningStudent();
                    }
                    if (stationList.get(0).getMorningMaxWorkers() > stationList.get(0).getTotalMorning() && pool.get(0).size() != 0){  //fill check
                        Student temp = randomChooser(pool.get(0), 1);
                        masterList.get(0).get(0).add(temp);
                        pool.set(0, removeByName(temp.getName(), pool.get(0)));
                        stationList.get(0).addMorningStudent();
                    }
                    if(stationList.get(11).getMorningMaxWorkers() > stationList.get(11).getTotalMorning() && pool.get(0).size() != 0){
                        Student temp = randomChooser(pool.get(0), 12);
                        masterList.get(11).get(0).add(temp);
                        pool.set(0, removeByName(temp.getName(), pool.get(0)));
                        stationList.get(11).addMorningStudent();
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
                        masterList.get(8).get(0).add(temp);
                        pool.set(0, removeByName(temp.getName(), pool.get(0)));
                        stationList.get(8).addMorningStudent();
                    }
                }
            }

        }
        while(pool.get(1).size() > 0) {
            if (stationList.get(0).getMidPeopleNeeded() > stationList.get(0).getTotalMid() && pool.get(1).size() != 0) {  // fill checker
                Student temp = randomChooser(pool.get(1), 1);
                masterList.get(0).get(1).add(temp);
                pool.set(1,removeByName(temp.getName(), pool.get(1)) ) ;
                stationList.get(0).addMidStudent();
            }
            if (stationList.get(1).getMidPeopleNeeded() > stationList.get(1).getTotalMid() && pool.get(1).size() != 0) { // fill peaks
                Student temp = randomChooser(pool.get(1), 2);
                masterList.get(1).get(1).add(temp);
                pool.set(1,removeByName(temp.getName(), pool.get(1)) ) ;
                stationList.get(1).addMidStudent();
            }
            if (stationList.get(2).getMidPeopleNeeded() > stationList.get(2).getTotalMid() && pool.get(1).size() != 0) { // fill hearth
                Student temp = randomChooser(pool.get(1), 3);
                masterList.get(2).get(1).add(temp);
                pool.set(1,removeByName(temp.getName(), pool.get(1)) ) ;
                stationList.get(2).addMidStudent();
            }
            if (stationList.get(3).getMidPeopleNeeded() > stationList.get(3).getTotalMid() && pool.get(1).size() != 0) { // fill salads
                Student temp = randomChooser(pool.get(1), 4);
                masterList.get(3).get(1).add(temp);
                pool.set(1,removeByName(temp.getName(), pool.get(1)) ) ;
                stationList.get(3).addMidStudent();
            }
            if (stationList.get(4).getMidPeopleNeeded() > stationList.get(4).getTotalMid() && pool.get(1).size() != 0) { //fill toast
                Student temp = randomChooser(pool.get(1), 5);
                masterList.get(4).get(1).add(temp);
                pool.set(1,removeByName(temp.getName(), pool.get(1)) ) ;
                stationList.get(4).addMidStudent();
            }
            if (stationList.get(5).getMidPeopleNeeded() > stationList.get(5).getTotalMid() && pool.get(1).size() != 0) { //fill mid
                Student temp = randomChooser(pool.get(1), 6);
                masterList.get(5).get(1).add(temp);
                pool.set(1,removeByName(temp.getName(), pool.get(1)) ) ;
                stationList.get(5).addMidStudent();
            }
            if (stationList.get(6).getMidPeopleNeeded() > stationList.get(6).getTotalMid() && pool.get(1).size() != 0) { //fill curry
                Student temp = randomChooser(pool.get(1), 7);
                masterList.get(6).get(1).add(temp);
                pool.set(1,removeByName(temp.getName(), pool.get(1)) ) ;
                stationList.get(6).addMidStudent();
            }
            if (stationList.get(7).getMidPeopleNeeded() > stationList.get(7).getTotalMid() && pool.get(1).size() != 0) { //fill grange
                Student temp = randomChooser(pool.get(1), 8);
                masterList.get(7).get(1).add(temp);
                pool.set(1,removeByName(temp.getName(), pool.get(1)) ) ;
                stationList.get(7).addMidStudent();
            }
            if (stationList.get(8).getMidPeopleNeeded() > stationList.get(8).getTotalMid() && pool.get(1).size() != 0) { //fill dish
                Student temp = randomChooser(pool.get(1), 9);
                masterList.get(8).get(1).add(temp);
                pool.set(1,removeByName(temp.getName(), pool.get(1)) ) ;
                stationList.get(8).addMidStudent();
            }

            if (stationList.get(9).getMidPeopleNeeded() > stationList.get(9).getTotalMid() && pool.get(1).size() != 0){  //fill dra
                Student temp = randomChooser(pool.get(1), 10);
                masterList.get(9).get(1).add(temp);
                pool.set(1, removeByName(temp.getName(), pool.get(1)));
                stationList.get(9).addMidStudent();
            }
            if (stationList.get(10).getMidPeopleNeeded() > stationList.get(10).getTotalMid() && pool.get(1).size() != 0){  //fill dra
                Student temp = randomChooser(pool.get(1), 11);
                masterList.get(10).get(1).add(temp);
                pool.set(1, removeByName(temp.getName(), pool.get(1)));
                stationList.get(10).addMidStudent();
            }
            if((stationList.get(0).getTotalMid() >= stationList.get(0).getMidPeopleNeeded()) &&
                    (stationList.get(1).getTotalMid() >= stationList.get(1).getMidPeopleNeeded()) &&
                    (stationList.get(2).getTotalMid() >= stationList.get(2).getMidPeopleNeeded()) &&
                    (stationList.get(3).getTotalMid() >= stationList.get(3).getMidPeopleNeeded()) &&
                    (stationList.get(4).getTotalMid() >= stationList.get(4).getMidPeopleNeeded()) &&
                    (stationList.get(5).getTotalMid() >= stationList.get(5).getMidPeopleNeeded()) &&
                    (stationList.get(7).getTotalMid() >= stationList.get(7).getMidPeopleNeeded()) &&
                    (stationList.get(8).getTotalMid() >= stationList.get(8).getMidPeopleNeeded()) &&
                    (stationList.get(9).getTotalMid() >= stationList.get(9).getMidPeopleNeeded()) &&
                    (stationList.get(10).getTotalMid() >= stationList.get(10).getMidPeopleNeeded()) &&
                    (stationList.get(11).getTotalMid() < stationList.get(11).getMidPeopleNeeded()) && pool.get(1).size() != 0){   //fill jan if other stations meet minimum (until jan meets its min)
                Student temp = randomChooser(pool.get(1), 11);
                masterList.get(10).get(1).add(temp);
                pool.set(1,removeByName(temp.getName(), pool.get(1)) ) ;
                stationList.get(10).addMidStudent();

            }
            if( (stationList.get(0).getTotalMid() >= stationList.get(0).getMidPeopleNeeded()) &&
                    (stationList.get(1).getTotalMid() >= stationList.get(1).getMidPeopleNeeded()) &&
                    (stationList.get(2).getTotalMid() >= stationList.get(2).getMidPeopleNeeded()) &&
                    (stationList.get(3).getTotalMid() >= stationList.get(3).getMidPeopleNeeded()) &&
                    (stationList.get(4).getTotalMid() >= stationList.get(4).getMidPeopleNeeded()) &&
                    (stationList.get(5).getTotalMid() >= stationList.get(5).getMidPeopleNeeded()) &&
                    (stationList.get(7).getTotalMid() >= stationList.get(7).getMidPeopleNeeded()) &&
                    (stationList.get(8).getTotalMid() >= stationList.get(8).getMidPeopleNeeded()) &&
                    (stationList.get(9).getTotalMid() >= stationList.get(9).getMidPeopleNeeded()) &&
                    (stationList.get(10).getTotalMid() >= stationList.get(10).getMidPeopleNeeded()) &&
                    (stationList.get(11).getTotalMid() >= stationList.get(11).getMidPeopleNeeded()) && pool.get(1).size() != 0){  //if all stations meet minimum requirements, start filling to max
                while(pool.get(1).size() > 0){ //order switched so extras go where help is more needed first
                    if (stationList.get(8).getMidMaxWorkers() > stationList.get(8).getTotalMid() && pool.get(1).size() != 0) {  //fill dish
                        Student temp = randomChooser(pool.get(1), 9);
                        masterList.get(8).get(1).add(temp);
                        pool.set(1,removeByName(temp.getName(), pool.get(1)) ) ;
                        stationList.get(8).addMidStudent();
                    }
                    if (stationList.get(1).getMidMaxWorkers() > stationList.get(1).getTotalMid() && pool.get(1).size() != 0) { // fill peaks
                        Student temp = randomChooser(pool.get(1), 2);
                        masterList.get(1).get(1).add(temp);
                        pool.set(1,removeByName(temp.getName(), pool.get(1)) ) ;
                        stationList.get(1).addMidStudent();
                    }
                    if (stationList.get(10).getMidMaxWorkers() > stationList.get(10).getTotalMid() && pool.get(1).size() != 0) { //fill cold
                        Student temp = randomChooser(pool.get(1), 11);
                        masterList.get(10).get(1).add(temp);
                        pool.set(1,  removeByName(temp.getName(), pool.get(1)));
                        stationList.get(10).addMidStudent();
                    }
                    if (stationList.get(2).getMidMaxWorkers() > stationList.get(2).getTotalMid() && pool.get(1).size() != 0) { // fill hearth
                        Student temp = randomChooser(pool.get(1), 3);
                        masterList.get(2).get(1).add(temp);
                        pool.set(1,removeByName(temp.getName(), pool.get(1)) ) ;
                        stationList.get(2).addMidStudent();
                    }
                    if (stationList.get(3).getMidMaxWorkers() > stationList.get(3).getTotalMid() && pool.get(1).size() != 0) { // fill salads
                        Student temp = randomChooser(pool.get(1), 4);
                        masterList.get(3).get(1).add(temp);
                        pool.set(1,removeByName(temp.getName(), pool.get(1)) ) ;
                        stationList.get(3).addMidStudent();
                    }
                    if (stationList.get(4).getMidMaxWorkers() > stationList.get(4).getTotalMid() && pool.get(1).size() != 0) { //fill toast
                        Student temp = randomChooser(pool.get(1), 5);
                        masterList.get(4).get(1).add(temp);
                        pool.set(1,removeByName(temp.getName(), pool.get(1)) ) ;
                        stationList.get(4).addMidStudent();
                    }
                    if (stationList.get(5).getMidMaxWorkers() > stationList.get(5).getTotalMid() && pool.get(1).size() != 0) { //fill mid
                        Student temp = randomChooser(pool.get(1), 6);
                        masterList.get(5).get(1).add(temp);
                        pool.set(1,removeByName(temp.getName(), pool.get(1)) ) ;
                        stationList.get(5).addMidStudent();
                    }
                    if (stationList.get(6).getMidMaxWorkers() > stationList.get(6).getTotalMid() && pool.get(1).size() != 0) { //fill curry
                        Student temp = randomChooser(pool.get(1), 7);
                        masterList.get(6).get(1).add(temp);
                        pool.set(1,removeByName(temp.getName(), pool.get(1)) ) ;
                        stationList.get(6).addMidStudent();
                    }
                    if (stationList.get(7).getMidMaxWorkers() > stationList.get(7).getTotalMid() && pool.get(1).size() != 0) { //fill grange
                        Student temp = randomChooser(pool.get(1), 8);
                        masterList.get(7).get(1).add(temp);
                        pool.set(1,removeByName(temp.getName(), pool.get(1)) ) ;
                        stationList.get(7).addMidStudent();
                    }
                    if (stationList.get(9).getMidMaxWorkers() > stationList.get(9).getTotalMid() && pool.get(1).size() != 0) { //fill dra
                        Student temp = randomChooser(pool.get(1), 10);
                        masterList.get(9).get(1).add(temp);
                        pool.set(1,removeByName(temp.getName(), pool.get(1)) ) ;
                        stationList.get(9).addMidStudent();
                    }
                    if (stationList.get(0).getMidMaxWorkers() > stationList.get(0).getTotalMid() && pool.get(1).size() != 0){  //fill check
                        Student temp = randomChooser(pool.get(1), 1);
                        masterList.get(0).get(1).add(temp);
                        pool.set(1, removeByName(temp.getName(), pool.get(1)));
                        stationList.get(0).addMidStudent();
                    }
                    if(stationList.get(11).getMidMaxWorkers() > stationList.get(11).getTotalMid() && pool.get(1).size() != 0){ //fill jan
                        Student temp = randomChooser(pool.get(1), 12);
                        masterList.get(11).get(1).add(temp);
                        pool.set(1, removeByName(temp.getName(), pool.get(1)));
                        stationList.get(11).addMidStudent();
                    }
                    if((stationList.get(0).getTotalMid() >= stationList.get(0).getMidMaxWorkers()) &&
                            (stationList.get(1).getTotalMid() >= stationList.get(1).getMidMaxWorkers()) &&
                            (stationList.get(2).getTotalMid() >= stationList.get(2).getMidMaxWorkers()) &&
                            (stationList.get(3).getTotalMid() >= stationList.get(3).getMidMaxWorkers()) &&
                            (stationList.get(4).getTotalMid() >= stationList.get(4).getMidMaxWorkers()) &&
                            (stationList.get(5).getTotalMid() >= stationList.get(5).getMidMaxWorkers()) &&
                            (stationList.get(7).getTotalMid() >= stationList.get(7).getMidMaxWorkers()) &&
                            (stationList.get(8).getTotalMid() >= stationList.get(8).getMidMaxWorkers()) &&
                            (stationList.get(9).getTotalMid() >= stationList.get(9).getMidMaxWorkers()) &&
                            (stationList.get(10).getTotalMid() >= stationList.get(10).getMidMaxWorkers()) &&
                            (stationList.get(11).getTotalMid() >= stationList.get(11).getMidMaxWorkers()) && pool.get(1).size() != 0) { //if all stations at max -> go to dish? //TODO: ask ryan what he prefers to happen here
                        Student temp = randomChooser(pool.get(1), 9);
                        masterList.get(8).get(1).add(temp);
                        pool.set(1, removeByName(temp.getName(), pool.get(1)));
                        stationList.get(8).addMidStudent();
                    }

                }
            }

        }

        while(pool.get(2).size() > 0) {
            if (stationList.get(0).getDinnerPeopleNeeded() > stationList.get(0).getTotalDinner() && pool.get(2).size() != 0) {  // fill checker
                Student temp = randomChooser(pool.get(2), 1);
                masterList.get(0).get(2).add(temp);
                pool.set(2,removeByName(temp.getName(), pool.get(2)) ) ;
                stationList.get(0).addDinnerStudent();
            }
            if (stationList.get(1).getDinnerPeopleNeeded() > stationList.get(1).getTotalDinner() && pool.get(2).size() != 0) { // fill peaks
                Student temp = randomChooser(pool.get(2), 2);
                masterList.get(1).get(2).add(temp);
                pool.set(2,removeByName(temp.getName(), pool.get(2)) ) ;
                stationList.get(1).addDinnerStudent();
            }
            if (stationList.get(2).getDinnerPeopleNeeded() > stationList.get(2).getTotalDinner() && pool.get(2).size() != 0) { // fill hearth
                Student temp = randomChooser(pool.get(2), 3);
                masterList.get(2).get(2).add(temp);
                pool.set(2,removeByName(temp.getName(), pool.get(2)) ) ;
                stationList.get(2).addDinnerStudent();
            }
            if (stationList.get(3).getDinnerPeopleNeeded() > stationList.get(3).getTotalDinner() && pool.get(2).size() != 0) { // fill salads
                Student temp = randomChooser(pool.get(2), 4);
                masterList.get(3).get(2).add(temp);
                pool.set(2,removeByName(temp.getName(), pool.get(2)) ) ;
                stationList.get(3).addDinnerStudent();
            }
            if (stationList.get(4).getDinnerPeopleNeeded() > stationList.get(4).getTotalDinner() && pool.get(2).size() != 0) { //fill toast
                Student temp = randomChooser(pool.get(2), 5);
                masterList.get(4).get(2).add(temp);
                pool.set(2,removeByName(temp.getName(), pool.get(2)) ) ;
                stationList.get(4).addDinnerStudent();
            }
            if (stationList.get(5).getDinnerPeopleNeeded() > stationList.get(5).getTotalDinner() && pool.get(2).size() != 0) { //fill mid
                Student temp = randomChooser(pool.get(2), 6);
                masterList.get(5).get(2).add(temp);
                pool.set(2,removeByName(temp.getName(), pool.get(2) )) ;
                stationList.get(5).addDinnerStudent();
            }
            if (stationList.get(6).getDinnerPeopleNeeded() > stationList.get(6).getTotalDinner() && pool.get(2).size() != 0) { //fill curry
                Student temp = randomChooser(pool.get(2), 7);
                masterList.get(6).get(2).add(temp);
                pool.set(2,removeByName(temp.getName(), pool.get(2)) ) ;
                stationList.get(6).addDinnerStudent();
            }
            if (stationList.get(7).getDinnerPeopleNeeded() > stationList.get(7).getTotalDinner() && pool.get(2).size() != 0) { //fill grange
                Student temp = randomChooser(pool.get(2), 8);
                masterList.get(7).get(2).add(temp);
                pool.set(2,removeByName(temp.getName(), pool.get(2)) ) ;
                stationList.get(7).addDinnerStudent();
            }
            if (stationList.get(8).getDinnerPeopleNeeded() > stationList.get(8).getTotalDinner() && pool.get(2).size() != 0) { //fill dish
                Student temp = randomChooser(pool.get(2), 9);
                masterList.get(8).get(2).add(temp);
                pool.set(2,removeByName(temp.getName(), pool.get(2)) ) ;
                stationList.get(8).addDinnerStudent();
            }
            if (stationList.get(10).getDinnerPeopleNeeded() > stationList.get(10).getTotalDinner() && pool.get(2).size() != 0) { //fill cold runner
                Student temp = randomChooser(pool.get(2), 11);
                masterList.get(10).get(2).add(temp);
                pool.set(2,removeByName(temp.getName(), pool.get(2)));
                stationList.get(10).addDinnerStudent();
            }
            if (stationList.get(9).getDinnerPeopleNeeded() > stationList.get(9).getTotalDinner() && pool.get(2).size() != 0){  //fill dra
                Student temp = randomChooser(pool.get(2), 10);
                masterList.get(9).get(2).add(temp);
                pool.set(2, removeByName(temp.getName(), pool.get(2)));
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
                    (stationList.get(11).getTotalDinner() < stationList.get(11).getDinnerPeopleNeeded()) && pool.get(2).size() != 0){   //fill jan if other stations meet minimum (until jan meets its min)
                Student temp = randomChooser(pool.get(2), 12);
                masterList.get(11).get(2).add(temp);
                pool.set(2,removeByName(temp.getName(), pool.get(2)) ) ;
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
                    (stationList.get(11).getTotalDinner() >= stationList.get(11).getDinnerPeopleNeeded()) && pool.get(2).size() != 0){  //if all stations meet minimum requirements, start filling to max
                while(pool.get(2).size() > 0){ //order switched so extras go where help is more needed first

                    if (stationList.get(8).getDinnerMaxWorkers() > stationList.get(8).getTotalDinner() && pool.get(2).size() != 0) {  //fill dish
                        Student temp = randomChooser(pool.get(2), 9);
                        masterList.get(8).get(2).add(temp);
                        pool.set(2,removeByName(temp.getName(), pool.get(2)) ) ;
                        stationList.get(8).addDinnerStudent();
                    }
                    if (stationList.get(1).getDinnerMaxWorkers() > stationList.get(1).getTotalDinner() && pool.get(2).size() != 0) { // fill peaks
                        Student temp = randomChooser(pool.get(2), 2);
                        masterList.get(1).get(2).add(temp);
                        pool.set(2,removeByName(temp.getName(), pool.get(2)) ) ;
                        stationList.get(1).addDinnerStudent();
                    }
                    if (stationList.get(2).getDinnerMaxWorkers() > stationList.get(2).getTotalDinner() && pool.get(2).size() != 0) { // fill hearth
                        Student temp = randomChooser(pool.get(2), 3);
                        masterList.get(2).get(2).add(temp);
                        pool.set(2,removeByName(temp.getName(), pool.get(2)) ) ;
                        stationList.get(2).addDinnerStudent();
                    }
                    if (stationList.get(3).getDinnerMaxWorkers() > stationList.get(3).getTotalDinner() && pool.get(2).size() != 0) { // fill salads
                        Student temp = randomChooser(pool.get(2), 4);
                        masterList.get(3).get(2).add(temp);
                        pool.set(2,removeByName(temp.getName(), pool.get(2)) ) ;
                        stationList.get(3).addDinnerStudent();
                    }
                    if (stationList.get(4).getDinnerMaxWorkers() > stationList.get(4).getTotalDinner() && pool.get(2).size() != 0) { //fill toast
                        Student temp = randomChooser(pool.get(2), 5);
                        masterList.get(4).get(2).add(temp);
                        pool.set(2,removeByName(temp.getName(), pool.get(2)) ) ;
                        stationList.get(4).addDinnerStudent();
                    }
                    if (stationList.get(5).getDinnerMaxWorkers() > stationList.get(5).getTotalDinner() && pool.get(2).size() != 0) { //fill mid
                        Student temp = randomChooser(pool.get(2), 6);
                        masterList.get(5).get(2).add(temp);
                        pool.set(2,removeByName(temp.getName(), pool.get(2)) ) ;
                        stationList.get(5).addDinnerStudent();
                    }
                    if (stationList.get(6).getDinnerMaxWorkers() > stationList.get(6).getTotalDinner() && pool.get(2).size() != 0) { //fill curry
                        Student temp = randomChooser(pool.get(2), 7);
                        masterList.get(6).get(2).add(temp);
                        pool.set(2,removeByName(temp.getName(), pool.get(2)) ) ;
                        stationList.get(6).addDinnerStudent();
                    }
                    if (stationList.get(7).getDinnerMaxWorkers() > stationList.get(7).getTotalDinner() && pool.get(2).size() != 0) { //fill grange
                        Student temp = randomChooser(pool.get(2), 8);
                        masterList.get(7).get(2).add(temp);
                        pool.set(2,removeByName(temp.getName(), pool.get(2)) ) ;
                        stationList.get(7).addDinnerStudent();
                    }
                    if (stationList.get(9).getDinnerMaxWorkers() > stationList.get(9).getTotalDinner() && pool.get(2).size() != 0) { //fill dra
                        Student temp = randomChooser(pool.get(2), 10);
                        masterList.get(9).get(2).add(temp);
                        pool.set(2,removeByName(temp.getName(), pool.get(2)) ) ;
                        stationList.get(9).addDinnerStudent();
                    }
                    if (stationList.get(0).getDinnerMaxWorkers() > stationList.get(0).getTotalDinner() && pool.get(2).size() != 0){  //fill check
                        Student temp = randomChooser(pool.get(2), 1);
                        masterList.get(0).get(2).add(temp);
                        pool.set(2, removeByName(temp.getName(), pool.get(2)));
                        stationList.get(0).addDinnerStudent();
                    }
                    if (stationList.get(10).getDinnerMaxWorkers() > stationList.get(10).getTotalDinner() && pool.get(2).size() != 0){ //fill cold runner
                        Student temp = randomChooser(pool.get(2), 11);
                        masterList.get(10).get(2).add(temp);
                        pool.set(2, removeByName(temp.getName(), pool.get(2)));
                        stationList.get(10).addDinnerStudent();
                    }
                    if(stationList.get(11).getDinnerMaxWorkers() > stationList.get(11).getTotalDinner() && pool.get(2).size() != 0){
                        Student temp = randomChooser(pool.get(2), 12);
                        masterList.get(11).get(2).add(temp);
                        pool.set(2, removeByName(temp.getName(), pool.get(2)));
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
                            (stationList.get(11).getTotalDinner() >= stationList.get(11).getDinnerMaxWorkers()) && pool.get(2).size() != 0) { //if all stations at max -> go to dish? //TODO: ask ryan what he prefers to happen here
                        Student temp = randomChooser(pool.get(2), 9);
                        masterList.get(8).get(2).add(temp);
                        pool.set(2, removeByName(temp.getName(), pool.get(2)));
                        stationList.get(8).addDinnerStudent();
                    }
                }
            }

        }
        return masterList;

    }

    private Student randomChooser(List<Student> options, int station){
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

            if(countWeight >= r){
                if( station == 1){
                    student.workCheck();
                    return student;
                }
                if( station == 2){
                    student.workPeaks();
                    return student;
                }
                if( station == 3){
                    student.workHearth();
                    return student;
                }
                if( station == 4){
                    student.workSalads();
                    return student;
                }
                if( station == 5){
                    student.workToast();
                    return student;
                }
                if( station == 6){
                    student.workMid();
                    return student;
                }
                if( station == 7){
                    student.workCurry();
                    return student;
                }
                if( station == 8) {
                    student.workGrange();
                    return student;
                }
                if( station == 9) {
                    student.workDish();
                    return student;
                }
                if( station == 10){
                    student.workDra();
                    return student;
                }
                if( station == 11){
                    student.workCold();
                    return student;
                }
                if( station == 12){
                    student.workJan();
                    return student;
                }

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
}
