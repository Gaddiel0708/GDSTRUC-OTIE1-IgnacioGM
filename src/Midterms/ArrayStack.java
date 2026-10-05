package Midterms;

import java.util.EmptyStackException;

public class ArrayStack {
    private Card[] stack;
    private int top;

    public ArrayStack(int capacity) {
        stack = new Card[capacity];
        top = -1;
    }

    public void push(Card c) {
        // stack is already full (auto-resizes like your class code)
        if (top == stack.length - 1) {
            Card[] newStack = new Card[stack.length * 2];
            System.arraycopy(stack, 0, newStack, 0, stack.length);
            stack = newStack;
        }
        stack[++top] = c;
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public Card pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        Card poppedCard = stack[top];
        stack[top] = null;
        top--;
        return poppedCard;
    }

    public Card peek() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return stack[top];
    }

    public void printStack() {
        if (isEmpty()) {
            System.out.println("  [Empty]");
            return;
        }
        for (int i = top; i >= 0; i--) {
            System.out.println("  - " + stack[i]);
        }
    }

    // Helper method to get the number of items in the stack
    public int size() {
        return top + 1;
    }
}