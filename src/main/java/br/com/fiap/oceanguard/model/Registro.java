package br.com.fiap.oceanguard.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "TB_REGISTRO")
public class Registro {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_REGISTRO")
    private Long id;
    
    @NotBlank(message = "O campo ocorrencia não pode setar em branco")
    @Column(name = "OCORRENCIA")
    private String ocorrencia;

    @NotBlank(message = "O campo localidade não pode setar em branco")
    @Column(name = "LOCADLIDADE")
    private String localidade;

    @NotBlank(message = "O campo desc registro não pode setar em branco")
    @Column(name = "DESC_REGISTRO")
    private String DescRegistro;

    @OneToOne
    @JoinColumn(name = "ID_USUARIO")
    private Usuario usuario;
}
