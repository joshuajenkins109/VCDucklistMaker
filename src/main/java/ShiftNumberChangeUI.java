import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.List;

public class ShiftNumberChangeUI {
    private JPanel shiftNumberChangeView;
    private JTextField PeaksMorningMin;
    private JTextField HearthMorningMin;
    private JTextField SaladsMorningMin;
    private JTextField ToastMorningMin;
    private JTextField MiddieMorningMin;
    private JTextField CurryMorningMin;
    private JTextField GrangeMorningMin;
    private JTextField DishMorningMin;
    private JTextField DRAMorningMin;
    private JTextField CRMorningMin;
    private JTextField JanitorMorningMin;
    private JTextField PeaksEarlyMin;
    private JTextField HearthEarlyMin;
    private JTextField SaladsEarlyMin;
    private JTextField ToastEarlyMin;
    private JTextField MiddieEarlyMin;
    private JTextField CurryEarlyMin;
    private JTextField GrangeEarlyMin;
    private JTextField DishEarlyMin;
    private JTextField DRAEarlyMin;
    private JTextField PeaksLateMin;
    private JTextField HearthLateMin;
    private JTextField SaladsLateMin;
    private JTextField ToastLateMin;
    private JTextField MiddieLateMin;
    private JTextField CurryLateMin;
    private JTextField GrangeLateMin;
    private JTextField DishLateMin;
    private JTextField DRALateMin;
    private JTextField CREarlyMin;
    private JTextField JanitorEarlyMin;
    private JTextField CRLateMin;
    private JTextField PeaksDinnerMin;
    private JTextField HearthDinnerMin;
    private JTextField SaladsDinnerMin;
    private JTextField ToastDinnerMin;
    private JTextField MiddieDinnerMin;
    private JTextField CurryDinnerMin;
    private JTextField GrangeDinnerMin;
    private JTextField DishDinnerMin;
    private JTextField DRADinnerMin;
    private JTextField JanitorLateMin;
    private JTextField CRDinnerMin;
    private JTextField JanitorDinnerMin;
    private JTextField PeaksMorningMax;
    private JTextField HearthMorningMax;
    private JTextField SaladsMorningMax;
    private JTextField ToastMorningMax;
    private JTextField MiddieMorningMax;
    private JTextField CurryMorningMax;
    private JTextField GrangeMorningMax;
    private JTextField DishMorningMax;
    private JTextField DRAMorningMax;
    private JTextField CRMorningMax;
    private JTextField JanitorMorningMax;
    private JTextField CheckerEarlyMax;
    private JTextField PeaksEarlyMax;
    private JTextField HearthEarlyMax;
    private JTextField SaladsEarlyMax;
    private JTextField ToastEarlyMax;
    private JTextField MiddieEarlyMax;
    private JTextField CurryEarlyMax;
    private JTextField GrangeEarlyMax;
    private JTextField DishEarlyMax;
    private JTextField DRAEarlyMax;
    private JTextField CREarlyMax;
    private JTextField JanitorEarlyMax;
    private JTextField CheckerLateMax;
    private JTextField PeaksLateMax;
    private JTextField HearthLateMax;
    private JTextField SaladsLateMax;
    private JTextField ToastLateMax;
    private JTextField MiddieLateMax;
    private JTextField CurryLateMax;
    private JTextField GrangeLateMax;
    private JTextField DishLateMax;
    private JTextField DRALateMax;
    private JTextField CRLateMax;
    private JTextField JanitorLateMax;
    private JTextField CheckerDinnerMax;
    private JTextField PeaksDinnerMax;
    private JTextField HearthDinnerMax;
    private JTextField SaladsDinnerMax;
    private JTextField ToastDinnerMax;
    private JTextField MiddieDinnerMax;
    private JTextField CurryDinnerMax;
    private JTextField GrangeDinnerMax;
    private JTextField DishDinnerMax;
    private JTextField DRADinnerMax;
    private JTextField CRDinnerMax;
    private JTextField JanitorDinnerMax;
    private JTextField CheckerMorningLeads;
    private JTextField PeaksMorningLeads;
    private JTextField HearthMorningLeads;
    private JTextField SaladsMorningLeads;
    private JTextField ToastMorningLeads;
    private JTextField MiddieMorningLeads;
    private JTextField CurryMorningLeads;
    private JTextField GrangeMorningLeads;
    private JTextField DishMorningLeads;
    private JTextField DRAMorningLeads;
    private JTextField CRMorningLeads;
    private JTextField JanitorMorningLeads;
    private JTextField CheckerEarlyLeads;
    private JTextField PeaksEarlyLeads;
    private JTextField HearthEarlyLeads;
    private JTextField SaladsEarlyLeads;
    private JTextField ToastEarlyLeads;
    private JTextField MiddieEarlyLeads;
    private JTextField CurryEarlyLeads;
    private JTextField GrangeEarlyLeads;
    private JTextField DishEarlyLeads;
    private JTextField DRAEarlyLeads;
    private JTextField CREarlyLeads;
    private JTextField JanitorEarlyLeads;
    private JTextField CheckerLateLeads;
    private JTextField PeaksLateLeads;
    private JTextField HearthLateLeads;
    private JTextField SaladsLateLeads;
    private JTextField ToastLateLeads;
    private JTextField MiddieLateLeads;
    private JTextField CurryLateLeads;
    private JTextField GrangeLateLeads;
    private JTextField DishLateLeads;
    private JTextField DRALateLeads;
    private JTextField CRLateLeads;
    private JTextField JanitorLateLeads;
    private JTextField CheckerDinnerLeads;
    private JTextField PeaksDinnerLeads;
    private JTextField HearthDinnerLeads;
    private JTextField SaladsDinnerLeads;
    private JTextField ToastDinnerLeads;
    private JTextField MiddieDinnerLeads;
    private JTextField CurryDinnerLeads;
    private JTextField GrangeDinnerLeads;
    private JTextField DishDinnerLeads;
    private JTextField DRADinnerLeads;
    private JTextField CRDinnerLeads;
    private JTextField JanitorDinnerLeads;
    private JTextField CheckerMorningMin;
    private JTextField CheckerEarlyMin;
    private JTextField CheckerLateMin;
    private JTextField CheckerDinnerMin;
    private JTextField CheckerMorningMax;
    private JTextField MorningMinHeader;
    private JPanel JPanel;
    private JTextField CheckerHeader;
    private JTextField PeaksHeader;
    private JTextField HearthHeader;
    private JTextField SaladsHeader;
    private JTextField ToastHeader;
    private JTextField MiddieHeader;
    private JTextField CurryHeader;
    private JTextField GrangeHeader;
    private JTextField DishHeader;
    private JTextField DRAHeader;
    private JTextField ColdRunnerHeader;
    private JTextField JanitorHeader;
    private JTextField EarlyMidMinHeader;
    private JTextField LateMidMinHeader;
    private JTextField DinnerMinHeader;
    private JTextField MorningMaxHeader;
    private JTextField EarlyMidMaxHeader;
    private JTextField LateMidMaxHeader;
    private JTextField DinnerMaxHeader;
    private JTextField MorningLeadsHeader;
    private JTextField EarlyMidLeadsHeader;
    private JTextField LateMidLeadsHeader;
    private JTextField DinnerLeadsHeader;
    private JButton SaveRunButton;
    private JButton RunButton;
    private JTextField GreetingHeader;

