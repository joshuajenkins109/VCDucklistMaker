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
import com.google.api.services.sheets.v4.model.*;
import org.apache.http.protocol.HTTP;
import sun.java2d.loops.FillRect;


import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.security.GeneralSecurityException;
import java.util.*;

public class SheetsCommunicator {

    private static final String APPLICATION_NAME = "Google Sheets API Java Quickstart";
    private static final JsonFactory JSON_FACTORY = JacksonFactory.getDefaultInstance();
    private static final String TOKENS_DIRECTORY_PATH = "tokens";

    private static final List<String> SCOPES = Collections.singletonList(SheetsScopes.SPREADSHEETS);
    private static final String CREDENTIALS_FILE_PATH = "/credentials.json";

    public SheetsCommunicator(){}

    /**
     * Creates an authorized Credential object.
                * @param HTTP_TRANSPORT The network HTTP Transport.
     * @return An authorized Credential object.
                * @throws IOException If the credentials.json file cannot be found.
                */
        private static Credential getCredentials(final NetHttpTransport HTTP_TRANSPORT) throws IOException {
            // Load client secrets.
            InputStream in = SheetsQuickstart.class.getResourceAsStream(CREDENTIALS_FILE_PATH);
            GoogleClientSecrets clientSecrets = GoogleClientSecrets.load(JSON_FACTORY, new InputStreamReader(in));

            // Build flow and trigger user authorization request.
            GoogleAuthorizationCodeFlow flow = new GoogleAuthorizationCodeFlow.Builder(
                    HTTP_TRANSPORT, JSON_FACTORY, clientSecrets, SCOPES)
                    .setDataStoreFactory(new FileDataStoreFactory(new java.io.File(TOKENS_DIRECTORY_PATH)))
                    .setAccessType("offline")
                    .build();
            return new AuthorizationCodeInstalledApp(flow, new LocalServerReceiver()).authorize("user");
        }

    public Schedule generateList() throws IOException, GeneralSecurityException {
        final NetHttpTransport HTTP_TRANSPORT = GoogleNetHttpTransport.newTrustedTransport();
        // *old schedule* final String spreadsheetId = "1JwjcwHRbxiq6T16uxJFP2lEbJl4C0FkH7HVlRqHo_ps";
        final String spreadsheetId = "1IdPO_3d2Y1Zcs0ZIIWrBsBG7TZ0mt3aLIL11cyHMl4M";
        final String range = "Sheet1!A6:O176";                                                          //TODO: Figure out how to make this dynamic **** CAUSES ERROR IF OVEREXTENDED
        Sheets service = new Sheets.Builder(HTTP_TRANSPORT, JSON_FACTORY, getCredentials(HTTP_TRANSPORT))
                .setApplicationName(APPLICATION_NAME)
                .build();
        ValueRange response = service.spreadsheets().values()
                .get(spreadsheetId, range)
                .execute();



        List<List<Object>> values = response.getValues();
        Schedule schedule = new Schedule(values);

        return schedule;
    }

    private void addStudentToWeights(String name, int rowIndex) throws IOException, GeneralSecurityException{
        final NetHttpTransport HTTP_TRANSPORT = GoogleNetHttpTransport.newTrustedTransport();
        final String spreadsheetId = "1BuWoL8uGgCgx24TKtDjx-j8406BZ36xbaGyOq359sfA";
        Sheets service = new Sheets.Builder(HTTP_TRANSPORT, JSON_FACTORY, getCredentials(HTTP_TRANSPORT))
                .setApplicationName(APPLICATION_NAME)
                .build();

        List<Request> requests = new ArrayList<>();
        List<CellData> cells = new ArrayList<>();

        cells.add( new CellData()
        .setUserEnteredValue(new ExtendedValue()
            .setStringValue(name))
        .setUserEnteredFormat(new CellFormat()
            .setTextFormat(new TextFormat()
                .setFontSize(12))));

        for(int i = 0; i < 12; i++)
        {
            cells.add( new CellData()
                    .setUserEnteredValue(new ExtendedValue()
                            .setStringValue("1")
                    )
                    .setUserEnteredFormat(new CellFormat()
                            .setHorizontalAlignment("Center")
                            .setTextFormat(new TextFormat()
                                    .setFontSize(12))));
        }
        cells.add( new CellData()
                .setUserEnteredValue(new ExtendedValue()
                        .setStringValue("0")
                )
                .setUserEnteredFormat(new CellFormat()
                    .setHorizontalAlignment("Center")
                    .setTextFormat(new TextFormat()
                        .setFontSize(12))));

        requests.add(new Request()
            .setInsertDimension(new InsertDimensionRequest()
            .setRange(new DimensionRange()
                .setSheetId(999419915)
                .setDimension("ROWS")
                    .setStartIndex(rowIndex)
                .setEndIndex(rowIndex+1))));


        requests.add(new Request()
            .setUpdateCells(new UpdateCellsRequest()
                .setRows(Arrays.asList(
                        new RowData().setValues(cells)))
                .setStart( new GridCoordinate()
                    .setSheetId(999419915)
                    .setRowIndex(rowIndex)
                    .setColumnIndex(0))
                .setFields("userEnteredValue,userEnteredFormat")));

        BatchUpdateSpreadsheetRequest body = new BatchUpdateSpreadsheetRequest().setRequests(requests);
        BatchUpdateSpreadsheetResponse response = service.spreadsheets()
                .batchUpdate(spreadsheetId, body).execute();

    }


    public void updateStudentsWeights() throws IOException, GeneralSecurityException{
        final NetHttpTransport HTTP_TRANSPORT = GoogleNetHttpTransport.newTrustedTransport();
        final String spreadsheetId = "1BuWoL8uGgCgx24TKtDjx-j8406BZ36xbaGyOq359sfA";
        final String spreadsheetId2 = "1IdPO_3d2Y1Zcs0ZIIWrBsBG7TZ0mt3aLIL11cyHMl4M";
        Sheets service = new Sheets.Builder(HTTP_TRANSPORT, JSON_FACTORY, getCredentials(HTTP_TRANSPORT))
                .setApplicationName(APPLICATION_NAME)
                .build();

        ValueRange response = service.spreadsheets().values()
                .get(spreadsheetId2, "Sheet1")
                .execute();

        ValueRange response2 = service.spreadsheets().values()
                .get(spreadsheetId, "StudentWeights")
                .execute();

        List<List<Object>> firstSheet = response.getValues();
        List<List<Object>> secondSheet = response2.getValues();


        for(int i = 6; i < firstSheet.size(); i++){

            for(int j = 1; j < secondSheet.size(); j++){
                if(firstSheet.get(i).size() > 0){
                    if(firstSheet.get(i).get(0).toString().compareTo("") != 0 &&
                            firstSheet.get(i).get(0).toString().compareTo("Crew") != 0 &&
                            firstSheet.get(i).get(0).toString().compareTo("Temps") != 0){

                        if(secondSheet.get(j).get(0).toString().compareTo(firstSheet.get(i).get(0).toString()) == 0)
                        {
                            break;
                        }
                        if(secondSheet.get(j).get(0).toString().compareTo(firstSheet.get(i).get(0).toString()) > 0){
                            addStudentToWeights(firstSheet.get(i).get(0).toString(), j);
                            secondSheet.add(j, firstSheet.get(i));
                            break;
                        }
                    }
                }

            }
        }
    }

    public List<List<Object>> getStudentWeights() throws IOException, GeneralSecurityException{
        final NetHttpTransport HTTP_TRANSPORT = GoogleNetHttpTransport.newTrustedTransport();
        final String spreadsheetId = "1BuWoL8uGgCgx24TKtDjx-j8406BZ36xbaGyOq359sfA";
        Sheets service = new Sheets.Builder(HTTP_TRANSPORT, JSON_FACTORY, getCredentials(HTTP_TRANSPORT))
                .setApplicationName(APPLICATION_NAME)
                .build();

        ValueRange response = service.spreadsheets().values()
                .get(spreadsheetId, "StudentWeights")
                .execute();

        return response.getValues();
    }

    public List<List<Object>> getShiftDefaults(String range) throws IOException, GeneralSecurityException {
            final NetHttpTransport HTTP_TRANSPORT = GoogleNetHttpTransport.newTrustedTransport();
            final String spreadsheetId = "1BuWoL8uGgCgx24TKtDjx-j8406BZ36xbaGyOq359sfA";
            Sheets service = new Sheets.Builder(HTTP_TRANSPORT, JSON_FACTORY, getCredentials(HTTP_TRANSPORT))
                    .setApplicationName(APPLICATION_NAME)
                    .build();
            ValueRange response = service.spreadsheets().values()
                    .get(spreadsheetId, range)
                    .execute();


            List<List<Object>> values = response.getValues();


            return values;
    }

    public void setShiftDefaults(String range, List<List<Object>> input) throws IOException, GeneralSecurityException {
        final NetHttpTransport HTTP_TRANSPORT = GoogleNetHttpTransport.newTrustedTransport();
        final String spreadsheetId = "1BuWoL8uGgCgx24TKtDjx-j8406BZ36xbaGyOq359sfA";

        List<List<Object>> values = input;



        Sheets service = new Sheets.Builder(HTTP_TRANSPORT, JSON_FACTORY, getCredentials(HTTP_TRANSPORT))
                .setApplicationName(APPLICATION_NAME)
                .build();
        ValueRange body = new ValueRange()
                .setValues(values);
        UpdateValuesResponse result =
                service.spreadsheets().values().update(spreadsheetId, range, body)
                        .setValueInputOption("USER_ENTERED")
                        .execute();

    }

    public void createDuckList(List<List<List<Student>>> students, int day) throws IOException, GeneralSecurityException{
        setCheckerDuckListValues(students, day, 0);
        setCheckerDuckListValues(students, day, 1);
        setCheckerDuckListValues(students, day, 3);
        setMiddleDuckListValues(students, day, 0);
        setMiddleDuckListValues(students, day, 1);
        setMiddleDuckListValues(students, day, 3);
        setCurryDuckListValues(students, day, 0);
        setCurryDuckListValues(students, day, 1);
        setCurryDuckListValues(students, day, 3);
        setGrangeDuckListValues(students, day, 0);
        setGrangeDuckListValues(students, day, 1);
        setGrangeDuckListValues(students, day, 3);
        setToastDuckListValues(students, day, 0);
        setToastDuckListValues(students, day, 1);
        setToastDuckListValues(students, day, 3);
        setDuckListValues(students, day, 0, 2, 24); //hearth
        setDuckListValues(students, day, 1, 2, 24);
        setDuckListValues(students, day, 3, 2, 24);
        setDuckListValues(students, day, 0, 1, 27); //peaks
        setDuckListValues(students, day, 1,1, 27);
        setDuckListValues(students, day, 3, 1, 27);
        setDuckListValues(students, day, 0, 3, 30); //salads
        setDuckListValues(students, day, 1,3, 30);
        setDuckListValues(students, day, 3, 3, 30);
        setDuckListValues(students, day, 0, 10, 33); //Cold Runner
        setDuckListValues(students, day, 1,10, 33);
        setDuckListValues(students, day, 3, 10, 33);
        setDuckListValues(students, day, 0, 9, 36); //DRA
        setDuckListValues(students, day, 1,9, 36);
        setDuckListValues(students, day, 3, 9, 36);
        setDishDuckListValues(students, day, 0);
        setDishDuckListValues(students, day, 1);
        setDishDuckListValues(students, day, 3);
        setJanitorDuckListValues(students, day, 0);
        setJanitorDuckListValues(students, day, 1);
        setJanitorDuckListValues(students, day, 3);


    }

