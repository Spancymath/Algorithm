package com.zhang.chapter1.section13;

/**
 * 文本编辑器的缓冲区
 */
public class Buffer {
    //主栈，添加字符
    Stack<Character> mainStack = new Stack<>();
    //辅助栈，左移光标
    Stack<Character> aidStack = new Stack<>();
    //主栈元素数
    //辅助栈元素数
    //构造空缓冲区
    //光标位置插入字符
    public void insert(char c) {
        mainStack.push(c);
    }
    //删除并返回光标位置字符
    public char delete() {
        if (mainStack.isEmpty()) return (Character)null;
        return mainStack.pop();
    }
    //左移k个位置光标
    public void left(int k) {
        int i = 0;
        while (!mainStack.isEmpty() && i++ < k) {
            aidStack.push(mainStack.pop());
        }
    }
    //右移k个位置光标
    public void right(int k) {
        int i = 0;
        while (aidStack.isEmpty() && i++ < k) {
            mainStack.push(aidStack.pop());
        }
    }
    //缓冲区字符数
    public int size() {
        return mainStack.size() + aidStack.size();
    }
}
