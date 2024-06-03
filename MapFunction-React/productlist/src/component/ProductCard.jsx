import React, { useState } from "react";
import Button from 'react-bootstrap/Button';
import Card from 'react-bootstrap/Card';
export default function ProductCard(props){
    const[paid,setPaid] = useState(false);
    const handlePaid = (e) => {
        e.preventDefault();
        setPaid(true);
    }
    return(
        <div>
            {/* MAP Function */}
            {/* {props.products.map((product,index) => (
            <Card key={index} style={{ width: '18rem' }}>
                {product.image &&
                <Card.Img variant="top" src={URL.createObjectURL(product.image)} />
                }
                <Card.Body>
                    <Card.Title>{product.name}</Card.Title>
                    <Button variant="primary">{product.price}</Button>
                </Card.Body>
            </Card>
            ))} */}

            {/* Filter Function */}
            {props.products.filter((product,index) => product.price > 2000 )
                            .map((filteredProduct,index) => (
                            <Card key={index} style={{ width: '18rem' }}>
                                {filteredProduct.image &&
                                <Card.Img variant="top" src={URL.createObjectURL(filteredProduct.image)} />
                                }
                                <Card.Body>
                                    <Card.Title>{filteredProduct.name}</Card.Title>
                                    <Button variant="primary">{filteredProduct.price}</Button>
                                </Card.Body>
                            </Card> 
                            ))}
            {/* Interactive List */}
            {
                props.products.map((product,index) => (
                    <Card key={index} style={{ width: '18rem',display:"flex",flexDirection:"column" }}>
                        {product.image &&
                        <Card.Img variant="top" src={URL.createObjectURL(product.image)} />
                        }
                        <Card.Body>
                            <Card.Title>{product.name}</Card.Title>
                            <Button variant="primary" onClick={handlePaid}>{!paid ? (product.price) : "Paid" }</Button>
                        </Card.Body>
                    </Card>
                ))
            }

        </div>
    )
}