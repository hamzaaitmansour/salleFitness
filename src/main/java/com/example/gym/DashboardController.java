package com.example.gym;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.AreaChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.*;

public class DashboardController implements Initializable{
    @FXML
    private AreaChart<?, ?> areaChart;
    static int a=9;
    @FXML
    private Button btn_coach;

    @FXML
    private Button btn_dashboard;

    @FXML
    private Button btn_membres;

    @FXML
    private Button btn_payment;

    @FXML
    private AnchorPane coachForm;

    @FXML
    private TextArea coach_adresse;

    @FXML
    private Button coach_btn_add;

    @FXML
    private Button coach_btn_delete;

    @FXML
    private Button coach_btn_reset;

    @FXML
    private Button coach_btn_update;

    @FXML
    private TableColumn<CoachData,String> coach_cln_adresse;

    @FXML
    private TableColumn<CoachData,String> coach_cln_gender;

    @FXML
    private TableColumn<CoachData, Integer> coach_cln_id;

    @FXML
    private TableColumn<CoachData,String> coach_cln_name;

    @FXML
    private TableColumn<CoachData,String> coach_cln_phone;

    @FXML
    private TableColumn<CoachData,String> coach_cln_status;

    @FXML
    private ComboBox<?> coach_gendre;

    @FXML
    private TextField coach_id;

    @FXML
    private TextField coach_name;

    @FXML
    private TextField coach_phone;

    @FXML
    private ComboBox<?> coach_status;

    @FXML
    private TableView<CoachData> coach_tableView;

    @FXML
    private AnchorPane dashboardForm;

    @FXML
    private Label incom;


    @FXML
    private AnchorPane membresForm;

    @FXML
    private TextField membres_Id;

    @FXML
    private TextArea membres_adresse;

    @FXML
    private Button membres_btn_add;

    @FXML
    private Button membres_btn_delete;

    @FXML
    private Button membres_btn_reset;

    @FXML
    private Button membres_btn_update;

    @FXML
    private DatePicker membres_datedebut;

    @FXML
    private DatePicker membres_datefin;

    @FXML
    private ComboBox<?> membres_gendre;

    @FXML
    private TextField membres_name;

    @FXML
    private TextField membres_phone;

    @FXML
    private ComboBox<String> membres_status;
    @FXML
    private ComboBox<String> membres_schudle;

    @FXML
    private TableView<MembreData> membres_tableView;

    @FXML
    private TableColumn<MembreData,String> membres_table_cln_adresse;

    @FXML
    private TableColumn<MembreData,Date> membres_table_cln_dateDebut;

    @FXML
    private TableColumn<MembreData,Date> membres_table_cln_dateFin;

    @FXML
    private TableColumn<MembreData,String> membres_table_cln_gender;

    @FXML
    private TableColumn<MembreData,Integer> membres_table_cln_id;

    @FXML
    private TableColumn<MembreData,String> membres_table_cln_name;

    @FXML
    private TableColumn<MembreData,Integer> membres_table_cln_phone;

    @FXML
    private TableColumn<MembreData,String> membres_table_cln_status;

    @FXML
    private Label nbr_coachs;

    @FXML
    private Label nbr_membres;

    @FXML
    private ComboBox<String> payment_Name;

    @FXML
    private TextField payment_amount;

    @FXML
    private Button payment_btnPay;
    @FXML
    private Button logout;

    @FXML
    private Label payment_change;

    @FXML
    private TableColumn<MembreData, Date> payment_coltableEndDate;

    @FXML
    private TableColumn<MembreData, String> payment_coltableId;

    @FXML
    private TableColumn<MembreData, String> payment_coltableName;

    @FXML
    private TableColumn<MembreData, Date> payment_coltableStartDate;

    @FXML
    private TableColumn<MembreData, String> payment_coltableStatus;

    @FXML
    private ComboBox<String> payment_customerId;

    @FXML
    private AnchorPane payment_form;

    @FXML
    private TableView<MembreData> payment_tableView;

    @FXML
    private Label payment_total;

