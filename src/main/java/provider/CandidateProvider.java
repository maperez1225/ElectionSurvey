package provider;
import db.DBConnection;
import entity.Candidate;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
public class CandidateProvider {
    public List<Candidate> getCandidates() throws SQLException, ClassNotFoundException {
        DBConnection connection = new DBConnection();
        List<Candidate> candidates = new ArrayList<>();
        ResultSet results = connection.getData("SELECT * FROM A00370027candidates ORDER BY id");
        while(results.next()){
            int id = results.getInt("id");
            String names = results.getString("names");
            String image = results.getString("image");
            int votes = results.getInt("votes");
            candidates.add(new Candidate(id, names, image, votes));
        }
        connection.close();
        return candidates;
    }
    public void registerVote(int id) throws SQLException, ClassNotFoundException {
        DBConnection connection = new DBConnection();
        ResultSet results = connection.getData("SELECT * FROM A00370027candidates WHERE id = '"+id+"'");
        results.next();
        int votes = results.getInt("votes");
        votes++;
        connection.runQuery("UPDATE A00370027candidates SET votes = '"+votes+"' WHERE id = '"+id+"'");
        connection.close();
    }
}