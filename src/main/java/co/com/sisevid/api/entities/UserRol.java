package co.com.sisevid.api.entities;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity(name = "usuario_roles_intermedia")
@Data
@NoArgsConstructor
public class UserRol {
    @Id
    @GenericGenerator(name = "SEQ_VALOR", strategy = "increment")
    @GeneratedValue(generator = "SEQ_VALOR")
    @Column(name = "ID")
    private long id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "ID_USUARIO", referencedColumnName = "ID_USUARIO")
    private User user;

    @ManyToOne(optional = false)
    @JoinColumn(name = "ID_USUARIO_ROLES", referencedColumnName = "ID_USUARIO_ROLES")
    private Rol rol;
}
