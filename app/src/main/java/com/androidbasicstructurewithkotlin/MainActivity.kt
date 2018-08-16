package com.androidbasicstructurewithkotlin

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText
import com.androidbasicstructurewithkotlin.model.User
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private var abc: Int = 10
    private var a: String? = ""

    val xyz by lazy {
        User("lazy name of user")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        testMethod("test method")
        a?.length
        /*Passing function as argument of function*/
        one("f", ::two)

        /*Filtering the data*/
        val users = ArrayList<User>()
        users.add(User("DAR"))
        users.add(User("ABC"))
        users.add(User("DARSHNA"))

        var user: ArrayList<User>
        user = users.filter { it.name.startsWith("DAR") } as ArrayList<User>
        user.forEach { println(it) }
        user = users.filter { it.name == "DAR" } as ArrayList<User>
        user.forEach { println(it) }

        /*Using extension function*/
        etMain.onChange { tvMain.text = it }

        /*Accessing singleton data*/
        val a = Resource.name
        Resource.test()

        /*Builder style usage of methods which return Unit*/
        arrayOfMinusOnes(3).forEach { println(it) }

        val text = """
    |for (c in "foo")
        |print(c)
"""
        /*trimming the preceding margins from a string*/
        println(text.trimMargin())

        println(xyz.name)
    }

    private fun testMethod(a: String = "xyz"): Int {
        println(a)
        return 1
    }

    fun one(s: String, a: (s: String) -> String) = ""

    fun two(s: String = "ads") = "ads"

    /*Extension function*/
    fun EditText.onChange(cb: (String) -> Unit) {
        this.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                cb(s.toString())
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
        })
    }

    /*Singleton*/
    object Resource {
        const val name = "Name"

        fun test() {
            print("test")
        }
    }

    /*Builder type usage of methods which return Unit*/
    fun arrayOfMinusOnes(size: Int): IntArray {
        return IntArray(size).apply { fill(2) }
    }

    open class A {
        open fun f() {
            print("A")
        }

        fun a() {
            print("a")
        }
    }

    interface B {
        fun f() {
            print("B")
        } // interface members are 'open' by default

        fun b() {
            print("b")
        }
    }

    class C() : A(), B {
        // The compiler requires f() to be overridden:
        override fun f() {
            super<A>.f() // call to A.f()
            super<B>.f() // call to B.f()
        }
    }

    /*Extension function in another class*/
    class E /*: ASealed()*/ {
        fun baz() {}

        fun D.foo() {
            bar()   // calls D.bar
            baz()   // calls C.baz
        }

        fun caller(d: D) {
            d.foo()   // call the extension function
        }
    }


    fun main(args: Array<String>) {
        println("Let's invoke a lambda function ${returnMe { "return Me " + "function" }} here")
    }

    fun returnMe(string: () -> String): String {
        return string()
    }

//Prints
//Let's invoke a lambda function return Me function here


}

