import React, {Component} from "react";
import './index.css'

export default class Footer extends Component {

    // 全选回调
    handleCheckAll = (event) => {
        this.props.checkAllTodo(event.target.checked);
    }

    // 清除所有
    handleClearAll = ()=> {
        this.props.clearAllDone()
    }

    render() {
        const {todos} = this.props
        // 已完成个数
        const doneCount = todos.reduce((pre, todo) => pre + (todo.done ? 1 : 0), 0);
        // 总数
        const allCount = todos.length;
        return (
            <div className="todo-footer">
                <label>
                    <input type="checkbox" onChange={this.handleCheckAll}
                           checked={doneCount === allCount && allCount !== 0}/>
                </label>
                <span>
                    <span>已完成{doneCount}</span>/ 全部{allCount}
                </span>
                <button className="btn btn-danger" onClick={this.handleClearAll}>清除已完成任务</button>
            </div>
        )
    }
}