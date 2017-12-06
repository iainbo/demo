'use strict';

import DropDownButton from 'react-bootstrap/lib/DropdownButton';
import MenuItem from 'react-bootstrap/lib/MenuItem';
import Modal from 'react-bootstrap/lib/Modal';
import style from 'bootstrap/dist/css/bootstrap.css';

import {UpdateDialog} from './updateDialog';

const React = require('react');

export class Employee extends React.Component {

    constructor(props) {
        super(props);

        this.state = {showModal: false};

        this.handleDelete = this.handleDelete.bind(this);
        this.update = this.update.bind(this);
        this.close = this.close.bind(this);
    }

    handleDelete() {
        this.props.onDelete(this.props.employee);
    }

    update(){
        this.setState({showModal: true});
    }

    close(){
        this.setState({showModal: false});
    }

    render() {
        return (
            <tr>
                <td>{this.props.employee.entity.firstName}</td>
                <td>{this.props.employee.entity.lastName}</td>
                <td>{this.props.employee.entity.phoneNumber}</td>
                <td>{this.props.employee.entity.emailAddress}</td>
                <td>{this.props.employee.entity.address}</td>
                <td>{this.props.employee.entity.manager.name}</td>
                <td>
                    <DropDownButton bsStyle="danger" title="More Actions" key={2} id={'dropdown-basic${2}'}>
                        <MenuItem eventKey="1" onClick={this.update}>Update Employee</MenuItem>
                        <MenuItem eventKey="2" onClick={this.handleDelete}>Delete Employee</MenuItem>
                    </DropDownButton>
                </td>
                <div className="static-modal">
                    <Modal show={this.state.showModal} onHide={this.close}>
                        <Modal.Header>
                            <Modal.Title>Update Employee</Modal.Title>
                        </Modal.Header>
                        <Modal.Body>
                            <UpdateDialog employee={this.props.employee}
                                          attributes={this.props.attributes}
                                          onUpdate={this.props.onUpdate}/>
                        </Modal.Body>
                    </Modal>
                </div>
            </tr>
        )
    }
}