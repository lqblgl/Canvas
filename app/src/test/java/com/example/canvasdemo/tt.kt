package com.example.canvasdemo

import kotlinx.coroutines.*


fun main() {
//    Thread{
//        println("thread")
//    }.start()
//    runBlocking {
//        add()
//        println("thread2")
//    }
    GlobalScope.launch() {
        coroutineScope {
            add3()
        }
//        runBlocking {
//            add3()
//        }
        launch(Dispatchers.IO) {
            add2()
        }
        add()

    }
//
//    println("thread2")
    Thread.sleep(10000)
}

fun add(){
    println("1"+Thread.currentThread().name)
}

fun add2(){
    println("2"+Thread.currentThread().name)
}

fun add3(){
    println("3"+Thread.currentThread().name)
}