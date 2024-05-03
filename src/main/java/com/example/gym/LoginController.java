package com.example.gym;

import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;

import javax.xml.transform.Result;
import java.sql.*;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.Properties;
import java.util.concurrent.Executor;

import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import static com.example.gym.apps.SwitchSene;
import static com.example.gym.apps.main;

public class LoginController {





        @FXML
        private Button close;

        @FXML
        private Button si_login;
        @FXML
        private AnchorPane main_f;

        @FXML
        private PasswordField si_password;

        @FXML
        private TextField si_username;

        @FXML
        private Button signup;

        @FXML
        private TextField su_email;

        @FXML
        private PasswordField su_password;

        @FXML
        private Button su_signup;

        @FXML
        private TextField su_username;

        @FXML
        private Label loginLabel;


        private Connection connect;
        private PreparedStatement prepare;
        private ResultSet result;
        void alertError(){

            Alert alert=new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error message");
            alert.setHeaderText(null);
            alert.setContentText("Please fill passwrod and username");
            alert.showAndWait();

        }
        double x=0,y=0;

        public void login()
        {
            String sql="SELECT * FROM admin WHERE username= ? AND password= ?";
            connect = Database.connectDb();
            try {
                prepare=connect.prepareStatement(sql);
                prepare.setString(1,si_username.getText());
                prepare.setString(2,si_password.getText());
                result=prepare.executeQuery();
                Alert alert;
                if(si_username.getText().isEmpty() || si_password.getText().isEmpty())
                {
                    alertError();
                }
                else {
                    if(result.next())
                    {   data.setUsername(si_username.getText());
                        si_username.setText("");
                        si_password.setText("");
                        alert=new Alert(Alert.AlertType.INFORMATION);
                        alert.setTitle("information message");
                        alert.setHeaderText(null);
                        alert.setContentText("welcome "+data.getUsername()+", Do you want to access ?");
                        alert.showAndWait();
                         alert.close();
                        si_login.getScene().getWindow().hide();
                        Stage stage=new Stage();
                       //SwitchSene("dashboard",1100,600);
                        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("dashboard.fxml")));
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

                        scene.getStylesheets().add("DashboardStyle.css");
                        // scene.getStylesheets().add("DashboardStyle.css");
                        stage.setScene(scene);
                        stage.show();


                    }
                    else{ alert=new Alert(Alert.AlertType.ERROR);
                        alert.setTitle("Error message");
                        alert.setHeaderText(null);
                        alert.setContentText("Wrong passwrod or username");
                        alert.showAndWait();


                    }
                }


            }catch (Exception e) {
                e.printStackTrace();
            }
        }

        @FXML
        private AnchorPane interfaceGYM;
        @FXML
        private AnchorPane interfaceSU;
        @FXML
        private AnchorPane   interfaceLogin;

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
        public void clearbtn()
        {
            su_email.setText("");
            su_username.setText("");
            su_password.setText("");
        }
        public void signup()
        {
            String sql="INSERT INTO admin (username,password,email) values (?,?,?)";
            connect = Database.connectDb();
            try {
                if(su_username.getText().isEmpty() || su_password.getText().isEmpty() ||su_password.getText().length()<8)
                    alertError();
                else
                {
                    prepare=connect.prepareStatement(sql);

                    prepare.setString(1,su_username.getText());
                    prepare.setString(2,su_password.getText());
                    prepare.setString(3,su_email.getText());
                    prepare.executeUpdate();

                    Alert alert=new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("information message");
                    alert.setHeaderText(null);
                    alert.setContentText("succes create new account");
                    alert.showAndWait();

                    su_password.setText("");
                    su_username.setText("");
                    su_email.setText("");
                }
            }catch (Exception e) {
                e.printStackTrace();
            }
        }
        @FXML
        Label edit_label;

        @FXML
        private Button singup2;
        public void translateSlider(){
            TranslateTransition slider=new TranslateTransition();
            slider.setNode(interfaceGYM);
            slider.setToX(300);
            slider.setDuration(Duration.seconds(.5));
            slider.play();
            interfaceSU.setVisible(true);
            interfaceLogin.setVisible(false);
            slider.setOnFinished((ActionEvent event)->{

                edit_label.setText("Login Account");
                singup2.setVisible(true);
                signup.setVisible(false);






            });}
        public void hidesignup(){
            TranslateTransition slider=new TranslateTransition();
            slider.setNode(interfaceGYM);
            slider.setToX(0);
            slider.setDuration(Duration.seconds(.5));
            slider.play();

            interfaceSU.setVisible(false);
            slider.setOnFinished((ActionEvent event)->{

                edit_label.setText("Create an account");
                interfaceLogin.setVisible(true);
                singup2.setVisible(false);
                signup.setVisible(true);





            });


        }


    }
