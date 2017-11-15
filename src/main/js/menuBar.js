'use strict';

const React = require('react');


import NavBar from 'react-bootstrap/lib/Navbar';
import Nav from 'react-bootstrap/lib/Nav';
import NavItem from 'react-bootstrap/lib/NavItem';
import NavDropDown from 'react-bootstrap/lib/NavDropdown';
import MenuItem from 'react-bootstrap/lib/MenuItem';
import style from 'bootstrap/dist/css/bootstrap.css';

export class MenuBar extends React.Component{

    render(){
        return(
            <NavBar>
                <NavBar.Header>
                    <NavBar.Brand>
                        <a href="#">React Bootstrap</a>
                    </NavBar.Brand>
                </NavBar.Header>
                <Nav>
                    <NavItem eventKey={1} href="#createEmployee">Create Employee</NavItem>
                    <NavItem eventKey={2} href="#">Link 2</NavItem>
                    <NavDropDown eventKey={3} title="Dropdown" id="basic-nav-dropdown">
                        <MenuItem eventKey={3.1}>Action</MenuItem>
                        <MenuItem eventKey={3.2}>Another Action</MenuItem>
                        <MenuItem eventKey={3.3}>Another, Another Action</MenuItem>
                        <MenuItem divider/>
                        <MenuItem eventKey={3.4}>Separated Link</MenuItem>
                    </NavDropDown>
                </Nav>
            </NavBar>
        );
    }
}
