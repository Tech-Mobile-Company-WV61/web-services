package com.fastporte.fastportewebservice.service;
import com.fastporte.fastportewebservice.dto.*;
import net.sf.jasperreports.engine.JRException;

import java.io.FileNotFoundException;

public interface ContractReportService {
    ResponseDto generateReport(ContractDto contractDto) throws JRException, FileNotFoundException;

}
