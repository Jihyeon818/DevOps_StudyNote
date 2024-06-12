import { useReducer, useEffect, useState } from "react";

function reducer(state, action){
    //action.type에 따라 다른 작업 수행
    switch(action.type){
        case 'increment':
            return {value:state.value+1};
        case 'decrement':
            return {value:state.value-1};
        default:
            return state;
    }
}


const Test =() =>{
    //useState로 값 저장
    const [username,setUsername] = useState("");
    const [msg, setMsg] = useState("");
    //입력할때마다 렌더링 확인
    useEffect(()=>{
        console.log('렌더링 완료');
        console.log({username,msg});
    })
    
    //username,msg 입력창을 쓸때마다 저장
    const onChangeUsername=(e)=>{
        setUsername(e.target.value);
    }
    const onChangeMsg = e =>{
        setMsg(e.target.value);
    }
    //확인 버튼 선택 시 입력 한 값 출력 후 지우기
    const onClickbutton=()=>{
        alert(username+" : "+msg);
        setUsername("");
        setMsg(""); //출력 후 공백으로 지워주기
    }
    //엔터키로도 눌리게
    const onkeyPressButton=e=>{
        if(e.key==="Enter"){
            onClickbutton();
        }
    }

    const [state, dispatch] = useReducer(reducer, {value:0})
    //state 초기값 0 → reducer 함수 호출

    return(
        <div>
            <input type="text" name="username" value={username} onChange={onChangeUsername}/>
            <input type="text" name="mag" value={msg} onChange={onChangeMsg}/>
            <button onClick={onClickbutton} onKeyPress={onkeyPressButton}>확인</button>
            <br/>
            이름: {username}<br/>
            하고싶은 말: {msg}
            <br/>
            현재 값 {StaticRange.value}이다
            <p>
                <button onClick={()=>{
                    dispatch({type: 'increment'})
                }}>+1</button>
                <button onClick={()=>{
                    dispatch({type: 'decrement'})
                }}>-1</button>
            </p>
        </div>
    )
}

export default Test;