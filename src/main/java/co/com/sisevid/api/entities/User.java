package co.com.sisevid.api.entities;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity(name = "USUARIO")
@Data
@NoArgsConstructor
public class User {
    @Id
    @GenericGenerator(name = "SEQ_VALOR", strategy = "increment")
    @GeneratedValue(generator = "SEQ_VALOR")
    @Column(name ="ID_USUARIO")
    private long id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "ID_USUARIO_INFO_CONTACTO", referencedColumnName = "ID_USUARIO_INFO_CONTACTO")
    private UserInfoContact idUserInfo;

    @Column(name ="USUARIO")
    private String user;

    @Column(name ="CONTRASE\u00D1A")
    private String password;

    @Column(name ="USUARIO_CREACION")
    private String userCreate;

    @Column(name ="FECHA_CREACION")
    private String dateCreate;

}
