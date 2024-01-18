import React, { useState, useEffect } from 'react'
import { fetchLessonsByCourseId} from './Api'  //fetch lesson data for a specific course
import ErrorBoundary from '../../../ErrorBoundary'
import './lesson.css';
import { FaFilePdf} from 'react-icons/fa'
import {RiFileVideoLine} from 'react-icons/ri'
import { Link } from 'react-router-dom';

//define a lesson component as a functional component, accepting 'match' as a prop
const Lesson = ({ match }) => { 
    
    // Extract the 'courseId' from the 'match' prop's parameters
    const courseId = match.params.courseId;
    const [lessons, setLessons] = useState([]);
    const [error, setError] = useState(null);
    const [expandedLesson, setExpandedLesson] = useState(null);
    // Initialize state variables for lessons, error, and expanded lesson using 'useState' hook

    useEffect(() => {
        // Define a side effect with 'useEffect'

        const fetchLessons = async () => {
            try {
                const data = await fetchLessonsByCourseId(courseId);
                // Fetch lesson data using the 'fetchLessonsByCourseId' function

                setLessons(data);
                // Update the 'lessons' state with the fetched data

            } catch (error) {
                setError('Error fetching lessons. Please try again later.');
                // Handle errors by updating the 'error' state
            }
        };
    
        fetchLessons();  // Call the 'fetchLessons' function when the 'courseId' changes
    }, [courseId]);

    // Define a function to toggle the currently expanded lesson
    const toggleLessonExpansion = (lessonIndex) => {
        if (expandedLesson === lessonIndex) {
          setExpandedLesson(null);
        } else {
          setExpandedLesson(lessonIndex);
        }
      };

    // Check if there's an error, and if so, display an error message  
    if (error) {
        return <div>Error: {error}</div>;
    }

    // Check if there are no lessons (empty array), and if so, display a loading message
    if (lessons.length === 0) {
        return <div>Loading...</div>;
      }

    return (
        // The following code renders lessons, their titles, and associated study materials based on state and data received from the server
        // It also uses the 'ErrorBoundary' component to handle potential errors within the rendering
        <ErrorBoundary>
        <div id='page' className='page-container'>
            <div className='course-content'>Course Content</div>
            {lessons.map((lesson, lessonIndex) => (
                <div key={lessonIndex} className="lesson-title">
                <p>
                   {lessonIndex + 1}. {lesson.lessonTitle}
                   <span
                   onClick={() => toggleLessonExpansion(lessonIndex)}
                   className = "expand-icon"
                   >
                   {expandedLesson === lessonIndex ? '^' : '˅' }
                   </span>
                </p>   
                {expandedLesson === lessonIndex && (
                    <div className="expanded-lesson">
                    {lesson.studyMaterials && lesson.studyMaterials.length > 0 && (
                    <div>
                        {lesson.studyMaterials.map((studyMaterial, index) => (
                            <div key={index}>
                                {studyMaterial.documents && studyMaterial.documents.length > 0 && (
                                    <div>
                                        {studyMaterial.documents.map((document, docIndex) => (
                                            <div key={docIndex}>
                                                <span className="icon-with-text">
                                                <FaFilePdf className="document-icon" />
                                                <a
                                                    href={`http://localhost:8080/api/documents/${document.documentId}/view`}
                                                    target="_blank"
                                                    rel="noopener noreferrer"
                                                    className="document-link"
                                                >
                                                    {document.documentTitle}
                                                </a>
                                                </span>
                                            </div>
                                        ))}
                                    </div>
                                )}
                               
                                {studyMaterial.videos && studyMaterial.videos.length > 0 && (
                                    <div>
                                        {studyMaterial.videos.map((video, videoIndex) => (
                                            <div key={videoIndex}>
                                                <span className="icon-with-text">
                                                <RiFileVideoLine className="video-icon" />
                                                <a
                                                    href={`http://localhost:8080/api/videos/${video.videoId}/stream`}
                                                    target="_blank"
                                                    rel="noopener noreferrer"
                                                    className="document-link"
                                                >
                                                    {video.videoTitle}
                                                </a>
                                                </span>
                                            </div>
                                        ))}
                                    </div>
                                )}
                               
                            </div>
                        ))}
                    </div>
                  )}
              </div>
            )}
          </div>
          
        ))}
        <div className='quizbtn-container'>
        <Link to = {'/quiz'}>
        <button className='btn-quiz'>Strart Quiz</button>
        </Link>
        </div>
      </div>
    </ErrorBoundary>
    );
};

export default Lesson;
