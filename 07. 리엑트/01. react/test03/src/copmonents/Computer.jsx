import { useState } from "react"

const Computer = () => {
    const [power,setPower] =useState("OFF");
    return(
      <div>
        {power==="ON"? <h1>ON</h1> : <h1>OFF</h1>}
        <button onClick={()=>{
          setPower(power==="ON"?"OFF":"ON");
        }}>
          {power==="ON"?"끈다":"켠다"}
        </button>
      </div>
    ) 
  }

  export default Computer;