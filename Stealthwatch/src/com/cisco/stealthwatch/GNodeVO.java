package com.cisco.stealthwatch;

public class GNodeVO implements GNode {
	private String name;
	private GNodeVO[] children;
	
	public GNodeVO(String name ) {
		this.name = name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	public void setChildren(GNodeVO[] children) {
		this.children = children;
	}
	
	public String getName() {
		return name;
	};
	
	public GNodeVO[] getChildren() {
		return children == null? new GNodeVO[0] : children;
	};

}
