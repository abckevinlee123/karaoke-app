// React Imports
import React from 'react';

const Search = ({ handleInputChange, song }) => { 

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