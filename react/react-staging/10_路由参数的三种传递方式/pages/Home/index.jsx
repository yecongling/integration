import {Component} from "react";
// import qs from 'querystring';
export default class Home extends Component {

    render() {
        /* 获取params参数 */
        // const {age, name} = this.props.match.params;
        /* 接收search参数 */
        /*const search = this.props.location || {};*/
        // const {id} = qs.parse(search.slice(1));
        /* 接收state参数 */
        // const {id, age} = this.props.location.state || {}
        return (
            <div className="container">
                我是home内容
            </div>
        )
    }
}
