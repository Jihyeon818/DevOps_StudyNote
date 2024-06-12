import { createContext, useCallback, useReducer, useRef } from 'react'
import './App.css'
import Header from './components/Header'
import List from './components/List'
import Register from './components/Register'

const copyData = [
  {
    id: 0,
    idDo: false,
    content: "스프링 공부하기",
    date: new Date().getTime(),
  },
  {
    id: 1,
    idDo: false,
    content: "프로젝트 스터디하기",
    date: new Date().getTime(),
  },
  {
    id: 2,
    idDo: false,
    content: "운동하기",
    date: new Date().getTime(),
  },
];

function reducer(state, action) {
  switch (action.type) {
    case 'create':
      return [action.data, ...state]; // 새로운 값, 원래 값

    case 'update':
      return state.map((item) =>
        item.id === action.targetId ? { ...item, idDo: !item.idDo } : item
      );

    case 'delete':
      return state.filter((todo) => todo.id !== action.targetId);

    default:
      return state;
  }
}

//외부에서 선언 → 리렌더링 될때마다 다시 생성될 필요가 없기 때문에 외부에 선언
const TodoListContext = createContext();

function App() {
  const [todos, dispatch] = useReducer(reducer, copyData);
  const idState = useRef(3);

  // 체크박스
  const onUpdate = (targetId) => {
    dispatch({
      type: 'update',
      targetId: targetId,
    });
  };

  const onDelete = useCallback((targetId) => {
    dispatch({
      type: 'delete',
      targetId: targetId,
    });
  },[]);

  const onCreate = useCallback((content) => {
    dispatch({
      type: 'create',
      data: {
        id: idState.current++,
        idDo: false,
        content: content,
        date: new Date().getTime(),
      },
    });
  },[]);

  return (
    <>
      <div className='App'>
        <Header />
        {/*데이터를 다이렉트로 공급받아 사용할 수 있음 */}
        <TodoListContext.Provider value={{todos,onCreate,onUpdate,onDelete}}>
          {/* <Register onCreate={onCreate} /> */}
          <List todos={todos} onUpdate={onUpdate} onDelete={onDelete} />
        </TodoListContext.Provider>
      </div>
    </>
  );
}

export default App;
