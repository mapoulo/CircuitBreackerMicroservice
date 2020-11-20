package com.example.demo.commonHyStrixCommand;

import java.util.function.Supplier;

import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;

public class MyHystrixCommad<T> extends HystrixCommand<T> {
	
	Supplier<T> execute;
	Supplier<T> fallback;
	
	
	

	public MyHystrixCommad(String group, Supplier<T> execute) {
		super(HystrixCommandGroupKey.Factory.asKey(group));
		this.execute = execute;
	}
	
	public MyHystrixCommad(Setter config, Supplier<T> execute) {
		super(config);
		this.execute = execute;
	}
	
	
	public MyHystrixCommad(String group, Supplier<T> execute, Supplier<T> fallback) {
		super(HystrixCommandGroupKey.Factory.asKey(group));
		this.execute = execute;
		this.fallback = fallback;
	}
	
	public MyHystrixCommad(Setter config, Supplier<T> execute, Supplier<T> fallback) {
		super(config);
		this.execute = execute;
		this.fallback = fallback;
	}

	@Override
	protected T run() throws Exception {
		return execute.get();
	}
	
	protected T getFallback() {
		
		if(fallback != null) {
			System.out.print("Fallback method executed");
			return fallback.get();
		}
		return super.getFallback();
	}

}
