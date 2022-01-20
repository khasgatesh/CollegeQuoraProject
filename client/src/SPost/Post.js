import React from 'react'
import Store from '../Action/Store'
import {ACTION_USER_LOGOUT,ACTION_USER_UPDATE_TOKEN } from "../Action/UserAction"
import {connect} from 'react-redux'
//import Feed from '../Feed/Feed'

var mapStateToProps = state => {
  return {
     Question: state.Questions,
  }
}
 
class SDashboard extends React.Component{

  constructor(){
    super()
    this.state = {
        updateProfilemsg : '',
        logoinstatus:false,
        email:'',
        Question : [],
    }       
}
componentDidMount()
{
    console.log(this.props.Question)
    this.setState({Questionss:this.props.Question})
    console.log(this.props.Question.email)
    console.log(this.props.Question.deptId)
 fetch(`http://localhost:8082/web/postquestion`)
 .then(response=>response.json()).then(data=>{
   console.log(data)
        if(data.status)
        {
            Store.dispatch({...ACTION_POST_QUESTION,payload:{
                token : data.token
            }})
            this.setState({Users:data.data})
            this.setState({email:data.data[2]})
            this.setState({deptId:data.data[1]})
        }else{
            if(data.code==401)
                alert("Invalid User !")
            if(data.code==400)
                alert("Session Lost !")
                this.setState({logoinstatus:true})  
            Store.dispatch({...ACTION_USER_LOGOUT})                      
        }
    }); 
    console.log(this.props.User)
}
 
 render(){
 return (
 <div>
 <h1>{this.props.User.email}</h1>
 <h2>{this.props.User.deptId}</h2>
 <div className="quora__contents">
        <div className="quora__content">
          </div>
          </div>
 </div>
 )
}
}
 

export default connect(mapStateToProps,null)(SDashboard)