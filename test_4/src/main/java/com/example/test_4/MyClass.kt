package com.example.test_4



// 최고 상위 영역 : 선언과 동시에 초기값 할당
//val name = "이상용"
val name2:String = "이상용2"
val num = 10;
var data = 10;

class MyClass {
    // 클래스 안에 영역 : 선언과 동시에 초기값 할당
    // var name4 :
    var name = "이상용"
    var age = 40;
    val name2 = "이상용4"
}

class User {
    var name = "lsy"
    constructor(name: String) {
        this.name = name
    }
    fun someFun() {
        println("name : $name")
    }
}

class User2(name:String, age:Int) {
    init {
        println("객체 생성 할 때 마다, init 실행이 됨. ")
    }
}

//class User3(val name:String, val age:Int) {
    class User3(val name:String, val age:Int) {
    init {
        println("init 안에서는 주생성자 매개변수 사용 가능. : $name, $age")
    }

    //var, val 로 지정하면, 다른 함수에서도 사용 가능.
    fun someFun() {
        println("name : $name")
    }
}


//class User4(name:String){
class User4(name:String,age:Int,phone:String){
    // 실제 작업은 주 생성자에서 선언을 해서 사용을 많이 하는 편.
    //constructor(name:String, age:Int):this(name)

    //constructor(name:String, age:Int,phone:String):this(name,age)
}

open class Super(name:String){
}
class Sub:Super{
    constructor(name:String):super(name)
}

//

open class Super2(name:String){
    var superData = 10
    fun superFun(){
        println("super class")
    }
}

class Sub2(name: String) :Super2(name)

open class Super3(name:String){
    open var superData = 10
    open fun superFun(){
        println("super class")
    }
}

class Sub3(name: String) :Super3(name){
    override var superData= 20
    override fun superFun(){
        println("재정의 테스트 ")
    }
}

open class Super4{
    var publicData = 10
    protected var protectedData = 10
    private var privateData = 10

}

class Sub4:Super4(){
    fun subFun(){
        publicData++
        protectedData++
        //privateData++
    }
}

class NonDataClass(val name : String, val age:Int)

data class DataClass(val name : String, val age:Int)


// 타입을 명시 안하면 외부에서 사용 못함
val obj = object {
    var data = 10
    fun some() {
        println("익명클래스 테스트")
        println("data : $data")
    }
}

open class Super5{
    open var publicdata = 10
    open fun some() {
        println("익명 클래스 사용 테스트")
    }
}

//익명 클래스 이름없음. 키워드를  object : 상속할 클래스, 인터페이스 표기{}
val obj2 = object:Super5() {
    override var publicdata = 20
    override fun some(){
        println("익명 클래스 사용 테스트")
    }
}

class MyClass2{
    //인스턴스 멤버
    var outData = 20
    // static 과 비슷한 효과, 클래스 멤버
    companion object{
        var data = 10
        fun some() {
            println("컴패니언 object 테스트 ")
        }
    }
}

// 람다 함수 간단 예제 (익명함수)
val sum = {no1:Int, no2:Int -> no1 + no2}

// 매개변수 1개인 경우 it 사용하기 전
val sum2 = {no1:Int-> println(no1)
30}

// 매개변수 1개인 경우 it 사용하기
// 함수 타입 :(Int)->unit
val sum3 :(Int) -> Unit = {println(it)}


fun FunTest(arg:(Int) -> Boolean):() -> String{
    val result6 = if(arg(10)){
        "valid"
    } else {
        "invalid"
    }
    return {"교차함수 테스트 : $result6"}
}



