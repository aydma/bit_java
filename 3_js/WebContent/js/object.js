/**
 *  자바스크립트 객
 */

 const log = console.log;

let array = ['가','다','하','나'];
//33 64 63 60
array[4]='~~~';
array.pop()   // 스택처럼사용가능
array.push('A')


// array.forEach(i => log(i))
// array.forEach(i => document.write("<h4>"+i+"</h4>")) //write로 브라우저에 씀

// array.filter(i => i>'다').forEach(i => log(i)) // filter 아스키코드값으로 자동정렬되서 하가 나옴

// 자바스크립트 객체 : 싱글톤(하나만 생성)
// this 생략시 error
let student = {
	name:"홍길동",
	ko:99,
	eng:100,
	sum:function(){
		return this.ko+this.eng; // this는 메모리에서의 나
	},
	avg:function(){
		return this.sum()/2;
	}
}

student["name"]
student.name
student.avg()

student.address='서울'

delete student.address
//delete student.sum

for(let data in student) {
	log(data);   // 맵이랑 비슷해서 키값을 뽑은것
}

for(let data in student) {
	log(student[data]);  // 키를 집어넣어서 값이 나온것
}


/* this 생략시 error
let student = {
	name:"홍길동",
	ko:99,
	eng:100,
	sum:function(){
		return ko+eng; // this는 메모리에서의 나
	},
	avg:function(){
		return sum()/2;
	}
}
// sum이 없어도 메모리에 띄어지지만 에러남  
// 인터프리터방식 
let student = {
	name:"홍길동",
	ko:99,
	eng:100,
	
	avg:function(){
		return this.sum()/2;
	}
}
*/
/*
// 객체들의 주소를 가지고 있는 배열을 for문으로 뽑아봄
let product = [
	{name:"바나나", price:700 },
	{name:"체리", price:1700 },
	{name:"사과", price:900 },
	{name:"배", price:5000 },
	{name:"수박", price:17000 }
];

// product[0].name
// product[0]["name"]
// product[0].price

for(let data in product) {
	log(product[data])
	for(let d in product[data]){
		log(d)   // d는 name,price
	}
}

for(let data in product) {
	log(product[data])
	for(let d in product[data]){
		log(product[data][d])  // 키값을 넣어서 value를 뽑아줌 data의 d를 뽑아내니까 바나나,700이나옴
	}
}

function print_product(data){
	log(data.name,"::",data.price)
}

print_product(product[0])

for(let data in product){
	print_product(product[data]);
	//log(product[data])
	//log(data) //01234나옴
	//print_product(data)
}
*/

// 자바스크립트객체 => 생성자 항수를 통한 객체 생성
// 객체는 자신만의 데이터를 가지며
// 함수는 공유하도록 설계한다.
function Student(name,ko,eng){
	this.name = name;
	this.ko = ko;
	this.eng = eng;
}


Student.prototype.sum=function(){ // student에 프로토타입 sum이라고 하는 메소드를 넣음 
	return this.ko+this.eng;

}

Student.prototype.avg=function(){
	return this.sum()/2;
}


let s1 = new Student("홍길동",90,77);
let s2 = new Student("강아지",99,97);
let s3 = new Student("고양이",69,57);



/* s1.grade = function(){
 	return this.avg > 80 ? 'A':'B';
	} */
// 프로토타입이란 이런것... 위에처럼 하면 grade를 s1밖에 못쓰지만 프로토타입으로 만들면 다들 쓸 수 있음
Student.prototype.grade = function(){
	return this.avg > 80 ? 'A':'B';
}



/*
log(s1.name, "/", s1.avg(), "/", s1.grade());
log(s2.name, "/", s2.avg(), "/", s2.grade());
log(s3.name, "/", s3.avg(), "/", s3.grade());
*/

let students = [
	new Student("홍길동",90,77),
	new Student("강아지",99,97),
	new Student("고양이",69,57),
	new Student("앵무새",90,77),
	new Student("신재훈",100,100),
	new Student("김잉꼬",69,57)
];


let testin;
let testof;
/*
for(let data in students) {
	testin = data;
	log(students[data].name ,"/", students[data].avg());
}

log(' students 평균 리스트 ');
for(let data of students) { 
	testof = data;
	log(data.name,"/",data.avg());
}
*/

log(s1.toString())

// s1.toString = function(){
// 	return this.name+"::"+this.avg();
// }

Student.prototype.toString = function(){
	return this.name+"::"+this.avg();
}

log(s1.toString())
log(s2.toString())
for(let data in students) {
	log(data.toString());
}
log(' of-------------- ');
for(let data of students) {
	log(data.toString());
}



