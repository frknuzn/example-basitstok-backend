package com.frknuzn.basitstok.Entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
//bu tabloya bir tane index eklemiş olduk
// Index eklememiz de ki amaç bu alana sürekli sorgu yapacağımız için bu alana göre sıratabilmek ve performanstan kazanabilmek
@Table(name = "users",indexes = {@Index(name = "idx_username",columnList = "uname")})
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class User extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "uname",length = 100,unique = true)
    // aynı user name ile birden fazla kullanıcı unique sayesinde kayıt olamaz
    private String userName;

    @Column(name = "pwd",length = 200)
    private String password;

    @Column(name = "name_surname",length = 200)
    private String nameSurname;

    @Column(name = "email",length = 100)
    private String email;

    @JoinColumn(name = "user_id")
    @OneToMany(fetch = FetchType.LAZY)
    /*
    *   Bir tane kullanıcının birden çok product u olabilir
    */
    private List<Product>products;
}
