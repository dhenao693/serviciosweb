package co.com.sisevid.api.entities;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity(name = "USUARIO_INFO_CONTACTO")
@Data
@NoArgsConstructor
public class UserInfoContact {
    @Id
    @GenericGenerator(name = "SEQ_VALOR", strategy = "increment")
    @GeneratedValue(generator = "SEQ_VALOR")
    @Column(name = "ID_USUARIO_INFO_CONTACTO")
    private long id;

    @Column(name = "TIPO_DOCUMENTO")
    private String documentType;

    @Column(name = "NUMERO_DOCUMENTO")
    private String documentNumber;

    @Column(name = "NOMBRES")
    private String name;

    @Column(name = "APELLIDOS")
    private String lastName;

    @Column(name = "NUMERO_CONTACTO")
    private String phone;

    @Column(name = "EMAIL")
    private String email;

    @Column(name = "USUARIO_CREACION")
    private String userCreate;

    @Column(name = "FECHA_CREACION")
    private String dateCreate;
}
