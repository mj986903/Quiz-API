# Quiz-Application
Quiz API is a web service that enables developers to seamlessly incorporate quiz functionalities into their applications, websites, or platforms. It offers endpoints for managing quiz &amp; questions, creating and customizing random questions quizzes, and tracking user performance. Features often include various question types and categorization.
</br>
</br>
<h2>API EndPoints :</h2>
    <br />
    <p>
      &nbsp &nbsp <b>BaseURL</b> = Set variable with initial value as your
      server base URL in your postman collection.
    </p>
    <ol>
      <li>
        <h4>Get all questions :</h4>
        <ul>
          <li>Method = GET</li>
          <li>URL = {{BaseURL}}/question/allQuestions</li>
        </ul>
      </li>
      <li>
        <h4>Get questions by category :</h4>
        <ul>
          <li>Method = GET</li>
          <li>URL = {{BaseURL}}/question/category/{category}</li>
        </ul>
      </li>
      <li>
        <h4>Add question :</h4>
        <ul>
          <li>Method = POST</li>
          <li>URL = {{BaseURL}}/question/add</li>
          <li>
            Body = JSON object (category, questionTitle, rightAnswer,
            difficultyLevel, option1, option2, option3, option4)
          </li>
        </ul>
      </li>
      <li>
        <h4>Update question :</h4>
        <ul>
          <li>Method = PUT</li>
          <li>URL = {{BaseURL}}/question/update</li>
          <li>
            Body = JSON object (id, category, questionTitle, rightAnswer,
            difficultyLevel, option1, option2, option3, option4)
          </li>
        </ul>
      </li>
      <li>
        <h4>Create quiz :</h4>
        <ul>
          <li>Method = POST</li>
          <li>URL = {{BaseURL}}/quiz/create</li>
          <li>Body = Form data (category, noOfQuestion, title)</li>
        </ul>
      </li>
      <li>
        <h4>Get quiz :</h4>
        <ul>
          <li>Method = GET</li>
          <li>URL = {{BaseURL}}/quiz/get/{quizId}</li>
        </ul>
      </li>
      <li>
        <h4>Submit quiz :</h4>
        <ul>
          <li>Method = GET</li>
          <li>URL = {{BaseURL}}/quiz/submit/{quizId}</li>
          <li>Body = JSON objects (id, response)</li>
        </ul>
      </li>
      <li>
        <h4>Delete quiz :</h4>
        <ul>
          <li>Method = DELETE</li>
          <li>URL = {{BaseURL}}/quiz/delete/{quizId}</li>
        </ul>
      </li>
    </ol>
