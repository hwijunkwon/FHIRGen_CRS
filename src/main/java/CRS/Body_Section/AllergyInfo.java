package CRS.Body_Section;

import CRS.Terminology;
import CRS.BaseResource;
import org.hl7.fhir.r4.model.AllergyIntolerance;
import org.hl7.fhir.r4.model.Resource;

import java.text.ParseException;

//알러지 및 부작용 정보
public class AllergyInfo extends BaseResource {
    static int resourceNum = 0;
    AllergyIntolerance allergyIntolerance;
    public  String date,   allergyFactor,   allergyFactorCode, allergyName,   reaction;

    public AllergyInfo(Resource resource){
        this.allergyIntolerance = (AllergyIntolerance)resource;
        this.date = allergyIntolerance.getRecordedDate().toString();
        this.allergyFactor = allergyIntolerance.getCode().getText();
        this.allergyFactorCode = allergyIntolerance.getCode().getCoding().get(0).getCode();
        this.allergyName = allergyIntolerance.getCode().getCoding().get(0).getDisplay();
        this.reaction = allergyIntolerance.getReaction().get(0).getManifestation().get(0).getText() ;
    }

    //등록일자, 알러지요인, 알러지요인코드, 알러지명, 반응, 환자 resource id
    public AllergyInfo(String date, String allergyFactor, String allergyFactorCode,
                       String allergyName, String reaction, String patientId){
        allergyIntolerance = new AllergyIntolerance();
        this.setMetaData(allergyIntolerance, Terminology.ALLERGY_INFO, resourceNum);

        this.date = date;
        this.allergyFactor = allergyFactor;
        this.allergyFactorCode = allergyFactorCode;
        this.allergyName = allergyName;
        this.reaction = reaction;

        try {
            allergyIntolerance.setRecordedDate(this.simpleDateFormat.parse(date));
        } catch (ParseException e) {
            e.printStackTrace();
        }

        allergyIntolerance.getCode().setText(allergyName)
                .addCoding()
                .setDisplay(allergyFactor)
                .setCode(allergyFactorCode);

        allergyIntolerance.addReaction().addManifestation().setText(reaction);
        allergyIntolerance.getPatient().setId(patientId);
    }
}
