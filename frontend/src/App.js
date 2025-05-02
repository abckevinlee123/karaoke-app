// React imports
import React from 'react';
import { BrowserRouter as Router, Routes, Route } from 'react-router-dom'; // Import Router, Routes, and Route

// Page imports
import Select from './pages/Select';
import Rooms from './pages/Rooms';
import Loading from './pages/Loading';

// Style imports
import './style/App.css';

const App = () => {
  return (
    <>
    <Router>
      <Routes>
        <Route path="/" element={<Select />} />
        <Route path="/room/:code" element={<Rooms />} />
      </Routes>
    </Router>
      {/* <Rooms /> */}
      {/* <Loading /> */}
    </>
  );
}

export default App;
