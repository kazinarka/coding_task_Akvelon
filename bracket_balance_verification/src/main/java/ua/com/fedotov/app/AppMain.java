package ua.com.fedotov.app;

public class AppMain {

    public static void main(String[] args) {
        System.out.println(BalanceVerificator.isCorrectBrackets("{"));
        System.out.println(BalanceVerificator.isCorrectBrackets("}"));
        System.out.println(BalanceVerificator.isCorrectBrackets("{([])}"));
        System.out.println(BalanceVerificator.isCorrectBrackets("{([(])}"));
        System.out.println(BalanceVerificator.isCorrectBrackets("{([)])}"));
        System.out.println(BalanceVerificator.isCorrectBrackets("{}"));
        System.out.println(BalanceVerificator.isCorrectBrackets("([{])"));
        System.out.println(BalanceVerificator.isCorrectBrackets("{()[()([]{}[]()]}"));
        System.out.println(BalanceVerificator.isCorrectBrackets("{()[()((([()]}"));
    }
}
