package by.it.lozouski.jd01_12;

import java.util.HashMap;
import java.util.Scanner;
import java.util.Stack;

class TaskC3 {
    public static void main(String[] args) {
        Scanner sc1 = new Scanner(System.in);
        HashMap<Character, Character> mapC3 = new HashMap<>(); //создал хешмап Char для хранения скобок
        Stack<Character> stack = new Stack<>(); //создал стек Char для хранения открывающих скобок
        ///??????вопрос?????? Класс стек не использовать? из-за чего?

        while (true){
            String inputLine = sc1.next(); //ввод строки, программу завершать по end
            if (inputLine.equals("end")) break;
            //заполнил мапу данными в виде ключ - открывающая скобка, значение - закрывающая скобка
            mapC3.put('(',')');
            mapC3.put('[',']');
            mapC3.put('{','}');
            for (int i = 0; i < inputLine.length(); i++) { //циклом перебираю введенную строку по каждому char
                char currentChar = inputLine.charAt(i); //присваиваю текущее значение чара в переменную
                if (mapC3.containsKey(currentChar)){ //...если мапа содержит ключ равный текущему чару( ключи - открывающие скобки )
                    stack.push(currentChar); //...добавляю в стек этот чар
                    //если нет, то...
                    //...в стеке сейчас хранится последовательность открытых скобок, и...
                }else if(mapC3.containsValue(currentChar)){ //...проверяю, содержит ли мапа в своих значениях(закрывающие скобки) текущий чар
                    // если проверка прошла, то нужно удалить открывающую скобку из стека
                    //удаление проходит по условию, но если оно выполняеться, то последовательность скобок не верна.
                    if (!stack.empty() && mapC3.get(stack.pop()) != currentChar){
                        break;
                    }
                }
            }
            //печать стека, если он пустой, то скобки правильно расставлены, вернет true,
            // но если в стеке остались элементы, вернет false
            System.out.println(stack.empty());
            //подчистить коллекцию и стек, для каждой итерации цикла while.
            mapC3.clear();
            stack.clear();
        }
    }
}
