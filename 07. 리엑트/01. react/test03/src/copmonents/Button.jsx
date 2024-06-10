const Button = ({text,color, children}) =>{ //함수형 컴포넌트
    const onClickButton=(e)=>{
        console.log(e);
        console.log(text);
    }
    return(
        <button onClick={onClickButton}
        style={{color:color}}> 
            {text}
            {children}
        </button>
    )
};

Button.defaultProps = {
    color: "pink",
    //defaultProps : 매개변수로 넘어오는 props가 없어도 적용됨.
  };

export default Button;