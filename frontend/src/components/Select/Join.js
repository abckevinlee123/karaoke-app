// React Imports
import React, { useState } from 'react';
import { useNavigate } from 'react-router-dom';

// Service Imports
import { joinRoom } from '../SessionController';

// Component Imports
import Wrong from './Wrong';

// Style Imports
import '../../style/Join.css';

const Join = () => {
                                                            /*** STATE VARIABLES ***/ 
    const [roomCode, setRoomCode] = useState('');           // State to store the room code
    const [show, setShow] = useState(false);                // State to control the visibility of the error message
    const navigate = useNavigate();                         // Hook to programmatically navigate

    const handleJoinRoom = async (e) => {                   /*** FUNCTION TO HANDLE JOINING A ROOM ***/
        e.preventDefault();                                 // Prevent the default form submission behavior
        try {                                               //
            await joinRoom(roomCode);                       // Calling the service
            navigate(`/room/${roomCode}`);                  // Navigate to the room page
            console.log('Room joined successfully');        // Log the response for debugging
        } catch (error) {                                   //
            setShow(true);                                  // Show the error message
            console.error('Failed to join room:', error);   // Log the error for debugging
        }
    };

    const handleInputChange = (e) => {                       /*** FUNCTION TO HANDLE INPUT CHANGE ***/
        e.preventDefault();                                  // Prevent the default form submission behavior
        setRoomCode(e.target.value.toUpperCase());           // Update the room code state
    };


    return (                                                 /*** RETURN STATEMENT ***/
        <div>
            <input
                className="input"
                type="text"
                placeholder="ROOM NUMBER HERE 👀"
                value={roomCode}
                onChange={handleInputChange}/>
            <button
                className="button"
                onClick={handleJoinRoom}>JOIN</button>
            <Wrong 
                show={show} 
                setShow={setShow}></Wrong>
        </div>
    );
};

export default Join;