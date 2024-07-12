package jms;

//create a number and  operation attribute and all the related methods and constructors
public class Number {

    private int number;
    private String operation;

    public Number() {
    }

    public Number(int number, String operation) {
        this.number = number;
        this.operation = operation;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    @Override
    public String toString() {
        return "Number{" +
                "number=" + number +
                ", operation='" + operation + '\'' +
                '}';
    }
}
