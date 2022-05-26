package services;
import entity.Candidate;
import provider.CandidateProvider;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.util.List;
@Path("candidates")
public class CandidateService {
    @GET
    @Path("all")
    @Produces("application/json")
    public Response getCandidates(){
        try {
            CandidateProvider provider = new CandidateProvider();
            List<Candidate> candidates = provider.getCandidates();
            return Response
                    .status(200)
                    .header("Access-Control-Allow-Origin", "*")
                    .entity(candidates)
                    .build();
        } catch(Exception e) {
            return Response
                    .status(500)
                    .entity(e.getMessage())
                    .build();
        }
    }
    @POST
    @Path("vote/{id}")
    public Response registerVote(@PathParam("id")int id){
        try {
            CandidateProvider provider = new CandidateProvider();
            provider.registerVote(id);
            return Response
                    .ok()
                    .build();
        } catch(Exception e) {
            return Response
                    .status(500)
                    .entity(e.getMessage())
                    .build();
        }
    }
}