    private void setCheckerDuckListValues(List<List<List<Student>>> students, int day, int shift) throws IOException, GeneralSecurityException{
        final NetHttpTransport HTTP_TRANSPORT = GoogleNetHttpTransport.newTrustedTransport();
        final String spreadsheetId = "1BuWoL8uGgCgx24TKtDjx-j8406BZ36xbaGyOq359sfA";


        Sheets service = new Sheets.Builder(HTTP_TRANSPORT, JSON_FACTORY, getCredentials(HTTP_TRANSPORT))
                .setApplicationName(APPLICATION_NAME)
                .build();


        List<Request> requests = new ArrayList<>();

        List<CellData> checkerCellLine1 = new ArrayList<>();
        List<CellData> checkerCellLine2 = new ArrayList<>();
        String checkerDataLine1 = "";
        String checkerDataLine2 = "";
        if(students.get(0).get(shift).size() > 0){
            checkerDataLine1 += students.get(0).get(shift).get(0).getName() + " (" + students.get(0).get(shift).get(0).getSchedule().get(day) + "-" + students.get(0).get(shift).get(0).getSchedule().get(day+1)+")";
        }
        if(students.get(0).get(shift).size() > 1){
            for(int i = 1; i < students.get(0).get(shift).size(); i++){
                checkerDataLine2 += students.get(0).get(shift).get(i).getName() + " (" + students.get(0).get(shift).get(i).getSchedule().get(day) + "-" + students.get(0).get(shift).get(i).getSchedule().get(day+1)+"), ";
            }
        }
        if(shift == 1){
            if(students.get(0).get(shift+1).size() > 0){
                for(int i = 0; i < students.get(0).get(shift+1).size(); i++){
                    checkerDataLine2 += students.get(0).get(shift+1).get(i).getName() + " (" + students.get(0).get(shift+1).get(i).getSchedule().get(day) + "-" + students.get(0).get(shift+1).get(i).getSchedule().get(day+1)+"), ";
                }
            }
        }
        checkerCellLine1.add( new CellData()
                .setUserEnteredValue(new ExtendedValue()
                        .setStringValue(checkerDataLine1))
                .setUserEnteredFormat(new CellFormat()
                        .setTextFormat(new TextFormat()
                                .setFontSize(8)
                        )
                        .setWrapStrategy("Wrap")));

        checkerCellLine2.add( new CellData()
                .setUserEnteredValue(new ExtendedValue()
                        .setStringValue(checkerDataLine2))
                .setUserEnteredFormat(new CellFormat()
                        .setTextFormat(new TextFormat()
                                .setFontSize(8)
                        )
                        .setWrapStrategy("Wrap")));

        if(shift == 0 || shift == 1) {
            requests.add(new Request()
                    .setUpdateCells(new UpdateCellsRequest()
                            .setRows(Arrays.asList(
                                    new RowData().setValues(checkerCellLine1)))
                            .setStart(new GridCoordinate()
                                    .setSheetId(1656413616)
                                    .setRowIndex(3)
                                    .setColumnIndex(shift))
                            .setFields("userEnteredValue,userEnteredFormat")));
            requests.add(new Request()
                    .setUpdateCells(new UpdateCellsRequest()
                            .setRows(Arrays.asList(
                                    new RowData().setValues(checkerCellLine2)))
                            .setStart(new GridCoordinate()
                                    .setSheetId(1656413616)
                                    .setRowIndex(4)
                                    .setColumnIndex(shift))
                            .setFields("userEnteredValue,userEnteredFormat")));
        }
        if(shift == 3){
            requests.add(new Request()
                    .setUpdateCells(new UpdateCellsRequest()
                            .setRows(Arrays.asList(
                                    new RowData().setValues(checkerCellLine1)))
                            .setStart(new GridCoordinate()
                                    .setSheetId(1656413616)
                                    .setRowIndex(3)
                                    .setColumnIndex(shift-1))
                            .setFields("userEnteredValue,userEnteredFormat")));
            requests.add(new Request()
                    .setUpdateCells(new UpdateCellsRequest()
                            .setRows(Arrays.asList(
                                    new RowData().setValues(checkerCellLine2)))
                            .setStart(new GridCoordinate()
                                    .setSheetId(1656413616)
                                    .setRowIndex(4)
                                    .setColumnIndex(shift-1))
                            .setFields("userEnteredValue,userEnteredFormat")));
        }
        BatchUpdateSpreadsheetRequest body = new BatchUpdateSpreadsheetRequest().setRequests(requests);
        BatchUpdateSpreadsheetResponse response = service.spreadsheets()
                .batchUpdate(spreadsheetId, body).execute();

    }

    private void setMiddleDuckListValues(List<List<List<Student>>> students, int day, int shift) throws IOException, GeneralSecurityException{
        final NetHttpTransport HTTP_TRANSPORT = GoogleNetHttpTransport.newTrustedTransport();
        final String spreadsheetId = "1BuWoL8uGgCgx24TKtDjx-j8406BZ36xbaGyOq359sfA";


        Sheets service = new Sheets.Builder(HTTP_TRANSPORT, JSON_FACTORY, getCredentials(HTTP_TRANSPORT))
                .setApplicationName(APPLICATION_NAME)
                .build();


        List<Request> requests = new ArrayList<>();

        List<CellData> middleCellLine1 = new ArrayList<>();
        List<CellData> middleCellLine2 = new ArrayList<>();
        List<CellData> middleCellLine3 = new ArrayList<>();
        String middleDataLine1 = "";
        String middleDataLine2 = "";
        String middleDataLine3 = "";

        if(students.get(5).get(shift).size() > 0){
            for(int i = 0; i < students.get(5).get(shift).size(); i++){
                if(i == 2) break;
                middleDataLine1 += students.get(5).get(shift).get(i).getName() + " (" +students.get(5).get(shift).get(i).getSchedule().get(day) + "-" + students.get(5).get(shift).get(i).getSchedule().get(day+1)+")" + ", ";
            }
            if( students.get(5).get(shift).size() > 2){
                for(int i = 2; i < students.get(5).get(shift).size(); i++){
                    if(i==4) break;
                    middleDataLine2 += students.get(5).get(shift).get(i).getName() + " (" +students.get(5).get(shift).get(i).getSchedule().get(day) + "-" + students.get(5).get(shift).get(i).getSchedule().get(day+1)+")" + ", ";
                }
            }
            if( students.get(5).get(shift).size() > 4){
                for(int i = 4; i < students.get(5).get(shift).size(); i++){
                    middleDataLine3 += students.get(5).get(shift).get(i).getName() + " (" +students.get(5).get(shift).get(i).getSchedule().get(day) + "-" + students.get(5).get(shift).get(i).getSchedule().get(day+1)+")" + ", ";
                }
            }


        }
        if(shift==1 && students.get(5).get(shift+1).size() > 0){
            if(students.get(5).get(shift).size() < 3)
            {
                for(int i = 0; i < students.get(5).get(shift+1).size(); i++){
                    if(i == 2) break;
                    middleDataLine2 += students.get(5).get(shift+1).get(i).getName() + " (" +students.get(5).get(shift+1).get(i).getSchedule().get(day) + "-" + students.get(5).get(shift+1).get(i).getSchedule().get(day+1)+")" + ", ";
                }
                if( students.get(5).get(shift+1).size() > 2){
                    for(int i = 2; i < students.get(5).get(shift+1).size(); i++){
                        middleDataLine3 += students.get(5).get(shift+1).get(i).getName() + " (" +students.get(5).get(shift+1).get(i).getSchedule().get(day) + "-" + students.get(5).get(shift+1).get(i).getSchedule().get(day+1)+")" + ", ";
                    }
                }
            }
            else if(students.get(5).get(shift).size() == 3){

                middleDataLine2 += students.get(5).get(shift+1).get(0).getName() + " (" +students.get(5).get(shift+1).get(0).getSchedule().get(day) + "-" + students.get(5).get(shift+1).get(0).getSchedule().get(day+1)+")" + ", ";
                if( students.get(5).get(shift+1).size() > 1){
                    for(int i = 1; i < students.get(5).get(shift+1).size(); i++){
                        middleDataLine3 += students.get(5).get(shift+1).get(i).getName() + " (" +students.get(5).get(shift+1).get(i).getSchedule().get(day) + "-" + students.get(5).get(shift+1).get(i).getSchedule().get(day+1)+")" + ", ";
                    }
                }
            }
            else if(students.get(5).get(shift).size() > 3){
                for(int i = 0; i < students.get(5).get(shift+1).size(); i++){
                    middleDataLine3 += students.get(5).get(shift+1).get(i).getName() + " (" +students.get(5).get(shift+1).get(i).getSchedule().get(day) + "-" + students.get(5).get(shift+1).get(i).getSchedule().get(day+1)+")" + ", ";
                }

            }
        }
        middleCellLine1.add( new CellData()
                .setUserEnteredValue(new ExtendedValue()
                        .setStringValue(middleDataLine1))
                .setUserEnteredFormat(new CellFormat()
                        .setTextFormat(new TextFormat()
                                .setFontSize(8)
                        )
                        .setWrapStrategy("Wrap")));

        middleCellLine2.add( new CellData()
                .setUserEnteredValue(new ExtendedValue()
                        .setStringValue(middleDataLine2))
                .setUserEnteredFormat(new CellFormat()
                        .setTextFormat(new TextFormat()
                                .setFontSize(8)
                        )
                        .setWrapStrategy("Wrap")));

        middleCellLine3.add( new CellData()
                .setUserEnteredValue(new ExtendedValue()
                        .setStringValue(middleDataLine3))
                .setUserEnteredFormat(new CellFormat()
                        .setTextFormat(new TextFormat()
                                .setFontSize(8)
                        )
                        .setWrapStrategy("Wrap")));



        if(shift == 0 || shift == 1) {
            requests.add(new Request()
                    .setUpdateCells(new UpdateCellsRequest()
                            .setRows(Arrays.asList(
                                    new RowData().setValues(middleCellLine1)))
                            .setStart(new GridCoordinate()
                                    .setSheetId(1656413616)
                                    .setRowIndex(6)
                                    .setColumnIndex(shift))
                            .setFields("userEnteredValue,userEnteredFormat")));
            requests.add(new Request()
                    .setUpdateCells(new UpdateCellsRequest()
                            .setRows(Arrays.asList(
                                    new RowData().setValues(middleCellLine2)))
                            .setStart(new GridCoordinate()
                                    .setSheetId(1656413616)
                                    .setRowIndex(7)
                                    .setColumnIndex(shift))
                            .setFields("userEnteredValue,userEnteredFormat")));
            requests.add(new Request()
                    .setUpdateCells(new UpdateCellsRequest()
                            .setRows(Arrays.asList(
                                    new RowData().setValues(middleCellLine3)))
                            .setStart(new GridCoordinate()
                                    .setSheetId(1656413616)
                                    .setRowIndex(8)
                                    .setColumnIndex(shift))
                            .setFields("userEnteredValue,userEnteredFormat")));

        }
        else if(shift == 3){
            requests.add(new Request()
                    .setUpdateCells(new UpdateCellsRequest()
                            .setRows(Arrays.asList(
                                    new RowData().setValues(middleCellLine1)))
                            .setStart(new GridCoordinate()
                                    .setSheetId(1656413616)
                                    .setRowIndex(6)
                                    .setColumnIndex(shift-1))
                            .setFields("userEnteredValue,userEnteredFormat")));
            requests.add(new Request()
                    .setUpdateCells(new UpdateCellsRequest()
                            .setRows(Arrays.asList(
                                    new RowData().setValues(middleCellLine2)))
                            .setStart(new GridCoordinate()
                                    .setSheetId(1656413616)
                                    .setRowIndex(7)
                                    .setColumnIndex(shift-1))
                            .setFields("userEnteredValue,userEnteredFormat")));
            requests.add(new Request()
                    .setUpdateCells(new UpdateCellsRequest()
                            .setRows(Arrays.asList(
                                    new RowData().setValues(middleCellLine3)))
                            .setStart(new GridCoordinate()
                                    .setSheetId(1656413616)
                                    .setRowIndex(8)
                                    .setColumnIndex(shift-1))
                            .setFields("userEnteredValue,userEnteredFormat")));
        }
        BatchUpdateSpreadsheetRequest body = new BatchUpdateSpreadsheetRequest().setRequests(requests);
        BatchUpdateSpreadsheetResponse response = service.spreadsheets()
                .batchUpdate(spreadsheetId, body).execute();
    }

