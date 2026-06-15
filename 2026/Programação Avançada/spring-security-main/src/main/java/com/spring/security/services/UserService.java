package com.spring.security.services;

import com.spring.security.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserService  implements UserDetailsService {

   @Autowired
   private UserRepository userRepository;


    /**
     * Método responsável por buscar um usuário no banco de dados
     * através do login informado.
     *
     * O Spring Security chama automaticamente esse método
     * durante o processo de autenticação.
     *
     * @param username -> login digitado pelo usuário
     * @return UserDetails -> objeto contendo os dados do usuário
     *         (login, senha e permissões)
     * @throws UsernameNotFoundException -> exceção lançada
     *         caso o usuário não seja encontrado
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return  userRepository.findByLogin(username);
    }
}
