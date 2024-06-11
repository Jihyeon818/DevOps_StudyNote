import { useEffect, useState } from "react";

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

    return(
        <div>
            <input type="text" name="username" value={username} onChange={onChangeUsername}/>
            <input type="text" name="mag" value={msg} onChange={onChangeMsg}/>
            <button onClick={onClickbutton} onkeyPress={onkeyPressButton}>확인</button>
            <br/>
            이름: {username}<br/>
            하고싶은 말: {msg}

        </div>
    )
}

export default Test;