import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.List;

public class DuckListUI {

    private List<List<List<Integer>>> stationNeeds = new ArrayList<List<List<Integer>>>();
    private JPanel mainView;
    private JButton SundayButton;
    private JButton MondayButton;
    private JButton TuesdayButton;
    private JButton Wednesday;
    private JButton ThursdayButton;
    private JButton FridayButton;
    private JButton SaturdayButton;
    private JTextArea DayText;
    private JButton ExitButton;
    private JButton CoverageButton;
    private JButton EditSundayButton;
    private JButton EditMondayButton;
    private JButton EditTuesdayButton;
    private JButton EditWednesdayButton;
    private JButton EditThursdayButton;
    private JButton EditFridayButton;
    private JButton EditSaturdayButton;
    private int action = 0;



    private int day = 0;

    private List<Integer> shiftInput;

    public void setAction(int action) {
        this.action = action;
    }
    public int getAction(){
        return action;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }


    public static void main(String[] args) throws IOException, GeneralSecurityException {


        JFrame frame = new JFrame("DuckListUI");
        frame.setContentPane(new DuckListUI().mainView);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

    }

    public DuckListUI() {

        SundayButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setAction(1);
                setDay(1);
            }
        });
        MondayButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setAction(1);
                setDay(3);
            }
        });
        TuesdayButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setAction(1);
                setDay(5);
            }
        });
        Wednesday.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setAction(1);
                setDay(7);
            }
        });
        ThursdayButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setAction(1);
                setDay(9);
            }
        });
        FridayButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setAction(1);
                setDay(11);
            }
        });
        SaturdayButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setAction(1);
                setDay(13);
            }
        });
        ExitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setAction(-1);
            }
        });
        CoverageButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setAction(3);
            }
        });
        EditSundayButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setAction(2);
                setDay(1);
            }
        });
        EditMondayButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setAction(2);
                setDay(3);
            }
        });
        EditTuesdayButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setAction(2);
                setDay(5);
            }
        });
        EditWednesdayButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setAction(2);
                setDay(7);
            }
        });
        EditThursdayButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setAction(2);
                setDay(9);
            }
        });
        EditFridayButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setAction(2);
                setDay(11);
            }
        });
        EditSaturdayButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setAction(2);
                setDay(13);
            }
        });
    }

    public JPanel getMainView(){
        return mainView;
    }

}
