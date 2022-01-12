import React from "react";
import "./Login.css"
import { Navigate } from 'react-router-dom';
export default class Login extends React.Component{

    constructor(){
        super()
        this.state = {
            regmsg : '',
            loginmsg : '',
            loginstatus : false
        }
    }
    login = (event)=>{
        var ob = {
            email : this.email.value,
            password: this.password.value,
        }
        console.log(this.setState.loginstatus)
        fetch(`http://localhost:8082/login`,{
            method : 'POST',
            headers:{
                "Content-Type" : "application/json"
            },
            body : JSON.stringify(ob)
        }).then(response=>response.json()).then(data=>{
            console.log(data)
            this.setState({regmsg:data.data})
            if(data.msg===200){
            this.setState({loginstatus:true})
            }
            
        });;
        console.log(this.state.loginstatus)
        console.log(ob)
        event.preventDefault()
    }

    render(){
        return(
            <div>
                <div className="form-v7">
	    <div className="page-content">
		<div className="form-v7-content">
			<div className="form-left">
				<img src="" alt="form" width="500px" height="700px"/>
			</div>
			<form className="form-detail"  onSubmit={this.login} action="">
				<h2>User Login</h2>
                <div className="form-row">
					<input type="text" ref={c=>this.email=c} name="email" id="email" className="input-text" placeholder="Enter your E mail" required/>
				</div>
				<div className="form-row">
					<input type="password" ref={c=>this.password=c} name="password" id="password" className="input-text" placeholder="Password" required/>
				</div>
				<b style={{color:"red"}}>{this.state.loginmsg}</b>
				<div className="form-row-last">
                <button style={{borderRadius: '9px', border: 'px solid' ,width:'250px' ,height:'50px' }} type="submit" name="register" className="register" value="Register"> Submit</button>
                </div>
                <div>
                <a href='/'>Already a user?</a>
                </div>
			</form>
		</div>
	</div>
</div>
            </div>
        )
    }

}