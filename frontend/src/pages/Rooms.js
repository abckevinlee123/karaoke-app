import React from 'react';
import { useParams } from 'react-router-dom';

const Rooms = () => {
    const { code } = useParams(); // Grabs the code from the URL

    return (
        <div>
            <h1>Room {code}</h1>
        </div>
    );
};

export default Rooms;