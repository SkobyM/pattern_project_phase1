
package com.houarizegai.calculator.operations;

public abstract class OperationCreator {

    public interface Operation {
        double execute(double first, double second);
    }

    // Factory Method
    protected abstract Operation createOperation();

    public double calculate(double first, double second) {
        return createOperation().execute(first, second);
    }

    // Select the appropriate creator
    public static OperationCreator forOperator(char operator) {
        switch (operator) {
            case '+':
                return new AdditionCreator();
            case '-':
                return new SubtractionCreator();
            case '*':
                return new MultiplicationCreator();
            case '/':
                return new DivisionCreator();
            case '%':
                return new ModuloCreator();
            case '^':
                return new PowerCreator();
            default:
                return null;
        }
    }

    // Concrete Creators
    public static class AdditionCreator extends OperationCreator {
        @Override
        protected Operation createOperation() {
            return new AdditionOperation();
        }
    }

    public static class SubtractionCreator extends OperationCreator {
        @Override
        protected Operation createOperation() {
            return new SubtractionOperation();
        }
    }

    public static class MultiplicationCreator extends OperationCreator {
        @Override
        protected Operation createOperation() {
            return new MultiplicationOperation();
        }
    }

    public static class DivisionCreator extends OperationCreator {
        @Override
        protected Operation createOperation() {
            return new DivisionOperation();
        }
    }

    public static class ModuloCreator extends OperationCreator {
        @Override
        protected Operation createOperation() {
            return new ModuloOperation();
        }
    }

    public static class PowerCreator extends OperationCreator {
        @Override
        protected Operation createOperation() {
            return new PowerOperation();
        }
    }

    // Concrete Operations
    private static class AdditionOperation implements Operation {
        public double execute(double a, double b) {
            return a + b;
        }
    }

    private static class SubtractionOperation implements Operation {
        public double execute(double a, double b) {
            return a - b;
        }
    }

    private static class MultiplicationOperation implements Operation {
        public double execute(double a, double b) {
            return a * b;
        }
    }

    private static class DivisionOperation implements Operation {
        public double execute(double a, double b) {
            return a / b;
        }
    }

    private static class ModuloOperation implements Operation {
        public double execute(double a, double b) {
            return a % b;
        }
    }

    private static class PowerOperation implements Operation {
        public double execute(double a, double b) {
            return Math.pow(a, b);
        }
    }
}
