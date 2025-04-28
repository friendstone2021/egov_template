/**
 * ${projectDescription}
 * <p>
 * ${projectName}
 * ${packageName}
 * TbCmUser.java
 *
 * @author ${author}
 * @version 1.0
 * @since ${since}
 */
package com.egov.template.entity.common;

import com.egov.template.entity.SystemProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Comment;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Pattern;
import java.util.Date;

/**
 * ${programDescription}
 *
 * @author ${author}
 * @version 1.0
 *
 * <pre>
 * == 개정이력(Modification Information)==
 * 수정일                 수정자          수정내용
 * -------      -------   ----------------------------
 * ${since}   ${author}   최초 작성
 *
 * </pre>
 * @since ${since}
 */
@Entity
@Table(name = "tb_cm_user")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TbCmUser extends SystemProperty {

    @Id
    @Column(name = "USER_ID")
    @Comment("사용자아이디")
    private String userId;

    @Column(name = "INST_CD")
    @Comment("기관코드")
    private String instCd;

    @Column(name = "DEPT_CD")
    @Comment("부서코드")
    private String deptCd;

    @Column(name = "ENPSWD")
    @Comment("암호화비밀번호")
    private String enpswd;

    @Column(name = "USER_NM")
    @Comment("사용자명")
    private String userNm;

    @Column(name = "MBL_TELNO")
    @Comment("사용자전화번호")
    private String mblTelno;

    @Column(name = "EML_ADDR")
    @Pattern(regexp = "^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$")
    @Comment("이메일주소")
    private String emlAddr;

    @Column(name = "LGN_FAIL_NMTM")
    @Comment("로그인실패횟수")
    private Integer lgnFailNmtm;

    @Column(name = "LAST_CNTN_DT")
    @Comment("최종접속일시")
    private Date lastCntnDt;

    @Column(name = "DEL_YN", length = 1)
    @Comment("삭제여부")
    private String delYn;

    @Column(name = "PSWD_CHG_DT")
    @Comment("비밀번호변경일시")
    private Date pswdChgDt;

}
