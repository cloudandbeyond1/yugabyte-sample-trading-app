package com.yugabyte.samples.tradex.api.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.yugabyte.samples.tradex.api.model.AppUser;
import com.yugabyte.samples.tradex.model.Tables;
import com.yugabyte.samples.tradex.model.tables.records.AppUserRecord;
import lombok.extern.slf4j.Slf4j;
import org.jooq.*;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class UserProfileService {

  @Autowired
  DSLContext dslContext;

  AppUserMapper mapper = new AppUserMapper();
  ObjectMapper objectMapper = new ObjectMapper();

  public AppUser fetchUserByEmail(String emailId) {
    AppUserRecord appUserRecord = dslContext.selectFrom(Tables.APP_USER)
      .where(Tables.APP_USER.EMAIL.eq(emailId)).fetchSingle();

    return mapper.map(appUserRecord);
  }

  public AppUser insertUser(AppUser appUser) throws JsonProcessingException {
    Record1<Integer> insertedId = dslContext.insertInto(Tables.APP_USER)
      .set(Tables.APP_USER.EMAIL, appUser.getEmail())
      .set(Tables.APP_USER.PREFERRED_REGION, appUser.getPreferredRegion())
      .set(Tables.APP_USER.ENABLED, appUser.isEnabled())
      .set(Tables.APP_USER.PERSONAL_DETAILS, JSON.valueOf(objectMapper.writeValueAsString(appUser.getPersonalDetails())))
      .set(Tables.APP_USER.PREFERENCES, JSON.valueOf(objectMapper.writeValueAsString(appUser.getPreferences())))
      .returningResult(Tables.APP_USER.ID)
      .fetchOne();
    log.info("Inserted Id: {}", insertedId.get(0));

    return dslContext.selectFrom(Tables.APP_USER).where(Tables.APP_USER.ID.eq((Integer)insertedId.get(0))).fetchOneInto(AppUser.class);
  }

}

class AppUserMapper implements RecordMapper<AppUserRecord, AppUser> {
  @Override
  public AppUser map(AppUserRecord appUserRecord) {
    if ( null == appUserRecord)
      return null;

    AppUser user = new AppUser();
    BeanUtils.copyProperties(appUserRecord, user);
    return user;
  }
}
