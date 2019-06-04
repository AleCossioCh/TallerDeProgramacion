package com.adjcv01.adjcv01;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.sql.Date;
import java.util.Set;

@Entity
    @Table(name="Usuario")
    public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NotNull
    private String nombreUsuario;
    private String nombreCompleto;
    private Date fechaNacimiento;

    @ManyToMany
    @JoinTable(name="usuario_roles",
    joinColumns = @JoinColumn(name = "usuario_id"),
    inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    private Set<Rol> roles;

    @JoinColumn(name = "configuracion_id", unique = true)
    @OneToOne(cascade=CascadeType.ALL)
    private Configuracion configuracion;

    public Usuario() {
        configuracion = new Configuracion();
    }

    public Usuario(Long id, String nombreUsuario,
                   String nombreCompleto, Date fechaNacimiento,
                   Set<Rol> roles, Configuracion configuracion) {
        super();
        this.id = id;
        this.nombreUsuario = nombreUsuario;
        this.nombreCompleto = nombreCompleto;
        this.fechaNacimiento = fechaNacimiento;
        this.roles = roles;
        this.configuracion = configuracion;
    }

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public String getNombreUsuario() {
            return nombreUsuario;
        }

        public void setNombreUsuario(String nombreUsuario) {
            this.nombreUsuario = nombreUsuario;
        }

        public String getNombreCompleto() {
            return nombreCompleto;
        }

        public void setNombreCompleto(String nombreCompleto) {
            this.nombreCompleto = nombreCompleto;
        }

        public Date getFechaNacimiento() {
            return fechaNacimiento;
        }

        public void setFechaNacimiento(Date fechaNacimineto) {
            this.fechaNacimiento = fechaNacimineto;
        }

        public Set<Rol> getRoles() {
            return roles;
        }

        public void setRoles(Set<Rol> roles) {
            this.roles = roles;
        }

        public Configuracion getConfiguracion() {
            return configuracion;
        }

        public void setConfiguracion(Configuracion configuracion) {
            this.configuracion = configuracion;
        }

        @Override
        public int hashCode() {
            final int prime = 31;
            int result = 1;
            result = prime * result + ((id == null) ? 0 : id.hashCode());
            return result;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj)
                return true;
            if (obj == null)
                return false;
            if (getClass() != obj.getClass())
                return false;
            Usuario other = (Usuario) obj;
            if (id == null) {
                if (other.id != null)
                    return false;
            } else if (!id.equals(other.id))
                return false;
            return true;
        }

        @Override
        public String toString() {
            return "Usuario [id=" + id + ", nombreUsuario=" + nombreUsuario + ", nombreCompleto=" + nombreCompleto
                    + ", fechaNacimineto=" + fechaNacimiento + ", roles=" + roles + ", configuracion=" + configuracion
                    + "]";
        }


    }