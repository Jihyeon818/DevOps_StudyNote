import React ,{ useEffect } from "react"

const Unmount = () =>{
    useEffect(()=>{
        return()=>{
            console.log("unmount");
        }; //정리 함수 → 언마운트 될 때
    },[]);
    return <div>4로 나눠 떨어짐</div>
}

export default Unmount;