import { useRef, useState } from "react";
import "./Register.css"

const Register=({onCreate})=>{
    
    const [content, setContent] = useState("");
    const inputRef = useRef();

    const onKeydown = (e)=>{
        if(e.keyCode===13){
            onsubmit(); {/*엔터키를 눌러도 추가되도록 */}
        }
    }

    const onContent=(e)=>{
        setContent(e.target.value);
    }

    const onSubmit =() =>{
        if(content === ""){ //추가 버튼 선택 시 값이 비어있으면
            inputRef.current.focus(); //입력창으로 초점 이동
            return;
        }
        onCreate(content); //할일에 넣은 값을 세팅해서 기존 배열에 띄움
        inputRef.current.focus();
        inputRef.current.select()
    }
    
    return(
        <div className="Register">
            <input ref={inputRef} value={content} onChange={onContent} onKeyDown={onkeydown} placeholder="할일을 입력하세요"/>
            <button onClick={onSubmit}>추가</button> {/*추가 버튼 누르면 onSubmit 함수 호출*/}
        </div>
    );
};

export default Register;