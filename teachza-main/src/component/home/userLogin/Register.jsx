import React, { useState } from 'react';
import './register.css';
import axios from 'axios';

const Register = (props) => {
  const [email, setEmail] = useState('');
  const [pass, setPass] = useState('');
  const [name, setName] = useState(''); // Initialize name as an empty string

  const handleSubmit = (e) => {
    e.preventDefault();

    // Create an object with the user's registration data
    const userData = {
      name: name,
      email: email,
      password: pass,
    };

    // Make the HTTP POST request using axios to your server endpoint
    axios.post('http://localhost:8081/users/', userData)
      .then(response => {
        // Handle a successful response, you can display an alert or do something else here
        alert(response.data.message); // Assuming the response contains a 'message' property
      })
      .catch(error => {
        // Handle errors or unsuccessful response here
        alert('Registration failed. Please check your information.');
      });
  }

  return (
    <div className="auth-form-container">
      <h2 className='login-title'>Register</h2>
      <form className="register-form" onSubmit={handleSubmit}>
        <label className="login-label" htmlFor="email">E-mail</label>
        <input className="login-input" value={email} onChange={(e) => setEmail(e.target.value)} type="email" placeholder="hash@gmail.com" id="email" name="email" />
        
        <label className="login-label" htmlFor='name'>Full Name</label>
        <input className="login-input" value={name} onChange={(e) => setName(e.target.value)} type="text" placeholder='Senuri Amanda' id='name' name='name' />

        <label className="login-label" htmlFor="password">Password</label>
        <input className="login-input" value={pass} onChange={(e) => setPass(e.target.value)} type="password" placeholder="Nk@#90hs" id="password" name="password" />

        <button className='register-btn' type="submit">Register</button>
      </form>

      <button className="link-btn" onClick={() => props.onFormSwitch("login")}>Already have an account? Login here. </button>
    </div>
  );
}

export default Register;
