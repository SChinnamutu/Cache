package com.perf.blog.cache;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;

@Repository("movieDao")
public class MovieDaoImpl implements MovieDao{

	
	@CacheEvict(value="movieFindCache", allEntries=true)
	public void evictCache() {
		System.out.println("Cache is going to evict...");
	}
	
	@Cacheable(value="movieFindCache", key="#name")
	public Movie findByDirector(String name) {
		slowQuery(2000L);
		System.out.println("findByDirector is running...");
		return new Movie(1,"Thalapathi","ManiRatnam");
	}
	
	public void slowQuery(long seconds){
		try {
            Thread.sleep(seconds);
        } catch (InterruptedException e) {
            throw new IllegalStateException(e);
        }
	}

	
}