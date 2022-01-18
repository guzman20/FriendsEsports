package com.FriendsEsports.servicios;

import java.util.HashSet;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.FriendsEsports.dao.UsuarioDao;
import com.FriendsEsports.entidades.Rol;
import com.FriendsEsports.entidades.Usuario;

@Transactional
@Service
public class DetallesUsuarios implements  UserDetailsService {

	@Autowired
	private UsuarioDao usuarioDao;

	@Override
	@Transactional()
	public UserDetails loadUserByUsername(String nombre) throws UsernameNotFoundException {

		
		Usuario usuario = usuarioDao.buscarPorNombre(nombre);
		if (usuario == null) {
            throw new UsernameNotFoundException(nombre);
        }
		Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
		for (Rol rol : usuario.getRoles()) {
			grantedAuthorities.add(new SimpleGrantedAuthority(rol.getNombreRol()));
		}

		return new org.springframework.security.core.userdetails.User(usuario.getNombre(), usuario.getPassword(),
				grantedAuthorities);
	}

}