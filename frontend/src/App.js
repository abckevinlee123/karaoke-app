import React from 'react';
import { BrowserRouter as Router, Routes, Route } from 'react-router-dom'; // Import Router, Routes, and Route

import Select from './pages/Select';
import Rooms from './pages/Rooms';
import Loading from './pages/Loading';

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
