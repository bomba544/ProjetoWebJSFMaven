package br.com.projeto.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "pessoa")
public class Pessoa implements Serializable{
    
    private static final long serialVersionID = 1L; 

    public Pessoa() {
    }

    public Pessoa(Integer id, String nome, String email, String telefone, String cpf, Date dtNascimento, Date dtCadastro) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
        this.cpf = cpf;
        this.dtNascimento = dtNascimento;
        this.dtCadastro = dtCadastro;
    }
    
    
    
    @Id
    @GeneratedValue
    @Column(name = "id_pessoa", nullable = false)
    private Integer id;
    @Column(name = "nome", nullable = false, length = 80)
    private String nome;
    @Column(name = "email", nullable = false, length = 80)
    private String email;
    @Column(name = "telefone", nullable = false, length = 80)
    private String telefone;
    @Column(name = "cpf", nullable = false, length = 14)
    private String cpf;
    @Temporal(TemporalType.DATE)
    @Column(name = "dt_nascimento", nullable = false)
    private Date dtNascimento;
    @Temporal(TemporalType.DATE)
    @Column(name = "dt_cadastro", nullable = false)
    private Date dtCadastro;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Date getDtNascimento() {
        return dtNascimento;
    }

    public void setDtNascimento(Date dtNascimento) {
        this.dtNascimento = dtNascimento;
    }

    public Date getDtCadastro() {
        return dtCadastro;
    }

    public void setDtCadastro(Date dtCadastro) {
        this.dtCadastro = dtCadastro;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 29 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Pessoa other = (Pessoa) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
    
    
    
    
}
