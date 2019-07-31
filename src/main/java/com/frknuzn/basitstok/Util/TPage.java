package com.frknuzn.basitstok.Util;


import lombok.Data;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;

import java.util.List;

/*
    Bu sayfayı yapmamızın amacı;
    Front end kısmında bir data table üzerinde kayıtlar gösterilecek
    ve orada server taraflı pagination yapılacak yani kaç kayıt isteniyorsa o kadar kayıt
    veritabanından getirilecek
 */

@Data

public class TPage<T> {

    //Front end kısmında Şu an kaçıncı sayfa görüntüleniyor
    private int number;
    //Front end kısmında Kayıtları kaçarlı göstereceğini belirleyecek
    private int size;
    //Front end kısmında herhangi bir kolona tıklayıp o kolonu sıralamayı ayarlayacak
    private Sort sort;
    //Toplamda kaç sayfa var onu Front end kısmına göndereceğiz
    private int totalPages;
    //Toplamda Kaç kayıt var onu Front end kısmında göstereceğiz
    private Long totalElements;
    // Front end kısmına göndereceğimiz datayı göstereceğiz
    private List<T> content;


    public void setStat(Page page, List<T> list){
        this.number=page.getNumber();
        this.size=page.getSize();
        this.sort=page.getSort();
        this.totalPages=page.getTotalPages();
        this.totalElements=page.getTotalElements();
        this.content=list;
    }

}
