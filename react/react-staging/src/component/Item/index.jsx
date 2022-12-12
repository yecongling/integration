import React, {Component} from "react";
import './index.css'
export default class Item extends Component {
    state  = {
        mouse : false
    }

    // 鼠标移入移出回调
    handleMouse = (flag) => {
        return () => {
            this.setState({mouse: flag})
        }
    }
    // 勾选、取消勾选某一个todo的回调
    handleCheck = (id) => {
        return (event) => {
            this.props.changeTodo(id, event.target.checked)
        }
    }

    render() {
        const {id, name, done} = this.props
        const {mouse} = this.state
        return (
            <li  style={{backgroundColor: mouse ? '#ddd' : '#fff'}} onMouseLeave={this.handleMouse(false)} onMouseEnter={this.handleMouse(true)}>
                <label>
                    <input type="checkbox" defaultChecked={done} onChange={this.handleCheck(id)}/>
                    <span>{name}</span>
                    <button className="btn btn-danger" style={{display:mouse ? 'block' : 'none'}}>删除</button>
                </label>
            </li>
        )
    }
}