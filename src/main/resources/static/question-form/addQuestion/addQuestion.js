function addQuestion() {
    const questionName = document.getElementById('questionName').value;
    const topicDropdown = document.getElementById('topicDropdown').value;
    const source = document.getElementById('source').value;
    const tags = document.getElementById('tags').value;

    const data = {
        questionName: questionName,
        topicDropdown: topicDropdown,
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

    showAlert('Question Added Successfully...');
    clearInputFields();
}


function clearInputFields() {
    document.getElementById('questionName').value = '';
    document.getElementById('topicDropdown').value = '';
    document.getElementById('source').value = '';
    document.getElementById('tags').value = '';
}

function showAlert(message) {
    alert(message);
}

document.addEventListener('DOMContentLoaded', function () {
fetchTopics();
});

 function fetchTopics() {
        const topicDropdown = document.getElementById('topicDropdown');
        fetch('http://localhost:8080/api/questions/getAllTopic')
            .then(response => response.json())
            .then(topics => {
                topics.forEach(topic => {
                    const option = document.createElement('option');
                    option.value = topic;
                    option.textContent = topic;
                    topicDropdown.appendChild(option);
                });
            })
            .catch(error => console.error('Error fetching topics:', error));
    }