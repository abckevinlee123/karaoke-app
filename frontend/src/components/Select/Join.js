import React, { useState } from 'react';
import { useNavigate } from 'react-router-dom';

import { joinRoom } from './SessionController';
import Wrong from './Wrong';

const Join = () => {
    const [roomCode, setRoomCode] = useState('');
    const [show, setShow] = useState('false');
    const [error, setError] = useState('');
    const navigate = useNavigate(); 

    const handleJoinRoom = async () => {
        try {
            await joinRoom(roomCode); // or your fetch/axios call
            navigate(`/room/${roomCode}`);
        } catch (error) {
            setShow(true);
        }
    };

    const handleInputChange = (e) => {
        setRoomCode(e.target.value);
        setError(''); // Clear error when user starts typing
    };

    return (
        <div style={{ textAlign: 'center', marginTop: '50px' }}>
            <input
                class="search"
                type="text"
                placeholder="Password please 👀"
                value={roomCode}
                onChange={handleInputChange}/>
            <button
                class="button"
                onClick={handleJoinRoom}> Join </button>
            <Wrong tex={show} setVar={setShow}></Wrong>
        </div>
    );
};

export default Join;