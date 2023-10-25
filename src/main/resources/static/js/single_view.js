document.getElementById('updateDiagnosisForm').addEventListener('submit', function(event) {
    event.preventDefault();
    const formData = new FormData(this);
    const xhr = new XMLHttpRequest();
    xhr.open('POST', this.action, true);
    xhr.send(formData);
});