import { useState } from "react";


const StateMap = () =>{
    //기본 값 저장
    const [names, setNames] = useState([
        {id:1, text:'java'},
        {id:2, text:'spring'},
        {id:3, text:'legacy'},
    ]);

    // 입력값 저장
    const [input, setInput] = useState("");
    const [nextId, setNextId] = useState(4);
    

    const onChangename = e => setInput(e.target.value);

    const onDeletename = id => {
        //filter함수 사용
        const nextNames = names.filter(name => name.id !== id);
        setNames(nextNames);
    }

    const namelist=names.map(name =>
        <li key={name.id} onDoubleClick={()=>onDeletename(name.id)}>{name.text}</li>
    )

    const onClickname = () =>{
        const name2 = names.concat({
            id:nextId,
            text:input
        });
        setNextId(nextId+1);
        setNames(name2);
        setInput(''); //추가 후 초기화
    }
    return(
        <>
        <ul>
            {<input onChange={onChangename} value={input}/>}
            <button onClick={onClickname}>추가</button>
            <ul>
                {namelist}
            </ul>
        </ul>
        </>
    )
}

export default StateMap;