    @FXML
    private TextField user2;
    @FXML
    private AnchorPane main_f;
    public void close(){
        Alert alert=new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("close application");
        alert.setHeaderText(null);
        alert.setContentText("Are u sure you want to close this application");
        Optional<ButtonType> option = alert.showAndWait();
        if(option.get().equals(ButtonType.OK))
            System.exit(0);
        else
            alert.close();

    }
    public void minimize(){
        Stage stage=(Stage)main_f.getScene().getWindow();
        stage.setIconified(true);
    }

    double x=0,y=0;
    @FXML
    private void logout() throws IOException {
        Alert alert=new Alert(Alert.AlertType.CONFIRMATION);
        alert.setContentText("Are you sure , You want to Logout");
        Optional<ButtonType> option = alert.showAndWait();
        if(option.get().equals(ButtonType.OK))

        {
        logout.getScene().getWindow().hide();
            Stage stage=new Stage();
            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("hello-view.fxml")));
            root.setOnMousePressed((MouseEvent event )->{
                x= event.getSceneX();
                y=event.getSceneY();

            });
            root.setOnMouseDragged((MouseEvent event )->{
                stage.setX(event.getScreenX() - x);
                stage.setY(event.getScreenY() - y);
                stage.setOpacity(.8);


            });
            root.setOnMouseReleased((MouseEvent event )->{
                stage.setOpacity(1);
            });
            stage.initStyle(StageStyle.TRANSPARENT);

            Scene scene = new Scene(root);
            stage.setTitle("Gym management Login");

