// React Imports
import React, { useState, useEffect } from 'react';

// Service Imports
import { debounce } from 'lodash'; // Importing lodash for debouncing
import { getTrackName, getTrackCover, getTrackArtist } from '../SpotifyController';

// Component Imports
import Track from './Track';

const Results = ({ roomCode, song }) => {
    const [trackNames, setTrackNames] = useState([]);
    const [trackCover, setTrackCover] = useState([]);
    const [trackArtist, setTrackArtist] = useState([]);

    // Function to search Spotify
    const searchSpotify = async (q) => {
        q = q.trim();                                       // Trim the query string
        try {                                               //
            const response1 = await getTrackName(q, roomCode);              // Calling the service
            const response2 = await getTrackCover(q, roomCode);              // Calling the service
            const response3 = await getTrackArtist(q, roomCode);              // Calling the service
            setTrackNames(response1.data);         // Update the track names state
            setTrackCover(response2.data);         // Update the track cover state
            setTrackArtist(response3.data);       // Update the track artist state
        } catch (error) {                                   //
            console.error('Failed to join room:', error);   // Log the error for debugging
        }
    };
    
    // Debounced function to search Spotify
    const debouncedSearch = debounce((q) => {           /*** Users search results popping up AFTER the user has finished typing after 1000ms ***/
        searchSpotify(q);                               // Call the search function with the debounced query
    }, 1000);                                           // 1000ms debounce time
    
    // Effect to handle song search
    useEffect(() => {
        if (song) debouncedSearch(song);                // Call the debounced search function if song is not empty
        return debouncedSearch.cancel;                  // Cleanup function to cancel the debounced search
    }, [song]);                                         // Effect dependency on song state
    

    return (
        <>
            {trackNames.map((name, index) => (
                <Track
                    roomCode={roomCode}
                    trackNames={name}
                    trackCover={trackCover[index]}
                    trackArtist={trackArtist[index]} // This could be an array like ["Drake", "21 Savage"]
                />
            ))}
        </>
    )
};

export default Results;