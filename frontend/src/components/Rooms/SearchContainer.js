// React Imports
import React, { useState } from 'react';

// Component Imports
import Search from './Search';
import Results from './Results';

const SearchContainer = ({ roomCode }) => {
    // State variables
    const [song, setSong] = useState('');               // State to store the song

    // Function to handle input change
    const handleInputChange = (e) => {
        setSong(e.target.value.toUpperCase());          // Update the song code state
    };

    return (
        <>
            <Search 
                handleInputChange={handleInputChange}
                song={song}></Search>
            <Results 
                roomCode={roomCode}
                song={song}></Results>
        </>
    )
};

export default SearchContainer;