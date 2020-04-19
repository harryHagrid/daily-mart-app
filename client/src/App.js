import React from 'react';
import { BrowserRouter, Route } from 'react-router-dom'
// import { Navbar, Nav, NavDropdown, Form, FormControl, Button,
//         Carousel
//  } from 'react-bootstrap';

// import logo from './logo.svg';

import './App.css';
import AppHeader from './components/App-header';
import HomePage from './modules/Homepage';


function App() {
  return (
    <BrowserRouter>
      <div className="App">
        <AppHeader />
        



      </div>
    </BrowserRouter>
  );
}

export default App;
