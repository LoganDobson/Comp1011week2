package com.example.comp1011week2;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.util.ResourceBundle;

public class BookViewController implements Initializable {

    @FXML
    private TextField authorTextField;

    @FXML
    private CheckBox availabilityCheckBox;

    @FXML
    private TextField bookNameTextField;

    @FXML
    private Label finalLabel;

    @FXML
    private ComboBox<String> genreComboBox;

    @FXML
    private Spinner<Double> priceSpinner;

    @FXML
    void saveBook(ActionEvent event) {
        try {


            String bookName = bookNameTextField.getText();
            String author = authorTextField.getText();
            String genre = genreComboBox.getSelectionModel().getSelectedItem();
            double price = priceSpinner.getValue();
            boolean available = availabilityCheckBox.isSelected();

            Book book1 = new Book(1, bookName, author, genre, price, available);
            finalLabel.setVisible(true);
            finalLabel.setText(book1.toString());
        }
        catch (Exception e){
            finalLabel.setVisible(true);
            finalLabel.setText(e.getMessage());
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        finalLabel.setVisible(false);
        genreComboBox.getItems().addAll(Book.findGenres());
        SpinnerValueFactory<Double> spinnerValueFactory = new SpinnerValueFactory.DoubleSpinnerValueFactory(20.00,200.00,2.00,5.00);
        priceSpinner.setValueFactory(spinnerValueFactory);
        priceSpinner.setEditable(true);

        // anonymous inner class

        TextField spinnerTextField =  priceSpinner.getEditor();

        spinnerTextField.textProperty().addListener((observableValue, oldValue, newValue) -> {
            try{
                Double.parseDouble(newValue);
            }catch (Exception e){
                finalLabel.setVisible(true);
                finalLabel.setText("only double values are allowed for price");
                e.printStackTrace();
                spinnerTextField.setText(oldValue);

            }
        });
    }


}