    private void setCurryDuckListValues(List<List<List<Student>>> students, int day, int shift) throws IOException, GeneralSecurityException{
        final NetHttpTransport HTTP_TRANSPORT = GoogleNetHttpTransport.newTrustedTransport();
        final String spreadsheetId = "1BuWoL8uGgCgx24TKtDjx-j8406BZ36xbaGyOq359sfA";


        Sheets service = new Sheets.Builder(HTTP_TRANSPORT, JSON_FACTORY, getCredentials(HTTP_TRANSPORT))
                .setApplicationName(APPLICATION_NAME)
                .build();


        List<Request> requests = new ArrayList<>();

        List<CellData> curryCellLine1 = new ArrayList<>();
        List<CellData> curryCellLine2 = new ArrayList<>();
        List<CellData> curryCellLine3 = new ArrayList<>();
        String curryDataLine1 = "";
        String curryDataLine2 = "";
        String curryDataLine3 = "";

        if(students.get(6).get(shift).size() > 0){
            for(int i = 0; i < students.get(6).get(shift).size(); i++){
                if(i == 2) break;
                curryDataLine1 += students.get(6).get(shift).get(i).getName() + " (" +students.get(6).get(shift).get(i).getSchedule().get(day) + "-" + students.get(6).get(shift).get(i).getSchedule().get(day+1)+")" + ", ";
            }
            if( students.get(6).get(shift).size() > 2){
                for(int i = 2; i < students.get(6).get(shift).size(); i++){
                    if(i==4) break;
                    curryDataLine2 += students.get(6).get(shift).get(i).getName() + " (" +students.get(6).get(shift).get(i).getSchedule().get(day) + "-" + students.get(6).get(shift).get(i).getSchedule().get(day+1)+")" + ", ";
                }
            }
            if( students.get(6).get(shift).size() > 4){
                for(int i = 4; i < students.get(6).get(shift).size(); i++){
                    curryDataLine3 += students.get(6).get(shift).get(i).getName() + " (" +students.get(6).get(shift).get(i).getSchedule().get(day) + "-" + students.get(6).get(shift).get(i).getSchedule().get(day+1)+")" + ", ";
                }
            }


        }
        if(shift==1 && students.get(6).get(shift+1).size() > 0){
            if(students.get(6).get(shift).size() < 3)
            {
                for(int i = 0; i < students.get(6).get(shift+1).size(); i++){
                    if(i == 2) break;
                    curryDataLine2 += students.get(6).get(shift+1).get(i).getName() + " (" +students.get(6).get(shift+1).get(i).getSchedule().get(day) + "-" + students.get(6).get(shift+1).get(i).getSchedule().get(day+1)+")" + ", ";
                }
                if( students.get(6).get(shift+1).size() > 2){
                    for(int i = 2; i < students.get(6).get(shift+1).size(); i++){
                        curryDataLine3 += students.get(6).get(shift+1).get(i).getName() + " (" +students.get(6).get(shift+1).get(i).getSchedule().get(day) + "-" + students.get(6).get(shift+1).get(i).getSchedule().get(day+1)+")" + ", ";
                    }
                }
            }
            else if(students.get(6).get(shift).size() == 3){

                curryDataLine2 += students.get(6).get(shift+1).get(0).getName() + " (" +students.get(6).get(shift+1).get(0).getSchedule().get(day) + "-" + students.get(6).get(shift+1).get(0).getSchedule().get(day+1)+")" + ", ";
                if( students.get(6).get(shift+1).size() > 1){
                    for(int i = 1; i < students.get(6).get(shift+1).size(); i++){
                        curryDataLine3 += students.get(6).get(shift+1).get(i).getName() + " (" +students.get(6).get(shift+1).get(i).getSchedule().get(day) + "-" + students.get(6).get(shift+1).get(i).getSchedule().get(day+1)+")" + ", ";
                    }
                }
            }
            else if(students.get(6).get(shift).size() > 3){
                for(int i = 0; i < students.get(6).get(shift+1).size(); i++){
                    curryDataLine3 += students.get(6).get(shift+1).get(i).getName() + " (" +students.get(6).get(shift+1).get(i).getSchedule().get(day) + "-" + students.get(6).get(shift+1).get(i).getSchedule().get(day+1)+")" + ", ";
                }

            }
        }
        curryCellLine1.add( new CellData()
                .setUserEnteredValue(new ExtendedValue()
                        .setStringValue(curryDataLine1))
                .setUserEnteredFormat(new CellFormat()
                        .setTextFormat(new TextFormat()
                                .setFontSize(8)
                        )
                        .setWrapStrategy("Wrap")));

        curryCellLine2.add( new CellData()
                .setUserEnteredValue(new ExtendedValue()
                        .setStringValue(curryDataLine2))
                .setUserEnteredFormat(new CellFormat()
                        .setTextFormat(new TextFormat()
                                .setFontSize(8)
                        )
                        .setWrapStrategy("Wrap")));

        curryCellLine3.add( new CellData()
                .setUserEnteredValue(new ExtendedValue()
                        .setStringValue(curryDataLine3))
                .setUserEnteredFormat(new CellFormat()
                        .setTextFormat(new TextFormat()
                                .setFontSize(8)
                        )
                        .setWrapStrategy("Wrap")));



        if(shift == 0 || shift == 1) {
            requests.add(new Request()
                    .setUpdateCells(new UpdateCellsRequest()
                            .setRows(Arrays.asList(
                                    new RowData().setValues(curryCellLine1)))
                            .setStart(new GridCoordinate()
                                    .setSheetId(1656413616)
                                    .setRowIndex(10)
                                    .setColumnIndex(shift))
                            .setFields("userEnteredValue,userEnteredFormat")));
            requests.add(new Request()
                    .setUpdateCells(new UpdateCellsRequest()
                            .setRows(Arrays.asList(
                                    new RowData().setValues(curryCellLine2)))
                            .setStart(new GridCoordinate()
                                    .setSheetId(1656413616)
                                    .setRowIndex(11)
                                    .setColumnIndex(shift))
                            .setFields("userEnteredValue,userEnteredFormat")));
            requests.add(new Request()
                    .setUpdateCells(new UpdateCellsRequest()
                            .setRows(Arrays.asList(
                                    new RowData().setValues(curryCellLine3)))
                            .setStart(new GridCoordinate()
                                    .setSheetId(1656413616)
                                    .setRowIndex(12)
                                    .setColumnIndex(shift))
                            .setFields("userEnteredValue,userEnteredFormat")));

        }
        else if(shift == 3){
            requests.add(new Request()
                    .setUpdateCells(new UpdateCellsRequest()
                            .setRows(Arrays.asList(
                                    new RowData().setValues(curryCellLine1)))
                            .setStart(new GridCoordinate()
                                    .setSheetId(1656413616)
                                    .setRowIndex(10)
                                    .setColumnIndex(shift-1))
                            .setFields("userEnteredValue,userEnteredFormat")));
            requests.add(new Request()
                    .setUpdateCells(new UpdateCellsRequest()
                            .setRows(Arrays.asList(
                                    new RowData().setValues(curryCellLine2)))
                            .setStart(new GridCoordinate()
                                    .setSheetId(1656413616)
                                    .setRowIndex(11)
                                    .setColumnIndex(shift-1))
                            .setFields("userEnteredValue,userEnteredFormat")));
            requests.add(new Request()
                    .setUpdateCells(new UpdateCellsRequest()
                            .setRows(Arrays.asList(
                                    new RowData().setValues(curryCellLine3)))
                            .setStart(new GridCoordinate()
                                    .setSheetId(1656413616)
                                    .setRowIndex(12)
                                    .setColumnIndex(shift-1))
                            .setFields("userEnteredValue,userEnteredFormat")));
        }
        BatchUpdateSpreadsheetRequest body = new BatchUpdateSpreadsheetRequest().setRequests(requests);
        BatchUpdateSpreadsheetResponse response = service.spreadsheets()
                .batchUpdate(spreadsheetId, body).execute();
    }

