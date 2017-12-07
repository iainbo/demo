'use strict';

import DropDownButton from 'react-bootstrap/lib/DropdownButton';
import MenuItem from 'react-bootstrap/lib/MenuItem';
import Modal from 'react-bootstrap/lib/Modal';
import Button from 'react-bootstrap/lib/Button';
import Form from 'react-bootstrap/lib/Form';
import style from 'bootstrap/dist/css/bootstrap.css';

const React = require('react');
const ReactDOM = require('react-dom');

export class Employee extends React.Component {

    constructor(props) {
        super(props);

        this.state = {showModal: false};

        this.handleSubmit = this.handleSubmit.bind(this);
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

    handleSubmit(e) {
        e.preventDefault();
        var updatedEmployee = {};
        this.props.attributes.forEach(attribute => {
            updatedEmployee[attribute] = ReactDOM.findDOMNode(this.refs[attribute]).value.trim();
        });
        this.props.onUpdate(this.props.employee, updatedEmployee);
        this.close();
    }

    render() {

        var inputs = this.props.attributes.map(attribute =>
            <p key={this.props.employee.entity[attribute]}>
                <input type="text" placeholder={attribute}
                       defaultValue={this.props.employee.entity[attribute]}
                       ref={attribute} className="field" />
            </p>
        );

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


                    <Modal show={this.state.showModal} onHide={this.close}>
                        <Modal.Header>
                            <Modal.Title>Update Employee</Modal.Title>
                        </Modal.Header>
                        <Modal.Body>
                            <div>
                                <h2>Update an employee</h2>

                                <Form>
                                    {inputs}
                                </Form>
                            </div>
                            <Button onClick={this.handleSubmit}>Update</Button>
                            <Button onClick={this.close}>Cancel</Button>
                        </Modal.Body>
                    </Modal>

            </tr>
        )
    }
}