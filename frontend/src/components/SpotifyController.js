// HTTP Imports
import axios from 'axios';

const getTrackName = async (query, roomCode) => {
  const response = await axios.get('http://localhost:8080/get-track-name', { 
    params: { 
      query: query, 
      roomCode: roomCode } 
    });
  return response;
};

const getTrackCover = async (query, roomCode) => {
  const response = await axios.get('http://localhost:8080/get-track-cover', { 
    params: { 
      query: query, 
      roomCode: roomCode } 
    });
  return response;
};

const getTrackArtist = async (query, roomCode) => {
  const response = await axios.get('http://localhost:8080/get-track-artist', { 
    params: { 
      query: query, 
      roomCode: roomCode } 
    });
  return response;
};

const queueTrack = async (roomCode, trackID, queuePosition, trackName, trackCover, trackArtist) => {
  await axios.get('http://localhost:8080/get-track-artist', { 
    params: { 
      roomCode: roomCode,
      trackID: trackID, 
      queuePosition: queuePosition,
      trackName: trackName,
      trackCover: trackCover,
      trackArtist: trackArtist
      } 
    });
  // return response;
};

export { getTrackName, getTrackCover, getTrackArtist, queueTrack };