    private void setGrangeDuckListValues(List<List<List<Student>>> students, int day, int shift) throws IOException, GeneralSecurityException{
        final NetHttpTransport HTTP_TRANSPORT = GoogleNetHttpTransport.newTrustedTransport();
        final String spreadsheetId = "1BuWoL8uGgCgx24TKtDjx-j8406BZ36xbaGyOq359sfA";


        Sheets service = new Sheets.Builder(HTTP_TRANSPORT, JSON_FACTORY, getCredentials(HTTP_TRANSPORT))
                .setApplicationName(APPLICATION_NAME)
                .build();


        List<Request> requests = new ArrayList<>();

        List<CellData> grangeCellLine1 = new ArrayList<>();
        List<CellData> grangeCellLine2 = new ArrayList<>();
        List<CellData> grangeCellLine3 = new ArrayList<>();
        String grangeDataLine1 = "";
        String grangeDataLine2 = "";
        String grangeDataLine3 = "";

        if(students.get(7).get(shift).size() > 0){
            for(int i = 0; i < students.get(7).get(shift).size(); i++){
                if(i == 2) break;
                grangeDataLine1 += students.get(7).get(shift).get(i).getName() + " (" +students.get(7).get(shift).get(i).getSchedule().get(day) + "-" + students.get(7).get(shift).get(i).getSchedule().get(day+1)+")" + ", ";
            }
            if( students.get(7).get(shift).size() > 2){
                for(int i = 2; i < students.get(7).get(shift).size(); i++){
                    if(i==4) break;
                    grangeDataLine2 += students.get(7).get(shift).get(i).getName() + " (" +students.get(7).get(shift).get(i).getSchedule().get(day) + "-" + students.get(7).get(shift).get(i).getSchedule().get(day+1)+")" + ", ";
                }
            }
            if( students.get(7).get(shift).size() > 4){
                for(int i = 4; i < students.get(7).get(shift).size(); i++){
                    grangeDataLine3 += students.get(7).get(shift).get(i).getName() + " (" +students.get(7).get(shift).get(i).getSchedule().get(day) + "-" + students.get(7).get(shift).get(i).getSchedule().get(day+1)+")" + ", ";
                }
            }


        }
        if(shift==1 && students.get(7).get(shift+1).size() > 0){
            if(students.get(7).get(shift).size() < 3)
            {
                for(int i = 0; i < students.get(7).get(shift+1).size(); i++){
                    if(i == 2) break;
                    grangeDataLine2 += students.get(7).get(shift+1).get(i).getName() + " (" +students.get(7).get(shift+1).get(i).getSchedule().get(day) + "-" + students.get(7).get(shift+1).get(i).getSchedule().get(day+1)+")" + ", ";
                }
                if( students.get(7).get(shift+1).size() > 2){
                    for(int i = 2; i < students.get(7).get(shift+1).size(); i++){
                        grangeDataLine3 += students.get(7).get(shift+1).get(i).getName() + " (" +students.get(7).get(shift+1).get(i).getSchedule().get(day) + "-" + students.get(7).get(shift+1).get(i).getSchedule().get(day+1)+")" + ", ";
                    }
                }
            }
            else if(students.get(7).get(shift).size() == 3){

                grangeDataLine2 += students.get(7).get(shift+1).get(0).getName() + " (" +students.get(7).get(shift+1).get(0).getSchedule().get(day) + "-" + students.get(7).get(shift+1).get(0).getSchedule().get(day+1)+")" + ", ";
                if( students.get(7).get(shift+1).size() > 1){
                    for(int i = 1; i < students.get(7).get(shift+1).size(); i++){
                        grangeDataLine3 += students.get(7).get(shift+1).get(i).getName() + " (" +students.get(7).get(shift+1).get(i).getSchedule().get(day) + "-" + students.get(7).get(shift+1).get(i).getSchedule().get(day+1)+")" + ", ";
                    }
                }
            }
            else if(students.get(7).get(shift).size() > 3){
                for(int i = 0; i < students.get(7).get(shift+1).size(); i++){
                    grangeDataLine3 += students.get(7).get(shift+1).get(i).getName() + " (" +students.get(7).get(shift+1).get(i).getSchedule().get(day) + "-" + students.get(7).get(shift+1).get(i).getSchedule().get(day+1)+")" + ", ";
                }

            }
        }
        grangeCellLine1.add( new CellData()
                .setUserEnteredValue(new ExtendedValue()
                        .setStringValue(grangeDataLine1))
                .setUserEnteredFormat(new CellFormat()
                        .setTextFormat(new TextFormat()
                                .setFontSize(8)
                        )
                        .setWrapStrategy("Wrap")));

        grangeCellLine2.add( new CellData()
                .setUserEnteredValue(new ExtendedValue()
                        .setStringValue(grangeDataLine2))
                .setUserEnteredFormat(new CellFormat()
                        .setTextFormat(new TextFormat()
                                .setFontSize(8)
                        )
                        .setWrapStrategy("Wrap")));

        grangeCellLine3.add( new CellData()
                .setUserEnteredValue(new ExtendedValue()
                        .setStringValue(grangeDataLine3))
                .setUserEnteredFormat(new CellFormat()
                        .setTextFormat(new TextFormat()
                                .setFontSize(8)
                        )
                        .setWrapStrategy("Wrap")));



        if(shift == 0 || shift == 1) {
            requests.add(new Request()
                    .setUpdateCells(new UpdateCellsRequest()
                            .setRows(Arrays.asList(
                                    new RowData().setValues(grangeCellLine1)))
                            .setStart(new GridCoordinate()
                                    .setSheetId(1656413616)
                                    .setRowIndex(14)
                                    .setColumnIndex(shift))
                            .setFields("userEnteredValue,userEnteredFormat")));
            requests.add(new Request()
                    .setUpdateCells(new UpdateCellsRequest()
                            .setRows(Arrays.asList(
                                    new RowData().setValues(grangeCellLine2)))
                            .setStart(new GridCoordinate()
                                    .setSheetId(1656413616)
                                    .setRowIndex(15)
                                    .setColumnIndex(shift))
                            .setFields("userEnteredValue,userEnteredFormat")));
            requests.add(new Request()
                    .setUpdateCells(new UpdateCellsRequest()
                            .setRows(Arrays.asList(
                                    new RowData().setValues(grangeCellLine3)))
                            .setStart(new GridCoordinate()
                                    .setSheetId(1656413616)
                                    .setRowIndex(16)
                                    .setColumnIndex(shift))
                            .setFields("userEnteredValue,userEnteredFormat")));

        }
        else if(shift == 3){
            requests.add(new Request()
                    .setUpdateCells(new UpdateCellsRequest()
                            .setRows(Arrays.asList(
                                    new RowData().setValues(grangeCellLine1)))
                            .setStart(new GridCoordinate()
                                    .setSheetId(1656413616)
                                    .setRowIndex(14)
                                    .setColumnIndex(shift-1))
                            .setFields("userEnteredValue,userEnteredFormat")));
            requests.add(new Request()
                    .setUpdateCells(new UpdateCellsRequest()
                            .setRows(Arrays.asList(
                                    new RowData().setValues(grangeCellLine2)))
                            .setStart(new GridCoordinate()
                                    .setSheetId(1656413616)
                                    .setRowIndex(15)
                                    .setColumnIndex(shift-1))
                            .setFields("userEnteredValue,userEnteredFormat")));
            requests.add(new Request()
                    .setUpdateCells(new UpdateCellsRequest()
                            .setRows(Arrays.asList(
                                    new RowData().setValues(grangeCellLine3)))
                            .setStart(new GridCoordinate()
                                    .setSheetId(1656413616)
                                    .setRowIndex(16)
                                    .setColumnIndex(shift-1))
                            .setFields("userEnteredValue,userEnteredFormat")));
        }
        BatchUpdateSpreadsheetRequest body = new BatchUpdateSpreadsheetRequest().setRequests(requests);
        BatchUpdateSpreadsheetResponse response = service.spreadsheets()
                .batchUpdate(spreadsheetId, body).execute();
    }

    private void setToastDuckListValues(List<List<List<Student>>> students, int day, int shift) throws IOException, GeneralSecurityException{
        final NetHttpTransport HTTP_TRANSPORT = GoogleNetHttpTransport.newTrustedTransport();
        final String spreadsheetId = "1BuWoL8uGgCgx24TKtDjx-j8406BZ36xbaGyOq359sfA";


        Sheets service = new Sheets.Builder(HTTP_TRANSPORT, JSON_FACTORY, getCredentials(HTTP_TRANSPORT))
                .setApplicationName(APPLICATION_NAME)
                .build();


        List<Request> requests = new ArrayList<>();

        List<CellData> toastCellLine1 = new ArrayList<>();
        List<CellData> toastCellLine2 = new ArrayList<>();
        List<CellData> toastCellLine3 = new ArrayList<>();
        List<CellData> toastCellLine4 = new ArrayList<>();
        String toastDataLine1 = "";
        String toastDataLine2 = "";
        String toastDataLine3 = "";
        String toastDataLine4 = "";

        if(students.get(4).get(shift).size() > 0) {
            for (int i = 0; i < students.get(4).get(shift).size(); i++) {
                if (i == 2) break;
                toastDataLine1 += students.get(4).get(shift).get(i).getName() + " (" + students.get(4).get(shift).get(i).getSchedule().get(day) + "-" + students.get(4).get(shift).get(i).getSchedule().get(day + 1) + ")" + ", ";
            }
            if (students.get(4).get(shift).size() > 2) {
                for (int i = 2; i < students.get(4).get(shift).size(); i++) {
                    if (i == 4) break;
                    toastDataLine2 += students.get(4).get(shift).get(i).getName() + " (" + students.get(4).get(shift).get(i).getSchedule().get(day) + "-" + students.get(4).get(shift).get(i).getSchedule().get(day + 1) + ")" + ", ";
                }
            }
            if (students.get(4).get(shift).size() > 4) {
                for (int i = 4; i < students.get(4).get(shift).size(); i++) {
                    if (i == 6) break;
                    toastDataLine3 += students.get(4).get(shift).get(i).getName() + " (" + students.get(4).get(shift).get(i).getSchedule().get(day) + "-" + students.get(4).get(shift).get(i).getSchedule().get(day + 1) + ")" + ", ";
                }
            }
            if (students.get(4).get(shift).size() > 6) {
                for (int i = 6; i < students.get(4).get(shift).size(); i++) {
                    toastDataLine4 += students.get(4).get(shift).get(i).getName() + " (" + students.get(4).get(shift).get(i).getSchedule().get(day) + "-" + students.get(4).get(shift).get(i).getSchedule().get(day + 1) + ")" + ", ";
                }
            }
        }
        if(shift == 1 && students.get(4).get(shift+1).size() > 0){
            if(students.get(4).get(shift).size() < 3){
                for(int i = 0; i < students.get(4).get(shift+1).size(); i++){
                    if(i==2)break;
                    toastDataLine2 += students.get(4).get(shift+1).get(i).getName() + " (" +students.get(4).get(shift+1).get(i).getSchedule().get(day) + "-" + students.get(4).get(shift+1).get(i).getSchedule().get(day+1)+")" + ", ";
                }
                if(students.get(4).get(shift+1).size() > 2){
                    for(int i = 2; i < students.get(4).get(shift+1).size(); i++){
                        if(i == 4) break;
                        toastDataLine3 += students.get(4).get(shift+1).get(i).getName() + " (" +students.get(4).get(shift+1).get(i).getSchedule().get(day) + "-" + students.get(4).get(shift+1).get(i).getSchedule().get(day+1)+")" + ", ";
                    }
                }
                if(students.get(4).get(shift+1).size() > 4){
                    for(int i = 4; i < students.get(4).get(shift+1).size(); i++){
                        toastDataLine4 += students.get(4).get(shift+1).get(i).getName() + " (" +students.get(4).get(shift+1).get(i).getSchedule().get(day) + "-" + students.get(4).get(shift+1).get(i).getSchedule().get(day+1)+")" + ", ";
                    }
                }
            }
            else if(students.get(4).get(shift).size() >= 3 &&  students.get(4).get(shift).size() < 6){
                for(int i = 0; i < students.get(4).get(shift+1).size(); i++){
                    if(i == 2) break;
                    toastDataLine3 += students.get(4).get(shift+1).get(i).getName() + " (" +students.get(4).get(shift+1).get(i).getSchedule().get(day) + "-" + students.get(4).get(shift+1).get(i).getSchedule().get(day+1)+")" + ", ";
                }
            }
                if(students.get(4).get(shift+1).size() > 2){
                    for(int i = 2; i < students.get(4).get(shift+1).size(); i++){
                        toastDataLine4 += students.get(4).get(shift+1).get(i).getName() + " (" +students.get(4).get(shift+1).get(i).getSchedule().get(day) + "-" + students.get(4).get(shift+1).get(i).getSchedule().get(day+1)+")" + ", ";
                    }
                }
            }
            else if(students.get(4).get(shift).size() >= 6){
                for(int i = 0; i < students.get(4).get(shift+1).size(); i++){
                    toastDataLine4 += students.get(4).get(shift+1).get(i).getName() + " (" +students.get(4).get(shift+1).get(i).getSchedule().get(day) + "-" + students.get(4).get(shift+1).get(i).getSchedule().get(day+1)+")" + ", ";
                }
        }

        toastCellLine1.add( new CellData()
                .setUserEnteredValue(new ExtendedValue()
                        .setStringValue(toastDataLine1))
                .setUserEnteredFormat(new CellFormat()
                        .setTextFormat(new TextFormat()
                                .setFontSize(8)
                                )
                        .setWrapStrategy("Wrap")));

        toastCellLine2.add( new CellData()
                .setUserEnteredValue(new ExtendedValue()
                        .setStringValue(toastDataLine2))
                .setUserEnteredFormat(new CellFormat()
                        .setTextFormat(new TextFormat()
                                .setFontSize(8)
                        )
                        .setWrapStrategy("Wrap")));

        toastCellLine3.add( new CellData()
                .setUserEnteredValue(new ExtendedValue()
                        .setStringValue(toastDataLine3))
                .setUserEnteredFormat(new CellFormat()
                        .setTextFormat(new TextFormat()
                                .setFontSize(8)
                        )
                        .setWrapStrategy("Wrap")));

        toastCellLine4.add( new CellData()
                .setUserEnteredValue(new ExtendedValue()
                        .setStringValue(toastDataLine4))
                .setUserEnteredFormat(new CellFormat()
                        .setTextFormat(new TextFormat()
                                .setFontSize(8)
                        )
                        .setWrapStrategy("Wrap")));

        if(shift == 0 || shift == 1) {
            requests.add(new Request()
                    .setUpdateCells(new UpdateCellsRequest()
                            .setRows(Arrays.asList(
                                    new RowData().setValues(toastCellLine1)))
                            .setStart(new GridCoordinate()
                                    .setSheetId(1656413616)
                                    .setRowIndex(19)
                                    .setColumnIndex(shift))
                            .setFields("userEnteredValue,userEnteredFormat")));
            requests.add(new Request()
                    .setUpdateCells(new UpdateCellsRequest()
                            .setRows(Arrays.asList(
                                    new RowData().setValues(toastCellLine2)))
                            .setStart(new GridCoordinate()
                                    .setSheetId(1656413616)
                                    .setRowIndex(20)
                                    .setColumnIndex(shift))
                            .setFields("userEnteredValue,userEnteredFormat")));
            requests.add(new Request()
                    .setUpdateCells(new UpdateCellsRequest()
                            .setRows(Arrays.asList(
                                    new RowData().setValues(toastCellLine3)))
                            .setStart(new GridCoordinate()
                                    .setSheetId(1656413616)
                                    .setRowIndex(21)
                                    .setColumnIndex(shift))
                            .setFields("userEnteredValue,userEnteredFormat")));
            requests.add(new Request()
                    .setUpdateCells(new UpdateCellsRequest()
                            .setRows(Arrays.asList(
                                    new RowData().setValues(toastCellLine4)))
                            .setStart(new GridCoordinate()
                                    .setSheetId(1656413616)
                                    .setRowIndex(22)
                                    .setColumnIndex(shift))
                            .setFields("userEnteredValue,userEnteredFormat")));
        }
        else if(shift == 3){
            requests.add(new Request()
                    .setUpdateCells(new UpdateCellsRequest()
                            .setRows(Arrays.asList(
                                    new RowData().setValues(toastCellLine1)))
                            .setStart(new GridCoordinate()
                                    .setSheetId(1656413616)
                                    .setRowIndex(19)
                                    .setColumnIndex(shift-1))
                            .setFields("userEnteredValue,userEnteredFormat")));
            requests.add(new Request()
                    .setUpdateCells(new UpdateCellsRequest()
                            .setRows(Arrays.asList(
                                    new RowData().setValues(toastCellLine2)))
                            .setStart(new GridCoordinate()
                                    .setSheetId(1656413616)
                                    .setRowIndex(20)
                                    .setColumnIndex(shift-1))
                            .setFields("userEnteredValue,userEnteredFormat")));
            requests.add(new Request()
                    .setUpdateCells(new UpdateCellsRequest()
                            .setRows(Arrays.asList(
                                    new RowData().setValues(toastCellLine3)))
                            .setStart(new GridCoordinate()
                                    .setSheetId(1656413616)
                                    .setRowIndex(21)
                                    .setColumnIndex(shift-1))
                            .setFields("userEnteredValue,userEnteredFormat")));
            requests.add(new Request()
                    .setUpdateCells(new UpdateCellsRequest()
                            .setRows(Arrays.asList(
                                    new RowData().setValues(toastCellLine4)))
                            .setStart(new GridCoordinate()
                                    .setSheetId(1656413616)
                                    .setRowIndex(22)
                                    .setColumnIndex(shift-1))
                            .setFields("userEnteredValue,userEnteredFormat")));
        }
        BatchUpdateSpreadsheetRequest body = new BatchUpdateSpreadsheetRequest().setRequests(requests);
        BatchUpdateSpreadsheetResponse response = service.spreadsheets()
                .batchUpdate(spreadsheetId, body).execute();
    }

