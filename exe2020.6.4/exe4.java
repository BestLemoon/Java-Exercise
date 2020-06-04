import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;


public class exe4 extends Application {
    TextField tfInvestmentAmount = new TextField();
    TextField tfNumberOfYears = new TextField();
    TextField tfAnnualInterestRate = new TextField();
    TextField tfFutureValue = new TextField();
    Button btCalculate = new Button("Calculate");
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        GridPane gridPane = new GridPane();
        gridPane.setHgap(5);
        gridPane.setVgap(5);

        gridPane.add(new Label("Investment Amount:"), 0, 0);
        gridPane.add(tfInvestmentAmount, 1, 0);
        gridPane.add(new Label("Number of Years:"), 0, 1);
        gridPane.add(tfNumberOfYears, 1, 1);
        gridPane.add(new Label("Annual Interest Rate:"), 0, 2);
        gridPane.add(tfAnnualInterestRate, 1, 2);
        gridPane.add(new Label("Future value:"), 0, 3);
        gridPane.add(tfFutureValue, 1, 3);
        gridPane.add(btCalculate, 1, 4);

        gridPane.setAlignment(Pos.CENTER);
        tfAnnualInterestRate.setAlignment(Pos.BOTTOM_RIGHT);
        tfNumberOfYears.setAlignment(Pos.BOTTOM_RIGHT);
        tfInvestmentAmount.setAlignment(Pos.BOTTOM_RIGHT);
        tfFutureValue.setAlignment(Pos.BOTTOM_RIGHT);
        tfFutureValue.setEditable(false);
        GridPane.setHalignment(btCalculate, HPos.RIGHT);

        btCalculate.setOnAction(e -> calculateLoanPayment());
        Scene scene = new Scene(gridPane, 400, 250);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
        private void calculateLoanPayment() {
            // Get values from text fields
            double annualInterestRate =
                    Double.parseDouble(tfAnnualInterestRate.getText());
            int numberOfYears = Integer.parseInt(tfNumberOfYears.getText());
            double investmentAmount =
                    Double.parseDouble(tfInvestmentAmount.getText());

            double monthlyInterestRate = annualInterestRate / 1200;
            double futureValue = investmentAmount *
                    Math.pow(1 + monthlyInterestRate, numberOfYears * 12);

            // Display monthly payment and total payment
            tfFutureValue.setText(String.format("$%.2f", futureValue));
        }
}

