import java.util.List;

public class Student {

    private List<Object> schedule;
    private Boolean workSunday = false;
    private Boolean workMonday = false;
    private Boolean workTuesday = false;
    private Boolean workWednesday = false;
    private Boolean workThursday = false;
    private Boolean workFriday = false;
    private Boolean workSaturday = false;

    private double checkWeight;
    private double peaksWeight;
    private double saladsWeight;
    private double hearthWeight;
    private double toastWeight;
    private double midWeight;
    private double curryWeight;
    private double grangeWeight;
    private double dishWeight;
    private double draWeight;
    private double janWeight;
    private double coldWeight;



    private String name;

    public Student(String name, List<Object> schedule){
        this.schedule = schedule;
        this.name = name;
        this.setWorkDays();
        while(this.schedule.size() <= 14){
            this.schedule.add(null);

        }
        this.checkWeight = 1.0;
        this.peaksWeight = 1.0;
        this.saladsWeight = 1.0;
        this.hearthWeight = 1.0;
        this.toastWeight = 1.0;
        this.midWeight = 1.0;
        this.curryWeight = 1.0;
        this.grangeWeight = 1.0;
        this.dishWeight = 1.0;
        this.draWeight = 1.0;
        this.janWeight = 1.0;
    }

    public List<Object> getSchedule(){
        return this.schedule;
    }
    public void printSchedule() {
        System.out.println(this.schedule);
    }
    public void setSchedule(List<Object> schedule) {this.schedule = schedule;}

    private void setWorkDays(){
        for(int i = 1; i < this.schedule.size(); i+=2){
            if(this.schedule.get(i).toString().compareTo("") != 0){
                if(i == 1) this.workSunday = true;
                if(i == 3) this.workMonday = true;
                if(i == 5) this.workTuesday = true;
                if(i == 7) this.workWednesday = true;
                if(i == 9) this.workThursday = true;
                if(i == 11) this.workFriday = true;
                if(i == 13) this.workSaturday = true;
            }
        }
    }

    public String checkShift(int indexOfDay){
        String message;
        if(schedule.get(indexOfDay) == null || schedule.get(indexOfDay).toString().compareTo("") == 0){
            message = "no shift today";
        }
        else if(schedule.get(indexOfDay).toString().endsWith("am")) message = "morning shift";
        else if(schedule.get(indexOfDay).toString().endsWith("pm")) message = "pm shift";
        else if(schedule.get(indexOfDay).toString().compareTo("CL") == 0) message = "CL";
        else message = "something went wrong";

        return message;
    }
    /*
        todo: So I need to remember to handle certain cases.
            Issue 1: times that are 6:30
            Issue 2: finding which shift a time applies to

           ( 6:30 7 8 9) (10 11 12 1 2) (3 4 5 6 7 8 9 Cl)

           (0)(1 , 2) (3, 4) (5, 6) (7, 8) (9, 10) (11, 12) (13, 14)

     */







