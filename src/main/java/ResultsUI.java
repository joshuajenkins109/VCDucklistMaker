import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ResultsUI {
    private JTextArea morningDuckList;
    private JPanel ResultsPanel;
    private JButton RestartButton;
    private JTextArea midDuckList;
    private JTextArea dinnerDuckList;
    private int exitCode = 0;

    public void setExitCode(int exitCode) {
        this.exitCode = exitCode;
    }
    public int getExitCode(){
        return exitCode;
    }

    public ResultsUI(){
        ResultsPanel.setSize(500, 500);
        RestartButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setExitCode(1);
            }
        });
    }

    public JPanel getResultsPanel(){
        return ResultsPanel;
    }


    public void setMorningDuckList(String text){
        morningDuckList.setText(text);
    }
    public void setMidDuckList(String text) { midDuckList.setText(text);}
    public void setDinnerDuckList(String text) { dinnerDuckList.setText(text);}
}
