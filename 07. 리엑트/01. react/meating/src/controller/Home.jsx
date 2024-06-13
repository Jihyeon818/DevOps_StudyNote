import { useSearchParams } from "react-router-dom";

const Home = () => {
    const [params,setParams] = useSearchParams(); //쿼리스트링으로 넘긴 값 받을 때
    console.log(params.get("key"));
    return <div>Home</div>;
}

export default Home;