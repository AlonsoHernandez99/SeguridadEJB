package com.seguridad.servicio;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;

import org.dozer.DozerBeanMapper;

@Startup
@Singleton
public class DozerMapper {

	DozerBeanMapper mapper;

	@PostConstruct
	public void init() {
		List<String> mappingFiles = new ArrayList<>();
		mappingFiles.add("com/seguridad/dto/dozerMapping.xml");
		mapper = new DozerBeanMapper();
		mapper.setMappingFiles(mappingFiles);
	}

	public <T extends Object> T map(Object source, Class<T> destinationClass) {
		return mapper.map(source, destinationClass);
	}

	public <T extends Object> List<T> mapList(List<?> source, Class<T> destinationClass) {
		List<T> result = new ArrayList<>();

		for (Object obj : source) {
			result.add(map(obj, destinationClass));
		}

		return result;
	}

}