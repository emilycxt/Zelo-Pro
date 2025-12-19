package com.dev.emilycxt.model;

public class Usuario {

	private Long id;
	private String nome;
	private String senhaHash;
	private Role role; // permissão: ADMIN, USER

	public Usuario() {

	}

    public boolean isAdmin() {
        return Role.ADMIN.equals(role);
    }

    public boolean isUser() {
        return Role.USER.equals(role);
    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSenhaHash() {
		return senhaHash;
	}

	public void setSenhaHash(String senhaHash) {
		this.senhaHash = senhaHash;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

}
