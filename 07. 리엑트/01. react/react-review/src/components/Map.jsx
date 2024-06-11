
const Map = () =>{
    const names=['자바','스프링','스프링부트'];

    const nameList=names.map((name, index) =>
        <li key={index}>{name}</li>
    )

    return(
        <div>
            <ul>
                {nameList}
            </ul>
        </div>
    )
}

export default Map;