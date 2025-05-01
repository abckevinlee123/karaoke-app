import React, { useState } from 'react';
import { useNavigate } from 'react-router-dom';

import { createRoom } from './SessionController'; // Import the service

const Create = () => {
    const [roomCode, setRoomCode] = useState('');
    const navigate = useNavigate(); // Import useNavigate from react-router-dom


    const handleSubmit = async (e) => {
        e.preventDefault();
    
        try {
          const response = await createRoom(); // Calling the service
          setRoomCode(response.data);
          navigate(`/room/${response.data}`);
          console.log('Room created successfully:', response);
        } catch (error) {
          console.error('Failed to create room:', error);
        }
    };

    return (
        <div style={{ textAlign: 'center'}}>
            <button
                class="button"
                onClick={handleSubmit}>Create</button>
        </div>
    );
}

export default Create;