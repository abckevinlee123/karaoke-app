// React Imports
import React from 'react';

// Component Imports
import Join from '../components/Select/Join';
import Create from '../components/Select/Create';

// Style Imports
import '../style/Select.css';

const Select = () => {
    // Return
    return (
        <div className="container">
            <Join />
            <Create />
        </div>
    );
};

export default Select;