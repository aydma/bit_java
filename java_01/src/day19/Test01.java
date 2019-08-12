package day19;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

import javax.management.Query;

public class Test01 {
	public static void main(String[] args) {
		Stack<String> stack = new Stack<String>();
		for(int i=0; i<100; i++) {
			stack.push(""+i);
		}
		System.out.println(stack.pop());
		
		Queue<Integer> queue = new LinkedList<Integer>(); // 이미 있는 클래스 쓰려면 자식 클래스생성해야함
		for(int i=0; i<100; i++) {
			queue.offer(i);
		}
		System.out.println(queue.poll());
		
	}
}
