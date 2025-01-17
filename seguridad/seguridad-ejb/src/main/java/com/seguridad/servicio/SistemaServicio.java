package com.seguridad.servicio;

import com.seguridad.dao.SecSisSistemasDAO;
import com.seguridad.dto.Sistema;
import com.seguridad.modelo.SecSisSistemas;
import java.util.List;
import java.util.stream.Collectors;
import javax.ejb.Stateless;
import javax.inject.Inject;
import org.dozer.DozerBeanMapper;

@Stateless
public class SistemaServicio {

    @Inject
    SecSisSistemasDAO sisDAO;

    public SistemaServicio() {
    }

    public List<Sistema> findAll() throws RuntimeException {
        List<SecSisSistemas> sistemas = sisDAO.findAll();
        return sistemas.stream().map(sistema -> convertDoToDto(sistema)).collect(Collectors.toList());
    }

    public void save(Sistema transientInstance) throws RuntimeException {
        sisDAO.save(convertDtoToDo(transientInstance));
    }

    public Object merge(Sistema detachedInstance) throws RuntimeException {
        return sisDAO.merge(convertDtoToDo(detachedInstance));
    }

    public void remove(Sistema persistentInstance) throws RuntimeException {
        sisDAO.remove(convertDtoToDo(persistentInstance));
    }
    
    public SecSisSistemas findById(int sistemaId){
        return sisDAO.findById(sistemaId);
    }

    private Sistema convertDoToDto(SecSisSistemas sistema) {
        return (new DozerBeanMapper()).map(sistema, Sistema.class);
    }

    private SecSisSistemas convertDtoToDo(Sistema sistema) {
        return (new DozerBeanMapper()).map(sistema, SecSisSistemas.class);
    }

}
