import axios from 'axios';
// Import the Axios library, which is used for making HTTP requests

export const fetchLessonData = async (lessonId) => {
  try {
      // Send an HTTP GET request to the specified URL to fetch lesson data for a given 'lessonId'
      const response = await axios.get(`http://localhost:8080/api/lessons/${lessonId}`);

      // Return the data from the response
      return response.data;
    } catch (error) {
      // Log an error message if there's an issue with the request
      console.error('Error fetching lesson data:', error);

      // Log the response data from the error (if available)
      console.log('Response data:', error.response.data);

      // Rethrow the error to be handled elsewhere in the code
      throw error;
  }
};

export const fetchLessonsByCourseId = async (courseId) => {
  try {
    const response = await axios.get(`http://localhost:8080/api/courses/${courseId}/lessons`);
    return response.data;
  } catch (error) {
    console.error('Error fetching lessons:', error);
    console.log('Response data:', error.response.data);
    throw error;
  }
};

export const fetchRandomQuestions = async () => {
  try {
    const response = await axios.get('http://localhost:8080/api/questions/random');

    if (response.status === 200) {
      return response.data;
    } else {
      // Handle unexpected response status codes
      console.error(`Unexpected response status: ${response.status}`);
      throw new Error('Unexpected response status');
    }
  } catch (error) {
    // Handle errors here
    console.error('Error fetching questions:', error);
    throw error;
  }
};
export default fetchLessonData;

