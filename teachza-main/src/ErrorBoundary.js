import React, { Component } from 'react';
// Import the React library and the Component class from React

class ErrorBoundary extends Component {
  constructor(props) {
    super(props);
    // Call the constructor of the parent class (Component) and pass in the props

    this.state = { hasError: false };
    // Initialize the component's state with a property 'hasError' set to 'false'
  }

  componentDidCatch(error, info) {
    // A lifecycle method that is called when an error is thrown by a child component

    console.error('Error:', error);
    // Log the error to the console

    console.error('Info:', info);
    // Log additional information about the error

    this.setState({ hasError: true });
    // Update the component's state to indicate that an error has occurred
  }

  render() {
    if (this.state.hasError) {
      // If an error has occurred (as indicated by the 'hasError' state),

      return <div>Something went wrong.</div>;
      // Render a message indicating that something went wrong
    }
    return this.props.children;
    // If no error has occurred, render the child components (the components wrapped by this ErrorBoundary)
  }
}

export default ErrorBoundary;
