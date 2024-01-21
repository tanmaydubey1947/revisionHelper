function addQuestion() {
    const questionName = document.getElementById('questionName').value;
    const topic = document.getElementById('topic').value;
    const source = document.getElementById('source').value;
    const tags = document.getElementById('tags').value;

    const data = {
        questionName: questionName,
        topic: topic,
        source: source,
        tags: tags
    };

    fetch('http://localhost:8080/api/questions/addQuestion', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(data)
    })
    .then(response => {
        if (!response.ok) {
            throw new Error('Network response was not ok.');
        }
        return response.json();
    })
    .then(data => {
        console.log('Question added successfully:', data);
    })
    .catch(error => {
        console.error('There was a problem adding the question:', error);
    });

    showAlert('Question Addedd Successfully...');
    clearInputFields();
}


function clearInputFields() {
    document.getElementById('questionName').value = '';
    document.getElementById('topic').value = '';
    document.getElementById('source').value = '';
    document.getElementById('tags').value = '';
}

function showAlert(message) {
    alert(message);
}    