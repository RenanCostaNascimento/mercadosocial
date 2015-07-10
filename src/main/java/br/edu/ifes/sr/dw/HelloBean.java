package br.edu.ifes.sr.dw;

import javax.faces.bean.ManagedBean;

@ManagedBean(name = "hello")
public class HelloBean {

	private String value = "Hello World!";

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
	
}
