import React from 'react'
import QHeader from '../Header/QHeader'
//import Feed from '../Feed/Feed';
import Sidebar from '../Sidebar/Sidebar';
 
function TDashboard() {
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
 
export default TDashboard;