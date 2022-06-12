import React from "react";
import axios from 'axios';

class StudentComponent extends React.Component{
    state = {
        name: '',
        city: '',
        students: []
    };
    onFormSubmit= (event)=>{
        event.preventDefault();
        const student = {
            id:0,
            name: this.state.name,
            city: this.state.city
        };
        const data = JSON.stringify(student);
        const config = {
            method: 'post',
            url: 'http://localhost:8080/student',
            headers: {
                'Content-Type': 'application/json'
            },
            data: data
        };

        this.setState({name:'', city:''});
        axios(config)
            .then(function (response) {
                console.log("success");
            })
            .catch(function (error) {
                console.log(error);
            });
        this.setState({name:'',city:''});
        this.fetchStudents();
    };
    deleteStudent= ( id) =>{
        console.log("delete trigger"+id);
        axios.delete(`http://localhost:8080/student/`+id)
            .then(res => {
                console.log(res);
                console.log(res.data);
            });

        this.fetchStudents();
    };
    fetchStudents = ()=>{
        axios.get(`http://localhost:8080/student`)
            .then(res => {
                const students = res.data;
                this.setState({ students:students});
            });
    };
    clearForm= ()=>{
        this.setState({name:'',city:''});
    };
    componentDidUpdate() {
        this.fetchStudents();
    }
    componentDidMount() {
        this.fetchStudents();
    }
    render(){
        return (
            <div className="ui segment">
                <form className="ui form">
                    <div className="field">
                        <label>Name</label>
                        <input type="text" onChange={e=> this.setState({name:e.target.value})} />
                    </div>
                    <div className="field">
                        <label>City</label>
                        <input type="text" onChange={e=> this.setState({city:e.target.value})}/>
                    </div>
                    <div className="field">
                        <label>City</label>
                        <input type="submit" onClick={this.onFormSubmit}/>
                    </div>
                </form>
                <hr/>
                <table className="ui celled table">
                    <thead>
                    <tr>
                        <th>Name</th>
                        <th>City</th>
                        <th>Action</th>
                    </tr>
                    </thead>
                    <tbody>
                    {
                        this.state.students
                            .map(student =>{
                                return(
                                    <tr key={student.id}>
                                        <td data-label="Name">{student.name}</td>
                                        <td data-label="Age">{student.city}</td>
                                        <td ><button onClick={this.deleteStudent.bind(this,student.id)}>Delete</button></td>
                                    </tr>
                                )
                            }
                            )
                    }
                    </tbody>
                </table>
            </div>

        );
    }
}

export default StudentComponent;
