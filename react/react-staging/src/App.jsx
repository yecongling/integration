import './App.css';
import {Component} from "react";
import axios from "axios";
import {Button, Card, Input} from "antd";

export default class App extends Component {

    state = {
        url: "",
        data: ""
    }

    changeUrl = (event) => {
        this.setState({url: event.target.value})
    }

    getStudentData = () => {
        const url = 'http://localhost:3000/integration';
        axios.get(url + this.state.url).then(
            response => {
                console.log('成功了', response);
                this.setState({data: response.data})
            },
            error => {
                console.log('失败了', error)
            }
        )
    }

    render() {
        const {data} = this.state
        return (
            <div className="App">
                <Input type="text" size="large" onChange={this.changeUrl}/>
                <Button type="primary" onClick={this.getStudentData}>点我获取学生数据</Button>
                <span>接口的返回值是</span>
                <Card title="返回值">
                    <span>{JSON.stringify(data)}</span>
                </Card>
            </div>
        )
    }
}
