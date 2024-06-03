import React, { useState } from "react";
import 'bootstrap/dist/css/bootstrap.min.css';
import Form from 'react-bootstrap/Form';
import { Button } from "react-bootstrap";
import io from 'socket.io-client';


export default function UserMessage(props){
    const[userName,setUserName] = useState('');
    const[message,setMessage] = useState('');
    
    const handleSubmit = (e) =>{
        alert("Message sent Sucessfully");
        e.preventDefault();
        const newChat = {
            userName:userName,
            message:message
        };
         // Send the message to the server using Socket.IO
        props.socket.emit('chat message',newChat);
        console.log(newChat);
        props.handleSentMessage(newChat);
        setUserName('');
        setMessage('');
    }
    return(
        <div style={{display:"flex",alignItems:"center",justifyContent:"center",marginTop:50}}>
        <Form style={{width:500,borderColor:'black',borderWidth:2,padding:20,borderStyle:'dashed'}} onSubmit={handleSubmit}>
        <Form.Group className="mb-3" >
            <Form.Label>User Name</Form.Label>
            <Form.Control type="text" value={userName} onChange={(e) => setUserName(e.target.value)}/>
        </Form.Group>
        <Form.Group className="mb-3" >
            <Form.Label>Message </Form.Label>
            <Form.Control as="textarea" rows={3} value={message} onChange={(e) => setMessage(e.target.value)}/>
        </Form.Group>
        <Button type="submit">Send</Button>
        </Form>
        </div>
    )
}