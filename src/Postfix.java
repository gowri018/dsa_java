import java.util.Scanner;
import java.util.Stack;

public class Postfix {
    public static void main(String args[]){

        Scanner sc=new Scanner(System.in);

        String exp="A*B+(C/D)%F-G";
        System.out.println("Expression "+exp);
       
        System.out.println("Postfix: " + postfix(exp));
        System.out.println("Prefix: " + prefix(exp));
    }

    public static int precedence(char ch){
        if(ch=='+' || ch=='-')
            return 1;
        else if(ch=='*'|| ch=='/'||ch=='%')
            return 2;
        else
            return 0;
    }
  
    public static String postfix(String exp){

        Stack<Character> stk= new Stack<>();
        StringBuilder res=new StringBuilder();
        int i;

        for(i=0;i<exp.length();i++){
            char ch=exp.charAt(i);

            if(ch>='A' && ch<='Z'){
                res.append(ch);
            }
            else if(ch=='('){
                stk.push(ch);
            }
            else if(ch==')'){
                while(!stk.empty() && stk.peek()!='('){
                    res.append(stk.pop());
                }
                stk.pop();
            }
            else{ //operators
                while(!stk.empty() && precedence(ch)<=precedence(stk.peek().charValue())){
                    res.append(stk.pop());
                }
                stk.push(ch);
            }
        }

        while(!stk.empty()){
            res.append(stk.pop());
        }
        return res.toString();
    }

    public static String prefix(String exp){
        StringBuilder rev=new StringBuilder(exp).reverse();
        for(int i=0;i<rev.length();i++){
            if(rev.charAt(i)=='(')
                rev.setCharAt(i, ')');
            else if(rev.charAt(i)==')')
                rev.setCharAt(i, '(');
            
        }

        String res=postfix(rev.toString());
        StringBuilder result=new StringBuilder(res).reverse();
        return result.reverse().toString();        
    }

}
