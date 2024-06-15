import { Link, Route, Routes, useNavigate } from 'react-router-dom'
import './App.css'
import Home from './controller/Home'
import New from './controller/New'
import Meet from './controller/Meet'
import NotFound from './controller/NotFound'

function App(){
    const nav = useNavigate(); //페이지를 실제로 이동시키는 navigate함수를 반환시켜줌
    
    const pageLink = () =>{
        nav("/new");
    }

    return(
        <>
        <div>
            <Link to={"/"}>Home</Link>
            <Link to={"new"}>New</Link>
            <Link to={"/meet"}>Meet</Link>
        </div>

        <button onClick={pageLink}>new 페이지로 이동</button>

        <Routes>
            <Route path="/" element={<Home/>} />
            <Route path="/new" element={<New/>} />
            <Route path="/meet/:id" element={<Meet/>} /> {/* 아이디값이 전달되지 않으면 notfound 페이지로 이동 */}
            <Route path="*" element={<NotFound/>} />
        </Routes>
        </>
    )
}

export default App