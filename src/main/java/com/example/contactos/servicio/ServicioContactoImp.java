package com.example.contactos.servicio;

import com.example.contactos.Dao.ContactoDao;
import com.example.contactos.entidades.Contacto;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ServicioContactoImp implements ServicioContacto {
    
    @Autowired
    private ContactoDao contactoDao;

    @Override
    @Transactional(readOnly = true)
    public List<Contacto> listContactos(){
        return (List<Contacto>) contactoDao.findAll();
    };

    @Override
    @Transactional
    public void guardarCambiar(Contacto contacto){
        contactoDao.save(contacto);
    };

    @Override
    @Transactional
    public void borrar(Contacto contacto){
        contactoDao.delete(contacto);
    };

    @Override
    @Transactional(readOnly = true)
    public Contacto buscarPorId(Long idContacto){
        return contactoDao.findById(idContacto).orElse(null);
    };
}
