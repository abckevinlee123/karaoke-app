// React Imports
import React from 'react';
import { useNavigate } from 'react-router-dom';

// Service Imports
import { createRoom } from '../SessionController'; // Import the service

const Create = () => {
  // State variables
  const navigate = useNavigate();

  // Function to handle room creation
  const handleCreateRoom = async (e) => {
    e.preventDefault();

    try {
      const response = await createRoom();                  // Calling the service
      navigate(`/room/${response.data}`);                   // Navigate to the room page
      console.log('Room created successfully:', response);  // Log the response for debugging
    } catch (error) {
      console.error('Failed to create room:', error);       // Log the error for debugging
    }
  };

  // Return
  return (
    <>
      <button
        class="button"
        onClick={handleCreateRoom}>MAKE A RESERVATION</button>
    </>
  );
}

export default Create;