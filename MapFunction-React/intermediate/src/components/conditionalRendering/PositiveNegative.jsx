import React, { useState } from "react";
import 'bootstrap/dist/css/bootstrap.min.css';
import Form from 'react-bootstrap/Form';
import { Button } from "react-bootstrap";

export default function PositiveNegative() {

    const[number , setNumber] = useState('');
    const handleNumber =(e) =>{
        console.log(number);
        e.preventDefault();
        if(number >= 0){
            alert("number is Positive")
        }
        else{
            alert("number is Negative");
        }
    }
    return(
        <div>
            <Form onSubmit={handleNumber}>
            <Form.Label >Enter a number:</Form.Label>
            <Form.Control type="number" value={number} onChange={(e) => setNumber(e.target.value)} />
            <Button type='submit'> Submit</Button>
            </Form>
        </div>
    )
}