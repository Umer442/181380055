package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.time.LocalDate;
import java.time.Month;
import java.time.Period;

public class Main extends Application {
    private Label titleLb,firstNameLb,lastNameLb,yearLb,monthLb,dayLb,outputLb;
    private TextField firstNameTextfield,lastNameTextfield,yearTextfield,
            monthTextfield,dayTextfield;
    private VBox vbox,yearVBox,monthVBox,dayVBox;
    private HBox HBox;
    @Override
    public void start(Stage primaryStage) {
        //create title label
        titleLb = new Label("Heart Rate Calculator");
        titleLb.setStyle("-fx-font:26px Arial");
        //create first name label
        firstNameLb = new Label("first Name");
        //create last name label
        lastNameLb = new Label("last Name");
        //create year label
        yearLb = new Label("year");
        //create month label
        monthLb = new Label("month");
        //create day label
        dayLb = new Label("day");
        //create output label
        outputLb = new Label();
        outputLb.setStyle("-fx-font:24px Arial;-fx-text-fill:blue;");

        //create first name textfield
        firstNameTextfield = new TextField();
        //create last name textfield
        lastNameTextfield = new TextField();
        //create year textfield
        yearTextfield = new TextField();
        //create month textfield
        monthTextfield = new TextField();
        //create day textfield
        dayTextfield = new TextField();

        //create calculate heart rate button
       Button calculateHeartRateBtn = new Button("Calculate Heart Rate");
        //create year vbox
        yearVBox = new VBox();
        //add year label and year textfield
        yearVBox.getChildren().addAll(yearLb,yearTextfield);
        //create month vbox
        monthVBox = new VBox();
        //Add month label and month textfield
        monthVBox.getChildren().addAll(monthLb,monthTextfield);
        //create day vbox
        dayVBox = new VBox();
        //Add day label and day textfield
        dayVBox.getChildren().addAll(dayLb,dayTextfield);
        //create Hbox
        HBox = new HBox();
        //Add yearvbox,monthvbox,dayvbox
        HBox.getChildren().addAll(yearVBox,monthVBox,dayVBox);
        HBox.setSpacing(20);
        //create Vbox root
        vbox = new VBox();
        //Add all controls
        vbox.getChildren().addAll(titleLb,firstNameLb,firstNameTextfield,lastNameLb
                ,lastNameTextfield,
                HBox,calculateHeartRateBtn,outputLb);
        //click listener
        calculateHeartRateBtn.setOnAction(e->{
            int year = Integer.parseInt(yearTextfield.getText());
            String monthText = monthTextfield.getText();
            int day = Integer.parseInt(dayTextfield.getText());
            String fullName = firstNameTextfield.getText() + " " + lastNameTextfield.getText();
            Month month = getMonth(monthText);
            int ageInYear = getAgeInYears(year,month,day);
            double maximumHeartRate = getHeartrate(ageInYear);
            String targetHeartRate = getTargetHeartrate(maximumHeartRate);
            String result;
            result = "Name:" + fullName + "\n"
                    + "Age:" + ageInYear + "\n"
                    + "Maximum heart rate:" + maximumHeartRate + "\n"
                    + "Target heart rate:" + targetHeartRate;
            outputLb.setText(result);
        });
        vbox.setSpacing(20);
        vbox.setPadding(new Insets(20));
        //create scene
        Scene scene = new Scene(vbox,500,500);
        //set scene
        primaryStage.setScene(scene);
        //set stage title
        primaryStage.setTitle("Heart Rate Calculator");
        primaryStage.show();

    }

    private int getAgeInYears(int year, Month m,int day) {
        LocalDate today = LocalDate.now();
        LocalDate bd = LocalDate.of(year,m,day);
        Period period = Period.between(bd,today);
        return (period.getYears());
    }

    private Month getMonth(String month){
        Month m;
        if(month.equalsIgnoreCase("January")){
            m = Month.JANUARY;
        }else if(month.equalsIgnoreCase("February")){
            m = Month.FEBRUARY;
        }else if(month.equalsIgnoreCase("March")){
            m = Month.MARCH;
        }else if(month.equalsIgnoreCase("april")){
            m = Month.APRIL;
        }
        else if(month.equalsIgnoreCase("may")){
            m = Month.MAY;
        }
        else if(month.equalsIgnoreCase("june")){
            m = Month.JUNE;
        }
        else if(month.equalsIgnoreCase("July")){
            m = Month.JULY;
        }
        else if(month.equalsIgnoreCase("August")){
            m = Month.AUGUST;
        }
        else if(month.equalsIgnoreCase("September")){
            m = Month.SEPTEMBER;
        }
        else if(month.equalsIgnoreCase("October")){
            m = Month.OCTOBER;
        }
        else if(month.equalsIgnoreCase("NOVEMBER")){
            m = Month.NOVEMBER;
        }
        else if(month.equalsIgnoreCase("DECEMBER")){
            m = Month.DECEMBER;
        }
        else {
            m = Month.JANUARY;
        }
        return m;
    }

    private double getHeartrate(int year)
    {

        return  220 - year;
    }
    private String getTargetHeartrate(double heartRate)
    {
        return  (int)(heartRate * 0.5) + " - " + (int)(heartRate * 0.85);
    }
    public static void main(String[] args) {
        launch(args);
    }
}
