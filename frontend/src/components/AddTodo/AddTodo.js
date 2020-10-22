import React from 'react'
import './AddTodo.css'
import Container from '@material-ui/core/Container';
import TextField from '@material-ui/core/TextField';
import Typography from '@material-ui/core/Typography'
import {withRouter} from 'react-router-dom';
import Select from '@material-ui/core/Select'
import InputLabel from '@material-ui/core/InputLabel';
import DatePicker from 'react-datepicker';
import 'react-datepicker/dist/react-datepicker.css';
import moment from "moment";
import CheckIcon from '@material-ui/icons/Check';
import Fab from '@material-ui/core/Fab';

class AddTodo extends React.Component{

    state = {
        "description":"",
        "responsible":"",
        "status":"",
        "dueDate":moment(),
        "email":""
    }

    handleDescription = (e) =>{
        this.setState({
            "description": e.target.value
        });
    }

    handleDatePicker = (date) =>{
        this.setState({
            ...this,
            "dueDate":date
        });

    }

    handleResponsible = (e) =>{
        this.setState({
            "responsible": e.target.value
        });
    }

    handleEmail = (e)=>{
        this.setState({
            "email": e.target.value
        });
    }

    handleState = (e) =>{
        this.setState({
            "status":e.target.value
        })
    }

    handleSubmit = (e) => {
        const {description,status,responsible,email,dueDate} = this.state;
        if(!description || !status || !responsible || !email || !dueDate){
            alert("Debes rellenar todos los datos")
        } else {
            const newItem = {
                "text":description,
                "status":status,
                "responsible":responsible,
                "dueDate":dueDate.toString()
            }
            this.props.newTask(newItem);
            this.props.history.push("/");
        }
        
    }

    render(){
        return(
            <Container className='Box' variant="contained">
                
            
            
            <Typography component="h1" variant="h5">
                New Task
            </Typography>
            <form>
                <TextField name="description" label="Description" id="description" autoComplete="description" onChange={this.handleDescription}/>
                <br/>
                <TextField name="responsible" label="Responsible" id="responsible" autoComplete="responsible" onChange={this.handleResponsible}/>
                <br/>
                <TextField name="email" label="Email Responsible" id="email" autoComplete="email" onChange={this.handleEmail}/>
                <br/>
                <br/>
                <InputLabel htmlFor="stateTodo">Status</InputLabel>
                <Select value={this.state.status} onChange={this.handleState} inputProps={{
            name: 'status',
            id: 'stateTodo',
          }} required>
                    <option value="ready">Ready</option>
                    <option value="completed">Completed</option>
                    <option selected value="in progress">In Progress</option>
                </Select>
                <br/>
                <br/>
                <InputLabel htmlFor="due-date">Date</InputLabel>
                <DatePicker
                        id="due-date"
                        selected={this.state.dueDate}
                        placeholderText="Due Date"
                        onChange={this.handleDatePicker}>
                    </DatePicker>
                <br/>
                <br/>
                <Fab color="primary" aria-label="add" onClick={this.handleSubmit}>
                    <CheckIcon />
                </Fab>

            </form>
        </Container>
        )
    }
}

export default withRouter(AddTodo);