import useInput from "../hook/useInput"

const Test = () =>{
    const [input, onchange] = useInput(); 
    const [input2, onchange2] = useInput(); //함수를 여러번 호출 가능

    return(
        <div>
            <input value={input} onChange={onchange}/>
            <input value={input2} onChange={onchange2}/>
        </div>
    );
};

export default Test;