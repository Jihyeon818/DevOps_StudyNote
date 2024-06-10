import React, {useState} from "react"

const Buttons = ({onClickButton}) =>{
    //버튼 클릭시 App으로부터 전달받은 onClickButton이 실행되면서 인수로 -10을 넘기면
    //App컴포넌트의 onClickButton함수가 실행됨
    //value값으로 -10을 받아와서 현재 숫자에서 -10을 더한 값으로 세팅(setNumber)
    return(
        <div>
            <button onClick={()=>{onClickButton(-10)}}>-10</button>
            <button onClick={()=>{onClickButton(+10)}}>+10</button>
            <button onClick={()=>{onClickButton(-100)}}>-100</button>
            <button onClick={()=>{onClickButton(+100)}}>+100</button>
            <button onClick={()=>{onClickButton(-1000)}}>-1000</button>
            <button  onClick={()=>{onClickButton(+1000)}}>+1000</button>
        </div>
    )
}

export default Buttons;