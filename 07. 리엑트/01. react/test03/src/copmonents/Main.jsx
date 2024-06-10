import "./Main.css";

const Main = () =>{ 
  const student = {
    name:"hyeon",
    isLogin: true,
};

  return(
    <>
      {student.isLogin ? (
        <div className="logout">
          로그아웃
        </div>
      ):( //false이면
        <div>로그인</div>
      )}
    </>
  )
}
  
export default Main;