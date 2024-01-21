# Revision Helper

This web application allows users to query and display questions based on topics and tags.

## Features

- **Add Question:** Allows users to add new questions with details like question name, topic, source, and tags.
- **Get Question:** Queries questions based on selected topics and tags and displays the results in a table format.

## Usage

1. **Add Question:**
   - Click on the "Add Question" button to add a new question. (This functionality redirects to the "addQuestion.html" page.)
   - Fill in the required details (question name, topic, source, and tags) and click the "Add" button to submit the question.

2. **Get Question:**
   - Click on the "Get Question" button to search for questions based on selected topics and tags. (This functionality redirects to the "getQuestion.html" page.)
   - Select a "Topic" and "Tags" from the dropdown menus.
   - Click the "Search" button to retrieve questions matching the selected criteria. The results will be displayed in a table format below the search form.

## Technologies Used

- HTML
- JavaScript
- Fetch API
- JAVA
- Spring Boot
- MySQL

## How to Run

1. Clone this repository to your local machine.
2. Open the project in a code editor.
3. Navigate to the project directory and open the `index.html` file in a web browser.
4. Use the application to add or search for questions based on topics and tags.

## Known Issues

- No error handling for failed API requests or backend errors.
- UI needs improvement

## Future Enhancements

- Implement error handling for API requests.
- Improve user interface and styling.
