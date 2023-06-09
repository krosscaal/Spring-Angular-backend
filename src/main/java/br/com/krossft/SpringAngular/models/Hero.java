package br.com.krossft.SpringAngular.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "heroes")
public class Hero implements Serializable {

    private static final long serialVersionUID = 1l;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @Column
    @NotBlank(message = "Nome não pode ser branco")
    @Length(min = 3, max = 45, message = "Nome deveŕa ter mínimo {min} e máximo {max} caracteres")
    private String name;

//    @Column
//    @Getter
//    @Setter
//    @NotBlank(message = "PODER não poder ser branco")
//    @Length(min = 5, max = 60, message = "Poder deveŕa ter mínimo {min} e máximo {max} caracteres")
//    private String power;

    @ManyToOne(fetch = FetchType.EAGER)
    private Power power;

    @Column
    @NotBlank(message = "email em formato incorreto")
    @Email
    private String email;

//    public Hero() {
//    }

    public Hero(String name, Power power,  String email) {
        this.name = name;
        this.power = power;
        this.email = email;
    }

}