fun main(){
    var data333 : String? = null
    //? 연산자를 사용한 변수에 특정 함수에 접근시  ?. 기호를 사용하거나
    // 또는 !! 예외 발생 연산자를 사용해야함
    // 참고. 널체크 ? 빠지게 되면 컴파일러가 친절히 알려줌.
    data333?.length

    //만약에, 널이 아니면 해당 길이를 반환하고,
    //만약에 널이면 지정한 값을 사용한다.
    //nvl 함수와 비슷한 구조
    //삼항 다항식 비슷한 구조
    data333?.length ?: 0

    println("널 안전성 체크해보기.")
    println(data333?.length ?: 0)
    println(data333!!.length ?: 0)


    val result6 = FunTest({no->no>0})
    println(result6())


    val result4 = sum(10,20)
    val result5 = sum2(10)
    println(result5)

    var result2 = MyClass2.data
    println(result2)
    MyClass2.some()
    val myClass3 = MyClass2()
    myClass3.outData



    println(obj2.publicdata)
    obj2.some()

    val nondata1 = NonDataClass("lsy2",30)
    val nondata2 = NonDataClass("lsy2",30)
    val dataClass1 = DataClass("lsy3",40)
    val dataClass2 = DataClass("lsy3",40)
    println(nondata1.equals(nondata2))
    println(dataClass1.equals(dataClass2))
    println(nondata1.toString())
    println(dataClass1.toString())


    var obj4=Sub4()
    obj4.publicData


    var obj3=Sub3("lsy8")
    println(obj3.superData)
    obj3.superFun()

    var obj = Sub2("lsy7")
    println(obj.superData)
    obj.superFun()

    val user5 = User3("lsy2",30)
    user5.someFun()


    val user2 = User2("lsy2",30)
    val user3 = User2("lsy3",30)
    val user4 = User2("lsy4",30)

    var myClass = MyClass()
    myClass.age

    // 객체 생성시 new 없이 바로 생성자 호출 방법
    val user = User("lsy2")
    //val user2 = User()
    user.someFun()

    var data04 = arrayOf<Int>(10,20,30)
    for (i in data04.indices) {
        print(data04[i])
        if (i !== data04.size -1) print(",")
    }
println("--------------------")
    var data05 = arrayOf<Int>(10,20,30)
    for ((index, value) in data05.withIndex()) {
        print(value)
        if (index !== data05.size - 1) print(",")
    }
    println("--------------------")

    var sum: Int = 0
    for (i in 1..10){
        sum += i}
    println(sum)

    var data02: Any = 10
    val result02 = when (data02){
        is String -> println("data is String")
        20,30 -> println("data is 20 or 30")
        in 1..10 -> println("data is 1..10")
        else -> println("data is not valid")
    }
    println("$result02")


    var data01: Any = 10
    when (data01){
        is String -> println("data is String")
        20,30 -> println("data is 20 or 30")
        in 1..10 -> println("data is 1..10")
        else -> println("data is not valid")
    }


    var data = "hi"
    when (data){
        "hi" -> println("data is hi")
        "hi2" -> println("data is hi2")
        else -> {
            println("data is not valid")
        }
    }


    var data00 = 10
    val result = if(data00>0){
        println("테스트")
        true
    } else{
        println("else 테스트")
        false
    }
    println("테스트 : $result")



    //가변 길이의 리스트, 맵

    val data18 = mutableMapOf<String, String>()
    data18.set("key","value")
    println(data18.get("key"))
    // companion 클래스 타입 지정후 사용

    val data17 = mutableListOf<Int>()
    data17.add(1)
    data17.add(2)
    println(data17[0])

    val data16 = intArrayOf(10,20,30)
    val data26 = booleanArrayOf(true, false, true)

    println(
        """
array size : ${data16.size}
array data : ${data16[0]}, ${data16[1]}, ${data16.get(2)}
            """
    )
    println(
        """
array size : ${data26.size}
array data : ${data26[0]}, ${data26[1]}, ${data26.get(2)}
            """
    )

    val data15 : Array<Int> = Array(3,{0})

    data15[0]=10
    data15[1]=20
    data15.set(2,30)

    println(
        """
array size : ${data15.size}
array data : ${data15[0]}, ${data15[1]}, ${data15.get(2)}
            """
)


    fun some (data1 : Int, data2 : Int = 10):Int{
        return data1 * data2
    }
    println(some(100))
    println(some(data2=100,data1=10))

    fun some2() : Nothing?{
        throw Exception()

    }

    var n1 : Int?
    n1 = null
    var n2 = 20

    var data13 : Nothing? = null


    var data11 : Any = 10
    var data21 : Any = "String"
    var data31 : Any = MyClass()

    fun test3(){
        println(data11)
        println(data21)
        println(data31)
    }
    var testxx = test3()
    println(testxx)


    fun addSum(no:Int) : Int {
        var sum = 0
        for (i in 1..no){
            sum += i
        }
        return sum
    }

    val name = "yong"
    println("name : $name, sum: ${addSum(10)}")

    val str1 = "hi \n yong"
    val str2 = """
 hi
 world
 """
    println("str1: $str1")
    println("str2: $str2")

    var data1 : Int = 10
    data1 = data1 + 10
    data1 = data1.plus(10)

    // 함수 내부에서는 선언만 가능.
    var name10 : String
    var MyClass = MyClass()
    MyClass.name = "이상용3"
    println(MyClass.age)
    println(MyClass.name)
    println(MyClass.name2)
    println("hello World1231")
    println("lazy 테스트 및 결과값 재할당해서 연산 확인")
    println(data + 10)
}