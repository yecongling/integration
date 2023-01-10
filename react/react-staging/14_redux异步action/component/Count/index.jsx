import {Component} from "react";
import {Button, Select} from "antd";
// 引入store
import store from "../../redux/store";
import {createDecrementAction, createIncrementAction, createIncrementAsyncAction} from "../../redux/count_action";

export default class Count extends Component {

    selectNumber = 1;

    state = {
        count: 1
    }

    componentDidMount() {
        // 检测redux中状态的变化，只要变化，就调用render
        store.subscribe(()=> {
            this.setState({});
        })
    }

    handleChange = (value) => {
        this.selectNumber = value;
    }

    increment = ()=> {
        const value = this.selectNumber;
        store.dispatch(createIncrementAction(value));
    }

    decrement = ()=> {
        const value = this.selectNumber;
        store.dispatch(createDecrementAction(value));
    }

    incrementIfOdd = ()=> {
        const value = this.selectNumber;
        const count = store.getState();
        if (count % 2 !== 0) {
            store.dispatch(createIncrementAction(value));
        }
    }

    incrementAsync = ()=> {
        const value = this.selectNumber;
        // setTimeout(()=> {
            store.dispatch(createIncrementAsyncAction(value, 500))
        // }, 500)

    }
    render() {
        return (
            <div>
                <h1>当前求和为：{store.getState()}</h1>
                <Select defaultValue="1" onChange={this.handleChange} options={[
                    {
                        value: '1',
                        label: '1'
                    },
                    {
                        value: '2',
                        label: '2'
                    },
                    {
                        value: '3',
                        label: '3'
                    }
                ]}/>
                <Button onClick={this.increment}>+</Button>
                <Button onClick={this.decrement}>-</Button>
                <Button onClick={this.incrementIfOdd}>当前求和为奇数再加</Button>
                <Button onClick={this.incrementAsync}>异步加</Button>
            </div>
        )

    }
}