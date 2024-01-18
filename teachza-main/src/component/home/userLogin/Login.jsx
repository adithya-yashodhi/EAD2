import React, { useState } from "react";
import './login.css';
import { Link } from 'react-router-dom';
import axios from "axios";

const Login = (props) => {
  const [email, setEmail] = useState('');
  const [pass, setPass] = useState('');

  const handleSubmit = (e) => {
    e.preventDefault();
    console.log("submit clicked");
    // Create an object with the data to send in the POST request
    const userData = {
      email: email,
      password: pass,
    };

    // Make the HTTP POST request using axios
    axios.post('http://localhost:8081/users/login', userData)
      .then(response => {
        // Handle a successful response, you can display an alert or do something else here
        alert(response.data.message); // Assuming the response contains a 'message' property
        // You can also redirect to another page if login is successful
        // Example: props.history.push('/dashboard');
        window.location.href = "/courseHome";
      })
      .catch(error => {
        // Handle errors or unsuccessful response here
        alert('Login failed. Please check your credentials.');
      });
  }

  return (
    <div className="auth-form-container">
      <h2 className="login-title">Login</h2>
      <form className="login-form" onSubmit={handleSubmit}>
        <label className="login-label" htmlFor="email">E-mail</label>
        <input className="login-input" value={email} onChange={(e) => setEmail(e.target.value)} type="email" placeholder="hash@gmail.com" id="email" name="email" />

        <label className="login-label" htmlFor="password">Password</label>
        <input className="login-input" value={pass} onChange={(e) => setPass(e.target.value)} type="password" placeholder="Nk@#90hs" id="password" name="password" />

        <button className="login-btn" type="submit">Log In</button>
      </form>

      <button className="link-btn" onClick={() => props.onFormSwitch("register")}>Don't have an account? Register here. </button>
    </div>
  );
}

export default Login;
