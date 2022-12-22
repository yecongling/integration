import React, {Component} from "react";
import Item from "../Item";
import './index.css'
import PropTypes from "prop-types";

export default class List extends Component {

    // 对接收的props进行：类型、必要性的限制
    static propTypes = {
        todos: PropTypes.array.isRequired,
        changeTodo: PropTypes.func.isRequired,
        deleteTodo: PropTypes.func.isRequired
    }

    render() {
        const {todos, changeTodo, deleteTodo} = this.props
        return (
            <ul className="todo-main">
                {
                    todos.map(todo => {
                        return <Item key={todo.id} {...todo} changeTodo={changeTodo} deleteTodo={deleteTodo}/>
                    })
                }
            </ul>
        )
    }
}