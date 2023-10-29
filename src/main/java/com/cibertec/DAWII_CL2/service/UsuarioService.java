package com.cibertec.DAWII_CL2.service;

import lombok.AllArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import com.cibertec.DAWII_CL2.model.Rol;
import com.cibertec.DAWII_CL2.model.Usuario;
import com.cibertec.DAWII_CL2.repository.RolRepository;
import com.cibertec.DAWII_CL2.repository.UsuarioRepository;

import java.util.Arrays;
import java.util.HashSet;

@Service
@AllArgsConstructor
public class UsuarioService {

    private UsuarioRepository usuarioRepository;
    private RolRepository rolRepository;

    private BCryptPasswordEncoder bCryptPasswordEncoder=
            new BCryptPasswordEncoder();

    public Usuario findUserByEmail(String email){
        return usuarioRepository.findByEmail(email);
    }

    public Usuario findUserByUserName(String username){
        return usuarioRepository.findByNomusuario(username);
    }

    public Usuario saveUser(Usuario usuario){
        usuario.setPassword(bCryptPasswordEncoder.encode(
                usuario.getPassword()));
        usuario.setActivo(true);
        Rol usuarioRol = rolRepository.findByNomrol("ADMIN");
        usuario.setRoles(new HashSet<>(Arrays.asList(usuarioRol)));
        return usuarioRepository.save(usuario);
    }
}
