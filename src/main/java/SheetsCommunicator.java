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





}
