import { useRef, useState } from "react"

const Join2 = () =>{
    const [input, setInput] = useState({ //상태관리 메서드 → 초기값, 값을 변경하는 메서드로 되어있는 배열 형태
        name:"",
        language:"",
        memo:"",
    });

    const ref=useRef(0); //기본타입(Prototype) object, dom요소 조작하는 객체형태{current:현재값}
    const inputRef = useRef();

    const onChange=(e)=>{
        ref.current++;
        console.log(ref.current);

        console.log(e.target.name+":"+e.target.value);
        setInput({
            ...input,
            [e.target.name] : e.target.value, //name에서 이벤트가 일어나면
        })
    }

    const onSubmit=()=>{
        if(input.name===""){
            //useRef로 dom요소에 접근
            inputRef.current.focus(); //이름을 입력하는 창에 DOM요소 포커스 주고있음
        }
    }

    const onChangeName=(e) => { //합
        setInput({
            ...input,
            //[e.target.name]:e.target.value,
            name: e.target.value,
        });
    }
    const onChangeLanguage=(e)=>{
        setInput({
            ...input,
            language: e.target.value,
        })
    }
    const onChangeMemo=(e)=>{
        setInput({
            ...input,
            memo: e.target.value,
        })
    }

    return(
        <div>
            <div>
                <input ref={inputRef} value={input.name} onChange={onChange} placeholder={"이름입력"}/>
            </div>
            <div>
                <button onClick={()=>{
                    ref.current++;
                    console.log(ref.current);
                }}>+</button>
            </div>    
            <div>
                <select value={input.language} onChange={onChangeLanguage}>
                    <option value="java">자바</option>
                    <option value="c">c언어</option>
                    <option value="c++">c++</option>
                </select>
            </div>
    
            <div>
                <textarea value={input.memo} onChange={onChangeMemo} />
            </div>
            <button onClick={onSubmit}>확인</button>
        </div>
    )
}

export default Join2;