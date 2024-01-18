import React, { useEffect, useState } from 'react'
import Modal from 'react-modal'
import { setAppElement } from 'react-modal'
import { fetchRandomQuestions } from './Api'
import axios from 'axios'
import './quiz.css'

setAppElement('#root');

const Quiz = () => {
  const [questions, setQuestions] = useState([]);
  const [userAnswers, setUserAnswers] = useState({});
  const [score, setScore] = useState(0);
  const [modalIsOpen, setModalIsOpen] = useState(false);

  useEffect(() => {
    // Fetch questions when the component mounts
    fetchRandomQuestions()
      .then((data) => {
        setQuestions(data);
      })
      .catch((error) => {
        console.error('Error fetching questions:', error);
      });
  }, []);

  const handleAnswer = (questionId, selectedAnswer) => {
    setUserAnswers({
      ...userAnswers,
      [questionId]: selectedAnswer,
    });
  };

  const saveUserAnswers = (userAnswers) => {
    // Send user answers to the server
    axios.post('http://localhost:8080/api/answers', userAnswers)
      .then((response) => {
        // Handle the response
        console.log('Request successful:', response);
      })
      .catch((error) => {
        // Handle errors
        console.error('Request failed:', error);
      });
  };

  const handleSubmit = () => {
    let currentScore = 0;
    for (const question of questions) {
      const userAnswer = userAnswers[question.questionId];

      if (userAnswer === question.correctAnswer) {
        currentScore += 1;
      }
    }
    setScore(currentScore);
    setModalIsOpen(true);

    // Call the function to save user answers
    saveUserAnswers(userAnswers);
  };

  const closeModal = () => {
    //reset the score and user answers
    setScore(0);
    setUserAnswers({});
    setModalIsOpen(false);
  };

  return (
    <div className='question-container'>
      <ul>
        {questions.map((question, index) => (
          <div className='question-box' key={question.questionId}>
            <h3>{index + 1}. {question.questionText}</h3>
            <form>
              <label>
                <input
                  type="radio"
                  name={`question_${question.questionId}`}
                  value="A"
                  checked={userAnswers[question.questionId] === 'A'}
                  onChange={() => handleAnswer(question.questionId, 'A')}
                />
                {question.optionA}
              </label>
              <br />
              <label>
                <input
                  type="radio"
                  name={`question_${question.questionId}`}
                  value="B"
                  checked={userAnswers[question.questionId] === 'B'}
                  onChange={() => handleAnswer(question.questionId, 'B')}
                />
                {question.optionB}
              </label>
              <br />
              <label>
                <input
                  type="radio"
                  name={`question_${question.questionId}`}
                  value="C"
                  checked={userAnswers[question.questionId] === 'C'}
                  onChange={() => handleAnswer(question.questionId, 'C')}
                />
                {question.optionC}
              </label>
              <br />
              <label>
                <input
                  type="radio"
                  name={`question_${question.questionId}`}
                  value="D"
                  checked={userAnswers[question.questionId] === 'D'}
                  onChange={() => handleAnswer(question.questionId, 'D')}
                />
                {question.optionD}
              </label>
            </form>
          </div>
        ))}
      </ul>

      <div className='button-container'>
      <button className='submit-button' onClick={handleSubmit}>Submit</button>
      </div> 

      <Modal
        isOpen={modalIsOpen}
        onRequestClose={closeModal}
        contentLabel="Score Modal"
      >
        <div className="modal-content">
        <h2>Your Score</h2>
        <p>Your score is: {score}</p>
        <button className="close-button" onClick={closeModal}>
          Close
        </button>
        </div>
      </Modal>
    </div>
  );
};

export default Quiz
