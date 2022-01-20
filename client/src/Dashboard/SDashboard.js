import React from 'react'
import QHeader from '../Header/QHeader'
import Sidebar from '../Sidebar/Sidebar'
import {USER_LOGOUT,USER_UPDATE_TOKEN } from "./Action/UserReducer"
import {connect} from 'react-redux'
import Feed from '../Feed/Feed'

var mapStateToProps = state => {
  return {
     User: state.Users,
  }
}
 
function SDashboard() {
 
 
 return (
 <div>
 <QHeader/>
 <div className="quora__contents">
        <div className="quora__content">
          <Sidebar />
          </div>
          </div>
 </div>
 )
}
 
export default SDashboard;