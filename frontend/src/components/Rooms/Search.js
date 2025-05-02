// React Imports
import React, { useState, useEffect } from 'react';

// Service Imports
import { debounce } from 'lodash'; // Importing lodash for debouncing
import { searchAnything } from '../SpotifyController';

const Search = ({ roomCode }) => {
    // State variables
    const [song, setSong] = useState('');               // State to store the song

    // Function to handle input change
    const handleInputChange = (e) => {
        setSong(e.target.value.toUpperCase());          // Update the song code state
    };

    // Function to search Spotify
    const searchSpotify = async (q) => {
        q = q.trim();                                       // Trim the query string
        try {                                               //
            const response = await searchAnything(q, roomCode);              // Calling the service
            console.log('Search results:', response);       // Log the search query
        } catch (error) {                                   //
            console.error('Failed to join room:', error);   // Log the error for debugging
        }
    };
    
    // Debounced function to search Spotify
    const debouncedSearch = debounce((q) => {
        searchSpotify(q);                               // Call the search function with the debounced query
    }, 1000);                                           // 1000ms debounce time
    
    // Effect to handle song search
    useEffect(() => {
        if (song) debouncedSearch(song);                // Call the debounced search function if song is not empty
        return debouncedSearch.cancel;                  // Cleanup function to cancel the debounced search
    }, [song]);                                         // Effect dependency on song state

    return (
        <>
            <input
                type="text"
                placeholder="TYPE A SONG OR ARTIST YOU'D LIKE TO QUEUE"
                value={song}
                onChange={handleInputChange}/>
        </>
    );
};

export default Search;