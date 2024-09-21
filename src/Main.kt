fun main() {
    println("Данная программа поможет провести операции: сложения,умножения, деления, вычитания (с двумя числами)" +
            "вы вводите данные через пробел, (например: 9.3 1.7 +) и получить результат.\n")
    while (true) {
        println("Введите два числа и операцию через пробел (введите 'exit' для выхода):")

        val input = readln().trim()

        if (input.equals("exit", ignoreCase = true)) {
            println("Программа завершена.")
            break
        }

        val sections = input.split(" ")

        if (sections.size != 3) {
            println("Ошибка: Введите два числа и символ операции, разделенные пробелами. Пример: 9 1 -")
            continue
        }

        try {
            val num1 = sections[0].toDouble()
            val num2 = sections[1].toDouble()
            val operation = sections[2]

            val result = when (operation) {
                "+" -> num1 + num2
                "-" -> num1 - num2
                "*" -> num1 * num2
                "/" -> {
                    if (num2 == 0.0) {
                        throw ArithmeticException("Ошибка: Деление на ноль невозможно.")
                    }
                    num1 / num2
                }
                else -> {
                    println("Ошибка: Некорректный символ операции. Введите пожалуйста допустимые операции: +, -, *, /")
                    println()
                    continue
                }
            }

            println("Результат: $result")

        } catch (e: NumberFormatException) {
            println("Ошибка: Введены некорректные числа. Попробуйте еще раз.")
        } catch (e: ArithmeticException) {
            println(e.message)
        }

        println()
    }
}