const express = require('express');
const app = express();
const server = require('http').createServer(app);
const io = require('socket.io')(server);

io.on('connection', (socket) => {
    // Handle incoming connections
    socket.on('chat message', (message) => {
        // Broadcast the message to all connected clients
        io.emit('chat message', message);
    });
});