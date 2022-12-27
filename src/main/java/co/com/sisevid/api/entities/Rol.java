package co.com.sisevid.api.entities;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity(name = "USUARIO_ROLES")
@Data
@NoArgsConstructor
public class Rol {
    @Id
    @GenericGenerator(name = "SEQ_VALOR", strategy = "increment")
    @GeneratedValue(generator = "SEQ_VALOR")
    @Column(name = "ID_USUARIO_ROLES")
    private long id;

    @Column(name = "DESCRIPCION")
    private String description;

    @Column(name = "USUARIO_CREACION")
    private String createUser;

    @Column(name = "FECHA_CREACION")
    private String createDate;
}