    private String sundayRange = "ShiftNumbers!B2:M13";
    private String mondayRange = "ShiftNumbers!B14:M25";
    private String tuesdayRange = "ShiftNumbers!B26:M37";
    private String wednesdayRange = "ShiftNumbers!B38:M49";
    private String thursdayRange = "ShiftNumbers!B50:M61";
    private String fridayRange = "ShiftNumbers!B62:M73";
    private String saturdayRange = "ShiftNumbers!B74:M85";

    private int action = 0;
    private int day = 0;


    public int getDay() {
        return day;
    }
    public void setDay(int day) {
        this.day = day;
    }

    public String getSundayRange(){return this.sundayRange;}
    public String getMondayRange(){return this.mondayRange;}
    public String getTuesdayRange(){return this.tuesdayRange;}
    public String getWednesdayRange(){return this.wednesdayRange;}
    public String getThursdayRange(){return this.thursdayRange;}
    public String getFridayRange(){return this.fridayRange;}
    public String getSaturdayRange(){return this.saturdayRange;}

    public int getAction() {
        return action;
    }
    public void setAction(int action) {
        this.action = action;
    }

    public ShiftNumberChangeUI(){
        SaveRunButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setAction(1);
            }
        });
        RunButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setAction(2);
            }
        });
    }

    public JPanel getShiftNumberChangeView(){
        return shiftNumberChangeView;
    }

    public void fillWithDefaults() throws IOException, GeneralSecurityException {
        SheetsCommunicator sheets = new SheetsCommunicator();
        List<List<Object>> values = new ArrayList<List<Object>>();
        if (day == 1) {  values = sheets.getShiftDefaults(sundayRange); }
        else if (day == 3) { values = sheets.getShiftDefaults(mondayRange); }
        else if (day == 5) {  values = sheets.getShiftDefaults(tuesdayRange); }
        else if (day == 7) { values = sheets.getShiftDefaults(wednesdayRange); }
        else if (day == 9) { values = sheets.getShiftDefaults(thursdayRange); }
        else if (day == 11) {  values = sheets.getShiftDefaults(fridayRange); }
        else if (day == 13) {  values = sheets.getShiftDefaults(saturdayRange); }



        CheckerMorningMin.setText((String)values.get(0).get(0));
        CheckerEarlyMin.setText((String)values.get(0).get(1));
        CheckerLateMin.setText((String)values.get(0).get(2));
        CheckerDinnerMin.setText((String)values.get(0).get(3));
        CheckerMorningMax.setText((String)values.get(0).get(4));
        CheckerEarlyMax.setText((String)values.get(0).get(5));
        CheckerLateMax.setText((String)values.get(0).get(6));
        CheckerDinnerMax.setText((String)values.get(0).get(7));
        CheckerMorningLeads.setText((String)values.get(0).get(8));
        CheckerEarlyLeads.setText((String)values.get(0).get(9));
        CheckerLateLeads.setText((String)values.get(0).get(10));
        CheckerDinnerLeads.setText((String)values.get(0).get(11));

        PeaksMorningMin.setText((String)values.get(1).get(0));
        PeaksEarlyMin.setText((String)values.get(1).get(1));
        PeaksLateMin.setText((String)values.get(1).get(2));
        PeaksDinnerMin.setText((String)values.get(1).get(3));
        PeaksMorningMax.setText((String)values.get(1).get(4));
        PeaksEarlyMax.setText((String)values.get(1).get(5));
        PeaksLateMax.setText((String)values.get(1).get(6));
        PeaksDinnerMax.setText((String)values.get(1).get(7));
        PeaksMorningLeads.setText((String)values.get(1).get(8));
        PeaksEarlyLeads.setText((String)values.get(1).get(9));
        PeaksLateLeads.setText((String)values.get(1).get(10));
        PeaksDinnerLeads.setText((String)values.get(1).get(11));

        HearthMorningMin.setText((String)values.get(2).get(0));
        HearthEarlyMin.setText((String)values.get(2).get(1));
        HearthLateMin.setText((String)values.get(2).get(2));
        HearthDinnerMin.setText((String)values.get(2).get(3));
        HearthMorningMax.setText((String)values.get(2).get(4));
        HearthEarlyMax.setText((String)values.get(2).get(5));
        HearthLateMax.setText((String)values.get(2).get(6));
        HearthDinnerMax.setText((String)values.get(2).get(7));
        HearthMorningLeads.setText((String)values.get(2).get(8));
        HearthEarlyLeads.setText((String)values.get(2).get(9));
        HearthLateLeads.setText((String)values.get(2).get(10));
        HearthDinnerLeads.setText((String)values.get(2).get(11));

        SaladsMorningMin.setText((String)values.get(3).get(0));
        SaladsEarlyMin.setText((String)values.get(3).get(1));
        SaladsLateMin.setText((String)values.get(3).get(2));
        SaladsDinnerMin.setText((String)values.get(3).get(3));
        SaladsMorningMax.setText((String)values.get(3).get(4));
        SaladsEarlyMax.setText((String)values.get(3).get(5));
        SaladsLateMax.setText((String)values.get(3).get(6));
        SaladsDinnerMax.setText((String)values.get(3).get(7));
        SaladsMorningLeads.setText((String)values.get(3).get(8));
        SaladsEarlyLeads.setText((String)values.get(3).get(9));
        SaladsLateLeads.setText((String)values.get(3).get(10));
        SaladsDinnerLeads.setText((String)values.get(3).get(11));

        ToastMorningMin.setText((String)values.get(4).get(0));
        ToastEarlyMin.setText((String)values.get(4).get(1));
        ToastLateMin.setText((String)values.get(4).get(2));
        ToastDinnerMin.setText((String)values.get(4).get(3));
        ToastMorningMax.setText((String)values.get(4).get(4));
        ToastEarlyMax.setText((String)values.get(4).get(5));
        ToastLateMax.setText((String)values.get(4).get(6));
        ToastDinnerMax.setText((String)values.get(4).get(7));
        ToastMorningLeads.setText((String)values.get(4).get(8));
        ToastEarlyLeads.setText((String)values.get(4).get(9));
        ToastLateLeads.setText((String)values.get(4).get(10));
        ToastDinnerLeads.setText((String)values.get(4).get(11));

        MiddieMorningMin.setText((String)values.get(5).get(0));
        MiddieEarlyMin.setText((String)values.get(5).get(1));
        MiddieLateMin.setText((String)values.get(5).get(2));
        MiddieDinnerMin.setText((String)values.get(5).get(3));
        MiddieMorningMax.setText((String)values.get(5).get(4));
        MiddieEarlyMax.setText((String)values.get(5).get(5));
        MiddieLateMax.setText((String)values.get(5).get(6));
        MiddieDinnerMax.setText((String)values.get(5).get(7));
        MiddieMorningLeads.setText((String)values.get(5).get(8));
        MiddieEarlyLeads.setText((String)values.get(5).get(9));
        MiddieLateLeads.setText((String)values.get(5).get(10));
        MiddieDinnerLeads.setText((String)values.get(5).get(11));

        CurryMorningMin.setText((String)values.get(6).get(0));
        CurryEarlyMin.setText((String)values.get(6).get(1));
        CurryLateMin.setText((String)values.get(6).get(2));
        CurryDinnerMin.setText((String)values.get(6).get(3));
        CurryMorningMax.setText((String)values.get(6).get(4));
        CurryEarlyMax.setText((String)values.get(6).get(5));
        CurryLateMax.setText((String)values.get(6).get(6));
        CurryDinnerMax.setText((String)values.get(6).get(7));
        CurryMorningLeads.setText((String)values.get(6).get(8));
        CurryEarlyLeads.setText((String)values.get(6).get(9));
        CurryLateLeads.setText((String)values.get(6).get(10));
        CurryDinnerLeads.setText((String)values.get(6).get(11));

        GrangeMorningMin.setText((String)values.get(7).get(0));
        GrangeEarlyMin.setText((String)values.get(7).get(1));
        GrangeLateMin.setText((String)values.get(7).get(2));
        GrangeDinnerMin.setText((String)values.get(7).get(3));
        GrangeMorningMax.setText((String)values.get(7).get(4));
        GrangeEarlyMax.setText((String)values.get(7).get(5));
        GrangeLateMax.setText((String)values.get(7).get(6));
        GrangeDinnerMax.setText((String)values.get(7).get(7));
        GrangeMorningLeads.setText((String)values.get(7).get(8));
        GrangeEarlyLeads.setText((String)values.get(7).get(9));
        GrangeLateLeads.setText((String)values.get(7).get(10));
        GrangeDinnerLeads.setText((String)values.get(7).get(11));

        DishMorningMin.setText((String)values.get(8).get(0));
        DishEarlyMin.setText((String)values.get(8).get(1));
        DishLateMin.setText((String)values.get(8).get(2));
        DishDinnerMin.setText((String)values.get(8).get(3));
        DishMorningMax.setText((String)values.get(8).get(4));
        DishEarlyMax.setText((String)values.get(8).get(5));
        DishLateMax.setText((String)values.get(8).get(6));
        DishDinnerMax.setText((String)values.get(8).get(7));
        DishMorningLeads.setText((String)values.get(8).get(8));
        DishEarlyLeads.setText((String)values.get(8).get(9));
        DishLateLeads.setText((String)values.get(8).get(10));
        DishDinnerLeads.setText((String)values.get(8).get(11));

        DRAMorningMin.setText((String)values.get(9).get(0));
        DRAEarlyMin.setText((String)values.get(9).get(1));
        DRALateMin.setText((String)values.get(9).get(2));
        DRADinnerMin.setText((String)values.get(9).get(3));
        DRAMorningMax.setText((String)values.get(9).get(4));
        DRAEarlyMax.setText((String)values.get(9).get(5));
        DRALateMax.setText((String)values.get(9).get(6));
        DRADinnerMax.setText((String)values.get(9).get(7));
        DRAMorningLeads.setText((String)values.get(9).get(8));
        DRAEarlyLeads.setText((String)values.get(9).get(9));
        DRALateLeads.setText((String)values.get(9).get(10));
        DRADinnerLeads.setText((String)values.get(9).get(11));

        CRMorningMin.setText((String)values.get(10).get(0));
        CREarlyMin.setText((String)values.get(10).get(1));
        CRLateMin.setText((String)values.get(10).get(2));
        CRDinnerMin.setText((String)values.get(10).get(3));
        CRMorningMax.setText((String)values.get(10).get(4));
        CREarlyMax.setText((String)values.get(10).get(5));
        CRLateMax.setText((String)values.get(10).get(6));
        CRDinnerMax.setText((String)values.get(10).get(7));
        CRMorningLeads.setText((String)values.get(10).get(8));
        CREarlyLeads.setText((String)values.get(10).get(9));
        CRLateLeads.setText((String)values.get(10).get(10));
        CRDinnerLeads.setText((String)values.get(10).get(11));

        JanitorMorningMin.setText((String)values.get(11).get(0));
        JanitorEarlyMin.setText((String)values.get(11).get(1));
        JanitorLateMin.setText((String)values.get(11).get(2));
        JanitorDinnerMin.setText((String)values.get(11).get(3));
        JanitorMorningMax.setText((String)values.get(11).get(4));
        JanitorEarlyMax.setText((String)values.get(11).get(5));
        JanitorLateMax.setText((String)values.get(11).get(6));
        JanitorDinnerMax.setText((String)values.get(11).get(7));
        JanitorMorningLeads.setText((String)values.get(11).get(8));
        JanitorEarlyLeads.setText((String)values.get(11).get(9));
        JanitorLateLeads.setText((String)values.get(11).get(10));
        JanitorDinnerLeads.setText((String)values.get(11).get(11));



    }

    public List<List<Object>> buildShiftNumbers(){
        List<List<Object>> shiftNumbers = new ArrayList<List<Object>>();
        List<Object> checker = new ArrayList<>();
        List<Object> peaks = new ArrayList<>();
        List<Object> hearth = new ArrayList<>();
        List<Object> salads = new ArrayList<>();
        List<Object> toast = new ArrayList<>();
        List<Object> middie = new ArrayList<>();
        List<Object> curry = new ArrayList<>();
        List<Object> grange = new ArrayList<>();
        List<Object> dish = new ArrayList<>();
        List<Object> dra = new ArrayList<>();
        List<Object> coldrunner = new ArrayList<>();
        List<Object> janitor = new ArrayList<>();


        checker.add(CheckerMorningMin.getText());
        checker.add(CheckerEarlyMin.getText());
        checker.add(CheckerLateMin.getText());
        checker.add(CheckerDinnerMin.getText());
        checker.add(CheckerMorningMax.getText());
        checker.add(CheckerEarlyMax.getText());
        checker.add(CheckerLateMax.getText());
        checker.add(CheckerDinnerMax.getText());
        checker.add(CheckerMorningLeads.getText());
        checker.add(CheckerEarlyLeads.getText());
        checker.add(CheckerLateLeads.getText());
        checker.add(CheckerDinnerLeads.getText());

        peaks.add(PeaksMorningMin.getText());
        peaks.add(PeaksEarlyMin.getText());
        peaks.add(PeaksLateMin.getText());
        peaks.add(PeaksDinnerMin.getText());
        peaks.add(PeaksMorningMax.getText());
        peaks.add(PeaksEarlyMax.getText());
        peaks.add(PeaksLateMax.getText());
        peaks.add(PeaksDinnerMax.getText());
        peaks.add(PeaksMorningLeads.getText());
        peaks.add(PeaksEarlyLeads.getText());
        peaks.add(PeaksLateLeads.getText());
        peaks.add(PeaksDinnerLeads.getText());

        hearth.add(HearthMorningMin.getText());
        hearth.add(HearthEarlyMin.getText());
        hearth.add(HearthLateMin.getText());
        hearth.add(HearthDinnerMin.getText());
        hearth.add(HearthMorningMax.getText());
        hearth.add(HearthEarlyMax.getText());
        hearth.add(HearthLateMax.getText());
        hearth.add(HearthDinnerMax.getText());
        hearth.add(HearthMorningLeads.getText());
        hearth.add(HearthEarlyLeads.getText());
        hearth.add(HearthLateLeads.getText());
        hearth.add(HearthDinnerLeads.getText());

        salads.add(SaladsMorningMin.getText());
        salads.add(SaladsEarlyMin.getText());
        salads.add(SaladsLateMin.getText());
        salads.add(SaladsDinnerMin.getText());
        salads.add(SaladsMorningMax.getText());
        salads.add(SaladsEarlyMax.getText());
        salads.add(SaladsLateMax.getText());
        salads.add(SaladsDinnerMax.getText());
        salads.add(SaladsMorningLeads.getText());
        salads.add(SaladsEarlyLeads.getText());
        salads.add(SaladsLateLeads.getText());
        salads.add(SaladsDinnerLeads.getText());

        toast.add(ToastMorningMin.getText());
        toast.add(ToastEarlyMin.getText());
        toast.add(ToastLateMin.getText());
        toast.add(ToastDinnerMin.getText());
        toast.add(ToastMorningMax.getText());
        toast.add(ToastEarlyMax.getText());
        toast.add(ToastLateMax.getText());
        toast.add(ToastDinnerMax.getText());
        toast.add(ToastMorningLeads.getText());
        toast.add(ToastEarlyLeads.getText());
        toast.add(ToastLateLeads.getText());
        toast.add(ToastDinnerLeads.getText());

        middie.add(MiddieMorningMin.getText());
        middie.add(MiddieEarlyMin.getText());
        middie.add(MiddieLateMin.getText());
        middie.add(MiddieDinnerMin.getText());
        middie.add(MiddieMorningMax.getText());
        middie.add(MiddieEarlyMax.getText());
        middie.add(MiddieLateMax.getText());
        middie.add(MiddieDinnerMax.getText());
        middie.add(MiddieMorningLeads.getText());
        middie.add(MiddieEarlyLeads.getText());
        middie.add(MiddieLateLeads.getText());
        middie.add(MiddieDinnerLeads.getText());

        curry.add(CurryMorningMin.getText());
        curry.add(CurryEarlyMin.getText());
        curry.add(CurryLateMin.getText());
        curry.add(CurryDinnerMin.getText());
        curry.add(CurryMorningMax.getText());
        curry.add(CurryEarlyMax.getText());
        curry.add(CurryLateMax.getText());
        curry.add(CurryDinnerMax.getText());
        curry.add(CurryMorningLeads.getText());
        curry.add(CurryEarlyLeads.getText());
        curry.add(CurryLateLeads.getText());
        curry.add(CurryDinnerLeads.getText());

        grange.add(GrangeMorningMin.getText());
        grange.add(GrangeEarlyMin.getText());
        grange.add(GrangeLateMin.getText());
        grange.add(GrangeDinnerMin.getText());
        grange.add(GrangeMorningMax.getText());
        grange.add(GrangeEarlyMax.getText());
        grange.add(GrangeLateMax.getText());
        grange.add(GrangeDinnerMax.getText());
        grange.add(GrangeMorningLeads.getText());
        grange.add(GrangeEarlyLeads.getText());
        grange.add(GrangeLateLeads.getText());
        grange.add(GrangeDinnerLeads.getText());

        dish.add(DishMorningMin.getText());
        dish.add(DishEarlyMin.getText());
        dish.add(DishLateMin.getText());
        dish.add(DishDinnerMin.getText());
        dish.add(DishMorningMax.getText());
        dish.add(DishEarlyMax.getText());
        dish.add(DishLateMax.getText());
        dish.add(DishDinnerMax.getText());
        dish.add(DishMorningLeads.getText());
        dish.add(DishEarlyLeads.getText());
        dish.add(DishLateLeads.getText());
        dish.add(DishDinnerLeads.getText());

        dra.add(DRAMorningMin.getText());
        dra.add(DRAEarlyMin.getText());
        dra.add(DRALateMin.getText());
        dra.add(DRADinnerMin.getText());
        dra.add(DRAMorningMax.getText());
        dra.add(DRAEarlyMax.getText());
        dra.add(DRALateMax.getText());
        dra.add(DRADinnerMax.getText());
        dra.add(DRAMorningLeads.getText());
        dra.add(DRAEarlyLeads.getText());
        dra.add(DRALateLeads.getText());
        dra.add(DRADinnerLeads.getText());

        coldrunner.add(CRMorningMin.getText());
        coldrunner.add(CREarlyMin.getText());
        coldrunner.add(CRLateMin.getText());
        coldrunner.add(CRDinnerMin.getText());
        coldrunner.add(CRMorningMax.getText());
        coldrunner.add(CREarlyMax.getText());
        coldrunner.add(CRLateMax.getText());
        coldrunner.add(CRDinnerMax.getText());
        coldrunner.add(CRMorningLeads.getText());
        coldrunner.add(CREarlyLeads.getText());
        coldrunner.add(CRLateLeads.getText());
        coldrunner.add(CRDinnerLeads.getText());

        janitor.add(JanitorMorningMin.getText());
        janitor.add(JanitorEarlyMin.getText());
        janitor.add(JanitorLateMin.getText());
        janitor.add(JanitorDinnerMin.getText());
        janitor.add(JanitorMorningMax.getText());
        janitor.add(JanitorEarlyMax.getText());
        janitor.add(JanitorLateMax.getText());
        janitor.add(JanitorDinnerMax.getText());
        janitor.add(JanitorMorningLeads.getText());
        janitor.add(JanitorEarlyLeads.getText());
        janitor.add(JanitorLateLeads.getText());
        janitor.add(JanitorDinnerLeads.getText());



        shiftNumbers.add(checker);
        shiftNumbers.add(peaks);
        shiftNumbers.add(hearth);
        shiftNumbers.add(salads);
        shiftNumbers.add(toast);
        shiftNumbers.add(middie);
        shiftNumbers.add(curry);
        shiftNumbers.add(grange);
        shiftNumbers.add(dish);
        shiftNumbers.add(dra);
        shiftNumbers.add(coldrunner);
        shiftNumbers.add(janitor);

        return shiftNumbers;
    }



    //TODO: create error check to ensure input is correct
    //TODO: Run with new values
    //TODO: Run and set new default
}
