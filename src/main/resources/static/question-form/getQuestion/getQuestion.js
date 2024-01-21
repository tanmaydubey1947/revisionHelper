function searchQuestions() {
    const topicDropdown = document.getElementById('topicDropdown').value;
    const tagsDropdown = document.getElementById('tagsDropdown').value;

    fetch(`http://localhost:8080/api/questions/getQuestion/${topicDropdown}/${tagsDropdown}`)
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

document.addEventListener('DOMContentLoaded', function () {
fetchTopics();
});

 function fetchTopics() {
     const topicDropdown = document.getElementById('topicDropdown');
     const tagsDropdown = document.getElementById('tagsDropdown');

     topicDropdown.addEventListener('change', function () {
         const selectedTopic = topicDropdown.value;
         fetchTags(selectedTopic, tagsDropdown);
     });

     fetch('http://localhost:8080/api/questions/getAllTopic')
         .then(response => response.json())
         .then(topics => {
             // Populate the topic dropdown
             topics.forEach(topic => {
                 const option = document.createElement('option');
                 option.value = topic;
                 option.textContent = topic;
                 topicDropdown.appendChild(option);
             });
         })
         .catch(error => console.error('Error fetching topics:', error));
 }

 function fetchTags(selectedTopic, tagsDropdown) {
     fetch(`http://localhost:8080/api/questions/getTagsByTopic/${selectedTopic}`)
         .then(response => response.json())
         .then(tags => {
             tagsDropdown.innerHTML = '';

             tags.forEach(tag => {
                 const option = document.createElement('option');
                 option.value = tag;
                 option.textContent = tag;
                 tagsDropdown.appendChild(option);
             });
         })
         .catch(error => console.error('Error fetching tags:', error));
 }
