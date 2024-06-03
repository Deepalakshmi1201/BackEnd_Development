import React, { useEffect, useState } from "react";
import 'bootstrap/dist/css/bootstrap.min.css';

export default function MessageHistory(props){
    const[messages,setMessages] = useState([]);

    useEffect(() => {
        props.socket.on('chat message', (message) => {
            setMessages((prevMessages) => [...prevMessages, message]);
        });
        return () => {
            props.socket.off('chat message'); // Clean up listener on unmount
        };
    }, [props.socket]);
}