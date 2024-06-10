import { useState } from "react";

//개발자 커스텀 훅
function useInput(){
    const [input, setInput]=useState();

    const onChange = (e) =>{
        setInput(e.target.value);
    }
    return [input, onchange];
}
export default useInput;