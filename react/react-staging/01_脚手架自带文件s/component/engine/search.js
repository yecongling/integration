
// 检索组件
import './search.css';
export function Search(props) {

    const onChange = (param) => {
        console.log(param)
        return (event) => {
            console.log('传过来的是：', param, '事件对象是：', event)
        }
        
    }

    return (
        <div className="search">
            <h2 style={{color:'white'}}>这是一个输入组件</h2>
            <input type="text" onChange={onChange('123')} value={props.value}/>
        </div>

    )
}