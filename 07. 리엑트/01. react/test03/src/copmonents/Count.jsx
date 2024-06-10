import { useState } from "react";

const Count = () =>{
    const [state,setState] = useState(0);
    return(
    <div>
        <h1>{state}</h1> 
        <button onClick={()=>{
            setState(state+1);
        }}>
            +
        </button>
    </div>  
    )
}

export default Count;