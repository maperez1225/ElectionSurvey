export default class CandidateComponent {
    constructor(candidate) {
        this.candidate = candidate;
    }
    render(container) {
        let html = `
<div class="card" style="width: 18rem;">
        `;
        if (this.candidate.image != null) {
            html += `
    <img src="${this.candidate.image}" class="card-img-top" alt="...">
            `;
        }
        html += `
    <div class="card-body" style="text-align: center">
        <h5 class="card-title">${this.candidate.names}</h5>
        <a href="#" id="button${this.candidate.id}" class="btn btn-primary">Votar</a>
    </div>
</div>
        `;
        let root = document.createElement('div');
        root.innerHTML = html.trim();
        container.appendChild(root.firstChild);
        let button = document.getElementById(`button${this.candidate.id}`);
        button.addEventListener('click', this.action.bind(this));
    }
    async action(event) {
        event.preventDefault();
        let response = await fetch(
            `http://localhost:8080/ElectionSurvey/api/candidates/vote/${this.candidate.id}`,
            {
                method:'POST'
            }
        );
        window.location.href = "results.html";
    }
}