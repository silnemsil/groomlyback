package ee.valiit.groomlyback.persistence.user;

import ee.valiit.groomlyback.NewCustomer;
import ee.valiit.groomlyback.Status;
import ee.valiit.groomlyback.controller.login.dto.LoginResponse;
import ee.valiit.groomlyback.controller.registration.dto.NewGroomer;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING, imports = {Status.class})
public interface UserMapper {

    @Mapping(source = "id", target = "userId")
    @Mapping(source = "role.name", target = "roleName")
    LoginResponse toLoginResponse(User user);


    @Mapping(source = "username",target = "username")
    @Mapping(source = "password",target = "password")
    @Mapping(expression = "java(Status.ACTIVE.getCode())",target = "status")
    User toUser(NewCustomer newCustomer);


    @Mapping(expression = "java(Status.ACTIVE.getCode())",target = "status")
    User toUser(NewGroomer newGroomer);




}