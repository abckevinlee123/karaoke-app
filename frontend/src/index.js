import React from 'react';
import ReactDOM from 'react-dom/client'; // ✅ Note: 'react-dom/client' not 'react-dom'
import App from './App';

const root = ReactDOM.createRoot(document.getElementById('root'));
root.render(<App />);