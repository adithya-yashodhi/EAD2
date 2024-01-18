import React from 'react'
import './hero.css'
import Title from '../../common/title/Title'
import {Link} from 'react-router-dom'

const Hero = () => {
  return (
    <>
      <section className='hero'>
        <div className="container">
            <div className="row">
                <Title subtitle='Welcome to techza' title='open minds, bright futures'/>
                <p>At Techza, we belive in the power of open minds to shape bright future. Our educational philosopy is centered around the idea that learning should be a transformative journey.</p>
                <div className="button">
                    <Link to={'/login'}>
                    <button className='primary-btn'>GET STARTED NOW</button>
                    </Link>
                    <button>VIEW COURSE</button>
                </div>
            </div>
        </div>
      </section>
      <div className='margin'>
      </div>
    </>
  )
}

export default Hero
