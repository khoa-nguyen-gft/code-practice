

function minutesToSeconds(time) {
	
	if(parseInt(time.split(":")[1]) >=60) return false;
	return time.split(":").reduce((a,b) => a * 60 + b*1, 0);
}

minutesToSeconds("13:56") ;// 836

console.log(minutesToSeconds("13:56"));

function textToNum(phone) {
	return phone
	.replacel("\[ABC]\g", "2")
	.replacel("\[DEF]\g", "3")
	.replacel("\[GHI]\g", "4")
	.replacel("\[JKL]\g", "5")
	.replacel("\[MNO]\g", "6")
	.replacel("\[PQRS]\g", "7")
	.replacel("\[TUV]\g", "8")
	.replacel("\[WXYZ]\g", "9");
}

//textToNum("(325)444-TEST") ;// "(325)444-8378"







function multiply(arr) {
	var result = arr.map(item => Array(arr.length).fill(item));
	console.log(result);
}

///multiply(["*", "%", "$"]) ➞ [["*", "*", "*"], ["%", "%", "%"], ["$", "$", "$"]]

//multiply(["*", "%", "$"]);

function checkPerfect(num) {
	return [...Array(num).keys()].filter(i => num % i == 0).reduce((a,b)=> a +b, 0) === num;
	
}

//checkPerfect(6) ;// true
//
//checkPerfect(28) ;// true
//
//checkPerfect(496) ;// true
//
//checkPerfect(12) ;// false
//
//checkPerfect(97) ;// false



function toHex(str) {
	return [...str].map(s => s.charCodeAt(0).toString(16)).join(' ');
}



//toHex("hello world");// ➞ "68 65 6c 6c 6f 20 77 6f 72 6c 64"
//
//toHex("Big Boi") ;//➞ "42 69 67 20 42 6f 69"
//
//toHex("Marty Poppinson");// ➞ "4d 61 72 74 79 20 50 6f 70 70 69 6e 73 6f 6e"


function numberSplit(n) {
	return [Math.floor(n/2), Math.ceil(n/2)];
}


//numberSplit(4) ;// ➞ [2, 2]
//
//numberSplit(10) ;// ➞ [5, 5]
//
//numberSplit(11) ;// ➞ [5, 6]
//
//numberSplit(-9) ;// ➞ [-5, -4]


function factorize(num) {
	let result = [...Array(num+1).keys()].filter(x => (x !==0 && num % x === 0));
	console.log(result);
}

//
// factorize(12);// [1, 2, 3, 4, 6, 12]
//
// factorize(4) ;// [1, 2, 4]
//
// factorize(17) ;// [1, 17]

function clone(arr) {	
	return arr.push([...arr]);
}



// clone([1, 1]) ;// [1, 1, [1, 1]]
//
// clone([1, 2, 3]) ;// [1, 2, 3, [1, 2, 3]]
//
// clone(["x", "y"]) ;// ["x", "y", ["x", "y"]]


function quadraticEquation(a, b, c) {
	return (-b + Math.abs(b*b - 4*a*c))/(2*a);
}


function rps(s1, s2) {
	if (s1 === s2) return "TIE";
	
	if ("paper" === s1 && "rock" === s2
		|| "rock" === s1 && "scissors" === s2
		|| "scissors" === s2 && "paper" === s2){
		return "Player 2 wins";
	}
	
	return "Player 1 wins";
			
}



function warOfNumbers(arr) {
	return Math.abs(arr.reduce((a,b) => (b & 1) == 1? a + b : a -b, 0));
}


// warOfNumbers([5, 9, 45, 6, 2, 7, 34, 8, 6, 90, 5, 244]);// ➞ 168

function highestDigit(number) {
	
	Math.max(...`${number}`);
	Math.max(...`${number}`);
	Math.max(...`${number}`);
	Math.max(...`${number}`);
	console.log(...number.toString());
	return result = Math.max(...number.toString().split(''));
}


// highestDigit(379);// ➞ 9
//
// highestDigit(2);// ➞ 2
//
// highestDigit(377401);// ➞ 7



function otherSides(length) {
	console.log(Math.sqrt(3) * length);
	return [
	  	2 * length, 
	  	Math.round(173.2 * length) / 100
	]
}


// otherSides(1);// ➞ [2, 1.73]
//
// otherSides(2);// ➞ [4, 3.46]
//
// otherSides(3);// ➞ [6, 5.2]



function isInOrder(str) {
	return str.split('').sort().join('') === str;	
}


// isInOrder("abc");// ➞ true
//
// isInOrder("edabit");// ➞ false
//
// isInOrder("123") ;// ➞ true
//
// isInOrder("xyzz") ;// ➞ true

function solutions(a, b, c) {
	let result = Math.pow(b,2) - 4 * a * c;
	
	result = result < 0 ? 0 : result == 0 ? 1 : 2;
	console.log(result);
	
	return result
}


// solutions(1, 0, -1);// ➞ 2
// //x² - 1 = 0 has two solutions (x = 1 and x = -1).
//
// solutions(1, 0, 0);//➞ 1
// //x² = 0 has one solution (x = 0).
//
// solutions(1, 0, 1);// ➞ 0
// //x² + 1 = 0 has no real solutions.

function getFilename(path) {
	let str = path.substring(path.lastIndexOf('/')+1);
	console.log(str);
}


// getFilename("C:/Projects/pil_tests/ascii/edabit.txt");// ➞ "edabit.txt"
//
// getFilename("C:/Users/johnsmith/Music/Beethoven_5.mp3");// ➞
// "Beethoven_5.mp3"
//
// getFilename("ffprobe.exe");// ➞ "ffprobe.exe";//
