// HTTP Imports
import axios from 'axios';

const searchAnything = async (query, roomCode) => {
  const response = await axios.get('http://localhost:8080/search-anything', { 
    params: { 
        query: query, 
        roomCode: roomCode } 
    });
  return response;
};

export { searchAnything };