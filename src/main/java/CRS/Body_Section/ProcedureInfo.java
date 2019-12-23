package CRS.Body_Section;

import CRS.Terminology;
import CRS.BaseResource;
import org.hl7.fhir.r4.model.Procedure;
import org.hl7.fhir.r4.model.Resource;

import java.text.ParseException;

//수술내역
public class ProcedureInfo extends BaseResource {
    static int resourceNum = 0;
    Procedure procedure;
    public String date,  procedureName,  procedureCode,  diagnosis,  anesthesia,  patientId;

    public ProcedureInfo(Resource resource){
        procedure = (Procedure)resource;
    }

    //수술일자, 수술명, 수술코드, 수술후 진단명, 마취종류, 환자 resource id, status
    public ProcedureInfo(String date, String procedureName, String procedureCode, String diagnosis,
                            String anesthesia, String patientId){
        procedure = new Procedure();
        this.setMetaData(procedure, Terminology.PROCEDURE_INFO, resourceNum);
        this.date = date;
        this.procedureName = procedureName;
        this.procedureCode = procedureCode;
        this.diagnosis = diagnosis;
        this.anesthesia = anesthesia;
        this.patientId = patientId;

        try {
            procedure.getPerformedDateTimeType().setValue(this.simpleDateFormat.parse(date));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        procedure.getCode().setText(diagnosis)
              .addCoding()
              .setDisplay(procedureName)
              .setCode(procedureCode);

      procedure.addUsedReference().setDisplay(anesthesia);
      procedure.getSubject().setId(patientId);
      procedure.setStatus(Procedure.ProcedureStatus.COMPLETED);

    }


}
