package com.cisco.stealthwatch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Stream;

public class GNodePath {
	public static void main(String[] args) {
		GNodeVO a = new GNodeVO("A");
		GNodeVO b = new GNodeVO("B");
		GNodeVO c = new GNodeVO("C");
		GNodeVO d = new GNodeVO("D");
		GNodeVO e = new GNodeVO("E");
		GNodeVO f = new GNodeVO("F");
		
		GNodeVO[] childrenForA = {b, c};
		a.setChildren(childrenForA);
		
		GNodeVO[] childrenForB = {d, e};
		b.setChildren(childrenForB);
		
		GNodeVO[] childrenForC = {f};
		c.setChildren(childrenForC);
		
		GNodePath path = new GNodePath();
		
		ArrayList<ArrayList<GNode>> result = path.paths(a);
		
		System.out.print("(");
		result.forEach(n -> {
			System.out.print("(");
			n.forEach(m -> System.out.print(m.getName()));
			System.out.print(")");
		});
		System.out.print(")");
	}
	
	public ArrayList<ArrayList<GNode>> paths(GNode node) {
		ArrayList<GNode> intermedia = new ArrayList<GNode>();
		intermedia.add(node);
		ArrayList<ArrayList<GNode>> result = new ArrayList<ArrayList<GNode>>();
		paths(node, result, intermedia);
		
		return result;
	}

	public void paths(GNode node, ArrayList<ArrayList<GNode>> result, ArrayList<GNode> intermedia) {
		
		if (node.getChildren().length == 0) {
			result.add(intermedia);
		}
		
		Stream<GNode> stream = Arrays.stream(node.getChildren());
		stream.forEach(child -> {
			ArrayList<GNode> temp = new ArrayList<GNode>();
			temp.addAll(intermedia);
			temp.add(child);
			paths(child, result, temp);
		});
		
	}
}
