import React, { useState } from "react";
import 'bootstrap/dist/css/bootstrap.min.css';
import Form from 'react-bootstrap/Form';
import { Button } from "react-bootstrap";

// Create an array of product objects containing properties like name, price, and image.

export default function AddProduct(props){
    const[name,setName] = useState('');
    const[price,setPrice] = useState('');
    const[image,setImage] = useState('');

    const submit = (e) =>{
        e.preventDefault();
        alert("Form Sucessfully Submitted");
        const newProduct ={
            name :name,
            price:price,
            image:image
        };
        console.log(newProduct);
        props.handleAddProduct(newProduct);
        setName('');
        setPrice('');
        setImage(" ");
    }
    return(
    <div>
        <Form onSubmit={submit}>
            <Form.Group className="mb-3" >
                <Form.Label>Name:</Form.Label>
                <Form.Control type="text" value={name} onChange={(e) => setName(e.target.value)} />
            </Form.Group>
            <Form.Group className="mb-3" >
                <Form.Label>Price:</Form.Label>
                <Form.Control type="number"  value={price} onChange={(e) => setPrice(e.target.value)}/>
            </Form.Group>
            <Form.Group className="mb-3" >
                <Form.Label>Image:</Form.Label>
                <Form.Control type="file"   onChange={ (e) => setImage(e.target.files[0])}/>
            </Form.Group>
            <Button type="submit" >Submit</Button>
         </Form>
   </div>
  
    )
}