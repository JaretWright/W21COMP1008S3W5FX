package models;

import java.util.Arrays;
import java.util.List;

public class Card {
    //These are the instance variables, they describe the
    //attributes that we want to model in the class.
    private String faceName, suit;
    private int faceValue;

    /**
     * The goal of the constructor is to allocate memory for the
     * object.  When this is called, it will reserve space and return
     * a "pointer" to the object.
     *
     * A constructor does not have a "return" type and it must match the
     * name of the class
     */
    public Card(String face, String suit, int faceValue)
    {
        setFaceName(face);
        setSuit(suit);
        setFaceValue(faceValue);  //valid values 2 -> 14
    }

    public String getFaceName() {
        return faceName;
    }

    /**
     * This returns a list of all the valid face names
     */
    public static List<String> getFaceNames()
    {
        return Arrays.asList("two","three","four","five","six","seven","eight",
                "nine","ten","jack","queen","king","ace");
    }

    /**
     * This will ensure that the face name represents a valid face name.
     * @param faceName - two, three, four,...,ten, jack, queen, king, ace
     */
    public void setFaceName(String faceName) {
        faceName = faceName.toLowerCase();

        List<String> validFaceNames = getFaceNames();
        if (validFaceNames.contains(faceName))
            this.faceName = faceName;
        else
            throw new IllegalArgumentException(faceName +" is not valid, choose from: " + validFaceNames);
    }

    public String getSuit() {
        return suit;
    }

    /**
     * This method will validate that the argument is hearts, diamonds, spades or clubs
     * and set the instance variable
     * @param suit
     */
    public void setSuit(String suit) {
        suit = suit.toLowerCase();
        List<String> validSuits = getSuits();
        if (validSuits.contains(suit))
            this.suit = suit;
        else
            throw new IllegalArgumentException(suit + " is not valid, valid options are: "+validSuits);
    }

    public static List<String> getSuits()
    {
        return Arrays.asList("hearts","diamonds","spades","clubs");
    }

    public int getFaceValue() {
        return faceValue;
    }

    /**
     * This represents the card value and must be between 2-14 and set the instance variable
     * @param faceValue (values 2-14)
     */
    public void setFaceValue(int faceValue) {
        if (faceValue>=2 && faceValue<=14)
            this.faceValue = faceValue;
        else
            throw new IllegalArgumentException("face value must be 2-14 inclusive");
    }

    public String toString()
    {
        return faceName + " of " + suit;
    }
}
