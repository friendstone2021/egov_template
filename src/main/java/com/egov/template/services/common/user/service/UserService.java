/**
 * ${projectDescription}
 * <p>
 * ${projectName}
 * ${packageName}
 * UserService.java
 *
 * @author ${author}
 * @version 1.0
 * @since ${since}
 */
package com.egov.template.services.common.user.service;

import com.egov.template.entity.common.TbCmAuthrt;
import com.egov.template.entity.common.TbCmUser;
import com.egov.template.entity.common.TbCmUserAuthrt;
import com.egov.template.entity.common.pk.PkTbCmUserAuthrt;
import com.egov.template.services.common.auth.repository.CmTbAuthRepository;
import com.egov.template.services.common.user.repository.CmTbUserAuthRepository;
import com.egov.template.services.common.user.repository.CmTbUserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

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
@Slf4j
@Service
public class UserService {

    @Autowired
    private CmTbUserRepository cmTbUserRepository;

    @Autowired
    private CmTbUserAuthRepository cmTbUserAuthRepository;

    @Autowired
    private CmTbAuthRepository cmTbAuthRepository;

    public boolean isUserIdDplct(String userId) {
        return cmTbUserRepository.findById(userId).isPresent();
    }

    @Transactional
    public void insertUser(TbCmUser tbCmUser){
        tbCmUser.setRegDt(LocalDateTime.now());
        tbCmUser.setRgtrId(tbCmUser.getUserId());
        tbCmUser.setUseYn("Y");
        cmTbUserRepository.save(tbCmUser);

        TbCmUserAuthrt tbCmUserAuthrt = new TbCmUserAuthrt();
        TbCmAuthrt tbCmAuthrt = cmTbAuthRepository.findById("GUEST").get();

        PkTbCmUserAuthrt pkTbCmUserAuthrt = new PkTbCmUserAuthrt();
        pkTbCmUserAuthrt.setUserId(tbCmUser.getUserId());
        pkTbCmUserAuthrt.setAuthrtCd(tbCmAuthrt.getAuthrtCd());

        tbCmUserAuthrt.setPkTbCmUserAuthrt(pkTbCmUserAuthrt);
        tbCmUserAuthrt.setRegDt(LocalDateTime.now());
        tbCmUserAuthrt.setRgtrId(tbCmUser.getUserId());
        tbCmUserAuthrt.setUseYn("Y");
        cmTbUserAuthRepository.save(tbCmUserAuthrt);
    }
}
