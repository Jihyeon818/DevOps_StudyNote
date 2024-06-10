import React, { useEffect } from "react";
import "./MainPage.css";
import useCount from "./hooks/useCount";

const MainPage = () => {
  const [number, changeNumber] = useCount(0);

  const changeBackColor = () => {
    let color, opacity;

    if (number > 0) {
      opacity = Math.min(number / 1000, 1);
      color = `rgba(0, 128, 0, ${opacity})`;
    } else if (number < 0) {
      opacity = Math.min(Math.abs(number) / 1000, 1);
      color = `rgba(250, 170, 200, ${opacity})`;
    }

    document.body.style.backgroundColor = color;
  };

  useEffect(() => {
    changeBackColor();
  }, [number]);

  const numColor = {
    color: number === 0 ? "white" : number > 0 ? "green" : "red",
  };

  return (
    <div className="main_container">
      <h1> 숫자 세기</h1>
      <h2 style={numColor}>{number}</h2>
      <button className="minus btn" onClick={() => changeNumber(-10)}>
        -10
      </button>
      <button className="minus btn" onClick={() => changeNumber(-100)}>
        -100
      </button>
      <button className="minus btn" onClick={() => changeNumber(-1000)}>
        -1000
      </button>
      <button className="plus btn" onClick={() => changeNumber(1000)}>
        +1000
      </button>
      <button className="plus btn" onClick={() => changeNumber(100)}>
        +100
      </button>
      <button className="plus btn" onClick={() => changeNumber(10)}>
        +10
      </button>
    </div>
  );
};

export default MainPage;
