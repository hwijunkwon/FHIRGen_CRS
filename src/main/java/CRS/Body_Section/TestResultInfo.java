package CRS.Body_Section;

import CRS.BaseResource;
import org.hl7.fhir.r4.model.Observation;
import org.hl7.fhir.r4.model.Resource;

import java.text.ParseException;

//검사결과정보
public class TestResultInfo extends BaseResource {
    static int resourceNum = 0;
    Observation observation ;
    public String date, testname,  testCode,  testTitle, testResult, referenceRange;

    public TestResultInfo(Resource resource){
        observation = (Observation)resource;
    }

    //검사일시, 검사항목명, 검사항목코드, 검사명, 검사결과값, 참고치
   public TestResultInfo(String kindOfTest, String date, String testName, String testCode,
                         String testTitle, String testResult, String referenceRange){
       observation = new Observation();
        this.setMetaData(observation, kindOfTest, resourceNum);
        this.date = date;
        this.testname = testName;
        this.testCode = testCode;
        this.testTitle = testTitle;
        this.testResult = testResult;
        this.referenceRange = referenceRange;

       try {
           observation.getEffectiveDateTimeType().setValue(this.simpleDateFormat.parse(date));
       } catch (ParseException e) {
           e.printStackTrace();
       }
       observation.getCode().setText(testTitle)
                .addCoding()
                .setDisplay(testName)
                .setCode(testCode);
        observation.getValueStringType().setValue(testResult);
        observation.addReferenceRange().setText(referenceRange);

        observation.setStatus(Observation.ObservationStatus.FINAL);
    }

}
