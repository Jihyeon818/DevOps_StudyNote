import { useReducer } from "react";

// reducer: 상태를 실제로 변화시키는 변환기 역할
function reducer(state, action){
    console.log(state,action); //action 객체는 increase, data
    if(action.type==="increase"){
        return state + action.data;
    }else if(action.type==="decrease"){
        return state - action.data;
    }
}

const Reducer = () => {
    const [state, dispatch] = useReducer(reducer,0);
                                    //    함수명, 초기값
    const onPlus =() =>{
        dispatch({
            type:"increase", //값 증가 요청
            data: 1,
        }) //상태변화 요청
    }

    const onMinus = () =>{
        dispatch({
            type:"decrease", //값 증가 요청
            data: 1,
        }) 
    }

    return(
        <div>
            <h1>0</h1>
            <button onClick={onPlus}>+</button> {/*버튼을 누르면 dispatch함수에 상태 변화 요청*/}
            <button onClick={onMinus}>-</button>
        </div>
    )
}

export default Reducer;