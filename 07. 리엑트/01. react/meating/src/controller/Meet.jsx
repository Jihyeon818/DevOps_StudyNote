import { useParams } from "react-router-dom";

const Meet = () => {
    const params = useParams();
    console.log(params);

    return <div>{params.id}회의</div>
}

export default Meet;