/**
 * ${projectDescription}
 * <p>
 * ${projectName}
 * ${packageName}
 * TbCmMenu.java
 *
 * @author ${author}
 * @version 1.0
 * @since ${since}
 */
package com.egov.template.entity.common;

import com.egov.template.entity.SystemProperty;
import lombok.*;
import org.hibernate.annotations.Comment;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * ${programDescription}
 * @author ${author}
 * @since ${since}
 * @version 1.0
 *
 * <pre>
 * == 개정이력(Modification Information)==
 * 수정일                 수정자          수정내용
 * -------      -------   ----------------------------
 * ${since}   ${author}   최초 작성
 *
 * </pre>
 */
@Entity
@Table(name = "TB_CM_MENU")
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@Setter
@Getter
@ToString
public class TbCmMenu extends SystemProperty {
    @Id
    @Column(name = "MENU_ID", unique = true)
    @Comment("메뉴아이디")
    private String menuId;

    @Column(name = "UP_MENU_ID")
    @Comment("상위메뉴아이디")
    private String upMenuId;

    @Column(name = "MENU_NM")
    @Comment("메뉴명")
    private String menuNm;

    @Column(name = "MENU_SEQ")
    @Comment("메뉴순번")
    private Integer menuSeq;

    @Column(name = "MENU_URL")
    @Comment("메뉴URL")
    private String menuUrl;

    @Column(name = "MENU_INDCT_YN", length = 1)
    @Comment("메뉴표시여부")
    private String menuIndctYn;
}
