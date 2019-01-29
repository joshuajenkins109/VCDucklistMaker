public class Station {

    private int morningPeopleNeeded;
    private int earlyMidPeopleNeeded;
    private int lateMidPeopleNeeded;
    private int dinnerPeopleNeeded;
    private int morningFullTime;
    private int earlyMidFullTime;
    private int lateMidFullTime;
    private int dinnerFullTime;
    private int morningStudents;    //TODO: refactor for consistency among variable names
    private int earlyMidStudents;
    private int lateMidStudents;
    private int dinnerStudents;
    private int morningMaxWorkers;


    private int earlyMidMaxWorkers;
    private int lateMidMaxWorkers;
    private int dinnerMaxWorkers;

    private int morningLeads;
    private int earlyLeads;
    private int lateLeads;
    private int dinnerLeads;

    private int assignedMorningLeads;
    private int assignedEarlyLeads;
    private int assignedLateLeads;
    private int assignedDinnerLeads;


    /*
        UI -> day -> usual variables on day <Option to change>

     */
    public Station(int morn, int mid, int lmid, int din, int maxmorn, int maxmid, int maxlmid, int maxdin, int morningLeads, int earlyLeads, int lateLeads, int dinnerLeads){
        this.morningPeopleNeeded = morn;
        this.earlyMidPeopleNeeded = mid;
        this.lateMidPeopleNeeded = lmid;
        this.dinnerPeopleNeeded = din;
        this.morningMaxWorkers = maxmorn;
        this.earlyMidMaxWorkers = maxmid;
        this.lateMidMaxWorkers = maxlmid;
        this.dinnerMaxWorkers = maxdin;
        this.morningLeads = morningLeads;
        this.earlyLeads = earlyLeads;
        this.lateLeads = lateLeads;
        this.dinnerLeads = dinnerLeads;
        this.morningFullTime = 0;
        this.earlyMidFullTime = 0;
        this.lateMidFullTime = 0;
        this.dinnerFullTime = 0;
        this.morningStudents = 0;
        this.earlyMidStudents = 0;
        this.lateMidStudents = 0;
        this.dinnerStudents = 0;
        this.assignedMorningLeads = 0;
        this.assignedEarlyLeads = 0;
        this.assignedLateLeads = 0;
        this.assignedDinnerLeads = 0;
    }

    public void addMorningLead(){ this.assignedMorningLeads++;}

    public void addEarlyLead(){ this.assignedEarlyLeads++;}

    public void addLateLead(){ this.assignedLateLeads++;}

    public void addDinnerLead(){ this.assignedDinnerLeads++;}

    public void addDinnerStudent(){this.dinnerStudents++;}

    public void addEarlyMidStudent(){ this.earlyMidStudents++;}

    public void addLateMidStudent() { this.lateMidStudents++;}

    public void addMorningStudent(){ this.morningStudents++;}

    public int getTotalMorning(){ return morningFullTime + morningStudents;}

    public int getTotalMid(){ return earlyMidFullTime + earlyMidStudents + lateMidFullTime + lateMidStudents;}

    public int getEarlyMid() { return earlyMidFullTime + earlyMidStudents;}

    public int getLateMid() { return lateMidFullTime + lateMidStudents;}

    public int getTotalDinner(){ return dinnerFullTime + dinnerStudents;}

    public int getMorningPeopleNeeded() {
        return morningPeopleNeeded;
    }

    public void setMorningPeopleNeeded(int morningPeopleNeeded) {
        this.morningPeopleNeeded = morningPeopleNeeded;
    }

    public int getEarlyMidPeopleNeeded() {
        return earlyMidPeopleNeeded;
    }

    public void setEarlyMidPeopleNeeded(int earlyMidPeopleNeeded) {
        this.earlyMidPeopleNeeded = earlyMidPeopleNeeded;
    }

    public int getDinnerPeopleNeeded() {
        return dinnerPeopleNeeded;
    }

    public void setDinnerPeopleNeeded(int dinnerPeopleNeeded) {
        this.dinnerPeopleNeeded = dinnerPeopleNeeded;
    }

    public int getMorningFullTime() {
        return morningFullTime;
    }

    public void setMorningFullTime(int morningFullTime) {
        this.morningFullTime = morningFullTime;
    }

    public int getDinnerFullTime() {
        return dinnerFullTime;
    }

    public void setDinnerFullTime(int dinnerFullTime) {
        this.dinnerFullTime = dinnerFullTime;
    }

    public int getMorningStudents() {
        return morningStudents;
    }

    public void setMorningStudents(int morningStudents) {
        this.morningStudents = morningStudents;
    }

    public int getDinnerStudents() {
        return dinnerStudents;
    }

    public void setDinnerStudents(int dinnerStudents) {
        this.dinnerStudents = dinnerStudents;
    }

    public int getMorningMaxWorkers() {
        return morningMaxWorkers;
    }

    public void setMorningMaxWorkers(int morningMaxWorkers) {
        this.morningMaxWorkers = morningMaxWorkers;
    }

    public int getDinnerMaxWorkers() {
        return dinnerMaxWorkers;
    }

    public void setDinnerMaxWorkers(int dinnerMaxWorkers) {
        this.dinnerMaxWorkers = dinnerMaxWorkers;
    }

    public int getLateMidPeopleNeeded() {
        return lateMidPeopleNeeded;
    }

    public void setLateMidPeopleNeeded(int lateMidPeopleNeeded) {
        this.lateMidPeopleNeeded = lateMidPeopleNeeded;
    }

    public int getEarlyMidFullTime() {
        return earlyMidFullTime;
    }

    public void setEarlyMidFullTime(int earlyMidFullTime) {
        this.earlyMidFullTime = earlyMidFullTime;
    }

    public int getLateMidFullTime() {
        return lateMidFullTime;
    }

    public void setLateMidFullTime(int lateMidFullTime) {
        this.lateMidFullTime = lateMidFullTime;
    }

    public int getEarlyMidStudents() {
        return earlyMidStudents;
    }

    public void setEarlyMidStudents(int earlyMidStudents) {
        this.earlyMidStudents = earlyMidStudents;
    }

    public int getLateMidStudents() {
        return lateMidStudents;
    }

    public void setLateMidStudents(int lateMidStudents) {
        this.lateMidStudents = lateMidStudents;
    }

    public int getEarlyMidMaxWorkers() {
        return earlyMidMaxWorkers;
    }

    public void setEarlyMidMaxWorkers(int earlyMidMaxWorkers) {
        this.earlyMidMaxWorkers = earlyMidMaxWorkers;
    }

    public int getLateMidMaxWorkers() {
        return lateMidMaxWorkers;
    }

    public void setLateMidMaxWorkers(int lateMidMaxWorkers) {
        this.lateMidMaxWorkers = lateMidMaxWorkers;
    }

    public int getMorningLeads() {
        return morningLeads;
    }

    public void setMorningLeads(int morningLeads) {
        this.morningLeads = morningLeads;
    }

    public int getEarlyLeads() {
        return earlyLeads;
    }

    public void setEarlyLeads(int earlyLeads) {
        this.earlyLeads = earlyLeads;
    }

    public int getLateLeads() {
        return lateLeads;
    }

    public void setLateLeads(int lateLeads) {
        this.lateLeads = lateLeads;
    }

    public int getDinnerLeads() {
        return dinnerLeads;
    }

    public void setDinnerLeads(int dinnerLeads) {
        this.dinnerLeads = dinnerLeads;
    }

    public int getAssignedMorningLeads() {
        return assignedMorningLeads;
    }

    public void setAssignedMorningLeads(int assignedMorningLeads) {
        this.assignedMorningLeads = assignedMorningLeads;
    }

    public int getAssignedEarlyLeads() {
        return assignedEarlyLeads;
    }

    public void setAssignedEarlyLeads(int assignedEarlyLeads) {
        this.assignedEarlyLeads = assignedEarlyLeads;
    }

    public int getAssignedLateLeads() {
        return assignedLateLeads;
    }

    public void setAssignedLateLeads(int assignedLateLeads) {
        this.assignedLateLeads = assignedLateLeads;
    }

    public int getAssignedDinnerLeads() {
        return assignedDinnerLeads;
    }

    public void setAssignedDinnerLeads(int assignedDinnerLeads) {
        this.assignedDinnerLeads = assignedDinnerLeads;
    }
}
