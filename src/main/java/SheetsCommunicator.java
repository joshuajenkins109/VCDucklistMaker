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



import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.lang.reflect.Array;
import java.security.GeneralSecurityException;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class SheetsCommunicator {

    private static final String APPLICATION_NAME = "Google Sheets API Java Quickstart";
    private static final JsonFactory JSON_FACTORY = JacksonFactory.getDefaultInstance();
    private static final String TOKENS_DIRECTORY_PATH = "tokens";

    private static final List<String> SCOPES = Collections.singletonList(SheetsScopes.SPREADSHEETS);
    private static final String CREDENTIALS_FILE_PATH = "/credentials.json";
    private String scheduleID;

    public SheetsCommunicator()throws IOException, GeneralSecurityException{this.scheduleID = getCurrentScheduleID();}

    /**
     * Creates an authorized Credential object.
                * @param HTTP_TRANSPORT The network HTTP Transport.
     * @return An authorized Credential object.
                * @throws IOException If the credentials.json file cannot be found.
                */
    private static Credential getCredentials(final NetHttpTransport HTTP_TRANSPORT) throws IOException {
            // Load client secrets.
            InputStream in = SheetsQuickstart.class.getResourceAsStream(CREDENTIALS_FILE_PATH);
            GoogleClientSecrets clientSecrets;
            if(in == null){
                String in2 = "{\n" +
                        "  \"installed\":\n" +
                        "  {\n" +
                        "    \"client_id\":\"654732257802-u4jqmi5pl4p4vvkoa4qf8lravn7ap35j.apps.googleusercontent.com\",\n" +
                        "    \"project_id\":\"duclistmaker-1535572080429\",\n" +
                        "    \"auth_uri\":\"https://accounts.google.com/o/oauth2/auth\",\n" +
                        "    \"token_uri\":\"https://www.googleapis.com/oauth2/v3/token\",\n" +
                        "    \"auth_provider_x509_cert_url\":\"https://www.googleapis.com/oauth2/v1/certs\",\n" +
                        "    \"client_secret\":\"99RcR7sSz7NB7xHHb9wllgkY\",\n" +
                        "    \"redirect_uris\":[\"urn:ietf:wg:oauth:2.0:oob\",\"http://localhost\"]\n" +
                        "  }\n" +
                        "}";
                 clientSecrets = GoogleClientSecrets.load(JSON_FACTORY, new StringReader(in2));
            }
            else{clientSecrets = GoogleClientSecrets.load(JSON_FACTORY, new InputStreamReader(in));}


            // Build flow and trigger user authorization request.
            GoogleAuthorizationCodeFlow flow = new GoogleAuthorizationCodeFlow.Builder(
                    HTTP_TRANSPORT, JSON_FACTORY, clientSecrets, SCOPES)
                    .setDataStoreFactory(new FileDataStoreFactory(new java.io.File(TOKENS_DIRECTORY_PATH)))
                    .setAccessType("offline")
                    .build();
            return new AuthorizationCodeInstalledApp(flow, new LocalServerReceiver()).authorize("user");
        }
    /**
     * Retreives current Schedule Id from google sheet
     *
     * @return Schedule ID String
     * @throws IOException If the Credentials cannot be found.
     * @throws GeneralSecurityException
     */
    private String getCurrentScheduleID()throws IOException, GeneralSecurityException{
        final NetHttpTransport HTTP_TRANSPORT = GoogleNetHttpTransport.newTrustedTransport();
        final String spreadsheetId = "1BuWoL8uGgCgx24TKtDjx-j8406BZ36xbaGyOq359sfA";
        Sheets service = new Sheets.Builder(HTTP_TRANSPORT, JSON_FACTORY, getCredentials(HTTP_TRANSPORT))
                .setApplicationName(APPLICATION_NAME)
                .build();

        ValueRange response = service.spreadsheets().values()
                .get(spreadsheetId, "ScheduleID")
                .execute();

        List<List<Object>> values = response.getValues();

        return values.get(0).get(0).toString();
    }
    /**
     * Build Schedule Object with values current schedule
     *
     * @return A Schedule object.
     * @throws IOException
     * @throws GeneralSecurityException
     */
    public Schedule generateList() throws IOException, GeneralSecurityException {
        final NetHttpTransport HTTP_TRANSPORT = GoogleNetHttpTransport.newTrustedTransport();
        final String range = "Sheet1";
        Sheets service = new Sheets.Builder(HTTP_TRANSPORT, JSON_FACTORY, getCredentials(HTTP_TRANSPORT))
                .setApplicationName(APPLICATION_NAME)
                .build();
        ValueRange response = service.spreadsheets().values()
                .get(scheduleID, range)
                .execute();

        List<List<Object>> values = response.getValues();

        Schedule schedule = new Schedule(values);


        return schedule;
    }
    /**
     * Builds List<List<List<String>>> for full time employees to be added to
     *
     * @return A List<List<List<String>>> sized for full time stations/positions
     *
     */
    private List<List<List<String>>> buildFullTimeList(){
        List<String> checkerMorning = new ArrayList<>();
        List<String> checkerMid = new ArrayList<>();
        List<String> checkerDinner = new ArrayList<>();
        List<String> middleMorning = new ArrayList<>();
        List<String> middleMid = new ArrayList<>();
        List<String> middleDinner = new ArrayList<>();
        List<String> curryMorning = new ArrayList<>();
        List<String> curryMid = new ArrayList<>();
        List<String> curryDinner = new ArrayList<>();
        List<String> grangeMorning = new ArrayList<>();
        List<String> grangeMid = new ArrayList<>();
        List<String> grangeDinner = new ArrayList<>();
        List<String> toastMorning = new ArrayList<>();
        List<String> toastMid = new ArrayList<>();
        List<String> toastDinner = new ArrayList<>();
        List<String> hearthMorning = new ArrayList<>();
        List<String> hearthMid = new ArrayList<>();
        List<String> hearthDinner = new ArrayList<>();
        List<String> peaksMorning = new ArrayList<>();
        List<String> peaksMid = new ArrayList<>();
        List<String> peaksDinner = new ArrayList<>();
        List<String> saladsMorning = new ArrayList<>();
        List<String> saladsMid = new ArrayList<>();
        List<String> saladsDinner = new ArrayList<>();
        List<String> coldRunnerMorning = new ArrayList<>();
        List<String> coldRunnerMid = new ArrayList<>();
        List<String> coldRunnerDinner = new ArrayList<>();
        List<String> draMorning = new ArrayList<>();
        List<String> draMid = new ArrayList<>();
        List<String> draDinner = new ArrayList<>();
        List<String> dishMorning = new ArrayList<>();
        List<String> dishMid = new ArrayList<>();
        List<String> dishDinner = new ArrayList<>();
        List<String> productionMorning = new ArrayList<>();
        List<String> productionMid = new ArrayList<>();
        List<String> productionDinner = new ArrayList<>();

        List<List<String>> checker = new ArrayList<>();
        List<List<String>> middle = new ArrayList<>();
        List<List<String>> curry = new ArrayList<>();
        List<List<String>> grange = new ArrayList<>();
        List<List<String>> toast = new ArrayList<>();
        List<List<String>> hearth = new ArrayList<>();
        List<List<String>> peaks = new ArrayList<>();
        List<List<String>> salads = new ArrayList<>();
        List<List<String>> coldRunner = new ArrayList<>();
        List<List<String>> dra = new ArrayList<>();
        List<List<String>> dish = new ArrayList<>();
        List<List<String>> production = new ArrayList<>();

        checker.add(checkerMorning);
        checker.add(checkerMid);
        checker.add(checkerDinner);
        middle.add(middleMorning);
        middle.add(middleMid);
        middle.add(middleDinner);
        curry.add(curryMorning);
        curry.add(curryMid);
        curry.add(curryDinner);
        grange.add(grangeMorning);
        grange.add(grangeMid);
        grange.add(grangeDinner);
        toast.add(toastMorning);
        toast.add(toastMid);
        toast.add(toastDinner);
        hearth.add(hearthMorning);
        hearth.add(hearthMid);
        hearth.add(hearthDinner);
        peaks.add(peaksMorning);
        peaks.add(peaksMid);
        peaks.add(peaksDinner);
        salads.add(saladsMorning);
        salads.add(saladsMid);
        salads.add(saladsDinner);
        coldRunner.add(coldRunnerMorning);
        coldRunner.add(coldRunnerMid);
        coldRunner.add(coldRunnerDinner);
        dra.add(draMorning);
        dra.add(draMid);
        dra.add(draDinner);
        dish.add(dishMorning);
        dish.add(dishMid);
        dish.add(dishDinner);
        production.add(productionMorning);
        production.add(productionMid);
        production.add(productionDinner);

        List<List<List<String>>> fullTimers = new ArrayList<>();
        fullTimers.add(checker);
        fullTimers.add(middle);
        fullTimers.add(curry);
        fullTimers.add(grange);
        fullTimers.add(toast);
        fullTimers.add(hearth);
        fullTimers.add(peaks);
        fullTimers.add(salads);
        fullTimers.add(coldRunner);
        fullTimers.add(dra);
        fullTimers.add(dish);
        fullTimers.add(production);

        return fullTimers;

    }
    /**
     * Retrieves full time employee times/placements and inserts them into List
     * @param day integer representing day of service
     * @return List<List<List<String>>> full time employees
     * @throws IOException
     * @throws GeneralSecurityException
     */
    private List<List<List<String>>> getFullTime(int day)throws IOException, GeneralSecurityException{
        final NetHttpTransport HTTP_TRANSPORT = GoogleNetHttpTransport.newTrustedTransport();
        final String spreadsheetId = "1BuWoL8uGgCgx24TKtDjx-j8406BZ36xbaGyOq359sfA";
        final String range = "FullTime";
        Sheets service = new Sheets.Builder(HTTP_TRANSPORT, JSON_FACTORY, getCredentials(HTTP_TRANSPORT))
                .setApplicationName(APPLICATION_NAME)
                .build();
        ValueRange response = service.spreadsheets().values()
                .get(spreadsheetId, range)
                .execute();

        List<List<Object>> values = response.getValues();

        List<List<List<String>>> fullTimers = buildFullTimeList();

        for(int i = 1; i < values.size(); i++){
            for(int j = day; j < values.get(i).size(); j++){
                if(j == day+3)break;
                if(values.get(i).get(j).toString().compareTo("0") == 0){
                    fullTimers.get(0).get((j-1)%3).add(values.get(i).get(0).toString());
                }
                else if(values.get(i).get(j).toString().compareTo("1") == 0){
                    fullTimers.get(1).get((j-1)%3).add(values.get(i).get(0).toString());
                }
                else if(values.get(i).get(j).toString().compareTo("2") == 0){
                    fullTimers.get(2).get((j-1)%3).add(values.get(i).get(0).toString());
                }
                else if(values.get(i).get(j).toString().compareTo("3") == 0){
                    fullTimers.get(3).get((j-1)%3).add(values.get(i).get(0).toString());
                }
                else if(values.get(i).get(j).toString().compareTo("4") == 0){
                    fullTimers.get(4).get((j-1)%3).add(values.get(i).get(0).toString());
                }
                else if(values.get(i).get(j).toString().compareTo("5") == 0){
                    fullTimers.get(5).get((j-1)%3).add(values.get(i).get(0).toString());
                }
                else if(values.get(i).get(j).toString().compareTo("6") == 0){
                    fullTimers.get(6).get((j-1)%3).add(values.get(i).get(0).toString());
                }
                else if(values.get(i).get(j).toString().compareTo("7") == 0){
                    fullTimers.get(7).get((j-1)%3).add(values.get(i).get(0).toString());
                }
                else if(values.get(i).get(j).toString().compareTo("8") == 0){
                    fullTimers.get(8).get((j-1)%3).add(values.get(i).get(0).toString());
                }
                else if(values.get(i).get(j).toString().compareTo("9") == 0){
                    fullTimers.get(9).get((j-1)%3).add(values.get(i).get(0).toString());
                }
                else if(values.get(i).get(j).toString().compareTo("10") == 0){
                    fullTimers.get(10).get((j-1)%3).add(values.get(i).get(0).toString());
                }
                else if(values.get(i).get(j).toString().compareTo("11") == 0){
                    fullTimers.get(11).get((j-1)%3).add(values.get(i).get(0).toString());
                }
            }
        }
        return fullTimers;
    }
    /**
     * Inserts new student into studentWeights sheet with default values
     * @param name String name of student being placed
     * @param rowIndex row in sheet in which student is placed
     * @throws IOException
     * @throws GeneralSecurityException
     */
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
        for(int i = 0; i < 3; i++){
            cells.add( new CellData()
                    .setUserEnteredValue(new ExtendedValue()
                            .setStringValue("null")
                    )
                    .setUserEnteredFormat(new CellFormat()
                            .setHorizontalAlignment("Center")
                            .setTextFormat(new TextFormat()
                                    .setFontSize(12))));
        }

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
    /**
     * Adds new students from schedule to studentWeights
     * @throws IOException
     * @throws GeneralSecurityException
     */
    public void updateStudentsWeights() throws IOException, GeneralSecurityException{
        final NetHttpTransport HTTP_TRANSPORT = GoogleNetHttpTransport.newTrustedTransport();
        final String spreadsheetId = "1BuWoL8uGgCgx24TKtDjx-j8406BZ36xbaGyOq359sfA";

        Sheets service = new Sheets.Builder(HTTP_TRANSPORT, JSON_FACTORY, getCredentials(HTTP_TRANSPORT))
                .setApplicationName(APPLICATION_NAME)
                .build();

        ValueRange response = service.spreadsheets().values()
                .get(scheduleID, "Sheet1")
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

                        if(secondSheet.get(j).get(0).toString().compareToIgnoreCase(firstSheet.get(i).get(0).toString()) == 0)
                        {
                            break;
                        }
                        if(secondSheet.get(j).get(0).toString().compareToIgnoreCase(firstSheet.get(i).get(0).toString()) > 0){
                            addStudentToWeights(firstSheet.get(i).get(0).toString(), j);
                            secondSheet.add(j, firstSheet.get(i));
                            break;
                        }
                        if(j == secondSheet.size() - 1 && secondSheet.get(j).get(0).toString().compareToIgnoreCase(firstSheet.get(i).get(0).toString()) < 0 ){
                            addStudentToWeights(firstSheet.get(i).get(0).toString(), j+1);
                            secondSheet.add(firstSheet.get(i));
                        }
                    }
                }

            }
        }
    }
    /**
     * Retrieves studentWeights sheet values
     *
     * @return List<List<Object>> containing studentWeights values
     * @throws IOException
     * @throws GeneralSecurityException
     */
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
    /**
     * Gets station numbers from shiftDefaults sheet for given day
     * @param range String representing the sheets range for given day
     * @return List<List<Object>> containing station defaults for mins/maxes
     * @throws IOException
     * @throws GeneralSecurityException
     */
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
    /**
     * Sets new default values to shiftDefaults sheet
     * @param range String representing the sheets range for given day
     * @param input values to set shift defaults as
     * @throws IOException
     * @throws GeneralSecurityException
     */
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
    /**
     * Adds Requests to update coverage sheet with given values
     * @param day Int representing day to update
     * @param requests List to add new requests to
     * @param coverage Values to update coverage with
     * @throws IOException
     * @throws GeneralSecurityException
     */
    private List<Request> updateCoverage(int day, List<Request> requests, List<Integer> coverage)throws IOException, GeneralSecurityException{



        List<CellData> cellLine1 = new ArrayList<>();
        List<CellData> cellLine2 = new ArrayList<>();
        List<CellData> cellLine3 = new ArrayList<>();
        List<CellData> cellLine4 = new ArrayList<>();
        List<CellData> cellLine5 = new ArrayList<>();

        String morning = "";
        String mid = "";
        String dinner = "";
        String earlyMid = "";
        String lateMid = "";


        cellLine1.add( new CellData()
                .setUserEnteredValue(new ExtendedValue()
                        .setNumberValue(coverage.get(0).doubleValue()))
                .setUserEnteredFormat(new CellFormat()
                        .setTextFormat(new TextFormat()
                                .setFontSize(10)
                        )
                        .setWrapStrategy("Wrap")
                        .setBorders(new Borders()
                                .setTop(new Border()
                                        .setStyle("Solid"))
                                .setBottom(new Border()
                                        .setStyle("Solid")
                                )
                                .setLeft(new Border()
                                        .setStyle("Solid"))
                                .setRight(new Border()
                                        .setStyle("Solid")))));
        cellLine2.add( new CellData()
                .setUserEnteredValue(new ExtendedValue()
                        .setNumberValue(coverage.get(1).doubleValue()))
                .setUserEnteredFormat(new CellFormat()
                        .setTextFormat(new TextFormat()
                                .setFontSize(10)
                        )
                        .setWrapStrategy("Wrap")
                        .setBorders(new Borders()
                                .setTop(new Border()
                                        .setStyle("Solid"))
                                .setBottom(new Border()
                                        .setStyle("Solid")
                                )
                                .setLeft(new Border()
                                        .setStyle("Solid"))
                                .setRight(new Border()
                                        .setStyle("Solid")))));
        cellLine3.add( new CellData()
                .setUserEnteredValue(new ExtendedValue()
                        .setNumberValue(coverage.get(2).doubleValue()))
                .setUserEnteredFormat(new CellFormat()
                        .setTextFormat(new TextFormat()
                                .setFontSize(10)
                        )
                        .setWrapStrategy("Wrap")
                        .setBorders(new Borders()
                                .setTop(new Border()
                                        .setStyle("Solid"))
                                .setBottom(new Border()
                                        .setStyle("Solid")
                                )
                                .setLeft(new Border()
                                        .setStyle("Solid"))
                                .setRight(new Border()
                                        .setStyle("Solid")))));
        cellLine4.add( new CellData()
                .setUserEnteredValue(new ExtendedValue()
                        .setNumberValue(coverage.get(3).doubleValue()))
                .setUserEnteredFormat(new CellFormat()
                        .setTextFormat(new TextFormat()
                                .setFontSize(10)
                        )
                        .setWrapStrategy("Wrap")
                        .setBorders(new Borders()
                                .setTop(new Border()
                                        .setStyle("Solid"))
                                .setBottom(new Border()
                                        .setStyle("Solid")
                                )
                                .setLeft(new Border()
                                        .setStyle("Solid"))
                                .setRight(new Border()
                                        .setStyle("Solid")))));
        cellLine5.add( new CellData()
                .setUserEnteredValue(new ExtendedValue()
                        .setNumberValue(coverage.get(4).doubleValue()))
                .setUserEnteredFormat(new CellFormat()
                        .setTextFormat(new TextFormat()
                                .setFontSize(10)
                        )
                        .setWrapStrategy("Wrap")
                        .setBorders(new Borders()
                                .setTop(new Border()
                                        .setStyle("Solid"))
                                .setBottom(new Border()
                                        .setStyle("Solid")
                                )
                                .setLeft(new Border()
                                        .setStyle("Solid"))
                                .setRight(new Border()
                                        .setStyle("Solid")))));


        requests.add(new Request()
                .setUpdateCells(new UpdateCellsRequest()
                        .setRows(Arrays.asList(
                                new RowData().setValues(cellLine1)))
                        .setStart(new GridCoordinate()
                                .setSheetId(0)
                                .setRowIndex(2)
                                .setColumnIndex(day+1))
                        .setFields("userEnteredValue,userEnteredFormat")));

        requests.add(new Request()
                .setUpdateCells(new UpdateCellsRequest()
                        .setRows(Arrays.asList(
                                new RowData().setValues(cellLine2)))
                        .setStart(new GridCoordinate()
                                .setSheetId(0)
                                .setRowIndex(3)
                                .setColumnIndex(day+1))
                        .setFields("userEnteredValue,userEnteredFormat")));


        requests.add(new Request()
                .setUpdateCells(new UpdateCellsRequest()
                        .setRows(Arrays.asList(
                                new RowData().setValues(cellLine3)))
                        .setStart(new GridCoordinate()
                                .setSheetId(0)
                                .setRowIndex(4)
                                .setColumnIndex(day+1))
                        .setFields("userEnteredValue,userEnteredFormat")));
        requests.add(new Request()
                .setUpdateCells(new UpdateCellsRequest()
                        .setRows(Arrays.asList(
                                new RowData().setValues(cellLine4)))
                        .setStart(new GridCoordinate()
                                .setSheetId(0)
                                .setRowIndex(6)
                                .setColumnIndex(day+1))
                        .setFields("userEnteredValue,userEnteredFormat")));


        requests.add(new Request()
                .setUpdateCells(new UpdateCellsRequest()
                        .setRows(Arrays.asList(
                                new RowData().setValues(cellLine5)))
                        .setStart(new GridCoordinate()
                                .setSheetId(0)
                                .setRowIndex(7)
                                .setColumnIndex(day+1))
                        .setFields("userEnteredValue,userEnteredFormat")));

        return requests;

    }
    /**
     * Calls updateCoverage for each day and executes requests
     * @param coverage values to update coverage with
     * @throws IOException
     * @throws GeneralSecurityException
     */
    public void updateCoverageSheet(List<List<Integer>> coverage)throws IOException, GeneralSecurityException{
        final NetHttpTransport HTTP_TRANSPORT = GoogleNetHttpTransport.newTrustedTransport();
        final String spreadsheetId = "1IN7WGwEPukwDjdyVmDBe57oQFeOA1DeIZ1k1EEX5yzQ";

        Sheets service = new Sheets.Builder(HTTP_TRANSPORT, JSON_FACTORY, getCredentials(HTTP_TRANSPORT))
                .setApplicationName(APPLICATION_NAME)
                .build();
        List<Request> requests = new ArrayList<>();
        requests = timestampCoverage(requests);
        requests = updateCoverage(0, requests, coverage.get(0));
        requests = updateCoverage(1, requests, coverage.get(1));
        requests = updateCoverage(2, requests, coverage.get(2));
        requests = updateCoverage(3, requests, coverage.get(3));
        requests = updateCoverage(4, requests, coverage.get(4));
        requests = updateCoverage(5, requests, coverage.get(5));
        requests = updateCoverage(6, requests, coverage.get(6));
        BatchUpdateSpreadsheetRequest body = new BatchUpdateSpreadsheetRequest().setRequests(requests);
        BatchUpdateSpreadsheetResponse response = service.spreadsheets()
                .batchUpdate(spreadsheetId, body).execute();

    }

    /**
     * Calls all updates to Duck List for given day
     * @param students sorted list of students to add to Duck List
     * @param day int representing day of Duck List
     * @throws IOException
     * @throws GeneralSecurityException
     */
    public void createDuckList(List<List<List<Student>>> students, int day) throws IOException, GeneralSecurityException{
        int ftday = 0;
        if(day == 1) ftday = 1;
        if(day == 3) ftday = 4;
        if(day == 5) ftday = 7;
        if(day == 7) ftday = 10;
        if(day == 9) ftday = 13;
        if(day == 11) ftday = 16;
        if(day == 13) ftday = 19;
        List<List<List<String>>> fullTime = getFullTime(ftday);
        setCheckerDuckListValues(students, fullTime, day, 0);
        setCheckerDuckListValues(students, fullTime, day, 1);
        setCheckerDuckListValues(students, fullTime, day, 2);
        System.out.println("Checkers done");
        setMiddleDuckListValues(students, fullTime, day, 0);
        setMiddleDuckListValues(students, fullTime, day, 1);
        setMiddleDuckListValues(students, fullTime, day, 2);
        System.out.println("Middle done");
        setCurryDuckListValues(students, fullTime, day, 0);
        setCurryDuckListValues(students, fullTime, day, 1);
        setCurryDuckListValues(students, fullTime, day, 2);
        System.out.println("Curry done");
        setGrangeDuckListValues(students, fullTime, day, 0);
        setGrangeDuckListValues(students, fullTime, day, 1);
        setGrangeDuckListValues(students, fullTime, day, 2);
        System.out.println("Grange done");
        setToastDuckListValues(students, fullTime, day, 0);
        System.out.println("ToastMorning");
        setToastDuckListValues(students, fullTime, day, 1);
        System.out.println("toastmid");
        setToastDuckListValues(students, fullTime, day, 2);
        System.out.println("Toast done");
        setDuckListValues(students, fullTime, day, 0, 2, 5,24); //hearth
        setDuckListValues(students, fullTime, day, 1, 2, 5,24);
        setDuckListValues(students, fullTime, day, 2, 2, 5,24);
        System.out.println("Hearth done");
        setDuckListValues(students, fullTime, day, 0, 1, 6,27); //peaks
        setDuckListValues(students, fullTime, day, 1, 1, 6,27);
        setDuckListValues(students, fullTime, day, 2, 1, 6,27);
        System.out.println("Peaks done");
        setDuckListValues(students, fullTime, day, 0, 3, 7,30); //salads
        setDuckListValues(students, fullTime, day, 1, 3, 7,30);
        setDuckListValues(students, fullTime, day, 2, 3, 7,30);
        System.out.println("Salads done");
        setDuckListValues(students, fullTime, day, 0, 10, 8,33); //Cold Runner
        setDuckListValues(students, fullTime, day, 1, 10, 8,33);
        setDuckListValues(students, fullTime, day, 2, 10, 8,33);
        System.out.println("CR done");
        setDuckListValues(students, fullTime, day, 0, 9, 9,36); //DRA
        setDuckListValues(students, fullTime, day, 1, 9, 9,36);
        setDuckListValues(students, fullTime, day, 2, 9, 9,36);
        System.out.println("dra done");
        setDishDuckListValues(students, fullTime, day, 0);
        setDishDuckListValues(students, fullTime, day, 1);
        setDishDuckListValues(students, fullTime, day, 2);
        System.out.println("Dish done");
        setFloatDuckListValues(students, day, 0);
        setFloatDuckListValues(students, day, 1);
        setFloatDuckListValues(students, day, 2);
        System.out.println("float done");
        setProductionDuckListValues(fullTime, 0);
        setJanitorDuckListValues(students, day, 1);
        setJanitorDuckListValues(students, day, 2);
        System.out.println("Janitor done");
    }
    /**
     * Populates Duck List Cells for each station
     * @param students list of students to populate Duck List with
     * @param fullTime list of full time employees to populate Duck List with
     * @param day int representing the day of the Duck List
     * @param shift int representing shift to be added to
     *
     * @throws IOException
     * @throws GeneralSecurityException
     */
    private void setCheckerDuckListValues(List<List<List<Student>>> students, List<List<List<String>>> fullTime, int day, int shift) throws IOException, GeneralSecurityException{
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

        if(fullTime.get(0).get(shift).size() > 0){
            for(int i = 0; i < fullTime.get(0).get(shift).size(); i++){
                checkerDataLine1 += fullTime.get(0).get(shift).get(i) +", ";
            }
        }
        if(students.get(0).get(shift).size() > 0){
            checkerDataLine1 += students.get(0).get(shift).get(0).getName() + " (" + students.get(0).get(shift).get(0).getSchedule().get(day) + "-" + students.get(0).get(shift).get(0).getSchedule().get(day+1)+")";
        }
        if(students.get(0).get(shift).size() > 1){
            for(int i = 1; i < students.get(0).get(shift).size(); i++){
                checkerDataLine2 += students.get(0).get(shift).get(i).getName() + " (" + students.get(0).get(shift).get(i).getSchedule().get(day) + "-" + students.get(0).get(shift).get(i).getSchedule().get(day+1)+"), ";
            }
        }

        checkerCellLine1.add( new CellData()
                .setUserEnteredValue(new ExtendedValue()
                        .setStringValue(checkerDataLine1))
                .setUserEnteredFormat(new CellFormat()
                        .setTextFormat(new TextFormat()
                                .setFontSize(10)
                        )
                        .setWrapStrategy("Wrap")
                        .setBorders(new Borders()
                                .setTop(new Border()
                                        .setStyle("Solid"))
                                .setBottom(new Border()

                                        .setStyle("Solid")
                                        )
                                .setLeft(new Border()
                                        .setStyle("Solid"))
                                .setRight(new Border()
                                        .setStyle("Solid")))));

        checkerCellLine2.add( new CellData()
                .setUserEnteredValue(new ExtendedValue()
                        .setStringValue(checkerDataLine2))
                .setUserEnteredFormat(new CellFormat()
                        .setTextFormat(new TextFormat()
                                .setFontSize(10)
                        )
                        .setWrapStrategy("Wrap")
                        .setBorders(new Borders()
                                .setTop(new Border()
                                        .setStyle("Solid"))
                                .setBottom(new Border()
                                        .setStyle("Solid")
                                )
                                .setLeft(new Border()
                                        .setStyle("Solid"))
                                .setRight(new Border()
                                        .setStyle("Solid")))));


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


        BatchUpdateSpreadsheetRequest body = new BatchUpdateSpreadsheetRequest().setRequests(requests);
        BatchUpdateSpreadsheetResponse response = service.spreadsheets()
                .batchUpdate(spreadsheetId, body).execute();

    }
    private void setMiddleDuckListValues(List<List<List<Student>>> students, List<List<List<String>>> fullTime, int day, int shift) throws IOException, GeneralSecurityException{
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

        //Add Full Time Employees
        if (fullTime.get(1).get(shift).size() > 0) {
            for (int i = 0; i < fullTime.get(1).get(shift).size(); i++) {
                middleDataLine1 += fullTime.get(1).get(shift).get(i) + ", ";
            }
        }

        //Measure size for pretty placement
        if(students.get(5).get(shift).size() < 3){
            if (students.get(5).get(shift).size() > 0) {
                middleDataLine2 += students.get(5).get(shift).get(0).getName() + " (" + students.get(5).get(shift).get(0).getSchedule().get(day) + "-" + students.get(5).get(shift).get(0).getSchedule().get(day + 1) + ")" + ", ";
            }
            if (students.get(5).get(shift).size() > 1) {
                middleDataLine3 += students.get(5).get(shift).get(1).getName() + " (" + students.get(5).get(shift).get(1).getSchedule().get(day) + "-" + students.get(5).get(shift).get(1).getSchedule().get(day + 1) + ")" + ", ";
            }
        }
        else if(students.get(5).get(shift).size() == 3){
            middleDataLine1 += students.get(5).get(shift).get(0).getName() + " (" + students.get(5).get(shift).get(0).getSchedule().get(day) + "-" + students.get(5).get(shift).get(0).getSchedule().get(day + 1) + ")" + ", ";
            middleDataLine2 += students.get(5).get(shift).get(1).getName() + " (" + students.get(5).get(shift).get(1).getSchedule().get(day) + "-" + students.get(5).get(shift).get(1).getSchedule().get(day + 1) + ")" + ", ";
            middleDataLine3 += students.get(5).get(shift).get(2).getName() + " (" + students.get(5).get(shift).get(2).getSchedule().get(day) + "-" + students.get(5).get(shift).get(2).getSchedule().get(day + 1) + ")" + ", ";
        }
        else if(students.get(5).get(shift).size() == 4){
            middleDataLine1 += students.get(5).get(shift).get(0).getName() + " (" + students.get(5).get(shift).get(0).getSchedule().get(day) + "-" + students.get(5).get(shift).get(0).getSchedule().get(day + 1) + ")" + ", ";
            middleDataLine2 += students.get(5).get(shift).get(1).getName() + " (" + students.get(5).get(shift).get(1).getSchedule().get(day) + "-" + students.get(5).get(shift).get(1).getSchedule().get(day + 1) + ")" + ", ";
            middleDataLine2 += students.get(5).get(shift).get(2).getName() + " (" + students.get(5).get(shift).get(2).getSchedule().get(day) + "-" + students.get(5).get(shift).get(2).getSchedule().get(day + 1) + ")" + ", ";
            middleDataLine3 += students.get(5).get(shift).get(3).getName() + " (" + students.get(5).get(shift).get(3).getSchedule().get(day) + "-" + students.get(5).get(shift).get(3).getSchedule().get(day + 1) + ")" + ", ";
        }
        else{

            if (students.get(5).get(shift).size() > 0) {
                for (int i = 0; i < students.get(5).get(shift).size(); i++) {
                    if (i == 2) break;
                    middleDataLine1 += students.get(5).get(shift).get(i).getName() + " (" + students.get(5).get(shift).get(i).getSchedule().get(day) + "-" + students.get(5).get(shift).get(i).getSchedule().get(day + 1) + ")" + ", ";
                }
                if (students.get(5).get(shift).size() > 2) {
                    for (int i = 2; i < students.get(5).get(shift).size(); i++) {
                        if (i == 4) break;
                        middleDataLine2 += students.get(5).get(shift).get(i).getName() + " (" + students.get(5).get(shift).get(i).getSchedule().get(day) + "-" + students.get(5).get(shift).get(i).getSchedule().get(day + 1) + ")" + ", ";
                    }
                }
                if (students.get(5).get(shift).size() > 4) {
                    for (int i = 4; i < students.get(5).get(shift).size(); i++) {
                        middleDataLine3 += students.get(5).get(shift).get(i).getName() + " (" + students.get(5).get(shift).get(i).getSchedule().get(day) + "-" + students.get(5).get(shift).get(i).getSchedule().get(day + 1) + ")" + ", ";
                    }
                }
            }
        }
        middleCellLine1.add( new CellData()
                .setUserEnteredValue(new ExtendedValue()
                        .setStringValue(middleDataLine1))
                .setUserEnteredFormat(new CellFormat()
                        .setTextFormat(new TextFormat()
                                .setFontSize(10)
                        )
                        .setWrapStrategy("Wrap")
                        .setBorders(new Borders()
                                .setTop(new Border()
                                        .setStyle("Solid"))
                                .setBottom(new Border()
                                        .setStyle("Solid")
                                )
                                .setLeft(new Border()
                                        .setStyle("Solid"))
                                .setRight(new Border()
                                        .setStyle("Solid")))));

        middleCellLine2.add( new CellData()
                .setUserEnteredValue(new ExtendedValue()
                        .setStringValue(middleDataLine2))
                .setUserEnteredFormat(new CellFormat()
                        .setTextFormat(new TextFormat()
                                .setFontSize(10)
                        )
                        .setWrapStrategy("Wrap")
                        .setBorders(new Borders()
                                .setTop(new Border()
                                        .setStyle("Solid"))
                                .setBottom(new Border()
                                        .setStyle("Solid")
                                )
                                .setLeft(new Border()
                                        .setStyle("Solid"))
                                .setRight(new Border()
                                        .setStyle("Solid")))));

        middleCellLine3.add( new CellData()
                .setUserEnteredValue(new ExtendedValue()
                        .setStringValue(middleDataLine3))
                .setUserEnteredFormat(new CellFormat()
                        .setTextFormat(new TextFormat()
                                .setFontSize(10)
                        )
                        .setWrapStrategy("Wrap")
                        .setBorders(new Borders()
                                .setTop(new Border()
                                        .setStyle("Solid"))
                                .setBottom(new Border()
                                        .setStyle("Solid")
                                )
                                .setLeft(new Border()
                                        .setStyle("Solid"))
                                .setRight(new Border()
                                        .setStyle("Solid")))));



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



        BatchUpdateSpreadsheetRequest body = new BatchUpdateSpreadsheetRequest().setRequests(requests);
        BatchUpdateSpreadsheetResponse response = service.spreadsheets()
                .batchUpdate(spreadsheetId, body).execute();
    }
    private void setCurryDuckListValues(List<List<List<Student>>> students, List<List<List<String>>> fullTime, int day, int shift) throws IOException, GeneralSecurityException{
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

        if (fullTime.get(2).get(shift).size() > 0) {
            for (int i = 0; i < fullTime.get(2).get(shift).size(); i++) {
                curryDataLine1 += fullTime.get(2).get(shift).get(i) + ", ";
            }
        }


        if(students.get(6).get(shift).size() < 3){

            if (students.get(6).get(shift).size() > 0) {
                curryDataLine2 += students.get(6).get(shift).get(0).getName() + " (" + students.get(6).get(shift).get(0).getSchedule().get(day) + "-" + students.get(6).get(shift).get(0).getSchedule().get(day + 1) + ")" + ", ";
            }
            if (students.get(6).get(shift).size() > 1) {
                curryDataLine3 += students.get(6).get(shift).get(1).getName() + " (" + students.get(6).get(shift).get(1).getSchedule().get(day) + "-" + students.get(6).get(shift).get(1).getSchedule().get(day + 1) + ")" + ", ";
            }

        }
        else if(students.get(6).get(shift).size() == 3){
            curryDataLine1 += students.get(6).get(shift).get(0).getName() + " (" + students.get(6).get(shift).get(0).getSchedule().get(day) + "-" + students.get(6).get(shift).get(0).getSchedule().get(day + 1) + ")" + ", ";
            curryDataLine2 += students.get(6).get(shift).get(1).getName() + " (" + students.get(6).get(shift).get(1).getSchedule().get(day) + "-" + students.get(6).get(shift).get(1).getSchedule().get(day + 1) + ")" + ", ";
            curryDataLine3 += students.get(6).get(shift).get(2).getName() + " (" + students.get(6).get(shift).get(2).getSchedule().get(day) + "-" + students.get(6).get(shift).get(2).getSchedule().get(day + 1) + ")" + ", ";
        }
        else {
            if (students.get(6).get(shift).size() > 0) {
                for (int i = 0; i < students.get(6).get(shift).size(); i++) {
                    if (i == 2) break;
                    curryDataLine1 += students.get(6).get(shift).get(i).getName() + " (" + students.get(6).get(shift).get(i).getSchedule().get(day) + "-" + students.get(6).get(shift).get(i).getSchedule().get(day + 1) + ")" + ", ";
                }
                if (students.get(6).get(shift).size() > 2) {
                    for (int i = 2; i < students.get(6).get(shift).size(); i++) {
                        if (i == 4) break;
                        curryDataLine2 += students.get(6).get(shift).get(i).getName() + " (" + students.get(6).get(shift).get(i).getSchedule().get(day) + "-" + students.get(6).get(shift).get(i).getSchedule().get(day + 1) + ")" + ", ";
                    }
                }
                if (students.get(6).get(shift).size() > 4) {
                    for (int i = 4; i < students.get(6).get(shift).size(); i++) {
                        curryDataLine3 += students.get(6).get(shift).get(i).getName() + " (" + students.get(6).get(shift).get(i).getSchedule().get(day) + "-" + students.get(6).get(shift).get(i).getSchedule().get(day + 1) + ")" + ", ";
                    }
                }


            }
        }
        curryCellLine1.add( new CellData()
                .setUserEnteredValue(new ExtendedValue()
                        .setStringValue(curryDataLine1))
                .setUserEnteredFormat(new CellFormat()
                        .setTextFormat(new TextFormat()
                                .setFontSize(10)
                        )
                        .setWrapStrategy("Wrap")
                        .setBorders(new Borders()
                                .setTop(new Border()
                                        .setStyle("Solid"))
                                .setBottom(new Border()
                                        .setStyle("Solid")
                                )
                                .setLeft(new Border()
                                        .setStyle("Solid"))
                                .setRight(new Border()
                                        .setStyle("Solid")))));

        curryCellLine2.add( new CellData()
                .setUserEnteredValue(new ExtendedValue()
                        .setStringValue(curryDataLine2))
                .setUserEnteredFormat(new CellFormat()
                        .setTextFormat(new TextFormat()
                                .setFontSize(10)
                        )
                        .setWrapStrategy("Wrap")
                        .setBorders(new Borders()
                                .setTop(new Border()
                                        .setStyle("Solid"))
                                .setBottom(new Border()
                                        .setStyle("Solid")
                                )
                                .setLeft(new Border()
                                        .setStyle("Solid"))
                                .setRight(new Border()
                                        .setStyle("Solid")))));

        curryCellLine3.add( new CellData()
                .setUserEnteredValue(new ExtendedValue()
                        .setStringValue(curryDataLine3))
                .setUserEnteredFormat(new CellFormat()
                        .setTextFormat(new TextFormat()
                                .setFontSize(10)
                        )
                        .setWrapStrategy("Wrap")
                        .setBorders(new Borders()
                                .setTop(new Border()
                                        .setStyle("Solid"))
                                .setBottom(new Border()
                                        .setStyle("Solid")
                                )
                                .setLeft(new Border()
                                        .setStyle("Solid"))
                                .setRight(new Border()
                                        .setStyle("Solid")))));




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

        BatchUpdateSpreadsheetRequest body = new BatchUpdateSpreadsheetRequest().setRequests(requests);
        BatchUpdateSpreadsheetResponse response = service.spreadsheets()
                .batchUpdate(spreadsheetId, body).execute();
    }
    private void setGrangeDuckListValues(List<List<List<Student>>> students, List<List<List<String>>> fullTime, int day, int shift) throws IOException, GeneralSecurityException{
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

        if (fullTime.get(3).get(shift).size() > 0) {
            for (int i = 0; i < fullTime.get(3).get(shift).size(); i++) {
                grangeDataLine1 += fullTime.get(3).get(shift).get(i) + ", ";
            }
        }



        if(students.get(7).get(shift).size() < 3){

            if (students.get(7).get(shift).size() > 0) {
                grangeDataLine2 += students.get(7).get(shift).get(0).getName() + " (" + students.get(7).get(shift).get(0).getSchedule().get(day) + "-" + students.get(7).get(shift).get(0).getSchedule().get(day + 1) + ")" + ", ";
            }
            if (students.get(7).get(shift).size() > 1) {
                grangeDataLine3 += students.get(7).get(shift).get(1).getName() + " (" + students.get(7).get(shift).get(1).getSchedule().get(day) + "-" + students.get(7).get(shift).get(1).getSchedule().get(day + 1) + ")" + ", ";
            }
        }
        else if(students.get(7).get(shift).size() == 3){
            grangeDataLine1 += students.get(7).get(shift).get(0).getName() + " (" + students.get(7).get(shift).get(0).getSchedule().get(day) + "-" + students.get(7).get(shift).get(0).getSchedule().get(day + 1) + ")" + ", ";
            grangeDataLine2 += students.get(7).get(shift).get(1).getName() + " (" + students.get(7).get(shift).get(1).getSchedule().get(day) + "-" + students.get(7).get(shift).get(1).getSchedule().get(day + 1) + ")" + ", ";
            grangeDataLine3 += students.get(7).get(shift).get(2).getName() + " (" + students.get(7).get(shift).get(2).getSchedule().get(day) + "-" + students.get(7).get(shift).get(2).getSchedule().get(day + 1) + ")" + ", ";
        }
        else if(students.get(7).get(shift).size() == 4){
            grangeDataLine1 += students.get(7).get(shift).get(0).getName() + " (" + students.get(7).get(shift).get(0).getSchedule().get(day) + "-" + students.get(7).get(shift).get(0).getSchedule().get(day + 1) + ")" + ", ";
            grangeDataLine2 += students.get(7).get(shift).get(1).getName() + " (" + students.get(7).get(shift).get(1).getSchedule().get(day) + "-" + students.get(7).get(shift).get(1).getSchedule().get(day + 1) + ")" + ", ";
            grangeDataLine2 += students.get(7).get(shift).get(2).getName() + " (" + students.get(7).get(shift).get(2).getSchedule().get(day) + "-" + students.get(7).get(shift).get(2).getSchedule().get(day + 1) + ")" + ", ";
            grangeDataLine3 += students.get(7).get(shift).get(3).getName() + " (" + students.get(7).get(shift).get(3).getSchedule().get(day) + "-" + students.get(7).get(shift).get(3).getSchedule().get(day + 1) + ")" + ", ";
        }
        else {
            if (students.get(7).get(shift).size() > 0) {
                for (int i = 0; i < students.get(7).get(shift).size(); i++) {
                    if (i == 1) break;
                    grangeDataLine1 += students.get(7).get(shift).get(i).getName() + " (" + students.get(7).get(shift).get(i).getSchedule().get(day) + "-" + students.get(7).get(shift).get(i).getSchedule().get(day + 1) + ")" + ", ";
                }
                if (students.get(7).get(shift).size() > 1) {
                    for (int i = 1; i < students.get(7).get(shift).size(); i++) {
                        if (i == 3) break;
                        grangeDataLine2 += students.get(7).get(shift).get(i).getName() + " (" + students.get(7).get(shift).get(i).getSchedule().get(day) + "-" + students.get(7).get(shift).get(i).getSchedule().get(day + 1) + ")" + ", ";
                    }
                }
                if (students.get(7).get(shift).size() > 3) {
                    for (int i = 3; i < students.get(7).get(shift).size(); i++) {
                        grangeDataLine3 += students.get(7).get(shift).get(i).getName() + " (" + students.get(7).get(shift).get(i).getSchedule().get(day) + "-" + students.get(7).get(shift).get(i).getSchedule().get(day + 1) + ")" + ", ";
                    }
                }


            }
        }
        grangeCellLine1.add( new CellData()
                .setUserEnteredValue(new ExtendedValue()
                        .setStringValue(grangeDataLine1))
                .setUserEnteredFormat(new CellFormat()
                        .setTextFormat(new TextFormat()
                                .setFontSize(10)
                        )
                        .setWrapStrategy("Wrap")
                        .setBorders(new Borders()
                                .setTop(new Border()
                                        .setStyle("Solid"))
                                .setBottom(new Border()
                                        .setStyle("Solid")
                                )
                                .setLeft(new Border()
                                        .setStyle("Solid"))
                                .setRight(new Border()
                                        .setStyle("Solid")))));

        grangeCellLine2.add( new CellData()
                .setUserEnteredValue(new ExtendedValue()
                        .setStringValue(grangeDataLine2))
                .setUserEnteredFormat(new CellFormat()
                        .setTextFormat(new TextFormat()
                                .setFontSize(10)
                        )
                        .setWrapStrategy("Wrap")
                        .setBorders(new Borders()
                                .setTop(new Border()
                                        .setStyle("Solid"))
                                .setBottom(new Border()
                                        .setStyle("Solid")
                                )
                                .setLeft(new Border()
                                        .setStyle("Solid"))
                                .setRight(new Border()
                                        .setStyle("Solid")))));

        grangeCellLine3.add( new CellData()
                .setUserEnteredValue(new ExtendedValue()
                        .setStringValue(grangeDataLine3))
                .setUserEnteredFormat(new CellFormat()
                        .setTextFormat(new TextFormat()
                                .setFontSize(10)
                        )
                        .setWrapStrategy("Wrap")
                        .setBorders(new Borders()
                                .setTop(new Border()
                                        .setStyle("Solid"))
                                .setBottom(new Border()
                                        .setStyle("Solid")
                                )
                                .setLeft(new Border()
                                        .setStyle("Solid"))
                                .setRight(new Border()
                                        .setStyle("Solid")))));



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


        BatchUpdateSpreadsheetRequest body = new BatchUpdateSpreadsheetRequest().setRequests(requests);
        BatchUpdateSpreadsheetResponse response = service.spreadsheets()
                .batchUpdate(spreadsheetId, body).execute();
    }
    private void setToastDuckListValues(List<List<List<Student>>> students, List<List<List<String>>> fullTime, int day, int shift) throws IOException, GeneralSecurityException{
        final NetHttpTransport HTTP_TRANSPORT = GoogleNetHttpTransport.newTrustedTransport();
        final String spreadsheetId = "1BuWoL8uGgCgx24TKtDjx-j8406BZ36xbaGyOq359sfA";


        Sheets service = new Sheets.Builder(HTTP_TRANSPORT, JSON_FACTORY, getCredentials(HTTP_TRANSPORT))
                .setApplicationName(APPLICATION_NAME)
                .build();


        List<Request> requests = new ArrayList<>();
        List<CellData> toastCellLine0 = new ArrayList<>();
        List<CellData> toastCellLine1 = new ArrayList<>();
        List<CellData> toastCellLine2 = new ArrayList<>();
        List<CellData> toastCellLine3 = new ArrayList<>();
        List<CellData> toastCellLine4 = new ArrayList<>();
        String toastDataLine0 = "";
        String toastDataLine1 = "";
        String toastDataLine2 = "";
        String toastDataLine3 = "";
        String toastDataLine4 = "";
        if (fullTime.get(4).get(shift).size() > 0) {
            for (int i = 0; i < fullTime.get(4).get(shift).size(); i++) {
                toastDataLine0 += fullTime.get(4).get(shift).get(i) + ", ";
            }
        }



        if(students.get(4).get(shift).size() < 3){

            if (students.get(4).get(shift).size() > 0) {
                toastDataLine2 += students.get(4).get(shift).get(0).getName() + " (" + students.get(4).get(shift).get(0).getSchedule().get(day) + "-" + students.get(4).get(shift).get(0).getSchedule().get(day + 1) + ")" + ", ";
            }
            if (students.get(4).get(shift).size() > 1) {
                toastDataLine3 += students.get(4).get(shift).get(1).getName() + " (" + students.get(4).get(shift).get(1).getSchedule().get(day) + "-" + students.get(4).get(shift).get(1).getSchedule().get(day + 1) + ")" + ", ";
            }
        }
        else if(students.get(4).get(shift).size() == 3){
            toastDataLine1 += students.get(4).get(shift).get(0).getName() + " (" + students.get(4).get(shift).get(0).getSchedule().get(day) + "-" + students.get(4).get(shift).get(0).getSchedule().get(day + 1) + ")" + ", ";
            toastDataLine2 += students.get(4).get(shift).get(1).getName() + " (" + students.get(4).get(shift).get(1).getSchedule().get(day) + "-" + students.get(4).get(shift).get(1).getSchedule().get(day + 1) + ")" + ", ";
            toastDataLine3 += students.get(4).get(shift).get(2).getName() + " (" + students.get(4).get(shift).get(2).getSchedule().get(day) + "-" + students.get(4).get(shift).get(2).getSchedule().get(day + 1) + ")" + ", ";
        }
        else if(students.get(4).get(shift).size() == 4){
            toastDataLine1 += students.get(4).get(shift).get(0).getName() + " (" + students.get(4).get(shift).get(0).getSchedule().get(day) + "-" + students.get(4).get(shift).get(0).getSchedule().get(day + 1) + ")" + ", ";
            toastDataLine2 += students.get(4).get(shift).get(1).getName() + " (" + students.get(4).get(shift).get(1).getSchedule().get(day) + "-" + students.get(4).get(shift).get(1).getSchedule().get(day + 1) + ")" + ", ";
            toastDataLine3 += students.get(4).get(shift).get(2).getName() + " (" + students.get(4).get(shift).get(2).getSchedule().get(day) + "-" + students.get(4).get(shift).get(2).getSchedule().get(day + 1) + ")" + ", ";
            toastDataLine4 += students.get(4).get(shift).get(3).getName() + " (" + students.get(4).get(shift).get(3).getSchedule().get(day) + "-" + students.get(4).get(shift).get(3).getSchedule().get(day + 1) + ")" + ", ";
        }
        else if(students.get(4).get(shift).size() == 5){
            toastDataLine1 += students.get(4).get(shift).get(0).getName() + " (" + students.get(4).get(shift).get(0).getSchedule().get(day) + "-" + students.get(4).get(shift).get(0).getSchedule().get(day + 1) + ")" + ", ";
            toastDataLine1 += students.get(4).get(shift).get(1).getName() + " (" + students.get(4).get(shift).get(1).getSchedule().get(day) + "-" + students.get(4).get(shift).get(1).getSchedule().get(day + 1) + ")" + ", ";
            toastDataLine2 += students.get(4).get(shift).get(2).getName() + " (" + students.get(4).get(shift).get(2).getSchedule().get(day) + "-" + students.get(4).get(shift).get(2).getSchedule().get(day + 1) + ")" + ", ";
            toastDataLine3 += students.get(4).get(shift).get(3).getName() + " (" + students.get(4).get(shift).get(3).getSchedule().get(day) + "-" + students.get(4).get(shift).get(3).getSchedule().get(day + 1) + ")" + ", ";
            toastDataLine4 += students.get(4).get(shift).get(4).getName() + " (" + students.get(4).get(shift).get(4).getSchedule().get(day) + "-" + students.get(4).get(shift).get(4).getSchedule().get(day + 1) + ")" + ", ";
        }
        else if(students.get(4).get(shift).size() == 6){
            toastDataLine1 += students.get(4).get(shift).get(0).getName() + " (" + students.get(4).get(shift).get(0).getSchedule().get(day) + "-" + students.get(4).get(shift).get(0).getSchedule().get(day + 1) + ")" + ", ";
            toastDataLine1 += students.get(4).get(shift).get(1).getName() + " (" + students.get(4).get(shift).get(1).getSchedule().get(day) + "-" + students.get(4).get(shift).get(1).getSchedule().get(day + 1) + ")" + ", ";
            toastDataLine2 += students.get(4).get(shift).get(2).getName() + " (" + students.get(4).get(shift).get(2).getSchedule().get(day) + "-" + students.get(4).get(shift).get(2).getSchedule().get(day + 1) + ")" + ", ";
            toastDataLine2 += students.get(4).get(shift).get(3).getName() + " (" + students.get(4).get(shift).get(3).getSchedule().get(day) + "-" + students.get(4).get(shift).get(3).getSchedule().get(day + 1) + ")" + ", ";
            toastDataLine3 += students.get(4).get(shift).get(4).getName() + " (" + students.get(4).get(shift).get(4).getSchedule().get(day) + "-" + students.get(4).get(shift).get(4).getSchedule().get(day + 1) + ")" + ", ";
            toastDataLine4 += students.get(4).get(shift).get(5).getName() + " (" + students.get(4).get(shift).get(5).getSchedule().get(day) + "-" + students.get(4).get(shift).get(5).getSchedule().get(day + 1) + ")" + ", ";
        }
        else {
            if (students.get(4).get(shift).size() > 0) {
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
        }
        toastCellLine0.add( new CellData()
                .setUserEnteredValue(new ExtendedValue()
                        .setStringValue(toastDataLine0))
                .setUserEnteredFormat(new CellFormat()
                        .setTextFormat(new TextFormat()
                                .setFontSize(10)
                        )
                        .setWrapStrategy("Wrap")
                        .setBorders(new Borders()
                                .setTop(new Border()
                                        .setStyle("Solid"))
                                .setBottom(new Border()
                                        .setStyle("Solid")
                                )
                                .setLeft(new Border()
                                        .setStyle("Solid"))
                                .setRight(new Border()
                                        .setStyle("Solid")))));
        toastCellLine1.add( new CellData()
                .setUserEnteredValue(new ExtendedValue()
                        .setStringValue(toastDataLine1))
                .setUserEnteredFormat(new CellFormat()
                        .setTextFormat(new TextFormat()
                                .setFontSize(10)
                                )
                        .setWrapStrategy("Wrap")
                        .setBorders(new Borders()
                                .setTop(new Border()
                                        .setStyle("Solid"))
                                .setBottom(new Border()
                                        .setStyle("Solid")
                                )
                                .setLeft(new Border()
                                        .setStyle("Solid"))
                                .setRight(new Border()
                                        .setStyle("Solid")))));

        toastCellLine2.add( new CellData()
                .setUserEnteredValue(new ExtendedValue()
                        .setStringValue(toastDataLine2))
                .setUserEnteredFormat(new CellFormat()
                        .setTextFormat(new TextFormat()
                                .setFontSize(10)
                        )
                        .setWrapStrategy("Wrap")
                        .setBorders(new Borders()
                                .setTop(new Border()
                                        .setStyle("Solid"))
                                .setBottom(new Border()
                                        .setStyle("Solid")
                                )
                                .setLeft(new Border()
                                        .setStyle("Solid"))
                                .setRight(new Border()
                                        .setStyle("Solid")))));

        toastCellLine3.add( new CellData()
                .setUserEnteredValue(new ExtendedValue()
                        .setStringValue(toastDataLine3))
                .setUserEnteredFormat(new CellFormat()
                        .setTextFormat(new TextFormat()
                                .setFontSize(10)
                        )
                        .setWrapStrategy("Wrap")
                        .setBorders(new Borders()
                                .setTop(new Border()
                                        .setStyle("Solid"))
                                .setBottom(new Border()
                                        .setStyle("Solid")
                                )
                                .setLeft(new Border()
                                        .setStyle("Solid"))
                                .setRight(new Border()
                                        .setStyle("Solid")))));

        toastCellLine4.add( new CellData()
                .setUserEnteredValue(new ExtendedValue()
                        .setStringValue(toastDataLine4))
                .setUserEnteredFormat(new CellFormat()
                        .setTextFormat(new TextFormat()
                                .setFontSize(10)
                        )
                        .setWrapStrategy("Wrap")
                        .setBorders(new Borders()
                                .setTop(new Border()
                                        .setStyle("Solid"))
                                .setBottom(new Border()
                                        .setStyle("Solid")
                                )
                                .setLeft(new Border()
                                        .setStyle("Solid"))
                                .setRight(new Border()
                                        .setStyle("Solid")))));

        requests.add(new Request()
                .setUpdateCells(new UpdateCellsRequest()
                        .setRows(Arrays.asList(
                                new RowData().setValues(toastCellLine0)))
                        .setStart(new GridCoordinate()
                                .setSheetId(1656413616)
                                .setRowIndex(18)
                                .setColumnIndex(shift))
                        .setFields("userEnteredValue,userEnteredFormat")));
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

        BatchUpdateSpreadsheetRequest body = new BatchUpdateSpreadsheetRequest().setRequests(requests);
        BatchUpdateSpreadsheetResponse response = service.spreadsheets()
                .batchUpdate(spreadsheetId, body).execute();
    }
    private void setDuckListValues(List<List<List<Student>>> students, List<List<List<String>>> fullTime, int day, int shift, int station, int ftstation, int index) throws IOException, GeneralSecurityException {
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

        if (fullTime.get(ftstation).get(shift).size() > 0) {
            for (int i = 0; i < fullTime.get(ftstation).get(shift).size(); i++) {
                dataLine1 += fullTime.get(ftstation).get(shift).get(i) + ", ";
            }
        }


        if (students.get(station).get(shift).size() > 0) {
            for (int i = 0; i < students.get(station).get(shift).size(); i++) {
                if (i == 1) break;
                dataLine1 += students.get(station).get(shift).get(i).getName() + " (" + students.get(station).get(shift).get(i).getSchedule().get(day) + "-" + students.get(station).get(shift).get(i).getSchedule().get(day + 1) + "), ";
            }
            if (students.get(station).get(shift).size() > 1) {
                for (int i = 1; i < students.get(station).get(shift).size(); i++) {
                    dataLine2 += students.get(station).get(shift).get(i).getName() + " (" + students.get(station).get(shift).get(i).getSchedule().get(day) + "-" + students.get(station).get(shift).get(i).getSchedule().get(day + 1) + "), ";
                }
            }
        }

        cellLine1.add(new CellData()
                .setUserEnteredValue(new ExtendedValue()
                        .setStringValue(dataLine1))
                .setUserEnteredFormat(new CellFormat()
                        .setTextFormat(new TextFormat()
                                .setFontSize(10)
                        )
                        .setWrapStrategy("Wrap")
                        .setBorders(new Borders()
                                .setTop(new Border()
                                        .setStyle("Solid"))
                                .setBottom(new Border()
                                        .setStyle("Solid")
                                )
                                .setLeft(new Border()
                                        .setStyle("Solid"))
                                .setRight(new Border()
                                        .setStyle("Solid")))));

        cellLine2.add(new CellData()
                .setUserEnteredValue(new ExtendedValue()
                        .setStringValue(dataLine2))
                .setUserEnteredFormat(new CellFormat()
                        .setTextFormat(new TextFormat()
                                .setFontSize(10)
                        )
                        .setWrapStrategy("Wrap")
                        .setBorders(new Borders()
                                .setTop(new Border()
                                        .setStyle("Solid"))
                                .setBottom(new Border()
                                        .setStyle("Solid")
                                )
                                .setLeft(new Border()
                                        .setStyle("Solid"))
                                .setRight(new Border()
                                        .setStyle("Solid")))));


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

        BatchUpdateSpreadsheetRequest body = new BatchUpdateSpreadsheetRequest().setRequests(requests);
        BatchUpdateSpreadsheetResponse response = service.spreadsheets()
                .batchUpdate(spreadsheetId, body).execute();


    }
    private void setDishDuckListValues(List<List<List<Student>>> students, List<List<List<String>>> fullTime, int day, int shift) throws IOException, GeneralSecurityException{
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
        ArrayList<String> dishlines = new ArrayList<>();
        dishlines.add(dishDataLine1);
        dishlines.add(dishDataLine2);
        dishlines.add(dishDataLine3);
        dishlines.add(dishDataLine4);
        dishlines.add(dishDataLine5);
        dishlines.add(dishDataLine6);
        dishlines.add(dishDataLine7);

        if (fullTime.get(10).get(shift).size() > 0) {
            for (int i = 0; i < fullTime.get(10).get(shift).size(); i++) {
                dishDataLine1 += fullTime.get(10).get(shift).get(i) + ", ";
            }
        }




        if(students.get(8).get(shift).size() < 7){
            if(students.get(8).get(shift).size() > 0){
                dishDataLine2 += students.get(8).get(shift).get(0).getName() + " (" + students.get(8).get(shift).get(0).getSchedule().get(day) + "-" + students.get(8).get(shift).get(0).getSchedule().get(day + 1) + "), ";
            }
            if(students.get(8).get(shift).size() > 1){
                dishDataLine3 += students.get(8).get(shift).get(1).getName() + " (" + students.get(8).get(shift).get(1).getSchedule().get(day) + "-" + students.get(8).get(shift).get(1).getSchedule().get(day + 1) + "), ";
            }
            if(students.get(8).get(shift).size() > 2){
                dishDataLine4 += students.get(8).get(shift).get(2).getName() + " (" + students.get(8).get(shift).get(2).getSchedule().get(day) + "-" + students.get(8).get(shift).get(2).getSchedule().get(day + 1) + "), ";
            }
            if(students.get(8).get(shift).size() > 3){
                dishDataLine5 += students.get(8).get(shift).get(3).getName() + " (" + students.get(8).get(shift).get(3).getSchedule().get(day) + "-" + students.get(8).get(shift).get(3).getSchedule().get(day + 1) + "), ";
            }
            if(students.get(8).get(shift).size() > 4){
                dishDataLine6 += students.get(8).get(shift).get(4).getName() + " (" + students.get(8).get(shift).get(4).getSchedule().get(day) + "-" + students.get(8).get(shift).get(4).getSchedule().get(day + 1) + "), ";
            }
            if(students.get(8).get(shift).size() > 5){
                dishDataLine7 += students.get(8).get(shift).get(5).getName() + " (" + students.get(8).get(shift).get(5).getSchedule().get(day) + "-" + students.get(8).get(shift).get(5).getSchedule().get(day + 1) + "), ";
            }
        }
        else if(students.get(8).get(shift).size() < 14){
            //for( size-1 % 6 amount of times) (add two to line
            dishDataLine1 += students.get(8).get(shift).get(0).getName() + " (" + students.get(8).get(shift).get(0).getSchedule().get(day) + "-" + students.get(8).get(shift).get(0).getSchedule().get(day + 1) + "), ";
            float cntr = 0;
            int i = 1;
            int lineCntr = 1;
            int doubleLines = (students.get(8).get(shift).size()-1) % 6;
            if(doubleLines == 0) doubleLines = 6;
            //%6 for amount of double name lines needed
            while( cntr < doubleLines) {
                if(i< students.get(8).get(shift).size()) {
                    dishlines = setDishString(dishlines, lineCntr, students.get(8).get(shift).get(i).getName() + " (" + students.get(8).get(shift).get(i).getSchedule().get(day) + "-" + students.get(8).get(shift).get(i).getSchedule().get(day + 1) + "), ");
                }
                cntr += .5;
                if(cntr%1==0){
                    lineCntr++;
                }
                i++;
            }
            while(i < students.get(8).get(shift).size()){
                dishlines = setDishString(dishlines, lineCntr, students.get(8).get(shift).get(i).getName() + " (" + students.get(8).get(shift).get(i).getSchedule().get(day) + "-" + students.get(8).get(shift).get(i).getSchedule().get(day + 1) + "), ");
                lineCntr++;
                i++;
            }

            dishDataLine2 = dishlines.get(1);
            dishDataLine3 = dishlines.get(2);
            dishDataLine4 = dishlines.get(3);
            dishDataLine5 = dishlines.get(4);
            dishDataLine6 = dishlines.get(5);
            dishDataLine7 = dishlines.get(6);

        }
        else {
            if (students.get(8).get(shift).size() > 0) {
                for (int i = 0; i < students.get(8).get(shift).size(); i++) {
                    if (i == 2) break;
                    dishDataLine2 += students.get(8).get(shift).get(i).getName() + " (" + students.get(8).get(shift).get(i).getSchedule().get(day) + "-" + students.get(8).get(shift).get(i).getSchedule().get(day + 1) + "), ";
                }
                if (students.get(8).get(shift).size() > 2) {
                    for (int i = 2; i < students.get(8).get(shift).size(); i++) {
                        if (i == 4) break;
                        dishDataLine3 += students.get(8).get(shift).get(i).getName() + " (" + students.get(8).get(shift).get(i).getSchedule().get(day) + "-" + students.get(8).get(shift).get(i).getSchedule().get(day + 1) + "), ";
                    }
                }
                if (students.get(8).get(shift).size() > 4) {
                    for (int i = 4; i < students.get(8).get(shift).size(); i++) {
                        if (i == 6) break;
                        dishDataLine4 += students.get(8).get(shift).get(i).getName() + " (" + students.get(8).get(shift).get(i).getSchedule().get(day) + "-" + students.get(8).get(shift).get(i).getSchedule().get(day + 1) + "), ";
                    }
                }
                if (students.get(8).get(shift).size() > 6) {
                    for (int i = 6; i < students.get(8).get(shift).size(); i++) {
                        if (i == 8) break;
                        dishDataLine5 += students.get(8).get(shift).get(i).getName() + " (" + students.get(8).get(shift).get(i).getSchedule().get(day) + "-" + students.get(8).get(shift).get(i).getSchedule().get(day + 1) + "), ";
                    }
                }
                if (students.get(8).get(shift).size() > 8) {
                    for (int i = 8; i < students.get(8).get(shift).size(); i++) {
                        if (i == 10) break;
                        dishDataLine6 += students.get(8).get(shift).get(i).getName() + " (" + students.get(8).get(shift).get(i).getSchedule().get(day) + "-" + students.get(8).get(shift).get(i).getSchedule().get(day + 1) + "), ";
                    }
                }
                if (students.get(8).get(shift).size() > 10) {
                    for (int i = 10; i < students.get(8).get(shift).size(); i++) {
                        dishDataLine7 += students.get(8).get(shift).get(i).getName() + " (" + students.get(8).get(shift).get(i).getSchedule().get(day) + "-" + students.get(8).get(shift).get(i).getSchedule().get(day + 1) + ")";
                    }
                }

            }
        }
        dishCellLine1.add(new CellData()
                .setUserEnteredValue(new ExtendedValue()
                        .setStringValue(dishDataLine1))
                .setUserEnteredFormat(new CellFormat()
                        .setTextFormat(new TextFormat()
                                .setFontSize(10)
                        )
                        .setWrapStrategy("Wrap")
                        .setBorders(new Borders()
                                .setTop(new Border()
                                        .setStyle("Solid"))
                                .setBottom(new Border()
                                        .setStyle("Solid")
                                )
                                .setLeft(new Border()
                                        .setStyle("Solid"))
                                .setRight(new Border()
                                        .setStyle("Solid")))));

        dishCellLine2.add(new CellData()
                .setUserEnteredValue(new ExtendedValue()
                        .setStringValue(dishDataLine2))
                .setUserEnteredFormat(new CellFormat()
                        .setTextFormat(new TextFormat()
                                .setFontSize(10)
                        )
                        .setWrapStrategy("Wrap")
                        .setBorders(new Borders()
                                .setTop(new Border()
                                        .setStyle("Solid"))
                                .setBottom(new Border()
                                        .setStyle("Solid")
                                )
                                .setLeft(new Border()
                                        .setStyle("Solid"))
                                .setRight(new Border()
                                        .setStyle("Solid")))));
        dishCellLine3.add(new CellData()
                .setUserEnteredValue(new ExtendedValue()
                        .setStringValue(dishDataLine3))
                .setUserEnteredFormat(new CellFormat()
                        .setTextFormat(new TextFormat()
                                .setFontSize(10)
                        )
                        .setWrapStrategy("Wrap")
                        .setBorders(new Borders()
                                .setTop(new Border()
                                        .setStyle("Solid"))
                                .setBottom(new Border()
                                        .setStyle("Solid")
                                )
                                .setLeft(new Border()
                                        .setStyle("Solid"))
                                .setRight(new Border()
                                        .setStyle("Solid")))));
        dishCellLine4.add(new CellData()
                .setUserEnteredValue(new ExtendedValue()
                        .setStringValue(dishDataLine4))
                .setUserEnteredFormat(new CellFormat()
                        .setTextFormat(new TextFormat()
                                .setFontSize(10)
                        )
                        .setWrapStrategy("Wrap")
                        .setBorders(new Borders()
                                .setTop(new Border()
                                        .setStyle("Solid"))
                                .setBottom(new Border()
                                        .setStyle("Solid")
                                )
                                .setLeft(new Border()
                                        .setStyle("Solid"))
                                .setRight(new Border()
                                        .setStyle("Solid")))));
        dishCellLine5.add(new CellData()
                .setUserEnteredValue(new ExtendedValue()
                        .setStringValue(dishDataLine5))
                .setUserEnteredFormat(new CellFormat()
                        .setTextFormat(new TextFormat()
                                .setFontSize(10)
                        )
                        .setWrapStrategy("Wrap")
                        .setBorders(new Borders()
                                .setTop(new Border()
                                        .setStyle("Solid"))
                                .setBottom(new Border()
                                        .setStyle("Solid")
                                )
                                .setLeft(new Border()
                                        .setStyle("Solid"))
                                .setRight(new Border()
                                        .setStyle("Solid")))));
        dishCellLine6.add(new CellData()
                .setUserEnteredValue(new ExtendedValue()
                        .setStringValue(dishDataLine6))
                .setUserEnteredFormat(new CellFormat()
                        .setTextFormat(new TextFormat()
                                .setFontSize(10)
                        )
                        .setWrapStrategy("Wrap")
                        .setBorders(new Borders()
                                .setTop(new Border()
                                        .setStyle("Solid"))
                                .setBottom(new Border()
                                        .setStyle("Solid")
                                )
                                .setLeft(new Border()
                                        .setStyle("Solid"))
                                .setRight(new Border()
                                        .setStyle("Solid")))));
        dishCellLine7.add(new CellData()
                .setUserEnteredValue(new ExtendedValue()
                        .setStringValue(dishDataLine7))
                .setUserEnteredFormat(new CellFormat()
                        .setTextFormat(new TextFormat()
                                .setFontSize(10)
                        )
                        .setWrapStrategy("Wrap")
                        .setBorders(new Borders()
                                .setTop(new Border()
                                        .setStyle("Solid"))
                                .setBottom(new Border()
                                        .setStyle("Solid")
                                )
                                .setLeft(new Border()
                                        .setStyle("Solid"))
                                .setRight(new Border()
                                        .setStyle("Solid")))));


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
        String dataLine1 = "Janitor:, ";
        if(students.get(11).get(shift).size() > 0)
        {
            for(int i = 0; i < students.get(11).get(shift).size(); i++){
                dataLine1 += students.get(11).get(shift).get(i).getName() + " (" + students.get(11).get(shift).get(i).getSchedule().get(day) + "-" + students.get(11).get(shift).get(i).getSchedule().get(day + 1) + "), ";
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
                        .setWrapStrategy("Wrap")
                        .setBorders(new Borders()
                                .setTop(new Border()
                                        .setStyle("Solid"))
                                .setBottom(new Border()
                                        .setStyle("Solid")
                                )
                                .setLeft(new Border()
                                        .setStyle("Solid"))
                                .setRight(new Border()
                                        .setStyle("Solid")))));


        requests.add(new Request()
                .setUpdateCells(new UpdateCellsRequest()
                        .setRows(Arrays.asList(
                                new RowData().setValues(cellLine1)))
                        .setStart(new GridCoordinate()
                                .setSheetId(1656413616)
                                .setRowIndex(48)
                                .setColumnIndex(shift))
                        .setFields("userEnteredValue,userEnteredFormat")));


        BatchUpdateSpreadsheetRequest body = new BatchUpdateSpreadsheetRequest().setRequests(requests);
        BatchUpdateSpreadsheetResponse response = service.spreadsheets()
                .batchUpdate(spreadsheetId, body).execute();
    }
    private void setFloatDuckListValues(List<List<List<Student>>> students, int day, int shift) throws IOException, GeneralSecurityException {
        final NetHttpTransport HTTP_TRANSPORT = GoogleNetHttpTransport.newTrustedTransport();
        final String spreadsheetId = "1BuWoL8uGgCgx24TKtDjx-j8406BZ36xbaGyOq359sfA";

        Sheets service = new Sheets.Builder(HTTP_TRANSPORT, JSON_FACTORY, getCredentials(HTTP_TRANSPORT))
                .setApplicationName(APPLICATION_NAME)
                .build();


        List<Request> requests = new ArrayList<>();

        List<CellData> cellLine1 = new ArrayList<>();
        String dataLine1 = "Float:, ";
        if (students.get(12).get(shift).size() > 0) {
            for (int i = 0; i < students.get(12).get(shift).size(); i++) {
                dataLine1 += students.get(12).get(shift).get(i).getName() + " (" + students.get(12).get(shift).get(i).getSchedule().get(day) + "-" + students.get(12).get(shift).get(i).getSchedule().get(day + 1) + "), ";
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
                        .setWrapStrategy("Wrap")
                        .setBorders(new Borders()
                                .setTop(new Border()
                                        .setStyle("Solid"))
                                .setBottom(new Border()
                                        .setStyle("Solid")
                                )
                                .setLeft(new Border()
                                        .setStyle("Solid"))
                                .setRight(new Border()
                                        .setStyle("Solid")))));


        requests.add(new Request()
                .setUpdateCells(new UpdateCellsRequest()
                        .setRows(Arrays.asList(
                                new RowData().setValues(cellLine1)))
                        .setStart(new GridCoordinate()
                                .setSheetId(1656413616)
                                .setRowIndex(46)
                                .setColumnIndex(shift))
                        .setFields("userEnteredValue,userEnteredFormat")));

        BatchUpdateSpreadsheetRequest body = new BatchUpdateSpreadsheetRequest().setRequests(requests);
        BatchUpdateSpreadsheetResponse response = service.spreadsheets()
                .batchUpdate(spreadsheetId, body).execute();
    }
    private void setProductionDuckListValues(List<List<List<String>>> fullTime,int shift)throws IOException, GeneralSecurityException{

        final NetHttpTransport HTTP_TRANSPORT = GoogleNetHttpTransport.newTrustedTransport();
        final String spreadsheetId = "1BuWoL8uGgCgx24TKtDjx-j8406BZ36xbaGyOq359sfA";

        Sheets service = new Sheets.Builder(HTTP_TRANSPORT, JSON_FACTORY, getCredentials(HTTP_TRANSPORT))
                .setApplicationName(APPLICATION_NAME)
                .build();

        List<Request> requests = new ArrayList<>();

        List<CellData> cellLine1 = new ArrayList<>();
        String dataLine1 = "AM Production: ";

        if(fullTime.get(11).get(shift).size() > 0){
            for(int i = 0; i < fullTime.get(11).get(shift).size(); i++){
                dataLine1 += fullTime.get(11).get(shift).get(i) +", ";
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
                        .setWrapStrategy("Wrap")
                        .setBorders(new Borders()
                                .setTop(new Border()
                                        .setStyle("Solid"))
                                .setBottom(new Border()
                                        .setStyle("Solid")
                                )
                                .setLeft(new Border()
                                        .setStyle("Solid"))
                                .setRight(new Border()
                                        .setStyle("Solid")))));


        requests.add(new Request()
                .setUpdateCells(new UpdateCellsRequest()
                        .setRows(Arrays.asList(
                                new RowData().setValues(cellLine1)))
                        .setStart(new GridCoordinate()
                                .setSheetId(1656413616)
                                .setRowIndex(48)
                                .setColumnIndex(shift))
                        .setFields("userEnteredValue,userEnteredFormat")));


        BatchUpdateSpreadsheetRequest body = new BatchUpdateSpreadsheetRequest().setRequests(requests);
        BatchUpdateSpreadsheetResponse response = service.spreadsheets()
                .batchUpdate(spreadsheetId, body).execute();
    }

    /**
     * Retrieves students string of employees from Duck List
     * @param line String to search for students on
     * @return list of students
     *
     */
    private List<String> getStudentsFromString(String line){

        List<String> names = Arrays.asList(line.split(",[ ]*"));
        List<String> studentNames = new ArrayList<>();
        for(String name: names){
            if(name.contains("(")){ studentNames.add(name.substring(0, name.indexOf("(")-1)); }
        }
        return studentNames;
    }
    /**
     * Gets values from completed Duck List
     * @return list of strings taken from Duck List values
     * @throws IOException
     * @throws GeneralSecurityException
     */
    private List<List<List<String>>> getDuckListValues()throws IOException, GeneralSecurityException{
        final NetHttpTransport HTTP_TRANSPORT = GoogleNetHttpTransport.newTrustedTransport();
        final String spreadsheetId = "1BuWoL8uGgCgx24TKtDjx-j8406BZ36xbaGyOq359sfA";
        Sheets service = new Sheets.Builder(HTTP_TRANSPORT, JSON_FACTORY, getCredentials(HTTP_TRANSPORT))
                .setApplicationName(APPLICATION_NAME)
                .build();

        ValueRange response = service.spreadsheets().values()
                .get(spreadsheetId, "Ducklist")
                .execute();

        List<List<Object>> values = response.getValues();


        List<List<List<String>>> students = new ArrayList<>();
        for(int i = 0; i < 13; i++) {
            List<List<String>> station = new ArrayList<>();
            students.add(station);
        }

        for(int i = 3; i < 5; i++) {
            if(values.get(i).size() > 0){
                for(int j = 0; j < values.get(i).size(); j++){
                    students.get(0).add(getStudentsFromString((String)values.get(i).get(j)));
                }
            }
        }
        for(int i = 6; i < 9; i++){
            if(values.get(i).size() > 0){
                for(int j = 0; j < values.get(i).size(); j++){
                    students.get(1).add(getStudentsFromString((String)values.get(i).get(j)));
                }
            }
        }
        for(int i = 10; i < 13; i++){
            if(values.get(i).size() > 0){
                for(int j = 0; j < values.get(i).size(); j++){
                    students.get(2).add(getStudentsFromString((String)values.get(i).get(j)));
                }
            }
        }
        for(int i = 14; i < 17; i++){
            if(values.get(i).size() > 0){
                for(int j = 0; j < values.get(i).size(); j++){
                    students.get(3).add(getStudentsFromString((String)values.get(i).get(j)));
                }
            }
        }
        for(int i = 18; i < 23; i++){
            if(values.get(i).size() > 0){
                for(int j = 0; j < values.get(i).size(); j++){
                    students.get(4).add(getStudentsFromString((String)values.get(i).get(j)));
                }
            }
        }
        for(int i = 24; i < 26; i++){
            if(values.get(i).size() > 0){
                for(int j = 0; j < values.get(i).size(); j++){
                    students.get(5).add(getStudentsFromString((String)values.get(i).get(j)));
                }
            }
        }
        for(int i = 27; i < 29; i++){
            if(values.get(i).size() > 0){
                for(int j = 0; j < values.get(i).size(); j++){
                    students.get(6).add(getStudentsFromString((String)values.get(i).get(j)));
                }
            }
        }
        for(int i = 30; i < 32; i++){
            if(values.get(i).size() > 0){
                for(int j = 0; j < values.get(i).size(); j++){
                    students.get(7).add(getStudentsFromString((String)values.get(i).get(j)));
                }
            }
        }
        for(int i = 33; i < 35; i++){
            if(values.get(i).size() > 0){
                for(int j = 0; j < values.get(i).size(); j++){
                    students.get(8).add(getStudentsFromString((String)values.get(i).get(j)));
                }
            }
        }
        for(int i = 36; i < 38; i++){
            if(values.get(i).size() > 0){
                for(int j = 0; j < values.get(i).size(); j++){
                    students.get(9).add(getStudentsFromString((String)values.get(i).get(j)));
                }
            }
        }
        for(int i = 39; i < 46; i++){
            if(values.get(i).size() > 0){
                for(int j = 0; j < values.get(i).size(); j++){
                    students.get(10).add(getStudentsFromString((String)values.get(i).get(j)));
                }
            }
        }
        if(values.get(48).size() > 0){
            for(int j = 0; j < values.get(48).size(); j++){
                students.get(11).add(getStudentsFromString((String)values.get(48).get(j)));
            }
        }
        if(values.get(46).size() > 0){
            for(int j = 0; j < values.get(46).size(); j++){
                students.get(12).add(getStudentsFromString((String)values.get(46).get(j)));
            }
        }

        return students;

    }
    /**
     * Sorts list of students to be placed on Duck List (Leads first, in order of arrival time)
     * @param students list of students to be sorted
     * @param day int representing day of scheduling
     * @return sorted list of students
     */
    private List<Student> sortStudents(List<Student> students,  int day){
        final int day1 = day;
        List<Student> sortedStudents = new ArrayList<>();
        for(int i = 0; i < students.size(); i++){
            if(students.get(i).getLead()){
                sortedStudents.add(students.get(i));
                students.remove(i);
            }
        }

        Collections.sort(students, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return  o1.getSchedule().get(day1).toString().compareTo(o2.getSchedule().get(day1).toString());
            }
        });
        Collections.sort(sortedStudents, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return  o1.getSchedule().get(day1).toString().compareTo(o2.getSchedule().get(day1).toString());
            }
        });
        for(Student student: students){
            sortedStudents.add(student);
        }
        return sortedStudents;

    }
    /**
     * Calls sortStudents on entirety of masterList of students
     * @param students masterList of students
     * @param day int representing day of shifts
     * @returns sorted masterList of students
     */
    public List<List<List<Student>>> sortMasterStudentList(List<List<List<Student>>> students, int day){
        for(int i = 0; i < students.size(); i++)
        {
            for(int j = 0; j < students.get(i).size(); j++){
                students.get(i).set(j, sortStudents(students.get(i).get(j), day));
            }
        }
        return students;
    }
    //TODO: DOCUMENTATION
    public List<List<List<Student>>> combineMidShifts(List<List<List<Student>>> students){
        List<List<List<Student>>> combinedStudents = new ArrayList<>();
        //students.get(i).get(0)    combine( students.get(i).get(1) ""(2) ) (3)
        for(int i = 0; i < students.size(); i++){
            List<List<Student>> station = new ArrayList<>();
            List<Student> combinedMid = new ArrayList<>();
            combinedMid.addAll(students.get(i).get(1));
            combinedMid.addAll(students.get(i).get(2));
            station.add(students.get(i).get(0));
            station.add(combinedMid);
            station.add(students.get(i).get(3));
            combinedStudents.add(station);

        }
        return combinedStudents;
    }
    /**
     * Executes requests to update studentWeights sheet after a student works a shift
     * @throws IOException
     * @throws GeneralSecurityException
     */
    public void adjustStudentWeights()throws IOException, GeneralSecurityException{
        final NetHttpTransport HTTP_TRANSPORT = GoogleNetHttpTransport.newTrustedTransport();
        final String spreadsheetId = "1BuWoL8uGgCgx24TKtDjx-j8406BZ36xbaGyOq359sfA";

        Sheets service = new Sheets.Builder(HTTP_TRANSPORT, JSON_FACTORY, getCredentials(HTTP_TRANSPORT))
                .setApplicationName(APPLICATION_NAME)
                .build();
        List<List<Object>> weights = getStudentWeights();
        List<List<List<String>>> students = getDuckListValues();
        List<Request> requests = new ArrayList<>();
        List<Integer> alreadyUpdated = new ArrayList<>();
        for(int l = 0; l < students.size(); l++) {
            for (int k = 0; k < students.get(l).size(); k++) {
                for (int i = 0; i < students.get(l).get(k).size(); i++) {
                    for (int j = 1; j < weights.size(); j++) {
                        if (students.get(l).get(k).get(i).compareTo((String) weights.get(j).get(0)) == 0) {
                            if(!alreadyUpdated.contains(j)) {
                                requests = updateWorkedLast(l, j, weights.get(j), requests);
                                requests = adjustWeight(l + 1, j, weights.get(j), requests);
                                alreadyUpdated.add(j);
                                break;
                            }
                        }
                        if (students.get(l).get(k).get(i).compareTo((String) weights.get(j).get(0)) < 0) break;
                    }
                }
            }
        }
        BatchUpdateSpreadsheetRequest body = new BatchUpdateSpreadsheetRequest().setRequests(requests);
        BatchUpdateSpreadsheetResponse response = service.spreadsheets()
                .batchUpdate(spreadsheetId, body).execute();
    }
    /**
     * Adds a request to add timestamp to coverage sheet
     * @param requests list to add request to
     * @return updated list of requests
     *
     */
    private List<Request> timestampCoverage(List<Request> requests){

        LocalDateTime time =  LocalDateTime.now();
        DateTimeFormatter format =
                DateTimeFormatter.ofPattern("MM-dd-yyyy ");
        String curTime = "";
        if(time.getHour() > 12){
            curTime = Integer.toString(time.getHour()-12) + ":" + time.getMinute() + " PM";
        }
        else if(time.getHour() == 12) curTime = Integer.toString(time.getHour()) + ":" + Integer.toString(time.getMinute())+" PM";
        else curTime = Integer.toString(time.getHour()) + ":" + Integer.toString(time.getMinute())+" AM";
        String formattedDateTime = "Last Updated: " + time.format(format) + curTime;

        List<CellData> cellLine1 = new ArrayList<>();
        cellLine1.add( new CellData()
                .setUserEnteredValue(new ExtendedValue()
                        .setStringValue(formattedDateTime))
                .setUserEnteredFormat(new CellFormat()
                        .setTextFormat(new TextFormat()
                                .setFontSize(10)
                        )
                        .setWrapStrategy("Wrap")
                        .setBorders(new Borders()
                                .setTop(new Border()
                                        .setStyle("Solid"))
                                .setBottom(new Border()

                                        .setStyle("Solid")
                                )
                                .setLeft(new Border()
                                        .setStyle("Solid"))
                                .setRight(new Border()
                                        .setStyle("Solid")))));

        requests.add(new Request()
                .setUpdateCells(new UpdateCellsRequest()
                        .setRows(Arrays.asList(
                                new RowData().setValues(cellLine1)))
                        .setStart(new GridCoordinate()
                                .setSheetId(0)
                                .setRowIndex(0)
                                .setColumnIndex(4))
                        .setFields("userEnteredValue,userEnteredFormat")));
        return requests;
    }
    /**
     * Adds Request to update values of weights for individual student
     * @param station int representing station worked
     * @param index students location in studentWeights Sheet
     * @param currentWeights students current weights (to be updated)
     * @param requests list of requests to be added to
     * @returns updated list of requests
     */
    private List<Request> adjustWeight(int station, int index, List<Object> currentWeights, List<Request> requests){


        for(int i = 1; i < 13; i++){
            if(Double.parseDouble(currentWeights.get(i).toString()) != 0){
                if(station == i){
                    double weight = Double.parseDouble(currentWeights.get(i).toString());
                    if(weight > .4 && weight < 10){ weight -= 0.4;}
                    List<CellData> cellLine1 = new ArrayList<>();
                    cellLine1.add(new CellData()
                            .setUserEnteredValue(new ExtendedValue()
                                    .setNumberValue(weight))
                            .setUserEnteredFormat(new CellFormat()
                                    .setTextFormat(new TextFormat()
                                            .setFontSize(12)
                                        )
                                    .setHorizontalAlignment("Center")));

                    requests.add(new Request()
                            .setUpdateCells(new UpdateCellsRequest()
                                    .setRows(Arrays.asList(
                                            new RowData().setValues(cellLine1)))
                                    .setStart(new GridCoordinate()
                                            .setSheetId(999419915)
                                            .setRowIndex(index)
                                            .setColumnIndex(i))
                                    .setFields("userEnteredValue,userEnteredFormat")));
                }
                else{
                    double weight = Double.parseDouble(currentWeights.get(i).toString());
                    if(weight < 9.75) weight += .05;
                    List<CellData> cellLine1 = new ArrayList<>();
                    cellLine1.add(new CellData()
                            .setUserEnteredValue(new ExtendedValue()
                                    .setNumberValue(weight))
                            .setUserEnteredFormat(new CellFormat()
                                    .setTextFormat(new TextFormat()
                                            .setFontSize(12))
                                    .setHorizontalAlignment("Center")));
                    requests.add(new Request()
                            .setUpdateCells(new UpdateCellsRequest()
                                    .setRows(Arrays.asList(
                                            new RowData().setValues(cellLine1)))
                                    .setStart(new GridCoordinate()
                                            .setSheetId(999419915)
                                            .setRowIndex(index)
                                            .setColumnIndex(i))
                                    .setFields("userEnteredValue,userEnteredFormat")));
                }
            }
        }
        return requests;

    }
    /**
     * Adds Request to update studentWeights sheet with last worked shift
     * @param station int representing station worked
     * @param index students location in studentWeights Sheet
     * @param currentWeights students current weights (and worked last) (to be updated)
     * @param requests list of requests to be added to
     * @returns updated list of requests
     */
    private List<Request> updateWorkedLast(int station, int index, List<Object> currentWeights, List<Request> requests){
        String secondLast = currentWeights.get(15).toString();
        String last = currentWeights.get(14).toString();
        String newLast = "";
        if(station == 0) newLast = "Checker";
        else if(station == 1) newLast = "Middle";
        else if(station == 2) newLast = "Curry";
        else if(station == 3) newLast = "Grange";
        else if(station == 4) newLast = "Toast";
        else if(station == 5) newLast = "Hearth";
        else if(station == 6) newLast = "Peaks";
        else if(station == 7) newLast = "Salads";
        else if(station == 8) newLast = "Cold Runner";
        else if(station == 9) newLast = "DRA";
        else if(station == 10) newLast = "Dish";
        else if(station == 11) newLast = "Janitor";
        else if(station == 12) newLast = "Float";




        List<CellData> lastPlacement = new ArrayList<>();
        List<CellData> secondLastPlacement = new ArrayList<>();
        List<CellData> thirdLastPlacement = new ArrayList<>();
        lastPlacement.add(new CellData()
                .setUserEnteredValue(new ExtendedValue()
                        .setStringValue(newLast))
                .setUserEnteredFormat(new CellFormat()
                        .setTextFormat(new TextFormat()
                                .setFontSize(12)
                        )
                        .setHorizontalAlignment("Center")));
        secondLastPlacement.add(new CellData()
                .setUserEnteredValue(new ExtendedValue()
                        .setStringValue(last))
                .setUserEnteredFormat(new CellFormat()
                        .setTextFormat(new TextFormat()
                                .setFontSize(12)
                        )
                        .setHorizontalAlignment("Center")));
        thirdLastPlacement.add(new CellData()
                .setUserEnteredValue(new ExtendedValue()
                        .setStringValue(secondLast))
                .setUserEnteredFormat(new CellFormat()
                        .setTextFormat(new TextFormat()
                                .setFontSize(12)
                        )
                        .setHorizontalAlignment("Center")));

        requests.add(new Request()
                .setUpdateCells(new UpdateCellsRequest()
                        .setRows(Arrays.asList(
                                new RowData().setValues(lastPlacement)))
                        .setStart(new GridCoordinate()
                                .setSheetId(999419915)
                                .setRowIndex(index)
                                .setColumnIndex(14))
                        .setFields("userEnteredValue,userEnteredFormat")));
        requests.add(new Request()
                .setUpdateCells(new UpdateCellsRequest()
                        .setRows(Arrays.asList(
                                new RowData().setValues(secondLastPlacement)))
                        .setStart(new GridCoordinate()
                                .setSheetId(999419915)
                                .setRowIndex(index)
                                .setColumnIndex(15))
                        .setFields("userEnteredValue,userEnteredFormat")));
        requests.add(new Request()
                .setUpdateCells(new UpdateCellsRequest()
                        .setRows(Arrays.asList(
                                new RowData().setValues(thirdLastPlacement)))
                        .setStart(new GridCoordinate()
                                .setSheetId(999419915)
                                .setRowIndex(index)
                                .setColumnIndex(16))
                        .setFields("userEnteredValue,userEnteredFormat")));

        return requests;
    }
    /**
     * Adds input to requested dish string
     * @param lines arrayList of Dish lines (strings)
     * @param line number of line to edit
     * @param input string to be appended to line
     * @returns updated list of strings
     */
    private ArrayList<String> setDishString(ArrayList<String> lines, int line, String input){
        lines.set(line, lines.get(line)+input);
        return lines;
    }




}
