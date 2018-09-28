public class Station {

    private int morningPeopleNeeded;



    private int midPeopleNeeded;
    private int dinnerPeopleNeeded;
    private int morningFullTime;
    private int midFullTime;
    private int dinnerFullTime;
    private int morningStudents;
    private int midStudents;
    private int dinnerStudents;
    private int morningMaxWorkers;
    private int midMaxWorkers;


    private int dinnerMaxWorkers;


    /*
        UI -> day -> usual variables on day <Option to change>

     */
    public Station(int morn, int mid, int din, int maxmorn, int maxmid, int maxdin){
        this.morningPeopleNeeded = morn;
        this.midPeopleNeeded = mid;
        this.dinnerPeopleNeeded = din;
        this.morningMaxWorkers = maxmorn;
        this.midMaxWorkers = maxmid;
        this.dinnerMaxWorkers = maxdin;
        this.morningFullTime = 0;
        this.midFullTime = 0;
        this.dinnerFullTime = 0;
        this.morningStudents = 0;
        this.midStudents = 0;
        this.dinnerStudents = 0;
    }

    public void addDinnerStudent(){this.dinnerStudents++;}

    public void addMidStudent(){ this.midStudents++;}

    public void addMorningStudent(){ this.morningStudents++;}

    public int getTotalMorning(){ return morningFullTime + morningStudents;}

    public int getTotalMid(){ return midFullTime + midStudents;}

    public int getTotalDinner(){ return dinnerFullTime + dinnerStudents;}

    public int getMorningPeopleNeeded() {
        return morningPeopleNeeded;
    }

    public void setMorningPeopleNeeded(int morningPeopleNeeded) {
        this.morningPeopleNeeded = morningPeopleNeeded;
    }

    public int getMidPeopleNeeded() {
        return midPeopleNeeded;
    }

    public void setMidPeopleNeeded(int midPeopleNeeded) {
        this.midPeopleNeeded = midPeopleNeeded;
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

    public int getMidFullTime() {
        return midFullTime;
    }

    public void setMidFullTime(int midFullTime) {
        this.midFullTime = midFullTime;
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

    public int getMidStudents() {
        return midStudents;
    }

    public void setMidStudents(int midStudents) {
        this.midStudents = midStudents;
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

    public int getMidMaxWorkers() {
        return midMaxWorkers;
    }

    public void setMidMaxWorkers(int midMaxWorkers) {
        this.midMaxWorkers = midMaxWorkers;
    }

    public int getDinnerMaxWorkers() {
        return dinnerMaxWorkers;
    }

    public void setDinnerMaxWorkers(int dinnerMaxWorkers) {
        this.dinnerMaxWorkers = dinnerMaxWorkers;
    }


}
