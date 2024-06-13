async function getProfile(){
    return new Promise((resolve, reject)=>{
        setTimeout(() => {
            resolve({
                name:"홍길동",
                id : "gil",
            })
        }, 2000);
    })
}

//then메서드 안써도 됨 → 메서드 호출될 때까지 기다렸다가 결과값 저장
//await → async안에서만 사용 가능한 키워드

async function printProfile(){
    const data = await getProfile();
    console.log(data);
}
printProfile();



/*
콜백함수
console.log('h1');
setTimeout(() => {
   console.log('h12'); 
}, 2000);
console.log('h13');

function add(a,b,callback){
    setTimeout(() => {
        const sum=a+b;
        //console.log(sum)
        callback(sum);
    }, 3000);
}
add(12,3,(value)=>{console.log(value)});
*/

/*
// 1.map
let number=[1,2,3,4,5];

let n = number.map(function(num){
    return num*num;
})

console.log(n); //[1, 4, 9, 16, 25]

let arr=[1,2,3];

const result = arr.map((item,idx,arr)=>{
    return item*2;
})

console.log(result); //[2, 4, 6]

// 2.filter
let arrfilter=[
    {name:"홍길동",id:"1"},
    {name:"박길동",id:"2"},
    {name:"이길동",id:"3"},
]

const a =arrfilter.filter(
    (item) => item.name==="이길동"
);
console.log(a); // 0: {name: '이길동', id: '3'}   length: 1

// 3. join
let m=["hi","react","spring"];
const m2=m.join(" ");
console.log(m2); // hi react spring

// 4. sort



let arr=[1,2,3];

//1. 배열 구조 분해 할당
let [one, two, three] = arr;

console.log(one);

//2. 객체 구조 분해 할당
let student={
    name:"홍길동",
    age:20,
    hobby:"컴퓨터",
}

let {name, age, hobby}=student;
console.log(name,age,hobby); 

// ...연산자 = stread 연산자 - 객체나 배열에 저장된 여러 개의 값을 개별로 흩뿌려줌
let arr1 = [1,2,3];
let arr2 = [4,5,arr1[0],arr1[1],arr1[2]];
let arr3 = [4,5,...arr1,6]; //arr에 있는 값들이 다 들어감

console.log(arr2); //4,5,1,2,3
console.log(arr3); //4,5,1,2,3,6

let obj1={
    a:1,
    b:2,
}

let obj2={
    a:obj1.a,
    b:obj1.b,
    c:3,
    d:4,
    e:5,
}

let obj3={
    ...obj1,
    c:3,
    d:4,
    e:5,
}

console.log(obj2);
console.log(obj3);

function fun(p1,p2,p3){
    console.log(p1,p2,p3);
}

fun(...arr1);*/