package javaapplication1.domain;

import java.util.Objects;

public class Cliente {
    private String nome;
    private Long cpf;
    private String tel;
    private String end;
    private String numero;
    private String cidade;
    private String estado;

    public Cliente(String nome, String cpf, String tel, String end, String numero, String cidade, String estado) {
        setNome(nome);
        setCpf(parseCpf(cpf));
        setTel(tel);
        setEnd(end);
        setNumero(numero);
        setCidade(cidade);
        setEstado(estado);
    }

    private Long parseCpf(String cpf) {
        if (cpf == null || cpf.trim().isEmpty()) {
            throw new IllegalArgumentException("CPF não pode ser vazio");
        }
        
        String cpfNumerico = cpf.replaceAll("[^0-9]", "");
        
        if (cpfNumerico.length() != 11) {
            throw new IllegalArgumentException("CPF deve conter exatamente 11 dígitos");
        }
        
        try {
            return Long.parseLong(cpfNumerico);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("CPF deve conter apenas números");
        }
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        if (nome == null || nome.trim().isEmpty()) {
            throw new IllegalArgumentException("Nome não pode ser nulo ou vazio");
        }
        this.nome = nome.trim();
    }

    public Long getCpf() {
        return cpf;
    }

    private void setCpf(Long cpf) {
        this.cpf = Objects.requireNonNull(cpf, "CPF não pode ser nulo");
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel != null ? tel.trim() : null;
    }

    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        this.end = end != null ? end.trim() : null;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero != null ? numero.trim() : null;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade != null ? cidade.trim() : null;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado != null ? estado.trim() : null;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(this.cpf);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Cliente other = (Cliente) obj;
        return Objects.equals(this.cpf, other.cpf);
    }

    @Override
    public String toString() {
        return "Cliente{" + 
               "nome='" + nome + '\'' + 
               ", cpf=" + cpf + 
               '}';
    }
}