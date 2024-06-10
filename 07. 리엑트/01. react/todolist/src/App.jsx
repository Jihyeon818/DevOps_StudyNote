import { useRef, useState } from 'react'
import './App.css'
import Header from './components/Header'
import List from './components/List'
import Register from './components/Register'

const copyData=[
  {
    id:0,
    idDo:false,
    content:"스프링 공부하기",
    date: new Date().getTime(),
  },
  {
    id:1,
    idDo:false,
    content:"프로젝트 스터디하기",
    date: new Date().getTime(),
  },
  {
    id:2,
    idDo:false,
    content:"운동하기",
    date: new Date().getTime(),
  },
]

function App() {

  const [todos, setTodos] = useState(copyData);

  const idState=useRef(3);

  const onUpdate = (targetId) =>{
    //todos state값들 중에 targetId와 일치하는 id를 갖는 item의 idDo를 변경
    setTodos(
      todos.map((todo)=>
        todo.id === targetId ? {...todo, idDo : !todo.idDo} : todo
        //같은 id값이 있으면 기존 todo 객체의 isDo를 true로 설정
        //같지 않으면 기존 todo를 돌려받음
      )
    )
  }

  const onCreate =(content)=>{
    const newTodo={
      id: idState.current++,
      idDo:false,
      content:content,
      date: new Date().getTime(),
    };
    setTodos([newTodo, ...todos]); //추가하고자 하는 값들이랑 기존의 todos 배열
  }

  return (
    <>
      <div className='App'>
        <Header/>
        <Register onCreate={onCreate} />
        <List todos={todos} onUpdate={onUpdate}/>
      </div>
    </>
  )
}

export default App
