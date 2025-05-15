// React Imports
import React from 'react';

// Component Imports
import { queueTrack } from '../SpotifyController'; // Importing the queueTrack function from SpotifyController

const Track = ({ roomCode, trackNames, trackCover, trackArtist }) => {

    const handleQueueTrack = async (e) => {                   /*** FUNCTION TO HANDLE JOINING A ROOM ***/
        e.preventDefault();                                 // Prevent the default form submission behavior
        try {                                               //
            await queueTrack(roomCode, 0, 0, trackNames, trackCover, trackArtist);                       // Calling the service
            console.log('Track successfully queued');        // Log the response for debugging
        } catch (error) {                                   //
            console.error('Failed to queue track:', error);   // Log the error for debugging
        }
    };

    return (
        <>
            <img 
                src={trackCover} 
                alt={`${trackNames} cover`} 
                width="100" />
            <h2>{trackNames}</h2>
            <p>{trackArtist}</p>
            <button
                onClick={() => handleQueueTrack}
                >Queue</button>
        </>
    );
};

export default Track;