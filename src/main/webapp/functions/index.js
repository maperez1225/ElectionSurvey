import Candidate from './Candidate.js';
import CandidateComponent from './CandidateComponent.js';
const candidatesContainer = document.getElementById("candidatesContainer");
const getCandidatesAPI = async ()=>{
    let response = await fetch(`http://localhost:8080/ElectionSurvey/api/candidates/all`,{method:'GET'});
    let obj = await response.json();
    for (let i in obj){
        let candidate = new Candidate(obj[i].id, obj[i].image, obj[i].names);
        let component = new CandidateComponent(candidate);
        component.render(candidatesContainer);
    }
}
getCandidatesAPI();