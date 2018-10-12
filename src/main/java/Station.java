public class Station {

    private int morningPeopleNeeded;
    private int earlyMidPeopleNeeded;
    private int lateMidPeopleNeeded;
    private int dinnerPeopleNeeded;
    private int morningFullTime;
    private int earlyMidFullTime;
    private int lateMidFullTime;
    private int dinnerFullTime;
    private int morningStudents;
    private int earlyMidStudents;
    private int lateMidStudents;
    private int dinnerStudents;
    private int morningMaxWorkers;


    private int earlyMidMaxWorkers;
    private int lateMidMaxWorkers;
    private int dinnerMaxWorkers;


    /*
        UI -> day -> usual variables on day <Option to change>

     */
    public Station(int morn, int mid, int lmid, int din, int maxmorn, int maxmid, int maxlmid, int maxdin){
        this.morningPeopleNeeded = morn;
        this.earlyMidPeopleNeeded = mid;
        this.lateMidPeopleNeeded = lmid;
        this.dinnerPeopleNeeded = din;
        this.morningMaxWorkers = maxmorn;
        this.earlyMidMaxWorkers = maxmid;
        this.lateMidMaxWorkers = maxlmid;
        this.dinnerMaxWorkers = maxdin;
        this.morningFullTime = 0;
        this.earlyMidFullTime = 0;
        this.lateMidFullTime = 0;
        this.dinnerFullTime = 0;
        this.morningStudents = 0;
        this.earlyMidStudents = 0;
        this.lateMidStudents = 0;
        this.dinnerStudents = 0;
    }

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



}
