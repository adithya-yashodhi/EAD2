import React, { useState } from 'react';
import Login from './Login';
import Register from './Register';

const AuthenticationForm = () => {
  const [currentForm, setCurrentForm] = useState('login');

  const toggleForm = (formName) => {
    setCurrentForm(formName);
  }

  return (
    <div className="app-container">
      {
        currentForm === "login" ? <Login onFormSwitch={toggleForm} /> : <Register onFormSwitch={toggleForm} />
      }
    </div>
  );
};

export default AuthenticationForm;
