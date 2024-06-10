import React, {useEffect, useRef, useState} from "react"
import './App.css'
import Viewers from "./Viewer"
import Buttons from "./Buttons"
import Unmount from "./components/Unmount";

function App() { 

  const [number, setNumbrr] = useState(0); //0의 값을 Viewer컴포넌트에 있는 number에 전달
  const [input, setInput] = useState("");

  const isMount = useRef(false); //아직 마운트되지 않았음

  //1. 마운트 탄생
  useEffect(()=>{ console.log("mount"); } , []);

  //2. 업데이트
  useEffect(()=>{
    if(!isMount.current){ //App컴포넌트가 최초 mount될 때 실행되긴 하는데
      isMount.current=true; //그때는 조건문이 참이 되기 때문에
      return; //강제로 종료시켜 아래 코드에서 아무것도 실행 안됨
    }
    console.log("update"); //리렌더링 이후 출력될거임
  })
  //mount를 제욓하고 컴포넌트가 update순간만 콜백함수를 실행하고 싶음
  //→ 현재 컴포넌트가 mount 되었는지 안되었는지 체크할 수 있음 → useRef 사용

  //3.언마운트

  const onClickButton = (value) =>{
    setNumbrr(value+number);
  }
  return (
    <>
      <div className="App">
        <h1>숫자 세기</h1>
          <section>
            <p>숫자를 입력하세요</p>
            <input value={input} onChange={(e)=>{setInput(e.target.value)}}/> {/*값이 변경될때마다 input에 바로 세팅*/}
          </section>
          <section>
            <Viewers number={number} /> {/*자식 컴포넌트*/}
            <h1>{number % 4 === 0 ? <Unmount /> : null}</h1>
          </section>
          <section>
            <Buttons onClickButton={onClickButton}/> {/*Buttons컴포넌트의 onClickButton 전달*/}
          </section>
      </div>
    </>
  )
}

export default App
