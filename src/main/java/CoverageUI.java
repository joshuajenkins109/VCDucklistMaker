import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CoverageUI {
    private JTextArea SundayCoverage;
    private JTextArea MondayCoverage;
    private JTextArea TuesdayCoverage;
    private JTextArea WednesdayCoverage;
    private JTextArea ThursdayCoverage;
    private JTextArea FridayCoverage;
    private JTextArea SaturdayCoverage;
    private int exitCode = 0;
    private JButton RestartButton;
    private JButton ExitButton;
    private JPanel CoveragePanel;


    public CoverageUI(){
        RestartButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setExitCode(1);
            }
        });
        ExitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setExitCode(-1);
            }
        });
    }

    public void setSundayCoverage(String text){ SundayCoverage.setText(text);}
    public void setMondayCoverage(String text){ MondayCoverage.setText(text);}
    public void setTuesdayCoverage(String text){ TuesdayCoverage.setText(text);}
    public void setWednesdayCoverage(String text){WednesdayCoverage.setText(text);}
    public void setThursdayCoverage(String text){ThursdayCoverage.setText(text);}
    public void setFridayCoverage(String text){FridayCoverage.setText(text);}
    public void setSaturdayCoverage(String text){SaturdayCoverage.setText(text);}


    public void setExitCode(int num){exitCode = num;}
    public int getExitCode() { return exitCode;}
    public JPanel getCoveragePanel(){return CoveragePanel;}

}
