package org.jdbcMaktab;

public class CustomerList {
    private Customer[] list;
    private int emptyHomeIndex;

    public CustomerList() {
        list = new Customer[1000];
        emptyHomeIndex = 0;
    }

    public void add(Customer value) {
        list[emptyHomeIndex] = value;
        emptyHomeIndex++;
    }

    public Customer get(int index) {
        return list[index];
    }

    public Customer get(String nationalCode) {
        for (Customer c: list) {
            if (c.getNationalCode().equals(nationalCode))
                return c;
        }
        return null;
    }

    public Boolean isEmpty() {
        return emptyHomeIndex == 0;
    }

    public int size() {
        return emptyHomeIndex;
    }

    public void add(int index, Customer value) {
        // Check: Index invalid
        for (int i = emptyHomeIndex; i > index ; i--) {
            list[i] = list[i - 1];
        }
        list[index] = value;
        emptyHomeIndex++;
    }

    public void addAll(Customer[] values) {
        for (Customer v: values) {
            add(v);
        }
    }
}
