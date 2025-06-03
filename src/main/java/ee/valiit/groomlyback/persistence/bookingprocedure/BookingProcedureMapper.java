package ee.valiit.groomlyback.persistence.bookingprocedure;

import ee.valiit.groomlyback.controller.booking.dto.BookingProcedureDto;
import org.mapstruct.*;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface BookingProcedureMapper {


    @Mapping(source = "id", target = "bookingProcedureId")
    @Mapping(source = "procedure.name", target = "procedureName")
    @Mapping(source = "procedure.description", target = "procedureDescription")
    @Mapping(source = "price", target = "price")
    BookingProcedureDto toBookingProcedureDto(BookingProcedure bookingProcedure);



   List<BookingProcedureDto> toBookingProcedureDtos(List <BookingProcedure> bookingProcedures);



}