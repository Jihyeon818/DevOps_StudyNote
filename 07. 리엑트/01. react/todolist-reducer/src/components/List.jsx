import './List.css'
import Item from './Item';
import { useMemo, useState } from 'react';

const List=({todos, onUpdate, onDelete})=>{ //3개의 todolist 초기값

    //검색어가 변경될때마다 state에 담기
    const [search, setSearch] = useState("");

    const onSearch=(e)=>{
        setSearch(e.target.value);
    }

    const filterData =() =>{
        if(search === ""){ //검색 결과가 없으면
            return todos;   //전체 리스트 띄우기
        }
        return todos.filter((todo) =>
            todo.content.toLowerCase().includes(search.toLowerCase()) 
            //todo의 내용(content)을 소문자로 바꿔서, search에서 검색한 내용(소문자로 바꿈)과 비교
        )
    }

    const filterDataList = filterData();

    const {total, doCnt, notDo} = useMemo(()=>{
        const total=todos.length; //전체 todolist 개수(3개)
        const doCnt=todos.filter( //할일 개수
            (todo) => todo.idDo).length;

        const notDo = total-doCnt; //하지 않은일 개수

        return{
            total,
            doCnt,
            notDo
        }
    },[todos]); //콜백함수가 반환하는 값을 그대로 반환해줌 → deps를 기준으로 메모리제이션함
            //빈 배열로 설정했으므로 첫번째 콜백함수의 연산반환이 컴포넌트가 최초로 렌더링 되었을 때 한번만 이루어짐
            // useMemo로 만들면 연산은 딱 한번만 수행


    return(
        <div className="List">
            <h4>To do List</h4>
            <div>
                <div>total: {total}</div>
                <div>doCnt: {doCnt}</div>
                <div>notDo: {notDo}</div>
            </div>
            <br/>
            <input onChange={onSearch} value={search} placeholder="검색어를 입력하세요" />

            <div className='li'>
                {filterDataList.map((todo)=>{ //배열에 담길 값을 리스트 형태로 반복적으로 렌더링
                    return <Item key={todo} {...todo} onUpdate={onUpdate} onDelete={onDelete}/>; //{id, idDo, content, date}
                    //리스트로 렌더링할 때 고유한 key값이 있어야 함
                })}
            </div>
        </div>
    )
}

export default List;