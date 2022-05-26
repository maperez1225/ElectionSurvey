package entity;
public class Candidate {
    private int id;
    private String names;
    private String image;
    private int votes;
    public Candidate() {}
    public Candidate(int id, String names, String image, int votes) {
        this.id = id;
        this.names = names;
        this.image = image;
        this.votes = votes;
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
    public int getVotes() {
        return votes;
    }
    public void setVotes(int votes) {
        this.votes = votes;
    }
}