            scene.getStylesheets().add("Design.css");
            // scene.getStylesheets().add("DashboardStyle.css");
            stage.setScene(scene);
            stage.show();
        }
        else
            alert.close();

    }
 int nm;
    public void dashboardnbrM()  {
        String sql="select count(id) from membre WHERE Membre_status='Paid'";
        connection=Database.connectDb();
        try{
        prepare=connection.prepareStatement(sql);
        result=prepare.executeQuery();
        if(result.next())
            nm =result.getInt("count(id)");
        nbr_membres.setText(String.valueOf(nm));}
        catch (Exception e)
    {
        e.printStackTrace();
    }

    }
    public void dashboardnbrC() {
        String sql="select count(id) from coach WHERE coach_status='Active'";
        connection=Database.connectDb();
        try{
        prepare=connection.prepareStatement(sql);
        result=prepare.executeQuery();
        if(result.next())
            nm =result.getInt("count(id)");
        nbr_coachs.setText(String.valueOf(nm));
        }catch (Exception e)
        {
            e.printStackTrace();
        }

    }
    double somme=0;
    public void dashboardIncom()  {
        String sql="select sum(price) from membre WHERE Membre_status='Paid'";
        connection=Database.connectDb();
        try{
            prepare=connection.prepareStatement(sql);
            result=prepare.executeQuery();
            if(result.next())
                somme =result.getDouble("sum(price)");
            incom.setText(String.valueOf(somme));

        }catch (Exception e)
        {
            e.printStackTrace();
        }


    }
    public void dashboardcahrt(){
        areaChart.getData().clear();
        String sql = "select dateDebut ,sum(price) from membre GROUP BY dateDebut ORDER BY TIMESTAMP(dateDebut) ASC LIMIT 10";
        try{connection=Database.connectDb();
        prepare=connection.prepareStatement(sql);
        result=prepare.executeQuery();
        XYChart.Series chart= new XYChart.Series();
        while(result.next())
            chart.getData().add(new XYChart.Data(result.getString(1),result.getDouble(2)));
        areaChart.getData().add(chart);}
        catch (Exception e)
        {
            e.printStackTrace();
        }

    }
    @FXML
    private TextField user;
    @FXML
    private TextField date;
    public void showDashboard() throws IOException, SQLException {
        dashboardForm.setVisible(true);
        coachForm.setVisible(false);
        payment_form.setVisible(false);
        membresForm.setVisible(false);

        dashboardnbrM();
        dashboardnbrC();
        dashboardIncom();
        dashboardcahrt();


    }


    public void showCoach() {
        dashboardForm.setVisible(false);
        coachForm.setVisible(true);
        payment_form.setVisible(false);
        membresForm.setVisible(false);
        coachgendreList();
        coachStatusList();
        Showcoachs();
    }
    public void showMembres() throws IOException{
        dashboardForm.setVisible(false);
        coachForm.setVisible(false);
        payment_form.setVisible(false);
        membresForm.setVisible(true);
        membreGendere();
        membreSchedule();
        membreStatus();
    }
    public void showPayment() throws IOException, SQLException {
        dashboardForm.setVisible(false);
        coachForm.setVisible(false);
        payment_form.setVisible(true);
        membresForm.setVisible(false);
        showPaymentlist();
        paymentId();
        paymentName();

    }
    // coach gendre

    public void coachgendreList()
    {
        List<String> gendreList = new ArrayList<>();
        gendreList.add("Male");
        gendreList.add("Female");
        ObservableList List = FXCollections.observableArrayList(gendreList);
        coach_gendre.setItems(List);
    }

    String status[]={"Paid", "Inpaid"};
    public void membreStatus(){
        List<String> ms = new ArrayList<>();
        ms.add(status[0]);
        ms.add(status[1]);
        ObservableList List = FXCollections.observableArrayList(ms);
        membres_status.setItems(List);
    }
    String gendreM[]={" Male ", " Female"};
    public void membreGendere(){
        List<String> ms = new ArrayList<>();
        ms.add(gendreM[0]);
        ms.add(gendreM[1]);
        ObservableList Listl = FXCollections.observableArrayList(ms);
        membres_gendre.setItems(Listl);
    }
    String scheduleM[]={" 8-11 ","11-3", " 2-5" , "20 - 23"};
    public void membreSchedule(){
        List<String> ms = new ArrayList<>();
       for(int i=0;i<4;i++)
           ms.add(scheduleM[i]);

        ObservableList Listl = FXCollections.observableArrayList(ms);
        membres_schudle.setItems(Listl);
    }

    public void paymentId() {
        ObservableList<String> list=FXCollections.observableArrayList();
        String sql="SELECT Membre_Id from membre";
        Connection connect=Database.connectDb();
        try {
            prepare = connect.prepareStatement(sql);
            result = prepare.executeQuery();
            while (result.next())
                list.add(result.getString("Membre_Id"));
            payment_customerId.setItems(list);
            paymentName();
        }catch(Exception e)
        {
            e.printStackTrace();
        }

    }
    public void paymentName() {
        ObservableList<String> list =FXCollections.observableArrayList();
        String sql=" SELECT Membre_name from membre where Membre_Id='"+payment_customerId.getSelectionModel().getSelectedItem()+"'";
        Connection connect=Database.connectDb();
       try{
        prepare=connect.prepareStatement(sql);
        result=prepare.executeQuery();
        while(result.next())
            list.add(result.getString("Membre_name"));
        payment_Name.setItems(list);
        totalSet();

           }
       catch (Exception e)
       {
           e.printStackTrace();
       }

    }
    static double total;
    public void totalSet(){
        String sql="SELECT price FROM membre WHERE Membre_Id='"+payment_customerId.getSelectionModel().getSelectedItem()+"' AND Membre_name='"+payment_Name.getSelectionModel().getSelectedItem()+"'";
        connection=Database.connectDb();
        try{prepare=connection.prepareStatement(sql);
            result=prepare.executeQuery();
            if(result.next())
            {   total=result.getDouble("price");
                payment_total.setText(" $ "+String.valueOf(total));
            }

        }catch (Exception e)
        {
            e.printStackTrace();
        }

    }
    double change=0;
    double amount=0;
    public void changePayment(){
        amount=Double.parseDouble(payment_amount.getText());
        change = amount - total;
        payment_change.setText(String.valueOf(change));
        // SET PAID
        String sql = "UPDATE membre SET Membre_status='Paid' WHERE Membre_Id='"+payment_customerId.getSelectionModel().getSelectedItem()+"'";
        connection=Database.connectDb();
        try{
            prepare=connection.prepareStatement(sql);
            prepare.executeUpdate();
            showPaymentlist();}
        catch (Exception e)
        {
            e.printStackTrace();
        }

    }


    public void coachStatusList()
    {
        List<String> StatusList = new ArrayList<>();
        StatusList.add("Active");
        StatusList.add("Inactive");
        ObservableList SList = FXCollections.observableArrayList(StatusList);
        coach_status.setItems(SList);



    }
    private ResultSet result;
    private Statement statement;
    private Connection connection;
    private PreparedStatement prepare;
    public ObservableList<CoachData> coachDataList()
    {   connection = Database.connectDb();
        ObservableList<CoachData> List =FXCollections.observableArrayList();
        String sql="SELECT * FROM coach";
        try {
          prepare=connection.prepareStatement(sql);
          result= prepare.executeQuery();
          CoachData cd;
          while(result.next())
          {
              cd =new CoachData(result.getInt("id"),result.getString("coach_Id"),result.getString("coach_name"),result.getString("coach_adresse"),result.getString("coach_gendre"),result.getInt("coach_phone"),result.getString("coach_status"));
              List.add(cd);
          }
        }catch (Exception e)
        {
            e.printStackTrace();
        }
      return List;
    }


    private ObservableList<CoachData> coachsList;
    public void Showcoachs()
    {
        coachsList=coachDataList();
        coach_cln_id.setCellValueFactory(new PropertyValueFactory<>("coach_Id"));
        coach_cln_name.setCellValueFactory(new PropertyValueFactory<>("coach_name"));
        coach_cln_adresse.setCellValueFactory(new PropertyValueFactory<>("coach_adresse"));
        coach_cln_gender.setCellValueFactory(new PropertyValueFactory<>("coach_gendre"));
        coach_cln_phone.setCellValueFactory(new PropertyValueFactory<>("coach_phone"));
        coach_cln_status.setCellValueFactory(new PropertyValueFactory<>("coach_status"));
        coach_tableView.setItems(coachsList);

    }
    public void coachSelect()
    {
        CoachData cd= coach_tableView.getSelectionModel().getSelectedItem();
        int n =coach_tableView.getSelectionModel().getSelectedIndex();
        if(n-1< -1)return;
        coach_id.setText(cd.getCoach_Id());
        coach_name.setText(cd.getCoach_name());
        coach_adresse.setText(cd.getCoach_adresse());
        coach_phone.setText(String.valueOf(cd.getCoach_phone()));


    }
    public void coachUpdate() throws SQLException {   String sql = "UPDATE coach SET coach_name='"+coach_name.getText()+"', coach_adresse='"+coach_adresse.getText()+"', coach_phone='"+coach_phone.getText()+"' ,coach_gendre='"+coach_gendre.getSelectionModel().getSelectedItem()+"',coach_status='"+coach_status.getSelectionModel().getSelectedItem()+"'WHERE coach_Id='"+coach_id.getText()+"'";
        Connection connect=Database.connectDb();
        //String sql ="DELETE FROM coach where coach_ID='"+coach_id.getText()+"'";
        prepare=connect.prepareStatement(sql);
        prepare.executeUpdate();
        Showcoachs();
        clearcoachBtn();
    }
    public void coachDelete() throws SQLException {

        String sql = "DELETE FROM coach WHERE coach_Id='"+coach_id.getText()+"'";
        connection=Database.connectDb();
        prepare=connection.prepareStatement(sql);
        prepare.executeUpdate();
        Showcoachs();
        clearcoachBtn();

    }

    public void coachADD()
    {
        String sql ="INSERT INTO coach (coach_Id , coach_name, coach_adresse , coach_gendre , coach_phone,coach_status) VALUES(?,?,?,?,?,?)";
        connection=Database.connectDb();
        try{
            if(coach_id.getText().isEmpty() || coach_phone.getText().isEmpty() || coach_adresse.getText().isEmpty() || coach_name.getText().isEmpty() || coach_gendre.getSelectionModel().getSelectedItem()==null||coach_status.getSelectionModel().getSelectedItem()==null)
            {Alert a =new Alert(Alert.AlertType.ERROR);
                a.setTitle("Empty error");
                a.setContentText("Please fill all blanks");
                a.getDialogPane().getStylesheets().add("alertDesign.css");
                a.showAndWait();}
            else {
                String checkid="SELECT coach_Id FROM coach WHERE coach_Id = '" + coach_id.getText() + "'";
                statement=connection.createStatement();
                result=statement.executeQuery(checkid);
                if(result.next())
                {
                    Alert alert=new Alert(Alert.AlertType.WARNING);
                    alert.setContentText("Ce id exist deja");
                    alert.showAndWait();
                }
                else{
                    prepare = connection.prepareStatement(sql);
                    prepare.setString(1, coach_id.getText());
                    prepare.setString(2, coach_name.getText());
                    prepare.setString(3, coach_adresse.getText());
                    prepare.setString(4, (String) coach_gendre.getSelectionModel().getSelectedItem());
                    prepare.setString(5, coach_phone.getText());
                    prepare.setString(6, (String) coach_status.getSelectionModel().getSelectedItem());
                    prepare.executeUpdate();
                }

                Showcoachs();
                clearcoachBtn();
            }


        }catch (Exception e)
        {
            e.printStackTrace();
        }

    }
    public void clearcoachBtn()
    {
        coach_phone.setText("");
        coach_name.setText("");
        coach_id.setText("");
        coach_adresse.setText("");
        coach_gendre.getSelectionModel().clearSelection();
        coach_status.getSelectionModel().clearSelection();
    }


    public ObservableList<MembreData> MembreDataList()
    {   connection = Database.connectDb();
        ObservableList<MembreData> List =FXCollections.observableArrayList();
        String sql="SELECT * FROM membre";
        try {
            prepare=connection.prepareStatement(sql);
            result= prepare.executeQuery();
            MembreData cd;
            while(result.next())
            {
                cd =new MembreData(result.getInt("id"),result.getString("membre_Id"),result.getString("membre_name"),result.getString("membre_adresse"),result.getString("membre_gendre"),result.getInt("membre_phone"),result.getDouble("price"),result.getString("membre_status"),result.getString("membre_schedule"),result.getDate("dateDebut"),result.getDate("dateFin"));
                List.add(cd);
            }
        }catch (Exception e)
        {
            e.printStackTrace();
        }
        return List;
    }
    private ObservableList<MembreData> membres;
    public void ShowMembres()
    {
        membres=MembreDataList();
        membres_table_cln_id.setCellValueFactory(new PropertyValueFactory<>("Membre_Id"));
        membres_table_cln_name.setCellValueFactory(new PropertyValueFactory<>("Membre_name"));
        membres_table_cln_adresse.setCellValueFactory(new PropertyValueFactory<>("Membre_adresse"));
        membres_table_cln_phone.setCellValueFactory(new PropertyValueFactory<>("Membre_phone"));
        membres_table_cln_gender.setCellValueFactory(new PropertyValueFactory<>("Membre_gendre"));
        membres_table_cln_dateDebut.setCellValueFactory(new PropertyValueFactory<>("dateDebut"));
        membres_table_cln_dateFin.setCellValueFactory(new PropertyValueFactory<>("dateFin"));
        membres_table_cln_status.setCellValueFactory(new PropertyValueFactory<>("Membre_status"));
        membres_tableView.setItems(membres);


    }
    public void membreSelect()
    {
        MembreData cd= membres_tableView.getSelectionModel().getSelectedItem();
        int n =membres_tableView.getSelectionModel().getSelectedIndex();
        if(n-1< -1)return;
         membres_name.setText(cd.getMembre_name());
         membres_Id.setText(cd.getMembre_Id());
         membres_phone.setText(String.valueOf(cd.getMembre_phone()));
         membres_adresse.setText(cd.getMembre_adresse());


    }
    public void membreUpdate() throws SQLException {
        String sql = "UPDATE membre SET Membre_name='"+membres_name.getText()+"', Membre_adresse='"+membres_adresse.getText()+"', Membre_phone='"+membres_phone.getText()+"' ,Membre_gendre='"+membres_gendre.getSelectionModel().getSelectedItem()+"',Membre_status='"+membres_status.getSelectionModel().getSelectedItem()+"',Membre_schedule='"+membres_schudle.getSelectionModel().getSelectedItem()+"',dateDebut='"+membres_datedebut.getValue()+"',dateFin='"+membres_datefin.getValue()+"'WHERE membre_Id='"+membres_Id.getText()+"'";
        Connection connect=Database.connectDb();
        //String sql ="DELETE FROM coach where coach_ID='"+coach_id.getText()+"'";
        prepare=connect.prepareStatement(sql);
        prepare.executeUpdate();
        ShowMembres();
        clearMembre();
    }
    public void clearMembre(){
        membres_name.setText("");
        membres_Id.setText("");
        membres_phone.setText("");
        membres_adresse.setText("");
        membres_schudle.getSelectionModel().clearSelection();
        membres_gendre.getSelectionModel().clearSelection();
        membres_status.getSelectionModel().clearSelection();

    }
    public void membreDelete() throws SQLException {

        String sql = "DELETE FROM membre WHERE Membre_Id='"+membres_Id.getText()+"'";
        connection=Database.connectDb();
        prepare=connection.prepareStatement(sql);
        prepare.executeUpdate();
        ShowMembres();
        clearMembre();

    }
    int totalDay;
    public void membreAdd()
    {
        String sql ="INSERT INTO membre (Membre_Id , Membre_name, Membre_adresse , Membre_gendre , Membre_phone,Membre_status,Membre_schedule,dateDebut,dateFin,price) VALUES(?,?,?,?,?,?,?,?,?,?)";
        connection=Database.connectDb();
        try{

                String checkid="SELECT Membre_Id FROM membre WHERE Membre_Id = '" +membres_Id.getText() + "'";
                statement=connection.createStatement();
                result=statement.executeQuery(checkid);
                if(result.next())
                {
                    Alert alert=new Alert(Alert.AlertType.WARNING);
                    alert.setContentText("Ce id exist deja");
                    alert.showAndWait();
                }
                else{
                    prepare = connection.prepareStatement(sql);
                    prepare.setString(1, membres_Id.getText());
                    prepare.setString(2, membres_name.getText());
                    prepare.setString(3, membres_adresse.getText());
                    prepare.setString(4, (String) membres_gendre.getSelectionModel().getSelectedItem());
                    prepare.setString(5, membres_phone.getText());
                    prepare.setString(6, (String) membres_status.getSelectionModel().getSelectedItem());
                    prepare.setString(7, (String) membres_schudle.getSelectionModel().getSelectedItem());
                    prepare.setString(8,String.valueOf(membres_datedebut.getValue()));
                    prepare.setString(9,String.valueOf(membres_datefin.getValue()));
                    totalDay=(int) ChronoUnit.DAYS.between(membres_datedebut.getValue(),membres_datefin.getValue());
                    prepare.setString(10, String.valueOf(totalDay*13));
                    prepare.executeUpdate();
                    ShowMembres();
                    clearMembre();
                }

        }catch (Exception e)
        {
            e.printStackTrace();
        }

    }
    ObservableList<MembreData> listm;
    public void showPaymentlist(){
        listm=MembreDataList();
        payment_coltableId.setCellValueFactory(new PropertyValueFactory<>("Membre_Id"));
        payment_coltableName.setCellValueFactory(new PropertyValueFactory<>("Membre_name"));
        payment_coltableStartDate.setCellValueFactory(new PropertyValueFactory<>("dateDebut"));
        payment_coltableEndDate.setCellValueFactory(new PropertyValueFactory<>("dateFin"));
        payment_coltableStatus.setCellValueFactory(new PropertyValueFactory<>("Membre_status"));

        payment_tableView.setItems(listm);

    }



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        user2.setText(data.getUsername());
        user.setText(data.getUsername());

        LocalDate currentTime = LocalDate.now();
        DateTimeFormatter formatter =DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String formattedTime = currentTime.format(formatter);
        date.setText(formattedTime);


        dashboardcahrt();
        dashboardIncom();
        dashboardnbrM();
        dashboardnbrC();

        coachgendreList();
        coachStatusList();
        Showcoachs();


        ShowMembres();
        membreGendere();
        membreStatus();
        membreSchedule();

        paymentId();
        paymentName();
        showPaymentlist();


    }
}
