import logo from './logo.svg';
import './App.css';
import UserMessage from './component/UserMessage';
import { useState } from 'react';
import MessageHistory from './component/MessageHistory';
import io from 'socket.io-client';
function App() {
  const[chats,setChats] = useState([])
  const handleSentMessage = (newChat) =>{
    console.log(newChat);
    setChats([...chats,newChat]);
  }
  const socket = io('http://localhost:3000'); // Replace with your server URL and port
  return (
    <div className="App">
      <UserMessage handleSentMessage={handleSentMessage} socket={socket}/>
      <MessageHistory socket={socket}/>
    </div>
  );
}

export default App;
