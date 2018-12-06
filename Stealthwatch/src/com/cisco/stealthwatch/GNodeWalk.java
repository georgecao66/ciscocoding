package com.cisco.stealthwatch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Stream;

public class GNodeWalk {
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
		
		GNodeWalk walk = new GNodeWalk();
		
		ArrayList<GNode> result = walk.walkGraph(a);
		
		result.forEach(n -> System.out.println(n.getName()));
	}
	
	public ArrayList<GNode> walkGraph(GNode node) {
		ArrayList<GNode> intermedia = new ArrayList<GNode>();
		return walkGraph(node, intermedia);
	}

	public ArrayList<GNode> walkGraph(GNode node, ArrayList<GNode> intermedia) {
		intermedia.add(node);
		Stream<GNode> stream = Arrays.stream(node.getChildren());
		stream.forEach(child -> {
			walkGraph (child, intermedia);
		});
		
		return intermedia;
	}
}
