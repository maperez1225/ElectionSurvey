export default class Candidate {
    votes;
    constructor(id, image, names) {
        this.id = id;
        this.names = names;
        this.image = image;
    }
}