import React from 'react'
import { useLocation } from 'react-router-dom';
import { Link } from 'react-router-dom';
import './header.css'

const Head = () => {
  const location = useLocation();
  return (
    <>
      <section className={location.pathname === '/' ? 'head home' : 'head other'}>
        <div className='container flexSB'>
            <div className='logo'>
                <h1 className={location.pathname === '/' ? 'home-text' : 'other-text'}>
                  TEACHZA
                </h1>
                <span className={location.pathname === '/' ? 'home-text' : 'other-text'}>Online Education & Learning Platform</span>
            </div>
            <div className='header-btn'>
              <Link to={'/homeCourse'}>
              <button className={location.pathname === '/' ? 'course-btn home-button' : 'course-btn other-button'}>Courses</button>
              </Link>
              <Link to={'/login'}>
              <button className='login-btn'>Login</button>
              </Link>
            </div>
        </div>
      </section>
    </>
  )
}

export default Head
