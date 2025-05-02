// HTTP Imports
import axios from 'axios';

const createRoom = async () => {
  const response = await axios.post('http://localhost:8080/create-room', {});
  return response;
};

const joinRoom = async (roomCode) => {
  const response = await axios.get('http://localhost:8080/join-room', { params: { roomCode: roomCode } });
  return response.data;
};

export { createRoom, joinRoom };