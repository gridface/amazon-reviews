//fibbonacci sequence
var a = 0
var b = 1
var c = 0
do {
  c = a + b
  println(c)
  b = c + a
  println(b)
  a = b + c
  println(a)
}
while ( a <= 200)
//

//functions
// format def <function name>(parameter name: type...) : return type = {}
def squareIt(x: Int) : Int = {
  x *x
}

def cubeIt(x: Int) : Int = {x * x * x}
def transformInt(x: Int, f: Int => Int): Int = {
  f(x)
}

val result = transformInt(2, cubeIt)
println(result)

var greetings : String = "Greetings, fellow Human. How are you feeling?"
//upper(greetings)
//.toUpperCase lambda function
def upper(x: String) : String = {
  x.toUpperCase()
}
//.toUpperCase lambda function
def lower(x: String) : String = {
  x.toLowerCase()
}

def removePunctuation(x: String) : String = {
  x.replaceAll("""[\p{Punct}]""", "")
}

greetings = greetings.toLowerCase()
println(greetings)
removePunctuation(greetings)

//executing a function on list items
val myList = List("Here is an Unformatted Sentence@!", "Here is AnOThEr UnFoRmAtTeD String.", "?Que, one More?")
println(myList)

val cleanedList = myList.map( (sentence: String) => (removePunctuation(sentence).toLowerCase()) )

//some reduce and filter functions
val numbers = List(1,2,3,4,5,6,7,8,9 )
val moreNumbers = List(10,11,12,13,14)
val summedNumbers = numbers.reduce((x: Int, y: Int) => x + 7)
val filteredNumbers = numbers.filter(_ != 3)
val concattedList = numbers ++ moreNumbers
val evenList = concattedList.filter((x:Int) => x % 2 == 0)
println(evenList)
//Key Value Maps
val reviews = Map(
  "bill" -> "bills review",
  "fred" -> "freds review",
  "ron" -> "rons review")

println(reviews("bill"))
val newReview = util.Try(reviews("jaina")) getOrElse "no reviews"
println(newReview)
//text preprocessing pipeline
// 1. remove html tags
// 2. remove accented characters
// 3. expand contractions
// 4. remove punctuation
// 5. lemmatization