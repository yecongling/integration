import Header from "./component/Header";
import List from "./component/List";
import './App.css';
import Footer from "./component/Footer";
function App() {
  return (
    <div className="todo-container">
      <div className="todo-warp">
          <Header/>
          <List/>
          <Footer/>
      </div>
    </div>
  );
}
// 暴露app组件
export default App;
