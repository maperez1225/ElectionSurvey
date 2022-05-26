const resultsContainer = document.getElementById("resultsContainer");
const getCandidatesAPI = async ()=>{
    let response = await fetch(`http://localhost:8080/ElectionSurvey/api/candidates/all`,{method:'GET'});
    let obj = await response.json();
    let total = 0;
    for (let i in obj) {
        total += obj[i].votes;
    }
    for (let i in obj) {
        resultsContainer.innerHTML += `
<h2>${obj[i].names}</h2>
<h5>${100*(obj[i].votes/total)} %</h5>
<div></div>
        `.trim();
    }
}
getCandidatesAPI();