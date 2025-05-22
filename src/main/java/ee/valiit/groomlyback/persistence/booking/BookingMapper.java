package ee.valiit.groomlyback.persistence.booking;

import ee.valiit.groomlyback.controller.booking.dto.BookingDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING,
        unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface BookingMapper {

//broneeringute koostamine
 //  @Mapping(source="groomer", target = "groomerId")
 //  @Mapping(source="customerUser", target = "customerUserId")
 //  @Mapping(source="procedure", target = "procedureId")
 //  BookingDto toBookingDto (Booking booking);

}
