package com.facile.hotel.usuarios;

import com.facile.hotel.roles.Rol;
import jakarta.persistence.*;
import java.util.Set;
import java.util.HashSet;

@Entity
@Table(name = "usuarios")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;
    private String password;

    @Column(nullable = false)
    private boolean enabled = true;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
        name = "usuarios_roles",
        joinColumns = @JoinColumn(name = "usuario_id"),
        inverseJoinColumns = @JoinColumn(name = "rol_id")
    )
    private Set<Rol> roles = new HashSet<>();

    public Usuario() {}

    public Long getId() { return id; }
    public String getUsername() { return username; }
    public String getPassword() { return password; }
    public boolean isEnabled() { return enabled; }
    public Set<Rol> getRoles() { return roles; }

    public void setId(Long id) { this.id = id; }
    public void setUsername(String username) { this.username = username; }
    public void setPassword(String password) { this.password = password; }
    public void setEnabled(boolean enabled) { this.enabled = enabled; }
    public void setRoles(Set<Rol> roles) { this.roles = roles; }
}
