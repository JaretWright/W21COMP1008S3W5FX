package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import models.*;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class CardViewController implements Initializable {

    @FXML
    private Label faceNameLabel;

    @FXML
    private Label suitLabel;

    @FXML
    private Label faceValueLabel;

    @FXML
    private ImageView imageView;

    private DeckOfCards deckOfCards;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        deckOfCards = new DeckOfCards();
        //add 1 line of code here to randomize the card order
        deckOfCards.shuffle();
        getNextCard();
    }

    @FXML
    private void getNextCard()
    {
        Card card = deckOfCards.dealTopCard();
        faceNameLabel.setText(card.getFaceName());
        suitLabel.setText(card.getSuit());
        faceValueLabel.setText(Integer.toString(card.getFaceValue()));
        imageView.setImage(card.getCardImage());
    }

    @FXML
    private void changeToHandOfCards(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("../views/handOfCardsView.fxml"));
        Scene scene = new Scene(root);

        //This line gets the Stage information
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();

        stage.setScene(scene);
        stage.setTitle("Hand of cards");
        stage.show();
    }
}
