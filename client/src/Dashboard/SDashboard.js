import React from 'react'
import QHeader from '../Header/QHeader'
import Sidebar from '../Sidebar/Sidebar'
//import Feed from '../Feed/Feed'
 
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