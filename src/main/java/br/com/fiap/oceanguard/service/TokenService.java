package br.com.fiap.oceanguard.service;
import java.time.Instant;
import java.time.temporal.ChronoUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;

import br.com.fiap.oceanguard.model.Usuario;
import br.com.fiap.oceanguard.model.dto.Token;
import br.com.fiap.oceanguard.repository.UsuarioRepository;

@Service
public class TokenService {

    @Autowired
    UsuarioRepository repository;

    public Token generateToken(String email){
        Algorithm alg = Algorithm.HMAC512("meusecretsupersecreto");
        var jwt = JWT.create()
            .withIssuer("oceanguard")
            .withSubject(email)
            .withExpiresAt(Instant.now().plus(10, ChronoUnit.DAYS))
            .sign(alg);

        return new Token(jwt, "JWT", "Bearer");

    }

    public Usuario validateToken(String token){
        Algorithm alg = Algorithm.HMAC512("meusecretsupersecreto");
        String email = JWT.require(alg)
            .withIssuer("oceanguard")
            .build()
            .verify(token)
            .getSubject()
            ;

        return repository
            .findByEmail(email)
            .orElseThrow(() -> new JWTVerificationException("Erro na verificação do Token"));
    }
    
}
