package com.frknuzn.basitstok.Entity;

import lombok.*;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "product_name",length = 200)
    private String productName;

    @Column(name = "quantities")
    private int quantities;

    private float price;

    @JoinColumn(name = "user_id")
    @ManyToOne(optional = true,fetch = FetchType.LAZY)
    /* Birçok product bir tane user a bağlanabilir
       ve bu bağlandığında oluşacak join kolonunun ismi user_id
       "optional" ise bir product nesnesi oluşturulurken onun assignee(user)'ını vermesende olur
       demek istedik. Kısacası optional ilişkinin zorunlu olup olmadığını sorar
    */
    private User user;
}
