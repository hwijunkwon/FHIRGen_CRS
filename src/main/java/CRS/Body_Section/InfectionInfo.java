package CRS.Body_Section;

import CRS.Terminology;
import CRS.BaseResource;
import org.hl7.fhir.r4.model.Condition;

import java.text.ParseException;

//법정 전염성 감염병
public class InfectionInfo extends BaseResource {
    static int resourceNum = 0;
    Condition condition = new Condition();

    //발병일자, 진단일자, 감염병명, 신고일, 환자분류, 확진검사결과, 입원여부, 추정감염지역, 대상환자 id
    public InfectionInfo(String onsetDate, String diagnosisDate, String diseaseName,
                        String reportDate, String patientClassification, String testResult,
                         String hospitalization, String estimatedInfectionArea, String patientId){

        this.setMetaData(condition, Terminology.INFECTION_INFO, resourceNum);

        try {
            condition.getOnsetDateTimeType().setValue(this.simpleDateFormat.parse(onsetDate));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        try {
            condition.getAbatementDateTimeType().setValue(this.simpleDateFormat.parse(diagnosisDate));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        try {
            condition.setRecordedDate(this.simpleDateFormat.parse(reportDate));
        } catch (ParseException e) {
            e.printStackTrace();
        }

        condition.getCode().setText(diseaseName);
        condition.addCategory().setText(patientClassification);
        condition.getClinicalStatus().setText(testResult);
        condition.addNote().setText(hospitalization);
        condition.getEncounter().setDisplay(estimatedInfectionArea);
        condition.getSubject().setId(patientId);
    }


}
