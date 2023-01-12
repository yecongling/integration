import {Component} from "react";
import {Button, Select} from "antd";
export default class Count extends Component {

    selectNumber = 1;

    state = {
        count: 1
    }

    handleChange = (value) => {
        this.selectNumber = value;
    }

    increment = ()=> {
        const value = this.selectNumber;
    }

    decrement = ()=> {
        const value = this.selectNumber;
    }

    incrementIfOdd = ()=> {
        const value = this.selectNumber;
    }

    incrementAsync = ()=> {
        const value = this.selectNumber;

    }
    render() {
        return (
            <div>
                <h1>当前求和为：{''}</h1>
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