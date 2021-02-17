package controllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
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
}
