import './List.css'
import Item from './Item';
import { useState } from 'react';

const List=({todos, onUpdate})=>{ //3개의 todolist 초기값

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

    return(
        <div className="List">
            <h4>To do List</h4>
            <input onChange={onSearch} value={search} placeholder="검색어를 입력하세요" />

            <div className='li'>
                {filterDataList.map((todo)=>{ //배열에 담길 값을 리스트 형태로 반복적으로 렌더링
                    return <Item key={todo} {...todo} onUpdate={onUpdate}/>; //{id, idDo, content, date}
                    //리스트로 렌더링할 때 고유한 key값이 있어야 함
                })}
            </div>
        </div>
    )
}

export default List;