import React from "react";
import "./Sidebar.css";
import SidebarOptions from "../SideBarOptions/SidebarOptions";

function Sidebar(props) {
  return (
    <div className="sidebar">
      <SidebarOptions subjects={props.subjects}/>
    </div>
  );
}

export default Sidebar;