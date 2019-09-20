console.log("fn.js log");
let name = "홍길동";
let flag = true < 10; // false는 0 true는 1이라서 true가연산
let now = new Date();
let num = 99;
const pi = 3.14;

/*  자바스크립트 일급함수의 특징
	자바스크립트 함수는 일급 함수  
	- 함수를 값으로 다룰수 있다.
	- 변수에 함수를 담을 수 있다.
	- 함수의 결과 값 리턴값으로 사용가능
	- 함수의 인자로 사용 가능

*/

const log = console.log; // 함수의 정의부를 변수에 담음

function f1() {
	alert("hello javascript ~~~");
}

const f2 = f1; 

const f3 = () => alert("hello javascript ~~~");

const f4 = (i) => alert(i);

function sum(a,b,c){
	if(!c) c=0;
	return a+b+c;
}

function sumAll(){
	let sum = 0;
	for(let i=0; i<arguments.length; i++){
		sum += arguments[i];
	}
	return sum;
}

function small(a,b){
	if(a>b) return b;
	else return a;
}

const min = (a,b) => a>b?b:a;

function callback() {
	log('callback');
}
function callTenTimes(fn){ // fn이 함수이다. 함수가 인자로들어갈수있음
	for(let i=0; i<3; i++){
		try {
			fn();
		} catch (e) {
			log('함수 이름을 넘겨 주세요');
		}
	}
}

// callTenTimes(callback);
// callTenTimes(function(){
// 	log('~~~');
// });

// let fc;
// callTenTimes(fc = () => alert('~~~~'));

// let intervalId = setInterval(callback,3000); // 3초 간격으로 함수계속호출 setInterval
/*												// 멈출때 이름넘겨줌 clearInterval(intervalId);
let id2 = setInterval(function() {
	log(new Date())
}, 1000);											

// 멈출때  clearInterval(id2);

setTimeout(function(){
	clearInterval(id2)    // 5초 후에 멈춤
	// location.href="http://www.naver.com";
	// location.href="http://localhost:8000/2_css/submenu/index.html"  //주소이동
},5000);
*/

function fa(){
	let data = 0;
	function inner(){  // 이너호출하기 fa()()
		return ++data;
	}
	return inner;
}

let ff1 = fa; // 함수전체를 가지고있음

let ff2 = fa(); // 똑같은 아우터주소를 사용함 리턴된 이너를 가지고있어서 호출할 때마다 +1이됨

/**
 * ff1()() 아우터를 계속 생성
 * ff2() 사용했던 이너를 계속 호출함
 */

let fb1 = function fb(){
	let data = 0;
	function inner(){  
		return ++data;
	}
	return inner;
} ;
let fb2 = function fb(){ // 호출할때마다 data가 죽지않고 살아있음 
	let data = 0;
	function inner(){  
		return ++data;
	}
	return inner;
}() ;









