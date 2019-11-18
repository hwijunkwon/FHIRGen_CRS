package CRS.Body_Section;

import CRS.Terminology;
import CRS.BaseResource;
import org.hl7.fhir.r4.model.Condition;

import java.text.ParseException;

//진단내역
public class DiagnosisInfo extends BaseResource {
    static int resourceNum = 0;
    Condition condition = new Condition();

    //진단일자, 상병명, 상병코드, 대상환자 resource id
    public DiagnosisInfo(String diagnosisDate, String diseaseName, String diseaseCode, String patientId){
        try {
            condition.setRecordedDate(this.simpleDateFormat.parse(diagnosisDate));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        condition.getCode().addCoding()
                .setDisplay(diseaseName)
                .setCode(diseaseCode);
        condition.getSubject().setId(patientId);
        this.setMetaData(condition, Terminology.DIAGNOSIS_INFO, resourceNum);
    }


}