    private void setDuckListValues(List<List<List<Student>>> students, int day, int shift, int station, int index) throws IOException, GeneralSecurityException {
        final NetHttpTransport HTTP_TRANSPORT = GoogleNetHttpTransport.newTrustedTransport();
        final String spreadsheetId = "1BuWoL8uGgCgx24TKtDjx-j8406BZ36xbaGyOq359sfA";

        Sheets service = new Sheets.Builder(HTTP_TRANSPORT, JSON_FACTORY, getCredentials(HTTP_TRANSPORT))
                .setApplicationName(APPLICATION_NAME)
                .build();


        List<Request> requests = new ArrayList<>();

        List<CellData> cellLine1 = new ArrayList<>();
        List<CellData> cellLine2 = new ArrayList<>();
        String dataLine1 = "";
        String dataLine2 = "";
        if (students.get(station).get(shift).size() > 0) {
            for (int i = 0; i < students.get(station).get(shift).size(); i++) {
                if (i == 2) break;
                dataLine1 += students.get(station).get(shift).get(i).getName() + " (" + students.get(station).get(shift).get(i).getSchedule().get(day) + "-" + students.get(station).get(shift).get(i).getSchedule().get(day + 1) + "), ";
            }
            if (students.get(station).get(shift).size() > 2) {
                for (int i = 2; i < students.get(station).get(shift).size(); i++) {
                    dataLine2 += students.get(station).get(shift).get(i).getName() + " (" + students.get(station).get(shift).get(i).getSchedule().get(day) + "-" + students.get(station).get(shift).get(i).getSchedule().get(day + 1) + "), ";
                }
            }
        }
        if (shift == 1 && students.get(station).get(shift + 1).size() > 0) {
            if (students.get(station).get(shift).size() < 2) {
                dataLine1 += students.get(station).get(shift + 1).get(0).getName() + " (" + students.get(station).get(shift + 1).get(0).getSchedule().get(day) + "-" + students.get(station).get(shift + 1).get(0).getSchedule().get(day + 1) + "), ";
                if (students.get(station).get(shift + 1).size() > 1) {
                    for (int i = 1; i < students.get(station).get(shift + 1).size(); i++) {
                        dataLine2 += students.get(station).get(shift + 1).get(i).getName() + " (" + students.get(station).get(shift + 1).get(i).getSchedule().get(day) + "-" + students.get(station).get(shift + 1).get(i).getSchedule().get(day + 1) + "), ";
                    }
                }
            } else {
                for (int i = 0; i < students.get(station).get(shift + 1).size(); i++) {
                    dataLine2 += students.get(station).get(shift + 1).get(i).getName() + " (" + students.get(station).get(shift + 1).get(i).getSchedule().get(day) + "-" + students.get(station).get(shift + 1).get(i).getSchedule().get(day + 1) + "), ";
                }
            }
        }
        cellLine1.add(new CellData()
                .setUserEnteredValue(new ExtendedValue()
                        .setStringValue(dataLine1))
                .setUserEnteredFormat(new CellFormat()
                        .setTextFormat(new TextFormat()
                                .setFontSize(8)
                        )
                        .setWrapStrategy("Wrap")));

        cellLine2.add(new CellData()
                .setUserEnteredValue(new ExtendedValue()
                        .setStringValue(dataLine2))
                .setUserEnteredFormat(new CellFormat()
                        .setTextFormat(new TextFormat()
                                .setFontSize(8)
                        )
                        .setWrapStrategy("Wrap")));

        if (shift == 0 || shift == 1) {
            requests.add(new Request()
                    .setUpdateCells(new UpdateCellsRequest()
                            .setRows(Arrays.asList(
                                    new RowData().setValues(cellLine1)))
                            .setStart(new GridCoordinate()
                                    .setSheetId(1656413616)
                                    .setRowIndex(index)
                                    .setColumnIndex(shift))
                            .setFields("userEnteredValue,userEnteredFormat")));
            requests.add(new Request()
                    .setUpdateCells(new UpdateCellsRequest()
                            .setRows(Arrays.asList(
                                    new RowData().setValues(cellLine2)))
                            .setStart(new GridCoordinate()
                                    .setSheetId(1656413616)
                                    .setRowIndex(index+1)
                                    .setColumnIndex(shift))
                            .setFields("userEnteredValue,userEnteredFormat")));
        }
        if (shift == 3) {
            requests.add(new Request()
                    .setUpdateCells(new UpdateCellsRequest()
                            .setRows(Arrays.asList(
                                    new RowData().setValues(cellLine1)))
                            .setStart(new GridCoordinate()
                                    .setSheetId(1656413616)
                                    .setRowIndex(index)
                                    .setColumnIndex(shift - 1))
                            .setFields("userEnteredValue,userEnteredFormat")));
            requests.add(new Request()
                    .setUpdateCells(new UpdateCellsRequest()
                            .setRows(Arrays.asList(
                                    new RowData().setValues(cellLine2)))
                            .setStart(new GridCoordinate()
                                    .setSheetId(1656413616)
                                    .setRowIndex(index+1)
                                    .setColumnIndex(shift - 1))
                            .setFields("userEnteredValue,userEnteredFormat")));
        }
        BatchUpdateSpreadsheetRequest body = new BatchUpdateSpreadsheetRequest().setRequests(requests);
        BatchUpdateSpreadsheetResponse response = service.spreadsheets()
                .batchUpdate(spreadsheetId, body).execute();


    }

