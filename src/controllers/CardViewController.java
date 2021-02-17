package controllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import models.*;

import java.net.URL;
import java.util.ResourceBundle;

public class CardViewController implements Initializable {

    @FXML
    private Label faceNameLabel;

    @FXML
    private Label suitLabel;

    @FXML
    private Label faceValueLabel;

    private DeckOfCards deckOfCards;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        deckOfCards = new DeckOfCards();
        Card card = deckOfCards.dealTopCard();
        faceNameLabel.setText(card.getFaceName());
        suitLabel.setText(card.getSuit());
        faceValueLabel.setText(Integer.toString(card.getFaceValue()));
    }
}
