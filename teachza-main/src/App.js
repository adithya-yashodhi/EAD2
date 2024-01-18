import React from "react"
import "./App.css"
import { BrowserRouter as Router, Switch, Route} from "react-router-dom"
import Home from "./component/home/Home"
import CourseHome from "./component/courses/CourseHome"
import LessonHome from "./component/courses/lessons/LessonHome"
import HomeCourse from "./component/home/HomeCourse"
import Head from "./component/common/heading/Head"
import Quiz from "./component/courses/lessons/Quiz"
import AuthenticationForm from "./component/home/userLogin/AuthenticationForm"

const App = () => {
  return (
    <>
      <Router>{/* Create a React Router with a BrowserRouter wrapper */}
        <Switch> {/* Use a Switch to handle different routes */}
          <Route path='/courseHome' exact component={CourseHome} />
          <Route path="/courses/:courseId" exact component={LessonHome} /> {/* Define a dynamic route for the path '/courses/:courseId' with the 'LessonHome' component */}
          <Route path='/lessons' exact component={LessonHome}/>
          <Route path='/quiz' exact component={Quiz}/>
          <Route path='/login' exact component={AuthenticationForm}/>
          <Route>
          <Head />
          <Route path='/homeCourse' exact component={HomeCourse}/>
          <Route path='/' exact component={Home}/>
          </Route>
        </Switch>
      </Router>
    </>
  )
}

export default App

