package entity;
public class Candidate {
    private int id;
    private String names;
    private String image;
    public Candidate() {}
    public Candidate(int id, String names, String image) {
        this.id = id;
        this.names = names;
        this.image = image;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getNames() {
        return names;
    }
    public void setNames(String names) {
        this.names = names;
    }
    public String getImage() {
        return image;
    }
    public void setImage(String image) {
        this.image = image;
    }
}