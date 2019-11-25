package CRS.Body_Section;

import CRS.BaseResource;
import org.hl7.fhir.r4.model.Observation;

import java.text.ParseException;

//검사결과정보
public class TestResultInfo extends BaseResource {
    static int resourceNum = 0;
    Observation observation = new Observation();

    //검사일시, 검사항목명, 검사항목코드, 검사명, 검사결과값, 참고치
   public TestResultInfo(String kindOfTest, String date, String testList, String testCode,
                         String detailTestName, String testResult, String referenceRange){

        this.setMetaData(observation, kindOfTest, resourceNum);

       try {
           observation.getEffectiveDateTimeType().setValue(this.simpleDateFormat.parse(date));
       } catch (ParseException e) {
           e.printStackTrace();
       }
       observation.getCode().setText(detailTestName)
                .addCoding()
                .setDisplay(testList)
                .setCode(testCode);
        observation.getValueStringType().setValue(testResult);
        observation.addReferenceRange().setText(referenceRange);

        observation.setStatus(Observation.ObservationStatus.FINAL);
    }

}
