package rayan.crypto.rayancrypto.model;

public class character_model {
    public int character_img;
    public String character_name;
    public int character_age;
    public float character_dropping;
    public String character_intro;
    public int character_price_wod;
    public float character_price_eth;
//    model img
    public int getCharacter_img(){
        return character_img;
    }
    public void setCharacter_img(int _character_img){
        character_img = _character_img;
    }
//  model name
    public String getCharacter_name(){
        return character_name;
    }
    public void setCharacter_name(String _character_name){
        character_name = _character_name;
    }
//model age
    public int getCharacter_age(){
        return character_age;
    }
    public void setCharacter_age(int _character_age){
        character_age = _character_age;
    }
//model dropping
    public float getCharacter_dropping(){
        return character_dropping;
    }
    public void setCharacter_dropping(float _character_dropping){
        character_dropping = _character_dropping;
    }
//    model intro
    public String getCharacter_intro(){
        return character_intro;
    }
    public void setCharacter_intro(String _character_intro){
        character_intro = _character_intro;
    }
//    model price wod
    public int getCharacter_price_wod(){
        return character_price_wod;
    }
    public void setCharacter_price_wod(int _character_price_wod){
        character_price_wod = _character_price_wod;
    }
//    model price eth

    public float getCharacter_price_eth(){
        return character_price_eth;
    }
    public void setCharacter_price_eth(float _character_price_eth){
        character_price_eth = _character_price_eth;
    }
}
