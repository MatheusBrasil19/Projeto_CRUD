package br.ulbra.entity;

public class Usuario {

    private int idNome;
    private String nome;
    private String email;
    private String fone;
    private String senha;
    private String rua;
    private String cep;
    private String bairro;
    private String cidade;
    private String estado;
    private int numero;

    public Usuario() {

    }

    public Usuario(int idNome, String nome, String email, String fone, String senha, String rua, String cep, String bairro, String cidade, String estado, int numero) {
        this.idNome = idNome;
        this.nome = nome;
        this.email = email;
        this.fone = fone;
        this.senha = senha;
        this.rua = rua;
        this.cep = cep;
        this.bairro = bairro;
        this.cidade = cidade;
        this.estado = estado;
        this.numero = numero;
    }

    @Override
    public String toString() {
        return "Usuario{" + "idNome=" + idNome + ", nome=" + nome + ", email=" + email + ", fone=" + fone + ", senha=" + senha + ", rua=" + rua + ", cep=" + cep + ", bairro=" + bairro + ", cidade=" + cidade + ", estado=" + estado + ", numero=" + numero + '}';
    }

    public int getIdNome() {
        return idNome;
    }

    public void setIdNome(int idNome) {
        this.idNome = idNome;
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

    public String getFone() {
        return fone;
    }

    public void setFone(String fone) {
        this.fone = fone;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

}
