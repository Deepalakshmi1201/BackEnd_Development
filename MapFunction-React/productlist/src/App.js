import logo from './logo.svg';
import './App.css';
import AddProduct from './component/AddProduct';
import React,{useState} from 'react';
import ProductCard from './component/ProductCard';
function App() {
  const[products,setProducts] = useState([]);

  const handleAddProduct = (newProduct) =>{
    setProducts([...products,newProduct]);
    console.log(newProduct);
  }
  return (
    <div className="App">
      <AddProduct  handleAddProduct={handleAddProduct}/>
      <ProductCard products={products}/>
    </div>
  );
}

export default App;
