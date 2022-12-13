import './App.css';
import {Component} from "react";
import axios from "axios";

export default class App extends Component {

    getStudentData = () => {
        axios.get('http://localhost:3000/integration/sys/project/endpointProperties').then(
            response => {
                console.log('成功了', response);
            },
            error => {
                console.log('失败了', error)
            }
        )
    }

    render() {
        return (
            <div className="App">
                <button onClick={this.getStudentData}>点我获取学生数据</button>
            </div>
        )
    }
}
