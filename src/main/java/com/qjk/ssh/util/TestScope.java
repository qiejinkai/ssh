package com.qjk.ssh.util;

import java.io.Serializable;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(value="session")
public class TestScope implements Serializable{
	
	{
		System.out.println("i am TestScope request ");
	}
	
	public TestScope() {
		System.out.println("new TestScope request");
	}
}
