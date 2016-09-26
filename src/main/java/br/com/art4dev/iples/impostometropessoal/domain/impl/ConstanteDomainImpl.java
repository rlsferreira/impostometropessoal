package br.com.art4dev.iples.impostometropessoal.domain.impl;

import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.art4dev.iples.impostometropessoal.domain.ConstanteDomain;
import br.com.art4dev.iples.impostometropessoal.model.Constante;
import br.com.art4dev.iples.impostometropessoal.repository.ConstanteRepository;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;

@Service
public class ConstanteDomainImpl implements ConstanteDomain {
	
	@Autowired
	private ConstanteRepository	            constanteRepository;
	
	private LoadingCache<String, Constante>	constantsCache;
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * br.com.art4dev.tests.xxtestes.domain.impl.ConstantsDomain#startConstantsCache
	 * ()
	 */
	@PostConstruct
	private void startConstantsCache() {
		
		constantsCache = CacheBuilder.newBuilder().maximumSize(1000).expireAfterAccess(30, TimeUnit.MINUTES)
		        .build(new CacheLoader<String, Constante>() {
			        
			        @Override
			        public Constante load(String name) throws Exception {
				        return getFromDatabase(name);
			        }
		        });
		
	}
	
	private Constante getFromDatabase(String name) {
		return constanteRepository.findByNome(name);
	}
	
	@Override
	public Constante getConstante(String name) {
		return constantsCache.getUnchecked(name);
	}
	
	@Override
	public List<Constante> findAll() {
		return constanteRepository.findAll();
	}
	
	@Override
	public Constante save(Constante constante) {
		return constanteRepository.save(constante);
	}
	
}
