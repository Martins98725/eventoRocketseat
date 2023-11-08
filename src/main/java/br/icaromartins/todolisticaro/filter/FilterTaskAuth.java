/*
package br.icaromartins.todolisticaro.filter;

import at.favre.lib.crypto.bcrypt.BCrypt;
import br.icaromartins.todolisticaro.user.IUserRepository;
import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.Base64;

*/
/* toda requisição passa pelo filter primeiro.
* *//*

@Component
public class FilterTaskAuth extends OncePerRequestFilter {

    @Autowired
    private IUserRepository repository;
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        var servletPath = request.getServletPath();
        if (servletPath.startsWith("/tasks/")){
            var auth = request.getHeader("Authorization");
            //processo de decode

            var authEncoded =  auth.substring("Basic".length()).trim();

            byte[] authDecode =  Base64.getDecoder().decode(authEncoded);

            var authString =   new String(authDecode);

            String[] credentials = authString.split(":");
            String userName = credentials[0];
            String passoword = credentials[1];

            System.out.println("Authorization: " + userName );
            System.out.println(passoword);

            //validar user
            var user = this.repository.findByUserName(userName);
            if (user == null){
                response.sendError(401);
            }else {
                //validar senha
                var passowordVerify = BCrypt.verifyer().verify(passoword.toCharArray(), user.getPassword());
                if (passowordVerify.verified){
                    request.setAttribute("idUser", user.getId());
                    filterChain.doFilter(request, response);

                } else {
                    response.sendError(401);
                }
            }
        } else {
                filterChain.doFilter(request, response);
        }
    }
}
*/