    public void workCheck(){
        this.setCheckWeight(this.getCheckWeight() - .1);
        this.setPeaksWeight(this.getPeaksWeight() + .025);
        this.setHearthWeight(this.getHearthWeight() + .025);
        this.setSaladsWeight(this.getSaladsWeight() + .025);
        this.setToastWeight(this.getToastWeight() + .025);
        this.setMidWeight(this.getMidWeight() + .025);
        this.setCurryWeight(this.getCurryWeight() + .025);
        this.setGrangeWeight(this.getGrangeWeight() + .025);
        this.setDishWeight(this.getDishWeight() + .025);
        this.setJanWeight(this.getJanWeight() + .025);
        this.setDraWeight(this.getDraWeight() + .025);
        this.setColdWeight(this.getColdWeight() + .025);
    }
    public void workPeaks(){
        this.setCheckWeight(this.getCheckWeight() + .025);
        this.setPeaksWeight(this.getPeaksWeight() - .1);
        this.setHearthWeight(this.getHearthWeight() + .025);
        this.setSaladsWeight(this.getSaladsWeight() + .025);
        this.setToastWeight(this.getToastWeight() + .025);
        this.setMidWeight(this.getMidWeight() + .025);
        this.setCurryWeight(this.getCurryWeight() + .025);
        this.setGrangeWeight(this.getGrangeWeight() + .025);
        this.setDishWeight(this.getDishWeight() + .025);
        this.setJanWeight(this.getJanWeight() + .025);
        this.setDraWeight(this.getDraWeight() + .025);
        this.setColdWeight(this.getColdWeight() + .025);
    }
    public void workHearth(){
        this.setCheckWeight(this.getCheckWeight() + .025);
        this.setPeaksWeight(this.getPeaksWeight() + .025);
        this.setHearthWeight(this.getHearthWeight() - .1);
        this.setSaladsWeight(this.getSaladsWeight() + .025);
        this.setToastWeight(this.getToastWeight() + .025);
        this.setMidWeight(this.getMidWeight() + .025);
        this.setCurryWeight(this.getCurryWeight() + .025);
        this.setGrangeWeight(this.getGrangeWeight() + .025);
        this.setDishWeight(this.getDishWeight() + .025);
        this.setJanWeight(this.getJanWeight() + .025);
        this.setDraWeight(this.getDraWeight() + .025);
        this.setColdWeight(this.getColdWeight() + .025);
    }
    public void workSalads(){
        this.setCheckWeight(this.getCheckWeight() + .025);
        this.setPeaksWeight(this.getPeaksWeight() + .025);
        this.setHearthWeight(this.getHearthWeight() + .025);
        this.setSaladsWeight(this.getSaladsWeight() - .1);
        this.setToastWeight(this.getToastWeight() + .025);
        this.setMidWeight(this.getMidWeight() + .025);
        this.setCurryWeight(this.getCurryWeight() + .025);
        this.setGrangeWeight(this.getGrangeWeight() + .025);
        this.setDishWeight(this.getDishWeight() + .025);
        this.setJanWeight(this.getJanWeight() + .025);
        this.setDraWeight(this.getDraWeight() + .025);
        this.setColdWeight(this.getColdWeight() + .025);
    }
    public void workToast(){
        this.setCheckWeight(this.getCheckWeight() + .025);
        this.setPeaksWeight(this.getPeaksWeight() + .025);
        this.setHearthWeight(this.getHearthWeight() + .025);
        this.setSaladsWeight(this.getSaladsWeight() + .025);
        this.setToastWeight(this.getToastWeight() - .1);
        this.setMidWeight(this.getMidWeight() + .025);
        this.setCurryWeight(this.getCurryWeight() + .025);
        this.setGrangeWeight(this.getGrangeWeight() + .025);
        this.setDishWeight(this.getDishWeight() + .025);
        this.setJanWeight(this.getJanWeight() + .025);
        this.setDraWeight(this.getDraWeight() + .025);
        this.setColdWeight(this.getColdWeight() + .025);
    }
    public void workMid(){
        this.setCheckWeight(this.getCheckWeight() + .025);
        this.setPeaksWeight(this.getPeaksWeight() + .025);
        this.setHearthWeight(this.getHearthWeight() + .025);
        this.setSaladsWeight(this.getSaladsWeight() + .025);
        this.setToastWeight(this.getToastWeight() + .025);
        this.setMidWeight(this.getMidWeight() - .1);
        this.setCurryWeight(this.getCurryWeight() + .025);
        this.setGrangeWeight(this.getGrangeWeight() + .025);
        this.setDishWeight(this.getDishWeight() + .025);
        this.setJanWeight(this.getJanWeight() + .025);
        this.setDraWeight(this.getDraWeight() + .025);
        this.setColdWeight(this.getColdWeight() + .025);
    }
    public void workCurry(){
        this.setCheckWeight(this.getCheckWeight() + .025);
        this.setPeaksWeight(this.getPeaksWeight() + .025);
        this.setHearthWeight(this.getHearthWeight() + .025);
        this.setSaladsWeight(this.getSaladsWeight() + .025);
        this.setToastWeight(this.getToastWeight() + .025);
        this.setMidWeight(this.getMidWeight() + .025);
        this.setCurryWeight(this.getCurryWeight() - .1);
        this.setGrangeWeight(this.getGrangeWeight() + .025);
        this.setDishWeight(this.getDishWeight() + .025);
        this.setJanWeight(this.getJanWeight() + .025);
        this.setDraWeight(this.getDraWeight() + .025);
        this.setColdWeight(this.getColdWeight() + .025);
    }
    public void workGrange(){
        this.setCheckWeight(this.getCheckWeight() + .025);
        this.setPeaksWeight(this.getPeaksWeight() + .025);
        this.setHearthWeight(this.getHearthWeight() + .025);
        this.setSaladsWeight(this.getSaladsWeight() + .025);
        this.setToastWeight(this.getToastWeight() + .025);
        this.setMidWeight(this.getMidWeight() + .025);
        this.setCurryWeight(this.getCurryWeight() + .025);
        this.setGrangeWeight(this.getGrangeWeight() - .1);
        this.setDishWeight(this.getDishWeight() + .025);
        this.setJanWeight(this.getJanWeight() + .025);
        this.setDraWeight(this.getDraWeight() + .025);
        this.setColdWeight(this.getColdWeight() + .025);
    }
    public void workDish(){
        this.setCheckWeight(this.getCheckWeight() + .025);
        this.setPeaksWeight(this.getPeaksWeight() + .025);
        this.setHearthWeight(this.getHearthWeight() + .025);
        this.setSaladsWeight(this.getSaladsWeight() + .025);
        this.setToastWeight(this.getToastWeight() + .025);
        this.setMidWeight(this.getMidWeight() + .025);
        this.setCurryWeight(this.getCurryWeight() + .025);
        this.setGrangeWeight(this.getGrangeWeight() + .025);
        this.setDishWeight(this.getDishWeight() - .1);
        this.setJanWeight(this.getJanWeight() + .025);
        this.setDraWeight(this.getDraWeight() + .025);
        this.setColdWeight(this.getColdWeight() + .025);
    }
    public void workDra(){
        this.setCheckWeight(this.getCheckWeight() + .025);
        this.setPeaksWeight(this.getPeaksWeight() + .025);
        this.setHearthWeight(this.getHearthWeight() + .025);
        this.setSaladsWeight(this.getSaladsWeight() + .025);
        this.setToastWeight(this.getToastWeight() + .025);
        this.setMidWeight(this.getMidWeight() + .025);
        this.setCurryWeight(this.getCurryWeight() + .025);
        this.setGrangeWeight(this.getGrangeWeight() + .025);
        this.setDishWeight(this.getDishWeight() + .025);
        this.setJanWeight(this.getJanWeight() + .025);
        this.setDraWeight(this.getDraWeight() - .1);
        this.setColdWeight(this.getColdWeight() + .025);
    }
    public void workJan(){
        this.setCheckWeight(this.getCheckWeight() + .025);
        this.setPeaksWeight(this.getPeaksWeight() + .025);
        this.setHearthWeight(this.getHearthWeight() + .025);
        this.setSaladsWeight(this.getSaladsWeight() + .025);
        this.setToastWeight(this.getToastWeight() + .025);
        this.setMidWeight(this.getMidWeight() + .025);
        this.setCurryWeight(this.getCurryWeight() + .025);
        this.setGrangeWeight(this.getGrangeWeight() + .025);
        this.setDishWeight(this.getDishWeight() + .025);
        this.setJanWeight(this.getJanWeight() - .1);
        this.setDraWeight(this.getDraWeight() + .025);
        this.setColdWeight(this.getColdWeight() + .025);
    }

