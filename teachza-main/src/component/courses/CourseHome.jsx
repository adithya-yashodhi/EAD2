import React from 'react'
import Back from '../common/back/Back'
import CoursesCard from './CoursesCard'

const CourseHome = () => {
  return (
    <>
      <Back title ='Explore Courses' />
      {/* Render the 'Back' component with a 'title' prop set to 'Explore Courses' */}
      <CoursesCard />
      {/* Render the 'CoursesCard' component, which appears to display a list of courses */}
    </>
  )
}

export default CourseHome
