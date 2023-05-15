package com.example.comp1011week2;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import javafx.scene.control.TextField;

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
            //double price = priceSpinner.getValue();
            boolean available = availabilityCheckBox.isSelected();

            Book book1 = new Book(1, bookName, author, genre, 12.50, available);
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

    }


}

