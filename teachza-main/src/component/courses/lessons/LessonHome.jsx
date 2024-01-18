import React from 'react'
import Lesson from './Lesson'
import { Route } from 'react-router-dom';

const LessonHome = () => {
  return (
    <>
      <Route path="/courses/:courseId" exact component={Lesson} />    
    </>
  )
}

export default LessonHome
