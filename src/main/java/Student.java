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
    private double floatWeight;

    private boolean isLead;
    private boolean multipleShifts;




    private String name;

    public Student(String name, List<Object> schedule, Boolean lead){
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
        this.coldWeight = 1.0;
        this.floatWeight = 0;
        this.isLead = lead;
        this.multipleShifts = false;
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


    public boolean getLead(){ return this.isLead;}

    public boolean getFloat(){
        if(getFloatWeight() > 0) return true;
        else return false;
    }



    public String getName() {
        return name;
    }

    private Boolean getWorkSunday() {
        return workSunday;
    }
    private Boolean getWorkMonday() {
        return workMonday;
    }
    private Boolean getWorkTuesday() {
        return workTuesday;
    }
    private Boolean getWorkWednesday() {
        return workWednesday;
    }
    private Boolean getWorkThursday() {
        return workThursday;
    }
    private Boolean getWorkFriday() {
        return workFriday;
    }
    private Boolean getWorkSaturday() {
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

    public void setMultipleShifts(Boolean multipleShifts){this.multipleShifts = multipleShifts; }

    public Boolean getMultipleShifts() {return multipleShifts;}

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

    public double getFloatWeight() {
        return floatWeight;
    }

    public void setFloatWeight(double floatWeight) {
        this.floatWeight = floatWeight;
    }
}
