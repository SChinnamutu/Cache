package com.perf.blog.cache;


public interface MovieDao{
	
	
	Movie findByDirector(String name);
	void evictCache(); 
	
}