package com.ihrm.social.dao;

import com.ihrm.domain.social_security.model.UserSocialSecurity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.util.Map;

public interface UserSocialSecurityDao extends JpaRepository<UserSocialSecurity, String>, JpaSpecificationExecutor<UserSocialSecurity> {


    /**
     * 基于sql的分页
     *      方法返回值 : Page<user>
     *          参数 : PageAble对象
     *                  封装了分页的参数(page,size)
     *      sql语句
     *          使用@Query编写sql语句
     */
    @Query(nativeQuery = true,
            value="SELECT bu.id userId,\n" +
                    "       bu.username,\n" +
                    "       bu.mobile,\n" +
                    "       bu.work_number  workNumber,\n" +
                    "       bu.department_name departmentName,\n" +
                    "       bu.time_of_entry timeOfEntry,\n" +
                    "       bu.time_of_dimission leaveTime, \n" +
                    "       ssuss.participating_in_the_city participatingInTheCity, \n" +
                    "       ssuss.participating_in_the_city_id participatingInTheCityId,\n" +
                    "       ssuss.provident_fund_city_id providentFundCityId, \n" +
                    "       ssuss.provident_fund_city providentFundCity,\n" +
                    "       ssuss.social_security_base socialSecurityBase,\n" +
                    "       ssuss.provident_fund_base providentFundBase FROM bs_user bu LEFT JOIN ss_user_social_security ssuss ON bu.id=ssuss.user_id WHERE bu.company_id=1",
            countQuery = "SELECT COUNT(*) FROM bs_user u LEFT JOIN ss_user_social_security  s ON u.id = s.user_id WHERE company_id=?1"
    )
    public Page<Map> findPage(String companyId, Pageable pageable);

}
