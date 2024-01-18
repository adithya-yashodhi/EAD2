import React from 'react'
import './courses.css'
import { coursesCard } from "../../dummydata"
import { Link } from 'react-router-dom';
// to create navigation links

const CoursesCard = () => {
    return (
      <>
        <section className='coursesCard'>
          <div className='container grid2'>

            {/*  Map over the 'coursesCard' array data and render each item, mapping over an array and val is variable */}
            {coursesCard.map((val) => (

              // Each item is enclosed in a 'div' with class 'items' and a unique 'key'
              <div className='items' key={val.id}>

                {/* Display an image with the source from 'val.cover'*/}
                <img src={val.cover} alt='' />  
                  <div className='text'>
                    <h1>{val.coursesName}</h1>
                  </div>

                  {/* Create a navigation link to a dynamic route using 'val.id' */}
                  <Link to={`/courses/${val.id}`}>
                    <button className='outline-btn'>Enroll Now</button>
                  </Link>
              </div>
            ))}
          </div>
        </section>

      </>
    )
  }

export default CoursesCard
