import React from 'react'
import './homeCourse.css'
import { coursesCard } from "../../dummydata"

const HomeCourse = () => {
  return (
    <>
    <section id='heading'>
      <div className='title-container'>
      <p className='main-title'>Recommend Me a Course</p>
      <p className='sub-title'>Career Oppurtunities in IT</p>
      </div>
    </section>
    <section className='course-container'>
    <div className='grid'>
      {coursesCard.map((val) => (
        <div className='items' key={val.id}>
          <img src={val.cover} alt='' />  
            <div className='text'>
              <h1>{val.coursesName}</h1>
            </div>
        </div>
      ))}
    </div>
  </section>
  </>
  )
}

export default HomeCourse
