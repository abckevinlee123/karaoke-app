// React Imports
import React from 'react';
import { useParams } from 'react-router-dom';

// Component Imports
import Search from '../components/Rooms/Search';

const Rooms = () => {
    const { code } = useParams(); // Grabs the code from the URL

    // Return
    return (
        <div>
            <h1>ROOM {code}</h1>
            <Search roomCode={code} />
        </div>
    );
};

export default Rooms;