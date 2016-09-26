package br.com.art4dev.iples.impostometropessoal.controller;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

//@ApplicationPath("/")
public class ApiRestApplication //extends Application 
{
	private Set<Object> singletons = new HashSet<Object>();
	private Set<Class<?>> empty = new HashSet<Class<?>>();

	public ApiRestApplication() {
		singletons.add(new CalculoImpostosController());
	}

//	@Override
	public Set<Class<?>> getClasses() {
		return empty;
	}

//	@Override
	public Set<Object> getSingletons() {
		return singletons;
	}
}
