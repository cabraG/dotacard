package cabra.dotacard.entity;

import java.util.List;

public class ValueCard {




    private int card_id;

    private int base_card_id;

    private String card_type;

    private Card_name card_name;

    private Card_text card_text;

    private Mini_image mini_image;

    private Large_image large_image;

    private Ingame_image ingame_image;

    private String illustrator;

    private boolean is_black;


    private boolean is_red;

    private boolean is_green;
    private boolean is_blue;

    private int mana_cost;

    private int gold_cost;

    private int attack;
    private int hit_points;
    private int armor;
    private String sub_type;

    public boolean isIs_crosslane() {
        return is_crosslane;
    }

    public void setIs_crosslane(boolean is_crosslane) {
        this.is_crosslane = is_crosslane;
    }

    private boolean is_crosslane;

    public int getNumrarity() {
        return numrarity;
    }

    public void setNumrarity(int numrarity) {
        this.numrarity = numrarity;
    }

    private int numrarity;

    public String getRarity() {
        return rarity;
    }

    public void setRarity(String rarity) {
        this.rarity = rarity;
    }

    private String rarity;


    private List<References> references ;

    public boolean isIs_black() {
        return is_black;
    }

    public int getItem_def() {
        return item_def;
    }

    public void setItem_def(int item_def) {
        this.item_def = item_def;
    }

    private int item_def;

    public boolean isIs_red() {
        return is_red;
    }

    public void setIs_red(boolean is_red) {
        this.is_red = is_red;
    }

    public boolean isIs_green() {
        return is_green;
    }

    public void setIs_green(boolean is_green) {
        this.is_green = is_green;
    }

    public boolean isIs_blue() {
        return is_blue;
    }

    public void setIs_blue(boolean is_bule) {
        this.is_blue = is_bule;
    }


    public int getGold_cost() {
        return gold_cost;
    }

    public void setGold_cost(int gold_cost) {
        this.gold_cost = gold_cost;
    }

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public int getHit_points() {
        return hit_points;
    }

    public void setHit_points(int hit_points) {
        this.hit_points = hit_points;
    }

    public int getArmor() {
        return armor;
    }

    public void setArmor(int armor) {
        this.armor = armor;
    }

    public String getSub_type() {
        return sub_type;
    }

    public void setSub_type(String sub_type) {
        this.sub_type = sub_type;
    }



    public void setCard_id(int card_id){
        this.card_id = card_id;
    }
    public int getCard_id(){
        return this.card_id;
    }
    public void setBase_card_id(int base_card_id){
        this.base_card_id = base_card_id;
    }
    public int getBase_card_id(){
        return this.base_card_id;
    }
    public void setCard_type(String card_type){
        this.card_type = card_type;
    }
    public String getCard_type(){
        return this.card_type;
    }
    public void setCard_name(Card_name card_name){
        this.card_name = card_name;
    }
    public Card_name getCard_name(){
        return this.card_name;
    }
    public void setCard_text(Card_text card_text){
        this.card_text = card_text;
    }
    public Card_text getCard_text(){
        return this.card_text;
    }
    public void setMini_image(Mini_image mini_image){
        this.mini_image = mini_image;
    }
    public Mini_image getMini_image(){
        return this.mini_image;
    }
    public void setLarge_image(Large_image large_image){
        this.large_image = large_image;
    }
    public Large_image getLarge_image(){
        return this.large_image;
    }
    public void setIngame_image(Ingame_image ingame_image){
        this.ingame_image = ingame_image;
    }
    public Ingame_image getIngame_image(){
        return this.ingame_image;
    }
    public void setIllustrator(String illustrator){
        this.illustrator = illustrator;
    }
    public String getIllustrator(){
        return this.illustrator;
    }
    public void setIs_black(boolean is_black){
        this.is_black = is_black;
    }
    public boolean getIs_black(){
        return this.is_black;
    }
    public void setMana_cost(int mana_cost){
        this.mana_cost = mana_cost;
    }
    public int getMana_cost(){
        return this.mana_cost;
    }
    public void setReferences(List<References> references){
        this.references = references;
    }
    public List<References> getReferences(){
        return this.references;
    }


}
