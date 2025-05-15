// React Imports
import React from 'react';
import { useParams } from 'react-router-dom';

// Component Imports
import SearchContainer from '../components/Rooms/SearchContainer';

const Rooms = () => {
    const { code } = useParams(); // Grabs the code from the URL

    // Return
    return (
        <div>
            <h1>ROOM {code}</h1>
            <SearchContainer roomCode={code} />
        </div>
    );
};

export default Rooms;