package com.hong.extrad.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * @Author: ZhangDeHong
 * @Describe: TODO
 * @Date Create in  11:36 下午 2020/7/26
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "extra_ad")
public class ExtraAd {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    @Basic
    @Column(name = "name", nullable = false)
    private String name;

    public ExtraAd (String name) {
        this.name = name;
    }
}
