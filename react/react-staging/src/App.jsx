import React, {Component} from "react";
import Header from "./component/Header";
import List from "./component/List";
import './App.css';
import Footer from "./component/Footer";
export default class App extends Component{
    // 状态在哪里，操作状态的方法就在哪
    state = {
        todos: [
            {id: '001', name: '吃饭',done: true},
            {id: '002', name: '睡觉',done: true},
            {id: '003', name: '打豆豆',done: false},
            {id: '004', name: '逛街',done: true}
        ]
    }

    // 用于添加一个todo，接收的参数是todo对象
    addTodo = (todoObj) => {
        // 获取原todos
        const {todos} = this.state
        // 追加一个todo
        const newTodos = [todoObj, ...todos];
        // 更新状态
        this.setState({todos: newTodos})
    }

    // 用于更新一个todo对象
    changeTodo = (id, done)=> {
        // 获取状态中的todos
        const {todos} = this.state
        // 匹配处理数据
        const newTodos = todos.map( todo => {
            if (todo.id === id) {
                return {...todo, done}
            } else {
                return todo;
            }
        })
        this.setState({todos: newTodos})
    }

    render() {
        const {todos} = this.state

        return (
            <div className="todo-container">
                <div className="todo-warp">
                    <Header addTodo = {this.addTodo}/>
                    <List todos = {todos} changeTodo = {this.changeTodo}/>
                    <Footer/>
                </div>
            </div>
        )
    }
}
