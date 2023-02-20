package com.example.test_4

// 최고 상위 영역 : 선언과 동시에 초기값 할당
val name = "이상용"
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

fun main(){

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