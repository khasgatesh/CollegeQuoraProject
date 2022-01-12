import React from "react";

export default class Register extends React.Component{

    constructor(){
        super()
         this.state = {
            regmsg : '',
            loginmsg : ''
        }
    }
    register = (event)=>{
        var ob = {
            role_type : this.role_type.value,
            user_name:this.user_name.value,
            email : this.email.value,
            password: this.password.value,
            dept_id: this.dept_id.value,
        }
        fetch(`http://localhost:8082/register`,{
            method : 'POST',
            headers:{
                "Content-Type" : "application/json"
            },
            body : JSON.stringify(ob)
        }).then(response=>response.json()).then(data=>{
            console.log(data)
            this.setState({regmsg:data.data})
        });;
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
			<form class="form-detail"  onSubmit={this.register} action="">
				<h2>User Registration</h2>
				<div class="form-row">

				<input type="text" ref={c=>this.role_type=c} name="role_type" id="role_type" className="input-text" placeholder="Select Your Role" required/>
                   
				</div>
                <div class="form-row">
					<input type="text" ref={c=>this.user_name=c} name="user_name" id="user_name" className="input-text" placeholder="User Name"  />
				</div>
                <div class="form-row">
					<input type="text" ref={c=>this.email=c} name="email" id="email" className="input-text" placeholder="Enter your E mail" required/>
				</div>
				<div class="form-row">
					<input type="password" ref={c=>this.password=c} name="password" id="password" className="input-text" placeholder="Password" required/>
				</div>
                <div class="form-row">
					<input type="text" ref={c=>this.dept_id=c} name="dept_id" id="dept_id" className="input-text" placeholder="Enter your department" required/>
				</div>
				<b style={{color:"red"}}>{this.state.regmsg}</b>
				<div class="form-row-last">
                <button style={{borderRadius: '9px', border: 'px solid' ,width:'250px' ,height:'50px' }} type="submit" name="register" class="register" value="Register"> Submit</button>
                </div>
                <div>
                <a href='/login'>Not a user?</a>
                </div>
			</form>
		</div>
	</div>
</div>
            </div>
        )
    }

}