function searchQuestions() {
    const topic = document.getElementById('topic').value;
    const tags = document.getElementById('tags').value;

    fetch(`http://localhost:8080/api/questions/getQuestion/${topic}/${tags}`)
        .then(response => {
            if (!response.ok) {
                throw new Error('Network response was not ok.');
            }
            return response.json();
        })
        .then(data => {
            displayQuestions(data);
        })
        .catch(error => {
            console.error('There was a problem searching questions:', error);
            // Handle error, e.g., show an error message
        });
}

function displayQuestions(questions) {
    const questionTable = document.getElementById('questionList');
    questionTable.innerHTML = ''; // Clear previous results

    if (questions.length === 0) {
        questionTable.innerHTML = '<tr><td colspan="5">No questions found.</td></tr>';
        return;
    }

    questions.forEach(question => {
        const row = document.createElement('tr');

        const idCell = document.createElement('td');
        idCell.textContent = question.questionId;
        row.appendChild(idCell);

        const nameCell = document.createElement('td');
        nameCell.textContent = question.questionName;
        row.appendChild(nameCell);

        const topicCell = document.createElement('td');
        topicCell.textContent = question.topic;
        row.appendChild(topicCell);

        const sourceCell = document.createElement('td');
        sourceCell.textContent = question.source;
        row.appendChild(sourceCell);

        const tagsCell = document.createElement('td');
        tagsCell.textContent = question.tags;
        row.appendChild(tagsCell);

        questionTable.appendChild(row);
    });
}
