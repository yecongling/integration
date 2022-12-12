import React, {Component} from "react";
import PropTypes from 'prop-types'
import {nanoid} from "nanoid";
import './index.css'
export default class Header extends Component {

    // 对接收的props进行：类型、必要性的限制
    static propTypes = {
        addTodo: PropTypes.func.isRequired
    }

    // 键盘事件的回调
    handleKeyUp = (event) => {
        // 解构赋值
        const {keyCode, target} = event;
        if (keyCode !== 13) {
            return
        }
        if (target.value === '') {
            return;
        }
        // 准备好一个todo对象
        const todoObj = {
            id: nanoid(),
            name: target.value,
            done : false
        }
        // 将值传递给app
        this.props.addTodo(todoObj)
        // 清空
        target.value = ''
    }

    render() {
        return (
            <div className="todo-header">
                <input type="text" onKeyUp={this.handleKeyUp} placeholder="请输入你的任务名称，按回车键确认"/>
            </div>
        )
    }
}