import { useState } from "react";

const Join = () =>{ //Join 컴포넌트
    const [name, setName] = useState(""); //hook
    const [email, setEmail] = useState("");
    const [language, setLanguage] = useState("언어");
    const [memo, setMemo] = useState("안녕하세요");

    const onChangeName=(e) => {  //함수
        setName(e.target.value);
    }
    const onChangeEmail=(e) => {  //함수
        setEmail(e.target.value);
    }
    const onChangeLanguage=(e)=>{
        setLanguage(e.target.value);
    }
    const onChangeMemo=(e)=>{
        setMemo(e.target.value);
    }

    return(
    <div>
        <div>
            <input onChange={onChangeName} placeholder="이름입력"/>
            {name}
        </div>

        <div>
            <select onChange={onChangeLanguage}>
                <option value="korean">한국어</option>
                <option value="english">영어</option>
            </select>
            {language}
        </div>
        <div>
            <textarea onChange={onChangeMemo}></textarea>
            {memo}
        </div>
    </div>
    )
}

export default Join;