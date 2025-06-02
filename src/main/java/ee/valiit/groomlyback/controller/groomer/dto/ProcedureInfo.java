package ee.valiit.groomlyback.controller.groomer.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class ProcedureInfo {
    private Integer groomerProcedureId;
    private String procedureName;
    private BigDecimal procedurePrice;
}
