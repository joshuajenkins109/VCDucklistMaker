import com.google.api.client.auth.oauth2.Credential;
import com.google.api.client.extensions.java6.auth.oauth2.AuthorizationCodeInstalledApp;
import com.google.api.client.extensions.jetty.auth.oauth2.LocalServerReceiver;
import com.google.api.client.googleapis.auth.oauth2.GoogleAuthorizationCodeFlow;
import com.google.api.client.googleapis.auth.oauth2.GoogleClientSecrets;
import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.client.util.store.FileDataStoreFactory;
import com.google.api.services.sheets.v4.Sheets;
import com.google.api.services.sheets.v4.SheetsScopes;
import com.google.api.services.sheets.v4.model.ValueRange;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.Collections;
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
    private int day = 0;

    public void setDay(int day) {
        this.day = day;
    }
    public int getDay(){
        return day;
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
            public void actionPerformed(ActionEvent e) { setDay(1); }});
        MondayButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setDay(3);
            }
        });
        TuesdayButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setDay(5);
            }
        });
        Wednesday.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setDay(7);
            }
        });
        ThursdayButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setDay(9);
            }
        });
        FridayButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setDay(11);
            }
        });
        SaturdayButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setDay(13);
            }
        });
        ExitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setDay(-1);
            }
        });
        CoverageButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setDay(15);
            }
        });
    }

    public JPanel getMainView(){
        return mainView;
    }

}
