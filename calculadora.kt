fun main() {

    fun calculadora(n1:Float?, n2:Float?, tipo:Int){             
        if(n1 != null && n2 != null) {
            println("Tudo certo, continuando a operação")            
            
            //função de ordem superior          
            var soma:Float = calculate(n1, n2){a,b -> a+b}
            var subtracao:Float = calculate(n1, n2){a,b -> a-b}
            var multiplicacao:Float = calculate(n1, n2){a,b -> a*b}
			var divisao:Float = calculate(n1, n2){a,b -> a/b}
    
            when(tipo){
            1 -> display(n1, n2, "Soma", soma)
            2 -> display(n1, n2, "Subtração", subtracao)
            3 -> display(n1, n2, "Multiplicação", multiplicacao)
            4 -> display(n1, n2, "Divisão", divisao)
            else -> println("Valor inserido inválido!")
            }            
        } else {
            println("Não é aceito valores nulos!")
        }
    }
    
    var n1:Float? = 5.0f 
    var n2:Float? = 8.0f
    var tp:Int = 4
    calculadora(n1, n2, tp)
}

fun calculate(n1:Float, n2:Float, operation:(Float, Float)->Float):Float{
    return operation(n1, n2)
}

fun display(n1:Float, n2:Float, operation:String, result:Float?){
    println("A $operation de $n1 com $n2 é igual a $result")
}