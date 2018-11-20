package cabra.dotacard.entity;

public class References {
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    private int id;
    private int card_id;

    public int getRefertences_id() {
        return refertences_id;
    }

    public void setRefertences_id(int refertences_id) {
        this.refertences_id = refertences_id;
    }

    private int refertences_id;
    private String ref_type;
    private int count;

    public int getCard_id() {
        return card_id;
    }

    public void setCard_id(int card_id) {
        this.card_id = card_id;
    }

    public String getRef_type() {
        return ref_type;
    }

    public void setRef_type(String ref_type) {
        this.ref_type = ref_type;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }


}
