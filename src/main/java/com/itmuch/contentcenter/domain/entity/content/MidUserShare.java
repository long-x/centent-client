package com.itmuch.contentcenter.domain.entity.content;

import javax.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Table(name = "mid_user_share")
public class MidUserShare {
    /**
     * id
     */
    @Id
    @GeneratedValue(generator = "JDBC")
    private Integer id;

    /**
     * user.id
     */
    @Column(name = "user_id")
    private Integer userId;

    /**
     * share.id
     */
    @Column(name = "share_id")
    private Integer shareId;
}