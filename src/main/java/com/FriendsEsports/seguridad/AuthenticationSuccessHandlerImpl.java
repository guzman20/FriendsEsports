package com.FriendsEsports.seguridad;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import com.FriendsEsports.entidades.Usuario;
import com.FriendsEsports.servicios.UsuarioServicio;

public class AuthenticationSuccessHandlerImpl implements AuthenticationSuccessHandler {

	@Autowired
	private UsuarioServicio usuarioServicio;
	private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {
		
		UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		HttpSession session = request.getSession();
		Usuario authUser = usuarioServicio.findByUsername(userDetails.getUsername());
		session.setAttribute("nombre", authUser.getNombre());
		session.setAttribute("idUsuario", authUser.getIdUsuario());


		boolean isRegistrado = false;
		boolean isAdmin = false;
		final Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
		for (final GrantedAuthority grantedAuthority : authorities) {
			if (grantedAuthority.getAuthority().equals("rolRegistrado")) {
				isRegistrado = true;
				break;
			} else if (grantedAuthority.getAuthority().equals("rolAdmin")) {
				isAdmin = true;
				break;
			}
		}
		String targetUrl;
		if (isRegistrado) {

			targetUrl = "/usuario/perfil";
		} else if (isAdmin) {
			targetUrl = "/index";
		} else {
			throw new IllegalStateException();
		}
		redirectStrategy.sendRedirect(request, response, targetUrl);

	}

}