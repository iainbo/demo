'use strict';

const React = require('react');


import NavBar from 'react-bootstrap/lib/Navbar';
import Nav from 'react-bootstrap/lib/Nav';
import NavItem from 'react-bootstrap/lib/NavItem';
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
                    <NavItem eventKey={1} href="#">Link 1</NavItem>
                </Nav>
            </NavBar>
        );
    }
}
