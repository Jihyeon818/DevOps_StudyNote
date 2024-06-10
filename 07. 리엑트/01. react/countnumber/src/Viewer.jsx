import React, {useState} from "react"

const Viewers = ({number}) => {
    return(
        <div>
           <div>숫자 세기: </div>
           <h1>{number}</h1> 
        </div>
    )
}

export default Viewers;
