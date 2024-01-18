package misc;

import java.util.*;

/**
 * This is the simplest and rude calculator stub with operands +-/* being positive integers.
 * Parenthesis are being used for operands prioritization, for this comprehends no priorities
 * of operands in itself.
 *
 * So, can not calculate an expression 3 + 8 * 4 in that form, however it can calculate
 * an expression with proper parenthesis: ((5+3)*(9-1))/(((3-2)+15)*2)
 *
 */
public class SimpleCalculator {

    private static final char PLUS = '+';
    private static final char MINUS = '-';
    private static final char MULTIPLY = '*';
    private static final char DIVIDE = '/';

    private static final char LEFT_BRACE = '(';
    private static final char RIGHT_BRACE = ')';

    private static final List<Character> SPACES = Arrays.asList(' ', '\t');
    private static final List<Character> TRAINS = Arrays.asList(PLUS, MINUS, MULTIPLY, DIVIDE, LEFT_BRACE, RIGHT_BRACE);

    private StringBuilder operand = new StringBuilder();

    // operators go to => trains
    // operands go to => wagons
    private Stack<Character> trains = new Stack<>();
    private Stack<Integer> wagons =  new Stack<>();


    public int calculate(String expression) {
        for (int i =0; i<expression.length(); i++) {
            char c = expression.charAt(i);

            if (SPACES.contains(c)) {
                continue;
            }

            if (TRAINS.contains(c)) {
                try {
                    switch (c) {
                        case RIGHT_BRACE:
                            saveOperand();

                            char operation = trains.pop();
                            Integer operand2 = wagons.pop();
                            Integer operand1 = wagons.pop();
                            wagons.push(calculate(operand1, operand2, operation));

                            char top = trains.pop();
                            if (LEFT_BRACE != top) {
                                throw new IllegalArgumentException("Incorrect expression");
                            }
                            break;
                        default:
                            saveOperand();
                            trains.push(c);
                            break;
                    }
                } catch (EmptyStackException | NumberFormatException e) {
                    throw new IllegalArgumentException("Incorrect expression");
                }
            } else {
                // next character of operand
                operand.append(c);
            }
        }

        // case : 15 + 3
        if (!trains.empty()) {
            saveOperand();
            char operation = trains.pop();
            Integer operand2 = wagons.pop();
            Integer operand1 = wagons.pop();
            wagons.push(calculate(operand1, operand2, operation));
        }

        // after all processing we MUST get single result value in wagons stack
        if (!(trains.empty() && wagons.size() == 1)) {
            throw new IllegalArgumentException("Incorrect expression");
        }
        return wagons.pop();
    }

    private void saveOperand() throws NumberFormatException {
        if (operand.length() > 0) {
            wagons.push(Integer.parseInt(operand.toString()));
        }
        operand = new StringBuilder();
    }

    private Integer calculate(Integer operand1, Integer operand2, char operation) {
        switch (operation) {
            case PLUS:
                return operand1 + operand2;
            case MINUS:
                return operand1 - operand2;
            case MULTIPLY:
                return operand1 * operand2;
            case DIVIDE:
                return operand1 / operand2;
            default:
                throw new IllegalArgumentException("Unsupported operation: " + operation);
        }
    }

    public static void main(String[] args) {
//        String expr = "5 + 3 * 3"; // this is not gona work
        String expr = "5+(3 * 3)";
//        String expr = "((5+3)*(9-99))/(((3-1)+15)*2)";
//        String expr = "((5+3)*(9-1))/(((3-2)+15)*2)";

        SimpleCalculator calculator = new SimpleCalculator();
        System.out.println(calculator.calculate(expr));
    }
}
