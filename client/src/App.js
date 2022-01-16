import React from "react";
import Register from "./Register/Register";
import Login from "./Login/Login";
import Navbar from "./Navbar/Navbar";
import Home from "./Home/Home";
import "./App.css";

import "./Register/Register.css";
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
    <div>  <Navbar></Navbar>
        <BrowserRouter>
             <Routes>
             <Route path="/" element={<Home/>}/>
             <Route path="/register" element={<Register/>}/>
             <Route path="/login" element={<Login/>}/>
             </Routes>
        </BrowserRouter>

        </div>
      
    )
  }
}