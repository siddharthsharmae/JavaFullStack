package com.Siddharth.Upload.JavaFullStack;
//Calculator which takes inputs from command line
public class CommandLineCalculator {
        public static void main(String[] input) {
            double inp1 = Double.parseDouble(input[0]);
            double inp2 = Double.parseDouble(input[2]);
            char opr = input[1].charAt(0);
            switch (opr) {
                case '+':
                    System.out.println("Addition is " + (inp1 + inp2));
                    break;
                case '-':
                    System.out.println("Subtraction is " + (inp1 - inp2));
                    break;
                case '*':
                    System.out.println("Multiplication is " + (inp1 * inp2));//* is reserved for opening files */
                    break;
                case '/':
                    System.out.println("Divisin is " + (inp1 / inp2));
                    break;
                case '^':
                    System.out.println("Power is"+(Math.pow(inp1, inp2)));
                    break;
                default:
                    System.out.println("Invalid Operator");
                    break;
            }
        }
    }