    private void setDishDuckListValues(List<List<List<Student>>> students, int day, int shift) throws IOException, GeneralSecurityException{
        final NetHttpTransport HTTP_TRANSPORT = GoogleNetHttpTransport.newTrustedTransport();
        final String spreadsheetId = "1BuWoL8uGgCgx24TKtDjx-j8406BZ36xbaGyOq359sfA";


        Sheets service = new Sheets.Builder(HTTP_TRANSPORT, JSON_FACTORY, getCredentials(HTTP_TRANSPORT))
                .setApplicationName(APPLICATION_NAME)
                .build();


        List<Request> requests = new ArrayList<>();

        List<CellData> dishCellLine1 = new ArrayList<>();
        List<CellData> dishCellLine2 = new ArrayList<>();
        List<CellData> dishCellLine3 = new ArrayList<>();
        List<CellData> dishCellLine4 = new ArrayList<>();
        List<CellData> dishCellLine5 = new ArrayList<>();
        List<CellData> dishCellLine6 = new ArrayList<>();
        List<CellData> dishCellLine7 = new ArrayList<>();
        String dishDataLine1 = "";
        String dishDataLine2 = "";
        String dishDataLine3 = "";
        String dishDataLine4 = "";
        String dishDataLine5 = "";
        String dishDataLine6 = "";
        String dishDataLine7 = "";

        if(students.get(8).get(shift).size() > 0){
            for(int i = 0; i < students.get(8).get(shift).size(); i++){
                if(i == 2)break;
                dishDataLine1 += students.get(8).get(shift).get(i).getName() + " (" + students.get(8).get(shift).get(i).getSchedule().get(day) + "-" + students.get(8).get(shift).get(i).getSchedule().get(day + 1) + "), ";
            }
            if(students.get(8).get(shift).size() > 2){
                for(int i = 2; i < students.get(8).get(shift).size(); i++){
                    if(i == 4)break;
                    dishDataLine2 += students.get(8).get(shift).get(i).getName() + " (" + students.get(8).get(shift).get(i).getSchedule().get(day) + "-" + students.get(8).get(shift).get(i).getSchedule().get(day + 1) + "), ";
                }
            }
            if(students.get(8).get(shift).size() > 4){
                for(int i = 4; i < students.get(8).get(shift).size(); i++){
                    if(i == 6)break;
                    dishDataLine3 += students.get(8).get(shift).get(i).getName() + " (" + students.get(8).get(shift).get(i).getSchedule().get(day) + "-" + students.get(8).get(shift).get(i).getSchedule().get(day + 1) + "), ";
                }
            }
            if(students.get(8).get(shift).size() > 6){
                for(int i = 6; i < students.get(8).get(shift).size(); i++){
                    if( i == 8) break;
                    dishDataLine4 += students.get(8).get(shift).get(i).getName() + " (" + students.get(8).get(shift).get(i).getSchedule().get(day) + "-" + students.get(8).get(shift).get(i).getSchedule().get(day + 1) + "), ";
                }
            }
            if(students.get(8).get(shift).size() > 8){
                for(int i = 8; i < students.get(8).get(shift).size(); i++){
                    if(i == 10)break;
                    dishDataLine5 += students.get(8).get(shift).get(i).getName() + " (" + students.get(8).get(shift).get(i).getSchedule().get(day) + "-" + students.get(8).get(shift).get(i).getSchedule().get(day + 1) + "), ";
                }
            }
            if(students.get(8).get(shift).size() > 10){
                for(int i = 10; i < students.get(8).get(shift).size(); i++){
                    if(i == 12)break;
                    dishDataLine6 += students.get(8).get(shift).get(i).getName() + " (" + students.get(8).get(shift).get(i).getSchedule().get(day) + "-" + students.get(8).get(shift).get(i).getSchedule().get(day + 1) + ")";
                }
            }
            if(students.get(8).get(shift).size() > 12){
                for(int i = 12; i < students.get(8).get(shift).size(); i++){
                    dishDataLine7 += students.get(8).get(shift).get(i).getName() + " (" + students.get(8).get(shift).get(i).getSchedule().get(day) + "-" + students.get(8).get(shift).get(i).getSchedule().get(day + 1) + "), ";
                }
            }
        }
        if(shift == 1 && students.get(8).get(shift+1).size() > 0){
            if(students.get(8).get(shift).size() < 2){
                dishDataLine1 += students.get(8).get(shift+1).get(0).getName() + " (" + students.get(8).get(shift+1).get(0).getSchedule().get(day) + "-" + students.get(8).get(shift+1).get(0).getSchedule().get(day + 1) + "), ";
                if(students.get(8).get(shift+1).size() > 1){
                    for(int i = 1; i < students.get(8).get(shift+1).size(); i++){
                        if(i == 3)break;
                        dishDataLine2 += students.get(8).get(shift+1).get(i).getName() + " (" + students.get(8).get(shift+1).get(i).getSchedule().get(day) + "-" + students.get(8).get(shift+1).get(i).getSchedule().get(day + 1) + "), ";
                    }
                }
                if(students.get(8).get(shift+1).size() > 3){
                    for(int i = 3; i < students.get(8).get(shift+1).size(); i++){
                        if(i == 5)break;
                        dishDataLine3 += students.get(8).get(shift+1).get(i).getName() + " (" + students.get(8).get(shift+1).get(i).getSchedule().get(day) + "-" + students.get(8).get(shift+1).get(i).getSchedule().get(day + 1) + "), ";
                    }
                }
                if(students.get(8).get(shift+1).size() > 5){
                    for(int i = 5; i < students.get(8).get(shift+1).size(); i++){
                        if( i == 7) break;
                        dishDataLine4 += students.get(8).get(shift+1).get(i).getName() + " (" + students.get(8).get(shift+1).get(i).getSchedule().get(day) + "-" + students.get(8).get(shift+1).get(i).getSchedule().get(day + 1) + "), ";
                    }
                }
                if(students.get(8).get(shift+1).size() > 7){
                    for(int i = 7; i < students.get(8).get(shift+1).size(); i++){
                        if(i == 9)break;
                        dishDataLine5 += students.get(8).get(shift+1).get(i).getName() + " (" + students.get(8).get(shift+1).get(i).getSchedule().get(day) + "-" + students.get(8).get(shift+1).get(i).getSchedule().get(day + 1) + "), ";
                    }
                }
                if(students.get(8).get(shift+1).size() > 9){
                    for(int i = 9; i < students.get(8).get(shift+1).size(); i++){
                        if(i == 11)break;
                        dishDataLine6 += students.get(8).get(shift+1).get(i).getName() + " (" + students.get(8).get(shift+1).get(i).getSchedule().get(day) + "-" + students.get(8).get(shift+1).get(i).getSchedule().get(day + 1) + "), ";
                    }
                }
                if(students.get(8).get(shift+1).size() > 11){
                    for(int i = 11; i < students.get(8).get(shift+1).size(); i++){
                        dishDataLine7 += students.get(8).get(shift+1).get(i).getName() + " (" + students.get(8).get(shift+1).get(i).getSchedule().get(day) + "-" + students.get(8).get(shift+1).get(i).getSchedule().get(day + 1) + "), ";
                    }
                }
            }
            else if(students.get(8).get(shift).size() == 2){
                for(int i = 0; i < students.get(8).get(shift+1).size(); i++){
                    if(i == 2)break;
                    dishDataLine2 += students.get(8).get(shift+1).get(i).getName() + " (" + students.get(8).get(shift+1).get(i).getSchedule().get(day) + "-" + students.get(8).get(shift+1).get(i).getSchedule().get(day + 1) + "), ";
                }
                if(students.get(8).get(shift+1).size() > 2){
                    for(int i = 2; i < students.get(8).get(shift+1).size(); i++){
                        if(i == 4)break;
                        dishDataLine3 += students.get(8).get(shift+1).get(i).getName() + " (" + students.get(8).get(shift+1).get(i).getSchedule().get(day) + "-" + students.get(8).get(shift+1).get(i).getSchedule().get(day + 1) + "), ";
                    }
                }
                if(students.get(8).get(shift+1).size() > 4){
                    for(int i = 4; i < students.get(8).get(shift+1).size(); i++){
                        if( i == 6) break;
                        dishDataLine4 += students.get(8).get(shift+1).get(i).getName() + " (" + students.get(8).get(shift+1).get(i).getSchedule().get(day) + "-" + students.get(8).get(shift+1).get(i).getSchedule().get(day + 1) + "), ";
                    }
                }
                if(students.get(8).get(shift+1).size() > 6){
                    for(int i = 6; i < students.get(8).get(shift+1).size(); i++){
                        if(i == 8)break;
                        dishDataLine5 += students.get(8).get(shift+1).get(i).getName() + " (" + students.get(8).get(shift+1).get(i).getSchedule().get(day) + "-" + students.get(8).get(shift+1).get(i).getSchedule().get(day + 1) + "), ";
                    }
                }
                if(students.get(8).get(shift+1).size() > 8){
                    for(int i = 8; i < students.get(8).get(shift+1).size(); i++){
                        if(i == 10)break;
                        dishDataLine6 += students.get(8).get(shift+1).get(i).getName() + " (" + students.get(8).get(shift+1).get(i).getSchedule().get(day) + "-" + students.get(8).get(shift+1).get(i).getSchedule().get(day + 1) + "), ";
                    }
                }
                if(students.get(8).get(shift+1).size() > 10){
                    for(int i = 10; i < students.get(8).get(shift+1).size(); i++){
                        dishDataLine7 += students.get(8).get(shift+1).get(i).getName() + " (" + students.get(8).get(shift+1).get(i).getSchedule().get(day) + "-" + students.get(8).get(shift+1).get(i).getSchedule().get(day + 1) + "), ";
                    }
                }
            }
            else if(students.get(8).get(shift).size() == 3){
                dishDataLine2 += students.get(8).get(shift+1).get(0).getName() + " (" + students.get(8).get(shift+1).get(0).getSchedule().get(day) + "-" + students.get(8).get(shift+1).get(0).getSchedule().get(day + 1) + "), ";
                if(students.get(8).get(shift+1).size() > 1){
                    for(int i = 1; i < students.get(8).get(shift+1).size(); i++){
                        if(i == 3)break;
                        dishDataLine3 += students.get(8).get(shift+1).get(i).getName() + " (" + students.get(8).get(shift+1).get(i).getSchedule().get(day) + "-" + students.get(8).get(shift+1).get(i).getSchedule().get(day + 1) + "), ";
                    }
                }
                if(students.get(8).get(shift+1).size() > 3){
                    for(int i = 3; i < students.get(8).get(shift+1).size(); i++){
                        if( i == 5) break;
                        dishDataLine4 += students.get(8).get(shift+1).get(i).getName() + " (" + students.get(8).get(shift+1).get(i).getSchedule().get(day) + "-" + students.get(8).get(shift+1).get(i).getSchedule().get(day + 1) + "), ";
                    }
                }
                if(students.get(8).get(shift+1).size() > 5){
                    for(int i = 5; i < students.get(8).get(shift+1).size(); i++){
                        if(i == 7)break;
                        dishDataLine5 += students.get(8).get(shift+1).get(i).getName() + " (" + students.get(8).get(shift+1).get(i).getSchedule().get(day) + "-" + students.get(8).get(shift+1).get(i).getSchedule().get(day + 1) + "), ";
                    }
                }
                if(students.get(8).get(shift+1).size() > 7){
                    for(int i = 7; i < students.get(8).get(shift+1).size(); i++){
                        if(i == 9)break;
                        dishDataLine6 += students.get(8).get(shift+1).get(i).getName() + " (" + students.get(8).get(shift+1).get(i).getSchedule().get(day) + "-" + students.get(8).get(shift+1).get(i).getSchedule().get(day + 1) + "), ";
                    }
                }
                if(students.get(8).get(shift+1).size() > 9){
                    for(int i = 9; i < students.get(8).get(shift+1).size(); i++){
                        dishDataLine7 += students.get(8).get(shift+1).get(i).getName() + " (" + students.get(8).get(shift+1).get(i).getSchedule().get(day) + "-" + students.get(8).get(shift+1).get(i).getSchedule().get(day + 1) + "), ";
                    }
                }
            }
            else if(students.get(8).get(shift).size() == 4){
                for(int i = 0; i < students.get(8).get(shift+1).size(); i++){
                    if(i == 2)break;
                    dishDataLine3 += students.get(8).get(shift+1).get(i).getName() + " (" + students.get(8).get(shift+1).get(i).getSchedule().get(day) + "-" + students.get(8).get(shift+1).get(i).getSchedule().get(day + 1) + "), ";
                }
                if(students.get(8).get(shift+1).size() > 2){
                    for(int i = 2; i < students.get(8).get(shift+1).size(); i++){
                        if( i == 4) break;
                        dishDataLine4 += students.get(8).get(shift+1).get(i).getName() + " (" + students.get(8).get(shift+1).get(i).getSchedule().get(day) + "-" + students.get(8).get(shift+1).get(i).getSchedule().get(day + 1) + "), ";
                    }
                }
                if(students.get(8).get(shift+1).size() > 4){
                    for(int i = 4; i < students.get(8).get(shift+1).size(); i++){
                        if(i == 6)break;
                        dishDataLine5 += students.get(8).get(shift+1).get(i).getName() + " (" + students.get(8).get(shift+1).get(i).getSchedule().get(day) + "-" + students.get(8).get(shift+1).get(i).getSchedule().get(day + 1) + "), ";
                    }
                }
                if(students.get(8).get(shift+1).size() > 6){
                    for(int i = 6; i < students.get(8).get(shift+1).size(); i++){
                        if(i == 8)break;
                        dishDataLine6 += students.get(8).get(shift+1).get(i).getName() + " (" + students.get(8).get(shift+1).get(i).getSchedule().get(day) + "-" + students.get(8).get(shift+1).get(i).getSchedule().get(day + 1) + "), ";
                    }
                }
                if(students.get(8).get(shift+1).size() > 8){
                    for(int i = 8; i < students.get(8).get(shift+1).size(); i++){
                        dishDataLine7 += students.get(8).get(shift+1).get(i).getName() + " (" + students.get(8).get(shift+1).get(i).getSchedule().get(day) + "-" + students.get(8).get(shift+1).get(i).getSchedule().get(day + 1) + "), ";
                    }
                }
            }
            else if(students.get(8).get(shift).size() == 5){
                dishDataLine3 += students.get(8).get(shift+1).get(0).getName() + " (" + students.get(8).get(shift+1).get(0).getSchedule().get(day) + "-" + students.get(8).get(shift+1).get(0).getSchedule().get(day + 1) + "), ";
                if(students.get(8).get(shift+1).size() > 1){
                    for(int i = 1; i < students.get(8).get(shift+1).size(); i++){
                        if( i == 3) break;
                        dishDataLine4 += students.get(8).get(shift+1).get(i).getName() + " (" + students.get(8).get(shift+1).get(i).getSchedule().get(day) + "-" + students.get(8).get(shift+1).get(i).getSchedule().get(day + 1) + "), ";
                    }
                }
                if(students.get(8).get(shift+1).size() > 3){
                    for(int i = 3; i < students.get(8).get(shift+1).size(); i++){
                        if(i == 5)break;
                        dishDataLine5 += students.get(8).get(shift+1).get(i).getName() + " (" + students.get(8).get(shift+1).get(i).getSchedule().get(day) + "-" + students.get(8).get(shift+1).get(i).getSchedule().get(day + 1) + "), ";
                    }
                }
                if(students.get(8).get(shift+1).size() > 5){
                    for(int i = 5; i < students.get(8).get(shift+1).size(); i++){
                        if(i == 7)break;
                        dishDataLine6 += students.get(8).get(shift+1).get(i).getName() + " (" + students.get(8).get(shift+1).get(i).getSchedule().get(day) + "-" + students.get(8).get(shift+1).get(i).getSchedule().get(day + 1) + "), ";
                    }
                }
                if(students.get(8).get(shift+1).size() > 7){
                    for(int i = 7; i < students.get(8).get(shift+1).size(); i++){
                        dishDataLine7 += students.get(8).get(shift+1).get(i).getName() + " (" + students.get(8).get(shift+1).get(i).getSchedule().get(day) + "-" + students.get(8).get(shift+1).get(i).getSchedule().get(day + 1) + "), ";
                    }
                }
            }
            else if(students.get(8).get(shift).size() == 6){
                for(int i = 0; i < students.get(8).get(shift+1).size(); i++){
                    if( i == 2) break;
                    dishDataLine4 += students.get(8).get(shift+1).get(i).getName() + " (" + students.get(8).get(shift+1).get(i).getSchedule().get(day) + "-" + students.get(8).get(shift+1).get(i).getSchedule().get(day + 1) + "), ";
                }
                if(students.get(8).get(shift+1).size() > 2){
                    for(int i = 2; i < students.get(8).get(shift+1).size(); i++){
                        if(i == 4)break;
                        dishDataLine5 += students.get(8).get(shift+1).get(i).getName() + " (" + students.get(8).get(shift+1).get(i).getSchedule().get(day) + "-" + students.get(8).get(shift+1).get(i).getSchedule().get(day + 1) + "), ";
                    }
                }
                if(students.get(8).get(shift+1).size() > 4){
                    for(int i = 4; i < students.get(8).get(shift+1).size(); i++){
                        if(i == 6)break;
                        dishDataLine6 += students.get(8).get(shift+1).get(i).getName() + " (" + students.get(8).get(shift+1).get(i).getSchedule().get(day) + "-" + students.get(8).get(shift+1).get(i).getSchedule().get(day + 1) + "), ";
                    }
                }
                if(students.get(8).get(shift+1).size() > 6){
                    for(int i = 6; i < students.get(8).get(shift+1).size(); i++){
                        dishDataLine7 += students.get(8).get(shift+1).get(i).getName() + " (" + students.get(8).get(shift+1).get(i).getSchedule().get(day) + "-" + students.get(8).get(shift+1).get(i).getSchedule().get(day + 1) + "), ";
                    }
                }
            }
            else if(students.get(8).get(shift).size() == 7){
                dishDataLine4 += students.get(8).get(shift+1).get(0).getName() + " (" + students.get(8).get(shift+1).get(0).getSchedule().get(day) + "-" + students.get(8).get(shift+1).get(0).getSchedule().get(day + 1) + "), ";
                if(students.get(8).get(shift+1).size() > 1){
                    for(int i = 1; i < students.get(8).get(shift+1).size(); i++){
                        if(i == 3)break;
                        dishDataLine5 += students.get(8).get(shift+1).get(i).getName() + " (" + students.get(8).get(shift+1).get(i).getSchedule().get(day) + "-" + students.get(8).get(shift+1).get(i).getSchedule().get(day + 1) + "), ";
                    }
                }
                if(students.get(8).get(shift+1).size() > 3){
                    for(int i = 3; i < students.get(8).get(shift+1).size(); i++){
                        if(i == 5)break;
                        dishDataLine6 += students.get(8).get(shift+1).get(i).getName() + " (" + students.get(8).get(shift+1).get(i).getSchedule().get(day) + "-" + students.get(8).get(shift+1).get(i).getSchedule().get(day + 1) + "), ";
                    }
                }
                if(students.get(8).get(shift+1).size() > 5){
                    for(int i = 5; i < students.get(8).get(shift+1).size(); i++){
                        dishDataLine7 += students.get(8).get(shift+1).get(i).getName() + " (" + students.get(8).get(shift+1).get(i).getSchedule().get(day) + "-" + students.get(8).get(shift+1).get(i).getSchedule().get(day + 1) + "), ";
                    }
                }
            }
            else if(students.get(8).get(shift).size() == 8){
                for(int i = 0; i < students.get(8).get(shift+1).size(); i++){
                    if(i == 2)break;
                    dishDataLine5 += students.get(8).get(shift+1).get(i).getName() + " (" + students.get(8).get(shift+1).get(i).getSchedule().get(day) + "-" + students.get(8).get(shift+1).get(i).getSchedule().get(day + 1) + "), ";
                }
                if(students.get(8).get(shift+1).size() > 2){
                    for(int i = 2; i < students.get(8).get(shift+1).size(); i++){
                        if(i == 6)break;
                        dishDataLine6 += students.get(8).get(shift+1).get(i).getName() + " (" + students.get(8).get(shift+1).get(i).getSchedule().get(day) + "-" + students.get(8).get(shift+1).get(i).getSchedule().get(day + 1) + "), ";
                    }
                }
                if(students.get(8).get(shift+1).size() > 6){
                    for(int i = 6; i < students.get(8).get(shift+1).size(); i++){
                        dishDataLine7 += students.get(8).get(shift+1).get(i).getName() + " (" + students.get(8).get(shift+1).get(i).getSchedule().get(day) + "-" + students.get(8).get(shift+1).get(i).getSchedule().get(day + 1) + "), ";
                    }
                }

            }
            else if(students.get(8).get(shift).size() == 9){
                dishDataLine5 += students.get(8).get(shift+1).get(0).getName() + " (" + students.get(8).get(shift+1).get(0).getSchedule().get(day) + "-" + students.get(8).get(shift+1).get(0).getSchedule().get(day + 1) + "), ";
                if(students.get(8).get(shift+1).size() > 1){
                    for(int i = 1; i < students.get(8).get(shift+1).size(); i++){
                        if(i == 3)break;
                        dishDataLine6 += students.get(8).get(shift+1).get(i).getName() + " (" + students.get(8).get(shift+1).get(i).getSchedule().get(day) + "-" + students.get(8).get(shift+1).get(i).getSchedule().get(day + 1) + "), ";
                    }
                }
                if(students.get(8).get(shift+1).size() > 3){
                    for(int i = 3; i < students.get(8).get(shift+1).size(); i++){
                        dishDataLine7 += students.get(8).get(shift+1).get(i).getName() + " (" + students.get(8).get(shift+1).get(i).getSchedule().get(day) + "-" + students.get(8).get(shift+1).get(i).getSchedule().get(day + 1) + "), ";
                    }
                }
            }
            else if(students.get(8).get(shift).size() == 10){
                for(int i = 0; i < students.get(8).get(shift+1).size(); i++){
                    if(i == 2)break;
                    dishDataLine6 += students.get(8).get(shift+1).get(i).getName() + " (" + students.get(8).get(shift+1).get(i).getSchedule().get(day) + "-" + students.get(8).get(shift+1).get(i).getSchedule().get(day + 1) + "), ";
                }

                if(students.get(8).get(shift+1).size() > 2){
                    for(int i = 2; i < students.get(8).get(shift+1).size(); i++){
                        dishDataLine7 += students.get(8).get(shift+1).get(i).getName() + " (" + students.get(8).get(shift+1).get(i).getSchedule().get(day) + "-" + students.get(8).get(shift+1).get(i).getSchedule().get(day + 1) + "), ";
                    }
                }
            }
            else if(students.get(8).get(shift).size() == 11){
                dishDataLine6 += students.get(8).get(shift+1).get(0).getName() + " (" + students.get(8).get(shift+1).get(0).getSchedule().get(day) + "-" + students.get(8).get(shift+1).get(0).getSchedule().get(day + 1) + "), ";
                if(students.get(8).get(shift+1).size() > 1){
                    for(int i = 1; i < students.get(8).get(shift+1).size(); i++){
                        dishDataLine7 += students.get(8).get(shift+1).get(i).getName() + " (" + students.get(8).get(shift+1).get(i).getSchedule().get(day) + "-" + students.get(8).get(shift+1).get(i).getSchedule().get(day + 1) + "), ";
                    }
                }
            }
            else if(students.get(8).get(shift).size() > 11){
                for(int i = 0; i < students.get(8).get(shift+1).size(); i++){
                    dishDataLine7 += students.get(8).get(shift+1).get(i).getName() + " (" + students.get(8).get(shift+1).get(i).getSchedule().get(day) + "-" + students.get(8).get(shift+1).get(i).getSchedule().get(day + 1) + "), ";
                }
            }
        }
        dishCellLine1.add(new CellData()
                .setUserEnteredValue(new ExtendedValue()
                        .setStringValue(dishDataLine1))
                .setUserEnteredFormat(new CellFormat()
                        .setTextFormat(new TextFormat()
                                .setFontSize(8)
                        )
                        .setWrapStrategy("Wrap")));

        dishCellLine2.add(new CellData()
                .setUserEnteredValue(new ExtendedValue()
                        .setStringValue(dishDataLine2))
                .setUserEnteredFormat(new CellFormat()
                        .setTextFormat(new TextFormat()
                                .setFontSize(8)
                        )
                        .setWrapStrategy("Wrap")));
        dishCellLine3.add(new CellData()
                .setUserEnteredValue(new ExtendedValue()
                        .setStringValue(dishDataLine3))
                .setUserEnteredFormat(new CellFormat()
                        .setTextFormat(new TextFormat()
                                .setFontSize(8)
                        )
                        .setWrapStrategy("Wrap")));
        dishCellLine4.add(new CellData()
                .setUserEnteredValue(new ExtendedValue()
                        .setStringValue(dishDataLine4))
                .setUserEnteredFormat(new CellFormat()
                        .setTextFormat(new TextFormat()
                                .setFontSize(8)
                        )
                        .setWrapStrategy("Wrap")));
        dishCellLine5.add(new CellData()
                .setUserEnteredValue(new ExtendedValue()
                        .setStringValue(dishDataLine5))
                .setUserEnteredFormat(new CellFormat()
                        .setTextFormat(new TextFormat()
                                .setFontSize(8)
                        )
                        .setWrapStrategy("Wrap")));
        dishCellLine6.add(new CellData()
                .setUserEnteredValue(new ExtendedValue()
                        .setStringValue(dishDataLine6))
                .setUserEnteredFormat(new CellFormat()
                        .setTextFormat(new TextFormat()
                                .setFontSize(8)
                        )
                        .setWrapStrategy("Wrap")));
        dishCellLine7.add(new CellData()
                .setUserEnteredValue(new ExtendedValue()
                        .setStringValue(dishDataLine7))
                .setUserEnteredFormat(new CellFormat()
                        .setTextFormat(new TextFormat()
                                .setFontSize(8)
                        )
                        .setWrapStrategy("Wrap")));

        if (shift == 0 || shift == 1) {
            requests.add(new Request()
                    .setUpdateCells(new UpdateCellsRequest()
                            .setRows(Arrays.asList(
                                    new RowData().setValues(dishCellLine1)))
                            .setStart(new GridCoordinate()
                                    .setSheetId(1656413616)
                                    .setRowIndex(39)
                                    .setColumnIndex(shift))
                            .setFields("userEnteredValue,userEnteredFormat")));
            requests.add(new Request()
                    .setUpdateCells(new UpdateCellsRequest()
                            .setRows(Arrays.asList(
                                    new RowData().setValues(dishCellLine2)))
                            .setStart(new GridCoordinate()
                                    .setSheetId(1656413616)
                                    .setRowIndex(40)
                                    .setColumnIndex(shift))
                            .setFields("userEnteredValue,userEnteredFormat")));
            requests.add(new Request()
                    .setUpdateCells(new UpdateCellsRequest()
                            .setRows(Arrays.asList(
                                    new RowData().setValues(dishCellLine3)))
                            .setStart(new GridCoordinate()
                                    .setSheetId(1656413616)
                                    .setRowIndex(41)
                                    .setColumnIndex(shift))
                            .setFields("userEnteredValue,userEnteredFormat")));
            requests.add(new Request()
                    .setUpdateCells(new UpdateCellsRequest()
                            .setRows(Arrays.asList(
                                    new RowData().setValues(dishCellLine4)))
                            .setStart(new GridCoordinate()
                                    .setSheetId(1656413616)
                                    .setRowIndex(42)
                                    .setColumnIndex(shift))
                            .setFields("userEnteredValue,userEnteredFormat")));
            requests.add(new Request()
                    .setUpdateCells(new UpdateCellsRequest()
                            .setRows(Arrays.asList(
                                    new RowData().setValues(dishCellLine5)))
                            .setStart(new GridCoordinate()
                                    .setSheetId(1656413616)
                                    .setRowIndex(43)
                                    .setColumnIndex(shift))
                            .setFields("userEnteredValue,userEnteredFormat")));
            requests.add(new Request()
                    .setUpdateCells(new UpdateCellsRequest()
                            .setRows(Arrays.asList(
                                    new RowData().setValues(dishCellLine6)))
                            .setStart(new GridCoordinate()
                                    .setSheetId(1656413616)
                                    .setRowIndex(44)
                                    .setColumnIndex(shift))
                            .setFields("userEnteredValue,userEnteredFormat")));
            requests.add(new Request()
                    .setUpdateCells(new UpdateCellsRequest()
                            .setRows(Arrays.asList(
                                    new RowData().setValues(dishCellLine7)))
                            .setStart(new GridCoordinate()
                                    .setSheetId(1656413616)
                                    .setRowIndex(45)
                                    .setColumnIndex(shift))
                            .setFields("userEnteredValue,userEnteredFormat")));
        }
        if (shift == 3) {
            requests.add(new Request()
                    .setUpdateCells(new UpdateCellsRequest()
                            .setRows(Arrays.asList(
                                    new RowData().setValues(dishCellLine1)))
                            .setStart(new GridCoordinate()
                                    .setSheetId(1656413616)
                                    .setRowIndex(39)
                                    .setColumnIndex(shift - 1))
                            .setFields("userEnteredValue,userEnteredFormat")));
            requests.add(new Request()
                    .setUpdateCells(new UpdateCellsRequest()
                            .setRows(Arrays.asList(
                                    new RowData().setValues(dishCellLine2)))
                            .setStart(new GridCoordinate()
                                    .setSheetId(1656413616)
                                    .setRowIndex(40)
                                    .setColumnIndex(shift - 1))
                            .setFields("userEnteredValue,userEnteredFormat")));
            requests.add(new Request()
                    .setUpdateCells(new UpdateCellsRequest()
                            .setRows(Arrays.asList(
                                    new RowData().setValues(dishCellLine3)))
                            .setStart(new GridCoordinate()
                                    .setSheetId(1656413616)
                                    .setRowIndex(41)
                                    .setColumnIndex(shift-1))
                            .setFields("userEnteredValue,userEnteredFormat")));
            requests.add(new Request()
                    .setUpdateCells(new UpdateCellsRequest()
                            .setRows(Arrays.asList(
                                    new RowData().setValues(dishCellLine4)))
                            .setStart(new GridCoordinate()
                                    .setSheetId(1656413616)
                                    .setRowIndex(42)
                                    .setColumnIndex(shift-1))
                            .setFields("userEnteredValue,userEnteredFormat")));
            requests.add(new Request()
                    .setUpdateCells(new UpdateCellsRequest()
                            .setRows(Arrays.asList(
                                    new RowData().setValues(dishCellLine5)))
                            .setStart(new GridCoordinate()
                                    .setSheetId(1656413616)
                                    .setRowIndex(43)
                                    .setColumnIndex(shift-1))
                            .setFields("userEnteredValue,userEnteredFormat")));
            requests.add(new Request()
                    .setUpdateCells(new UpdateCellsRequest()
                            .setRows(Arrays.asList(
                                    new RowData().setValues(dishCellLine6)))
                            .setStart(new GridCoordinate()
                                    .setSheetId(1656413616)
                                    .setRowIndex(44)
                                    .setColumnIndex(shift-1))
                            .setFields("userEnteredValue,userEnteredFormat")));
            requests.add(new Request()
                    .setUpdateCells(new UpdateCellsRequest()
                            .setRows(Arrays.asList(
                                    new RowData().setValues(dishCellLine7)))
                            .setStart(new GridCoordinate()
                                    .setSheetId(1656413616)
                                    .setRowIndex(45)
                                    .setColumnIndex(shift-1))
                            .setFields("userEnteredValue,userEnteredFormat")));
        }
        BatchUpdateSpreadsheetRequest body = new BatchUpdateSpreadsheetRequest().setRequests(requests);
        BatchUpdateSpreadsheetResponse response = service.spreadsheets()
                .batchUpdate(spreadsheetId, body).execute();
    }

