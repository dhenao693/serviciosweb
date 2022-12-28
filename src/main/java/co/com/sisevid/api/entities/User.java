package co.com.sisevid.api.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "USUARIO")
public class User {
    @Id
    @GenericGenerator(name = "SEQ_VALOR", strategy = "increment")
    @GeneratedValue(generator = "SEQ_VALOR")
    @Column(name = "ID_USUARIO")
    private long id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "ID_USUARIO_INFO_CONTACTO", referencedColumnName = "ID_USUARIO_INFO_CONTACTO")
    private UserInfoContact idUserInfo;

    @Column(name = "USUARIO")
    private String user;

    @Column(name = "CONTRASE\u00D1A")
    private String password;

    @Column(name = "USUARIO_CREACION")
    private String userCreate;

    @Column(name = "FECHA_CREACION")
    private String dateCreate;

}
