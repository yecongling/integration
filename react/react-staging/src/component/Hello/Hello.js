import React, {Component} from "react"
import {Button} from "antd";
import './hello.css'
/* hello组件 */
export class Hello extends Component {
    render() {
        return (
            <div className="Hello">
                <Button type="primary">点击我</Button>
            </div>
        )
    }
}