    private void setJanitorDuckListValues(List<List<List<Student>>> students, int day, int shift) throws IOException, GeneralSecurityException{
        final NetHttpTransport HTTP_TRANSPORT = GoogleNetHttpTransport.newTrustedTransport();
        final String spreadsheetId = "1BuWoL8uGgCgx24TKtDjx-j8406BZ36xbaGyOq359sfA";

        Sheets service = new Sheets.Builder(HTTP_TRANSPORT, JSON_FACTORY, getCredentials(HTTP_TRANSPORT))
                .setApplicationName(APPLICATION_NAME)
                .build();


        List<Request> requests = new ArrayList<>();

        List<CellData> cellLine1 = new ArrayList<>();
        String dataLine1 = "Janitor: ";
        if(students.get(11).get(shift).size() > 0)
        {
            for(int i = 0; i < students.get(11).get(shift).size(); i++){
                dataLine1 += students.get(11).get(shift).get(i).getName() + " (" + students.get(11).get(shift).get(i).getSchedule().get(day) + "-" + students.get(11).get(shift).get(i).getSchedule().get(day + 1) + "), ";
            }
        }
        if( shift == 1 && students.get(11).get(shift+1).size() > 0){
            for(int i = 0; i < students.get(11).get(shift+1).size(); i++){
                dataLine1 += students.get(11).get(shift+1).get(i).getName() + " (" + students.get(11).get(shift+1).get(i).getSchedule().get(day) + "-" + students.get(11).get(shift+1).get(i).getSchedule().get(day + 1) + "), ";
            }
        }

        cellLine1.add(new CellData()
                .setUserEnteredValue(new ExtendedValue()
                        .setStringValue(dataLine1))
                .setUserEnteredFormat(new CellFormat()
                        .setTextFormat(new TextFormat()
                                .setFontSize(10)
                                .setBold(true)
                        )
                        .setWrapStrategy("Wrap")));

        if(shift == 0 || shift == 1){
            requests.add(new Request()
                    .setUpdateCells(new UpdateCellsRequest()
                            .setRows(Arrays.asList(
                                    new RowData().setValues(cellLine1)))
                            .setStart(new GridCoordinate()
                                    .setSheetId(1656413616)
                                    .setRowIndex(48)
                                    .setColumnIndex(shift))
                            .setFields("userEnteredValue,userEnteredFormat")));
        }
        if(shift == 3){
            requests.add(new Request()
                    .setUpdateCells(new UpdateCellsRequest()
                            .setRows(Arrays.asList(
                                    new RowData().setValues(cellLine1)))
                            .setStart(new GridCoordinate()
                                    .setSheetId(1656413616)
                                    .setRowIndex(48)
                                    .setColumnIndex(shift-1))
                            .setFields("userEnteredValue,userEnteredFormat")));
        }
    }


}