    public void workCold(){
        this.setCheckWeight(this.getCheckWeight() + .025);
        this.setPeaksWeight(this.getPeaksWeight() + .025);
        this.setHearthWeight(this.getHearthWeight() + .025);
        this.setSaladsWeight(this.getSaladsWeight() + .025);
        this.setToastWeight(this.getToastWeight() + .025);
        this.setMidWeight(this.getMidWeight() + .025);
        this.setCurryWeight(this.getCurryWeight() + .025);
        this.setGrangeWeight(this.getGrangeWeight() + .025);
        this.setDishWeight(this.getDishWeight() + .025);
        this.setJanWeight(this.getJanWeight() + .025);
        this.setDraWeight(this.getDraWeight() + .025);
        this.setColdWeight(this.getColdWeight() - .1);
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Boolean getWorkSunday() {
        return workSunday;
    }
    public Boolean getWorkMonday() {
        return workMonday;
    }
    public Boolean getWorkTuesday() {
        return workTuesday;
    }
    public Boolean getWorkWednesday() {
        return workWednesday;
    }
    public Boolean getWorkThursday() {
        return workThursday;
    }
    public Boolean getWorkFriday() {
        return workFriday;
    }
    public Boolean getWorkSaturday() {
        return workSaturday;
    }

    public Boolean getWork(int day){
        if (day == 1) {
            return getWorkSunday();
        }
        if (day == 3) {
            return getWorkMonday();
        }
        if (day == 5) {
            return getWorkTuesday();
        }
        if (day == 7) {
            return getWorkWednesday();
        }
        if (day == 9) {
            return getWorkThursday();
        }
        if (day == 11) {
            return getWorkFriday();
        }
        if (day == 13) {
            return getWorkSaturday();
        }
        return false;
    }


    public double getColdWeight() {
        return coldWeight;
    }

    public void setColdWeight(double coldWeight) {
        this.coldWeight = coldWeight;
    }

    public double getCheckWeight() {
        return checkWeight;
    }

    public void setCheckWeight(double checkWeight) {
        this.checkWeight = checkWeight;
    }

    public double getPeaksWeight() {
        return peaksWeight;
    }

    public void setPeaksWeight(double peaksWeight) {
        this.peaksWeight = peaksWeight;
    }

    public double getSaladsWeight() {
        return saladsWeight;
    }

    public void setSaladsWeight(double saladsWeight) {
        this.saladsWeight = saladsWeight;
    }

    public double getHearthWeight() {
        return hearthWeight;
    }

    public void setHearthWeight(double hearthWeight) {
        this.hearthWeight = hearthWeight;
    }

    public double getToastWeight() {
        return toastWeight;
    }

    public void setToastWeight(double toastWeight) {
        this.toastWeight = toastWeight;
    }

    public double getMidWeight() {
        return midWeight;
    }

    public void setMidWeight(double midWeight) {
        this.midWeight = midWeight;
    }

    public double getCurryWeight() {
        return curryWeight;
    }

    public void setCurryWeight(double curryWeight) {
        this.curryWeight = curryWeight;
    }

    public double getGrangeWeight() {
        return grangeWeight;
    }

    public void setGrangeWeight(double grangeWeight) {
        this.grangeWeight = grangeWeight;
    }

    public double getDishWeight() {
        return dishWeight;
    }

    public void setDishWeight(double dishWeight) {
        this.dishWeight = dishWeight;
    }
    public double getDraWeight() {
        return draWeight;
    }

    public void setDraWeight(double draWeight) {
        this.draWeight = draWeight;
    }

    public double getJanWeight() {
        return janWeight;
    }

    public void setJanWeight(double janWeight) {
        this.janWeight = janWeight;
    }

}
