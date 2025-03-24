package com.banana.bananawhatsapp.servicios;

import com.banana.bananawhatsapp.exceptions.UsuarioException;
import com.banana.bananawhatsapp.modelos.Usuario;
import com.banana.bananawhatsapp.persistencia.IUsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.Set;

@Service
public class usuarioServiceImpl implements usuarioService{

    @Autowired
    private IUsuarioRepository repository;


    @Override
    public Usuario obtener(int id) throws UsuarioException {
        return repository.findById(id).orElse(null);
    }

    @Override
    public Usuario crearUsuario(Usuario usuario) throws UsuarioException{
        return repository.save(usuario);
    }

    @Override
    public boolean borrarUsuario(Usuario usuario) throws UsuarioException {
        if(repository.findById(usuario.getId())!= null){
            repository.delete(usuario);
            return true;
        }
        return false;
    }

    @Override
    public Usuario actualizarUsuario(Usuario usuario) throws UsuarioException {
        if(repository.findById(usuario.getId())!=null){
            return repository.save(usuario);
        }
        return null;
    }

    @Override
    public Set<Usuario> obtenerPosiblesDesinatarios(Usuario usuario, int max) throws UsuarioException {
        return Set.of();
    }
}
