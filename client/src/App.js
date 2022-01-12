import React from "react";
import Register from "./Register/Register";
import Login from "./Login/Login";
import "./App.css";
import {
  Route,
  BrowserRouter,
  Routes,
} from 'react-router-dom';

 export default class App extends React.Component{
  constructor(){
    super();
    this.state={
      authenticated:false,
      loading:true
    };
  }

  render(){
    return(
    
        <BrowserRouter>
             <Routes>
             <Route path="/" element={<Register/>}/>
             <Route path="/login" element={<Login/>}/>
             </Routes>
        </BrowserRouter>
      
    )
  }
}