package com.krayapp.zaycevnetapp

fun main (args:Array<String>){

    println(discountPrices(arrayOf(5,100,20,66,16),50,1,3))
}

fun discountPrices(price:Array<Int>, discount:Int,offset:Int,readLength:Int):List<Int>{
    try {
        val mutablePrice:MutableList<Int> = mutableListOf()
        if ((offset + readLength)+1 < price.size){
            println("Error bound")
        }else{
            for(i in offset..readLength){
                mutablePrice.add((price[i]/100f*discount).toInt())
            }
            return mutablePrice.toList()
        }
        return emptyList()
    }catch (e :ArrayIndexOutOfBoundsException ){
        throw(Throwable("Недостаточная длина массива для таких параметров $offset и $readLength при длине массива ${price.size}"))
    }

}